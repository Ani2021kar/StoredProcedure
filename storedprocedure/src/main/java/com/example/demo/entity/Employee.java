package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "emp.createEmployee", procedureName = "insertData",
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "eid", type = Integer.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "employeeName", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "employeePhoneNo", type = String.class)
				}),
	
	@NamedStoredProcedureQuery(name = "emp.readEmployee", procedureName = "readData",
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "eid", type = Integer.class)
				}),
	
	@NamedStoredProcedureQuery(name = "emp.updateEmployee", procedureName = "updateEmployee",
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "eid", type = Integer.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "employeeName", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "employeePhoneNo", type = String.class)
				}),
	
	@NamedStoredProcedureQuery(name = "emp.deleteEmployee", procedureName = "deleteEmployee",
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "eid", type = Integer.class)
				})
		})
@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name = "employee_id")
	private int id;
	
	@Column(name = "employee_name")
	private String name;
	
	@Column(name = "phone_no")
	private String phoneNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	
}
