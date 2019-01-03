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
	 * Get Friends wrt to user
     * @param user
     * @return List of friends for a user
     */
    @Query(nativeQuery = true)
    List<String> getFriends(@Param("user") final String user);
    
    /**
     * Get Common Friends List
     * @param userone usertwo
     * @return List of friends for a user
     */
    @Query(nativeQuery = true)
    List<String> getCommonFriends(@Param("userone") final String userone, @Param("usertwo") final String usertwo);
    
    /**
     * Get friend connection
     * @param userone usertwo
     * @return Friends Connections
     */
    @Query(nativeQuery = true)
    List<String> getFriendConnection(@Param("userone") final String userone, 
    		@Param("usertwo") final String usertwo, @Param("friendship") final int friendship);
    
    /**
     * Update Friendship Status to Blocked or Accepted
     * @param status
     * @param requestor
     * @param target
     * @return
     */
    @Query(nativeQuery = true)
    List<String> updateFrienshipStatus(@Param("blockedstatus") final int blockedstatus, 
    		@Param("requestor") final String requestor, @Param("target") final String target);
	
}
