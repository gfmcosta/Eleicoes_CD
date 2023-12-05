/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eleicoes.wallet;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author costa
 */
public class teste {
   
    public static int MAX_NONCE = (int) 1E9;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Nonce: " + NoncePAR("Costa", 3));
    }

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