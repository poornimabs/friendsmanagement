package org.socialnetwork.apis.friendsmanagement.service;

import org.socialnetwork.apis.friendsmanagement.dto.AccountDTO;
import org.socialnetwork.apis.friendsmanagement.entity.UserEntity;

/**
* User service to handle adding an account
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/

public interface UserService {
	
	/**
	 * This method is used to create an account for a user
     * @param friendConnectionDTO
     * @return void
     */
	UserEntity account(AccountDTO accountDTO); 

}
