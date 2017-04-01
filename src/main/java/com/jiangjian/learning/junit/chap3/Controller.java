package com.jiangjian.learning.junit.chap3;

public interface Controller {
	void addHandler(Request request, RequestHandler handle);
	
	Response processRequest(Request request);
}
