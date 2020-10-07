/**
 * 
 */
package com.cucoex.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author enrique
 *
 */
@Entity
public class Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7486569944072831814L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=10)
	private String statusKey;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=10)
	private String statusName;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=10)
	private String statusDescription;

	/**
	 * @return the statusKey
	 */
	public String getStatusKey() {
		return statusKey;
	}



	/**
	 * @param statusKey the statusKey to set
	 */
	public void setStatusKey(String statusKey) {
		this.statusKey = statusKey;
	}



	/**
	 * @return the statusNAme
	 */
	public String getStatusNAme() {
		return statusName;
	}



	/**
	 * @param statusNAme the statusNAme to set
	 */
	public void setStatusNAme(String statusNAme) {
		this.statusName = statusNAme;
	}



	/**
	 * @return the statusDescription
	 */
	public String getStatusDescription() {
		return statusDescription;
	}



	/**
	 * @param statusDescription the statusDescription to set
	 */
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * 
	 */
	public Status() {
		
	}



	/**
	 * @param statusKey
	 * @param statusNAme
	 * @param statusDescription
	 */
	public Status(@NotEmpty @Size(min = 1, max = 10) String statusKey,
			@NotEmpty @Size(min = 1, max = 10) String statusNAme,
			@NotEmpty @Size(min = 1, max = 10) String statusDescription) {
		super();
		this.statusKey = statusKey;
		this.statusName = statusNAme;
		this.statusDescription = statusDescription;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((statusDescription == null) ? 0 : statusDescription.hashCode());
		result = prime * result + ((statusKey == null) ? 0 : statusKey.hashCode());
		result = prime * result + ((statusName == null) ? 0 : statusName.hashCode());
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
		Status other = (Status) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (statusDescription == null) {
			if (other.statusDescription != null)
				return false;
		} else if (!statusDescription.equals(other.statusDescription))
			return false;
		if (statusKey == null) {
			if (other.statusKey != null)
				return false;
		} else if (!statusKey.equals(other.statusKey))
			return false;
		if (statusName == null) {
			if (other.statusName != null)
				return false;
		} else if (!statusName.equals(other.statusName))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Status [id=" + id + ", statusKey=" + statusKey + ", statusNAme=" + statusName + ", statusDescription="
				+ statusDescription + "]";
	}

	
}
