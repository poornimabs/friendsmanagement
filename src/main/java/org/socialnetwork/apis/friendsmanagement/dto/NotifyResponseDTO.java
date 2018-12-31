package org.socialnetwork.apis.friendsmanagement.dto;

import java.util.List;

/**
* NotifyResposneDTO Data Transfer Object
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/


public class NotifyResponseDTO extends ResponseDTO{
	
	private List<String> recipients;

	public NotifyResponseDTO(List<String> recipients) {
		super(true);
		this.setRecipients(recipients);
	}

	public List<String> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}
	
	

}
