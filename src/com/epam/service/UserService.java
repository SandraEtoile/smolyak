package com.epam.service;

import java.util.ArrayList;

import com.epam.dao.DAOFactory;
import com.epam.dao.UserDAO;
import com.epam.dao.daoException.DAOException;
import com.epam.entity.Book;
import com.epam.entity.User;
import com.epam.service.serviceException.ServiceException;

public class UserService {
	
	public static boolean validateUser(String name) throws ServiceException{
		boolean validation=false;
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		try{
			validation=userDAO.checkUser(name);
			if(name.equals(null)){
				throw new ServiceException("Nothing found!");
			}
		}catch(DAOException ex){
            throw new ServiceException("Can't validate user!");       
		}
		return validation;
	}
	
	public static void registerUser(User user)throws ServiceException{	
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();
		try{
		
			userDAO.register(user);
		}catch(DAOException ex){
            throw new ServiceException("Can't register user!");       
		}
	}
	
	public static ArrayList<Book> reviewCatalogue(String name)throws ServiceException{
		ArrayList<Book> catalogue=new ArrayList<>();
		DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();
		try{
			catalogue = userDAO.returnValidationCatalogue(name);
		}catch(DAOException ex){
            throw new ServiceException("Can't reviw catalogue!");       
		}
		return catalogue;
	}

}
