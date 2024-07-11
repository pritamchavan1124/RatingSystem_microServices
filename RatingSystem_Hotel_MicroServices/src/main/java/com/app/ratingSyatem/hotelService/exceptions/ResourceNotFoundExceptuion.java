package com.app.ratingSyatem.hotelService.exceptions;
 
public class ResourceNotFoundExceptuion extends RuntimeException{

	public ResourceNotFoundExceptuion(String msg) {
		super(msg);
	}
	
	public ResourceNotFoundExceptuion() {
		super("Resource not found .....");
	}
}
