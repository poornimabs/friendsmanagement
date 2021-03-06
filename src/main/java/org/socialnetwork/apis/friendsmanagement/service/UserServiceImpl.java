package org.socialnetwork.apis.friendsmanagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.socialnetwork.apis.friendsmanagement.constant.ApplicationExceptionConstants;
import org.socialnetwork.apis.friendsmanagement.controller.FriendsManagementController;
import org.socialnetwork.apis.friendsmanagement.dto.AccountDTO;
import org.socialnetwork.apis.friendsmanagement.entity.UserEntity;
import org.socialnetwork.apis.friendsmanagement.exception.DuplicateRequestException;
import org.socialnetwork.apis.friendsmanagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User Services Implementation
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(FriendsManagementController.class);

    @Autowired
    UsersRepository userRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserEntity account(final AccountDTO accountDTO) {
        String accountEmail = userRepository.getSingleUser(accountDTO.getEmail());
        if (null != accountEmail) {
        	LOG.info("DuplicateRequestException {}",accountEmail);
            throw new DuplicateRequestException(ApplicationExceptionConstants.DUPLICATE_ACCOUNT_REQUEST);
        }
        return userRepository.save(new UserEntity(accountDTO.getEmail(),
            accountDTO.getUsername(), accountDTO.getPassword()));
    }

}
