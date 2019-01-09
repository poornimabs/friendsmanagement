package org.socialnetwork.apis.friendsmanagement.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.socialnetwork.apis.friendsmanagement.constant.ApplicationConstants;

/**
 * Validator Utilities
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */

public class Validator {

    /**
     * Validates whether the Email Address is Valid
     * 
     * @param userOne
     * @param userTwo
     * @return boolean
     */
    public static boolean isEmailValid(final String userOne, final String userTwo) {
        EmailValidator emailValidator = new EmailValidator();
        boolean userOneValid = emailValidator.isValid(userOne, null);
        boolean userTwoValid = emailValidator.isValid(userTwo, null);
        return (userOneValid && userTwoValid) ? true : false;
    }
    
    /**
     * Email extractor from text
     * @param text
     * @return
     */
    public static List<String> emailExtractor(String text) {
    	Matcher m = Pattern.compile(ApplicationConstants.EMAIL_EXTRACTOR_REGEX).matcher(text);
 	    List<String> emailsExtracted = new ArrayList<String>();
 	    while (m.find()) {
 	    	emailsExtracted.add(m.group());
 	    }
 	    return emailsExtracted;
    }

}
