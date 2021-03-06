package org.socialnetwork.apis.friendsmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.socialnetwork.apis.friendsmanagement.constant.ApplicationConstants;
import org.socialnetwork.apis.friendsmanagement.constant.ApplicationExceptionConstants;
import org.socialnetwork.apis.friendsmanagement.dto.AccountDTO;
import org.socialnetwork.apis.friendsmanagement.dto.FriendConnectionDTO;
import org.socialnetwork.apis.friendsmanagement.dto.FriendsListDTO;
import org.socialnetwork.apis.friendsmanagement.dto.NotificationDTO;
import org.socialnetwork.apis.friendsmanagement.dto.NotifyDTO;
import org.socialnetwork.apis.friendsmanagement.dto.NotifyResponseDTO;
import org.socialnetwork.apis.friendsmanagement.dto.ResponseDTO;
import org.socialnetwork.apis.friendsmanagement.dto.UserEmailDTO;
import org.socialnetwork.apis.friendsmanagement.exception.FriendConnectionException;
import org.socialnetwork.apis.friendsmanagement.service.FriendConnectionService;
import org.socialnetwork.apis.friendsmanagement.service.NotificationService;
import org.socialnetwork.apis.friendsmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * REST endpoint for friends management.
 * <p>
 * Provides basic CRUD functionality
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */

@RestController
@RequestMapping(ApplicationConstants.RESOURCE_PATH)
@Api(value = "Friends Management")
public class FriendsManagementController {

    private static final Logger LOG = LoggerFactory.getLogger(FriendsManagementController.class);

    @Autowired
    UserService userService;

    @Autowired
    FriendConnectionService friendConnectionService;

    @Autowired
    NotificationService notificationService;

    /**
     * This method is used to create an account
     * 
     * @param accountDTO First param which holds account details
     * @return ResponseDTO
     */
    @ApiOperation(value = "API to create user account", response = ResponseDTO.class)
    @PostMapping("/account")
    public ResponseDTO account(@Valid @RequestBody final AccountDTO accountDTO) {
        LOG.info("Create user account");
        userService.account(accountDTO);
        return new ResponseDTO(Boolean.TRUE);
    }

    /**
     * This method is used to handle friend connection request
     * 
     * @param friendConnectionDTO First param which holds friend connection details
     * @return ResponseDTO
     */
    @ApiOperation(value = "API to create a friend connection between two email address",
        response = ResponseDTO.class)
    @PostMapping("/friendconnection")
    public ResponseDTO friendConnection(@RequestBody final FriendConnectionDTO friendConnectionDTO) {
        LOG.info("Create a friend connection between two email address");
        validateRequest(friendConnectionDTO);
        friendConnectionService.friendConnection(friendConnectionDTO);
        return new ResponseDTO(Boolean.TRUE);
    }

    /**
     * This method is used to get friends list with user emailId
     * 
     * @param UserEmailDTO First param which holds user email id
     * @return FriendsListDTO
     */
    @ApiOperation(value = "API to retrieve the friends list for an email address",
        response = FriendsListDTO.class)
    @PostMapping("/friends")
    public FriendsListDTO friends(@Valid @RequestBody final UserEmailDTO userEmailDTO) {
        LOG.info("Retrieve the friends list for an email address /friends");
        List<String> friendsList = friendConnectionService.friendsList(userEmailDTO);
        return new FriendsListDTO(friendsList);
    }

    /**
     * This method is used to get common friends list between two users
     * 
     * @param FriendConnectionDTO holds user email id
     * @return FriendsListDTO
     */
    @ApiOperation(value = "API to retrieve the common friends list between two\r\n" +
        "email addresses", response = FriendsListDTO.class)
    @PostMapping("/common")
    public FriendsListDTO commonFriends(@RequestBody final FriendConnectionDTO friendConnectionDTO) {
        LOG.info("Retrieve common friends list between two email addresses");
        validateRequest(friendConnectionDTO);
        List<String> commonFriendsList = friendConnectionService.commonFriends(friendConnectionDTO);
        return new FriendsListDTO(commonFriendsList);
    }

    /**
     * This method is used to subscribe to updates
     * 
     * @param notificationDTO Holds requester and target details for notification
     * @return ResponseDTO
     */
    @ApiOperation(value = "API to subscribe to updates from an email address",
        response = ResponseDTO.class)
    @PostMapping("/subscribe")
    public ResponseDTO subscribe(@Valid @RequestBody final NotificationDTO notificationDTO) {
        LOG.info("Subscribe to updates from an email address");
        notificationService.subscribe(notificationDTO);
        return new ResponseDTO(Boolean.TRUE);
    }

    /**
     * This method is used to block a user from receiving updates
     * 
     * @param notificationDTO Holds requester and target details for notification
     * @return ResponseDTO
     */
    @ApiOperation(value = "API to block updates from an email address",
        response = ResponseDTO.class)
    @PostMapping("/blockupdate")
    public ResponseDTO blockUpdates(@Valid @RequestBody final NotificationDTO notificationDTO) {
        LOG.info("Block updates from an email address");
        notificationService.blockUpdates(notificationDTO);
        return new ResponseDTO(Boolean.TRUE);
    }

    /**
     * This method is used to fetch all email address which can receive updates for particular user
     * 
     * @param notificationDTO Holds requester and target details for notification
     * @return NotifyResponseDTO
     */
    @ApiOperation(value = "API to retrieve all email addresses that can receive\r\n" +
        "updates from an email address", response = NotifyResponseDTO.class)
    @PostMapping("/notify")
    public NotifyResponseDTO notification(@Valid @RequestBody final NotifyDTO notifyDTO) {
        LOG.info("Email addresses that can receive updates from an email address");
        List<String> notifiedUsers = notificationService.notify(notifyDTO);
        return new NotifyResponseDTO(notifiedUsers);
    }
    
    /**
     * Validate FriendConnectionDTO Request Param
     * @param friendConnectionDTO
     */
    private void validateRequest(final FriendConnectionDTO friendConnectionDTO) {
    	 if (null == friendConnectionDTO.getFriends()) {
             throw new FriendConnectionException(ApplicationExceptionConstants.FRIENDRELATION_VALIDATION_FAILED);
         }
         if (friendConnectionDTO.getFriends().size() > 2 || friendConnectionDTO.getFriends().size() < 2) {
             throw new FriendConnectionException(ApplicationExceptionConstants.FRIENDS_CONNECTION);
         }
    }
}
