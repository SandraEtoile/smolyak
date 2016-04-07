package com.epam.dao.impl.xmlStAX;

public enum BookEnum {
	BOOK, TITLE, AUTHOR, YEAR, BOOKS_INFOBOOKS;

	public static BookEnum getElementTagName(String element) {
		switch (element) {
		case "book":
			return BOOK;
		case "title":
			return TITLE;
		case "author":
			return AUTHOR;
		case "year":
			return YEAR;
		case "infoBooks":
			return BOOKS_INFOBOOKS;
		
		default:
			throw new EnumConstantNotPresentException(BookEnum.class, element);
		}
	}
}
