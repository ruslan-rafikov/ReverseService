package org.example.ws.server;

import javax.xml.transform.Source;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.ws.test.server.RequestCreators;
import org.springframework.ws.test.server.ResponseMatchers;
import org.springframework.xml.transform.StringSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("spring-ws-servlet-test.xml")
public class ReverseServiceEndpointIntegrationTest {

	@Autowired
	private ApplicationContext applicationContext;

	private MockWebServiceClient mockClient;

	@Before
	public void createClient() {
		mockClient = MockWebServiceClient.createClient(applicationContext);
	}

	@Test
	public void testReverseString() {
		Source requestPayload = new StringSource(
				"<rev:ReverseStringRequest xmlns:rev='http://www.example.org/reverse-service'><rev:inputString>test!</rev:inputString></rev:ReverseStringRequest>");
		Source responsePayload = new StringSource(
				"<ns2:ReverseStringResponse xmlns:ns2='http://www.example.org/reverse-service'><ns2:reversedString>!tset</ns2:reversedString></ns2:ReverseStringResponse>");

		mockClient.sendRequest(RequestCreators.withPayload(requestPayload))
				.andExpect(ResponseMatchers.payload(responsePayload));
	}
}
