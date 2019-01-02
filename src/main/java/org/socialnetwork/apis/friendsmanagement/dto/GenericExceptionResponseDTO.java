package org.socialnetwork.apis.friendsmanagement.dto;

import java.util.Date;

/**
 * ValidationResponse Data Transfer Object
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

public class GenericExceptionResponseDTO {

	private Date timestamp;
	private String message;
	private String details;

	public GenericExceptionResponseDTO(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
