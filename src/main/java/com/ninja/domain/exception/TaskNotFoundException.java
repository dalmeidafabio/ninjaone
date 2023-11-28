package com.ninja.domain.exception;

public class TaskNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;

	public TaskNotFoundException(String message) {
		super(message);
	}
	
	public TaskNotFoundException(Long id) {
		this(String.format("Task %d does not exist.", id));
	}	
	
}
