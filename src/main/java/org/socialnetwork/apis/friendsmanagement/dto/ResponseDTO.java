package org.socialnetwork.apis.friendsmanagement.dto;

/**
* Response Data Transfer Object
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/

public class ResponseDTO {
	
	private boolean success;
	
	public ResponseDTO(boolean success) {
		super();
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	

}
