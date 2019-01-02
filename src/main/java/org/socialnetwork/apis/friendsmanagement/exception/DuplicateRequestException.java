package org.socialnetwork.apis.friendsmanagement.exception;

/**
 * Duplicate Request Exception
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

public class DuplicateRequestException extends RuntimeException{
	private static final long serialVersionUID = 4611749467082840623L;
	
	public DuplicateRequestException(String exception) {
		super(exception);
	}

}
