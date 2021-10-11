package com.example.webService.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.webService.exception.ResourceNotFoundException;
import com.example.webService.model.Employee;
import com.example.webService.repository.EmployeeRepository;
import com.example.webService.service.EmployeeService;

/**
* @author Anisur Oct 11, 2021
**/

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	/**
	 * @param employeeRepository
	 */
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id", id));
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
	 
		employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id", id));
		employeeRepository.deleteById(id);
		
	}
	
	
}
