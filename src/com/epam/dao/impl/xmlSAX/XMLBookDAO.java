package com.epam.dao.impl.xmlSAX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.dao.BookDAO;
import com.epam.dao.daoException.DAOException;
import com.epam.entity.Book;

public class XMLBookDAO implements BookDAO{
	public ArrayList<Book> books;
	
	public ArrayList<Book> getBooks() {
		return books;
	}

	public List<Book> parseXML() throws DAOException{
		try{
		XMLReader reader =  XMLReaderFactory.createXMLReader();
		XMLBookParserDAO bookParser =  new XMLBookParserDAO();
		reader.setContentHandler(bookParser);
		reader.parse(new InputSource("books.xml"));
		reader.setFeature("http://xml.org/sax/features/validation", true);
		reader.setFeature("http://xml.org/sax/features/namespaces", true);
		reader.setFeature("http://xml.org/sax/features/string-interning", true);
		books = bookParser.getBookList();
		}
		catch(SAXException | IOException e){
			throw new DAOException("error",e);
		}
		return books;
	}

	@Override
	public void add(Book book) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StringBuffer find(String keyWord) throws DAOException {
		StringBuffer stringBuffer = new StringBuffer();
		for(Book item: books){
			if(item.getAuthor().equals(keyWord) || item.getTittle().equals(keyWord)){
				stringBuffer.append(item.getTittle()).append(item.getAuthor()).append(item.getYearOfPublication());
			
			}
			
		}
		return stringBuffer;
	}
	

}
