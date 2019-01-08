package org.socialnetwork.apis.friendsmanagement.dto;

/**
 * Argument Binding Validation
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */


public class ArgumentBindingExceptionDTO {

	private String field;
	private String message;

	public ArgumentBindingExceptionDTO(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
