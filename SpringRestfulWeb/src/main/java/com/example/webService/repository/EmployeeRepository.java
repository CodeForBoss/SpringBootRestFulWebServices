package com.example.webService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webService.model.Employee;

/**
* @author Anisur Oct 11, 2021
**/
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
