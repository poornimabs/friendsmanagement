package org.socialnetwork.apis.friendsmanagement.service;

import org.socialnetwork.apis.friendsmanagement.dto.FriendConnectionDTO;
import org.socialnetwork.apis.friendsmanagement.entity.Friends;
import org.socialnetwork.apis.friendsmanagement.repository.FriendConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* FriendConnections Services Implementation
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/

@Service
public class FriendConnectionServiceImpl implements FriendConnectionService{
	
	@Autowired
	FriendConnectionRepository friendConnectionRepository;

	@Override
	public void friendConnection(FriendConnectionDTO friendConnectionDTO) {
		String personOne = friendConnectionDTO.getFriends().get(0);
        String personTwo = friendConnectionDTO.getFriends().get(1);
		friendConnectionRepository.save(new Friends(personOne,personTwo));
	}
}