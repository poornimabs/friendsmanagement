package org.socialnetwork.apis.friendsmanagement.service;

import java.util.List;

import org.socialnetwork.apis.friendsmanagement.constant.ApplicationConstants;
import org.socialnetwork.apis.friendsmanagement.dto.NotificationDTO;
import org.socialnetwork.apis.friendsmanagement.dto.NotifyDTO;
import org.socialnetwork.apis.friendsmanagement.entity.NotificationEntity;
import org.socialnetwork.apis.friendsmanagement.repository.FriendConnectionRepository;
import org.socialnetwork.apis.friendsmanagement.repository.NotificationRepository;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void subscribe(NotificationDTO notificationDTO) {
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

}