package org.socialnetwork.apis.friendsmanagement.exception;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Global Exception Handling Controller
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public void handleConflict() {
		// Nothing to do
	}

	@ExceptionHandler({SQLException.class,DataAccessException.class})
	public String databaseError() {
		return "databaseError";
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public GenericExceptionResponse handleRecordNotFoundException(RecordNotFoundException exception,
			HttpServletRequest request) {
		return formatException(exception);
	}

	@ExceptionHandler(UserDataInvalidException.class)
	public GenericExceptionResponse handleUserDataInavlidException(UserDataInvalidException exception, 
			HttpServletRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(exception.getLocalizedMessage());
		GenericExceptionResponse error = new GenericExceptionResponse(exception.getMessage(), details);
		return error;
	}

	private GenericExceptionResponse formatException(Exception exception) {
		List<String> details = new ArrayList<String>();
		details.add(exception.getLocalizedMessage());
		GenericExceptionResponse error = new GenericExceptionResponse(exception.getMessage(), details);
		return error;
	}

}
