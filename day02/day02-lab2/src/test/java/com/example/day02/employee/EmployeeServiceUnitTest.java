package com.example.day02.employee;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceUnitTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@Test
	void getId() {
		// Arrange
		EmployeeService service = new EmployeeService(employeeRepository);
		when(employeeRepository.findById(99)).thenReturn(Optional.of(new Employee(99, "hello world")));

		// Act
		EmployeeResponse result = service.getId(99);

		// Assert
		assertEquals(99, result.getId());
		assertEquals("hello world", result.getName());
	}

}
