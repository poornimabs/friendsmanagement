package org.socialnetwork.apis.friendsmanagement.service;

import java.util.List;

import org.socialnetwork.apis.friendsmanagement.constant.ApplicationConstants;
import org.socialnetwork.apis.friendsmanagement.constant.ApplicationExceptionConstants;
import org.socialnetwork.apis.friendsmanagement.dto.NotificationDTO;
import org.socialnetwork.apis.friendsmanagement.dto.NotifyDTO;
import org.socialnetwork.apis.friendsmanagement.entity.NotificationEntity;
import org.socialnetwork.apis.friendsmanagement.exception.DuplicateRequestException;
import org.socialnetwork.apis.friendsmanagement.exception.UserAccountDoesNotExists;
import org.socialnetwork.apis.friendsmanagement.repository.FriendConnectionRepository;
import org.socialnetwork.apis.friendsmanagement.repository.NotificationRepository;
import org.socialnetwork.apis.friendsmanagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Notifications Request Services Implementation
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */
@Service
public class NotificationServiceImpl implements NotificationService{

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	FriendConnectionRepository friendConnectionRepository;

	@Autowired
	UsersRepository userRepository;


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void subscribe(NotificationDTO notificationDTO) {
		validationsHandler(notificationDTO, ApplicationConstants.STATUS_ACCEPTED);
		notificationRepository.save(new NotificationEntity(
				notificationDTO.getRequestor(),
				notificationDTO.getTarget(),
				ApplicationConstants.NOTIFY_ACCEPTED));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void blockUpdates(NotificationDTO notificationDTO) {
		validationsHandler(notificationDTO, ApplicationConstants.STATUS_BLOCKED);
		notificationRepository.save(new NotificationEntity(
				notificationDTO.getRequestor(),
				notificationDTO.getTarget(),
				ApplicationConstants.NOTIFY_BLOCKED));
		friendConnectionRepository.updateFrienshipStatus(0, notificationDTO.getRequestor(), 
				notificationDTO.getTarget());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> notify(NotifyDTO notifyDTO) {
		validationHandlerForUserExists(notifyDTO.getSender());
		List<String> notifiedUsers = notificationRepository.getNotifiedUsers(notifyDTO.getSender());
		return notifiedUsers;
	}
	
	/**
	 * Validate User Existence
	 * @param sender
	 */
	private void validationHandlerForUserExists(String sender){
		String userCount = userRepository.getSingleUser(sender);
		if(Integer.parseInt(userCount)<2) {
			throw new UserAccountDoesNotExists(ApplicationExceptionConstants.USER_ACCOUNT_NOT_EXISTS);
		}
	}

	/**
	 * Validations before process request
	 * @param notificationDTO
	 */
	private void validationsHandler(NotificationDTO notificationDTO, int status) {
		List<String> subscribedUsers = notificationRepository.getExistingSubsscribe(notificationDTO.getRequestor(),
				notificationDTO.getTarget(),
				status);
		if(subscribedUsers.size() > 0) {
			throw new DuplicateRequestException(ApplicationExceptionConstants.DUPLICATE_REQUEST);
		}

	}

}