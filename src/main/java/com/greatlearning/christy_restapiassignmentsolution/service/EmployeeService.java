package com.greatlearning.christy_restapiassignmentsolution.service;

import java.util.List;

import com.greatlearning.christy_restapiassignmentsolution.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

	List<Employee> getEmployeesSorted(String order);

	Employee fetchEmployee(long employeeId);

	Employee UpdateEmployee(Employee employee, Long employeeId);

	void delelteEmployee(long employeeId);

	List<Employee> searchEmployee(String firstName);

}
