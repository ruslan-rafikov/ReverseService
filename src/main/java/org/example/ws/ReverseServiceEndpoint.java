package org.example.ws;

import org.example.ws.model.ObjectFactory;
import org.example.ws.model.ReverseStringRequest;
import org.example.ws.model.ReverseStringResponse;
import org.example.ws.service.ReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ReverseServiceEndpoint {

	private static final String NAMESPACE_URI = "http://www.example.org/reverse-service";

	private ReverseService reverseService;
	
	private final ObjectFactory objectFactory = new ObjectFactory();
	
	@Autowired
	public ReverseServiceEndpoint(ReverseService reverseService) {
		this.reverseService = reverseService;
	}

	@PayloadRoot(localPart = "ReverseStringRequest", namespace = NAMESPACE_URI)
	@ResponsePayload
	public ReverseStringResponse handleReverseStringRequest(
			@RequestPayload ReverseStringRequest request) {

		String inputString = request.getInputString();
		String reversedString = reverseService.getReversedString(inputString);
		ReverseStringResponse response = objectFactory.createReverseStringResponse();
		response.setReversedString(reversedString);

		return response;
	}
}
