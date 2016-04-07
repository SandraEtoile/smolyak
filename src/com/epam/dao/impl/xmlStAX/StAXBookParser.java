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

import com.epam.entity.Book;

public class StAXBookParser {

	public static List<Book> parse() throws FileNotFoundException {
		List<Book> books = null;
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream("books.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			books= process(reader);
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return books;
	}

	private static List<Book> process(XMLStreamReader reader) throws XMLStreamException {
		List<Book> books = new ArrayList<Book>();
		Book book = null;
		BookEnum bookEnum = null;

		while (reader.hasNext()) {
			
			int type = reader.next();
			switch (type) {
							
			case XMLStreamConstants.START_ELEMENT:
				bookEnum = BookEnum.getElementTagName(reader.getLocalName());
				switch (bookEnum) {
				case BOOK:
					book = new Book();
					break;
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (bookEnum) {
				case TITLE:
					book.setTittle(text);
					break;
				case AUTHOR:
					book.setAuthor(text);
					break;
				case YEAR:
					book.setYearOfPublication(Integer.parseInt(text));
					break;
				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				bookEnum = BookEnum.getElementTagName(reader.getLocalName());
				switch (bookEnum) {
				case BOOK:
					books.add(book);
				}
			}
		}
		return books;
	}
}
