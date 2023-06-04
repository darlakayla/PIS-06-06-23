/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import config.dbconfiguration;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author HP
 */
public class purokList extends javax.swing.JInternalFrame {
    DefaultTableModel model;
    
    public purokList() {
        initComponents();    
        displayData();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
    }
    
        Color navcolor= new Color(255,102,102);
        Color headcolor= new Color(255,153,153);
        Color bodycolor = new Color(255,204,204);
        
        

    public void filter(String qry ){
             model = (DefaultTableModel) puroklist.getModel();
             TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
             puroklist.setRowSorter(trs);
       
             if(qry =="ALL"){
                puroklist.setRowSorter(trs);
             }else{
                trs.setRowFilter(RowFilter.regexFilter(qry));
             }
       
        }
        
    public void displayData() {
       dbconfiguration dbc=new dbconfiguration();
       ResultSet rs;
      
      try {
    String query = ("SELECT * FROM puroklist JOIN tbl_householdrecords ON puroklist.p_id = tbl_householdrecords.hh_id, tbl_householdrecords.hh_lastname");


    rs = dbc.getData(query);
    puroklist.setModel(DbUtils.resultSetToTableModel(rs));

    DefaultTableModel model = (DefaultTableModel) puroklist.getModel();
    String[] columnIdentifiers = {"TagbuagTubig", "Centro", "Ilaya", "Argonex", "Cambaje","Upper","Kapolinar"};
    model.setColumnIdentifiers(columnIdentifiers);
    rs.close();
   // rs6.close();
    } catch (SQLException ex) {
    Logger.getLogger(purokList.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        db2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        puroklist = new javax.swing.JTable();
        print = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        filter = new javax.swing.JComboBox<>();
        display = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        db2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/houses (1).png"))); // NOI18N
        jPanel2.add(db2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));

        jLabel24.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("PUROK LIST");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 180, 50));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 20, 240, 50);

        jScrollPane2.setViewportView(puroklist);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(30, 120, 820, 340);

        print.setBackground(new java.awt.Color(255, 153, 153));
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printMouseExited(evt);
            }
        });
        print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PRINT ");
        print.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/print1 (1).png"))); // NOI18N
        print.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jPanel1.add(print);
        print.setBounds(720, 70, 120, 40);

        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"All", "Tagbuag-tubig", "Centro", "Ilaya","Argonex","Cambaje","Upper","Kapolinar"}));
        filter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterItemStateChanged(evt);
            }
        });
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });
        jPanel1.add(filter);
        filter.setBounds(330, 70, 240, 40);

        display.setBackground(new java.awt.Color(255, 153, 153));
        display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                displayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                displayMouseExited(evt);
            }
        });
        display.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/display (1).png"))); // NOI18N
        display.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel19.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("DISPLAY");
        display.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 90, 40));

        jPanel1.add(display);
        display.setBounds(580, 70, 130, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
       
    }//GEN-LAST:event_printMouseClicked

    private void printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseEntered
        print.setBackground(navcolor);
    }//GEN-LAST:event_printMouseEntered

    private void printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseExited
        print.setBackground(headcolor);
    }//GEN-LAST:event_printMouseExited

    private void filterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterItemStateChanged
       String qry = filter.getSelectedItem().toString();
       filter(qry);
    }//GEN-LAST:event_filterItemStateChanged

    private void displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayMouseClicked
        displayData();
    }//GEN-LAST:event_displayMouseClicked

    private void displayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayMouseEntered
        display.setBackground(navcolor);
    }//GEN-LAST:event_displayMouseEntered

    private void displayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayMouseExited
        display.setBackground(headcolor);
    }//GEN-LAST:event_displayMouseExited

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel db2;
    private javax.swing.JPanel display;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel print;
    private javax.swing.JTable puroklist;
    // End of variables declaration//GEN-END:variables
}
