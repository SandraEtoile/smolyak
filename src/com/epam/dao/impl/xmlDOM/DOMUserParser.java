package com.epam.dao.impl.xmlDOM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.entity.User;

public class DOMUserParser {

	public static List<User> parse() throws SAXException, IOException {

		DOMParser parser = new DOMParser();
		parser.parse("users.xml");
		Document document = parser.getDocument();
		Element root = document.getDocumentElement();
		List<User> users = new ArrayList<User>();

		NodeList userNodes = root.getElementsByTagName("user");
		User user = null;
		for (int i = 0; i < userNodes.getLength(); i++) {
			user = new User();
			Element userElement = (Element) userNodes.item(i);
			user.setName(getSingleChild(userElement, "name").getTextContent().trim());
			user.setUserId(Integer.parseInt(getSingleChild(userElement, "id").getTextContent().trim()));
			users.add(user);
		}

		return users;

	}

	private static Element getSingleChild(Element element, String childName) {
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}
}
