package org.socialnetwork.apis.friendsmanagement.service;

import java.util.List;

import org.socialnetwork.apis.friendsmanagement.dto.FriendConnectionDTO;
import org.socialnetwork.apis.friendsmanagement.dto.UserEmailDTO;

/**
 * REST endpoint for friends request service.
 * <p>
 * Provides basic CRUD functionality
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */
public interface FriendConnectionService {

    /**
     * This method is used to create a friendship b/w two users
     * 
     * @param friendConnectionDTO
     * @return void
     */
    void friendConnection(final FriendConnectionDTO friendConnectionDTO);

    /**
     * This method is used to get friends list wrt single user
     * 
     * @param userEmailDTO
     * @return Friends List for user
     */
    List<String> friendsList(final UserEmailDTO userEmailDTO);

    /**
     * This method is used to get common friends list between users
     * 
     * @param friendConnectionDTO
     * @return Common Friends List for user
     */
    List<String> commonFriends(final FriendConnectionDTO friendConnectionDTO);

}
