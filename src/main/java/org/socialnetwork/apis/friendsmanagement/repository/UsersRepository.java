package org.socialnetwork.apis.friendsmanagement.repository;

import org.socialnetwork.apis.friendsmanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* Users Repository class
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/


public interface UsersRepository extends JpaRepository<UserEntity, String>{

}
