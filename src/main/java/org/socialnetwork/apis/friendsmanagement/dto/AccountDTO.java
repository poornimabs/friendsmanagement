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

    @NotEmpty(message = "Email cannot be an empty string")
    @NotNull(message = "Email cannot be null")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotEmpty(message = "Username cannot be an empty string")
    @NotNull(message = "Username cannot be null")
    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String username;

    @NotEmpty(message = "Password cannot be an empty string")
    @NotNull(message = "Password cannot be null")
    @Size(min = 7, message = "Password should have atleast 2 characters")
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
