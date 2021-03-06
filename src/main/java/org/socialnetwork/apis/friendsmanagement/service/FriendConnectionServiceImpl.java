package org.socialnetwork.apis.friendsmanagement.service;

import java.util.List;

import org.socialnetwork.apis.friendsmanagement.constant.ApplicationConstants;
import org.socialnetwork.apis.friendsmanagement.constant.ApplicationExceptionConstants;
import org.socialnetwork.apis.friendsmanagement.dto.FriendConnectionDTO;
import org.socialnetwork.apis.friendsmanagement.dto.UserEmailDTO;
import org.socialnetwork.apis.friendsmanagement.entity.FriendrelationEntity;
import org.socialnetwork.apis.friendsmanagement.exception.BlockedFriendshipException;
import org.socialnetwork.apis.friendsmanagement.exception.DataInvalidException;
import org.socialnetwork.apis.friendsmanagement.exception.DuplicateRequestException;
import org.socialnetwork.apis.friendsmanagement.exception.FriendConnectionException;
import org.socialnetwork.apis.friendsmanagement.exception.RecordNotFoundException;
import org.socialnetwork.apis.friendsmanagement.exception.UserAccountDoesNotExists;
import org.socialnetwork.apis.friendsmanagement.repository.FriendConnectionRepository;
import org.socialnetwork.apis.friendsmanagement.repository.NotificationRepository;
import org.socialnetwork.apis.friendsmanagement.repository.UsersRepository;
import org.socialnetwork.apis.friendsmanagement.utilities.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FriendConnections/Requests Services Implementation
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */

@Service
public class FriendConnectionServiceImpl implements FriendConnectionService {

    @Autowired
    FriendConnectionRepository friendConnectionRepository;

    @Autowired
    UsersRepository userRepository;

    @Autowired
    NotificationRepository notificationRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void friendConnection(final FriendConnectionDTO friendConnectionDTO) {
        friendConnectionValidation(friendConnectionDTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> friendsList(final UserEmailDTO userEmailDTO) {
        String userEmail = userRepository.getSingleUser(userEmailDTO.getEmail());
        if (null == userEmail) {
            throw new UserAccountDoesNotExists(ApplicationExceptionConstants.USER_ACCOUNT_DOES_NOT_EXISTS);
        }
        List<String> friendsList = friendConnectionRepository.getFriends(userEmailDTO.getEmail());
        if (friendsList.size() == 0) {
            throw new RecordNotFoundException(ApplicationExceptionConstants.NO_FRIEND_CONNECTION);
        }
        return friendsList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> commonFriends(final FriendConnectionDTO friendConnectionDTO) {
        commonValidations(friendConnectionDTO);
        List<String> friendsList = friendConnectionRepository.getCommonFriends(friendConnectionDTO.getFriends().get(0),
            friendConnectionDTO.getFriends().get(1));
        if (friendsList.size() == 0) {
            throw new RecordNotFoundException(ApplicationExceptionConstants.NO_COMMON_FRIENDS);
        }
        return friendsList;
    }

    /**
     * Validates for Resource and creates friend connection
     * 
     * @param friendConnectionDTO
     * @return void
     */
    private void friendConnectionValidation(final FriendConnectionDTO friendConnectionDTO) {
        resourceValidations(friendConnectionDTO);
        friendConnectionRepository.save(new FriendrelationEntity(friendConnectionDTO.getFriends().get(0),
            friendConnectionDTO.getFriends().get(1),
            ApplicationConstants.STATUS_ACCEPTED));
    }

    /**
     * Resource Validations Checks for RequestBody Validation Checks for valid numbers of users email id sent Checks for Email Valid Checks
     * for user account exists Checks for Status Blocked, Unsubscribed User Checks whether friendship already exists
     * 
     * @param friendConnectionDTO
     * @return void
     */
    private void resourceValidations(final FriendConnectionDTO friendConnectionDTO) {
        commonValidations(friendConnectionDTO);
        List<String> friendShipBlocked = notificationRepository.getBlockedUsersForUpdates(
            friendConnectionDTO.getFriends().get(0),
            friendConnectionDTO.getFriends().get(1), ApplicationConstants.STATUS_BLOCKED);
        if (friendShipBlocked.size() > 0) {
            throw new BlockedFriendshipException(ApplicationExceptionConstants.UNSUBSCRIBED_FRIENDSHIP_BLOCKED);
        }

        Long friendShipExists = friendConnectionRepository.getFriendConnection(
            friendConnectionDTO.getFriends().get(0),
            friendConnectionDTO.getFriends().get(1), ApplicationConstants.STATUS_ACCEPTED);
        if (null != friendShipExists) {
            throw new DuplicateRequestException(ApplicationExceptionConstants.FRIENDSHIP_EXISTS);
        }
        Long blockedFriend = friendConnectionRepository.getFriendConnection(
            friendConnectionDTO.getFriends().get(0),
            friendConnectionDTO.getFriends().get(1), ApplicationConstants.STATUS_BLOCKED);
        if (null != blockedFriend) {
            throw new FriendConnectionException(ApplicationExceptionConstants.FRIENDSHIP_BLOCKED);
        }
    }

    /**
     * Common Validations
     * 
     * @param friendConnectionDTO
     */
    private void commonValidations(final FriendConnectionDTO friendConnectionDTO) {
        boolean validEmail = Validator.isEmailValid(friendConnectionDTO.getFriends().get(0),
            friendConnectionDTO.getFriends().get(1));
        if (!validEmail) {
            throw new DataInvalidException(ApplicationExceptionConstants.INVALID_EMAIL);
        }
        String userCount = userRepository.getMultipleUser(friendConnectionDTO.getFriends().get(0),
            friendConnectionDTO.getFriends().get(1));
        if (Integer.parseInt(userCount) < 2) {
            throw new UserAccountDoesNotExists(ApplicationExceptionConstants.USER_ACCOUNT_DOES_NOT_EXISTS);
        }
    }

}
