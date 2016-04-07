package com.epam.dao.impl.xmlDOM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.entity.Book;

public class DOMBookParser {
	public static List<Book> parse() throws SAXException, IOException {

		DOMParser parser = new DOMParser();
		parser.parse("books.xml");
		Document document = parser.getDocument();
		Element root = document.getDocumentElement();
		List<Book> books = new ArrayList<Book>();

		NodeList bookNodes = root.getElementsByTagName("book");
		Book book = null;
		for (int i = 0; i < bookNodes.getLength(); i++) {
			book = new Book();
			Element bookElement = (Element) bookNodes.item(i);
			book.setAuthor(getSingleChild(bookElement, "author").getTextContent().trim());
			book.setTittle(getSingleChild(bookElement, "title").getTextContent().trim());
			// Integer
			book.setYearOfPublication(Integer.parseInt(getSingleChild(bookElement, "year").getTextContent().trim()));
			books.add(book);
		}
		return books;

	}

	private static Element getSingleChild(Element element, String childName) {
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}
}
