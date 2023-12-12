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

import client.Vote;
import distributedMiner.MiningListener;
import distributedMiner.RemoteObject;
import java.awt.Color;
import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import distributedMiner.utils.GuiUtils;
import distributedMiner.utils.RMI;
import distributedMiner.RemoteInterface;
import distributedMiner.blockchain.Block;
import distributedMiner.blockchain.BlockChain;
import java.io.IOException;
import javax.swing.ImageIcon;
import distributedMiner.utils.Serializer;
import eleicoes.lib.Candidate;

/**
 *
 * @author IPT
 */
public class ServerMiner extends javax.swing.JFrame implements MiningListener {

    //Objeto remoto
    RemoteObject myRemote;

    /**
     * Creates new form Test03_GUI_miner
     */
    public ServerMiner() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     *
     * @param port port de escuta
     * @param px localização x do ecrã
     * @param py localização 2 do ecrã
     */
    public ServerMiner(int port, int px, int py) {
        initComponents();
        spMyServerPort.setValue(port);
        setLocation(px, py);
        //iniciar o servidor
        btStartServerActionPerformed(null);
        //conectar-se
        btAddServerActionPerformed(null);
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
        pnServerMining = new javax.swing.JPanel();
        pnServer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btStartServer = new javax.swing.JButton();
        spMyServerPort = new javax.swing.JSpinner();
        runningIcon = new javax.swing.JLabel();
        pnMining = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtField = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNonce = new javax.swing.JTextField();
        txtField1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtHash = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        spDificulty = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtField2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtData = new javax.swing.JTextArea();
        pnNtework = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txtNodeAdress = new javax.swing.JTextField();
        btAddServer = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNetwork = new javax.swing.JTextArea();
        pnTransaction = new javax.swing.JPanel();
        pnBlockchianTop = new javax.swing.JPanel();
        pnLabelLeft = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstTransactions = new javax.swing.JList<>();
        pnLabelCenter = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtTransaction = new javax.swing.JTextArea();
        pnBlochchain = new javax.swing.JPanel();
        pnBlockchianTop1 = new javax.swing.JPanel();
        pnLabelLeft1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lstBlockchain = new javax.swing.JList<>();
        pnLabelCenter1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtBlockchain = new javax.swing.JTextArea();
        pnCandidates1 = new javax.swing.JPanel();
        pnCandidatesTop2 = new javax.swing.JPanel();
        pnLabelLeft2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        lstCandidates = new javax.swing.JList<>();
        pnLabelCenter2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtCandidates = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Miner (c)2023");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnServerMining.setLayout(new java.awt.BorderLayout());

        pnServer.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btStartServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/distributedMiner/images/Connect_to_Server.png"))); // NOI18N
        btStartServer.setText("Start Server");
        btStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartServerActionPerformed(evt);
            }
        });
        jPanel2.add(btStartServer);

        spMyServerPort.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        spMyServerPort.setModel(new javax.swing.SpinnerNumberModel(10010, 10010, null, 1));
        spMyServerPort.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(spMyServerPort);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pnServer.add(jPanel1, java.awt.BorderLayout.WEST);

        runningIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        runningIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/distributedMiner/images/working.gif"))); // NOI18N
        pnServer.add(runningIcon, java.awt.BorderLayout.CENTER);

        pnServerMining.add(pnServer, java.awt.BorderLayout.NORTH);

        pnMining.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        txtField.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel2.setText("Nonce");
        txtField.add(jLabel2, java.awt.BorderLayout.NORTH);

        txtNonce.setEditable(false);
        txtNonce.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtNonce.setText("00000000");
        txtNonce.setPreferredSize(new java.awt.Dimension(150, 32));
        txtField.add(txtNonce, java.awt.BorderLayout.CENTER);

        jPanel5.add(txtField, java.awt.BorderLayout.WEST);

        txtField1.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel3.setText("Hash");
        txtField1.add(jLabel3, java.awt.BorderLayout.NORTH);

        txtHash.setEditable(false);
        txtHash.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtHash.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtHash.setFocusTraversalPolicyProvider(true);
        txtField1.add(txtHash, java.awt.BorderLayout.CENTER);

        jPanel5.add(txtField1, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());

        spDificulty.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        spDificulty.setModel(new javax.swing.SpinnerNumberModel(3, null, null, 1));
        spDificulty.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        spDificulty.setEnabled(false);
        spDificulty.setFocusTraversalPolicyProvider(true);
        jPanel3.add(spDificulty, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Dificulty");
        jPanel3.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel8.add(jPanel3, java.awt.BorderLayout.EAST);

        pnMining.add(jPanel8, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.BorderLayout());

        txtField2.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel4.setText("Message");
        txtField2.add(jLabel4, java.awt.BorderLayout.NORTH);

        txtData.setEditable(false);
        txtData.setColumns(20);
        txtData.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        txtData.setLineWrap(true);
        txtData.setRows(5);
        jScrollPane1.setViewportView(txtData);

        txtField2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel6.add(txtField2, java.awt.BorderLayout.CENTER);

        pnMining.add(jPanel6, java.awt.BorderLayout.CENTER);

        pnServerMining.add(pnMining, java.awt.BorderLayout.CENTER);

        tpMain.addTab("Remote Miner", pnServerMining);

        pnNtework.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new java.awt.BorderLayout());

        txtNodeAdress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNodeAdress.setText("//localhost:10010/RemoteMiner");
        txtNodeAdress.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.add(txtNodeAdress, java.awt.BorderLayout.CENTER);

        btAddServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/distributedMiner/images/add-server-icon.png"))); // NOI18N
        btAddServer.setText("Add");
        btAddServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddServerActionPerformed(evt);
            }
        });
        jPanel9.add(btAddServer, java.awt.BorderLayout.WEST);

        pnNtework.add(jPanel9, java.awt.BorderLayout.NORTH);

        txtNetwork.setColumns(20);
        txtNetwork.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtNetwork.setRows(5);
        jScrollPane3.setViewportView(txtNetwork);

        pnNtework.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        tpMain.addTab("Network", pnNtework);

        pnTransaction.setLayout(new java.awt.BorderLayout());

        pnBlockchianTop.setLayout(new java.awt.GridLayout(1, 0));

        pnLabelLeft.setLayout(new java.awt.BorderLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Transactions");
        jLabel6.setPreferredSize(new java.awt.Dimension(200, 16));
        pnLabelLeft.add(jLabel6, java.awt.BorderLayout.NORTH);

        jScrollPane5.setMaximumSize(new java.awt.Dimension(32767, 200));

        lstTransactions.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstTransactions.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTransactionsValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(lstTransactions);

        pnLabelLeft.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        pnBlockchianTop.add(pnLabelLeft);

        pnLabelCenter.setLayout(new java.awt.BorderLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Details");
        pnLabelCenter.add(jLabel5, java.awt.BorderLayout.NORTH);

        jScrollPane7.setMaximumSize(new java.awt.Dimension(300, 900000));
        jScrollPane7.setOpaque(false);

        txtTransaction.setColumns(20);
        txtTransaction.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtTransaction.setRows(5);
        txtTransaction.setMaximumSize(new java.awt.Dimension(300, 900000));
        txtTransaction.setOpaque(false);
        jScrollPane7.setViewportView(txtTransaction);

        pnLabelCenter.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        pnBlockchianTop.add(pnLabelCenter);

        pnTransaction.add(pnBlockchianTop, java.awt.BorderLayout.CENTER);

        tpMain.addTab("Transactions", pnTransaction);

        pnBlochchain.setLayout(new java.awt.BorderLayout());

        pnBlockchianTop1.setLayout(new java.awt.GridLayout(1, 0));

        pnLabelLeft1.setLayout(new java.awt.BorderLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Blockchain");
        jLabel7.setPreferredSize(new java.awt.Dimension(200, 16));
        pnLabelLeft1.add(jLabel7, java.awt.BorderLayout.NORTH);

        jScrollPane6.setMaximumSize(new java.awt.Dimension(32767, 200));

        lstBlockchain.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstBlockchain.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstBlockchainValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(lstBlockchain);

        pnLabelLeft1.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        pnBlockchianTop1.add(pnLabelLeft1);

        pnLabelCenter1.setLayout(new java.awt.BorderLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Details");
        pnLabelCenter1.add(jLabel8, java.awt.BorderLayout.NORTH);

        jScrollPane8.setMaximumSize(new java.awt.Dimension(300, 900000));
        jScrollPane8.setOpaque(false);

        txtBlockchain.setColumns(20);
        txtBlockchain.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtBlockchain.setRows(5);
        txtBlockchain.setMaximumSize(new java.awt.Dimension(300, 900000));
        txtBlockchain.setOpaque(false);
        jScrollPane8.setViewportView(txtBlockchain);

        pnLabelCenter1.add(jScrollPane8, java.awt.BorderLayout.CENTER);

        pnBlockchianTop1.add(pnLabelCenter1);

        pnBlochchain.add(pnBlockchianTop1, java.awt.BorderLayout.CENTER);

        tpMain.addTab("Blockchain", pnBlochchain);

        pnCandidates1.setLayout(new java.awt.BorderLayout());

        pnCandidatesTop2.setLayout(new java.awt.GridLayout());

        pnLabelLeft2.setLayout(new java.awt.BorderLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Candidates");
        jLabel9.setPreferredSize(new java.awt.Dimension(200, 16));
        pnLabelLeft2.add(jLabel9, java.awt.BorderLayout.NORTH);

        jScrollPane9.setMaximumSize(new java.awt.Dimension(32767, 200));

        lstCandidates.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstCandidates.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCandidatesValueChanged(evt);
            }
        });
        jScrollPane9.setViewportView(lstCandidates);

        pnLabelLeft2.add(jScrollPane9, java.awt.BorderLayout.CENTER);

        pnCandidatesTop2.add(pnLabelLeft2);

        pnLabelCenter2.setLayout(new java.awt.BorderLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Details");
        pnLabelCenter2.add(jLabel10, java.awt.BorderLayout.NORTH);

        jScrollPane10.setMaximumSize(new java.awt.Dimension(300, 900000));
        jScrollPane10.setOpaque(false);

        txtCandidates.setColumns(20);
        txtCandidates.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtCandidates.setRows(5);
        txtCandidates.setMaximumSize(new java.awt.Dimension(300, 900000));
        txtCandidates.setOpaque(false);
        jScrollPane10.setViewportView(txtCandidates);

        pnLabelCenter2.add(jScrollPane10, java.awt.BorderLayout.CENTER);

        pnCandidatesTop2.add(pnLabelCenter2);

        pnCandidates1.add(pnCandidatesTop2, java.awt.BorderLayout.CENTER);

        tpMain.addTab("Candidates", pnCandidates1);

        getContentPane().add(tpMain, java.awt.BorderLayout.CENTER);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(64, 300));

        txtLog.setEditable(false);
        txtLog.setBackground(new java.awt.Color(0, 0, 0));
        txtLog.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtLog.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(txtLog);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartServerActionPerformed
        try {
            int port = (int) spMyServerPort.getValue();
            myRemote = new RemoteObject(port, this);
            RMI.startRemoteObject(myRemote, port, RemoteInterface.OBJECT_NAME);
        } catch (Exception e) {
            onException("Start server", e);
        }

    }//GEN-LAST:event_btStartServerActionPerformed

    private void btAddServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddServerActionPerformed

        RemoteInterface node;
        try {
            node = (RemoteInterface) RMI.getRemote(txtNodeAdress.getText());
            myRemote.addNode(node);
            myRemote.synchonizeTransactions(node.getTransactionsList());
            myRemote.synchonizeCandidates(node.getCandidatesList());
        } catch (Exception ex) {
            onException("Add Node", ex);
        }


    }//GEN-LAST:event_btAddServerActionPerformed

    private void lstTransactionsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTransactionsValueChanged
        //se estiver algo selecionado
        if (lstTransactions.getSelectedIndex() >= 0) {
            //apresentar a transação
           Vote t = Vote.fromText(lstTransactions.getSelectedValue());
           // Vote2 t = Vote2.fromText(lstTransactions.getSelectedValue());
            txtTransaction.setText(t.toString());
        }
    }//GEN-LAST:event_lstTransactionsValueChanged

    private void lstBlockchainValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstBlockchainValueChanged
        //se estiver algo selecionado
        if (lstBlockchain.getSelectedIndex() >= 0) {
            //bloco selecionado
            Block b = myRemote.blockchain.getChain().get(lstBlockchain.getSelectedIndex() + 1);
            //Lista de transaçoes
            List<String> lst = (List<String>) Serializer.base64ToObject(b.getData());
            StringBuilder txt = new StringBuilder(b.getInfo());
            //iterar as transações
            for (String string : lst) {
                //converter transacoes para tranfer
               Vote t = (Vote) Serializer.base64ToObject(string);
                //adicionar a transfer
                txt.append("\n:::::::::::::::::\n");
                txt.append(t.toString()).append("\n");
            }
            txtBlockchain.setText(txt.toString());
        }
    }//GEN-LAST:event_lstBlockchainValueChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            //guardar a blockchain
            myRemote.blockchain.save(BlockChain.DEFAULT_FILENAME);
        } catch (IOException ex) {
            Logger.getLogger(ServerMiner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void lstCandidatesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCandidatesValueChanged
        // TODO add your handling code here:
        if (lstCandidates.getSelectedIndex() >= 0) {
            try {
                //candidato selecionado
                Candidate c = myRemote.getCandidatesList().get(lstCandidates.getSelectedIndex());
                
                txtCandidates.setText(c.getInfo());
            } catch (RemoteException ex) {
                Logger.getLogger(ServerMiner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lstCandidatesValueChanged

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
            java.util.logging.Logger.getLogger(ServerMiner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerMiner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerMiner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerMiner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerMiner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddServer;
    private javax.swing.JButton btStartServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JList<String> lstBlockchain;
    private javax.swing.JList<String> lstCandidates;
    private javax.swing.JList<String> lstTransactions;
    private javax.swing.JPanel pnBlochchain;
    private javax.swing.JPanel pnBlockchianTop;
    private javax.swing.JPanel pnBlockchianTop1;
    private javax.swing.JPanel pnCandidates1;
    private javax.swing.JPanel pnCandidatesTop2;
    private javax.swing.JPanel pnLabelCenter;
    private javax.swing.JPanel pnLabelCenter1;
    private javax.swing.JPanel pnLabelCenter2;
    private javax.swing.JPanel pnLabelLeft;
    private javax.swing.JPanel pnLabelLeft1;
    private javax.swing.JPanel pnLabelLeft2;
    private javax.swing.JPanel pnMining;
    private javax.swing.JPanel pnNtework;
    private javax.swing.JPanel pnServer;
    private javax.swing.JPanel pnServerMining;
    private javax.swing.JPanel pnTransaction;
    private javax.swing.JLabel runningIcon;
    private javax.swing.JSpinner spDificulty;
    private javax.swing.JSpinner spMyServerPort;
    private javax.swing.JTabbedPane tpMain;
    private javax.swing.JTextArea txtBlockchain;
    private javax.swing.JTextArea txtCandidates;
    private javax.swing.JTextArea txtData;
    private javax.swing.JPanel txtField;
    private javax.swing.JPanel txtField1;
    private javax.swing.JPanel txtField2;
    private javax.swing.JTextField txtHash;
    private javax.swing.JTextPane txtLog;
    private javax.swing.JTextArea txtNetwork;
    private javax.swing.JTextField txtNodeAdress;
    private javax.swing.JTextField txtNonce;
    private javax.swing.JTextArea txtTransaction;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onException(String title, Exception ex) {
        //fazer log na gui
        GuiUtils.addText(txtLog, title, ex.getMessage(), Color.RED, Color.MAGENTA);
        //apresentar caixa de dialogo
        JOptionPane.showMessageDialog(this, ex.getMessage(),
                title, JOptionPane.ERROR_MESSAGE);
        //fazer log na consola
        Logger.getAnonymousLogger().log(Level.SEVERE, null, ex);
    }

    @Override
    public void onMessage(String title, String msg) {
        //fazer log da mensagem
        GuiUtils.addText(txtLog, title, msg, Color.GREEN, Color.WHITE);
    }

    @Override
    public void onStartServer(String adress) {
        EventQueue.invokeLater(() -> {
            //inativar os botões
            btStartServer.setEnabled(false);
            spMyServerPort.setEnabled(false);
            runningIcon.setVisible(false);
            setTitle(adress);
            onMessage("Server ready", adress);
            //atualizar as transacoes e a blockchain
            onUpdateTransactions(null);
            onUpdateBlockchain();
            onUpdateCandidate();
        });
    }

    @Override
    public void onStartMining(String message, int zeros) {
        EventQueue.invokeLater(() -> {
            runningIcon.setVisible(true);
            txtData.setText(message);
            txtData.setCaretPosition(0);
            txtHash.setText(".....");
            spDificulty.setValue(zeros);
            onMessage("Start Mining ", "[" + zeros + "]");
            tpMain.setSelectedComponent(pnServerMining);
        });
    }

    @Override
    public void onStopMining(int nonce) {
        EventQueue.invokeLater(() -> {
            try {
                runningIcon.setVisible(false);
                txtNonce.setText(nonce + "");
                //apresentar os primeiros 20 caracteres
                txtHash.setText(myRemote.getHash(nonce, txtData.getText()).substring(0, 20));
                onMessage("Stop Mining ", " " + nonce + "");
                txtBlockchain.setText(myRemote.miningBlock.getInfo());
                tpMain.setSelectedComponent(pnBlochchain);
            } catch (RemoteException ex) {
            }
        });
    }

    @Override
    public void onMining(int number) {
        EventQueue.invokeLater(() -> {
            txtNonce.setText(number + "");
        });
    }

    //imagem de quem ganhou
    private final ImageIcon img = new ImageIcon(getClass().getResource("/distributedMiner/images/winner.gif"));

    @Override
    public void onNounceFound(int nonce) {
        EventQueue.invokeLater(() -> {
            try {
                //atualizar o nonce do bloco
                myRemote.miningBlock.setNonce(nonce);
                //mandar parar a rede
                for (RemoteInterface node : myRemote.getNetwork()) {
                    onMessage("Abort Miner", node.getAdress());
                    node.stopMining(nonce);
                    //atualizar o bloco do nodo
                    node.updateMiningBlock(myRemote.miningBlock);
                }
                GuiUtils.addImage(txtLog, "Winner : " + nonce, img);
                onMessage("NOUNCE FOUND", nonce + "");

                myRemote.buildNewBlock();
            } catch (Exception ex) {
                onException("Nonce Found", ex);
            }
        });
    }

    @Override
    public void onAddNode(RemoteInterface node) {
        EventQueue.invokeLater(() -> {
            try {
                List<RemoteInterface> net = myRemote.getNetwork();
                txtNetwork.setText("");
                for (RemoteInterface n : net) {
                    txtNetwork.append(n.getAdress() + "\n");
                }
                onMessage("Add New Node", node.getAdress());
                tpMain.setSelectedComponent(pnNtework);
            } catch (Exception e) {
                onException("Add Node", e);
            }
        });

    }

    @Override
    public void onUpdateTransactions(String transaction) {
        EventQueue.invokeLater(() -> {
            try {
                //atualizar os elementos da lista
                DefaultListModel<String> model = new DefaultListModel<>();
                model.addAll(myRemote.getTransactionsList());
                lstTransactions.setModel(model);
                lstTransactions.setSelectedValue(transaction, true);
                if (transaction != null) {
                    //selecionar a transaçao
                    tpMain.setSelectedComponent(pnTransaction);
                }

            } catch (RemoteException ex) {
                onException("onReceiveTransaction", ex);
            }

        });
    }

    @Override
    public void onUpdateBlockchain() {
        EventQueue.invokeLater(() -> {
            try {
                //atualizar a lista
                DefaultListModel<String> model = new DefaultListModel<>();
                //nao introduzir o primeiro elemento
                for (int i = 1; i < myRemote.getBlockchainSize(); i++) {
                    model.addElement(myRemote.getBlockchain().getChain().get(i).getHash());
                }
                lstBlockchain.setModel(model);
                //selecionar o último bloco
                lstBlockchain.setSelectedValue(myRemote.getBlockchainSize() - 1, true);
                tpMain.setSelectedComponent(pnBlochchain);
            } catch (RemoteException ex) {
                onException("onReceiveTransaction", ex);
            }
        });
    }

    @Override
    public void onConsensus(String title, String desc) {
        GuiUtils.addText(txtLog, title, desc, Color.yellow, Color.ORANGE);
                
     }
    
    
    
    @Override
    public void onUpdateCandidate() {
        EventQueue.invokeLater(() -> {
            try {
                //atualizar os elementos da lista
                DefaultListModel<String> model = new DefaultListModel<>();
                for (int i = 0; i < myRemote.getCandidatesList().size(); i++) {
                    model.addElement(myRemote.getCandidatesList().get(i).getAbv());
                }
                lstCandidates.setModel(model);
                //selecionar o último bloco
                lstCandidates.setSelectedValue(myRemote.getCandidatesList().size() - 1, true);
                tpMain.setSelectedComponent(pnCandidates1);

            } catch (RemoteException ex) {
                onException("onReceiveCandidates", ex);
            }

        });
    }

}
