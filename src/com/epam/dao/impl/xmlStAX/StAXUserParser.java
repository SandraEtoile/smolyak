package com.epam.dao.impl.xmlStAX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.epam.entity.User;

public class StAXUserParser {
	
	public static List<User> parse() throws FileNotFoundException {
		List<User> users = null;
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream("users.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			users = process(reader);
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return users;
	}

	private static List<User> process(XMLStreamReader reader) throws XMLStreamException {
		List<User> users = new ArrayList<User>();
		User user = null;
		UserEnum userEnum = null;

		while (reader.hasNext()) {
			
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				userEnum = UserEnum.getElementTagName(reader.getLocalName());
				switch (userEnum) {
				case USER:
					user = new User();
					break;
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (userEnum) {
				case NAME:
					user.setName(text);
					break;
				case ID:
					user.setUserId(Integer.parseInt(text));
					break;
				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				userEnum = UserEnum.getElementTagName(reader.getLocalName());
				switch (userEnum) {
				case USER:
					users.add(user);
				}
			}
		}
		return users;
	}
}
