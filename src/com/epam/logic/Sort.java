package com.epam.logic;

import java.util.Comparator;

import com.epam.entity.Book;


	public enum Sort implements Comparator<Book> {
		SORTBYTITLE {
			@Override
			public int compare(Book one, Book two) {
				return one.getTittle().compareTo(two.getTittle());
			}

		},
		SORTBYAUTHOR {
			@Override
			public int compare(Book one, Book two) {
				return one.getAuthor().compareTo(two.getAuthor());
			}
		},
		SORTBYYEAR {
			@Override
			public int compare(Book one, Book two) {
				return one.getYearOfPublication() - two.getYearOfPublication();
			}
		};
	}



