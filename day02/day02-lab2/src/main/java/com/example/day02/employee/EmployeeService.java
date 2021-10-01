package com.example.day02.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class EmployeeService {

	private EmployeeRepository repository;

	@Autowired
	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	public EmployeeResponse getId(int id) {
		return repository.findById(id).map(emp -> {
			return new EmployeeResponse(emp.getId(), emp.getName());
		}).orElseThrow(() -> new RuntimeException("Emplyee not found with id = " + id));
	}

	public List<EmployeeResponse> getAll() {
		return repository.findAll().stream().map(emp -> new EmployeeResponse(emp.getId(), emp.getName()))
				.collect(Collectors.toList());
	}

}
