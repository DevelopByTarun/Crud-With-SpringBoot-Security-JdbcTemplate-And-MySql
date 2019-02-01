package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.dao.IPersonDAO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.exception.PersonException;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.modal.Person;
import org.apache.log4j.Logger;

@Controller
public class PersonController {
	
	private Logger logger = Logger.getLogger(PersonController.class);
		
	@ExceptionHandler(PersonException.class)
	public ModelAndView showPersonExceptionView(Exception exception) {
		System.out.println("----Caught PersonException----");
		System.out.println("");
		logger.debug("----Caught PersonException----");
		logger.debug("");
	    ModelAndView model = new ModelAndView();
	    model.addObject("exception", exception);
	    model.setViewName("personExceptionView");
	    return model;
	}
		
	@Autowired
	private IPersonDAO personDAO;
	
	@RequestMapping(value = "/welcome-person", method = RequestMethod.GET)
	public ModelAndView showAddPersonPage() {
		logger.debug("****Going To Enter On Add Person Page****");
		logger.debug("");
		logger.debug("");
		ModelAndView model = new ModelAndView();
		model.setViewName("add");
		return model;
	}
	
	@RequestMapping(value = "/add-person", method = RequestMethod.POST)
	public ModelAndView savePerson(@RequestParam("id") int id,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("age") int age, @RequestParam("city") String city,
			@ModelAttribute() Person person) throws Exception {
		logger.debug("****Going To Start Save Person Method****");
		if(id > 500) {
			logger.debug("Unable To Add Person Id Because Count Of Id Is Not Correct !! Please Try Again..");
			logger.debug("");
			throw new PersonException(new Date(), "Unable To Add Person Id Because Count Of Id Is Not Correct !! Please Try Again..");
		}
		else {
			person.setId(id);
		}
		if(firstName.length() > 10) {
			logger.debug("Unable To Add Person FirstName Because Length Of FirstName Is Not Correct !! Please Try Again..");
			logger.debug("");
			throw new PersonException(new Date(), "Unable To Add Person FirstName Because Length Of FirstName Is Not Correct !! Please Try Again..");
		}
		else {
			person.setFirstName(firstName);
		}
		if(lastName.length() < 4) {
			logger.debug("Unable To Add Person LastName Because Length Of LastName Is Not Correct !! Please Try Again..");
			logger.debug("");
			throw new PersonException(new Date(), "Unable To Add Person LastName Because Length Of LastName Is Not Correct !! Please Try Again..");
		}
		else {
			person.setLastName(lastName);
		}
		if(age <= 25) {
			logger.debug("IOException Occured :-> Unable To Add Person Age Because Count Of Age Is Not Correct !! Please Try Again..");
			logger.debug("");
			throw new IOException("IOException Occured :-> Unable To Add Person Age Because Count Of Age Is Not Correct !! Please Try Again..");
		}
		else {
			person.setAge(age);
		}
		if(city.length() > 10) {
			logger.debug("NullPointerException Occured :-> Unable To Add Person City Because Length Of City Is Not Correct !! Please Try Again..");
			logger.debug("");
			throw new NullPointerException("NullPointerException Occured :-> Unable To Add Person City Because Length Of City Is Not Correct !! Please Try Again..");
		}
		else {
			person.setCity(city);
		}
		boolean result = personDAO.createPerson(person);
		if(result == true) {
			logger.debug(firstName.concat(lastName)+" Is Save Successfully");
		}
		else {
			logger.debug("Unable To Save "+firstName.concat(lastName));
		}
		logger.debug("****Going To End Save Person Method****");
		logger.debug("");
		logger.debug("");
		return new ModelAndView("redirect:/list-person");
	}
	
	@RequestMapping(value = "/list-person", method = RequestMethod.GET)
	public ModelAndView fetchAllPersons() throws Exception {
		logger.debug("****Going To Start Fetch All Persons Method****");
		ModelAndView model = new ModelAndView("list-person");
		List<Person> personList = personDAO.getAllPersons();
		if(personList != null && personList.size() > 0) {
			model.addObject("personList", personList);
			logger.debug("You Have Successfully Fetch All Persons List");
		}
		else {
			logger.debug("Unable To Fetch All Persons List");
		}
		logger.debug("****Going To End Fetch All Persons Method****");
		logger.debug("");
		logger.debug("");
		return model;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/edit-person/{id}", method = RequestMethod.GET)
	public ModelAndView editPerson(@PathVariable("id") int id) throws Exception {
		logger.debug("****Going To Start Edit Person Method****");
		ModelAndView model = new ModelAndView();
		Person edit = personDAO.getPersonById(id);
		if(edit != null) {
			model.addObject("values", edit);
			logger.debug("You Have Successfully Edit Person Id "+id);
		}
		else {
			logger.debug("Unable To Edit Person Id "+id);
		}
		model.setViewName("update");
		logger.debug("****Going To End Edit Person Method****");
		logger.debug("");
		logger.debug("");
		return model;
	}
	
	@RequestMapping(value = "/update-person", method = RequestMethod.POST)
	public ModelAndView updatePerson(@ModelAttribute() Person person) throws Exception {
		logger.debug("****Going To Start Update Person Method****");
		boolean result = personDAO.updatePerson(person);
		if(result == true) {
			logger.debug(person.getFirstName().concat(person.getLastName())+" Updated Successfully");
		}
		else {
			logger.debug("Unable To Update "+person.getFirstName().concat(person.getLastName()));
		}
		logger.debug("****Going To End Update Person Method****");
		logger.debug("");
		logger.debug("");
		return new ModelAndView("redirect:/list-person");
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/delete-person/{id}", method = RequestMethod.GET)
	public ModelAndView deletePerson(@PathVariable("id") int id,
			@ModelAttribute() Person person) throws Exception {
		logger.debug("****Going To Start Delete Person Method****");
		person.setId(id);
		boolean result = personDAO.deletePerson(person);
		if(result == true) {
			logger.debug("You Have Successfully Delete Person Id "+id);
		}
		else {
			logger.debug("Unable To Delete Person Id "+id);
		}
		logger.debug("****Going To End Delete Person Method****");
		logger.debug("");
		logger.debug("");
		return new ModelAndView("redirect:/list-person");
	}		
}
