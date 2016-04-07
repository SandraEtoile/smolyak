package com.epam.dao.impl.xmlStAX;

public enum UserEnum {
	USER, USERS_INFOUSERS, ID, NAME;

	public static UserEnum getElementTagName(String element) {
		switch (element) {
		case "user":
			return USER;
		case "id":
			return ID;
		case "name":
			return NAME;
		case "infoUsers":
			return  USERS_INFOUSERS;
		default:
			throw new EnumConstantNotPresentException(BookEnum.class, element);
		}
	}
}
