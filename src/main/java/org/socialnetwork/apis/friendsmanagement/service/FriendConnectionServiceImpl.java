package org.socialnetwork.apis.friendsmanagement.service;

import java.util.List;

import org.socialnetwork.apis.friendsmanagement.constant.ApplicationConstants;
import org.socialnetwork.apis.friendsmanagement.dto.FriendConnectionDTO;
import org.socialnetwork.apis.friendsmanagement.dto.UserEmailDTO;
import org.socialnetwork.apis.friendsmanagement.entity.FriendrelationEntity;
import org.socialnetwork.apis.friendsmanagement.repository.FriendConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FriendConnections/Requests Services Implementation
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

@Service
public class FriendConnectionServiceImpl implements FriendConnectionService{

	@Autowired
	FriendConnectionRepository friendConnectionRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void friendConnection(FriendConnectionDTO friendConnectionDTO) {
		String personOne = friendConnectionDTO.getFriends().get(0);
		String personTwo = friendConnectionDTO.getFriends().get(1);
		friendConnectionRepository.save(new FriendrelationEntity(personOne,personTwo,
				ApplicationConstants.STATUS_ACCEPTED));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> friendsList(UserEmailDTO userEmailDTO) {
		List<String> friendsList = friendConnectionRepository.getFriends(userEmailDTO.getEmail());
		return friendsList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> commonFriends(FriendConnectionDTO friendConnectionDTO) {
		List<String> friendsList = friendConnectionRepository.getCommonFriends(friendConnectionDTO.getFriends().get(0), 
				friendConnectionDTO.getFriends().get(1));
		return friendsList;
	}
	
}
