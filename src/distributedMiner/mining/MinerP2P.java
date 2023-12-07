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
package distributedMiner.mining;

import distributedMiner.MiningListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 28/09/2022, 11:13:39
 *
 * @author IPT - computer
 * @version 1.0
 */

public class MinerP2P {

    //dados de minagem
    String data;
    //ticket para com números para testar
    AtomicInteger ticket;
    //noce que mina a mensagem
    AtomicInteger nonce;
    //listener do mineiro
    MiningListener listener;
    //array de thread para minar em paralelo
    MinerTHR[] workers; // Array de threads

    public MinerP2P(MiningListener listener) {
        this.ticket = new AtomicInteger(0);
        this.nonce = new AtomicInteger(0);
        this.workers = null;
        this.listener = listener;
    }

    public void startMining(String data, int dificulty) {
        int numThreads = Runtime.getRuntime().availableProcessors();
        Random rnd = new Random();
        //parar o mineiro se ainda estiver a minar
        stopMining(999);
        //criar novos objetos partilhados
        //começar num numero aleatório
        ticket = new AtomicInteger(Math.abs(rnd.nextInt() + 1));
        nonce = new AtomicInteger(0);
        //Criar o array de threads e colocar a correr
        workers = new MinerTHR[numThreads];
        for (int i = 0; i < numThreads; i++) {
            workers[i] = new MinerTHR(ticket, nonce, dificulty, data, listener);
            workers[i].start();
        }
    }

    public void stopMining(int number) {
        if (workers != null) {
            for (MinerTHR worker : workers) {
                worker.stop(number);
            }
        }
    }

    public int getTicket() {
        return ticket.get();
    }

    public String getData() {
        return data;
    }

    public boolean isMining() {
        return workers != null && nonce.get() == 0;
    }

    public int getNonce() {
        return nonce.get();
    }

    /**
     * Espera que as threads executem terminem o trabalho e devolve o nonce
     *
     * @return
     * @throws Exception
     */
    public int waitToNonce() throws Exception {
        if (workers != null) {
            for (MinerTHR worker : workers) {
                worker.join();
            }
            return nonce.get();
        } else {
            throw new Exception("Not mining");
        }
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    //:::::::::      THREAD         :::::::::::::::::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
    private class MinerTHR extends Thread {

        AtomicInteger myTicket;
        AtomicInteger myNonce;
        int dificulty;
        String myData;
        MiningListener listener;

        public MinerTHR(AtomicInteger ticket, AtomicInteger nonce, int dificulty, String data, MiningListener listener) {
            this.myTicket = ticket;
            this.myNonce = nonce;
            this.dificulty = dificulty;
            this.myData = data;
            this.listener = listener;
        }

        public void stop(int number) {
            myNonce.set(number);
            interrupt();
        }

        public void run() {
            //String of zeros
            String zeros = String.format("%0" + dificulty + "d", 0);
            int number;
            while (myNonce.get() == 0) {
                //calculate hash of block
                number = myTicket.getAndIncrement();
                //:::::::::::::  L I S T E N E R  ::::::::::::::::::::::::::::::
                if (System.currentTimeMillis() % 100 == 0) {
                    listener.onMining(number);
                }
                String hash = getHash(number + myData);
                //Nounce found
                if (hash.startsWith(zeros)) {
                    //:::::::::::::  L I S T E N E R  ::::::::::::::::::::::::::::::
                    listener.onNounceFound(number);
                    myNonce.set(number);
                }
            }
            //:::::::::::::  L I S T E N E R  ::::::::::::::::::::::::::::::
            listener.onStopMining(myNonce.get());
        }
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    //:::::::::      I N T E G R I T Y         :::::::::::::::::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
    public static String getHash(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            return Base64.getEncoder().encodeToString(md.digest());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MinerP2P.class.getName()).log(Level.SEVERE, null, ex);
            return data;
        }
    }
}
