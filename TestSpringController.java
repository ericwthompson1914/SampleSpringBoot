package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TestSpringController {
	
	

	@Test
	public void testIndex() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8080/";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("Enter a number 1-10 in the url bar to see one of my author recommendations."));
	}

	@Test
	public void testValidNum() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8080/1";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("Brandon Sanderson"));
	}

	@Test
	public void testInvalidNum() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8080/11";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("Enter a number 1-10"));
	}
}