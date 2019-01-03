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
		validationHandlerForMultipleUserExists(notificationDTO);
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
		validationHandlerForMultipleUserExists(notificationDTO);
		notificationRepository.save(new NotificationEntity(
				notificationDTO.getRequestor(),
				notificationDTO.getTarget(),
				ApplicationConstants.NOTIFY_BLOCKED));
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
	 * Validate User Existence for Multiple User
	 * @param sender
	 */
	private void validationHandlerForMultipleUserExists(NotificationDTO notificationDTO){
		String userEmailCount = userRepository.getMultipleUser(notificationDTO.getRequestor(), 
				notificationDTO.getTarget());
		if(Integer.parseInt(userEmailCount)<2) {
			throw new UserAccountDoesNotExists(ApplicationExceptionConstants.USER_ACCOUNT_NOT_EXISTS);
		}
	}
	
	/**
	 * Validate User Existence for Single User
	 * @param sender
	 */
	private void validationHandlerForUserExists(String sender){
		String userEmail = userRepository.getSingleUser(sender);
		if(userEmail == null) {
			throw new UserAccountDoesNotExists(ApplicationExceptionConstants.USER_ACCOUNT_NOT_EXISTS);
		}
	}

	/**
	 * Validations before duplicate request
	 * @param notificationDTO
	 */
	private void validationsHandler(NotificationDTO notificationDTO, int status) {
		List<String> subscribedUsers = notificationRepository.getExistingSubscribe(notificationDTO.getRequestor(),
				notificationDTO.getTarget(),
				status);
		if(subscribedUsers.size() > 0) {
			throw new DuplicateRequestException(ApplicationExceptionConstants.DUPLICATE_REQUEST);
		}

	}

}