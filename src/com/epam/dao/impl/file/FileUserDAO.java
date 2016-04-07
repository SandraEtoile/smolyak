package com.epam.dao.impl.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.epam.dao.UserDAO;
import com.epam.dao.daoException.DAOException;
import com.epam.entity.Book;
import com.epam.entity.User;

public class FileUserDAO implements UserDAO {
	private File fileUser = new File("\\users.txt");
	private File fileBooks = new File("\\books.txt");
	private BufferedReader bufferedReader;
	private BufferedWriter bufferWriter;
	private ArrayList<Book> books = new ArrayList<>();

	public ArrayList<Book> getBookAll() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public void register(User user) throws DAOException {
		try {
			FileWriter fileWriter = new FileWriter(fileUser.getName(), true);
			bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write(user.getName() + " " + user.getUserId() + "\n");
		} catch (IOException e) {
			throw new DAOException("Can't register!", e);
		} finally {
			try {
				bufferWriter.close();
			} catch (IOException e) {
				throw new DAOException("Can't close stream!", e);
			}

		}

	}

	public boolean checkUser(String name) throws DAOException {
		String line = null;
		boolean result = false;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileUser));
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains(name)) {
					result = true;
					break;
				} else {
					result = false;
				}
			}
		} catch (IOException e) {
			throw new DAOException("Can't check user!", e);
		} 
		finally{ 
			try {
			bufferWriter.close();
		} catch (IOException e) {
			throw new DAOException("Can't close stream!", e);
		}
		}
		return result;
	}

	public ArrayList<Book> returnCatalogue() throws DAOException {
		String line = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileBooks));
			while ((line = bufferedReader.readLine()) != null) {
				Book book = new Book();
				String[] bookinfo = line.split("-");
				book.setTittle(bookinfo[0]);
				book.setAuthor(bookinfo[1]);
				book.setYearOfPublication(Integer.parseInt(bookinfo[2]));
				books.add(book);
			}
		} catch (IOException e) {
			throw new DAOException("Can't return catalogue!", e);
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				throw new DAOException("Can't close stream!", e);
			}
		}
		return books;
	}


	public ArrayList<Book> returnValidationCatalogue(String name) throws DAOException {
		ArrayList<Book> catalogue = new ArrayList<>();
		if (checkUser(name) == true) {
			catalogue = returnCatalogue();

		} else {
			throw new DAOException("Not allowed");
		}
		return catalogue;
	}


}
