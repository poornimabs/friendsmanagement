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
	 * @param userOne
	 * @param userTwo
	 * @return boolean
	 */
	public static boolean isEmailValid(String userOne, String userTwo) {
		EmailValidator emailValidator = new EmailValidator();
		boolean userOneValid = emailValidator.isValid(userOne, null);
		boolean userTwoValid = emailValidator.isValid(userTwo, null);
		boolean validEmail = (userOneValid && userTwoValid) ? true : false;
		return validEmail;
	}

}
