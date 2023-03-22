package com.example.demo.repo;

import java.util.Map;

public interface CustomRepository{
	
	void saveEmployeeDetails(int id, String name, String phoneNo);
	
	Map<String, ?> getEmployeeDetailsById(int id);
	
	Map<String, ?> updateEmployeeInfo(int id, String name, String phoneNo);
	
	void deleteEmployeeInfo(int id);
	
	Map<String, ?> getAllInfo();
}
