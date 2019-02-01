package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jJdbcTemplateAndMysql.exception;

import java.util.Date;

public class PersonException extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
	private Date date;
	
	private String message;

	/**
	 * @param date
	 * @param message
	 */
	public PersonException(Date date, String message) {
		this.date = date;
		this.message = message;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
