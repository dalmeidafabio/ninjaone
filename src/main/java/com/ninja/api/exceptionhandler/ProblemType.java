package com.ninja.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	SYSTEM_ERROR("/system-error", "System Error"),
	RESOURCE_NOT_FOUND("/resource-not-found", "Resource not found");
	
	private String title;
	private String uri;
	
	private ProblemType(String path, String title) {
		this.uri = "https://ninja.com" + path;
		this.title = title;
	}
}