/**
 * 
 */
package com.cucoex.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.OrderColumn;
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
public class ImpExpType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4062101968932041790L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=25)
	private String impExpTypeName;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=254)
	private String impExpTypeDescription;
	
	@Column(columnDefinition="DATE DEFAULT curdate()")
	@Temporal(TemporalType.DATE)
	private Calendar created;
	
	@Column(columnDefinition="DATE DEFAULT curdate()")
	@Temporal(TemporalType.DATE)
	private Calendar updated;

	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="impexptypes_causales"
		,joinColumns=@JoinColumn(name="impexptype_id")
		,inverseJoinColumns=@JoinColumn(name="causal_id"))
	@OrderBy(value = "id ASC")
	private Set<Causal> causalList;
	
	
	


	/**
	 * @return the causalList
	 */
	public Set<Causal> getCausalList() {
		return causalList;
	}

	/**
	 * @param causalList the causalList to set
	 */
	public void setCausalList(Set<Causal> causalList) {
		this.causalList = causalList;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Calendar updated) {
		this.updated = updated;
	}

	/**
	 * 
	 */
	public ImpExpType() {
		
		
	}

	public ImpExpType(String impExpTypeName, String impExpTypeDescription) {
		super();
		impExpTypeName = impExpTypeName;
		impExpTypeDescription = impExpTypeDescription;
	}

	
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the impExpTypeName
	 */
	public String getImpExpTypeName() {
		return impExpTypeName;
	}

	/**
	 * @param impExpTypeName the impExpTypeName to set
	 */
	public void setImpExpTypeName(String impExpTypeName) {
		impExpTypeName = impExpTypeName;
	}

	/**
	 * @return the impExpTypeDescription
	 */
	public String getImpExpTypeDescription() {
		return impExpTypeDescription;
	}

	/**
	 * @param impExpTypeDescription the impExpTypeDescription to set
	 */
	public void setImpExpTypeDescription(String impExpTypeDescription) {
		impExpTypeDescription = impExpTypeDescription;
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
	public void setUpdated(Date updated) {
		updated = updated;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((impExpTypeDescription == null) ? 0 : impExpTypeDescription.hashCode());
		result = prime * result + ((impExpTypeName == null) ? 0 : impExpTypeName.hashCode());
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
		ImpExpType other = (ImpExpType) obj;
		if (impExpTypeDescription == null) {
			if (other.impExpTypeDescription != null)
				return false;
		} else if (!impExpTypeDescription.equals(other.impExpTypeDescription))
			return false;
		if (impExpTypeName == null) {
			if (other.impExpTypeName != null)
				return false;
		} else if (!impExpTypeName.equals(other.impExpTypeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ImpExpType [id=" + id + ", ImpExpTypeName=" + impExpTypeName + ", ImpExpTypeDescription="
				+ impExpTypeDescription + "]";
	}

	
	
}
