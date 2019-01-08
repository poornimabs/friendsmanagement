package org.socialnetwork.apis.friendsmanagement.service;

import org.socialnetwork.apis.friendsmanagement.constant.ApplicationExceptionConstants;
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

    @Autowired
    UsersRepository userRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserEntity account(final AccountDTO accountDTO) {
        String accountEmail = userRepository.getSingleUser(accountDTO.getEmail());
        if (null != accountEmail) {
            throw new DuplicateRequestException(ApplicationExceptionConstants.DUPLICATE_ACCOUNT_REQUEST);
        }
        return userRepository.save(new UserEntity(accountDTO.getEmail(),
            accountDTO.getUsername(), accountDTO.getPassword()));
    }

}
