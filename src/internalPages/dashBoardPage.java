/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author HP
 */
public class dashBoardPage extends javax.swing.JInternalFrame {

    /**
     * Creates new form dashBoardPage
     */
    public dashBoardPage() {
        initComponents();
                   
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }

    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        one = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("“Naga, An Maogmang Lugar”");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 280, 380, 40);

        jLabel3.setFont(new java.awt.Font("Rockwell", 2, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("citizenship.");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(430, 200, 400, 30);

        one.setFont(new java.awt.Font("Rockwell", 2, 17)); // NOI18N
        one.setForeground(new java.awt.Color(255, 255, 255));
        one.setText("To make Nagueños happy and proud of their city");
        jPanel1.add(one);
        one.setBounds(480, 110, 370, 30);

        jLabel5.setFont(new java.awt.Font("Rockwell", 2, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("and of their living faith thru continuous improvement and ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(430, 140, 440, 30);

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("MISSION");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(400, 70, 140, 40);

        jLabel7.setFont(new java.awt.Font("Rockwell", 2, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("A healthy city – peaceful, vibrant and productive, safe and smart,");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(70, 320, 490, 30);

        jLabel8.setFont(new java.awt.Font("Rockwell", 2, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("green and resilient – that is driven by excellence and solidarity, enabled");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 350, 530, 30);

        jLabel9.setFont(new java.awt.Font("Rockwell", 2, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("agricultural economy, and nurtured by culture and religious diversity.");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 410, 520, 30);

        jLabel10.setFont(new java.awt.Font("Rockwell", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("VISION");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 250, 140, 40);

        jLabel11.setFont(new java.awt.Font("Rockwell", 2, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("by technology, powered by a strong and diversified urban and ");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 380, 520, 30);

        jLabel4.setFont(new java.awt.Font("Rockwell", 2, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("innovation in inclusive  governance and responsible");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(430, 170, 400, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/Untitled.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 880, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel one;
    // End of variables declaration//GEN-END:variables
}
