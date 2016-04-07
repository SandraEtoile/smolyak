package com.epam.view;

import java.util.ArrayList;

import com.epam.entity.Book;

public class LinraryConsoleView {
	public static void print(Book book) {
		System.out.println(book.getTittle() + " " + book.getAuthor() + " " + book.getYearOfPublication());

	}

	public static void print(Book... books) {
		for (Book book : books) {
			System.out.println(book.getTittle() + " " + book.getAuthor() + " " + book.getYearOfPublication());
		}
	}

	public static void print(ArrayList<Book> books) {
		for (Book book : books) {
			System.out.println(book.getTittle() + " " + book.getAuthor() + " " + book.getYearOfPublication());
		}

	}

}
