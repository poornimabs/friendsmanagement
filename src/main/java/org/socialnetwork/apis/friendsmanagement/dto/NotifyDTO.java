package org.socialnetwork.apis.friendsmanagement.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * NotifyDTO Data Transfer Object
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

public class NotifyDTO implements Serializable{
	private static final long serialVersionUID = -1822135377222820305L;

	@NotEmpty(message="Sender email cannot be an empty string")
	@NotNull(message="Sender email cannot be null")
	@Email(message="Please provide a valid email address")
	private String sender;
	
	@NotEmpty(message="Notification cannot be an empty string")
	@NotNull(message="Notification cannot be null")
	@Size(min=2, message="Notification should have atleast 2 characters")
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
