package com.example.day02.employee;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerWebMvcTest {

	@Autowired
	MockMvc mvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void getById() throws Exception {
		var mvcResult = mvc.perform(get("/employee/1")).andExpect(status().isOk()).andReturn();
		var result = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), EmployeeResponse.class);
		assertEquals(1, result.getId());
		assertEquals("hello world", result.getName());
	}

	@Test
	void getAll() throws Exception {
		var mvcResult = mvc.perform(get("/employee")).andExpect(status().isOk()).andReturn();
		var results = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), EmployeeResponse[].class);
		
		assertEquals(2, results.length);

		assertEquals(1, results[0].getId());
		assertEquals("hello", results[0].getName());

		assertEquals(2, results[1].getId());
		assertEquals("world", results[1].getName());
	}

}
