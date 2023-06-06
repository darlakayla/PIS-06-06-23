package internalPages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import internalPages.Household;
import internalPages.Resident;
import internalPages.settings;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import myapp.loginForm;

/**
 *
 * @author SCC-COLLEGE
 */
public class dashBoard extends javax.swing.JFrame {

    /**
     * Creates new form dashBoard
     */
    public dashBoard() {
        initComponents();
        
        showDate(); // Class para sa Date
        showTime(); // Class para sa Time
    }
    
    Color navcolor= new Color(255,102,102);
    Color headcolor= new Color(255,153,153);
    Color bodycolor = new Color(255,204,204);

    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy");
        date.setText("Date: " + s.format(d));
    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
        time.setText("Time: " + s.format(d));
            }
            
        }
        ).start();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        navbar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        firstname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        household = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        db3 = new javax.swing.JLabel();
        resident = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        db = new javax.swing.JLabel();
        managehousehold = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        db2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        printreports = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        db4 = new javax.swing.JLabel();
        dashboard = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        db1 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        db5 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        maindesktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        navbar.setBackground(new java.awt.Color(255, 102, 102));
        navbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/userr.png"))); // NOI18N
        navbar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 200, 50));

        firstname.setBackground(new java.awt.Color(255, 102, 102));
        firstname.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        firstname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        navbar.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 180, 30));

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ADMIN");
        navbar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 20));

        household.setBackground(new java.awt.Color(255, 102, 102));
        household.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                householdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                householdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                householdMouseExited(evt);
            }
        });
        household.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("HOUSEHOLD");
        household.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 120, 50));

        db3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/newr (1).png"))); // NOI18N
        household.add(db3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        navbar.add(household, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, 50));

        resident.setBackground(new java.awt.Color(255, 102, 102));
        resident.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                residentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                residentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                residentMouseExited(evt);
            }
        });
        resident.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("RESIDENT");
        resident.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 130, 40));

        db.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        db.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/resrec (1).png"))); // NOI18N
        resident.add(db, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 50));

        navbar.add(resident, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 50));

        managehousehold.setBackground(new java.awt.Color(255, 102, 102));
        managehousehold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                managehouseholdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                managehouseholdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                managehouseholdMouseExited(evt);
            }
        });
        managehousehold.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MANAGE");
        managehousehold.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 120, 30));

        jLabel12.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("HOUSEHOLD");
        managehousehold.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 120, 30));

        db2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/home (1).png"))); // NOI18N
        managehousehold.add(db2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        navbar.add(managehousehold, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 200, 50));

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("WELCOME!");
        navbar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, 20));

        printreports.setBackground(new java.awt.Color(255, 102, 102));
        printreports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printreportsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printreportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printreportsMouseExited(evt);
            }
        });
        printreports.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("REPORTS");
        printreports.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 120, 30));

        jLabel15.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("PRINT");
        printreports.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 120, 30));

        db4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/print1 (2).png"))); // NOI18N
        printreports.add(db4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 50));

        navbar.add(printreports, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, -1, 50));

        dashboard.setBackground(new java.awt.Color(255, 102, 102));
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardMouseExited(evt);
            }
        });
        dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DASHBOARD");
        dashboard.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 120, 30));

        db1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/db (1).png"))); // NOI18N
        dashboard.add(db1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        navbar.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, 50));

        logout.setBackground(new java.awt.Color(255, 102, 102));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });
        logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("LOGOUT");
        logout.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 120, 30));

        db5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/logout (1).png"))); // NOI18N
        logout.add(db5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 60, 50));

        navbar.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 200, 50));

        jPanel1.add(navbar);
        navbar.setBounds(0, 0, 200, 560);

        header.setBackground(new java.awt.Color(255, 153, 153));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        header.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 34, 30));

        minimize.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("—");
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        header.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 30, 40));

        time.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        time.setText("TIME");
        header.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 220, 30));

        date.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        date.setText("DATE");
        header.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 220, 30));

        jPanel1.add(header);
        header.setBounds(150, 0, 930, 50);

        maindesktop.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PUROK");
        maindesktop.add(jLabel1);
        jLabel1.setBounds(30, 180, 860, 50);

        jLabel6.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SYSTEM");
        maindesktop.add(jLabel6);
        jLabel6.setBounds(30, 300, 880, 50);

        jLabel7.setFont(new java.awt.Font("Goudy Stout", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("INFORMATION");
        maindesktop.add(jLabel7);
        jLabel7.setBounds(30, 240, 860, 50);

        jPanel1.add(maindesktop);
        maindesktop.setBounds(200, 50, 880, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1074, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseEntered
      dashboard.setBackground(bodycolor);
    }//GEN-LAST:event_dashboardMouseEntered

    private void dashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseExited
      dashboard.setBackground(navcolor);
    }//GEN-LAST:event_dashboardMouseExited

    private void dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseClicked
       dbPage bp = new dbPage();
       maindesktop.add(bp).setVisible(true);
    }//GEN-LAST:event_dashboardMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        int a=JOptionPane.showConfirmDialog(null, "Confirm Exit?");
        if(a==JOptionPane.YES_OPTION){
            System.exit(0);
        }
                
    }//GEN-LAST:event_exitMouseClicked

    private void householdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_householdMouseClicked
       Household nr = new Household();
       maindesktop.add(nr).setVisible(true);
    }//GEN-LAST:event_householdMouseClicked

    private void householdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_householdMouseEntered
        household.setBackground(bodycolor);
    }//GEN-LAST:event_householdMouseEntered

    private void householdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_householdMouseExited
        household.setBackground(navcolor);
    }//GEN-LAST:event_householdMouseExited

    private void residentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_residentMouseClicked
        Resident hh = new Resident();
        maindesktop.add(hh).setVisible(true);
    }//GEN-LAST:event_residentMouseClicked

    private void residentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_residentMouseEntered
        resident.setBackground(bodycolor);
    }//GEN-LAST:event_residentMouseEntered

    private void residentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_residentMouseExited
        resident.setBackground(navcolor);
    }//GEN-LAST:event_residentMouseExited

    private void managehouseholdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managehouseholdMouseClicked
        manageHousehold mh = new manageHousehold();
        maindesktop.add(mh).setVisible(true);
    }//GEN-LAST:event_managehouseholdMouseClicked

    private void managehouseholdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managehouseholdMouseEntered
        managehousehold.setBackground(bodycolor);
    }//GEN-LAST:event_managehouseholdMouseEntered

    private void managehouseholdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managehouseholdMouseExited
        managehousehold.setBackground(navcolor);
    }//GEN-LAST:event_managehouseholdMouseExited

    private void printreportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printreportsMouseClicked
        printReports br = new printReports();
        maindesktop.add(br).setVisible(true);
    }//GEN-LAST:event_printreportsMouseClicked

    private void printreportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printreportsMouseEntered
        printreports.setBackground(bodycolor);
    }//GEN-LAST:event_printreportsMouseEntered

    private void printreportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printreportsMouseExited
        printreports.setBackground(navcolor);
    }//GEN-LAST:event_printreportsMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        loginForm lf = new loginForm();
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        logout.setBackground(bodycolor);
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        logout.setBackground(navcolor);
    }//GEN-LAST:event_logoutMouseExited

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
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel date;
    private javax.swing.JLabel db;
    private javax.swing.JLabel db1;
    private javax.swing.JLabel db2;
    private javax.swing.JLabel db3;
    private javax.swing.JLabel db4;
    private javax.swing.JLabel db5;
    private javax.swing.JLabel exit;
    public static javax.swing.JLabel firstname;
    private javax.swing.JPanel header;
    private javax.swing.JPanel household;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel logout;
    public javax.swing.JDesktopPane maindesktop;
    private javax.swing.JPanel managehousehold;
    private javax.swing.JLabel minimize;
    private javax.swing.JPanel navbar;
    private javax.swing.JPanel printreports;
    private javax.swing.JPanel resident;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
