package com.example.day02.employee;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest2 {

	@Autowired
	TestRestTemplate restTemplate;

	@MockBean
	EmployeeRepository employeeRepository;

	@Test
	void getById() {
		// Arrage
		when(employeeRepository.findById(100)).thenReturn(Optional.of(new Employee(100, "hello world")));

		// Act
		var result = restTemplate.getForObject("/employee/100", EmployeeResponse.class);

		// Assert
		assertEquals(100, result.getId());
		assertEquals("hello world", result.getName());
	}

	@Test
	void getAll() {
		// Arrage
		when(employeeRepository.findAll())
				.thenReturn(Arrays.asList(new Employee(101, "hello"), new Employee(102, "world")));

		// Act
		var results = restTemplate.getForObject("/employee", EmployeeResponse[].class);

		// Assert
		assertEquals(2, results.length);

		assertEquals(101, results[0].getId());
		assertEquals("hello", results[0].getName());

		assertEquals(102, results[1].getId());
		assertEquals("world", results[1].getName());
	}

}
