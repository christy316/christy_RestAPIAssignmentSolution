package com.greatlearning.christy_restapiassignmentsolution.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.christy_restapiassignmentsolution.model.Employee;
import com.greatlearning.christy_restapiassignmentsolution.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {

		this.employeeService = employeeService;
	}

	@PostMapping("/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createEmployee(@RequestBody Employee employee) {

		employeeService.createEmployee(employee);
	}

	@GetMapping("/employees")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employees/{employeeId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Employee getEmployee(@PathVariable(name = "employeeId") long employeeId) {
		return employeeService.fetchEmployee(employeeId);
	}

	@PutMapping("/employees")
	@ResponseStatus(code = HttpStatus.OK)
	public Employee updateEmployee(@RequestBody Employee employee, @RequestParam(name = "employeeId") long employeeId) {
		return employeeService.UpdateEmployee(employee, employeeId);
	}

	@DeleteMapping("/employees/{employeeId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable(name = "employeeId") long employeeId) {
		employeeService.delelteEmployee(employeeId);
	}

	@GetMapping("/employees/search/{firstName}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Employee> searchEmployee(@PathVariable(name = "firstName") String firstName) {
		return employeeService.searchEmployee(firstName);
	}

	@GetMapping("/employees/sort")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Employee> getEmployeesSorted(@RequestParam(name = "order") String order) {
		return employeeService.getEmployeesSorted(order);
	}

}
