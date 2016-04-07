package com.epam.dao.impl.xmlSAX;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.dao.BookDAO;
import com.epam.dao.daoException.DAOException;
import com.epam.entity.Book;

public class XMLBookParserDAO extends DefaultHandler {
	
	private ArrayList<Book> bookList = new ArrayList<Book>();
	private Book book;
	private StringBuilder text;

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		text = new StringBuilder();
		if (qName.equals("book")) {
			book = new Book();
		}
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		BookEnum tagName = BookEnum.valueOf(qName.toUpperCase().replace(":", "_"));
		switch (tagName) {
		case TITLE:
			book.setTittle(text.toString().trim());
			break;
		case AUTHOR:
			book.setAuthor(text.toString().trim());
			break;
		case YEAR:
			book.setYearOfPublication(Integer.parseInt(text.toString().trim()));
			break;
		case BOOK:
			bookList.add(book);
			book = null;
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
