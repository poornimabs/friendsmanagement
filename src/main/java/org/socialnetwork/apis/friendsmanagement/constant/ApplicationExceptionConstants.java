package org.socialnetwork.apis.friendsmanagement.constant;

/**
 * Exception constants used across application
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */
public class ApplicationExceptionConstants {
	
	/**
	 * Record Not Found Exception
	 */
	public static final String RECORD_NOT_FOUND = "Record Not Found";
	
	/**
	 * No Common Friends Exception
	 */
	public static final String NO_COMMON_FRIENDS = "No Common Friends";
	
	/**
	 * User Request Data Validation Failed
	 */
    public static final String USER_VALIDATION_FAILED = "Validation Failed - Invalid Data";
    
    /**
	 * Friend Connection Data Validation
	 */
    public static final String FRIENDRELATION_VALIDATION_FAILED = "Validation Failed - Invalid Data For Friend Connection";
    
    /**
	 * Friend Connection Data Validation - Friend Connection Requires
	 *  Two Users - Greater or Less than will give an Error
	 */
    public static final String FRIENDS_CONNECTION = "Friend Connection Requires Two Users";
    
    /**
	 *Validates Email Address
	 */
    public static final String INVALID_EMAIL = "Please provide a valid email address";
    
    /**
     * Friend Relation Already Exists
     */
    public static final String FRIENDSHIP_EXISTS = "Friendship already exists";
    
    /**
     * Friend Relation Already Exists and Blocked
     */
    public static final String FRIENDSHIP_BLOCKED = "Friend connection exists and status is blocked";
    
    /**
     * User Account Not Exists
     */
    public static final String USER_ACCOUNT_DOES_NOT_EXISTS = "Please register the user";
    
    /**
     * Friend Relation Already Exists and Blocked
     */
    public static final String UNSUBSCRIBED_FRIENDSHIP_BLOCKED = "Friend connection request is blocked by the user";
    
    /**
     * Duplicate Request for Subscribing Users
     */
    public static final String DUPLICATE_REQUEST = "Duplicate request";
    
    /**
     * Duplicate Account Request
     */
    public static final String DUPLICATE_ACCOUNT_REQUEST = "Duplicate account request";
    
    /**
     * 
     */
    public static final String NO_FRIEND_CONNECTION = "No friend connections exists";
}
