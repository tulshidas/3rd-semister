package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CustomerWindow {
	private JFrame frame;

	public CustomerWindow() {
		makeFrame();
		makeTitle();
		makeProductTableViewerButton();
		makeCustomerTableViewerButton();
		makeCategoryTableViewerButton();

		frame.setVisible(true);

	}
	
	private void makeTitle() {
		JLabel titleLabel = new JLabel("Customer");
		titleLabel.setBackground(Color.RED);
		titleLabel.setForeground(Color.BLUE);
		//titleLabel.setOpaque(true);
		titleLabel.setBounds(610, 10, 350, 90);
		titleLabel.setFont(new Font("Sherif",Font.BOLD,40));
		frame.add(titleLabel);
	}

	private void makeCategoryTableViewerButton() {
		JButton categoryTableViewerButton = new JButton("Show categories");
		categoryTableViewerButton.setForeground(Color.RED);
		categoryTableViewerButton.setBounds(600,250,200,40);
		categoryTableViewerButton.setFont(new Font("Sherif",Font.BOLD,20));
		categoryTableViewerButton.setFocusPainted(false);
		categoryTableViewerButton.setBackground(Color.blue);
		categoryTableViewerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//new customerWindow();
			}
		});

		
		frame.add(categoryTableViewerButton);
		
	}

	private void makeCustomerTableViewerButton() {
		JButton customerTableViewerButton = new JButton("Show customers");
		customerTableViewerButton.setForeground(Color.RED);
		customerTableViewerButton.setBounds(600,190,200,40);
		customerTableViewerButton.setFont(new Font("Sherif",Font.BOLD,20));
		customerTableViewerButton.setFocusPainted(false);
		customerTableViewerButton.setBackground(Color.blue);
		customerTableViewerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//new customerWindow();
			}
		});
		
		frame.add(customerTableViewerButton);
		
		
	}

	private void makeProductTableViewerButton() {
		JButton productSearcherButton = new JButton("Show Products");
		productSearcherButton.setForeground(Color.RED);
		productSearcherButton.setBounds(600,130,200,40);
		productSearcherButton.setFont(new Font("Sherif",Font.BOLD,20));
		productSearcherButton.setFocusPainted(false);
		productSearcherButton.setBackground(Color.blue);
		productSearcherButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//new ProductWindow();
			}
		});

		
		frame.add(productSearcherButton);
		
	}

	private void makeFrame() {
		frame = new JFrame("Seller");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
