package com.curd.model;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

	private String empId;
    private String eName;
    private float sal;
    private Date  doj;
    private char gender;
    private boolean isPermenent;
}
