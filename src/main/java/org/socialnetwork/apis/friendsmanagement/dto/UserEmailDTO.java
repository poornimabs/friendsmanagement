package org.socialnetwork.apis.friendsmanagement.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * UserEmailDTO Data Transfer Object
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */

public class UserEmailDTO {

    @NotEmpty(message = "{user.email.empty}")
    @NotNull(message = "{user.email.null}")
    @Email(message = "{user.email.invalid}")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
