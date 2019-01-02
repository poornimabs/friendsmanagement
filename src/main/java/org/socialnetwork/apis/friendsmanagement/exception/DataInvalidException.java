package org.socialnetwork.apis.friendsmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * User Data Invalid Exception to handle invalid inputs
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class DataInvalidException extends RuntimeException{
	private static final long serialVersionUID = -3991339224785414791L;

	public DataInvalidException(String exception) {
		super(exception);
	}

}
