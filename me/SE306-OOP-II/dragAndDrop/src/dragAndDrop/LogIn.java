package dragAndDrop;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField_2;

	
	public static void main(String[] args) {
		new LogIn();
	}

	
	public LogIn() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("         Welcome to POS");
		lblNewLabel.setFont(new Font("Blackadder ITC", Font.ITALIC, 30));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(566, 21, 274, 41);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(529, 113, 170, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCustomerId = new JLabel("    Customer Id:");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomerId.setBounds(385, 113, 136, 25);
		getContentPane().add(lblCustomerId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(791, 113, 89, 25);
		getContentPane().add(lblPassword);
		
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFocusPainted(false);
		btnLogIn.setForeground(Color.MAGENTA);
		btnLogIn.setBackground(Color.DARK_GRAY);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogIn.setBounds(676, 182, 151, 41);
		getContentPane().add(btnLogIn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(975, 118, -90, 20);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(890, 113, 143, 25);
		getContentPane().add(passwordField_1);
		
		JLabel lblSignUpTo = new JLabel("Sign Up to POS");
		lblSignUpTo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSignUpTo.setBounds(684, 316, 238, 33);
		getContentPane().add(lblSignUpTo);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(541, 423, 56, 25);
		getContentPane().add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(629, 422, 227, 33);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(541, 493, 72, 33);
		getContentPane().add(lblPhone);
		
		textField_2 = new JTextField();
		textField_2.setBounds(629, 496, 227, 33);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBalance.setBounds(541, 568, 68, 25);
		getContentPane().add(lblBalance);
		
		textField_3 = new JTextField();
		textField_3.setBounds(629, 567, 227, 33);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword_1.setBounds(541, 630, 89, 25);
		getContentPane().add(lblPassword_1);
		
		JButton btnOk = new JButton("  OK");
		btnOk.setFocusPainted(false);
		btnOk.setForeground(new Color(106, 90, 205));
		btnOk.setBackground(new Color(165, 42, 42));
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOk.setBounds(1021, 527, 136, 41);
		getContentPane().add(btnOk);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(629, 630, 227, 25);
		getContentPane().add(passwordField_2);
		
		setVisible(true);  
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(560, 300, 900, 300);
	}
}
