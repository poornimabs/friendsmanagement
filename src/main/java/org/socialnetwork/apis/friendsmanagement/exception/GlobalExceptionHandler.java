package org.socialnetwork.apis.friendsmanagement.exception;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.socialnetwork.apis.friendsmanagement.constant.ApplicationExceptionConstants;
import org.socialnetwork.apis.friendsmanagement.dto.ArgumentBindingExceptionDTO;
import org.socialnetwork.apis.friendsmanagement.dto.GenericArgumentExceptionDTO;
import org.socialnetwork.apis.friendsmanagement.dto.GenericExceptionResponseDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global Exception Handling Controller
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public final ResponseEntity<Object> databaseError(SQLException exception, HttpServletRequest request) {
        GenericExceptionResponseDTO exceptionResponse = new GenericExceptionResponseDTO(LocalDateTime.now(),
            HttpStatus.NOT_FOUND,
            exception.getMessage(),
            request.getRequestURI());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException exception,
    		HttpServletRequest request) {
        GenericExceptionResponseDTO exceptionResponse = new GenericExceptionResponseDTO(LocalDateTime.now(),
            HttpStatus.NOT_FOUND,
            exception.getMessage(),
            request.getRequestURI());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataInvalidException.class)
    public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
    	BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<ArgumentBindingExceptionDTO> bindingException = new ArrayList<ArgumentBindingExceptionDTO>();
        ArgumentBindingExceptionDTO argument;
        for (FieldError fieldError: fieldErrors) {
        	argument = new ArgumentBindingExceptionDTO(fieldError.getField(), 
        			fieldError.getDefaultMessage());
        	bindingException.add(argument);
        }
        GenericArgumentExceptionDTO exceptionResponse = new GenericArgumentExceptionDTO(LocalDateTime.now(),
            status,
            ApplicationExceptionConstants.USER_VALIDATION_FAILED,
            bindingException);
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAccountDoesNotExists.class)
    public final ResponseEntity<Object> handleUserDoesNotExistsException(UserAccountDoesNotExists exception,
    		HttpServletRequest request) {
        GenericExceptionResponseDTO exceptionResponse = new GenericExceptionResponseDTO(LocalDateTime.now(),
            HttpStatus.NOT_FOUND,
            exception.getMessage(),
            request.getRequestURI());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FriendConnectionException.class)
    public final ResponseEntity<Object> handleFriendConnectionException(FriendConnectionException exception,
    		HttpServletRequest request) {
        GenericExceptionResponseDTO exceptionResponse = new GenericExceptionResponseDTO(LocalDateTime.now(),
            HttpStatus.BAD_REQUEST,
            exception.getMessage(),
            request.getRequestURI());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BlockedFriendshipException.class)
    public final ResponseEntity<Object> handleBlockedFriendShipException(BlockedFriendshipException exception,
    		HttpServletRequest request) {
        GenericExceptionResponseDTO exceptionResponse = new GenericExceptionResponseDTO(LocalDateTime.now(),
            HttpStatus.EXPECTATION_FAILED,
            exception.getMessage(),
            request.getRequestURI());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(DuplicateRequestException.class)
    public final ResponseEntity<Object> handleDuplicateRequestn(DuplicateRequestException exception,
    		HttpServletRequest request) {
        GenericExceptionResponseDTO exceptionResponse = new GenericExceptionResponseDTO(LocalDateTime.now(),
            HttpStatus.CONFLICT,
            exception.getMessage(),
            request.getRequestURI());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.CONFLICT);
    }
}
