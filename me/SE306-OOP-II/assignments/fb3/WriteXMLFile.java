package fb2;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
public class WriteXMLFile {
	private static int id =0;

	public WriteXMLFile(String firstName,String surName,String email,String birthday,char[] password) throws SAXException, IOException {

	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.parse("C/Users/User/Documents:\\file1.XML");
		
		org.w3c.dom.Node firstElement = doc.getFirstChild();
		Element account = doc.createElement("account");
		id = firstElement.getLastChild().getAttributes(). ;

		// set attribute to staff element
	/*  Attr accountId = doc.createAttribute("id");
		id++;
		accountId.setValue(String.valueOf(id));
		account.setAttributeNode(accountId);
	*/
		// shorten way
		// staff.setAttribute("id", "1");
		account.setAttribute("id", String.valueOf(id));
		// firstname elements
		Element efirstname = doc.createElement("firstname");
		efirstname.appendChild(doc.createTextNode(firstName));
		account.appendChild(efirstname);

		// lastname elements
		Element lastname = doc.createElement("surName");
		lastname.appendChild(doc.createTextNode(surName));
		account.appendChild(lastname);
		
		Element eEmail = doc.createElement("email");
		eEmail.appendChild(doc.createTextNode(email));
		account.appendChild(eEmail);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:\\accounts.xml"));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}
