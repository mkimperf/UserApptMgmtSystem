package com.perficient.userservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class ErrorDetails {
	private LocalDateTime timestamp;
    private String message;
    private String details;
    public ErrorDetails(LocalDateTime now, String message, String details) {
		this.timestamp = now;
		this.message = message;
		this.details = details;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
