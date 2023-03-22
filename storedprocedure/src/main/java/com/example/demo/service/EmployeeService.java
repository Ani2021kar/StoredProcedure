package com.example.demo.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;



@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Employee saveEmployeeData(Employee employee) {
		employeeRepository.saveEmployeeDetails(employee.getId(), employee.getName(), employee.getPhoneNo());
		 return employee;
	 }

	public Map<String, ?> getEmployeeById(int id) {
		return employeeRepository.getEmployeeDetailsById(id);
	}

	public Map<String, ?> updateEmployeeInfo(Employee employee) {
		return employeeRepository.updateEmployeeInfo(employee.getId(), employee.getName(), employee.getPhoneNo());
	}

	public void deleteEmployeeInfo(int id) {
		employeeRepository.deleteEmployeeInfo(id);
	}

	public Map<String, ?> getAllDetails() {
		// TODO Auto-generated method stub
		return employeeRepository.getAllInfo();
	}
	

}
