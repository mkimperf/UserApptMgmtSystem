package com.perficient.userservice.exception;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class ErrorDetailsTest {

	@Test
	void test() {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), "error", "description");
		assertEquals(errorDetails.getTimestamp(), LocalDateTime.now());
		assertEquals(errorDetails.getDetails(), "description");
		
		errorDetails.setMessage("new message");
		assertEquals(errorDetails.getMessage(), "new message");
		errorDetails.setDetails("detail");
		assertEquals(errorDetails.getDetails(), "detail");
	}

}
