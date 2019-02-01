package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.service;

public interface DataBaseQuery {
	
	public static final String SQL_FIND_PERSON = "select * from PersonSpringBootMvcAopSecurityJdbcCrud where id = ?";
	
	public static final String SQL_DELETE_PERSON = "delete from PersonSpringBootMvcAopSecurityJdbcCrud where id = ?";
		
	public static final String SQL_GET_ALL = "select * from PersonSpringBootMvcAopSecurityJdbcCrud";
	
	public static final String SQL_INSERT_PERSON = "insert into PersonSpringBootMvcAopSecurityJdbcCrud(id, firstName, lastName, age, city) values(?, ?, ?, ?, ?)";
}
