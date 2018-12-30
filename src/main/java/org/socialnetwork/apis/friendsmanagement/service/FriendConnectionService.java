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

	/**
	 * This method is used to create a friendship b/w two users
     * @param friendConnectionDTO
     * @return void
     */
	void friendConnection(FriendConnectionDTO friendConnectionDTO);
	
	/**
	 * This methos is used to get friends list wrt single user
     * @param userEmailDTO
     * @return Friends List for user
     */
	List<String> friendsList(UserEmailDTO userEmailDTO);
}
