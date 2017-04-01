package com.jiangjian.learning.junit.chap3;

public class ErrorResponse implements Response{
	private Exception originalException;
	private Request request;
	
	public ErrorResponse(Exception originalException, Request request) {
		this.originalException = originalException;
		this.request = request;
	}
	
	public Exception getOriginalException() {
		return originalException;
	}
	
	public void setOriginalException(Exception originalException) {
		this.originalException = originalException;
	}
	
	public Request getRequest() {
		return request;
	}
	
	public void setRequest(Request request) {
		this.request = request;
	}
	
}
