/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import com.toedter.calendar.JDateChooser;
import config.dbconfiguration;
import static internalPages.AddEditBlotter.sched;
import java.awt.Color;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author HP
 */
public class Blotter extends javax.swing.JInternalFrame {
    DefaultTableModel model;
    private Connection con;
    /**
     * Creates new form Blotter
     */
    public Blotter() {
        initComponents();
        displayData();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
  
    public void displayData(){
        try{
            dbconfiguration dbc = new dbconfiguration();
            ResultSet rs = dbc.getData("SELECT b_caseno, b_accusation, b_schedule, complainantlastname, cfirstname, respondentlastname, rfirstname, b_status FROM blotter");
            blotter.setModel(DbUtils.resultSetToTableModel(rs));
            DefaultTableModel model = (DefaultTableModel) blotter.getModel();
            String[] columnIdentifiers = {"Case NO", "Accusation", "Schedule", "ComplainantLastname", "Firstname", "RespondentLastname", "Firstname", "Status"};
            model.setColumnIdentifiers(columnIdentifiers);
            
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
        }
    
    public void add(){
     
         try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/purokinformationsystem", "root", "");
            String sql = "INSERT INTO blotter ( b_caseno, b_accusation, b_schedule, complainantlastname, cfirstname, respondentlastname, rfirstname, b_status)values (?,?,?,?,?,?,?,?)"; 
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, cano.getText());
            ps.setString(2, accus.getText());  
            int srow = blotter.getSelectedRow();
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(srow, 3));
                sched.setDate(date);        
            ps.setString(3, clastn.getText());    
            ps.setString(4, cfname.getText());    
            ps.setString(5, rlastn.getText());    
            ps.setString(6, rfname.getText()); 
            ps.setString(7, stat.getSelectedItem().toString());
            
                    
             displayData();
             reset();
        JOptionPane.showMessageDialog(this, "ADDED SUCCESSFULLY");
        reset();
            }catch(Exception e){
                System.err.println("Cannot connect to database: " + e.getMessage());
     
     
     }
     }
    public void update(){
        int result=0;
         try {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/purokinformationsystem", "root", "");
         int row = blotter.getSelectedRow();
         String value = (blotter.getModel().getValueAt(row, 0).toString());
         String sql = "UPDATE blotter SET b_caseno=?, b_accusation=?, b_schedule=?, complainantlastname=?, cfirstname=?, respondentlastname=?, rfirstname=?, b_status=?  WHERE b_id="+value;
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, cano.getText());
            ps.setString(2, accus.getText());  
            try{
                int srow = blotter.getSelectedRow();
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(srow, 3));
                sched.setDate(date);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            ps.setString(3, clastn.getText());    
            ps.setString(4, cfname.getText());    
            ps.setString(5, rlastn.getText());    
            ps.setString(6, rfname.getText()); 
            ps.setString(7, stat.getSelectedItem().toString());
  
           reset();
           JOptionPane.showMessageDialog(null, "Successfully Updated!");
           }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"Database Connection Error!"+e);
           }
     }
    
    
    
         public void table(){
         int row = blotter.getSelectedRow();
         int cc = blotter.getSelectedColumn();
       
         String bid = blotter.getModel().getValueAt(row, 0).toString();
             try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/purokinformationsystem", "root", "");
             String sql = "SELECT * from blotter where b_id="+bid+"";
             PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
            int id=rs.getInt("b_id");
            String cano=rs.getString("b_caseno");
            String address=rs.getString("b_accusation");   
            String sche=rs.getString("b_schedule");    
            String cl=rs.getString("complainantlastname");   
            String cf=rs.getString("cfirstname");   
            String rl=rs.getString("respondentlastname");   
            String rf=rs.getString("rfirstname");   
            String stat=rs.getString("b_status");   
            }
             ps.close();
             rs.close();
         } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
         }
        }
        
    
    
    
    
    
        Color navcolor= new Color(255,102,102);
        Color headcolor= new Color(255,153,153);
        Color bodycolor = new Color(255,204,204);

        public void reset(){
        cano.setText("");
        accus.setText("");
       
        clastn.setText("");
        cfname.setText("");
        rlastn.setText("");
        rfname.setText("");
        stat.setSelectedItem("");
        
       
        }
        
        
        public boolean validation(){
            
        String cn= cano.getText();
        String acc= accus.getText();
        
        String cln= clastn.getText();
        String cfn= cfname.getText();
        String rln= rlastn.getText();
        String rfn= rfname.getText();
        
        
        if (cano.equals("")){
           JOptionPane.showMessageDialog(this, "PLEASE ENTER CASE NO.");
        return false;
        }
        if(accus.equals("")){
           JOptionPane.showMessageDialog(this, "PLEASE ENTER ACCUSATION");
        return false;
        }     
        if(clastn.equals("")){
        JOptionPane.showMessageDialog(this, "PLEASE ENTER COMPLAINANT LASTNAME");
        return false;
        }    
        if(cfname.equals("")){
        JOptionPane.showMessageDialog(this, "PLEASE ENTER COMPLAINANT FIRSTNAME");
        return false;
        }
        if(rlastn.equals("")){
        JOptionPane.showMessageDialog(this, "PLEASE ENTER RESPONDENT LASTNAME");
        return false;
        }
        if(rfname.equals("")){
        JOptionPane.showMessageDialog(this, "PLEASE ENTER RESPONDENT FIRSTNAME");
        return false;
        }
        
        if(((JTextField)sched.getDateEditor().getUiComponent()).getText().isEmpty()
        ) 
        {
         JOptionPane.showMessageDialog(this, "Date should be filled");
        } else {
    
         }
          return true;  
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
        db = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        blotter = new javax.swing.JTable();
        add = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        print = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        delete = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        update = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cano = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        accus = new javax.swing.JTextField();
        sched = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        clastn = new javax.swing.JTextField();
        cfname = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        rlastn = new javax.swing.JTextField();
        rfname = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        stat = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        db.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/blotter (1).png"))); // NOI18N
        jPanel2.add(db, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 50));

        jLabel24.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("BLOTTER");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 120, 50));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 10, 190, 50);

        blotter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blotterMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(blotter);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 850, 160);

        add.setBackground(new java.awt.Color(255, 153, 153));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ADD");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        add.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 80, 40));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/add (1).png"))); // NOI18N
        add.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jPanel1.add(add);
        add.setBounds(20, 240, 130, 40);

        print.setBackground(new java.awt.Color(255, 153, 153));
        print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PRINT");
        print.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 80, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/print1 (1).png"))); // NOI18N
        print.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jPanel1.add(print);
        print.setBounds(720, 20, 130, 40);

        delete.setBackground(new java.awt.Color(255, 153, 153));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });
        delete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/delete (1).png"))); // NOI18N
        delete.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("DELETE");
        delete.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 80, 40));

        jPanel1.add(delete);
        delete.setBounds(300, 240, 130, 40);

        update.setBackground(new java.awt.Color(255, 153, 153));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });
        update.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/edit (1).png"))); // NOI18N
        update.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel13.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("UPDATE");
        update.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 80, 40));

        jPanel1.add(update);
        update.setBounds(160, 240, 130, 40);

        jLabel15.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("ID:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(20, 300, 140, 30);

        id.setEditable(false);
        id.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jPanel1.add(id);
        id.setBounds(160, 300, 280, 30);

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Case No.");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 340, 140, 30);

        cano.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jPanel1.add(cano);
        cano.setBounds(160, 340, 280, 30);

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Accusation:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 380, 140, 30);

        accus.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jPanel1.add(accus);
        accus.setBounds(160, 380, 280, 30);
        jPanel1.add(sched);
        sched.setBounds(160, 420, 280, 30);

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Schedule:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 420, 140, 30);

        jLabel16.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel16.setText("Complainant:(LNAME)");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(450, 290, 140, 30);

        jLabel17.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("(FIRST NAME)");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(490, 330, 100, 30);

        clastn.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jPanel1.add(clastn);
        clastn.setBounds(590, 290, 280, 30);

        cfname.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jPanel1.add(cfname);
        cfname.setBounds(590, 330, 280, 30);

        jLabel18.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel18.setText("Respondent:(LNAME)");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(460, 370, 130, 30);

        rlastn.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jPanel1.add(rlastn);
        rlastn.setBounds(590, 370, 280, 30);

        rfname.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jPanel1.add(rfname);
        rfname.setBounds(590, 410, 280, 30);

        jLabel20.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("(FIRST NAME)");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(490, 410, 100, 30);

        stat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Settled", "On-going Settled", "Settled" }));
        jPanel1.add(stat);
        stat.setBounds(590, 450, 280, 30);

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel1.setText("Status:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(490, 450, 100, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        add.setBackground(navcolor);
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        add.setBackground(headcolor);
    }//GEN-LAST:event_addMouseExited

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
       if (validation () == true){
         add();
     }
    }//GEN-LAST:event_addMouseClicked

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        delete.setBackground(navcolor);
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        int rowIndex = blotter.getSelectedRow();
       if(rowIndex < 0){
           JOptionPane.showMessageDialog(null, "Please select a data first");
       }else{
            TableModel model = blotter.getModel();
            Object value = model.getValueAt(rowIndex, 0);
            String id = value.toString();
             int a=JOptionPane.showConfirmDialog(null,"Are you sure?");  
                    if(a==JOptionPane.YES_OPTION){  
                            dbconfiguration dbc = new dbconfiguration();
                            int bid = Integer.parseInt(id);
                            dbc.deleteData(bid,"blotter","b_id");
                            displayData();
                            reset();
                    }    
       }
    }//GEN-LAST:event_deleteMouseClicked

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        delete.setBackground(headcolor);
    }//GEN-LAST:event_deleteMouseExited

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
         if(validation()== true){
          update();
        }
      
    }//GEN-LAST:event_updateMouseClicked

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
       update.setBackground(navcolor); 
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        update.setBackground(headcolor);
    }//GEN-LAST:event_updateMouseExited

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void blotterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blotterMouseClicked
        table();      
    }//GEN-LAST:event_blotterMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField accus;
    private javax.swing.JPanel add;
    private javax.swing.JTable blotter;
    public javax.swing.JTextField cano;
    public javax.swing.JTextField cfname;
    public javax.swing.JTextField clastn;
    private javax.swing.JLabel db;
    private javax.swing.JPanel delete;
    public javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel print;
    public javax.swing.JTextField rfname;
    public javax.swing.JTextField rlastn;
    public static com.toedter.calendar.JDateChooser sched;
    public javax.swing.JComboBox<String> stat;
    private javax.swing.JPanel update;
    // End of variables declaration//GEN-END:variables
}
