package com.example.day02.employee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void getById() {
		// Act
		var result = restTemplate.getForObject("/employee/1", EmployeeResponse.class);

		// Assert
		assertEquals(1, result.getId());
		assertEquals("hello world", result.getName());
	}

	@Test
	void getAll() {
		// Act
		var results = restTemplate.getForObject("/employee", EmployeeResponse[].class);

		// Assert
		assertEquals(2, results.length);
		
		assertEquals(1, results[0].getId());
		assertEquals("hello", results[0].getName());

		assertEquals(2, results[1].getId());
		assertEquals("world", results[1].getName());
	}

}
