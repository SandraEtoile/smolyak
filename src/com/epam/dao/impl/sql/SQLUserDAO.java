package com.epam.dao.impl.sql;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.epam.connectionPool.ConnectionPool;
import com.epam.connectionPool.ConnectionPoolException;
import com.epam.dao.UserDAO;
import com.epam.dao.daoException.DAOException;
import com.epam.entity.Book;
import com.epam.entity.User;

public class SQLUserDAO implements UserDAO {
	ConnectionPool pool;
	SQLBookDAO bookDAO = new SQLBookDAO();
	Statement st;

	@Override
	public void register(User user) throws DAOException {
		pool = ConnectionPool.getConnectionPool();
		String addUser = "INSERT INTO Library.User VALUES(?, ?)";
		try {
	
			pool.initPoolData();
			PreparedStatement pc = pool.createPrepareStatement(addUser);
			pc.setInt(1, user.getUserId());
			pc.setString(2, user.getName());
			pc.executeUpdate();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Can't register user!", e);
		}
	}

	@Override
	public ArrayList<Book> returnValidationCatalogue(String name) throws DAOException {
		ArrayList<Book> listOfBooks = new ArrayList<>();
		String books = "SELECT * FROM Library.Books";
		if (checkUser(name) == true) {
			try {
				while (makeRequestForSQL(books).next()) {
					Book book = new Book();
					book.setAuthor(makeRequestForSQL(books).getString(2));
					book.setTittle(makeRequestForSQL(books).getString(4));
					book.setYearOfPublication(makeRequestForSQL(books).getInt(3));
					listOfBooks.add(book);
				}
			} catch (SQLException e) {
				throw new DAOException("Can't return catalogue!", e);
			}
		}
		return listOfBooks;
	}

	@Override
	public boolean checkUser(String name) throws DAOException {
		Boolean result = false;
		try {
			String checkUser = "SELECT * FROM Library.User";
			while (makeRequestForSQL(checkUser).next()) {
				if (makeRequestForSQL(checkUser).getString(2).equals(name)) {
					result = true;
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Can't check user!", e);
		}
		return result;
	}

	public ResultSet makeRequestForSQL(String request) throws DAOException {
		pool = ConnectionPool.getConnectionPool();
		ResultSet res = null;
		PreparedStatement pc;
		try {
			pool.initPoolData();
			pc = pool.createPrepareStatement(request);
			res = pc.executeQuery(request);
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Can't make request for sql!", e);
		}
		return res;

	}

}
