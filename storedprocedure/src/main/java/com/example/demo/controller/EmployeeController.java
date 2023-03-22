package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("create")
	public Employee createEmployeeData(@RequestBody Employee employee) {
		employeeService.saveEmployeeData(employee);
		return employee;
	}
	
	@GetMapping("getEmployee/{id}")
	public Map<String, ?> getEmployeeById(@PathVariable int id){
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("updateEmployee")
	public Map<String, ?> updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployeeInfo(employee);
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	public Map<String, ?> deleteMapping(@PathVariable int id){
		Map<String, ?> deletedRecord = employeeService.getEmployeeById(id);
		employeeService.deleteEmployeeInfo(id);
		return deletedRecord;
	}
	
	@GetMapping("getAllEmployee")
	public Map<String, ?> getAllDetails(){
		return employeeService.getAllDetails();
	}
}



