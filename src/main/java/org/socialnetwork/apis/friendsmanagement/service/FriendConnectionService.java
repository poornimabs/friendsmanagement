package org.socialnetwork.apis.friendsmanagement.service;

import java.util.List;

import org.socialnetwork.apis.friendsmanagement.dto.FriendConnectionDTO;
import org.socialnetwork.apis.friendsmanagement.dto.UserEmailDTO;

/**
* REST endpoint for friends management.
* <p>
* Provides basic CRUD functionality
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/

public interface FriendConnectionService {

	void friendConnection(FriendConnectionDTO friendConnectionDTO);
	
	List<String> friendsList(UserEmailDTO userEmailDTO);
}
