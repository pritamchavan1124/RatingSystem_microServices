package com.app.ratingSyatem.userService.exception;

public class ResourseNotFoundException extends Exception{

	public ResourseNotFoundException(String msg) {
		super(msg);
	}
	
	public ResourseNotFoundException() {
		super("Resourse Not found on server!!");
	}
}
