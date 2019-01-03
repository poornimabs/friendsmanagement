package org.socialnetwork.apis.friendsmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Duplicate Request Exception
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateRequestException extends RuntimeException{
	private static final long serialVersionUID = 4611749467082840623L;
	
	public DuplicateRequestException(String exception) {
		super(exception);
	}

}
