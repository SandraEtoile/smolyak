package com.epam.dao.impl.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.epam.dao.BookDAO;
import com.epam.dao.daoException.DAOException;
import com.epam.entity.Book;

public class FileBookDAO implements BookDAO {
	public File fileBooks = new File("\\books.txt");
	private BufferedReader bufferedReader;
	private BufferedWriter bufferWriter;

	@Override
	public void add(Book book) throws DAOException {
		try {
			FileWriter fileWriter = new FileWriter(fileBooks.getName(), true);
			bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write(book.getTittle() + "-" + book.getAuthor() + "-" + book.getYearOfPublication() + "\n");
		} catch (IOException e) {
			throw new DAOException("Can't add book!", e);
		} finally {
			try {
				bufferWriter.close();
			} catch (IOException e) {
				throw new DAOException("Can't close stream!", e);
			}
		}
	}

	@Override
	public StringBuffer find(String keyWord) throws DAOException {
		StringBuffer stringBuffer = new StringBuffer();
		String line = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileBooks));
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains(keyWord)) {
					stringBuffer.append(line).append("\n");
				}
			}
		} catch (IOException e) {
			throw new DAOException("Can't find book!", e);
		} finally {
			try {

				bufferedReader.close();
			} catch (IOException e) {
				throw new DAOException("Can't close stream!", e);
			}
		}
		return stringBuffer;

	}
	

}
