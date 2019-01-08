package org.socialnetwork.apis.friendsmanagement.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User Account Data Transfer Object
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */
public class AccountDTO {

    @NotEmpty(message = "{user.email.empty}")
    @NotNull(message = "{user.email.null}")
    @Email(message = "{user.email.invalid}")
    private String email;

    @NotEmpty(message = "{user.name.empty}")
    @NotNull(message = "{user.name.null}")
    @Size(min = 2, message = "{user.name.min}")
    private String username;

    @NotEmpty(message = "{user.password.empty}")
    @NotNull(message = "{user.password.null}")
    @Size(min = 7, message = "{user.password.min}")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
