package org.socialnetwork.apis.friendsmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Record Not Found Exception Handler
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

@ResponseStatus(value=HttpStatus.NOT_FOUND)  // 404
public class RecordNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 4217649778333099187L;

	public RecordNotFoundException() {
		super();
	}

	public RecordNotFoundException(final String exception) {
		super(exception);
	}
}
