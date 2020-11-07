/**
 * 
 */
package com.cucoex.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author enrique
 *
 */
@Entity
@Table(name="compliance", 
uniqueConstraints=@UniqueConstraint(columnNames={"companyId", "impexptypeId", "causalId"}))
public class Compliance  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3274594582844769993L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	

	@ManyToOne
    @JoinColumn(name="companyId" ,nullable=false)
	@NotNull(message = "Se debe especificar un objeto para company")
	private Company company; 
	
	@ManyToOne
    @JoinColumn(name="impexptypeId" ,nullable=false)
	@NotNull(message = "Se debe especificar un objeto para tipo de expot Imp")
	private ImpExpType impexptype; 
	
	@ManyToOne
    @JoinColumn(name="causalId" ,nullable=false)
	@NotNull(message = "Se debe especificar un objeto para causal")
	private Causal causal; 
	
	
	// El estatus puede cambiar Por: La fecha actual es mayor a la fecha de vigencia para cumplimiento. El usuario determina que no se cumple.

	@ManyToOne
	@JoinColumn(name="statusId" ,nullable=false)
	@NotNull(message = "Se debe especificar un obj para estatus")
	private Status status;
		
	@Transient
	private Boolean isCompliance;
	
	@Column(nullable = false)
	@NotNull(message = "Se debe especificar una fecha para vigencia")
	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar effectiveDateForCompliance;          // Fecha de Vigencia para cumplimiento
	//private LocalDate effectiveDateForCompliance;          // Fecha de Vigencia para cumplimiento
	
	@Column(nullable = false)
	@NotNull(message = "Se debe especificar una fecha para proxima verificacion")
	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar complianceEvaluationDate;				//Fecha en que fue ejecutado el monitor para validar el cumplimiento
	//private LocalDate complianceEvaluationDate;				//Fecha en que fue ejecutado el monitor para validar el cumplimiento
			
	

	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updated;
	
	

  
	
	public Compliance() {
		
	}



	/**
	 * @param company
	 * @param impexptype
	 * @param causal
	 * @param effectiveDateForCompliance
	 * @param complianceEvaluationDate
	 * @param created
	 * @param updated
	 * @param status
	 */
	public Compliance(Company company, ImpExpType impexptype, Causal causal, Calendar effectiveDateForCompliance,
			Calendar complianceEvaluationDate, Calendar created, Calendar updated, Status status) {
		super();
		this.company = company;
		this.impexptype = impexptype;
		this.causal = causal;
		this.effectiveDateForCompliance = effectiveDateForCompliance;
		this.complianceEvaluationDate = complianceEvaluationDate;
		this.created = created;
		this.updated = updated;
		this.status = status;
	}


	/**
	 * @return the effectiveDateForCompliance
	 */
	public Calendar getEffectiveDateForCompliance() {
		return effectiveDateForCompliance;
	}

	/**
	 * @param effectiveDateForCompliance the effectiveDateForCompliance to set
	 */
	public void setEffectiveDateForCompliance(Calendar effectiveDateForCompliance) {
		this.effectiveDateForCompliance = effectiveDateForCompliance;
	}

	/**
	 * @return the complianceEvaluationDate
	 */
	public Calendar getComplianceEvaluationDate() {
		return complianceEvaluationDate;
	}

	/**
	 * @param complianceEvaluationDate the complianceEvaluationDate to set
	 */
	public void setComplianceEvaluationDate(Calendar complianceEvaluationDate) {
		this.complianceEvaluationDate = complianceEvaluationDate;
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


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complianceEvaluationDate == null) ? 0 : complianceEvaluationDate.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((effectiveDateForCompliance == null) ? 0 : effectiveDateForCompliance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
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
		Compliance other = (Compliance) obj;
		if (complianceEvaluationDate == null) {
			if (other.complianceEvaluationDate != null)
				return false;
		} else if (!complianceEvaluationDate.equals(other.complianceEvaluationDate))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (effectiveDateForCompliance == null) {
			if (other.effectiveDateForCompliance != null)
				return false;
		} else if (!effectiveDateForCompliance.equals(other.effectiveDateForCompliance))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cumplimiento [id=" + id + ", effectiveDateForCompliance=" + effectiveDateForCompliance
				+ ", complianceEvaluationDate=" + complianceEvaluationDate + ", created=" + created + ", updated="
				+ updated + ", status=" + status + "]";
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the impexptype
	 */
	public ImpExpType getImpexptype() {
		return impexptype;
	}

	/**
	 * @param impexptype the impexptype to set
	 */
	public void setImpexptype(ImpExpType impexptype) {
		this.impexptype = impexptype;
	}

	/**
	 * @return the causal
	 */
	public Causal getCausal() {
		return causal;
	}

	/**
	 * @param causal the causal to set
	 */
	public void setCausal(Causal causal) {
		this.causal = causal;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * @return the isCompliance
	 */
	public boolean getIsCompliance() {
		return isCompliance;
	}



	/**
	 * @param isCompliance the isCompliance to set
	 */
	public void setIsCompliance(boolean isCompliance) {
		this.isCompliance = isCompliance;
	}

	
	
	

	

}
