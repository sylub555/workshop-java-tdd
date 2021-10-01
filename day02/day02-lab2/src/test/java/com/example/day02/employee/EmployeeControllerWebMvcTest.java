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
		var mvcResult = mvc.perform(get("employee/1")).andExpect(status().isOk()).andReturn();
		var result = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), EmployeeResponse.class);
		assertEquals(1, result.getId());
		assertEquals("hello world", result.getName());
	}

}
