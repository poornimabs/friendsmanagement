package org.socialnetwork.apis.friendsmanagement.repository;


import java.util.List;

import org.socialnetwork.apis.friendsmanagement.entity.FriendrelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
* FriendConnection Repository class
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/


public interface FriendConnectionRepository extends JpaRepository<FriendrelationEntity, String>{
	
	/**
     * @param user
     * @return List of friends for a user
     */
    @Query(nativeQuery = true)
    List<String> getFriends(@Param("user") final String user);
    
    /**
     * @param userone usertwo
     * @return List of friends for a user
     */
    @Query(nativeQuery = true)
    List<String> getCommonFriends(@Param("userone") final String userone, @Param("usertwo") final String usertwo);
	
}
