package com.epam.dao.impl.xmlSAX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import com.epam.dao.UserDAO;
import com.epam.dao.daoException.DAOException;
import com.epam.entity.Book;
import com.epam.entity.User;

public class XMLUserDAO implements UserDAO {
	public List<User> users;
	XMLBookDAO bookdao=new XMLBookDAO();

	public void parseXML() throws DAOException{
		try{
		XMLReader reader = XMLReaderFactory.createXMLReader();
		XMLUserParserDAO userParser = new XMLUserParserDAO();
		reader.setContentHandler(userParser);
		reader.parse(new InputSource("users.xml"));
		reader.setFeature("http://xml.org/sax/features/validation", true);
		reader.setFeature("http://xml.org/sax/features/namespaces", true);
		reader.setFeature("http://xml.org/sax/features/string-interning", true);
		users = userParser.getUserList();
		}
		catch(SAXException | IOException e){
			throw new DAOException("error",e);
		}
	}

	@Override
	public void register(User user) throws DAOException {
	}

	@Override
	public ArrayList<Book> returnValidationCatalogue(String name) throws DAOException {
		ArrayList<Book> bookList = new ArrayList<Book>();
		if(checkUser(name)==true){
			bookList=(ArrayList<Book>) bookdao.parseXML(); 			
		}	
	
		return bookList;
	}

	@Override
	public boolean checkUser(String name) throws DAOException {
		boolean result = false;
		for (User item : users) {
			if (item.getName().equals(name)) {
				result = true;
			}
		}
		return result;
	}
}
