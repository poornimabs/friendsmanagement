package org.socialnetwork.apis.friendsmanagement.service;

import org.socialnetwork.apis.friendsmanagement.dto.AccountDTO;
import org.socialnetwork.apis.friendsmanagement.entity.Users;

/**
* User service to handle adding an account
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/

public interface UserService {
	
	Users account(AccountDTO accountDTO); 

}
