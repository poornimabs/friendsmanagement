package org.socialnetwork.apis.friendsmanagement.repository;


import org.socialnetwork.apis.friendsmanagement.entity.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* FriendConnection Repository class
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/


public interface FriendConnectionRepository extends JpaRepository<Friendship, String>{
	
}
