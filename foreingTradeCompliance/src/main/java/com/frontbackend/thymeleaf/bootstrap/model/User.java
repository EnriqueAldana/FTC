package com.frontbackend.thymeleaf.bootstrap.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
public class User {

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birtdate;

	/**
	 * @return the birtdate
	 */
	public Date getBirtdate() {
		return birtdate;
	}

	/**
	 * @param birtdate the birtdate to set
	 */
	public void setBirtdate(Date birtdate) {
		this.birtdate = birtdate;
	}
}
