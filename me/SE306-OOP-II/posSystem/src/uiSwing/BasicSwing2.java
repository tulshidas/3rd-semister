package uiSwing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BasicSwing2 {
	
	public BasicSwing2(String info) {
		// TODO Auto-generated constructor stub
		JFrame mainframe= new JFrame("New Swing Example");  
		mainframe.setSize(500, 500);
		mainframe.setLayout(new FlowLayout());
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Welcome " + info);
		mainframe.add(nameLabel);
		
		mainframe.setVisible(true);
		
	}

}
