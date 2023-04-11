
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class dbconfiguration {
    private Connection connection;
    
    public dbconfiguration(){
        try{
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/purokinformationsystem", "root", "");
            }catch(SQLException e){
                System.err.println("Cannot connect to database: " + e.getMessage());
            }      
}

    public ResultSet getData(String sql) throws SQLException {
        Statement stmt = (Statement) connection.createStatement();
        ResultSet rst = stmt.executeQuery(sql);   
        return rst;
    }
    
    public void filltable()throws SQLException{
        dbconfiguration dc = new dbconfiguration ();
    ResultSet rs = dc.getData("SELECT * FROM tbl_householdrecords");
    }
    public void filltables()throws SQLException{
        dbconfiguration dc = new dbconfiguration ();
    ResultSet rs = dc.getData("SELECT * FROM tbl_residentrecords,tbl_householdrecords");
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
        
     public void deletedata(int id, String table){
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM tbl_householdrecords  WHERE hh_id=?");
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
     
        
        
}
        
