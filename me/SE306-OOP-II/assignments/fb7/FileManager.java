package fb7;

import java.io.File;
import java.io.IOException;

import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
public class FileManager {
	private Document doc;
	private Element newAccount;
	private File file;
	
	public FileManager() {
		file = new File("C:/Users/User/Documents/facebook.xml");
		if(!file.exists()) new CreateXmlFile();
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		
		// root elements
		try {
			DocumentBuilder  docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.parse(file);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		}
	    
	}

	public void WriteToXml(String firstName,String surName,String email,String birthday,String gender,char[] password) throws SAXException, IOException {

	  try {
		int accountNumber;
		  
		newAccount = doc.createElement("Account");
	    
		Element rootElement = doc.getDocumentElement();
		Node accountNo = doc.getElementsByTagName("AccountNo").item(0);
		accountNumber = (Integer.valueOf(accountNo.getTextContent())).intValue();
		
	    accountNumber++;
	    accountNo.setTextContent(String.valueOf(accountNumber));
	    
		setAttributeToNewAccount(accountNumber);
		setFirstNameToNewAccount(firstName);
		setSurnameToNewAccount(surName);
		setEmailToNewAccount(email);
		setBirthDayToNewAccount(birthday);
		setGenderToNewAccount(gender);
		setPasswordToNewAccount(password);

		rootElement.appendChild(newAccount);
		
		// set attribute to staff element
	/*  Attr accountId = doc.createAttribute("id");
		id++;
		accountId.setValue(String.valueOf(id));
		account.setAttributeNode(accountId);
	*/
		// shorten way
		// staff.setAttribute("id", "1");
		// firstname elements

		// lastname elements
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(file);
		transformer.transform(source, result);

		System.out.println("File saved!");

	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}	
	
	public int getAccountNo(){
		int accountNo = Integer.valueOf(doc.getElementsByTagName("AccountNo").item(0).getTextContent()).intValue();
		return accountNo;
	}
	
	private void setGenderToNewAccount(String gender) {
		Element eGender = doc.createElement("Gender");
		eGender.setTextContent(gender);
		newAccount.appendChild(eGender);
	}

	public boolean isEmailExist(String email){
		Node node;
		NodeList nList = doc.getElementsByTagName("Email");
		for(int i=0;i<nList.getLength();i++){
		    node = nList.item(i);
		    if(node.getTextContent().equals(email))return true;
		}	
		
		return false;
	}
	
	public boolean isPasswordCorrect(char[] password,String email){
		Node node;
		String textPassword = String.valueOf(password);
		int i;
		NodeList nList = doc.getElementsByTagName("Email");
		for( i=0;i<nList.getLength();i++){
		    node = nList.item(i);
		    if(node.getTextContent().equals(email))break;
		}	
		
		nList = doc.getElementsByTagName("Password");
		node = nList.item(i);
		if(node.getTextContent().equals(textPassword))return true;
		
		return false;
	}
	
	public DefaultTableModel loadInTable(){
		DefaultTableModel model = new DefaultTableModel();
		NodeList nList = doc.getElementsByTagName("Account");
		String firstName,surname,gender,email,birthday;

		
		for(int i=1;i<=nList.getLength();i++){
			firstName = nList.item(i-1).getChildNodes().item(0).getTextContent();
			surname =   nList.item(i-1).getChildNodes().item(1).getTextContent();
			email = nList.item(i-1).getChildNodes().item(2).getTextContent();
			birthday = nList.item(i-1).getChildNodes().item(3).getTextContent();
			gender = nList.item(i-1).getChildNodes().item(4).getTextContent();
			model.addRow(new Object[]{String.valueOf(i), firstName, surname,email,birthday,gender});
		}
		
		return model;
		
	}


	private void setPasswordToNewAccount(char[] password) {
		Element ePassword = doc.createElement("Password");
		ePassword.setTextContent(new String(password));
		newAccount.appendChild(ePassword);
		
	}


	private void setBirthDayToNewAccount(String birthday) {
		Element eBirthday = doc.createElement("Birthday");
		eBirthday.setTextContent(birthday);
		newAccount.appendChild(eBirthday);
	}

	private void setEmailToNewAccount(String email) {
		Element eEmail = doc.createElement("Email");
		eEmail.setTextContent(email);
		newAccount.appendChild(eEmail);
	}


	private void setSurnameToNewAccount(String surName) {
		
		Element eSurName = doc.createElement("Surname");
		eSurName.setTextContent(surName);
		newAccount.appendChild(eSurName);
	}


	private void setAttributeToNewAccount(int accountNumber) {
		newAccount.setAttribute("id", String.valueOf(accountNumber));
	}

	private void setFirstNameToNewAccount(String firstName) {
		Element eFirstName= doc.createElement("FirstName");
		eFirstName.setTextContent(firstName);
		newAccount.appendChild(eFirstName);
		
		
	}
}

