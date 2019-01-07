package org.socialnetwork.apis.friendsmanagement.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * NotificationDTO Data Transfer Object
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */

public class NotificationDTO implements Serializable {

    private static final long serialVersionUID = 1102744786883391477L;

    @NotEmpty(message = "Requestor Email cannot be an empty string")
    @NotNull(message = "Requestor Email cannot be null")
    @Email(message = "Please provide a valid email address")
    private String requestor;

    @NotEmpty(message = "Target Email cannot be an empty string")
    @NotNull(message = "Target Email cannot be null")
    @Email(message = "Please provide a valid email address")
    private String target;

    public String getRequestor() {
        return requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

}
