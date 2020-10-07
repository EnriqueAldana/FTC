/**
 * 
 */
package com.cucoex.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author enrique
 *
 */
// @Embeddable
public class CompanyConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 880831223676000150L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column(nullable=false)
	@NotNull()
	private Long frequencyToRunMonitor;   // Numero de dias para ejecutar monitor
	

	
	@Column(nullable=false)
	@NotNull()
	private Boolean areAlertsEnabled;
	
	
	@Column(nullable=false)
	@NotNull()
	private Boolean areAlertsEnabledToAdministrators;
	
	@Column(nullable=false)
	@NotNull()
	private Boolean areAlertsEnabledToSupervisors;
	
	
	@Column(nullable=false)
	@NotNull()
	private Boolean areAlertsEnabledToUsers;
	
	@Column(nullable=false)
	@NotNull()
	private Long DaysToClimbAlertsToSupervisor;  	// Dias posteriores al inicio de estatus Por Incumplir
	
	@Column(nullable=false)
	@NotNull()
	private Long DaysToClimbAlertsToAdministrator;  // Dias posteriores a inicio de estatus Por Incumplir


	@Column(nullable=false)
	@NotNull()
	private Long DaysToDefault;                   	// Dias anticipados a la fecha de Incumplir
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=254)
	private String alertMessage;       				//Mensaje para la alerta             
		
	
	

	/**
	 * 
	 */
	public CompanyConfiguration() {
		
	}




	/**
	 * @param frequencyToRunMonitor
	 * @param areAlertsEnabled
	 * @param areAlertsEnabledToAdministrators
	 * @param areAlertsEnabledToSupervisors
	 * @param areAlertsEnabledToUsers
	 * @param daysToClimbAlertsToSupervisor
	 * @param daysToClimbAlertsToAdministrator
	 * @param daysToDefault
	 * @param alertMessage
	 */
	public CompanyConfiguration(@NotEmpty Long frequencyToRunMonitor, @NotEmpty Boolean areAlertsEnabled,
			@NotEmpty Boolean areAlertsEnabledToAdministrators, @NotEmpty Boolean areAlertsEnabledToSupervisors,
			@NotEmpty Boolean areAlertsEnabledToUsers, @NotEmpty Long daysToClimbAlertsToSupervisor,
			@NotEmpty Long daysToClimbAlertsToAdministrator, @NotEmpty Long daysToDefault,
			@NotEmpty @Size(min = 1, max = 254) String alertMessage) {
		super();
		this.frequencyToRunMonitor = frequencyToRunMonitor;
		this.areAlertsEnabled = areAlertsEnabled;
		this.areAlertsEnabledToAdministrators = areAlertsEnabledToAdministrators;
		this.areAlertsEnabledToSupervisors = areAlertsEnabledToSupervisors;
		this.areAlertsEnabledToUsers = areAlertsEnabledToUsers;
		DaysToClimbAlertsToSupervisor = daysToClimbAlertsToSupervisor;
		DaysToClimbAlertsToAdministrator = daysToClimbAlertsToAdministrator;
		DaysToDefault = daysToDefault;
		this.alertMessage = alertMessage;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}




	/**
	 * @return the frequencyToRunMonitor
	 */
	public Long getFrequencyToRunMonitor() {
		return frequencyToRunMonitor;
	}




	/**
	 * @param frequencyToRunMonitor the frequencyToRunMonitor to set
	 */
	public void setFrequencyToRunMonitor(Long frequencyToRunMonitor) {
		this.frequencyToRunMonitor = frequencyToRunMonitor;
	}




	/**
	 * @return the areAlertsEnabled
	 */
	public Boolean getAreAlertsEnabled() {
		return areAlertsEnabled;
	}




	/**
	 * @param areAlertsEnabled the areAlertsEnabled to set
	 */
	public void setAreAlertsEnabled(Boolean areAlertsEnabled) {
		this.areAlertsEnabled = areAlertsEnabled;
	}




	/**
	 * @return the areAlertsEnabledToAdministrators
	 */
	public Boolean getAreAlertsEnabledToAdministrators() {
		return areAlertsEnabledToAdministrators;
	}




	/**
	 * @param areAlertsEnabledToAdministrators the areAlertsEnabledToAdministrators to set
	 */
	public void setAreAlertsEnabledToAdministrators(Boolean areAlertsEnabledToAdministrators) {
		this.areAlertsEnabledToAdministrators = areAlertsEnabledToAdministrators;
	}




	/**
	 * @return the areAlertsEnabledToSupervisors
	 */
	public Boolean getAreAlertsEnabledToSupervisors() {
		return areAlertsEnabledToSupervisors;
	}




	/**
	 * @param areAlertsEnabledToSupervisors the areAlertsEnabledToSupervisors to set
	 */
	public void setAreAlertsEnabledToSupervisors(Boolean areAlertsEnabledToSupervisors) {
		this.areAlertsEnabledToSupervisors = areAlertsEnabledToSupervisors;
	}




	/**
	 * @return the areAlertsEnabledToUsers
	 */
	public Boolean getAreAlertsEnabledToUsers() {
		return areAlertsEnabledToUsers;
	}




	/**
	 * @param areAlertsEnabledToUsers the areAlertsEnabledToUsers to set
	 */
	public void setAreAlertsEnabledToUsers(Boolean areAlertsEnabledToUsers) {
		this.areAlertsEnabledToUsers = areAlertsEnabledToUsers;
	}




	/**
	 * @return the daysToClimbAlertsToSupervisor
	 */
	public Long getDaysToClimbAlertsToSupervisor() {
		return DaysToClimbAlertsToSupervisor;
	}




	/**
	 * @param daysToClimbAlertsToSupervisor the daysToClimbAlertsToSupervisor to set
	 */
	public void setDaysToClimbAlertsToSupervisor(Long daysToClimbAlertsToSupervisor) {
		DaysToClimbAlertsToSupervisor = daysToClimbAlertsToSupervisor;
	}




	/**
	 * @return the daysToClimbAlertsToAdministrator
	 */
	public Long getDaysToClimbAlertsToAdministrator() {
		return DaysToClimbAlertsToAdministrator;
	}




	/**
	 * @param daysToClimbAlertsToAdministrator the daysToClimbAlertsToAdministrator to set
	 */
	public void setDaysToClimbAlertsToAdministrator(Long daysToClimbAlertsToAdministrator) {
		DaysToClimbAlertsToAdministrator = daysToClimbAlertsToAdministrator;
	}




	/**
	 * @return the daysToDefault
	 */
	public Long getDaysToDefault() {
		return DaysToDefault;
	}




	/**
	 * @param daysToDefault the daysToDefault to set
	 */
	public void setDaysToDefault(Long daysToDefault) {
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
	 * @return the id
	 */
	public Long getId() {
		return id;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((DaysToClimbAlertsToAdministrator == null) ? 0 : DaysToClimbAlertsToAdministrator.hashCode());
		result = prime * result
				+ ((DaysToClimbAlertsToSupervisor == null) ? 0 : DaysToClimbAlertsToSupervisor.hashCode());
		result = prime * result + ((DaysToDefault == null) ? 0 : DaysToDefault.hashCode());
		result = prime * result + ((alertMessage == null) ? 0 : alertMessage.hashCode());
		result = prime * result + ((areAlertsEnabled == null) ? 0 : areAlertsEnabled.hashCode());
		result = prime * result
				+ ((areAlertsEnabledToAdministrators == null) ? 0 : areAlertsEnabledToAdministrators.hashCode());
		result = prime * result
				+ ((areAlertsEnabledToSupervisors == null) ? 0 : areAlertsEnabledToSupervisors.hashCode());
		result = prime * result + ((areAlertsEnabledToUsers == null) ? 0 : areAlertsEnabledToUsers.hashCode());
		result = prime * result + ((frequencyToRunMonitor == null) ? 0 : frequencyToRunMonitor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CompanyConfiguration other = (CompanyConfiguration) obj;
		if (DaysToClimbAlertsToAdministrator == null) {
			if (other.DaysToClimbAlertsToAdministrator != null)
				return false;
		} else if (!DaysToClimbAlertsToAdministrator.equals(other.DaysToClimbAlertsToAdministrator))
			return false;
		if (DaysToClimbAlertsToSupervisor == null) {
			if (other.DaysToClimbAlertsToSupervisor != null)
				return false;
		} else if (!DaysToClimbAlertsToSupervisor.equals(other.DaysToClimbAlertsToSupervisor))
			return false;
		if (DaysToDefault == null) {
			if (other.DaysToDefault != null)
				return false;
		} else if (!DaysToDefault.equals(other.DaysToDefault))
			return false;
		if (alertMessage == null) {
			if (other.alertMessage != null)
				return false;
		} else if (!alertMessage.equals(other.alertMessage))
			return false;
		if (areAlertsEnabled == null) {
			if (other.areAlertsEnabled != null)
				return false;
		} else if (!areAlertsEnabled.equals(other.areAlertsEnabled))
			return false;
		if (areAlertsEnabledToAdministrators == null) {
			if (other.areAlertsEnabledToAdministrators != null)
				return false;
		} else if (!areAlertsEnabledToAdministrators.equals(other.areAlertsEnabledToAdministrators))
			return false;
		if (areAlertsEnabledToSupervisors == null) {
			if (other.areAlertsEnabledToSupervisors != null)
				return false;
		} else if (!areAlertsEnabledToSupervisors.equals(other.areAlertsEnabledToSupervisors))
			return false;
		if (areAlertsEnabledToUsers == null) {
			if (other.areAlertsEnabledToUsers != null)
				return false;
		} else if (!areAlertsEnabledToUsers.equals(other.areAlertsEnabledToUsers))
			return false;
		if (frequencyToRunMonitor == null) {
			if (other.frequencyToRunMonitor != null)
				return false;
		} else if (!frequencyToRunMonitor.equals(other.frequencyToRunMonitor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "SystemConfiguration [id=" + id + ", frequencyToRunMonitor=" + frequencyToRunMonitor
				+ ", areAlertsEnabled=" + areAlertsEnabled + ", areAlertsEnabledToAdministrators="
				+ areAlertsEnabledToAdministrators + ", areAlertsEnabledToSupervisors=" + areAlertsEnabledToSupervisors
				+ ", areAlertsEnabledToUsers=" + areAlertsEnabledToUsers + ", DaysToClimbAlertsToSupervisor="
				+ DaysToClimbAlertsToSupervisor + ", DaysToClimbAlertsToAdministrator="
				+ DaysToClimbAlertsToAdministrator + ", DaysToDefault=" + DaysToDefault + ", alertMessage="
				+ alertMessage + "]";
	}

	
	
}
