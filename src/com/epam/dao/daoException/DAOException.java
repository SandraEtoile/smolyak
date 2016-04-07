package com.epam.dao.daoException;

public class DAOException extends Throwable{

	private static final long serialVersionUID = 1L;
	private Exception er;

	public DAOException(){
	
		
	}
		public DAOException(String message){
		super(message);
		
	}

	public DAOException(String message, Exception e){
		super(message);
		er=e;
		
	}
	public Exception getE() {
		return er;
	}
	

}
