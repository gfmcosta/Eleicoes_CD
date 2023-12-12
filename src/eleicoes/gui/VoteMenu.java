/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package eleicoes.gui;

import client.Vote;
import distributedMiner.utils.Converter;
import eleicoes.lib.Global;
import eleicoes.lib.Candidate;
import eleicoes.utils.SecurityUtils;
import java.awt.Image;
import java.awt.TextArea;
import java.rmi.RemoteException;
import java.security.Key;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

/**
 *
 * @author diogo
 */
public class VoteMenu extends javax.swing.JDialog {

    /**
     * Creates new form vote
     */
    public VoteMenu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            JLabel l;
            JLabel l2;
            JLabel l3;
            JRadioButton j1;
            JButton bt1;
            int y=0;
            initComponents();
            for (Candidate c : Global.remote.getElection().getCandidate()){
                //name label
                l = new JLabel(c.getName());
                l.setBounds(6,98+y,192,50);
                l.setFont(new java.awt.Font("Segoe UI", 3, 11));
                l.setDoubleBuffered(true);
                add(l);
                //abv label
                l2 = new JLabel(c.getAbv());
                l2.setBounds(225,116+y,39,15);
                l2.setFont(new java.awt.Font("Segoe UI", 3, 11));
                l2.setDoubleBuffered(true);
                add(l2);
                //image label
                l3 = new JLabel("");
                l3.setBounds(302,98+y,50,50);
                ImageIcon i = new javax.swing.ImageIcon(getClass().getResource(c.getImage()));
                Image img = i.getImage().getScaledInstance(l3.getWidth(), l3.getHeight(), Image.SCALE_SMOOTH);
                l3.setIcon(new ImageIcon(img));
                l3.setDoubleBuffered(true);
                add(l3);
                //radioButton
                j1=new JRadioButton();
                j1.setBounds(391,110+y,30,32);
                j1.setActionCommand(c.getAbv());
                buttonGroup1.add(j1);
                add(j1);
                y+=50;
            }
            
//            for (Candidate c : Global.eleitoral.getCandidate()){
//                //name label
//                l = new JLabel(c.getName());
//                l.setBounds(6,98+y,192,50);
//                l.setFont(new java.awt.Font("Segoe UI", 3, 11));
//                l.setDoubleBuffered(true);
//                add(l);
//                //abv label
//                l2 = new JLabel(c.getAbv());
//                l2.setBounds(225,116+y,39,15);
//                l2.setFont(new java.awt.Font("Segoe UI", 3, 11));
//                l2.setDoubleBuffered(true);
//                add(l2);
//                //image label
//                l3 = new JLabel("");
//                l3.setBounds(302,98+y,50,50);
//                ImageIcon i = new javax.swing.ImageIcon(getClass().getResource(c.getImage()));
//                Image img = i.getImage().getScaledInstance(l3.getWidth(), l3.getHeight(), Image.SCALE_SMOOTH);
//                l3.setIcon(new ImageIcon(img));
//                l3.setDoubleBuffered(true);
//                add(l3);
//                //radioButton
//                j1=new JRadioButton();
//                j1.setBounds(391,110+y,30,32);
//                j1.setActionCommand(c.getAbv());
//                buttonGroup1.add(j1);
//                add(j1);
//                y+=50;
//            }
            //blank Vote2 option
            l = new JLabel("Votar em Branco");
            l.setBounds(6,98+y,192,50);
            l.setFont(new java.awt.Font("Segoe UI", 3, 11));
            l.setDoubleBuffered(true);
            add(l);
            //abv label
            l2 = new JLabel("VB");
            l2.setBounds(225,116+y,39,15);
            l2.setFont(new java.awt.Font("Segoe UI", 3, 11));
            l2.setDoubleBuffered(true);
            add(l2);
            //image label
            l3 = new JLabel("");
            l3.setBounds(302,98+y,50,50);
            ImageIcon i = new javax.swing.ImageIcon(getClass().getResource("/resources/nulo.png"));
            Image img = i.getImage().getScaledInstance(l3.getWidth(), l3.getHeight(), Image.SCALE_SMOOTH);
            l3.setIcon(new ImageIcon(img));
            l3.setDoubleBuffered(true);
            add(l3);
            //radioButton
            j1=new JRadioButton();
            j1.setBounds(391,110+y,30,32);
            j1.setActionCommand("VB");
            buttonGroup1.add(j1);
            add(j1);
            y+=155;
            //confirm button
            bt1= new JButton();
            bt1.setBounds(339,y,117,28);
            bt1.setText("Confirmar Voto");
            bt1.setFont(new java.awt.Font("Segoe UI", 3, 12));
            bt1.addMouseListener(new java.awt.event.MouseAdapter() {
                //creating the mousclicked event
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    //add the personal vote
                    String vote=buttonGroup1.getSelection().getActionCommand();
                    try {
                        Global.remote.getElection().addListVotes(vote);
                    } catch (RemoteException ex) {
                        Logger.getLogger(VoteMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Global.loggedP.setVoted(true);
                    
                    //Cria um voto
                    //From: CC da pessoa encriptado com a chave publica
                    //To: String abreviatura do candidato
                    //Signature: Assinaturado objeto Voto com a chave privada da pessoa (O voto tem apenas from e to nesta instância com assinatura a null)
                    Vote v =null;
                    try {
                        byte[] eleitor = SecurityUtils.encrypt(Converter.objectToByteArray(Global.loggedP.getCC()), Global.loggedP.getPubKey());
                        String eleitorString = Base64.getEncoder().encodeToString(eleitor);
                        v = new Vote(eleitorString, vote);
                        byte[] assinatura = SecurityUtils.sign(Converter.objectToByteArray(v), Global.loggedP.getPrivKey());
                        String assinaturaString = Base64.getEncoder().encodeToString(assinatura);
                        v= new Vote(eleitorString, vote,assinaturaString);
                    } catch (Exception ex) {
                        Logger.getLogger(VoteMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    try {
                        Global.remote.getElection().addVoteToBlockChain(v);
                        //Vote t = new Vote(Global.loggedP.getName(), vote, 1);
                        //Global.remote.addTransaction(v.toText());
                        JOptionPane.showMessageDialog(null, "Obrigado por votar "+Global.loggedP.getName()+"!", "Voto", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } catch (Exception ex) {
                        Logger.getLogger(VoteMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            add(bt1);
            setBounds(getX(), getY(), getWidth(), y+80);
            
            i = new javax.swing.ImageIcon(getClass().getResource("/resources/elections (1).png"));
            img = i.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            setIconImage(img);
        } catch (RemoteException ex) {
            Logger.getLogger(VoteMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        jLabel14 = new javax.swing.JLabel();

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eleições by Costa & Diogo");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        label2.setAlignment(java.awt.Label.CENTER);
        label2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        label2.setText("Votar");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/elections.png"))); // NOI18N
        jLabel14.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(505, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO addVoteToBlockChain your handling code here:
        
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(VoteMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoteMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoteMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoteMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VoteMenu dialog = new VoteMenu(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                dialog.revalidate();
                dialog.validate();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}
