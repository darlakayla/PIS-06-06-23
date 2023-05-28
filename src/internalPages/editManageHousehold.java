/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;
import javax.swing.JOptionPane;
import config.dbconfiguration;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author HP
 */
public class editManageHousehold extends javax.swing.JFrame {
 
    public editManageHousehold() {     
       initComponents();
       remove.setVisible(false);
    }
    
        public String destination = "";
        File selectedFile;
        public String oldpath;
        String path;
    
   
        public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: ");
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
        
        public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
        
    
        public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
        ImageIcon MyImage = null;
            if(ImagePath !=null){
                MyImage = new ImageIcon(ImagePath);
            }else{
                MyImage = new ImageIcon(pic);
            }
        
        int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
}
        public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/images", fileName);
        boolean fileExists = Files.exists(filePath);
        
            if (fileExists) {
                return 1;
            }else {
                return 0;
            }   
    }
    
    
    public void close(){
        this.dispose();
        dashBoard db = new dashBoard();
        db.setVisible(true);
        manageHousehold mh = new manageHousehold();
        db.maindesktop.add(mh).setVisible(true);
    }
    
        Color navcolor= new Color(255,102,102);
        Color headcolor= new Color(255,153,153);
        Color bodycolor = new Color(255,204,204);
    
    
    
        public String gender;
        public String action;
    
    

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
        jLabel9 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        female = new javax.swing.JRadioButton();
        add = new javax.swing.JPanel();
        st_label1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        spouse = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        status = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        birthdate = new javax.swing.JTextField();
        occupation = new javax.swing.JTextField();
        remove = new javax.swing.JLabel();
        numbers = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        ages = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        purokname = new javax.swing.JTextField();
        JPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        image1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("HOUSEHOLD FORM");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 50));

        exit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        jPanel2.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 40, 30));

        minimize.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("—");
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        jPanel2.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 40, 40));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(-10, 0, 1090, 50);

        female.setBackground(new java.awt.Color(255, 153, 153));
        female.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        jPanel1.add(female);
        female.setBounds(320, 280, 170, 30);

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

        st_label1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        st_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        st_label1.setText("LABEL");
        add.add(st_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jPanel1.add(add);
        add.setBounds(930, 480, 100, 30);

        jLabel13.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel13.setText("Gender");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(20, 280, 130, 30);

        lastname.setBackground(new java.awt.Color(255, 153, 153));
        lastname.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        jPanel1.add(lastname);
        lastname.setBounds(150, 160, 340, 30);

        jLabel15.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel15.setText("Last Name:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(20, 160, 130, 30);

        jLabel16.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel16.setText("Spouse Name:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(20, 240, 130, 30);

        spouse.setBackground(new java.awt.Color(255, 153, 153));
        spouse.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        spouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spouseActionPerformed(evt);
            }
        });
        jPanel1.add(spouse);
        spouse.setBounds(150, 240, 340, 30);

        jLabel17.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel17.setText("Household ID:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(20, 80, 130, 30);

        id.setEditable(false);
        id.setBackground(new java.awt.Color(255, 153, 153));
        id.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel1.add(id);
        id.setBounds(150, 80, 340, 30);

        male.setBackground(new java.awt.Color(255, 153, 153));
        male.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        jPanel1.add(male);
        male.setBounds(150, 280, 160, 30);

        status.setBackground(new java.awt.Color(255, 153, 153));
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Divorced", "Separated", "Widowed" }));
        jPanel1.add(status);
        status.setBounds(150, 320, 340, 30);

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Status:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 320, 130, 30);

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Birthdate:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 360, 130, 30);

        birthdate.setBackground(new java.awt.Color(255, 153, 153));
        birthdate.setFont(new java.awt.Font("Baskerville Old Face", 0, 15)); // NOI18N
        jPanel1.add(birthdate);
        birthdate.setBounds(150, 360, 340, 30);

        occupation.setBackground(new java.awt.Color(255, 153, 153));
        occupation.setFont(new java.awt.Font("Baskerville Old Face", 0, 15)); // NOI18N
        jPanel1.add(occupation);
        occupation.setBounds(710, 320, 320, 30);

        remove.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        remove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        remove.setText("REMOVE");
        remove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
        });
        jPanel1.add(remove);
        remove.setBounds(800, 280, 170, 30);

        numbers.setBackground(new java.awt.Color(255, 153, 153));
        numbers.setFont(new java.awt.Font("Baskerville Old Face", 0, 15)); // NOI18N
        jPanel1.add(numbers);
        numbers.setBounds(710, 400, 320, 30);

        jLabel14.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N
        jLabel14.setText("No. of Children (ALL)");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(510, 400, 200, 30);

        jLabel18.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N
        jLabel18.setText("Contact:");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(510, 360, 140, 30);

        jLabel19.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N
        jLabel19.setText("Image:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(700, 70, 70, 30);

        address.setBackground(new java.awt.Color(255, 153, 153));
        address.setColumns(20);
        address.setFont(new java.awt.Font("Baskerville Old Face", 0, 15)); // NOI18N
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(150, 400, 340, 100);

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N
        jLabel10.setText("Address:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 400, 130, 30);

        ages.setBackground(new java.awt.Color(255, 153, 153));
        ages.setFont(new java.awt.Font("Baskerville Old Face", 0, 15)); // NOI18N
        jPanel1.add(ages);
        ages.setBounds(710, 440, 320, 30);

        jLabel20.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N
        jLabel20.setText("Their ages:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(510, 440, 140, 30);

        contact.setBackground(new java.awt.Color(255, 153, 153));
        contact.setFont(new java.awt.Font("Baskerville Old Face", 0, 15)); // NOI18N
        jPanel1.add(contact);
        contact.setBounds(710, 360, 320, 30);

        jLabel21.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel21.setText("Purok Name:");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(20, 120, 130, 30);

        purokname.setBackground(new java.awt.Color(255, 153, 153));
        purokname.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        purokname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puroknameActionPerformed(evt);
            }
        });
        jPanel1.add(purokname);
        purokname.setBounds(150, 120, 340, 30);

        JPanel3.setBackground(new java.awt.Color(255, 153, 153));
        JPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPanel3MouseClicked(evt);
            }
        });
        JPanel3.setLayout(null);
        JPanel3.add(image);
        image.setBounds(20, 0, 200, 200);

        image1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/added (2).png"))); // NOI18N
        JPanel3.add(image1);
        image1.setBounds(20, 0, 200, 200);

        jPanel1.add(JPanel3);
        JPanel3.setBounds(770, 70, 240, 200);

        jLabel22.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N
        jLabel22.setText("Occupation:");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(510, 320, 140, 30);

        jLabel23.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel23.setText("First Name:");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(20, 200, 130, 30);

        firstname.setBackground(new java.awt.Color(255, 153, 153));
        firstname.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        jPanel1.add(firstname);
        firstname.setBounds(150, 200, 340, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1074, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        close();

    }//GEN-LAST:event_exitMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        male.setSelected(false);
        if(female.isSelected()){
            gender = "Female";
        }else{
            gender = null;
        }

    }//GEN-LAST:event_femaleActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        
        if (purokname.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Purok Name!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(lastname.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Lastname!", "Error", JOptionPane.ERROR_MESSAGE);
            return;            
        }else if(firstname.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Firstname!", "Error", JOptionPane.ERROR_MESSAGE);
            return;            
        }else if(spouse.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Spouse Name!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if (birthdate.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Birthdate!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(address.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Address!", "Error", JOptionPane.ERROR_MESSAGE);
            return;      
        }else if(occupation.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Occupation!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(contact.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Contact!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(numbers.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type the No. of Children!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(ages.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type their ages!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validate JRadioButtons
        if (!male.isSelected() && !female.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select your gender!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validate JComboBox
        if (status.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Please select your Status!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
             
       if(action.equals("Add")){
           dbconfiguration dbc = new dbconfiguration();
           int result=0;
           try{
            
            String sql = "INSERT INTO tbl_householdrecords (hh_purokname, hh_lastname, hh_firstname, hh_spouse, hh_gender, hh_status, hh_birthdate, hh_address, hh_occupation, hh_contact, hh_children, hh_ages, hh_image) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = dbc.connection.prepareStatement(sql);
            pst.setString(1, purokname.getText());
            pst.setString(2, lastname.getText());
            pst.setString(3, firstname.getText());
            pst.setString(4, spouse.getText());
            pst.setString(5, gender);          
            pst.setString(6, status.getSelectedItem().toString());
            pst.setString(7, birthdate.getText());
            pst.setString(8, address.getText());
            pst.setString(9, occupation.getText());
            pst.setString(10, contact.getText());
            pst.setString(11, numbers.getText());
            pst.setString(12, ages.getText());      
            pst.setString(13, destination);
            
            pst.execute();
            result = 1;
            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);        
        }catch(Exception e){
               System.out.println("Insert Image Error");
        }

           if(result == 1){
               JOptionPane.showMessageDialog(null, "Successfully Save!");
               close();
           }else{
                System.out.println("Saving Data Failed!");
           }
       }else if(action.equals("Update")){
           dbconfiguration dbc = new dbconfiguration();
           try{
           String sql = "UPDATE tbl_householdrecords SET hh_purokname = ?, hh_lastname = ?, hh_firstname = ?, hh_spouse = ?, hh_gender = ?, hh_status = ?, hh_birthdate = ?, hh_address = ?, hh_occupation = ?, hh_contact = ?, hh_children = ?, hh_ages = ?, hh_image = ?  WHERE hh_id = '"+id.getText()+"'";
           PreparedStatement pst = dbc.connection.prepareStatement(sql);
            pst.setString(1, purokname.getText());
            pst.setString(2, lastname.getText());
            pst.setString(3, firstname.getText());
            pst.setString(4, spouse.getText());
            pst.setString(5, gender);
            pst.setString(6, status.getSelectedItem().toString());
            pst.setString(7, birthdate.getText());
            pst.setString(8, address.getText());
            pst.setString(9, occupation.getText());
            pst.setString(10, contact.getText());
            pst.setString(11, numbers.getText());
            pst.setString(12, ages.getText());     
            pst.setString(13, destination);
            pst.execute();
           close();

           imageUpdater(oldpath, path);
           
           File existingFile = new File(oldpath);
            if (existingFile.exists()) {
                existingFile.delete();
            }
           
           JOptionPane.showMessageDialog(null, "Successfully Updated!");
           }catch(SQLException e){
               System.out.println("Database Connection Error!");
           }
       }else{
           JOptionPane.showMessageDialog(null, "No action selected!");
           close();
       }
       
    }//GEN-LAST:event_addMouseClicked

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        add.setBackground(navcolor);
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        add.setBackground(headcolor);
    }//GEN-LAST:event_addMouseExited

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void spouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spouseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spouseActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        
    }//GEN-LAST:event_idActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        female.setSelected(false);
        if(male.isSelected()){
            gender = "Female";
        }else{
            gender = null;
        }
    }//GEN-LAST:event_maleActionPerformed

    private void puroknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puroknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_puroknameActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void JPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPanel3MouseClicked
       JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                        
                
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/images/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            System.out.println(""+destination);
                            remove.setVisible(true);
                            remove.setText("REMOVE");
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }
    }//GEN-LAST:event_JPanel3MouseClicked

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
        remove.setVisible(false);
        image.setIcon(null);
        destination = "";
        path="";
    }//GEN-LAST:event_removeMouseClicked

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
            java.util.logging.Logger.getLogger(editManageHousehold.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editManageHousehold.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editManageHousehold.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editManageHousehold.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editManageHousehold().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel JPanel3;
    private javax.swing.JPanel add;
    public javax.swing.JTextArea address;
    public javax.swing.JTextField ages;
    public javax.swing.JTextField birthdate;
    public javax.swing.JTextField contact;
    private javax.swing.JLabel exit;
    public javax.swing.JRadioButton female;
    public javax.swing.JTextField firstname;
    public javax.swing.JTextField id;
    public javax.swing.JLabel image;
    public javax.swing.JLabel image1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField lastname;
    public javax.swing.JRadioButton male;
    private javax.swing.JLabel minimize;
    public javax.swing.JTextField numbers;
    public javax.swing.JTextField occupation;
    public javax.swing.JTextField purokname;
    public javax.swing.JLabel remove;
    public javax.swing.JTextField spouse;
    public javax.swing.JLabel st_label1;
    public javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
