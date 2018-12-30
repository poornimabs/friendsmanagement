package org.socialnetwork.apis.friendsmanagement.dto;

import java.io.Serializable;
import java.util.List;

/**
* FriendConnection Data Transfer Object
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/

public class FriendConnectionDTO implements Serializable{
	
	private static final long serialVersionUID = 8881170598465378160L;
	
	private List<String> friends;

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
}
