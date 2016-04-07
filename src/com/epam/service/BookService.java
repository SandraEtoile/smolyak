package com.epam.service;
import com.epam.dao.BookDAO;
import com.epam.dao.DAOFactory;
import com.epam.dao.daoException.DAOException;
import com.epam.entity.Book;
import com.epam.service.serviceException.ServiceException;
public class BookService {
	
	public static StringBuffer getBook(String keyWord) throws ServiceException{
		StringBuffer book = null;
		try{
			DAOFactory daoFactory = DAOFactory.getInstance();
			BookDAO bookDAO = daoFactory.getBookDAO();
			book = bookDAO.find(keyWord);
			if(book.equals(null)){
				throw new ServiceException("Nothing found!");
			}
		}catch(DAOException e){
            throw new ServiceException("Can't get book!");       
		}
			return book;
		
	}
	
	public static void addBook(Book book) throws ServiceException{
		try{
			DAOFactory daoFactory = DAOFactory.getInstance();
			BookDAO bookDAO = daoFactory.getBookDAO();
			bookDAO.add(book);
	    }
		catch(DAOException e){
            throw new ServiceException("Can't add book!");       
		}

	}
	
	

}
