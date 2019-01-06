package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCustomerClass {

	public void UpdateIdCustomerClass(int id) {
		
		String sql = "UPDATE " + "CustomerTable"+ " SET  id = ? ";
 
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
	
	public void UpdateNameCustomerClass(String name) {
		String sql = "UPDATE " + "CustomerTable"+ " SET  name = ? ";
		 
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
	
	public void UpdatePhoneCustomerClass(String phone) {
		String sql = "UPDATE " + "CustomerTable"+ " SET  phone = ? ";
		 
        try (Connection conn = new POSdatabase().connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, phone);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void UpdateBalanceCustomerClass(double balance) {
		String sql = "UPDATE " + "CustomerTable"+ " SET  balance = ? ";
		 
        try (Connection conn = new POSdatabase().connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setDouble(1, balance);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	
	}
	
	public void UpdateTypeCustomerClass(String type) {
	
		String sql = "UPDATE " + "CustomerTable"+ " SET  type = ? ";
		 
        try (Connection conn = new POSdatabase().connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, type);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	
	}
	
	public void UpdatePasswordCustomerClass(char [] password) {
		String sql = "UPDATE " + "CustomerTable"+ " SET  password = ? ";
		 
        try (Connection conn = new POSdatabase().connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, String.valueOf(password));
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	
	
	}
	
	
	
	
}
