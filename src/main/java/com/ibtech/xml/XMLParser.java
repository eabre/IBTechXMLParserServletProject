package com.ibtech.xml;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.ibtech.bag.Bag;
import com.ibtech.bag.BagKey;
import com.ibtech.command.CommandExecuter;
import com.ibtech.model.Customer;

public class XMLParser {
	
	public static void customerParser(String body) throws Exception {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();  
		DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(body)));
		document.getDocumentElement().normalize();
				
		String commandName =  document.getDocumentElement().getElementsByTagName("commandName").item(0).getTextContent();
		System.out.println(commandName);
		
		int customerId;
		
		String customerName = document.getDocumentElement().getElementsByTagName("customerName").item(0).getTextContent();
		System.out.println(customerName);
		String customerSurname = document.getDocumentElement().getElementsByTagName("customerSurname").item(0).getTextContent();
		System.out.println(customerSurname);
		String tckn = document.getDocumentElement().getElementsByTagName("tckn").item(0).getTextContent();
		System.out.println(tckn);
		
		Customer customer = new Customer(customerName, customerSurname, tckn);
		Bag bag = new Bag();
		
		//update ve delete için gerekli id'yi almak
		if(!commandName.equals("add_customer_info")) {
			customerId = (int) Integer.parseInt(document.getDocumentElement().getElementsByTagName("customerId").item(0).getTextContent());
			System.out.println("Customer Id" + customerId);
			bag.put(BagKey.ID, (int)customerId);
		}
		
		bag.put(BagKey.NAME, customer.getName());
		bag.put(BagKey.SURNAME, customer.getSurname());
		bag.put(BagKey.TCKN, customer.getTckn());
		
		Bag resultBag = CommandExecuter.executer(commandName, bag);

	}

}
