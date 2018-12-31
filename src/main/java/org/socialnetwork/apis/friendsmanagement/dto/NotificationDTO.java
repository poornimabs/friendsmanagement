package org.socialnetwork.apis.friendsmanagement.dto;

import java.io.Serializable;

/**
 * NotificationDTO Data Transfer Object
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

public class NotificationDTO implements Serializable{

	private static final long serialVersionUID = 1102744786883391477L;

	private String requestor;
	private String target;

	public String getRequestor() {
		return requestor;
	}
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}

}
