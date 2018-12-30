package org.socialnetwork.apis.friendsmanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.socialnetwork.apis.friendsmanagement.constant.ApplicationConstants;
import org.socialnetwork.apis.friendsmanagement.dto.AccountDTO;
import org.socialnetwork.apis.friendsmanagement.dto.FriendConnectionDTO;
import org.socialnetwork.apis.friendsmanagement.dto.ResponseDTO;
import org.socialnetwork.apis.friendsmanagement.service.FriendConnectionService;
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
	FriendConnectionService friendConnectionService;
	
	@Autowired
	UserService userService;
	
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
	
	

}
