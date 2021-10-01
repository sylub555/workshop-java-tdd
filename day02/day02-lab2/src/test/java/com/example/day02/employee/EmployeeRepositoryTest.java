package com.example.day02.employee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class EmployeeRepositoryTest {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void case01() {
		// Arrage
		Employee demo = new Employee(1, "hello world");
		employeeRepository.save(demo);

		// Act
		var result = employeeRepository.findById(1);

		// Assert
		assertTrue(result.isPresent());
		assertEquals(1, result.get().getId());
		assertEquals("hello world", result.get().getName());
	}

	@Test
	void case02() {
		// Act
		var result = employeeRepository.findById(1);
		
		// Assert
		assertFalse(result.isPresent());
	}

}
