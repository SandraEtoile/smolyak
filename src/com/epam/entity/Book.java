package com.epam.entity;

public class Book {
	private String tittle;
	private String author;
	private int yearOfPublication;

	public Book(String title, String author, int yearOfPublication) {
		this.tittle = title;
		this.author = author;
		this.yearOfPublication = yearOfPublication;
	}
	public Book() {

	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (null == obj) {
			return true;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Book book = (Book) obj;
		if (yearOfPublication != book.yearOfPublication) {
			return false;
		}
		if (null == author) {
			return (author == book.author);
		} else {
			if (!author.equals(book.author)) {
				return false;
			}
		}
		if (null == tittle) {
			return (tittle == book.tittle);
		} else {
			if (!tittle.equals(book.tittle)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return (int) (10 * yearOfPublication + ((null == tittle) ? 0 : tittle.hashCode())
				+ ((null == author) ? 0 : author.hashCode()));
	}

	@Override
	public String toString() {
		return getClass().getName() + "@" + " " + tittle + " " + yearOfPublication + "  " + author;
	}

}
