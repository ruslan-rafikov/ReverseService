package org.example.ws.service;

import org.springframework.stereotype.Service;

@Service
public class ReverseServiceImpl implements ReverseService {

	public String getReversedString(String inputString) {
		StringBuilder builder = new StringBuilder(inputString);
		return builder.reverse().toString();
	}
}
