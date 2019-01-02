package org.socialnetwork.apis.friendsmanagement.exception;

import java.util.List;

/**
 * Generic Exception Response
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

public class GenericExceptionResponse{
	private String message;
	private List<String> details;

	public GenericExceptionResponse(String message, List<String> details) {
		this.message = message;
		this.setDetails(details);
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}


}
