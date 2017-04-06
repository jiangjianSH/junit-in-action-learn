package com.jiangjian.learning.junit.chap3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class TestDefaultController {
	private DefaultController defaultController;
	private Request request;
	private RequestHandler handler;
	
	private class SampleRequest implements Request {
		public String getName() {
			return "test";
		}
	}
	
	private class SampleHandler implements RequestHandler {
		public Response process(Request request) throws Exception {
			return new SampleResponse();
		}
	}
	
	private class SampleResponse implements Response {
		private static final String NAME = "sample";
		
		public String getName() {
			return NAME;
		}
		
		@Override
		public boolean equals(Object other) {
			boolean result = false;
			if(other instanceof SampleResponse) {
				result = ((SampleResponse) other).getName().equals(NAME);
			}
			return result;
		}
		
		@Override
		public int hashCode() {
			return NAME.hashCode();
		}
	}
	
	@Before
	public void instantiate(){
		defaultController = new DefaultController();
		request = new SampleRequest();
		handler = new SampleHandler();
		defaultController.addHandler(request, handler);
	}
	
	@Test
	public void testAddHandler() {
		assertSame("Handler should be the same", handler, defaultController.getHandler(request));
	}
	
	@Test
	public void testProcessRequest() {
		Response response = defaultController.processRequest(request);
		assertNotNull("the response shouldn't be null", response);
		assertEquals("the response should be SampleClass type", new SampleResponse(), response);
	}
}
