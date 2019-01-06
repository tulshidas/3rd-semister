package lab;

import java.util.Scanner;

import database.POSdatabase;
public class Seller {
	private POSdatabase dbTest = new POSdatabase();
	Scanner input = new Scanner(System.in);
	
	public void createCustomerTable(){
		dbTest.createNewCustomerTable();
		
	}
	
	public void createProductTable() {
		dbTest.createNewProductTable();
		
	}
	public void createManagementTable(){
		dbTest.createNewManagementTable();
	}

	
	
	
}
