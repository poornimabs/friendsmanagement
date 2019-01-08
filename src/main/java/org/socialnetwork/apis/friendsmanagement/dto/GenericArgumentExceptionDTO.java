package org.socialnetwork.apis.friendsmanagement.dto;

/**
 * Argument Not Valid Exception Data Transfer Object
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GenericArgumentExceptionDTO {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private HttpStatus status;
	private String message;
	private List<ArgumentBindingExceptionDTO> details;

	public GenericArgumentExceptionDTO(LocalDateTime timestamp, HttpStatus status,
			String message, List<ArgumentBindingExceptionDTO> details) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.details = details;
	}

	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public List<ArgumentBindingExceptionDTO> getDetails() {
		return details;
	}

	public void setDetails(List<ArgumentBindingExceptionDTO> details) {
		this.details = details;
	}
}
