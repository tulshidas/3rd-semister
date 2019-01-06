package fb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Fb {
	public String firstName;
	public String surName;
	public String mobOrEmail;
	public char[] password;
	public String passwordText;
	public String day,month,year;
	public String gender="noone";
	public JTable table;
	public DefaultTableModel model;
	public int serialNo=0;
	
	public  Fb() {
		JFrame frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(new GridLayout(10, 1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Serial Id");
		model.addColumn("First Name");
		model.addColumn("Surname");
		model.addColumn("Gender");
		model.addColumn("Birthday");		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1,2));
		p1.setBackground(Color.BLUE);
		JLabel l1= new JLabel("    facebook", SwingConstants.LEFT);
	    l1.setFont(new Font("sherif", Font.BOLD, 40));
	    l1.setForeground(Color.WHITE);
		p1.add(l1);
		frame.add(p1);
		
		JPanel p11 = new JPanel();
		p11.setBackground(Color.BLUE);
		p11.setLayout(new GridLayout(3, 3));
		
		JLabel l11 = new JLabel("Email or Phone",SwingConstants.LEFT);
		l11.setFont(new Font( "sherif",Font.PLAIN,15));
			
		JLabel l12 = new JLabel("Password",SwingConstants.LEFT);
		l12.setFont(new Font("sherif", Font.PLAIN, 15));
			
		JLabel empty = new JLabel("");
		JLabel empty1 = new JLabel("");
		JLabel empty2 = new JLabel("");
		JTextField tf = new JTextField();
		JTextField tf1 = new JTextField();
		tf.setBounds(300, 20, 150, 15);
		JButton jb = new JButton("Log in");		
	
		JLabel l22 = new JLabel("Forgotten account",SwingConstants.LEFT);
		l22.setFont(new Font("sherif", Font.PLAIN, 15));
		
		p11.add(l11);
		p11.add(l12);
		p11.add(empty1);
		p11.add(tf1);
		p11.add(tf);
		p11.add(jb);
		p11.add(empty);
		p11.add(l22);
		p11.add(empty2);
		
		p1.add(p11);
			
		JPanel p2 = new JPanel(new GridLayout(1, 2));
		p2.add(new JLabel(""));
		JLabel l2= new JLabel("Creat a new account");
		l2.setFont(new Font("sherif",Font.PLAIN,40));
		p2.add(l2);
		frame.add(p2);
		
		JPanel p3 = new JPanel(new GridLayout(1, 2));
		p3.add(new JLabel(""));
		JLabel l3= new JLabel("It's free and always will be ");
		l3.setFont(new Font("sherif",Font.PLAIN,20));
		p3.add(l3);
		frame.add(p3);
		
		JPanel p4 = new JPanel(new GridLayout(1, 2));
		p4.add(new JLabel(""));
		JPanel p41 = new JPanel(new GridLayout(1, 2));
		JTextField name = new JTextField("First name",30);
		
		name.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				 
				 firstName = name.getText();
				 name.setText(firstName);
			} 
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				firstName = name.getText();
				if(firstName.equals("First name")) name.setText(null);
			}	
		
		});
		
		
	    p41.add(name);
		JTextField surname = new JTextField("Surname",30);
		surname.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				surName = surname.getText();
				surname.setText(surName);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				surName = surname.getText();
				if(surName.equals("Surname")) surname.setText(null);
			}
		});
		
		p41.add(surname);
		
		p4.add(p41);
		frame.add(p4);
		
		JPanel p5 = new JPanel();
		p5.setLayout(new GridLayout(1, 2));
		p5.add(new JLabel(""));
		
		JTextField mobile = new JTextField("Mobile number or email address",40);
		mobile.setToolTipText("What is your name");
		mobile.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				mobOrEmail = mobile.getText();
				mobile.setText(mobOrEmail);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				mobOrEmail = mobile.getText();
				if(mobOrEmail.equals("Mobile number or email address")) mobile.setText(null);
			}
		});
		p5.add(mobile);
		
		frame.add(p5);

		JPanel p6 = new JPanel();
		p6.setLayout(new GridLayout(1, 2));
		p6.add(new JLabel(""));
		
		JTextField reEnter = new JTextField("Re-enter mobile number or email address",40);
		reEnter.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				mobOrEmail = reEnter.getText();
				reEnter.setText(mobOrEmail);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				mobOrEmail = reEnter.getText();
				if(mobOrEmail.equals("Re-enter mobile number or email address")) reEnter.setText(null);
			}
		});
		
		p6.add(reEnter);
		
		frame.add(p6);
		
		JPanel p7 = new JPanel();
		p7.setLayout(new GridLayout(1, 2));
		p7.add(new JLabel(""));
		
		JPasswordField newPassword = new JPasswordField("Password",10);
		newPassword.setToolTipText("Password");
		
		newPassword.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				passwordText = newPassword.getText();
				newPassword.setText(null);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				passwordText = newPassword.getText();
				if(passwordText.equals("Password")) newPassword.setText(null);
			}
		});
		p7.add(newPassword);
		
		frame.add(p7);
		
		JPanel p8 = new JPanel(new GridLayout(1, 2));
		p8.add(new JLabel(""));
		
		JPanel birthDate = new JPanel(new GridLayout(1, 2));
		birthDate.add(new JLabel(""));
		
		JComboBox<?>dayList;
		
		String []days = new String[32];
		days[0]="Day";
		for(int i=1;i<32;i++){
			days[i]=String.valueOf(i);
		}
		
		dayList = new JComboBox<String>(days);
		dayList.setSelectedIndex(0);
		dayList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				day = (String) dayList.getSelectedItem();
			}
		});
		JPanel p71 = new JPanel(new GridLayout(2, 2));
		JLabel l71 = new JLabel("Birthday");
		p71.add(l71);
		p71.add(new JLabel(""));
		
		JPanel datePanel = new JPanel(new GridLayout(1, 3));
		datePanel.add(dayList);
		
		
		JComboBox<?>monthList;
		String[] months = new String[13];
		months[0] = "Month";
		for(int i=1;i<13;i++){
			months[i] = String.valueOf(i);
		}
		
		monthList = new JComboBox< String >(months);
		monthList.setSelectedIndex(0);
		monthList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				month = (String) monthList.getSelectedItem();
				
			}
		});
		datePanel.add(monthList);
		
		JComboBox<?>yearList;
		
		String[] years = new String[201];
		
		years[0] = "Year" ;
		for(int i=1880;i<2020;i++){
			years[i-1879] = String.valueOf(i);
		}
		yearList = new JComboBox<String>(years);
		yearList.setSelectedIndex(0);
		
		yearList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				year = (String) yearList.getSelectedItem();
				
			}
		});
		
		datePanel.add(yearList); 
		p71.add(datePanel);
		
		JLabel tex = new JLabel("why I need to provide my \n date of birth");
		p71.add(tex);
		
		p8.add(p71);
		frame.add(p8);
		
		JPanel p9 = new JPanel(new GridLayout(1, 2));
		p9.add(new JLabel(""));
		
		JPanel p91 = new JPanel(new BorderLayout());
		JCheckBox male = new JCheckBox("Male");
		male.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				 gender = event.getActionCommand();
			}
		});
		JCheckBox female = new JCheckBox("Female");
		//male.setBounds(5, 3, 5, 5);
		female.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				gender = event.getActionCommand();
				JOptionPane.showMessageDialog(null, gender);
				
			}
		});
		p91.add(male,BorderLayout.WEST);
		p91.add(female,BorderLayout.CENTER);
		p9.add(p91);
		frame.add(p9);
		
		JPanel p10 = new JPanel(new GridLayout(1, 2));
		p10.add(new JLabel(""));
		JButton creatAc = new JButton("Creat Account");
		creatAc.setBackground(Color.green);
		creatAc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				firstName = name.getText();
				surName = surname.getText();
				JOptionPane.showMessageDialog(null, "Account created");
				serialNo++;
				frame.setState(JFrame.ICONIFIED);
				showAllInformation();
				
				
			}

			
			
		});
		
		JPanel p101 = new JPanel(new GridLayout(1, 2));
		p101.add(creatAc);
		p101.add(new JLabel(""));
		p10.add(p101);
		
		frame.add(p10);
		frame.setVisible(true);
		
	}
	
	
	private void insertInTable() {
		// TODO Auto-generated method stub
		String birthday = new String(this.day+"-"+this.month+"-"+this.year);
		JFrame frame2 = new JFrame("Facebook Account Table");
		frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		model.addRow(new Object[]{serialNo,firstName,surName,gender,birthday});
		frame2.add(new JScrollPane(table));
		
		frame2.setVisible(true);
	}

	
	private void showAllInformation() {
		JFrame frame1 = new JFrame();
		frame1.setLayout(new GridLayout(10,1));
		frame1.setSize(1370, 738);
		
		JLabel name1 = new JLabel("FirstName:"+ this.firstName);
		name1.setFont(new Font("sherif", Font.BOLD, 30));
		frame1.add(name1);
		
		JLabel surname1 = new JLabel("Surname:"+surName);
		surname1.setFont(new Font("sherif", Font.BOLD, 30));
		frame1.add(surname1);
		
		JLabel mobileNo = new JLabel();
		if(mobOrEmail.startsWith("01")) mobileNo.setText("Mobile:"+ mobOrEmail);
		else mobileNo.setText("Email:"+ mobOrEmail);
		mobileNo.setFont(new Font("sherif", Font.BOLD, 30));
		frame1.add(mobileNo);
		
		JLabel birthday = new JLabel("Birthday:"+this.day+"-"+this.month+"-"+this.year);
		birthday.setFont(new Font("sherif", Font.BOLD, 30));
		frame1.add(birthday);
		
		JLabel gender1 = new JLabel("Gender:"+this.gender);
		gender1.setFont(new Font("sherif", Font.BOLD, 30));
		frame1.add(gender1);
		
		JPanel pnel = new JPanel(new GridLayout(1, 3));
		pnel.add(new JLabel(""));
		JButton jbton = new JButton("OK");
		jbton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame1.setVisible(false);
				insertInTable();
			}
		});
		
		pnel.add(jbton);
		pnel.add(new JLabel(""));
		
		frame1.add(pnel);
		frame1.setVisible(true);
		
	}
	
}
