package org.socialnetwork.apis.friendsmanagement.exception;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.socialnetwork.apis.friendsmanagement.constant.ApplicationExceptionConstants;
import org.socialnetwork.apis.friendsmanagement.dto.GenericExceptionResponseDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global Exception Handling Controller
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

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
	public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException exception,
			WebRequest request) {
		GenericExceptionResponseDTO exceptionResponse = new GenericExceptionResponseDTO(LocalDateTime.now(), 
				HttpStatus.NOT_FOUND,
				exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserDataInvalidException.class)
	public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		GenericExceptionResponseDTO exceptionResponse = new GenericExceptionResponseDTO(LocalDateTime.now(), 
				status,
				ApplicationExceptionConstants.VALIDATION_FAILED,
				ex.getBindingResult().toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	} 
	
}
