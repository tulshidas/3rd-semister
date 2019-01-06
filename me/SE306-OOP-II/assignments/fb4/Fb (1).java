package fb3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
	private String firstName;
	private String surName;
	private String mobOrEmail;
	private String reEnteredMobOrEmail;
	private char[] password;
	private String day,month,year;
	private String gender="noone";
	private JFrame frame;
	private JFrame frame1;
	private HashMap<String, Account> accounts;
	JPasswordField logInPasswordField ;
	private JTable table;
	private DefaultTableModel model;
	private int serialNo=0;
	
	public  Fb() {
	    frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(new GridLayout(10, 1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		accounts = new HashMap<>();
		
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
		
		JTextField tf = new JTextField();
		/*tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}); 
		*/
		
		
		
		logInPasswordField=new JPasswordField();
		logInPasswordField.setEchoChar('*');
		//tf.setBounds(300, 20, 150, 15);
		JButton jb = new JButton("Log in");
	
		jb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(!checkEmail(tf.getText())) JOptionPane.showMessageDialog(null, "Account doesn't exist","Error",JOptionPane.ERROR_MESSAGE);
				else if(!checkPassword(logInPasswordField.getPassword(),tf.getText()))
						JOptionPane.showMessageDialog(null,"Wrong Password","Error",JOptionPane.ERROR_MESSAGE);
				else{
					JOptionPane.showMessageDialog(null, "log in successful");
				}
			}
		});
		
		JLabel l22 = new JLabel("Forgotten account",SwingConstants.LEFT);
		l22.setFont(new Font("sherif", Font.PLAIN, 15));
		
		p11.add(l11);
		p11.add(l12);
		p11.add(new JLabel(""));
		p11.add(tf);
		p11.add(logInPasswordField);
		p11.add(jb);
		p11.add(new JLabel(""));
		p11.add(l22);
		p11.add(new JLabel(""));
		
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
			public void focusLost(FocusEvent e) {
				 
				 firstName = name.getText();
				 name.setText(firstName);
			} 
			
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				firstName = name.getText();
				if(firstName.equals("First name")) name.setText(null);
			}	
		
		});
		
		
	    p41.add(name);
		JTextField surname = new JTextField("Surname",30);
		surname.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				surName = surname.getText();
				surname.setText(surName);
			}
			
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
			
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				mobOrEmail = mobile.getText();
				mobile.setText(mobOrEmail);
			}
			
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
			
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				reEnteredMobOrEmail = reEnter.getText();
				reEnter.setText(reEnteredMobOrEmail);
			}
			
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				reEnteredMobOrEmail = reEnter.getText();
				if(reEnteredMobOrEmail.equals("Re-enter mobile number or email address")) reEnter.setText(null);
			}
		});
		
		p6.add(reEnter);
		
		frame.add(p6);
		
		JPanel p7 = new JPanel();
		p7.setLayout(new GridLayout(1, 2));
		p7.add(new JLabel(""));
		
		JPasswordField newPassword = new JPasswordField("Password",10);
		newPassword.setToolTipText("Password");
		newPassword.setEchoChar('*');
		newPassword.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				password = newPassword.getPassword();
				newPassword.setText(new String(password));
			}
			
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				password = newPassword.getPassword();
				if(Arrays.equals(password, new char[]{'P','a','s','s','w','o','r','d'}))
					newPassword.setText(null);
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
			public void actionPerformed(ActionEvent event) {
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
			public void actionPerformed(ActionEvent event) {
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
		JCheckBox female = new JCheckBox("Female");
		male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				 if(male.isSelected()) {
					 gender = "Male";
					 if(female.isSelected()) female.setSelected(false);
				 }
				 else {
					 if(! female.isSelected()) gender = null ;
				 }
			}
		});
		
		
		female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(female.isSelected() ){ 
					gender = "Female";
					if(male.isSelected()) male.setSelected(false);
					
				}
				
				else {
					if(! male.isSelected()) gender = null ;
				}
				
				
			}
		});
		p91.add(male,BorderLayout.WEST);
		p91.add(female,BorderLayout.CENTER);
		p9.add(p91);
		frame.add(p9);
		
		JPanel p10 = new JPanel(new GridLayout(1, 2));
		p10.add(new JLabel(""));
		JButton creatAc = new JButton("Create Account");
		creatAc.setBackground(Color.green);
		creatAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				firstName = name.getText();
				surName = surname.getText();
				mobOrEmail = mobile.getText();				
			
				if(!checkPatter(firstName,surName,mobOrEmail)) ;

				else if(! mobOrEmail.equals(reEnteredMobOrEmail)) JOptionPane.showMessageDialog(null, "Email mismatch, please try again",
						"error",JOptionPane.ERROR_MESSAGE);
				else if(!checkEmail(mobOrEmail))JOptionPane.showMessageDialog(null, "Account already exist,"
							+ "Enter another email","Error", JOptionPane.ERROR_MESSAGE);
				else{
					//password = logInPasswordField.getPassword();
					Account account = new Account(firstName, surName, mobOrEmail,password, day+month+year, gender);
					accounts.put(account.getMobOrEmail(), account);
					model.addRow(new Object[]{serialNo,firstName,surName,gender,day+"-"+month+"-"+year});
					
					JOptionPane.showMessageDialog(null, "Account created");
					serialNo++;
					
					frame.setVisible(false);
					showAllInformation(mobOrEmail);
				}		
				
			}													
			
		});
		
		JPanel p101 = new JPanel(new GridLayout(1, 2));
		p101.add(creatAc);
		p101.add(new JLabel(""));
		p10.add(p101);
		
		frame.add(p10);
		frame.setVisible(true);
		
	}
	
	private static boolean checkPatter(String firstName, String surName, String mobOrEmail) {
		boolean returnValue=true;
		String regExOfName = "[a-zA-Z]{1,}";
		Pattern pRegExOfName = Pattern.compile(regExOfName);
		Matcher mRegExOfName = pRegExOfName.matcher(firstName);
		if(!mRegExOfName.matches()) {
			JOptionPane.showMessageDialog(null,"Invalid Type in firstName");
			returnValue = false;
			
		}

		Matcher mRegExOfSurName = pRegExOfName.matcher(surName);
		if(!mRegExOfSurName.matches()){
			JOptionPane.showMessageDialog(null,"Invalid Type in surName");
			returnValue = false;
		}
		
		String regExOfMobOrEmail = "01[5-9]{1}[0-9]{8}|[/S]{1,}@[/S]{1,}";
		Pattern pRegExOfMobOrEmail = Pattern.compile(regExOfMobOrEmail);
		Matcher mRegExOfMobOrEmail = pRegExOfMobOrEmail.matcher(mobOrEmail);
		if(!mRegExOfMobOrEmail.matches()){
			JOptionPane.showMessageDialog(null,"Invalid Type in Moble or Email");
			returnValue = false;
		}
		
		return returnValue;
	}	
	
	private boolean checkEmail(String mobOrEmail1) {
		for(String email:accounts.keySet()){
			System.out.println(email);
			System.out.println("mobOrEmail:"+ accounts.get(email).getMobOrEmail());
			System.out.println(accounts.get(email).getPassword());

			if(!mobOrEmail1.equals(email))return false;
		}
		return true;
	}
	
	private boolean checkPassword(char[] logInPasswd, String email) {
		// TODO Auto-generated method stub
		if(Arrays.equals(logInPasswd, accounts.get(email).getPassword())) return true;
		else return false;
	}
	
	
	private void showTable() {
		// TODO Auto-generated method stub
		JFrame frame2 = new JFrame("Facebook Account Table");
		frame2.setLayout(new BorderLayout());
		frame2.add(new JScrollPane(table), BorderLayout.PAGE_START);
		JPanel jp= new JPanel();
		JButton jbutton = new JButton("OK");
		jbutton.setSize(50, 50);
		jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame2.setVisible(false);
				frame1.setVisible(true);
			}
		});
		
		jp.add(jbutton);
		frame2.add(jp,BorderLayout.CENTER);
		
		frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame2.setVisible(true);
	}

	
	private void showAllInformation(String mobOrEmail2) {
		frame1 = new JFrame();
		frame1.setLayout(new GridLayout(10,1));
		frame1.setSize(1370, 738);
		
		JLabel name1 = new JLabel("FirstName:"+ accounts.get(mobOrEmail2).getFirstName());
		name1.setFont(new Font("sherif", Font.BOLD, 30));
		frame1.add(name1);
		
		JLabel surname1 = new JLabel("Surname:"+accounts.get(mobOrEmail2).getSurName());
		surname1.setFont(new Font("sherif", Font.BOLD, 30));
		frame1.add(surname1);
		
		JLabel mobileNo = new JLabel();
		if(mobOrEmail.startsWith("01")) mobileNo.setText("Mobile:"+ accounts.get(mobOrEmail2).getMobOrEmail());
		else mobileNo.setText("Email:"+ accounts.get(mobOrEmail2).getMobOrEmail());
		mobileNo.setFont(new Font("sherif", Font.BOLD, 30));
		frame1.add(mobileNo);
		
		JLabel birthday = new JLabel("Birthday:"+this.day+"-"+this.month+"-"+this.year);
		birthday.setFont(new Font("sherif", Font.BOLD, 30));
		frame1.add(birthday);
		
		JLabel gender1 = new JLabel("Gender:"+accounts.get(mobOrEmail2).getGender());
		gender1.setFont(new Font("sherif", Font.BOLD, 30));
		frame1.add(gender1);
		
		JPanel pnel = new JPanel(new GridLayout(1, 4));
		pnel.add(new JLabel(""));
		JButton jbton = new JButton("Show All Accounts");
		jbton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame1.setVisible(false);
				showTable();
			}
		});
		
		pnel.add(jbton);
		
		JButton jbton1 = new JButton("Create new account");
		jbton1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				frame1.setVisible(false);
				frame.setVisible(true);
				
			}
		});
		
		pnel.add(jbton1);
		
		pnel.add(new JLabel(""));
		
		frame1.add(pnel);
		frame1.setVisible(true);
		
	}
	
}
