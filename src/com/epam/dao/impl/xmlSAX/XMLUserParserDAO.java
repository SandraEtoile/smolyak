package com.epam.dao.impl.xmlSAX;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import com.epam.entity.User;

public class XMLUserParserDAO extends DefaultHandler {

	private List<User> userList = new ArrayList<User>();
	private User user;
	private StringBuilder text;

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		text = new StringBuilder();
		if (qName.equals("user")) {
			user = new User();
		}
	}

	public List<User> getUserList() {
		return userList;
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		UserEnum tagName = UserEnum.valueOf(qName.toUpperCase().replace(":", "_"));
		switch (tagName) {
		case ID:
			user.setUserId(Integer.parseInt(text.toString()));
			break;
		case NAME:
			user.setName(text.toString());
			break;
		case USER:
			userList.add(user);
			user = null;
			break;
		}

	}

	public void warning(SAXParseException exception) {
		System.err.println("WARNING: line" + exception.getLineNumber() + ":" + exception.getMessage());
	}

	public void error(SAXParseException exception) {
		System.err.println("ERROR: line" + exception.getLineNumber() + ":" + exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.err.println("FATAL: line" + exception.getLineNumber() + ":" + exception.getMessage());
		throw (exception);
	}

	public StringBuilder getText() {
		return text;
	}

}
