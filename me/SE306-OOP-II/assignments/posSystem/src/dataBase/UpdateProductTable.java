package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProductTable {

/*	public void insertIntoProductTable(int id, String name, String category,double price,double quantity) {
        String sql = "INSERT INTO " + "ProductTable"+ " (id,name,category,price,quantity) VALUES(?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, category);
            pstmt.setDouble(4, price);
            pstmt.setDouble(5, quantity);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }  */
	
	
	public void updateIdProductTable(int id){
		String sql = "UPDATE " + "ProductTable"+ " SET  id = ? ";
		 
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
	
	
	public void updateNameProductTable(String name){
		String sql = "UPDATE " + "ProductTable"+ " SET  name = ? ";
		 
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
	
	
	public void updateCategoryProductTable(String category){
		String sql = "UPDATE " + "ProductTable"+ " SET  category = ? ";
		 
        try (Connection conn = new POSdatabase().connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, category);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        }
		
	}
	
	
	
	public void updatePriceProductTable(double price){
		String sql = "UPDATE " + "ProductTable"+ " SET  price = ? ";
		 
        try (Connection conn = new POSdatabase().connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setDouble(1, price);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        }
		
	}
	

	public void updateQuantityProductTable(double quantity){
		String sql = "UPDATE " + "ProductTable"+ " SET  quantity = ? ";
		 
        try (Connection conn = new POSdatabase().connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setDouble(1, quantity);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        }
		
	}
	

	
	
}
