package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entity.EmployeeEntity;
import com.assignment.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeEntity> getAllEmp() {
		List<EmployeeEntity> all = employeeRepository.findAll();
		return all;
	}

	@Override
	public String addEmp(EmployeeEntity entity) {
		EmployeeEntity save = employeeRepository.save(entity);
		return "Employee Record save succesfully with ID : "+save.getEmp_id();
	}

	@Override
	public String deleteEmp(Integer emp_id) {
		employeeRepository.deleteById(emp_id);
		return "EMployee Record Deleted for ID : "+emp_id;
	}

	@Override
	public String updateEmp(EmployeeEntity entity) {
		EmployeeEntity update = employeeRepository.save(entity);
		return "Employee Record Updated succesfully with ID : "+update.getEmp_id();
	}

}
