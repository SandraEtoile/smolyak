package com.epam.dao;

import com.epam.dao.impl.file.FileBookDAO;
import com.epam.dao.impl.file.FileUserDAO;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private BookDAO bookDAO = (BookDAO) new FileBookDAO();
	private UserDAO userDAO = (UserDAO) new FileUserDAO();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

}
