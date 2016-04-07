package com.epam.dao.impl.xmlStAX;

import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.SAXException;

import com.epam.dao.UserDAO;
import com.epam.dao.daoException.DAOException;
import com.epam.dao.impl.xmlDOM.DOMBookParser;
import com.epam.dao.impl.xmlDOM.DOMUserParser;
import com.epam.entity.Book;
import com.epam.entity.User;

public class XMLUserDAO implements UserDAO{

	@Override
	public void register(User user) throws DAOException {	
	}

	@Override
	public ArrayList<Book> returnValidationCatalogue(String name) throws DAOException {
		ArrayList<Book> bookList = new ArrayList<Book>();
		if (checkUser(name) == true) {
			try {
				bookList = (ArrayList<Book>) StAXBookParser.parse();
			} catch (IOException e) {
				throw new DAOException("Can't return catalogue!", e);
			}
		}
			return bookList;
	}

	@Override
	public boolean checkUser(String name) throws DAOException {
		boolean result = false;
		ArrayList<User> userList = new ArrayList<User>();
		try {
			userList = (ArrayList<User>) StAXUserParser.parse();
		} catch (IOException e) {
			throw new DAOException("Can't check user!", e);
		}
		for (User item : userList) {
			if (item.getName().equals(name)) {
				result = true;
			}
		}
		return result;
	}

}
