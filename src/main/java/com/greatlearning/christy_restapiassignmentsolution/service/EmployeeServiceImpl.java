package com.greatlearning.christy_restapiassignmentsolution.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.christy_restapiassignmentsolution.model.Employee;
import com.greatlearning.christy_restapiassignmentsolution.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee createEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee fetchEmployee(long employeeId) {

		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new IllegalArgumentException("Record not found"));
	}

	@Override
	public Employee UpdateEmployee(Employee employee, Long employeeId) {
		Employee employeeToSave = employeeRepository.findById(employeeId).map(employeeToBeUpdate -> {
			employeeToBeUpdate.setFirstName(employee.getFirstName());
			employeeToBeUpdate.setLastName(employee.getLastName());
			employeeToBeUpdate.setEmail(employee.getEmail());
			return employeeToBeUpdate;
		}).orElseThrow(() -> new IllegalArgumentException("Record not found"));

		return employeeRepository.save(employeeToSave);
	}

	@Override
	public void delelteEmployee(long employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public List<Employee> searchEmployee(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

	@Override
	public List<Employee> getEmployeesSorted(String direction) {
		Direction sortDirec = null;
		if (direction.equalsIgnoreCase("asc")) {
			sortDirec = Sort.Direction.ASC;
		} else if (direction.equalsIgnoreCase("desc")) {
			sortDirec = Sort.Direction.DESC;
		} else {
			throw new IllegalArgumentException("please pass sort by direction as ASC or DESC");
		}

		return employeeRepository.findAll(Sort.by(sortDirec, "firstName"));
	}

}
