package org.socialnetwork.apis.friendsmanagement.service;

import org.socialnetwork.apis.friendsmanagement.dto.FriendConnectionDTO;

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
}
