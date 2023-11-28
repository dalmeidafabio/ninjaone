package com.ninja.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Problem {

	private Integer status;
	private String type;
	private String title;
	private String detail;
	private String userMessage;
	private OffsetDateTime timestamp;
	private List<Object> objects;

	@Builder
	@Getter
	public static class Object {
		private String name;
		private String userMessage;
	}

}