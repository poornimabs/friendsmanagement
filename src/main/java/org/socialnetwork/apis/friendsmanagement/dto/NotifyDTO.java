package org.socialnetwork.apis.friendsmanagement.dto;

import java.io.Serializable;

/**
 * NotifyDTO Data Transfer Object
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

public class NotifyDTO implements Serializable{
	private static final long serialVersionUID = -1822135377222820305L;

	private String sender;
	private String text;

	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
