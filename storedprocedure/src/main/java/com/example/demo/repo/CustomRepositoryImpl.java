package com.example.demo.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;

public class CustomRepositoryImpl implements CustomRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveEmployeeDetails(int id, String name, String phoneNo) {
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.INTEGER),
													  new SqlParameter(Types.NVARCHAR),
													  new SqlParameter(Types.NVARCHAR));
	jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection Con) throws SQLException{
			
				CallableStatement cs = Con.prepareCall("call addemployee(?,?,?)");
				cs.setInt(1, id);
				cs.setString(2, name);
				cs.setString(3, phoneNo);
				return cs;
			}
		}, parameters);
	}


	@Override
	public Map<String, ?> getEmployeeDetailsById(int id) {
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.INTEGER));
		
		return jdbcTemplate.call(new CallableStatementCreator(){
			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException{
				CallableStatement cs = con.prepareCall("{call readData(?)}");
				cs.setInt(1, id);
				return cs;
			}

		},parameters);
	}


	@Override
	public Map<String, ?> updateEmployeeInfo(int id, String name, String phoneNo) {
		// TODO Auto-generated method stub
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.INTEGER),
													new SqlParameter(Types.NVARCHAR),
													new SqlParameter(Types.NVARCHAR));
		
		jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall("call updateEmployee(?,?,?)");
				cs.setInt(1, id);
				cs.setString(2, name);
				cs.setString(3, phoneNo);
				return cs;
			}
		}, parameters);
		
		return getEmployeeDetailsById(id);
	}


	@Override
	public void deleteEmployeeInfo(int id) {
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.INTEGER));
		jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall("call deleteEmployee(?)");
				cs.setInt(1, id);
				return cs;
			}
		}, parameters);
		
	}


	@Override
	public Map<String, ?> getAllInfo() {
		// TODO Auto-generated method stub
		List<SqlParameter> parameters = new ArrayList();
		return jdbcTemplate.call(new CallableStatementCreator() {

			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall("{call getallemployees()}");
				return cs;
			}
		}, parameters);
	}
}
