package org.socialnetwork.apis.friendsmanagement.service;

import java.util.List;

import org.socialnetwork.apis.friendsmanagement.constant.ApplicationConstants;
import org.socialnetwork.apis.friendsmanagement.constant.ApplicationExceptionConstants;
import org.socialnetwork.apis.friendsmanagement.dto.NotificationDTO;
import org.socialnetwork.apis.friendsmanagement.dto.NotifyDTO;
import org.socialnetwork.apis.friendsmanagement.entity.NotificationEntity;
import org.socialnetwork.apis.friendsmanagement.exception.DataInvalidException;
import org.socialnetwork.apis.friendsmanagement.exception.DuplicateRequestException;
import org.socialnetwork.apis.friendsmanagement.repository.FriendConnectionRepository;
import org.socialnetwork.apis.friendsmanagement.repository.NotificationRepository;
import org.socialnetwork.apis.friendsmanagement.repository.UsersRepository;
import org.socialnetwork.apis.friendsmanagement.utilities.Validator;
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
		validationsHandler(notificationDTO);
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
		List<String> notifiedUsers = notificationRepository.getNotifiedUsers(notifyDTO.getSender());
		return notifiedUsers;
	}
	
	/**
	 * Validations before process request
	 * @param notificationDTO
	 */
	private void validationsHandler(NotificationDTO notificationDTO) {
		boolean validEmail = Validator.isEmailValid(notificationDTO.getRequestor(),
				notificationDTO.getTarget());
		if(!validEmail) {
			throw new DataInvalidException(ApplicationExceptionConstants.INVALID_EMAIL);
		}
		
		List<String> subscribedUsers = notificationRepository.getExistingSubsscribe(notificationDTO.getRequestor(), notificationDTO.getTarget(),
				ApplicationConstants.STATUS_ACCEPTED);
		if(subscribedUsers.size() > 0) {
			throw new DuplicateRequestException(ApplicationExceptionConstants.DUPLICATE_SUBSCRIBED_USERS);
		}
		
	}

}