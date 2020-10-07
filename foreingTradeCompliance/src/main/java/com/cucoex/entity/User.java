/**
 * 
 */
package com.cucoex.entity;

/**
 * @author enrique
 *
 */
import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.JoinColumn;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = -6833167247955613395L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	@Column(nullable = false)
	@NotEmpty
	@Size(min = 1, max = 254)
	private String firstName;

	@Column(nullable = false)
	@NotEmpty
	@Size(min = 1, max = 254)
	private String lastName;

	@Column(unique = true ,nullable = false)
	@NotEmpty
	@Size(min = 6, message = "La longitud minima de un correo elec debe ser de al menos 6 caracteres")
	private String email;

	@Column(nullable = false)
	@NotEmpty
	@Size(min = 1, max = 254)
	private String username;

	/**
	 * @return the updated
	 */
	public Calendar getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Calendar updated) {
		this.updated = updated;
	}

	@Column(nullable = false)
	@NotEmpty
	@Size(min = 4, max = 10)
	private String password;

	@Transient
	@Size(min = 4, max = 10)
	private String confirmPassword;
	
	@Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updated;
	
	@Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;

	
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	
	@ManyToMany(fetch = FetchType.LAZY) 
	@JoinTable(name="users_companies" ,joinColumns=@JoinColumn(name="user_id")
	,inverseJoinColumns=@JoinColumn(name="company_id")) 
	private Set<Company> companies;
	
	
	/**
	 * @return the companies
	 */
	public Set<Company> getCompanies() {
		return companies;
	}

	/**
	 * @param companies the companies to set
	 */
	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	public User() {
	}

	public User(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	

	
	/**
	 * @return the lastUpdated
	 */
	public Calendar getLastUpdated() {
		return updated;
	}

	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(Calendar lastUpdated) {
		this.updated = lastUpdated;
	}

	/**
	 * @return the created
	 */
	public Calendar getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Calendar created) {
		this.created = created;
	}

	/*
	 * public Set<Company> getCompanies() { return companies; }
	 * 
	 *//**
		 * @param companies the companies to set
		 *//*
			 * public void setCompanies(Set<Company> companies) { this.companies =
			 * companies; }
			 * 
			 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (confirmPassword == null) {
			if (other.confirmPassword != null)
				return false;
		} else if (!confirmPassword.equals(other.confirmPassword))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", created=" 
				+ created.get(Calendar.DAY_OF_MONTH) + "/"
				+ created.get(Calendar.MONTH) + "/"
				+ created.get(Calendar.YEAR ) + " "
				+ created.get(Calendar.HOUR ) + ":"
				+ created.get(Calendar.MINUTE ) + ":"
				+ created.get(Calendar.SECOND)
				
				+ ", updated=" +  
				
				+ updated.get(Calendar.DAY_OF_MONTH) + "/"
				+ updated.get(Calendar.MONTH) + "/"
				+ updated.get(Calendar.YEAR )  + " "
				+ updated.get(Calendar.HOUR ) + ":"
				+ updated.get(Calendar.MINUTE )+ ":"
				+ updated.get(Calendar.SECOND)
				
				+ ", roles=" + roles + "]";
	}

}