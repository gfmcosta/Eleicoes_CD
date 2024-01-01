/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eleicoes.remote;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import eleicoes.utils.RMI;

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

/**
 *
 * @author Gonçalo Costa
 * @author João Gonçalves
 */
public class AutomaticP2P {

    public static void sendAddress(String remoteAdress, int interval) {
        new Thread(
                () -> {
                    try {
                        InetAddress adress = InetAddress.getByName("230.0.0.1"); // Escolher um diferente
                        int port = 4446;
                        //mensagem a enviar
                        //abrir um socket na máquina actual 
                        DatagramSocket socket = new DatagramSocket();
                        //construção do pacote
                        DatagramPacket packet = new DatagramPacket(
                                remoteAdress.getBytes(), remoteAdress.length(), adress, port);
                        //enviar o pacote para a rede
                        while (true) {
                            socket.send(packet);
                            System.out.println("Send "+ remoteAdress);
                            Thread.currentThread().sleep(interval);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(AutomaticP2P.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }).start();
    }

    public static void listenToNodes(RemoteObject remote) {
        new Thread(
                () -> {
            try {
                int port = 4446;
                //Listen port 4446
                MulticastSocket socket = new MulticastSocket(port);
                //join to group 230.0.0.1
                InetAddress address = InetAddress.getByName("230.0.0.1");
                socket.joinGroup(address);
                //build packet
                byte[] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);;
                
                while (true) {
                    System.out.println("Waiting to messages");
                    //get message
                    socket.receive(packet);
                    //process message
                    String received = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("Receive " + received);
                    RemoteInterface remoteNode = (RemoteInterface) RMI.getRemote(received);
                    remote.addNode(remoteNode);
                }
            } catch (Exception ex) {
                //Logger.getLogger(AutomaticP2P.class.getName()).log(Level.SEVERE, null, ex);
            }
                }).start();
    }
}
