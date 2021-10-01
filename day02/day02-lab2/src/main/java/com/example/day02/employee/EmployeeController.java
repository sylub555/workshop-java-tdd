package com.example.day02.employee;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@GetMapping("employee/{id}")
	public EmployeeResponse getById(@PathVariable int id) {
		return new EmployeeResponse(id, "hello world");
	}

	@GetMapping("employee")
	public List<EmployeeResponse> getAll() {
		return Arrays.asList(new EmployeeResponse(1, "hello"), new EmployeeResponse(2, "world"));
	}

}