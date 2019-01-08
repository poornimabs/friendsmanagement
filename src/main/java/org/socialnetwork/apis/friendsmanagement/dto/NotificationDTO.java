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

    @NotEmpty(message = "{requestor.email.empty}")
    @NotNull(message = "{requestor email.null}")
    @Email(message = "{user.email.invalid}")
    private String requestor;

    @NotEmpty(message = "{target.email.empty}")
    @NotNull(message = "{target email.null}")
    @Email(message = "{user.email.invalid}")
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
