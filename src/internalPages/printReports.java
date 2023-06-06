/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import config.dbconfiguration;
import java.awt.Color;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author HP
 */
public class printReports extends javax.swing.JInternalFrame {
DefaultTableModel model;
    /**
     * Creates new form blotterReports
     */
    public printReports() {
        initComponents();
        displayData();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
    
    
    public void filter(String qry ){
             model = (DefaultTableModel) p_table.getModel();
             TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
             p_table.setRowSorter(trs);
       
             if(qry =="ALL"){
                p_table.setRowSorter(trs);
             }else{
                trs.setRowFilter(RowFilter.regexFilter(qry));
             }
       
        }
   
    
    
        Color navcolor= new Color(255,102,102);
        Color headcolor= new Color(255,153,153);
        Color bodycolor = new Color(255,204,204);
    
    public void displayData() {
    try {
        dbconfiguration dbc = new dbconfiguration();
        ResultSet rs = dbc.getData("SELECT printreports.pr_id as 'ID'\n" +
", tbl_purokrecords.purok as 'Purok'\n" +
",printreports.h_num as 'House Number'\n" +
", tbl_residentrecords.rr_lastname as 'Last Name'\n" +
", tbl_residentrecords.rr_firstname as 'First Name'\n" +
", tbl_residentrecords.rr_address as 'Address'\n" +
", tbl_residentrecords.rr_contact as 'Contact'\n" +
", tbl_residentrecords.rr_occupation as 'Occupation'\n" +
", printreports.fam_mem as' Family Member' FROM ((printreports INNER JOIN tbl_purokrecords ON printreports.purok_id = tbl_purokrecords.purok_id) INNER JOIN tbl_residentrecords ON printreports.rr_id = tbl_residentrecords.rr_id) ORDER BY printreports.pr_id ASC;");

        p_table.setModel(DbUtils.resultSetToTableModel(rs));

    } catch (SQLException ex) {
        System.out.println("Error Message: " + ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        db4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        p_table = new javax.swing.JTable();
        print = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        search = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        search1 = new javax.swing.JTextField();
        filter = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("PRINT REPORTS");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 180, 50));

        db4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/print1 (2).png"))); // NOI18N
        jPanel2.add(db4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, 50));

        p_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(p_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 850, 320));

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

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/print1 (1).png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        print.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel14.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PRINT REPORT");
        print.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 120, 40));

        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 170, 40));

        search.setBackground(new java.awt.Color(255, 153, 153));
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchMouseExited(evt);
            }
        });
        search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/search1 (1).png"))); // NOI18N
        search.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel17.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("SEARCH");
        search.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 70, 40));

        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 120, 40));

        search1.setBackground(new java.awt.Color(255, 204, 204));
        search1.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jPanel1.add(search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 240, 40));

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
        jPanel1.add(filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 250, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("FILTERED:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 30));

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
       MessageFormat header = new MessageFormat("PUROK INFORMATION SYSTEM");
       MessageFormat footer = new MessageFormat("Page {0, number, integer}");

       PrinterJob printerJob = PrinterJob.getPrinterJob();

       if (printerJob.printDialog()) {
        PageFormat pageFormat = printerJob.defaultPage();
        pageFormat.setOrientation(PageFormat.LANDSCAPE);

        // Set the page margins to fit the entire table on one page
        double margin = 36; // 1 inch margin
        double width = pageFormat.getImageableWidth() - 2 * margin;
        double height = pageFormat.getImageableHeight() - 2 * margin;

        p_table.setSize((int) width, (int) height);

        try {
            p_table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException e) {
            System.err.format("Printer error: %s%n", e.getMessage());
        }
    }
    }//GEN-LAST:event_printMouseClicked

    private void printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseEntered
        print.setBackground(navcolor);
    }//GEN-LAST:event_printMouseEntered

    private void printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseExited
        print.setBackground(headcolor);
    }//GEN-LAST:event_printMouseExited

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        DefaultTableModel model = (DefaultTableModel) p_table.getModel();
        TableRowSorter<DefaultTableModel> obj  = new TableRowSorter<>(model);
        p_table.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(search1.getText()));
    }//GEN-LAST:event_searchMouseClicked

    private void searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseEntered
        search.setBackground(navcolor);
    }//GEN-LAST:event_searchMouseEntered

    private void searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseExited
        search.setBackground(headcolor);
    }//GEN-LAST:event_searchMouseExited

    private void p_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_tableMouseClicked
        
    }//GEN-LAST:event_p_tableMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void filterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterItemStateChanged
        String qry = filter.getSelectedItem().toString();
        filter(qry);
    }//GEN-LAST:event_filterItemStateChanged

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel db4;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable p_table;
    private javax.swing.JPanel print;
    private javax.swing.JPanel search;
    private javax.swing.JTextField search1;
    // End of variables declaration//GEN-END:variables
}
