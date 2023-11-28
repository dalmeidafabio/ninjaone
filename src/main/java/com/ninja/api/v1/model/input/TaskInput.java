package com.ninja.api.v1.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskInput {

	@NotBlank
	private String name;
	
	@NotBlank
	private String description;	
	
}
