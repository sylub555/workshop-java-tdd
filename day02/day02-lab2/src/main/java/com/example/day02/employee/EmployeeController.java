package com.example.day02.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("employee/{id}")
	public EmployeeResponse getById(@PathVariable int id) {
		return employeeService.getId(id);
	}

	@GetMapping("employee")
	public List<EmployeeResponse> getAll() {
		return employeeService.getAll();
	}

}
