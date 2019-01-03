package org.socialnetwork.apis.friendsmanagement.service;

import java.util.List;

import org.socialnetwork.apis.friendsmanagement.constant.ApplicationConstants;
import org.socialnetwork.apis.friendsmanagement.constant.ApplicationExceptionConstants;
import org.socialnetwork.apis.friendsmanagement.dto.FriendConnectionDTO;
import org.socialnetwork.apis.friendsmanagement.dto.UserEmailDTO;
import org.socialnetwork.apis.friendsmanagement.entity.FriendrelationEntity;
import org.socialnetwork.apis.friendsmanagement.exception.BlockedFriendshipException;
import org.socialnetwork.apis.friendsmanagement.exception.DataInvalidException;
import org.socialnetwork.apis.friendsmanagement.exception.FriendConnectionException;
import org.socialnetwork.apis.friendsmanagement.exception.UserAccountDoesNotExists;
import org.socialnetwork.apis.friendsmanagement.repository.FriendConnectionRepository;
import org.socialnetwork.apis.friendsmanagement.repository.NotificationRepository;
import org.socialnetwork.apis.friendsmanagement.repository.UsersRepository;
import org.socialnetwork.apis.friendsmanagement.utilities.Validator;
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
public class FriendRelationServiceImpl implements FriendRelationService{

	@Autowired
	FriendConnectionRepository friendConnectionRepository;

	@Autowired
	UsersRepository userRepository;

	@Autowired
	NotificationRepository notificationRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void friendconnection(FriendConnectionDTO friendConnectionDTO) {
		friendConnectionValidation(friendConnectionDTO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> friendsList(UserEmailDTO userEmailDTO) {
		String userCount = userRepository.getSingleUser(userEmailDTO.getEmail());
		if(Integer.parseInt(userCount)<2) {
			throw new UserAccountDoesNotExists(ApplicationExceptionConstants.USER_ACCOUNT_NOT_EXISTS);
		}
		List<String> friendsList = friendConnectionRepository.getFriends(userEmailDTO.getEmail());
		return friendsList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> commonFriends(FriendConnectionDTO friendConnectionDTO) {
		commonValidations(friendConnectionDTO);
		List<String> friendsList = friendConnectionRepository.getCommonFriends(friendConnectionDTO.getFriends().get(0), 
				friendConnectionDTO.getFriends().get(1));
		return friendsList;
	}

	/**
	 * Validates for Resource and creates friend connection
	 * @param friendConnectionDTO
	 * @return void
	 */
	private void friendConnectionValidation(FriendConnectionDTO friendConnectionDTO) {
		resourceValidations(friendConnectionDTO);
		friendConnectionRepository.save(new FriendrelationEntity(friendConnectionDTO.getFriends().get(0),
				friendConnectionDTO.getFriends().get(1),
				ApplicationConstants.STATUS_ACCEPTED));
	}

	/**
	 * Resource Validations
	 * Checks for RequestBody Validation
	 * Checks for valid numbers of users email id sent
	 * Checks for Email Valid
	 * Checks for user account exists
	 * Checks for Status Blocked, Unsubscribed User
	 * Checks whether friendship already exists
	 * @param friendConnectionDTO
	 * @return void
	 */
	private void resourceValidations(FriendConnectionDTO friendConnectionDTO) {
		commonValidations(friendConnectionDTO);
		List<String> friendShipBlocked = notificationRepository.getBlockedUsersForUpdates(
				friendConnectionDTO.getFriends().get(0),
				friendConnectionDTO.getFriends().get(1), ApplicationConstants.STATUS_BLOCKED);
		if(friendShipBlocked.size() > 0) {
			throw new BlockedFriendshipException(ApplicationExceptionConstants.UNSUBSCRIBED_FRIENDSHIP_BLOCKED);
		}

		List<String> friendConnection = friendConnectionRepository.getFriendConnection(
				friendConnectionDTO.getFriends().get(0),
				friendConnectionDTO.getFriends().get(1), ApplicationConstants.STATUS_ACCEPTED);
		if(friendConnection.size() > 0) {
			throw new FriendConnectionException(ApplicationExceptionConstants.FRIENDSHIP_EXISTS);
		}
		List<String> blockedFriend = friendConnectionRepository.getFriendConnection(
				friendConnectionDTO.getFriends().get(0),
				friendConnectionDTO.getFriends().get(1), ApplicationConstants.STATUS_BLOCKED);
		if(blockedFriend.size() > 0) {
			throw new FriendConnectionException(ApplicationExceptionConstants.FRIENDSHIP_BLOCKED);
		}
	}

	/**
	 * Common Validations
	 * @param friendConnectionDTO
	 */
	private void commonValidations(FriendConnectionDTO friendConnectionDTO) {
		if(friendConnectionDTO.getFriends().isEmpty() || friendConnectionDTO == null) {
			throw new DataInvalidException(ApplicationExceptionConstants.FRIENDRELATION_VALIDATION_FAILED);
		}
		if(friendConnectionDTO.getFriends().size()>2 || friendConnectionDTO.getFriends().size()<2) {
			throw new DataInvalidException(ApplicationExceptionConstants.FRIENDS_CONNECTION);
		} 
		boolean validEmail = Validator.isEmailValid(friendConnectionDTO.getFriends().get(0),
				friendConnectionDTO.getFriends().get(1));
		if(!validEmail) {
			throw new DataInvalidException(ApplicationExceptionConstants.INVALID_EMAIL);
		}
		String userCount = userRepository.getMultipleUser(friendConnectionDTO.getFriends().get(0), 
				friendConnectionDTO.getFriends().get(1));
		if(Integer.parseInt(userCount)<2) {
			throw new UserAccountDoesNotExists(ApplicationExceptionConstants.USER_ACCOUNT_NOT_EXISTS);
		}
	}

}
