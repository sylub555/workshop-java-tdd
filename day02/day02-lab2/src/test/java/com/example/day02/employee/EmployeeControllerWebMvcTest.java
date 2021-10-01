package com.example.day02.employee;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerWebMvcTest {

	@Autowired
	MockMvc mvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	EmployeeService employeeService;

	@Test
	void getById() throws Exception {
		// Arrange
		var data = new EmployeeResponse(1, "name");
		when(employeeService.getId(1)).thenReturn(data);
		// Act
		var mvcResult = mvc.perform(get("/employee/1")).andExpect(status().isOk()).andReturn();
		// Assert
		var result = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), EmployeeResponse.class);
		assertEquals(1, result.getId());
		assertEquals("name", result.getName());
	}

	@Test
	void getAll() throws Exception {
		// Arrange
		var datas = Arrays.asList(new EmployeeResponse(1, "name1"), new EmployeeResponse(2, "name1"));
		when(employeeService.getAll()).thenReturn(datas);

		// Act
		var mvcResult = mvc.perform(get("/employee")).andExpect(status().isOk()).andReturn();

		// Assert
		var results = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), EmployeeResponse[].class);

		assertEquals(2, results.length);

		assertEquals(1, results[0].getId());
		assertEquals("name1", results[0].getName());

		assertEquals(2, results[1].getId());
		assertEquals("name1", results[1].getName());
	}

}
