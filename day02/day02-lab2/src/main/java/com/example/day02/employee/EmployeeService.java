package com.example.day02.employee;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	public EmployeeResponse getId(int id) {
		return new EmployeeResponse(id, "hello world");
	}

	public List<EmployeeResponse> getAll() {
		return Arrays.asList(new EmployeeResponse(1, "hello"), new EmployeeResponse(2, "world"));
	}

}
