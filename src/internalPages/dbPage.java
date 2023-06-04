/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class dbPage extends javax.swing.JInternalFrame {
    private Connection con;
    DefaultTableModel model;
    
    public dbPage() {
        initComponents();
        
        reshouse();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
    }

     public void reshouse(){
     PreparedStatement st = null;
     ResultSet rs = null;
     
     long l = System.currentTimeMillis();
     Date todaydate = new Date(l);

      try {
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/purokinformationsystem", "root", "");
           st = con.prepareStatement("SELECT COUNT(*) FROM tbl_residentrecords");
           rs = st.executeQuery();
          while (rs.next()){
              int count = rs.getInt(1);
              
          residentno.setText(String.valueOf(count));  
          }
           st = con.prepareStatement("SELECT COUNT(*) FROM tbl_householdrecords");
           rs = st.executeQuery();
           while (rs.next()){
              int count = rs.getInt(1);
              
          householdno.setText(String.valueOf(count));  
          }                 
      } catch (Exception e) {
      e.printStackTrace();
      }
  
  
  }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        residentno = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        householdno = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("NO. OF RESIDENT");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 280, 40));

        residentno.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        residentno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        residentno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(residentno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 80, 50));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(110, 70, 320, 170);

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        householdno.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        householdno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        householdno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(householdno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 80, 50));

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("NO. OF HOUSEHOLD");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 40));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 280, 40));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(110, 280, 320, 170);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/pis-low-resolution-color-logo-mo.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(540, 130, 240, 240);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel householdno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel residentno;
    // End of variables declaration//GEN-END:variables
}
