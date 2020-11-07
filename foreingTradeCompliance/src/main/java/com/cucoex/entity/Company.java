package com.cucoex.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Company implements Serializable {

	private static final long serialVersionUID = 1833167247955613395L;

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	@Column(nullable = false)
	@NotEmpty(message = "Introduzca un nombre de empresa")
	@Size(min = 1, max = 254)
	private String companyName;

	@Column(unique = true, nullable = false)
	@NotEmpty(message = "Introduzca ID fiscal ")
	@Size(min = 1, max = 25)
	private String companyId; // RFC

	@Column(nullable = false)
	@NotEmpty(message = "Introduzca una direccion de empresa")
	@Size(min = 1, max = 254)
	private String companyAddress;

	@Column(nullable = false)
	@NotEmpty(message = "Introduzca un telefono de empresa")
	@Size(min = 1, max = 25)
	private String companyPhone;

	@Column(nullable = false)
	@NotEmpty(message = "Introduzca una web de empresa")
	@Size(min = 1, max = 25)
	private String companyWeb;

	@Column(nullable = false)
	@NotEmpty(message = "Introduzca un correo de empresa")
	@Size(min = 1, max = 25)
	private String companyEmail;

	@Column(nullable = false)
	@NotNull
	private Boolean isEnabled;

	
	// Configuracion
	
	@Column(nullable=false)
	@NotNull(message = "Se debe especificar un numero para la frecuencia de ejecucion del monitor")
	private Long frequencyToRunMonitor;   // Numero de dias para ejecutar monitor
	

	
	@Column(nullable=false)
	@NotNull
	private Boolean areAlertsEnabled;
	
	
	@Column(nullable=false)
	@NotNull
	private Boolean areAlertsEnabledToAdministrators;
	
	@Column(nullable=false)
	@NotNull
	private Boolean areAlertsEnabledToSupervisors;
	
	
	@Column(nullable=false)
	@NotNull
	private Boolean areAlertsEnabledToUsers;
	
	@Column(nullable=false)
	@NotNull(message = "Se debe especificar un numero de dias para alertar al supervisor")
	private Long DaysToClimbAlertsToSupervisor;  	// Dias posteriores al inicio de estatus Por Incumplir
	
	@Column(nullable=false)
	@NotNull(message = "Se debe especificar un numero de dias para alertar al administrador")
	private Long DaysToClimbAlertsToAdministrator;  // Dias posteriores a inicio de estatus Por Incumplir


	@Column(nullable=false)
	@NotNull(message = "Se debe especificar un numero de dias para anticipar la fecha de Incumplimiento")
	private Long DaysToDefault;                   	// Dias anticipados a la fecha de Incumplir
	
	@Column(nullable=false)
	@NotEmpty(message = "Agregue un mensaje que formara parte de la alerta")
	@Size(min=1, max=254)
	private String alertMessage;       				//Mensaje para la alerta             
		


	@Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;
	
	@Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updated;
	



	/*
	 * @Embedded private CompanyConfiguration companyConfiguration;
	 * 
	 */
	/*	*//**
			 * @return the companyConfiguration
			 */
	/*
	 * public CompanyConfiguration getCompanyConfiguration() { return
	 * companyConfiguration; }
	 * 
	 *//**
		 * @param companyConfiguration the companyConfiguration to set
		 *//*
			 * public void setCompanyConfiguration(CompanyConfiguration
			 * companyConfiguration) { this.companyConfiguration = companyConfiguration; }
			 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "companies_impexptypes", joinColumns = @JoinColumn(name = "company_id"), 
	inverseJoinColumns = @JoinColumn(name = "impexptype_id"))
	@OrderBy(value = "id ASC")
	private Set<ImpExpType> impExpTypeList;

	@ManyToMany(mappedBy="companies")
	private Set<User> users ;
	


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
	 * @param companyName
	 * @param companyId
	 * @param companyAddress
	 * @param companyPhone
	 * @param companyWeb
	 * @param companyEmail
	 * @param isEnabled
	 * @param companyConfiguration
	 * @param impExpType
	 */

	// https://www.arquitecturajava.com/ejemplo-jpa-embedded/ EJEMPLO
	public Company(@NotEmpty @Size(min = 1, max = 254) String companyName,
			@NotEmpty @Size(min = 1, max = 25) String companyId,
			@NotEmpty @Size(min = 1, max = 254) String companyAddress,
			@NotEmpty @Size(min = 1, max = 25) String companyPhone,
			@NotEmpty @Size(min = 1, max = 25) String companyWeb,
			@NotEmpty @Size(min = 1, max = 25) String companyEmail, @NotEmpty Boolean isEnabled,

			@NotEmpty Long frequencyToRunMonitor, @NotEmpty Boolean areAlertsEnabled,
			@NotEmpty Boolean areAlertsEnabledToAdministrators, @NotEmpty Boolean areAlertsEnabledToSupervisors,
			@NotEmpty Boolean areAlertsEnabledToUsers, @NotEmpty Long daysToClimbAlertsToSupervisor,
			@NotEmpty Long daysToClimbAlertsToAdministrator, @NotEmpty Long daysToDefault,
			@NotEmpty @Size(min = 1, max = 254) String alertMessage

			, Set<ImpExpType> impExpTypeList) {
		super();
		this.companyName = companyName;
		this.companyId = companyId;
		this.companyAddress = companyAddress;
		this.companyPhone = companyPhone;
		this.companyWeb = companyWeb;
		this.companyEmail = companyEmail;
		this.isEnabled = isEnabled;
		/*
		 * this.companyConfiguration = new CompanyConfiguration(frequencyToRunMonitor,
		 * areAlertsEnabled, areAlertsEnabledToAdministrators,
		 * areAlertsEnabledToSupervisors, areAlertsEnabledToUsers,
		 * daysToClimbAlertsToSupervisor, daysToClimbAlertsToAdministrator,
		 * daysToDefault, alertMessage);
		 */
		this.impExpTypeList = impExpTypeList;
	}

	/*	*//**
			 * @return the companyConfiguration
			 */
	/*
	 * public CompanyConfiguration getCompanyConfiguration() { return
	 * companyConfiguration; }
	 * 
	 *//**
		 * @param companyConfiguration the companyConfiguration to set
		 *//*
			 * public void setCompanyConfiguration(CompanyConfiguration
			 * companyConfiguration) { this.companyConfiguration = companyConfiguration; }
			 */

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public Company() {
		
		

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
	 * @return the companyAddress
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * @param companyAddress the companyAddress to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
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
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
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
	 * @return the updated
	 */
	public Calendar getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated1(Calendar updated) {
		this.updated = updated;
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



	

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Calendar updated) {
		this.updated = updated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyAddress == null) ? 0 : companyAddress.hashCode());
		result = prime * result + ((companyEmail == null) ? 0 : companyEmail.hashCode());
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((companyPhone == null) ? 0 : companyPhone.hashCode());
		result = prime * result + ((companyWeb == null) ? 0 : companyWeb.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isEnabled == null) ? 0 : isEnabled.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", companyId=" + companyId + ", companyAddress="
				+ companyAddress + ", companyPhone=" + companyPhone + ", companyWeb=" + companyWeb + ", companyEmail="
				+ companyEmail + ", isEnabled=" + isEnabled + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (companyAddress == null) {
			if (other.companyAddress != null)
				return false;
		} else if (!companyAddress.equals(other.companyAddress))
			return false;
		if (companyEmail == null) {
			if (other.companyEmail != null)
				return false;
		} else if (!companyEmail.equals(other.companyEmail))
			return false;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (companyPhone == null) {
			if (other.companyPhone != null)
				return false;
		} else if (!companyPhone.equals(other.companyPhone))
			return false;
		if (companyWeb == null) {
			if (other.companyWeb != null)
				return false;
		} else if (!companyWeb.equals(other.companyWeb))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isEnabled == null) {
			if (other.isEnabled != null)
				return false;
		} else if (!isEnabled.equals(other.isEnabled))
			return false;
		return true;
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
