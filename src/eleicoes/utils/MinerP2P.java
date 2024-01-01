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

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Gonçalo Filipe Martins da Costa                                     ::
//::     e-mail: aluno23692@ipt.pt                                           ::
//::                                                                         ::
//::     João Miguel Rodrigues Ribeiro Gonçalves                             ::
//::     e-mail: aluno23882@ipt.pt                                           ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::                                                                         ::
//::                                                                         ::
//::     This software was edited with the purpose of investigate and        ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2024   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package eleicoes.utils;

import eleicoes.remote.MiningListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável pela implementação do Miner P2P.
 * 
 * @author Gonçalo Costa
 * @author João Gonçalves
 */
public class MinerP2P {

    // Dados de mineração
    String data;
    // Ticket com números para testar
    AtomicInteger ticket;
    // Número que mina a mensagem (nonce)
    AtomicInteger nonce;
    // Listener do mineiro para notificar eventos de mineração
    MiningListener listener;
    // Array de threads para minerar em paralelo
    MinerTHR[] workers;

    /**
     * Construtor da classe MinerP2P.
     * 
     * @param listener Objeto para ouvir eventos de mineração.
     */
    public MinerP2P(MiningListener listener) {
        this.ticket = new AtomicInteger(0);
        this.nonce = new AtomicInteger(0);
        this.workers = null;
        this.listener = listener;
    }

    /**
     * Inicia o processo de mineração.
     * 
     * @param data Dados a serem minerados.
     * @param difficulty Dificuldade desejada para a mineração.
     */
    public void startMining(String data, int difficulty) {
        // Número de cores do processador
        int numThreads = Runtime.getRuntime().availableProcessors();
        Random rnd = new Random();
        // Para o mineiro se ainda estiver a minerar
        stopMining(999);
        // Cria novos objetos partilhados (AtomicInteger(+)
        // Começa com um número aleatório
        ticket = new AtomicInteger(Math.abs(rnd.nextInt() + 1));
        nonce = new AtomicInteger(0);
        // Cria o array de threads e dá ordem de começar
        workers = new MinerTHR[numThreads];
        for (int i = 0; i < numThreads; i++) {
            workers[i] = new MinerTHR(ticket, nonce, difficulty, data, listener);
            workers[i].start();
        }
    }
    

     /**
     * Para o processo de mineração.
     * 
     * @param number Número para parar o processo de mineração.
     */
    public void stopMining(int number) {
        if (workers != null) {
            for (MinerTHR worker : workers) {
                worker.stop(number);
            }
        }
    }

    /**
     * Obtém o valor do ticket atual.
     * 
     * @return Valor do ticket.
     */
    public int getTicket() {
        return ticket.get();
    }

    /**
     * Obtém os dados a serem minerados.
     * 
     * @return Dados a serem minerados.
     */
    public String getData() {
        return data;
    }
    
    /**
     * Verifica se o mineiro está em execução.
     * 
     * @return True se estiver a minerar, false caso contrário.
     */
    public boolean isMining() {
        return workers != null && nonce.get() == 0;
    }

    /**
     * Obtém o valor atual do nonce.
     * 
     * @return Valor do nonce.
     */
    public int getNonce() {
        return nonce.get();
    }

    /**
     * Aguarda até que as threads terminem o trabalho e retorna o nonce encontrado.
     * 
     * @return Valor do nonce encontrado.
     * @throws Exception Exceção lançada se não estiver a minerar.
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

    
    /**
     * Classe interna para representar cada thread de mineração.
     */
    private class MinerTHR extends Thread {

        AtomicInteger myTicket;
        AtomicInteger myNonce;
        int difficulty;
        String myData;
        MiningListener listener;

        /**
         * Construtor da classe interna MinerTHR.
         * 
         * @param ticket Ticket partilhado.
         * @param nonce Nonce partilhado.
         * @param difficulty Dificuldade desejada para a mineração.
         * @param data Dados a serem minerados.
         * @param listener Objeto para ouvir eventos de mineração.
         */
        public MinerTHR(AtomicInteger ticket, AtomicInteger nonce, int difficulty, String data, MiningListener listener) {
            this.myTicket = ticket;
            this.myNonce = nonce;
            this.difficulty = difficulty;
            this.myData = data;
            this.listener = listener;
        }

        /**
         * Método para parar a thread de mineração.
         * 
         * @param number Número para parar o processo de mineração.
         */
        public void stop(int number) {
            myNonce.set(number);
            interrupt();
        }

        /**
         * Método principal que executa a lógica de mineração na thread.
         */
        public void run() {
            // String com zeros à esquerda, com base na dificuldade
            String leadingZeros = String.format("%0" + difficulty + "d", 0);
            int number;
            // Enquanto o nonce não foi encontrado
            while (myNonce.get() == 0) {
                // Calcula o hash do bloco usando o ticket atual
                number = myTicket.getAndIncrement();
                // Notifica o ouvinte a cada 100 milissegundos durante a mineração
                if (System.currentTimeMillis() % 100 == 0) {
                    listener.onMining(number);
                }
                // Obtém o hash da concatenação do número e dos dados
                String hash = getHash(number + myData);
                // Verifica se o nonce atende à dificuldade desejada
                if (hash.startsWith(leadingZeros)) {
                    // Notifica o ouvinte sobre a descoberta do nonce
                    listener.onNounceFound(number);
                    // Define o nonce encontrado
                    myNonce.set(number);
                }
            }
            // Notifica o ouvinte que parou a mineração
            listener.onStopMining(myNonce.get());
        }
    }

    /**
     * Método estático para calcular o hash SHA-256 de uma string.
     * 
     * @param data Dados a serem hashed.
     * @return String que representa o hash.
     */
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
