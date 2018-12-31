package org.socialnetwork.apis.friendsmanagement.service;

import java.util.List;

import org.socialnetwork.apis.friendsmanagement.dto.NotificationDTO;
import org.socialnetwork.apis.friendsmanagement.dto.NotifyDTO;

/**
* REST endpoint for notification requests.
* <p>
* Provides basic CRUD functionality
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/

public interface NotificationService {
	
	/**
	 * This method is subscribe friends to receive updates/notifications
     * @param notificationDTO
     * @return void
     */
	void subscribe(NotificationDTO notificationDTO);
	
	/**
	 * This method is subscribe friends to receive updates/notifications
     * @param notificationDTO
     * @return void
     */
	void blockUpdates(NotificationDTO notificationDTO);
	
	/**
	 * This method is used to send notification to friends based on conditions
     * @param notificationDTO
     * @return void
     */
	List<String> notify(NotifyDTO notifyDTO);
}
