package org.socialnetwork.apis.friendsmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * BlockedFriendship in Notification Table - Blocked user for updates
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class BlockedFriendshipException extends RuntimeException {

    private static final long serialVersionUID = -6223620506745237847L;

    public BlockedFriendshipException(String exception) {
        super(exception);
    }

}
