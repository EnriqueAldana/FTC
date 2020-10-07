/**
 * 
 */
package com.cucoex.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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


/**
 * @author enrique
 *
 */
@Entity
public class Causal implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4492504495415651138L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column(nullable=false)
	@NotEmpty(message = "Introduzca una descripcion")
	@Size(min=1, max=254)
	private String causalDescription;
	
	
	@Column(nullable=false)
	@NotEmpty(message = "Introduzca un fraccion")
	@Size(min=1, max=10)
	private String causalFraction;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=6)
	private String causalOsCe;
	
	@Column(nullable=false)
	@NotNull(message = "Se debe especificar una causal Clasificacion")
	private Long causalClasification;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=6)
	private String causalExclusive;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=254)
	private String causalCumplimiento;
	
	
	@Column(nullable=false)
	@NotNull(message = "Se debe especificar un tipo de causal")
	private Long causalType;   // El tipo sera una agrupacion para determinar el comportamiento de la interfaz de usuario para fijar el cumplimiento
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updated;
	
	

	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="causales_instructions"
		,joinColumns=@JoinColumn(name="causal_id")
		,inverseJoinColumns=@JoinColumn(name="instruction_id"))
	@OrderBy(value = "id ASC")
	private Set<Instruction> instructionList;
	

	
	
	
	/**
	 * 
	 */
	public Causal() {
		
	}




	/**
	 * @param id
	 * @param causalDescription
	 * @param causalFraction
	 * @param causalOsCe
	 * @param causalClasification
	 * @param causalExclusive
	 * @param causalCumplimiento
	 * @param causalType
	 * @param created
	 * @param updated
	 * @param instructionList
	 */
	public Causal(Long id,
			@NotEmpty(message = "Introduzca una descripcion") @Size(min = 1, max = 254) String causalDescription,
			@NotEmpty(message = "Introduzca un fraccion") @Size(min = 1, max = 10) String causalFraction,
			@NotEmpty @Size(min = 1, max = 6) String causalOsCe,
			@NotNull(message = "Se debe especificar una causal Clasificacion") Long causalClasification,
			@NotEmpty @Size(min = 1, max = 6) String causalExclusive,
			@NotEmpty @Size(min = 1, max = 254) String causalCumplimiento,
			@NotNull(message = "Se debe especificar un tipo de causal") Long causalType, Calendar created,
			Calendar updated, Set<Instruction> instructionList) {
		super();
		this.id = id;
		this.causalDescription = causalDescription;
		this.causalFraction = causalFraction;
		this.causalOsCe = causalOsCe;
		this.causalClasification = causalClasification;
		this.causalExclusive = causalExclusive;
		this.causalCumplimiento = causalCumplimiento;
		this.causalType = causalType;
		this.created = created;
		this.updated = updated;
		this.instructionList = instructionList;
	}




	/**
	 * @return the causalDescription
	 */
	public String getCausalDescription() {
		return causalDescription;
	}


	/**
	 * @param causalDescription the causalDescription to set
	 */
	public void setCausalDescription(String causalDescription) {
		this.causalDescription = causalDescription;
	}


	/**
	 * @return the causalFraction
	 */
	public String getCausalFraction() {
		return causalFraction;
	}


	/**
	 * @param causalFraction the causalFraction to set
	 */
	public void setCausalFraction(String causalFraction) {
		this.causalFraction = causalFraction;
	}


	/**
	 * @return the causalOsCe
	 */
	public String getCausalOsCe() {
		return causalOsCe;
	}


	/**
	 * @param causalOsCe the causalOsCe to set
	 */
	public void setCausalOsCe(String causalOsCe) {
		this.causalOsCe = causalOsCe;
	}


	/**
	 * @return the causalClasification
	 */
	public Long getCausalClasification() {
		return causalClasification;
	}


	/**
	 * @param causalClasification the causalClasification to set
	 */
	public void setCausalClasification(Long causalClasification) {
		this.causalClasification = causalClasification;
	}


	/**
	 * @return the causalExclusiva
	 */
	public String getCausalExclusiva() {
		return causalExclusive;
	}


	/**
	 * @param causalExclusiva the causalExclusiva to set
	 */
	public void setCausalExclusiva(String causalExclusiva) {
		this.causalExclusive= causalExclusiva;
	}


	/**
	 * @return the causalCumplimiento
	 */
	public String getCausalCumplimiento() {
		return causalCumplimiento;
	}


	/**
	 * @param causalCumplimiento the causalCumplimiento to set
	 */
	public void setCausalCumplimiento(String causalCumplimiento) {
		this.causalCumplimiento = causalCumplimiento;
	}


	/**
	 * @return the causalType
	 */
	public Long getCausalType() {
		return causalType;
	}


	/**
	 * @param causalType the causalType to set
	 */
	public void setCausalType(Long causalType) {
		this.causalType = causalType;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	
	
	/**
	 * @return the updated
	 */
	public Calendar getUpdated() {
		return updated;
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
	 * @return the instructionList
	 */
	public Set<Instruction> getInstructionList() {
		return instructionList;
	}


	/**
	 * @param instructionList the instructionList to set
	 */
	public void setInstructionList(Set<Instruction> instructionList) {
		this.instructionList = instructionList;
	}


	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Calendar updated) {
		this.updated = updated;
	}


	/**
	 * @return the causalExclusive
	 */
	public String getCausalExclusive() {
		return causalExclusive;
	}


	/**
	 * @param causalExclusive the causalExclusive to set
	 */
	public void setCausalExclusive(String causalExclusive) {
		this.causalExclusive = causalExclusive;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((causalClasification == null) ? 0 : causalClasification.hashCode());
		result = prime * result + ((causalCumplimiento == null) ? 0 : causalCumplimiento.hashCode());
		result = prime * result + ((causalDescription == null) ? 0 : causalDescription.hashCode());
		result = prime * result + ((causalExclusive == null) ? 0 : causalExclusive.hashCode());
		result = prime * result + ((causalFraction == null) ? 0 : causalFraction.hashCode());
		result = prime * result + ((causalOsCe == null) ? 0 : causalOsCe.hashCode());
		result = prime * result + ((causalType == null) ? 0 : causalType.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instructionList == null) ? 0 : instructionList.hashCode());
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
		Causal other = (Causal) obj;
		if (causalClasification == null) {
			if (other.causalClasification != null)
				return false;
		} else if (!causalClasification.equals(other.causalClasification))
			return false;
		if (causalCumplimiento == null) {
			if (other.causalCumplimiento != null)
				return false;
		} else if (!causalCumplimiento.equals(other.causalCumplimiento))
			return false;
		if (causalDescription == null) {
			if (other.causalDescription != null)
				return false;
		} else if (!causalDescription.equals(other.causalDescription))
			return false;
		if (causalExclusive == null) {
			if (other.causalExclusive != null)
				return false;
		} else if (!causalExclusive.equals(other.causalExclusive))
			return false;
		if (causalFraction == null) {
			if (other.causalFraction != null)
				return false;
		} else if (!causalFraction.equals(other.causalFraction))
			return false;
		if (causalOsCe == null) {
			if (other.causalOsCe != null)
				return false;
		} else if (!causalOsCe.equals(other.causalOsCe))
			return false;
		if (causalType == null) {
			if (other.causalType != null)
				return false;
		} else if (!causalType.equals(other.causalType))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instructionList == null) {
			if (other.instructionList != null)
				return false;
		} else if (!instructionList.equals(other.instructionList))
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
		return "Causal [id=" + id + ", causalDescription=" + causalDescription + ", causalFraction=" + causalFraction
				+ ", causalOsCe=" + causalOsCe + ", causalClasification=" + causalClasification + ", causalExclusive="
				+ causalExclusive + ", causalCumplimiento=" + causalCumplimiento + ", causalType=" + causalType
				+ ", created=" + created + ", updated=" + updated + ", instructionList=" + instructionList + "]";
	}



	





	
	
	

}
