package dataBase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class POSdatabase {
	
	final private String dbName = "bsse08.db"; 
	final private String url = "jdbc:sqlite:db_file/"+dbName;
	private String tableName;// = "OOC2_Results";

    public Connection connect() {
        // SQLite connection string
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void createNewDatabase() {
   	 
      try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }   //database created so it can't be created twice
    
    
    public void createNewCustomerTable() {
       // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS " + "CustomerTable"+ " (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text,\n"
                + "	phone text,\n"
                +" balence real NOT NULL,\n"
                +"type text NOT NULL,\n"
                +"password text NOT NULL,\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("Table created sucessfully.");
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertIntoCustomerTable(int id, String name, String phone,double balance,String type,char[] password) {
        String sql = "INSERT INTO " + "CustomerTable"+ " (id,name,phone,balance,type,password) VALUES(?,?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            pstmt.setDouble(4, balance);
            pstmt.setString(5, type);
            pstmt.setString(6, String.valueOf(password));
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void createNewProductTable() {
        // SQL statement for creating a new table
    	/* private String id;
	private String name;
	private Category category;
	private double price;
	private double quantity;*/
         String sql = "CREATE TABLE IF NOT EXISTS " + "ProductTable"+ " (\n"
                 + "	id integer PRIMARY KEY,\n"
                 + "	name text,\n"
                 + "	category text,\n"
                 +" price real NOT NULL,\n"
                 +"quantity real NOT NULL,\n"
                 + ");";
         
         try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {
             // create a new table
             stmt.execute(sql);
             System.out.println("Table created sucessfully.");
             System.out.println(sql);
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
     }
    
    
    public void insertIntoProductTable(int id, String name, String category,double price,double quantity) {
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
    }
    
    
    public void loadProductsToTableModel(DefaultTableModel model){
        String sql = "SELECT id, name,category,price,quantity FROM " + "ProductTable" + "";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
            	model.addRow(new Object[]{String.valueOf(rs.getInt("id")),rs.getString("name"),rs.getString("category"),String.valueOf(rs.getDouble("price")),String.valueOf(rs.getDouble("quantity"))});
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

    
    
    
    public void createNewCategoryTable() {
        // SQL statement for creating a new table
         String sql = "CREATE TABLE IF NOT EXISTS " + "CategoryTable"+ " (\n"
                 + "	id integer PRIMARY KEY,\n"
                 + "	name text,\n"
                 + ");";
         
         try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {
             // create a new table
             stmt.execute(sql);
             System.out.println("Category Table created sucessfully.");
             System.out.println(sql);
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
     }
    
    
    public void insertIntoCategoryTable(int id, String name) {
        String sql = "INSERT INTO " + "CategoryTable"+ " (id,name) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void createNewManagementTable() {
        // SQL statement for creating a new table
         String sql = "CREATE TABLE IF NOT EXISTS " + "ManagementTable"+ " (\n"
                 + "	CustomerId integer PRIMARY KEY,\n"
                 + "	ProductId integer,\n"
                 + "	TotalUnit integer,\n"
                 +" 	TotalPrice real NOT NULL,\n"
                 + ");";
         
         try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {
             // create a new table
             stmt.execute(sql);
             System.out.println("Table created sucessfully.");
             System.out.println(sql);
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
     }
    
    
    public void insert(int roll, String name, double lab,double mid,double Final,double Total) {
        String sql = "INSERT INTO " + tableName+ " (roll,name,lab,mid,Final,Total) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, roll);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
/*    public void selectAll(){
        String sql = "SELECT id, name, points FROM " + tableName+ "";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("points"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
 */
    
    
    
    
    public void getpointsGreaterThan(double points){
        String sql = "SELECT id, name, points "
                   + "FROM " + tableName+ " WHERE points > ?";
 
		 try (Connection conn = this.connect();
		      PreparedStatement pstmt  = conn.prepareStatement(sql)){
		     
		     // set the value
			 pstmt.setDouble(1,points);
			 //
			 ResultSet rs  = pstmt.executeQuery();
			 
			 // loop through the result set
			 while (rs.next()) {
			     System.out.println(rs.getInt("id") +  "\t" + 
			                    rs.getString("name") + "\t" +
			                    rs.getDouble("points"));
			 }
		 } catch (SQLException e) {
		     System.out.println(e.getMessage());
		 }
    }
    
    public void update(int id, String name, double points) {
        String sql = "UPDATE " + tableName+ " SET name = ? , "
                + "points = ? "
                + "WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setDouble(2, points);
            pstmt.setInt(3, id);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM " + tableName+ " WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
