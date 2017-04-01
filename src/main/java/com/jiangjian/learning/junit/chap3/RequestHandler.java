package com.jiangjian.learning.junit.chap3;

public interface RequestHandler {
	Response process(Request request) throws Exception;
}
