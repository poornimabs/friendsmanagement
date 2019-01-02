package org.socialnetwork.apis.friendsmanagement.utilities;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;

/**
 * Validator Utilities
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

public class Validator {
	/**
	 * Validates whether the Email Address is Valid
	 * @param user_one
	 * @param user_two
	 * @return boolean
	 */
	public static boolean isEmailValid(String user_one, String user_two) {
		EmailValidator emailValidator = new EmailValidator();
		boolean user_one_valid = emailValidator.isValid(user_one, null);
		boolean user_two_valid = emailValidator.isValid(user_two, null);
		boolean validEmail = (user_one_valid && user_two_valid) ? true : false;
		return validEmail;
	}

}
