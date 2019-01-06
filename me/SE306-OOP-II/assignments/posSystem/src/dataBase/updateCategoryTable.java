package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateCategoryTable {

/*	
  String sql = "UPDATE " + "ProductTable"+ " SET  id = ? ";
		 
        try (Connection conn = new POSdatabase().connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, id);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        } */
	
	
	public void updateIdCategoryTable(int id){
		String sql = "UPDATE " + "CategoryTable"+ " SET  id = ? ";
		 
        try (Connection conn = new POSdatabase().connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, id);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        }
		
		
	}
	
	public void updateNameCategoryTable(String name){
		String sql = "UPDATE " + "CategoryTable"+ " SET  name = ? ";
		 
        try (Connection conn = new POSdatabase().connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, name);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        }
	}
	
}
