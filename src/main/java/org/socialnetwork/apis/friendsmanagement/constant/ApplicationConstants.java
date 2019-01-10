package org.socialnetwork.apis.friendsmanagement.constant;

/**
 * General constants used across application
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */

public class ApplicationConstants {

    /**
     * The resource name for friendsmanagement.
     */
    public static final String RESOURCE_PATH = "/friendsmanagement";

    /**
     * Represents the relationship and update status - Accepted
     */
    public static final int STATUS_ACCEPTED = 1;

    /**
     * Represents the relationship and update status - Blocked
     */
    public static final int STATUS_BLOCKED = 0;
    
    /**
     * Email extractor regular expression
     */
    public static final String EMAIL_EXTRACTOR_REGEX = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";

}
