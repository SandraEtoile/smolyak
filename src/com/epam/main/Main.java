package com.epam.main;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.xerces.parsers.DOMParser;
import org.xml.sax.SAXException;

import com.epam.dao.DAOFactory;
import com.epam.dao.daoException.DAOException;
import com.epam.dao.impl.file.FileBookDAO;
import com.epam.dao.impl.file.FileUserDAO;
import com.epam.dao.impl.sql.SQLBookDAO;
import com.epam.dao.impl.sql.SQLUserDAO;
import com.epam.dao.impl.xmlDOM.DOMBookParser;
import com.epam.dao.impl.xmlDOM.DOMUserParser;
import com.epam.dao.impl.xmlSAX.XMLBookDAO;
import com.epam.dao.impl.xmlSAX.XMLBookParserDAO;
import com.epam.dao.impl.xmlSAX.XMLUserDAO;
import com.epam.dao.impl.xmlStAX.StAXBookParser;
import com.epam.entity.Book;
import com.epam.entity.Library;
import com.epam.entity.User;
import com.epam.service.BookService;
import com.epam.service.serviceException.ServiceException;
import com.epam.view.LinraryConsoleView;

public class Main {

	public static void main(String[] args) throws DAOException, ServiceException, ParserConfigurationException, SAXException, IOException {
		com.epam.dao.impl.xmlStAX.XMLUserDAO bookDAO = new com.epam.dao.impl.xmlStAX.XMLUserDAO();
		bookDAO.returnValidationCatalogue("Vasya");
		
	}
}
