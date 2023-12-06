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
//::                                                               (c)2021   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package distributedMiner.gui;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import distributedMiner.utils.GuiUtils;
import distributedMiner.utils.RMI;
import distributedMiner.RemoteInterface;

/**
 *
 * @author IPT
 */
public class ClientMiner extends javax.swing.JFrame {

    RemoteInterface remote;

    /**
     * Creates new form Test03_GUI_miner
     */
    public ClientMiner() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    
    /**
     * Creates new form Test03_GUI_miner
     */
    public ClientMiner(String adress) {
        initComponents();
        setLocationRelativeTo(null);
        txtAdress.setText(adress);
        btConnectToServerActionPerformed(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpMain = new javax.swing.JTabbedPane();
        pnServerNetwork = new javax.swing.JPanel();
        pnServer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtField3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        btConnectToServer = new javax.swing.JButton();
        pnMining = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtField = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNonce = new javax.swing.JTextField();
        txtField1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtHash = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        spMyServerPort = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        btMining = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtField2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtData = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Miner (c)2023");

        pnServerNetwork.setLayout(new java.awt.BorderLayout());

        pnServer.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        txtField3.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel5.setText("Adress");
        txtField3.add(jLabel5, java.awt.BorderLayout.NORTH);

        txtAdress.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtAdress.setText("//localhost:10010/RemoteMiner");
        txtAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdressActionPerformed(evt);
            }
        });
        txtField3.add(txtAdress, java.awt.BorderLayout.CENTER);

        jPanel1.add(txtField3, java.awt.BorderLayout.CENTER);

        btConnectToServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/distributedMiner/images/Connect_to_Server.png"))); // NOI18N
        btConnectToServer.setText("Connect to Server");
        btConnectToServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConnectToServerActionPerformed(evt);
            }
        });
        jPanel1.add(btConnectToServer, java.awt.BorderLayout.WEST);

        pnServer.add(jPanel1, java.awt.BorderLayout.CENTER);

        pnServerNetwork.add(pnServer, java.awt.BorderLayout.NORTH);

        pnMining.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        txtField.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel2.setText("Nonce");
        txtField.add(jLabel2, java.awt.BorderLayout.NORTH);

        txtNonce.setEditable(false);
        txtNonce.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtNonce.setText("00000000");
        txtField.add(txtNonce, java.awt.BorderLayout.CENTER);

        jPanel5.add(txtField, java.awt.BorderLayout.WEST);

        txtField1.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel3.setText("Hash");
        txtField1.add(jLabel3, java.awt.BorderLayout.NORTH);

        txtHash.setEditable(false);
        txtHash.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtField1.add(txtHash, java.awt.BorderLayout.CENTER);

        jPanel5.add(txtField1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        spMyServerPort.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        spMyServerPort.setModel(new javax.swing.SpinnerNumberModel(3, null, null, 1));
        spMyServerPort.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        spMyServerPort.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel2.add(spMyServerPort, java.awt.BorderLayout.WEST);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mining");
        jPanel2.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        btMining.setIcon(new javax.swing.ImageIcon(getClass().getResource("/distributedMiner/images/getNonce48.png"))); // NOI18N
        btMining.setText("Start");
        btMining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMiningActionPerformed(evt);
            }
        });
        jPanel2.add(btMining, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel2, java.awt.BorderLayout.EAST);

        jPanel8.add(jPanel5, java.awt.BorderLayout.CENTER);

        pnMining.add(jPanel8, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.BorderLayout());

        txtField2.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel4.setText("Message");
        txtField2.add(jLabel4, java.awt.BorderLayout.NORTH);

        txtData.setColumns(20);
        txtData.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        txtData.setRows(5);
        txtData.setText("Hello Distributed Mining World");
        jScrollPane1.setViewportView(txtData);

        txtField2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel6.add(txtField2, java.awt.BorderLayout.CENTER);

        pnMining.add(jPanel6, java.awt.BorderLayout.CENTER);

        pnServerNetwork.add(pnMining, java.awt.BorderLayout.CENTER);

        tpMain.addTab("Client Remote Miner", pnServerNetwork);

        getContentPane().add(tpMain, java.awt.BorderLayout.CENTER);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(64, 300));

        txtLog.setBackground(new java.awt.Color(0, 0, 0));
        txtLog.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtLog.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(txtLog);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConnectToServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConnectToServerActionPerformed
        try {
            remote = (RemoteInterface) RMI.getRemote(txtAdress.getText());
            onMessage("Connected to ", txtAdress.getText());

        } catch (Exception e) {
            onException("Connect to server", e);
        }

    }//GEN-LAST:event_btConnectToServerActionPerformed

    private void txtAdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdressActionPerformed

    private void btMiningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMiningActionPerformed
        try {
            if (remote.isMining()) {
                remote.stopMining(99999);
                txtData.setEnabled(true);
                btMining.setText("Start");
            } else {
                remote.startMining(txtData.getText(), (int) spMyServerPort.getValue());
                txtData.setEnabled(false);
                btMining.setText("Stop");
                new Thread(
                        () -> {
                            try {
                                while (remote.isMining()) {
                                    Thread.sleep(100);
                                }
                                txtData.setEnabled(true);
                                btMining.setText("Start");
                                txtNonce.setText(remote.getNonce()+"");
                                txtHash.setText(remote.getHash(remote.getNonce(), txtData.getText()));                                

                            } catch (Exception ex) {

                            }

                        }
                ).start();
            }

        } catch (RemoteException ex) {
            Logger.getLogger(ClientMiner.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btMiningActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientMiner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientMiner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientMiner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientMiner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }




        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientMiner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConnectToServer;
    private javax.swing.JButton btMining;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnMining;
    private javax.swing.JPanel pnServer;
    private javax.swing.JPanel pnServerNetwork;
    private javax.swing.JSpinner spMyServerPort;
    private javax.swing.JTabbedPane tpMain;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextArea txtData;
    private javax.swing.JPanel txtField;
    private javax.swing.JPanel txtField1;
    private javax.swing.JPanel txtField2;
    private javax.swing.JPanel txtField3;
    private javax.swing.JTextField txtHash;
    private javax.swing.JTextPane txtLog;
    private javax.swing.JTextField txtNonce;
    // End of variables declaration//GEN-END:variables

    public void onException(String title, Exception ex) {
        GuiUtils.addText(txtLog, title, ex.getMessage(), Color.RED, Color.MAGENTA);
        JOptionPane.showMessageDialog(this, ex.getMessage(),
                title, JOptionPane.ERROR_MESSAGE);
        Logger.getAnonymousLogger().log(Level.SEVERE, null, ex);
    }

    public void onMessage(String title, String msg) {
        GuiUtils.addText(txtLog, title, msg, Color.GREEN, Color.WHITE);
    }

}
