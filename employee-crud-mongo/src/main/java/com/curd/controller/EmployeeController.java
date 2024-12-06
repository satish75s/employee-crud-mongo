package com.curd.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curd.model.Employee;
import com.curd.model.EmployeeResponse;
import com.curd.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public EmployeeResponse addEmployee(@RequestBody Employee employee) {
		return convertToDTO(employeeService.addEmployee(employee));
	}
	
	private EmployeeResponse convertToDTO(Employee employee) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setDoj(employee.getDoj());
		employeeResponse.setEmpId(employee.getEmpId());
		employeeResponse.setEName(employee.getEName());
		employeeResponse.setGender(employee.getGender());
		employeeResponse.setPermenent(employee.isPermenent());
		employeeResponse.setSal(employee.getSal());
		return employeeResponse;
		
	}

	@GetMapping("/fetchall")
	public List<EmployeeResponse> getEemployeeList(){
		return employeeService.findAllEmployees().stream().map(post -> modelMapper.map(post, EmployeeResponse.class))
				.collect(Collectors.toList());
		
		/*return postService.getAllPosts().stream().map(post -> modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());*/
	}

}
