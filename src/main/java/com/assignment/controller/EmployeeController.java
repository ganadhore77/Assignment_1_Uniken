package com.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entity.EmployeeEntity;
import com.assignment.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmp")
	public ResponseEntity<List<EmployeeEntity>> getAllEmp() {

		try {

			List<EmployeeEntity> allEmp = employeeService.getAllEmp();
			return new ResponseEntity<List<EmployeeEntity>>(allEmp, HttpStatus.OK);
		} catch (Exception e) {
			List list = new ArrayList<>();
			list.add("Exception");
			return new ResponseEntity<List<EmployeeEntity>>(list, HttpStatus.BAD_GATEWAY);
		}
	}

	@PostMapping("/addEmp")
	public ResponseEntity<String> addEmp(@RequestBody EmployeeEntity entity) {
		try {
			String addEmp = employeeService.addEmp(entity);
			return new ResponseEntity<String>(addEmp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Exception", HttpStatus.BAD_GATEWAY);
		}

	}

	@PutMapping("/updateEmp")
	public ResponseEntity<String> updatEmp(@RequestBody EmployeeEntity entity) {
		try {
			String updateEmp = employeeService.updateEmp(entity);
			return new ResponseEntity<String>(updateEmp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Exception", HttpStatus.BAD_GATEWAY);
		}
	}

	@DeleteMapping("/deleteEmp/{emp_id}")
	public ResponseEntity<String> deleteEmp(@PathVariable Integer emp_id) {

		try {
			String deleteEmp = employeeService.deleteEmp(emp_id);
			return new ResponseEntity<String>(deleteEmp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Exception", HttpStatus.BAD_GATEWAY);
		}
	}

}
