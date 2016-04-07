package com.epam.dao;

import com.epam.dao.daoException.DAOException;
import com.epam.entity.Book;

public interface BookDAO {
	public void add(Book book) throws DAOException;
	public StringBuffer find(String keyWord) throws DAOException;
	

}
