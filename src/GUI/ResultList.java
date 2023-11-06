/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

import eleicoes.lib.Global;
import eleicoes.lib.Candidate;
import eleicoes.lib.Election;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author diogo
 */
public class ResultList extends javax.swing.JDialog {

    /**
     * Creates new form vote
     */
    public ResultList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        JLabel l;
        JLabel l2;
        JLabel l3;
        JLabel l4;
        JLabel l5;
        JLabel l6;
        JLabel l7;
        JSeparator j1;
        JSeparator j2;
        int y=0;
        initComponents();
        File folder = new File(System.getProperty("user.dir") + "\\wikiElection");
        //open all files and real necessary information to create the menu dynamically
        for (File f : folder.listFiles()) {
            try{
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                //save all lines in array
                ArrayList<String> lines = new ArrayList<>();
                String line;
                while((line = br.readLine()) != null) { lines.add(line); }
                //close File Reader
                fr.close();
                //Start creating label's dynamically
                //Election name label
                l = new JLabel(lines.get(0));
                l.setBounds(82,92+y,140,25);
                l.setFont(new java.awt.Font("Segoe UI", 3, 16));
                l.setDoubleBuffered(true);
                add(l);
                //Initial date label
                l2 = new JLabel("Data Inicial: "+lines.get(1));
                l2.setBounds(82,123+y,140,16);
                l2.setFont(new java.awt.Font("Segoe UI", 1, 12));
                l2.setDoubleBuffered(true);
                add(l2);
                //Final date label
                l3 = new JLabel("Data final: "+lines.get(2));
                l3.setBounds(82,146+y,140,16);
                l3.setFont(new java.awt.Font("Segoe UI", 1, 12));
                l3.setDoubleBuffered(true);
                add(l3);
                //Image label
                l4 = new JLabel("");
                l4.setBounds(6,92+y,70,70);
                ImageIcon i = new javax.swing.ImageIcon(getClass().getResource(lines.get(3)));
                Image img = i.getImage().getScaledInstance(l4.getWidth(), l4.getHeight(), Image.SCALE_SMOOTH);
                l4.setIcon(new ImageIcon(img));
                l4.setDoubleBuffered(true);
                add(l4);
                //Vertical Separator
                j1= new JSeparator();
                j1.setBounds(235,92+y,3,70);
                j1.setForeground(Color.BLACK);
                j1.setDoubleBuffered(true);
                j1.setOrientation(SwingConstants.VERTICAL);
                add(j1);
                //Total votes label
                l5 = new JLabel("");
                l5.setBounds(244,92+y,126,16);
                l5.setFont(new java.awt.Font("Segoe UI", 3, 12));
                l5.setDoubleBuffered(true);
                boolean totalVotes=false;
                //Finding all votes number line in file
                for (String line1 : lines) {
                    if(totalVotes==true){
                        l5.setText("Votos: "+line1);
                        
                        break;
                    }
                    if(line1.equals(".")){
                        totalVotes=true;
                    }
                }
                add(l5);
                //winner Label
                l6 = new JLabel("Vencedor: "+ lines.get(lines.size()-1));
                l6.setBounds(244,120+y,203,16);
                l6.setFont(new java.awt.Font("Segoe UI", 3, 12));
                l6.setDoubleBuffered(true);
                add(l6);
                
                //plus information Label
                l7 = new JLabel("Mais informações");
                l7.setBounds(244,146+y,100,16);
                l7.setFont(new java.awt.Font("Segoe UI", 3, 12));
                l7.setDoubleBuffered(true);
                l7.setForeground(new Color(0,153,255));
                l7.setCursor(new Cursor(Cursor.HAND_CURSOR));
                l7.setName(lines.get(0));
                l7.addMouseListener(new java.awt.event.MouseAdapter() {
                    //creating the mousclicked event
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        //Find the election saved;
                        Global.eleitoralSearch = new Election();
                        Global.eleitoralSearch.setName(((JLabel)evt.getSource()).getName());
                        new Results(null,true).setVisible(true);
                    }
                });
                add(l7);
                
                //Horizontal Separator
                j2= new JSeparator();
                j2.setBounds(6,170+y,482,10);
                j2.setForeground(Color.BLACK);
                j2.setDoubleBuffered(true);
                j2.setOrientation(SwingConstants.HORIZONTAL);
                add(j2);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
            y+=90;
        }        
        setBounds(getX(), getY(), getWidth(), y+140);
        
        ImageIcon i = new javax.swing.ImageIcon(getClass().getResource("/resources/elections (1).png"));
        Image img = i.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        setIconImage(img);
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
        jSeparator1 = new javax.swing.JSeparator();

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
        label2.setText("Lista de Eleições");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/elections.png"))); // NOI18N
        jLabel14.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(384, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
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
            java.util.logging.Logger.getLogger(ResultList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ResultList dialog = new ResultList(new javax.swing.JFrame(), true);
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
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}
