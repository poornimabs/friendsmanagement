package org.socialnetwork.apis.friendsmanagement.service;

import org.socialnetwork.apis.friendsmanagement.dto.AccountDTO;
import org.socialnetwork.apis.friendsmanagement.entity.Users;
import org.socialnetwork.apis.friendsmanagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* User Services Implementation
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UsersRepository userRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Users account(AccountDTO accountDTO) {
		return userRepository.save(new Users(accountDTO.getEmail(), 
				accountDTO.getUsername(), accountDTO.getPassword()));
	}
	
}
