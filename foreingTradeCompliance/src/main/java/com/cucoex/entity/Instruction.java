/**
 * 
 */
package com.cucoex.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Instruction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -585184438028704670L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=1254)
	private String instructionDescripcion;

	@Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;
	
	@Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updated;

	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=5)
	private String instructionOrder;
	
	
	/**
	 * @return the instructionDescription
	 */
	public String getInstructionDescription() {
		return instructionDescripcion;
	}

	/**
	 * @param instructionDescription the instructionDescription to set
	 */
	public void setInstructionDescription(String instructionDescription) {
		this.instructionDescripcion = instructionDescription;
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
	 * @param updated the updated to set
	 */
	public void setUpdated(Calendar updated) {
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
	 * 
	 */
	public Instruction() {
		
	}

	/**
	 * @param instructionDescription
	 */
	public Instruction(@NotEmpty @Size(min = 1, max = 254) String instructionDescription) {
		super();
		this.instructionDescripcion = instructionDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instructionDescripcion == null) ? 0 : instructionDescripcion.hashCode());
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
		Instruction other = (Instruction) obj;
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
		if (instructionDescripcion == null) {
			if (other.instructionDescripcion != null)
				return false;
		} else if (!instructionDescripcion.equals(other.instructionDescripcion))
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
		return "Instruccion [id=" + id + ", instructionDescripcion=" + instructionDescripcion + ", created=" + created
				+ ", updated=" + updated + "]";
	}

	/**
	 * @return the instructionOrder
	 */
	public String getInstructionOrder() {
		return instructionOrder;
	}

	/**
	 * @param instructionOrder the instructionOrder to set
	 */
	public void setInstructionOrder(String instructionOrder) {
		this.instructionOrder = instructionOrder;
	}


	
}
