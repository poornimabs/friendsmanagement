package org.socialnetwork.apis.friendsmanagement.repository;

import java.util.List;

import org.socialnetwork.apis.friendsmanagement.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Notification Repository
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */
public interface NotificationRepository extends JpaRepository<NotificationEntity, String> {

    /**
     * @param user
     * @return List of friends for a user
     */
    @Query(nativeQuery = true)
    List<String> getNotifiedUsers(@Param("user") final String user);

    /**
     * @param user
     * @return List of Users Blocked
     */
    @Query(nativeQuery = true)
    List<String> getBlockedUsersForUpdates(@Param("userone") final String userone,
        @Param("usertwo") final String usertwo, @Param("status") final int status);

    /**
     * @param user
     * @return Checks whether already subscribed for updates
     */
    @Query(nativeQuery = true)
    List<String> getExistingSubscribe(@Param("requestor") final String requestor,
        @Param("target") final String target,
        @Param("status") final int status);

    /**
     * Update status
     * 
     * @param blockedstatus
     * @param blockId
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE subscribe SET state = :state WHERE requestor = :requestor && target = :target",
        nativeQuery = true)
    void updateSubscribeStatus(int state, String requestor, String target);

}
