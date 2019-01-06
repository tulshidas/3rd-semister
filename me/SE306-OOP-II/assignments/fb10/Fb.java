package fb10;

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
	private JFrame mainFrame;
	private JPasswordField logInPasswordField ;
	private JTable table;
	private DefaultTableModel model;
	private int serialNo;
	private FileManager fileManager;
	
	public  Fb() {
		fileManager = new FileManager();
	    makeMainFrame();
		loadDataInTable();
		serialNo = fileManager.getAccountNo();
		
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
		mainFrame.setVisible(true);
		
	}

	private void loadDataInTable() {
		
		model =	fileManager.loadInTable();
		table = new JTable(model);
		System.out.println("Load completed\n the Data are:\n");
		for(int i=0;i<model.getRowCount();i++){
			for(int j=0;j<model.getColumnCount();j++){
				System.out.print(model.getValueAt(i, j)+"   ");
				
			}
			System.out.println();
		}
		
		
	}

	private void makeAccountCreatorButton(JTextField tFieldOfFirstname, JTextField tFieldOfSurname, JTextField tFieldOfMobile) {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.add(new JLabel(""));
		JButton jbCreatAc = new JButton("Create Account");
		jbCreatAc.setBackground(Color.green);
		jbCreatAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				firstName = tFieldOfFirstname.getText();
				surName = tFieldOfSurname.getText();
				mobOrEmail = tFieldOfMobile.getText();
				System.out.println();
				JOptionPane.showMessageDialog(null, firstName+"  "+surName+"  "+mobOrEmail+" "+day+"."+month+"."+year+"  "+password.toString());
				if(!checkPatter(firstName,surName,mobOrEmail)) ;
				
				else if(! mobOrEmail.equals(reEnteredMobOrEmail)) JOptionPane.showMessageDialog(null, "Email mismatch, please try again",
						"error",JOptionPane.ERROR_MESSAGE);
				else if(fileManager.isEmailExist(mobOrEmail))JOptionPane.showMessageDialog(null, "Account already exist,"
							+ "Enter another email","Error", JOptionPane.ERROR_MESSAGE);
				else{
					//password = logInPasswordField.getPassword();
					serialNo++;
					//Account account = new Account(firstName, surName, mobOrEmail,password, day+month+year, gender);
					//accounts.put(account.getMobOrEmail(), account);
					model.addRow(new Object[]{serialNo,firstName,surName,mobOrEmail,day+"-"+month+"-"+year,gender});
					writeInformationToXmlFile();
					JOptionPane.showMessageDialog(null, "Account created");
					
					mainFrame.setVisible(false);
					showAllInformation(firstName,surName,mobOrEmail,day+"-"+month+"-"+year,gender);
				}		
				
			}

			
		});
		
		JPanel subPanel = new JPanel(new GridLayout(1, 2));
		subPanel.add(jbCreatAc);
		subPanel.add(new JLabel(""));
		panel.add(subPanel);
		
		mainFrame.add(panel);
	}
	
	private void writeInformationToXmlFile() {
		try {
		
			fileManager.WriteToXml(firstName, surName, mobOrEmail, day+"-"+month+"-"+year,gender, password);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}													
	

	private void makeCheckBoxOfGender() {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.add(new JLabel(""));
		
		JPanel subPanel = new JPanel(new BorderLayout());
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
		subPanel.add(male,BorderLayout.WEST);
		subPanel.add(female,BorderLayout.CENTER);
		panel.add(subPanel);
		mainFrame.add(panel);
	}

	private void makeComboboxOfBirthday() {
		JPanel panelOfBirthDay = new JPanel(new GridLayout(1, 2));
		panelOfBirthDay.add(new JLabel(""));
		
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
		mainFrame.add(panelOfBirthDay);
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
		
		mainFrame.add(panelOfPassword);
	}

	private void makeTextFieldOfRe_enteredOfEmailOrMobile() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(new JLabel(""));
		
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
		
		panel.add(reEnter);
		
		mainFrame.add(panel);
	}

	private JTextField makeTextFieldOfEmailOrMobile() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(new JLabel(""));
		
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
		panel.add(tFieldOfMobile);
		
		mainFrame.add(panel);
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
		mainFrame.add(panelOfUserName);
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
				firstName = tFieldOfFirstname.getText();
				if(firstName.equals("First name")) tFieldOfFirstname.setText(null);
			}	
		
		});
		return tFieldOfFirstname;
	}

	private void writeSubHeadingOfAccountCreationPart() {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.add(new JLabel(""));
		JLabel label= new JLabel("It's free and always will be ");
		label.setFont(new Font("sherif",Font.PLAIN,20));
		panel.add(label);
		mainFrame.add(panel);
	}

	private void writeHeadingOfAccountCreationPart() {
		JPanel jpHeading = new JPanel(new GridLayout(1, 2));
		jpHeading.add(new JLabel(""));
		JLabel jlHeading= new JLabel("Creat a new account");
		jlHeading.setFont(new Font("sherif",Font.PLAIN,40));
		jpHeading.add(jlHeading);
		mainFrame.add(jpHeading);
	}

	private void makeLogInPart(JPanel panelOfTitleBar) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setLayout(new GridLayout(3, 3));
		
		JLabel jlEmail = new JLabel("Email or Phone",SwingConstants.LEFT);
		jlEmail.setFont(new Font( "sherif",Font.PLAIN,15));
			
		JLabel jlPassword = new JLabel("Password",SwingConstants.LEFT);
		jlPassword.setFont(new Font("sherif", Font.PLAIN, 15));
		
		JTextField tfEmail = new JTextField();
		
		
		logInPasswordField=new JPasswordField();
		logInPasswordField.setEchoChar('*');
		JButton jbLongIn = new JButton("Log in");
		
		jbLongIn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, String.valueOf(logInPasswordField.getPassword()));
				JOptionPane.showMessageDialog(null, String.valueOf(tfEmail.getText()));
				if(! fileManager.isInputValid(tfEmail.getText(),logInPasswordField.getPassword())) ;				
				else{
					JOptionPane.showMessageDialog(null, "log in successful");
				}
			}
		});
		
		JLabel jlForgetText = new JLabel("Forgotten account",SwingConstants.LEFT);
		jlForgetText.setFont(new Font("sherif", Font.PLAIN, 15));
		
		panel.add(jlEmail);
		panel.add(jlPassword);
		panel.add(new JLabel(""));
		panel.add(tfEmail);
		panel.add(logInPasswordField);
		panel.add(jbLongIn);
		panel.add(new JLabel(""));
		panel.add(jlForgetText);
		panel.add(new JLabel(""));
		
		panelOfTitleBar.add(panel);
	}

	private JPanel drawTitle() {
		JPanel panelOfTitleBar = new JPanel();
		panelOfTitleBar.setLayout(new GridLayout(1,2));
		panelOfTitleBar.setBackground(Color.BLUE);
		JLabel lbTile= new JLabel("    facebook", SwingConstants.LEFT);
	    lbTile.setFont(new Font("sherif", Font.BOLD, 40));
	    lbTile.setForeground(Color.WHITE);
		panelOfTitleBar.add(lbTile);
		mainFrame.add(panelOfTitleBar);
		return panelOfTitleBar;
	}

	private void makeMainFrame() {
		mainFrame = new JFrame();
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setLayout(new GridLayout(10, 1));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
	private void showTable(){
		JFrame frameOfTable = new JFrame("Facebook Account Table");
		frameOfTable.setLayout(new BorderLayout());
		frameOfTable.add(new JScrollPane(table), BorderLayout.PAGE_START);
		JPanel panel= new JPanel();
		JButton jbutton = new JButton("OK");
		jbutton.setSize(50, 50);
		jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frameOfTable.setVisible(false);
				showAllInformation(firstName,surName,mobOrEmail,day+"-"+month+"-"+year,gender);
			}
		});
		
		panel.add(jbutton);
		frameOfTable.add(panel,BorderLayout.CENTER);
		
		frameOfTable.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frameOfTable.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frameOfTable.setVisible(true);
	}

	private void showAllInformation(String firstName, String surName, String mobOrEmail, String birthday, String gender) {
		JFrame  frameOfAllinformations = new JFrame();
		frameOfAllinformations.setLayout(new GridLayout(10,1));
		frameOfAllinformations.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JLabel name1 = new JLabel("FirstName:"+ firstName);
		name1.setFont(new Font("sherif", Font.BOLD, 30));
		frameOfAllinformations.add(name1);
		
		JLabel surname1 = new JLabel("Surname:"+surName);
		surname1.setFont(new Font("sherif", Font.BOLD, 30));
		frameOfAllinformations.add(surname1);
		
		JLabel mobileNo = new JLabel();
		if(mobOrEmail.startsWith("01")) mobileNo.setText("Mobile:"+ mobOrEmail);
		//else mobileNo.setText("Email:"+ accounts.get(mobOrEmail).getMobOrEmail());
		else mobileNo.setText(mobOrEmail);
		mobileNo.setFont(new Font("sherif", Font.BOLD, 30));
		frameOfAllinformations.add(mobileNo);
		
		JLabel lBirthday = new JLabel("Birthday:"+birthday);
		lBirthday.setFont(new Font("sherif", Font.BOLD, 30));
		frameOfAllinformations.add(lBirthday);
		
		JLabel gender1 = new JLabel("Gender:"+gender);
		gender1.setFont(new Font("sherif", Font.BOLD, 30));
		frameOfAllinformations.add(gender1);
		
		JPanel pnel = new JPanel(new GridLayout(1, 4));
		pnel.add(new JLabel(""));
		JButton jbton = new JButton("Show All Accounts");
		jbton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frameOfAllinformations.setVisible(false);
				showTable();
			}
		});
		
		pnel.add(jbton);
		
		JButton jbton1 = new JButton("Create new account");
		jbton1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				frameOfAllinformations.setVisible(false);
				mainFrame.setVisible(true);
				
			}
		});
		
		pnel.add(jbton1);
		
		pnel.add(new JLabel(""));
		
		frameOfAllinformations.add(pnel);
		frameOfAllinformations.setVisible(true);
		
	}
	
}
