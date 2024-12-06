package com.curd.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(collection = "EmployeeList" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	private String empId;
	@JsonProperty
    private String eName;
    private float sal;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date  doj;
    private char gender;
    @JsonProperty
    private boolean isPermenent;

}
