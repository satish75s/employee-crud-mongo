package com.curd.service;



import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.model.Employee;
import com.curd.repository.EmployeeRepository;
@Service
public class EmployeeService {

	@Autowired 
	EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee ) {
		employee.setEmpId(UUID.randomUUID().toString().split("-")[0]);
		return employeeRepository.save(employee);
		
	}
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}
}
