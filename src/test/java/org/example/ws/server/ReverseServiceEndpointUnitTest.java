package org.example.ws.server;

import static org.junit.Assert.assertThat;

import org.example.ws.ReverseServiceEndpoint;
import org.example.ws.model.ObjectFactory;
import org.example.ws.model.ReverseStringRequest;
import org.example.ws.model.ReverseStringResponse;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("spring-ws-servlet-test.xml")
public class ReverseServiceEndpointUnitTest {

	private static ObjectFactory objectFactory = new ObjectFactory();
	
	@Autowired
	private ReverseServiceEndpoint endpoint;
	
	@Test
	public void testReverseStringRequestHandler() {
		ReverseStringRequest request = objectFactory.createReverseStringRequest();
		request.setInputString("ReverseServiceEndpointUnitTest");
		ReverseStringResponse response = endpoint.handleReverseStringRequest(request);
		
		assertThat(response.getReversedString(), is("tseTtinUtniopdnEecivreSesreveR"));
	}
}
