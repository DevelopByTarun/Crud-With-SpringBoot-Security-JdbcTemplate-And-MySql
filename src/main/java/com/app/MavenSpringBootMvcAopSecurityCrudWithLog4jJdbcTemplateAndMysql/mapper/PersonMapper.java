package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.modal.Person;

public class PersonMapper implements RowMapper<Person> {
	
	public Person mapRow(ResultSet resultSet, int i) throws SQLException {
		Person person = new Person();
		person.setId(resultSet.getInt("id"));
		person.setFirstName(resultSet.getString("firstName"));
		person.setLastName(resultSet.getString("lastName"));
		person.setAge(resultSet.getInt("age"));
		person.setCity(resultSet.getString("city"));		
		return person;
	}
}
