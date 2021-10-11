package com.example.webService.service;

import java.util.List;

import com.example.webService.model.Employee;

/**
* @author Anisur Oct 11, 2021
**/
public interface EmployeeService {
          Employee saveEmployee(Employee employee);
          List<Employee> getAllEmployees();
          Employee getEmployeeById(long id);
          Employee updateEmployee(Employee employee, long id);
          void deleteEmployee(long id);
}
