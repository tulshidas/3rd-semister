package fb5;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
public class WriteToXMLFile {
	private Document doc;
	private Element newAccount;

	public WriteToXMLFile(String firstName,String surName,String email,String birthday,char[] password) throws SAXException, IOException {

	  try {
		int accountNumber;
		  
		File file = new File("C:/Users/User/Documents/facebook.xml");

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		doc = docBuilder.parse(file);
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
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(file);
		transformer.transform(source, result);

		System.out.println("File saved!");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
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

