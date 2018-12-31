package org.socialnetwork.apis.friendsmanagement.repository;

import java.util.List;

import org.socialnetwork.apis.friendsmanagement.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
* Notification Repository
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/
public interface NotificationRepository extends JpaRepository<NotificationEntity, String>{
	
	/**
     * @param user
     * @return List of friends for a user
     */
    @Query(nativeQuery = true)
    List<String> getNotifiedUsers(@Param("user") final String user);

}
