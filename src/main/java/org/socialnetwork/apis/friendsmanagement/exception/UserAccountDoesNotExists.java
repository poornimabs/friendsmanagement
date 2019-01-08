package org.socialnetwork.apis.friendsmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Handles User Account Does Not Exists Exception
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserAccountDoesNotExists extends RuntimeException {

    private static final long serialVersionUID = 6523111572521682783L;

    public UserAccountDoesNotExists(String Exception) {
        super(Exception);
    }

}
