package fb5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
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

import org.xml.sax.SAXException;

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
	private HashMap<String, Account> accounts =  new HashMap<>();
	JPasswordField logInPasswordField ;
	private JTable table;
	private DefaultTableModel model;
	private int serialNo=0;
	
	public  Fb() {
	    makeMainFrame();
		
		createTable();		
		
		JPanel panelOfTitleBar = drawTitle();
		
		makeLogInPart(panelOfTitleBar);
			
		writeHeadingOfAccountCreationPart();
		
		writeSubHeadingOfAccountCreationPart();
		
		JPanel panelOfUserName = new JPanel(new GridLayout(1, 2));
		panelOfUserName.add(new JLabel(""));
		JPanel panelOfFullName = new JPanel(new GridLayout(1, 2));
		
		JTextField tFieldOfFirstname = makeTextFieldOfFirstName();
		
	    panelOfFullName.add(tFieldOfFirstname);
	    
		JTextField tFieldOfSurname = makeTextFieldOfSurname(panelOfUserName, panelOfFullName);
		
		JTextField tFieldOfMobile = makeTextFieldOfEmailOrMobile();

		makeTextFieldOfRe_enteredOfEmailOrMobile();
		
		JPanel panelOfPassword = new JPanel();
		panelOfPassword.setLayout(new GridLayout(1, 2));
		panelOfPassword.add(new JLabel(""));
		
		makePasswordField(panelOfPassword);
		
		makeComboboxOfBirthday();
		
		makeCheckBoxOfGender();
		
		makeAccountCreatorButton(tFieldOfFirstname, tFieldOfSurname, tFieldOfMobile);
		frame.setVisible(true);
		
	}

	private void makeAccountCreatorButton(JTextField tFieldOfFirstname, JTextField tFieldOfSurname, JTextField tFieldOfMobile) {
		JPanel p10 = new JPanel(new GridLayout(1, 2));
		p10.add(new JLabel(""));
		JButton creatAc = new JButton("Create Account");
		creatAc.setBackground(Color.green);
		creatAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				firstName = tFieldOfFirstname.getText();
				surName = tFieldOfSurname.getText();
				mobOrEmail = tFieldOfMobile.getText();
				System.out.println();
				JOptionPane.showMessageDialog(null, firstName+"  "+surName+"  "+mobOrEmail+" "+day+"."+month+"."+year+"  "+password.toString());
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
					writeInformationToXmlFile();
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
	}
	
	private void writeInformationToXmlFile() {
		try {
		
			new WriteToXMLFile(firstName, surName, mobOrEmail, day+"-"+month+"-"+year, password);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}													
	

	private void makeCheckBoxOfGender() {
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
	}

	private void makeComboboxOfBirthday() {
		JPanel panelOfBirthDay = new JPanel(new GridLayout(1, 2));
		panelOfBirthDay.add(new JLabel(""));
		
		//JPanel birthDate = new JPanel(new GridLayout(1, 2));
		//birthDate.add(new JLabel(""));
		
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
				day = (String) dayList.getSelectedItem();
			}
		});
		JPanel subPanelOfBirthday = new JPanel(new GridLayout(2, 2));
		JLabel textLabel = new JLabel("Birthday");
		subPanelOfBirthday.add(textLabel);
		subPanelOfBirthday.add(new JLabel(""));
		
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
		subPanelOfBirthday.add(datePanel);
		
		JLabel notificationLabel = new JLabel("why I need to provide my \n date of birth");
		subPanelOfBirthday.add(notificationLabel);
		
		panelOfBirthDay.add(subPanelOfBirthday);
		frame.add(panelOfBirthDay);
	}

	private void makePasswordField(JPanel panelOfPassword) {
		JPasswordField passwordField = new JPasswordField("Password",10);
		passwordField.setToolTipText("Password");
		passwordField.setEchoChar('*');
		passwordField.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				password = passwordField.getPassword();
				passwordField.setText(new String(password));
			}
			
			public void focusGained(FocusEvent e) {
				password = passwordField.getPassword();
				if(Arrays.equals(password, new char[]{'P','a','s','s','w','o','r','d'}))
					passwordField.setText(null);
			}
		});
		panelOfPassword.add(passwordField);
		
		frame.add(panelOfPassword);
	}

	private void makeTextFieldOfRe_enteredOfEmailOrMobile() {
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
	}

	private JTextField makeTextFieldOfEmailOrMobile() {
		JPanel p5 = new JPanel();
		p5.setLayout(new GridLayout(1, 2));
		p5.add(new JLabel(""));
		
		JTextField tFieldOfMobile = new JTextField("Mobile number or email address",40);
		tFieldOfMobile.setToolTipText("What is your name");
		tFieldOfMobile.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				mobOrEmail = tFieldOfMobile.getText();
				tFieldOfMobile.setText(mobOrEmail);
			}
			
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				mobOrEmail = tFieldOfMobile.getText();
				if(mobOrEmail.equals("Mobile number or email address")) tFieldOfMobile.setText(null);
			}
		});
		p5.add(tFieldOfMobile);
		
		frame.add(p5);
		return tFieldOfMobile;
	}

	private JTextField makeTextFieldOfSurname(JPanel panelOfUserName, JPanel panelOfFullName) {
		JTextField tFieldOfSurname = new JTextField("Surname",30);
		tFieldOfSurname.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				surName = tFieldOfSurname.getText();
				tFieldOfSurname.setText(surName);
			}
			
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				surName = tFieldOfSurname.getText();
				if(surName.equals("Surname")) tFieldOfSurname.setText(null);
			}
		});
		
		panelOfFullName.add(tFieldOfSurname);
		
		panelOfUserName.add(panelOfFullName);
		frame.add(panelOfUserName);
		return tFieldOfSurname;
	}

	private JTextField makeTextFieldOfFirstName() {
		JTextField tFieldOfFirstname = new JTextField("First name",30);
		
		tFieldOfFirstname.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				 
				 firstName = tFieldOfFirstname.getText();
				 tFieldOfFirstname.setText(firstName);
			} 
			
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				firstName = tFieldOfFirstname.getText();
				if(firstName.equals("First name")) tFieldOfFirstname.setText(null);
			}	
		
		});
		return tFieldOfFirstname;
	}

	private void writeSubHeadingOfAccountCreationPart() {
		JPanel p3 = new JPanel(new GridLayout(1, 2));
		p3.add(new JLabel(""));
		JLabel l3= new JLabel("It's free and always will be ");
		l3.setFont(new Font("sherif",Font.PLAIN,20));
		p3.add(l3);
		frame.add(p3);
	}

	private void writeHeadingOfAccountCreationPart() {
		JPanel p2 = new JPanel(new GridLayout(1, 2));
		p2.add(new JLabel(""));
		JLabel l2= new JLabel("Creat a new account");
		l2.setFont(new Font("sherif",Font.PLAIN,40));
		p2.add(l2);
		frame.add(p2);
	}

	private void makeLogInPart(JPanel panelOfTitleBar) {
		JPanel p11 = new JPanel();
		p11.setBackground(Color.BLUE);
		p11.setLayout(new GridLayout(3, 3));
		
		JLabel l11 = new JLabel("Email or Phone",SwingConstants.LEFT);
		l11.setFont(new Font( "sherif",Font.PLAIN,15));
			
		JLabel l12 = new JLabel("Password",SwingConstants.LEFT);
		l12.setFont(new Font("sherif", Font.PLAIN, 15));
		
		JTextField tf = new JTextField();
		
		
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
		
		panelOfTitleBar.add(p11);
	}

	private JPanel drawTitle() {
		JPanel panelOfTitleBar = new JPanel();
		panelOfTitleBar.setLayout(new GridLayout(1,2));
		panelOfTitleBar.setBackground(Color.BLUE);
		JLabel l1= new JLabel("    facebook", SwingConstants.LEFT);
	    l1.setFont(new Font("sherif", Font.BOLD, 40));
	    l1.setForeground(Color.WHITE);
		panelOfTitleBar.add(l1);
		frame.add(panelOfTitleBar);
		return panelOfTitleBar;
	}

	private void createTable() {
		model = new DefaultTableModel();                                                                                                                                                                                                                                                                                                                                                                                                                             
		table = new JTable(model);
		model.addColumn("Serial Id");
		model.addColumn("First Name");
		model.addColumn("Surname");
		model.addColumn("Gender");
		model.addColumn("Birthday");
	}

	private void makeMainFrame() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(new GridLayout(10, 1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

			if(mobOrEmail1.equals(email))return false;
		}
		return true;
	}
	
	private boolean checkPassword(char[] logInPasswd, String email) {
		if(Arrays.equals(logInPasswd, accounts.get(email).getPassword())) return true;
		else return false;
	}
	
	
	private void showTable() {
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
