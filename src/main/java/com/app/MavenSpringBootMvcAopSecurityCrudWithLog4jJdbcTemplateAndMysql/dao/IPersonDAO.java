package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.modal.Person;

@Repository
public interface IPersonDAO {
	
	public Person getPersonById(int id) throws Exception;

	public List<Person> getAllPersons() throws Exception;

	public boolean deletePerson(Person person) throws Exception;

	public boolean updatePerson(Person person) throws Exception;

	public boolean createPerson(Person person) throws Exception;
}
