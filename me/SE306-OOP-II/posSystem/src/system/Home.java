package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Home{
	
	private JFrame frame;


	public Home() {
		makeMainFrame();
		makeLogInOptions();
		makeAccountCreatorButton();
		
		frame.setVisible(true);
	}
	
	
	private void makeAccountCreatorButton() {
		JButton button = new JButton("Creat Account");
		button.setBounds(600,400,200,40);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please Wait till seller confirm you");
			}
		});
		frame.add(button);
	}


	private void makeLogInOptions() {
		makeLogInTitle();
		makeIdTextLabel();
		makeIdTextField();
		makePasswordTextLabel();
		makeCustomerPasswordField();
		makeLogInTextLabel();
		makeLogInButton();
		

	}

	private void makeLogInButton() {
		JButton logInButton = new JButton("Log In");
		logInButton.setForeground(Color.RED);
		logInButton.setBounds(950,130,80,40); 
		logInButton.setBackground(Color.blue);
		logInButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//new ProductWindow();
			}
		});
		frame.add(logInButton);
		
		
	}
	
	private void makeLogInTextLabel() {
		JLabel label = new JLabel("Log In:");
		label.setBounds(870, 100, 200, 100);
		label.setFont(new Font("Sherif",Font.PLAIN,20));
		frame.add(label);
	}


	private void makePasswordTextLabel() {
		JLabel label = new JLabel("Password:");
		label.setBounds(500, 100, 200, 100);
		label.setFont(new Font("Sherif",Font.PLAIN,20));
		frame.add(label);
		
	}


	private void makeCustomerPasswordField() {
		JPasswordField passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(610,130,208, 40);
		frame.add(passwordField);
		
		
	}


	private void makeIdTextField() {
		JTextField logInTField = new JTextField();
		logInTField.setBounds(230, 130, 208, 40);
		frame.add(logInTField);
		
	}


	private void makeLogInTitle() {
		JLabel titleLabel = new JLabel("Welcome to TOS");
		titleLabel.setBackground(Color.RED);
		titleLabel.setForeground(Color.BLUE);
		//titleLabel.setOpaque(true);
		titleLabel.setBounds(500, 30, 350, 90);
		titleLabel.setFont(new Font("Sherif",Font.BOLD,40));
		frame.add(titleLabel);
	}


	private void makeIdTextLabel() {
		JLabel id = new JLabel("Customer id:");
		id.setFont(new Font("Sherif",Font.PLAIN,20));
		id.setBounds(100, 100, 200, 100);
		frame.add(id);
	}


	private void makeMainFrame() {
		frame = new JFrame("Customer");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Home();
	}
	
	////////////////////////////////////////////////////////////////
	
	
/*	@Override
	public boolean mouseMove(Event evt, int x, int y) {
		x= evt.x;
		y= evt.y;
		return super.mouseMove(evt, x, y);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.setFont(new Font("Monospaced", Font.BOLD, 20));
	    g.fillOval(x, y, 10, 10);                 // gives the bullet
	    g.drawString(x + "," + y,  x+10, y -10);  // displays the x and y position
	    g.drawString(str, x+10, y+20);       
	}  */
	
}
