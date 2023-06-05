
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.JOptionPane;


public class dbconfiguration {
    public Connection connection;
    
   
    
    public dbconfiguration(){
        try{
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/purokinformationsystem", "root", "");
            }catch(SQLException e){
                System.err.println("Cannot connect to database: " + e.getMessage());
            }      
        
        
}
    public Connection connect_db(){
              try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/purokinformationsystem", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
              return connection;
        }

    public ResultSet getData(String sql) throws SQLException {
        Statement stmt = (Statement) connection.createStatement();
        ResultSet rst = stmt.executeQuery(sql);   
        return rst;
    }
    

    public int insertData(String sql){
       int result;
       try{
           PreparedStatement pstmt = connection.prepareStatement(sql);
           
           pstmt.executeUpdate();
           System.out.println("Inserted Succesfully!");
           pstmt.close();
           result = 1;
       }catch(SQLException e){ 
           System.out.println("Connection Error."+e);
           result = 0;
       }
       return result;
    }
    
    public void deleteData(int id, String table){
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM tbl_residentrecords WHERE rr_id=?");
            stmt.setInt(1,id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0){
               JOptionPane.showMessageDialog(null, "Deleted Succesfully!");               
            }else{
                System.out.println("Deletion Failed!");
            }
            stmt.close();                 
        }catch(SQLException ex){
            System.out.println("Connection Error:" +ex);
        }
        
    }
        public void updateData(String sql){        
          try{
              
              PreparedStatement pstmt = connection.prepareStatement(sql);
              int rowsUpdated = pstmt.executeUpdate();
              if(rowsUpdated >0){
                  JOptionPane.showMessageDialog(null, "Data Updated Succesfully!");                                 
          }else{
                  System.out.println("Data Update Failed!");                
             }
             pstmt.close();
          }catch (SQLException ex){
              System.out.println("Connction Error:"+ex);
         }
     
        }
        
    public void deleteData(int id, String table, String table_id){
            try{
                PreparedStatement pst = connection.prepareStatement("DELETE FROM "+table+" WHERE "+table_id+" = ?");
                pst.setInt(1, id);
                int rowsDeleted = pst.executeUpdate();
                    if(rowsDeleted > 0){
                        JOptionPane.showMessageDialog(null, "Deleted Successfully!");
                    }else{
                        System.out.println("Deletion Failed!");
                    }
                    pst.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Data cannot be deleted\nContact the administrator.");
            }
        }
        
     
     public void deLeteData(int id, String table){
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM tbl_blotterreports WHERE br_id=?");
            stmt.setInt(1,id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0){
               JOptionPane.showMessageDialog(null, "Deleted Succesfully!");               
            }else{
                System.out.println("Deletion Failed!");
            }
            stmt.close();                 
        }catch(SQLException ex){
            System.out.println("Connection Error:" +ex);
        }
        
    }
     
     public void deleteeData(int id, String table){
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM blotter WHERE b_id=?");
            stmt.setInt(1,id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0){
               JOptionPane.showMessageDialog(null, "Deleted Succesfully!");               
            }else{
                System.out.println("Deletion Failed!");
            }
            stmt.close();                 
        }catch(SQLException ex){
            System.out.println("Connection Error:" +ex);
        }
        
    }
     
     
     public int updatedData(String sql){
        int num = 0;
        try {
       
            String query = sql;
            PreparedStatement pstmt = connection.prepareStatement(query);
            int rowsUpdated = pstmt.executeUpdate();
            if(rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
                num = 1;
            } else {
                System.out.println("Data update failed!");
                num = 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return num;
    }
    
}
        
