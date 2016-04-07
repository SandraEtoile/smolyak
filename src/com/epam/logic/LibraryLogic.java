package com.epam.logic;

import java.util.ArrayList;

import com.epam.entity.Book;

public class LibraryLogic{

	private ArrayList<Book> booksByTittle = new ArrayList<>();

	public ArrayList<Book> getBooksByTittle() {
		return booksByTittle;
	}

	/*
	public ArrayList<Book> findTittles(ArrayList<Book> books, String tittle) {
		for (Book x : books) {
			if (x.getTittle().equals(tittle) || x.getAuthor().equals(tittle)) {
				booksByTittle.add(x);
			}
		}
		return booksByTittle;
	}
*/

	/*public ArrayList<Book> findYears(ArrayList<Book> books, int year) {
		for (Book x : books) {
			if (x.getYearOfPublication() == year) {
				booksByTittle.add(x);
			}
		}
		return booksByTittle;
	}*/
	public ArrayList<Book> findTittles(ArrayList<Book> books, String keyWord) {
		for (Book x : books) {
			String []mas = x.toString().split(" ");
			for(String item: mas){
				if(item.equals(keyWord)){
					booksByTittle.add(x);
				}
			}
			
		}
		return booksByTittle;
		}
		
	

}
