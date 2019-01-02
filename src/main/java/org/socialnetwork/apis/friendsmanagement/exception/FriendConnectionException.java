package org.socialnetwork.apis.friendsmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Checks whether friend connection already exists
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class FriendConnectionException extends RuntimeException{
	private static final long serialVersionUID = 5480727803193848220L;
	
	public FriendConnectionException(String exception) {
		super(exception);
	}

}
