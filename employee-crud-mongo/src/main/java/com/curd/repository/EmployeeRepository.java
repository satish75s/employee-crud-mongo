package com.curd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.curd.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
