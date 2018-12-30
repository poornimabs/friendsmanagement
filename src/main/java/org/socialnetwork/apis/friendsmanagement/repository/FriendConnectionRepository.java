package org.socialnetwork.apis.friendsmanagement.repository;


import java.util.List;

import org.socialnetwork.apis.friendsmanagement.entity.Friendship;
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


public interface FriendConnectionRepository extends JpaRepository<Friendship, String>{
	
	/**
     * @param user
     * @return List of friends for a user
     */
    @Query(nativeQuery = true)
    List<String> fetchFriends(@Param("user") final String user);
	
}
