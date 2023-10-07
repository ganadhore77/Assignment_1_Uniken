package com.assignment.service;

import java.util.List;

import com.assignment.entity.EmployeeEntity;

public interface EmployeeService {

	public List<EmployeeEntity> getAllEmp();
	
	public String addEmp(EmployeeEntity entity);
	
	public String deleteEmp(Integer emp_id);
	
	public String updateEmp(EmployeeEntity entity);	
	
}
