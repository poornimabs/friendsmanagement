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

    @NotEmpty(message = "Email cannot be an empty string")
    @NotNull(message = "Email cannot be null")
    @Email(message = "Please provide a valid email address")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
