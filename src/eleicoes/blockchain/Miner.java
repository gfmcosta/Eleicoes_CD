//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2022   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package eleicoes.blockchain;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 28/09/2022, 11:13:39
 *
 * @author IPT - computer
 * @version 1.0
 */
public class Miner {
    public static int MAX_NONCE = (int) 1E9;

    static class NonceThread extends Thread {
        private final int threadIndex;
        private final String data;
        private final int difficulty;
        private final AtomicInteger foundNonce;
        private final int cores;

        NonceThread(int threadIndex, String data, int difficulty, AtomicInteger foundNonce, int cores) {
            this.threadIndex = threadIndex;
            this.data = data;
            this.difficulty = difficulty;
            this.foundNonce = foundNonce;
            this.cores = cores;
        }

        @Override
        public void run() {
            String zeros = String.format("%0" + difficulty + "d", 0);
            int nonce=threadIndex;
            while (nonce < MAX_NONCE) {
                if (foundNonce.get() != -1) {
                    // Another thread already found the nonce, exit
                    return;
                }
                String hash = getHash(nonce + data);
                System.out.println("Thread " + threadIndex + " found nonce: " + nonce);
                if (hash.startsWith(zeros)) {
                    foundNonce.set(nonce);
                    System.out.println(hash);
                    return;
                }
                nonce+=cores;
            }
        }
    }

    public static int NoncePAR(String data, int difficulty) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        AtomicInteger foundNonce = new AtomicInteger(-1);
        NonceThread[] threads = new NonceThread[cores];

        for (int i = 0; i < cores; i++) {
            threads[i] = new NonceThread(i, data, difficulty, foundNonce,cores);
            threads[i].start();
        }

        for (NonceThread thread : threads) {
            thread.join();
        }

        return foundNonce.get();
    }

    public static String getHash(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("sha3-256");
            md.update(data.getBytes());
            byte[] hash = md.digest();
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception ex) {
            return "HASH CALCULATOR ERROR";
        }
    }
}
