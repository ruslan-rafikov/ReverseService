package org.example.ws.server;

import static org.junit.Assert.assertThat;

import org.example.ws.service.ReverseService;
import org.example.ws.service.ReverseServiceImpl;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class ReverseServiceUnitTest {

	private ReverseService service = new ReverseServiceImpl();
	
	@Test
	public void testGetReversedSting() {
		String result = service.getReversedString("ReverseServiceTest");
		assertThat(result, CoreMatchers.is("tseTecivreSesreveR"));
	}
}
