package ramen.exception;

import log.Log4J;

public class NotExistException extends Exception {
	
	private Log4J log = Log4J.getInstance();
	public NotExistException() {}

	public NotExistException(String message) {
		super(message);
		log.error();
	}
}
