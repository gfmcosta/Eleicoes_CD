/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package eleicoes.gui;

import distributedMiner.RemoteInterface;
import distributedMiner.utils.RMI;
import eleicoes.lib.Global;
import eleicoes.lib.Candidate;
import eleicoes.lib.Election;
import eleicoes.lib.Person;
import java.awt.Image;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author Costa
 */
public class Verify extends javax.swing.JFrame {

    /**
     * Creates new form Verify
     */
        
    public Verify() {
        initComponents();
        if(Global.isFirst){
            deleteFiles();
            Global.isFirst=false;
        }
            
        ImageIcon i = new javax.swing.ImageIcon(getClass().getResource("/resources/upload.png"));
        Image img = i.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        jLabel8.setIcon(new ImageIcon(img));
        
    }
    
    void deleteFiles(){
        Path defaultDirectoryPath = Paths.get(System.getProperty("user.dir"), "keys");
        File pasta = defaultDirectoryPath.toFile();
        if (pasta.exists() && pasta.isDirectory()) {
            File[] arquivos = pasta.listFiles();

            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    if (arquivo.isFile()) {
                        if (arquivo.delete()) {
                            System.out.println("Arquivo removido: " + arquivo.getName());
                        } else {
                            System.err.println("Não foi possível remover o arquivo: " + arquivo.getName());
                        }
                    }
                }
            } else {
                System.out.println("A pasta está vazia.");
            }
        } else {
            System.err.println("A pasta não existe ou não é um diretório válido.");
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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eleições by Costa & Diogo");
        setResizable(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/elections (1).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Eleições");

        jTextField1.setEditable(false);
        jTextField1.setToolTipText("Número CC: XXXXXXXX");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Insira o número do CC");

        jButton1.setText("Verificar identidade");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Entrar como Administrador");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel8.setMaximumSize(new java.awt.Dimension(25, 25));
        jLabel8.setMinimumSize(new java.awt.Dimension(25, 25));
        jLabel8.setOpaque(true);
        jLabel8.setPreferredSize(new java.awt.Dimension(25, 25));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4))
        );

        jTextField1.getAccessibleContext().setAccessibleName("ccField");
        jLabel4.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO addVoteToBlockChain your handling code here:
        try{
        // cc number
        String fich = jTextField1.getText();
        // Encontrar a posição de ".pub"
        int indexOfPub = fich.indexOf(".user");
        // Verificar se ".pub" foi encontrado e extrair o texto antes disso
        String ccn = (indexOfPub != -1) ? fich.substring(0, indexOfPub) : fich;
        //bolean to control 'for' results
        boolean isValid=false;
        if(jTextField1.getText().equals("")){
                //null field value
                //open a pop-up message
                JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
            //textField1 isnt null
        for(Person p : Global.eleitoral.getElector()){
            if(p.getCC().equals(ccn) && p.getVoted()==false){
                
               //can vote
                isValid=true;
                //copy person with the same CC to Global variable loggedPerson
                Global.loggedP=p;
                //open nem form
                String pwd = new String(jPasswordField1.getPassword());
                Person loadedPerson = Person.loadUser(ccn, pwd);
                if(loadedPerson.getPrivKey()!=null){
                    new Menu().setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "A password não está coreta", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
                break;
            }else if(p.getCC().equals(ccn) && p.getVoted()==true){
                //cant vote but can see the results
                isValid=true;
                //copy person with the same CC to Global variable loggedPerson
                Global.loggedP=p;
                //open new form
                new Menu().setVisible(true);
                dispose();
            }
        }
     
        if (!isValid){
           //cc never exist
           JOptionPane.showMessageDialog(null, "O seu número de CC não se encontra na nossa lista", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
}
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro. Contacte o Administrador", "Exceção", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO addVoteToBlockChain your handling code here:
        new AdminLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO addVoteToBlockChain your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO addVoteToBlockChain your handling code here:
        Path defaultDirectoryPath = Paths.get(System.getProperty("user.dir"), "keys");
        File defaultDirectory = defaultDirectoryPath.toFile();

        JFileChooser chooser = new JFileChooser(defaultDirectory);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            // Crie um arquivo com o arquivo selecionado
            File f = chooser.getSelectedFile();
            // Salve o nome do arquivo selecionado no campo de texto
            jTextField1.setText(f.getName());
        }
    }//GEN-LAST:event_jLabel8MouseClicked

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
            java.util.logging.Logger.getLogger(Verify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Verify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Verify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Verify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Verify().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
