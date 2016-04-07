package com.epam.service.serviceException;

public class ServiceException extends Throwable {

	private static final long serialVersionUID = 1L;
	private Exception ex;
	
		public ServiceException() {
			
		}
							
		public ServiceException(String exception){
			super(exception);
			
		}
	
		public ServiceException(String exception, Exception e){
			super(exception);
			ex=e;
			
		}

		public Exception getEx() {
			return ex;
		}

		
}
