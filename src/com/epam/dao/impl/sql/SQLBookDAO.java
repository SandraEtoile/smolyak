package com.epam.dao.impl.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.connectionPool.ConnectionPool;
import com.epam.connectionPool.ConnectionPoolException;
import com.epam.dao.BookDAO;
import com.epam.dao.daoException.DAOException;
import com.epam.entity.Book;

public class SQLBookDAO implements BookDAO {
	ConnectionPool pool;

	@Override
	public void add(Book book) throws DAOException {
		pool = ConnectionPool.getConnectionPool();
		try {

			String addBook = "INSERT INTO Library.Books VALUES(?, ?, ?, ?)";
			pool.initPoolData();
			PreparedStatement pc = pool.createPrepareStatement(addBook);
			pc.setInt(1, generateIdBook());
			pc.setString(2, book.getAuthor());
			pc.setInt(3, book.getYearOfPublication());
			pc.setString(4, book.getTittle());
			pc.executeUpdate();

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Can't add book!", e);
		}

	}

	public int generateIdBook() throws DAOException{
		int id = 0;
		id = (int) (1000 + (Math.random() * (9999 - 1000)));
		try {
			while (customSelect().next()) {
				if (customSelect().getInt("idBook") == id) {
					generateIdBook();
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Can't generate Id book!", e);
		}
		return id;

	}

	@Override
	public StringBuffer find(String keyWord) throws DAOException {
		StringBuffer stringBuffer = new StringBuffer();
		ResultSet rs = customSelect();
		try {
			while (rs.next()) {
				if (rs.getString(2).equals(keyWord) || rs.getString(4).equals(keyWord)) {
					stringBuffer.append(rs.getString(2)).append(rs.getString(4)).append(rs.getInt(3));
					}
			}
		} catch (SQLException e) {
			throw new DAOException("Can't find book!", e);
		}
		return stringBuffer;
	}

	public ResultSet customSelect() throws DAOException{
		pool = ConnectionPool.getConnectionPool();
		ResultSet res = null;
		try {
			String addBook = "SELECT * FROM Library.Books";
			pool.initPoolData();

			PreparedStatement pc = pool.createPrepareStatement(addBook);
			res = pc.executeQuery(addBook);
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Can't select!", e);
		}
		return res;

	}

}
