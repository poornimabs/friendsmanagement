package org.socialnetwork.apis.friendsmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.socialnetwork.apis.friendsmanagement.constant.ApplicationConstants;
import org.socialnetwork.apis.friendsmanagement.dto.AccountDTO;
import org.socialnetwork.apis.friendsmanagement.dto.FriendConnectionDTO;
import org.socialnetwork.apis.friendsmanagement.dto.FriendsListDTO;
import org.socialnetwork.apis.friendsmanagement.dto.NotificationDTO;
import org.socialnetwork.apis.friendsmanagement.dto.NotifyDTO;
import org.socialnetwork.apis.friendsmanagement.dto.NotifyResponseDTO;
import org.socialnetwork.apis.friendsmanagement.dto.ResponseDTO;
import org.socialnetwork.apis.friendsmanagement.dto.UserEmailDTO;
import org.socialnetwork.apis.friendsmanagement.service.FriendConnectionService;
import org.socialnetwork.apis.friendsmanagement.service.NotificationService;
import org.socialnetwork.apis.friendsmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoint for friends management.
 * <p>
 * Provides basic CRUD functionality
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

@RestController
@RequestMapping(ApplicationConstants.RESOURCE_PATH)
public class FriendsManagementController {

	private static final Logger LOG = LoggerFactory.getLogger(FriendsManagementController.class);

	@Autowired
	UserService userService;

	@Autowired
	FriendConnectionService friendConnectionService;

	@Autowired
	NotificationService notificationService;
	
	/**
	 *This method is used to create an account
	 * @param accountDTO First param which holds account details
	 * @return ResponseDTO
	 */
	@PostMapping("/account")
	public ResponseDTO account(@RequestBody AccountDTO accountDTO) {
		LOG.info("Create account");
		userService.account(accountDTO);
		return new ResponseDTO(Boolean.TRUE);
	}

	/**
	 *This method is used to handle friend connection request
	 * @param friendConnectionDTO First param which holds friend connection details
	 * @return ResponseDTO 
	 */
	@PostMapping("/friendconnection")
	public ResponseDTO friendConnection(@RequestBody FriendConnectionDTO friendConnectionDTO) {
		friendConnectionService.friendConnection(friendConnectionDTO);
		return new ResponseDTO(Boolean.TRUE);
	}

	/**
	 *This method is used to get friends list with user emailId
	 * @param UserEmailDTO First param which holds user email id
	 * @return FriendsListDTO 
	 */
	@PostMapping("/friends")
	public FriendsListDTO friends(@RequestBody UserEmailDTO userEmailDTO) {
		List<String> friendsList = friendConnectionService.friendsList(userEmailDTO);
		return new FriendsListDTO(friendsList);
	}
	
	/**
	 *This method is used to get friends list with user emailId
	 * @param UserEmailDTO First param which holds user email id
	 * @return FriendsListDTO 
	 */
	@PostMapping("/common")
	public FriendsListDTO commonFriends(@RequestBody FriendConnectionDTO friendConnectionDTO) {
		List<String> commonFriendsList = friendConnectionService.commonFriends(friendConnectionDTO);
		return new FriendsListDTO(commonFriendsList);
	}
	
	
	/**
	 *This method is used to subscribe to updates
	 * @param notificationDTO Holds requester and target details for notification
	 * @return ResponseDTO 
	 */
	@PostMapping("/subscribe")
	public ResponseDTO subscribe(@RequestBody NotificationDTO notificationDTO) {
		notificationService.subscribe(notificationDTO);
		return new ResponseDTO(Boolean.TRUE);
	}
	
	/**
	 *This method is used to block a user from receiving updates
	 * @param notificationDTO Holds requester and target details for notification
	 * @return ResponseDTO 
	 */
	@PostMapping("/blockupdate")
	public ResponseDTO blockUpdates(@RequestBody NotificationDTO notificationDTO) {
		notificationService.blockUpdates(notificationDTO);
		return new ResponseDTO(Boolean.TRUE);
	}
	
	/**
	 *This method is used to fetch all email address which can receive updates for particular user
	 * @param notificationDTO Holds requester and target details for notification
	 * @return ResponseDTO 
	 */
	@PostMapping("/notify")
	public NotifyResponseDTO ResponseDTO (@RequestBody NotifyDTO notifyDTO) {
		List<String> notifiedUsers = notificationService.notify(notifyDTO);
		return new NotifyResponseDTO(notifiedUsers);
	}
}
