package com.epam.dao.impl.xmlDOM;

import java.io.IOException;
import java.util.ArrayList;
import org.xml.sax.SAXException;
import com.epam.dao.BookDAO;
import com.epam.dao.daoException.DAOException;
import com.epam.entity.Book;

public class XMLBookDAO implements BookDAO {
	ArrayList<Book> books;

	@Override
	public void add(Book book) throws DAOException {

	}

	@Override
	public StringBuffer find(String keyWord) throws DAOException {
		StringBuffer stringBuffer = new StringBuffer();
		try {
			books = (ArrayList<Book>) DOMBookParser.parse();
			for (Book item : books) {
				if (item.getAuthor().equals(keyWord) || item.getTittle().equals(keyWord)) {
					stringBuffer.append(item.getTittle()).append(item.getAuthor()).append(item.getYearOfPublication());

				}
			}
		} catch (SAXException | IOException e) {
			throw new DAOException("Can't find book!", e);
		}
		return stringBuffer;
	}

}
