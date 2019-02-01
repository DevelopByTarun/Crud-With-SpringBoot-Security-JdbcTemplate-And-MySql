package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.dao.IPersonDAO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.mapper.PersonMapper;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.modal.Person;

@Service
public class PersonService implements IPersonDAO, DataBaseQuery {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	@Transactional
	public Person getPersonById(int id) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] { id }, new PersonMapper());
	}

	@Override
	@Transactional
	public List<Person> getAllPersons() throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_ALL, new PersonMapper());
	}

	@Override
	@Transactional
	public boolean deletePerson(Person person) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_DELETE_PERSON, person.getId()) > 0;
	}

	@Override
	@Transactional
	public boolean updatePerson(Person person) throws Exception {
		// TODO Auto-generated method stub
		String query = "update PersonSpringBootMvcAopSecurityJdbcCrud set firstName='"+person.getFirstName()+"', lastName='"+person.getLastName()+"', age="+person.getAge()+", city='"+person.getCity()+"' where id="+person.getId()+"";
		return jdbcTemplate.update(query) > 0;
	}

	@Override
	@Transactional
	public boolean createPerson(Person person) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_INSERT_PERSON, person.getId(), person.getFirstName(), person.getLastName(), person.getAge(),
				person.getCity()) > 0;
	}
}
