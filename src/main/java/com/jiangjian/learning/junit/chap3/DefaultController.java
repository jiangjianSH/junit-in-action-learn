package com.jiangjian.learning.junit.chap3;

import java.util.HashMap;
import java.util.Map;

public class DefaultController implements Controller{
	private Map<String, RequestHandler> handlers = new HashMap<>();
	
	protected RequestHandler getHandler(Request request) {
		if(!handlers.containsKey(request.getName())) {
			throw new RuntimeException("there is no handler for request:" + request.getName());
		}
		return handlers.get(request.getName());
	}
	
	public void addHandler(Request request, RequestHandler handle) {
		if(handlers.containsKey(request.getName())) {
			throw new RuntimeException("a request handler has added before on request: " + request.getName());
		}
		handlers.put(request.getName(), handle);
	}

	public Response processRequest(Request request) {
		Response response;
		RequestHandler handler = getHandler(request);
		try {
			response = handler.process(request);
		} catch (Exception e) {
		
			response = new ErrorResponse(e, request);
		}
		return response;
	}

}
