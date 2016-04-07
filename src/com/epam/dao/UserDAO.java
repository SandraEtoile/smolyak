package com.epam.dao;

import java.util.ArrayList;

import com.epam.connectionPool.ConnectionPoolException;
import com.epam.dao.daoException.DAOException;
import com.epam.entity.Book;
import com.epam.entity.User;

public interface UserDAO {
	public void register(User user) throws  DAOException;

	public ArrayList<Book> returnValidationCatalogue(String name) throws DAOException;

	boolean checkUser(String name) throws DAOException;
}
