package org.socialnetwork.apis.friendsmanagement.repository;

import org.socialnetwork.apis.friendsmanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Users Repository class
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */

public interface UsersRepository extends JpaRepository<UserEntity, String> {

    /**
     * @param userone_email
     * @param usertwo_email
     * @return Users Count
     */
    @Query(nativeQuery = true)
    String getMultipleUser(@Param("userone_email") final String userone_email,
        @Param("usertwo_email") final String usertwo_email);

    /**
     * @param userone usertwo
     * @return List of friends for a user
     */
    @Query(nativeQuery = true)
    String getSingleUser(@Param("userone_email") final String userone_email);

}
