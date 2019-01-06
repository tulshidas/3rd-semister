package system;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dataBase.POSdatabase;

public class ProductWindow {
	DefaultTableModel model;
	JTable productTable;
	JFrame frame;
	
	public ProductWindow() {
		makeFrame();
		prepareTable();
		addTableToFrame();
		makeProductPurchasingCheckBox();
		
		
	}
	private void makeProductPurchasingCheckBox() {
		//unemplemented;
	}
	private void addTableToFrame() {
	//	 frame.add(new JScrollPane(productTable).);
		
	}
	private void makeFrame() {
		frame = new JFrame("Products");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private void prepareTable() {
		model = new DefaultTableModel();
		new POSdatabase().loadProductsToTableModel(model);
		productTable = new JTable(model);
		
	}
}
