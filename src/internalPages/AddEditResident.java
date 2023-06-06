package internalPages;

import config.dbconfiguration;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class AddEditResident extends javax.swing.JFrame {
    
    
    
    
    public AddEditResident() {
        initComponents();                 
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
        Resident rr = new Resident();
        db.maindesktop.add(rr).setVisible(true);
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
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<>();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        occupation = new javax.swing.JTextField();
        add1 = new javax.swing.JPanel();
        st_label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        image1 = new javax.swing.JLabel();
        remove = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel9.setText("RESIDENT FORM");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 280, 40));

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
        jPanel2.setBounds(-10, 0, 1090, 60);

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setText("Resident ID:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 100, 120, 30);

        id.setEditable(false);
        id.setBackground(new java.awt.Color(255, 153, 153));
        id.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        id.setEnabled(false);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel1.add(id);
        id.setBounds(150, 100, 350, 30);

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setText("Lastname:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 150, 120, 30);

        lastname.setBackground(new java.awt.Color(255, 153, 153));
        lastname.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        jPanel1.add(lastname);
        lastname.setBounds(150, 150, 350, 30);

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel5.setText("Firstname:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 200, 120, 30);

        firstname.setBackground(new java.awt.Color(255, 153, 153));
        firstname.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        jPanel1.add(firstname);
        firstname.setBounds(150, 200, 350, 30);

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel6.setText("Address:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 250, 120, 30);

        address.setBackground(new java.awt.Color(255, 153, 153));
        address.setColumns(20);
        address.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(150, 250, 350, 110);

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel7.setText("Status:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 370, 110, 30);

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setText("Gender:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 410, 110, 30);

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel8.setText("Contact No:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(560, 340, 110, 30);

        contact.setBackground(new java.awt.Color(255, 153, 153));
        contact.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        jPanel1.add(contact);
        contact.setBounds(670, 340, 320, 30);

        status.setBackground(new java.awt.Color(255, 153, 153));
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Widowed", "Divorced", "Separated" }));
        jPanel1.add(status);
        status.setBounds(150, 370, 350, 30);

        male.setBackground(new java.awt.Color(255, 153, 153));
        male.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        jPanel1.add(male);
        male.setBounds(150, 410, 150, 30);

        female.setBackground(new java.awt.Color(255, 153, 153));
        female.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        jPanel1.add(female);
        female.setBounds(340, 410, 160, 30);

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel10.setText("Email:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(560, 380, 110, 30);

        email.setBackground(new java.awt.Color(255, 153, 153));
        email.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email);
        email.setBounds(670, 380, 320, 30);

        jLabel11.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel11.setText("Occupation:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(560, 420, 110, 30);

        occupation.setBackground(new java.awt.Color(255, 153, 153));
        occupation.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        occupation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                occupationActionPerformed(evt);
            }
        });
        jPanel1.add(occupation);
        occupation.setBounds(670, 420, 320, 30);

        add1.setBackground(new java.awt.Color(255, 153, 153));
        add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add1MouseExited(evt);
            }
        });
        add1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        st_label.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        st_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        st_label.setText("LABEL");
        add1.add(st_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jPanel1.add(add1);
        add1.setBounds(930, 470, 100, 30);

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 0, 190, 200));

        image1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/added (2).png"))); // NOI18N
        jPanel3.add(image1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 200, 200));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(740, 80, 240, 200);

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
        remove.setBounds(770, 290, 170, 30);

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

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        male.setSelected(false);
        if(female.isSelected()){
            gender = "Female";
        }else{
            gender = null;
        }
        
    }//GEN-LAST:event_femaleActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        female.setSelected(false);
        if(male.isSelected()){
            gender = "Male";
        }else{
            gender = null;
        }
    }//GEN-LAST:event_maleActionPerformed

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        close();
        
    }//GEN-LAST:event_exitMouseClicked

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void occupationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_occupationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_occupationActionPerformed

    private void add1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseEntered
        add1.setBackground(navcolor);
    }//GEN-LAST:event_add1MouseEntered

    private void add1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseExited
        add1.setBackground(headcolor);
    }//GEN-LAST:event_add1MouseExited

    private void add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseClicked

        if(lastname.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Lastname!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(firstname.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Firstname!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(address.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Address!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Validate JComboBox
        if (status.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Please select your Status!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Validate JRadioButtons
        if (!male.isSelected() && !female.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select your gender!.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        if (contact.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Contact!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(email.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Email!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(occupation.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type your Occupation!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        if(action.equals("Add")){
           dbconfiguration dbc = new dbconfiguration();
           int result=0;
           try{
            
            String sql = "INSERT INTO tbl_residentrecords ( rr_lastname, rr_firstname, rr_address, rr_status, rr_gender, rr_contact, rr_email, rr_occupation, rr_image) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = dbc.connection.prepareStatement(sql);
           
            pst.setString(1, lastname.getText());
            pst.setString(2, firstname.getText());
            pst.setString(3, address.getText());
            pst.setString(4, status.getSelectedItem().toString());
            pst.setString(5, gender);                   
            pst.setString(6, contact.getText());
            pst.setString(7, email.getText());
            pst.setString(8, occupation.getText());         
            pst.setString(9, destination);
            
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
           String sql = "UPDATE tbl_residentrecords SET  rr_lastname = ?, rr_firstname = ?, rr_address = ?, rr_status = ?, rr_gender = ?, rr_contact = ?, rr_email = ?, rr_occupation = ?,  rr_image = ?  WHERE rr_id = '"+id.getText()+"'";
           PreparedStatement pst = dbc.connection.prepareStatement(sql);        
            pst.setString(1, firstname.getText());
            pst.setString(2, lastname.getText());
            pst.setString(3, address.getText());
            pst.setString(4, status.getSelectedItem().toString());
            pst.setString(5, gender);
            pst.setString(6, contact.getText());        
            pst.setString(7, email.getText());
            pst.setString(8, occupation.getText());
            pst.setString(9, destination);
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
         
    }//GEN-LAST:event_add1MouseClicked

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
        remove.setVisible(false);
        image.setIcon(null);
        destination = "";
        path="";
    }//GEN-LAST:event_removeMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
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
    }//GEN-LAST:event_jPanel3MouseClicked

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
            java.util.logging.Logger.getLogger(AddEditResident.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEditResident.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEditResident.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEditResident.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new AddEditResident().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add1;
    public javax.swing.JTextArea address;
    public javax.swing.JTextField contact;
    public javax.swing.JTextField email;
    private javax.swing.JLabel exit;
    public javax.swing.JRadioButton female;
    public javax.swing.JTextField firstname;
    public javax.swing.JTextField id;
    public javax.swing.JLabel image;
    public javax.swing.JLabel image1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField lastname;
    public javax.swing.JRadioButton male;
    private javax.swing.JLabel minimize;
    public javax.swing.JTextField occupation;
    public javax.swing.JLabel remove;
    public javax.swing.JLabel st_label;
    public javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
