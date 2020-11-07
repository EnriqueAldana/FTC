/**
 * 
 */
package com.cucoex.dto;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.cucoex.entity.ImpExpType;
import com.cucoex.entity.User;

/**
 * @author enrique
 *
 */


public class CompanyDTO {

	

	private String id;
	private String companyName;
	private String companyId; // RFC
	private String companyPhone;
	private String companyWeb;
	private String companyEmail;
	private String isEnabled;
	private String frequencyToRunMonitor;   // Numero de dias para ejecutar monitor
	private String areAlertsEnabled;
	private String areAlertsEnabledToAdministrators;
	private String areAlertsEnabledToSupervisors;
	private String areAlertsEnabledToUsers;
	private String DaysToClimbAlertsToSupervisor;  	// Dias posteriores al inicio de estatus Por Incumplir
	private String DaysToClimbAlertsToAdministrator;  // Dias posteriores a inicio de estatus Por Incumplir
	private String DaysToDefault;                   	// Dias anticipados a la fecha de Incumplir
	private String alertMessage;       				//Mensaje para la alerta             
	private String created;
	private String updated;
	private Set<ImpExpType> impExpTypeList;
	private Set<User> users ;
	

	
	/**
	 * 
	 */
	public CompanyDTO() {
		
	}



	/**
	 * @param id
	 * @param companyName
	 * @param companyId
	 * @param companyPhone
	 * @param companyWeb
	 * @param companyEmail
	 * @param isEnabled
	 * @param frequencyToRunMonitor
	 * @param areAlertsEnabled
	 * @param areAlertsEnabledToAdministrators
	 * @param areAlertsEnabledToSupervisors
	 * @param areAlertsEnabledToUsers
	 * @param daysToClimbAlertsToSupervisor
	 * @param daysToClimbAlertsToAdministrator
	 * @param daysToDefault
	 * @param alertMessage
	 * @param created
	 * @param updated
	 * @param impExpTypeList
	 * @param users
	 */
	public CompanyDTO(String id, String companyName, String companyId, String companyPhone, String companyWeb,
			String companyEmail, String isEnabled, String frequencyToRunMonitor, String areAlertsEnabled,
			String areAlertsEnabledToAdministrators, String areAlertsEnabledToSupervisors,
			String areAlertsEnabledToUsers, String daysToClimbAlertsToSupervisor,
			String daysToClimbAlertsToAdministrator, String daysToDefault, String alertMessage, String created,
			String updated, Set<ImpExpType> impExpTypeList, Set<User> users) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.companyId = companyId;
		this.companyPhone = companyPhone;
		this.companyWeb = companyWeb;
		this.companyEmail = companyEmail;
		this.isEnabled = isEnabled;
		this.frequencyToRunMonitor = frequencyToRunMonitor;
		this.areAlertsEnabled = areAlertsEnabled;
		this.areAlertsEnabledToAdministrators = areAlertsEnabledToAdministrators;
		this.areAlertsEnabledToSupervisors = areAlertsEnabledToSupervisors;
		this.areAlertsEnabledToUsers = areAlertsEnabledToUsers;
		DaysToClimbAlertsToSupervisor = daysToClimbAlertsToSupervisor;
		DaysToClimbAlertsToAdministrator = daysToClimbAlertsToAdministrator;
		DaysToDefault = daysToDefault;
		this.alertMessage = alertMessage;
		this.created = created;
		this.updated = updated;
		this.impExpTypeList = impExpTypeList;
		this.users = users;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}



	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}



	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}



	/**
	 * @return the companyPhone
	 */
	public String getCompanyPhone() {
		return companyPhone;
	}



	/**
	 * @param companyPhone the companyPhone to set
	 */
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}



	/**
	 * @return the companyWeb
	 */
	public String getCompanyWeb() {
		return companyWeb;
	}



	/**
	 * @param companyWeb the companyWeb to set
	 */
	public void setCompanyWeb(String companyWeb) {
		this.companyWeb = companyWeb;
	}



	/**
	 * @return the companyEmail
	 */
	public String getCompanyEmail() {
		return companyEmail;
	}



	/**
	 * @param companyEmail the companyEmail to set
	 */
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}



	/**
	 * @return the isEnabled
	 */
	public String getIsEnabled() {
		return isEnabled;
	}



	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}



	/**
	 * @return the frequencyToRunMonitor
	 */
	public String getFrequencyToRunMonitor() {
		return frequencyToRunMonitor;
	}



	/**
	 * @param frequencyToRunMonitor the frequencyToRunMonitor to set
	 */
	public void setFrequencyToRunMonitor(String frequencyToRunMonitor) {
		this.frequencyToRunMonitor = frequencyToRunMonitor;
	}



	/**
	 * @return the areAlertsEnabled
	 */
	public String getAreAlertsEnabled() {
		return areAlertsEnabled;
	}



	/**
	 * @param areAlertsEnabled the areAlertsEnabled to set
	 */
	public void setAreAlertsEnabled(String areAlertsEnabled) {
		this.areAlertsEnabled = areAlertsEnabled;
	}



	/**
	 * @return the areAlertsEnabledToAdministrators
	 */
	public String getAreAlertsEnabledToAdministrators() {
		return areAlertsEnabledToAdministrators;
	}



	/**
	 * @param areAlertsEnabledToAdministrators the areAlertsEnabledToAdministrators to set
	 */
	public void setAreAlertsEnabledToAdministrators(String areAlertsEnabledToAdministrators) {
		this.areAlertsEnabledToAdministrators = areAlertsEnabledToAdministrators;
	}



	/**
	 * @return the areAlertsEnabledToSupervisors
	 */
	public String getAreAlertsEnabledToSupervisors() {
		return areAlertsEnabledToSupervisors;
	}



	/**
	 * @param areAlertsEnabledToSupervisors the areAlertsEnabledToSupervisors to set
	 */
	public void setAreAlertsEnabledToSupervisors(String areAlertsEnabledToSupervisors) {
		this.areAlertsEnabledToSupervisors = areAlertsEnabledToSupervisors;
	}



	/**
	 * @return the areAlertsEnabledToUsers
	 */
	public String getAreAlertsEnabledToUsers() {
		return areAlertsEnabledToUsers;
	}



	/**
	 * @param areAlertsEnabledToUsers the areAlertsEnabledToUsers to set
	 */
	public void setAreAlertsEnabledToUsers(String areAlertsEnabledToUsers) {
		this.areAlertsEnabledToUsers = areAlertsEnabledToUsers;
	}



	/**
	 * @return the daysToClimbAlertsToSupervisor
	 */
	public String getDaysToClimbAlertsToSupervisor() {
		return DaysToClimbAlertsToSupervisor;
	}



	/**
	 * @param daysToClimbAlertsToSupervisor the daysToClimbAlertsToSupervisor to set
	 */
	public void setDaysToClimbAlertsToSupervisor(String daysToClimbAlertsToSupervisor) {
		DaysToClimbAlertsToSupervisor = daysToClimbAlertsToSupervisor;
	}



	/**
	 * @return the daysToClimbAlertsToAdministrator
	 */
	public String getDaysToClimbAlertsToAdministrator() {
		return DaysToClimbAlertsToAdministrator;
	}



	/**
	 * @param daysToClimbAlertsToAdministrator the daysToClimbAlertsToAdministrator to set
	 */
	public void setDaysToClimbAlertsToAdministrator(String daysToClimbAlertsToAdministrator) {
		DaysToClimbAlertsToAdministrator = daysToClimbAlertsToAdministrator;
	}



	/**
	 * @return the daysToDefault
	 */
	public String getDaysToDefault() {
		return DaysToDefault;
	}



	/**
	 * @param daysToDefault the daysToDefault to set
	 */
	public void setDaysToDefault(String daysToDefault) {
		DaysToDefault = daysToDefault;
	}



	/**
	 * @return the alertMessage
	 */
	public String getAlertMessage() {
		return alertMessage;
	}



	/**
	 * @param alertMessage the alertMessage to set
	 */
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}



	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}



	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}



	/**
	 * @return the updated
	 */
	public String getUpdated() {
		return updated;
	}



	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
	}



	/**
	 * @return the impExpTypeList
	 */
	public Set<ImpExpType> getImpExpTypeList() {
		return impExpTypeList;
	}



	/**
	 * @param impExpTypeList the impExpTypeList to set
	 */
	public void setImpExpTypeList(Set<ImpExpType> impExpTypeList) {
		this.impExpTypeList = impExpTypeList;
	}



	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}



	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
