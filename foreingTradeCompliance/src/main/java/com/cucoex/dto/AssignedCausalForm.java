/**
 * 
 */
package com.cucoex.dto;

import java.util.Date;

import com.cucoex.entity.Causal;

/**
 * @author enrique
 *
 */
public class AssignedCausalForm {

	/**
	 * 
	 */
	public AssignedCausalForm() {
		
	}
	
	private Long companyId;
	
	private Long impExpTypeId;
	
	private Causal causalId;
	
	private boolean statusId;
	
	private Date complianceEvaluationDate;
	
	private Date effectiveDateForCompliance;
	
	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the impExpTypeId
	 */
	public Long getImpExpTypeId() {
		return impExpTypeId;
	}

	/**
	 * @param impExpTypeId the impExpTypeId to set
	 */
	public void setImpExpTypeId(Long impExpTypeId) {
		this.impExpTypeId = impExpTypeId;
	}

	/**
	 * @return the causalId
	 */
	public Causal getCausalId() {
		return causalId;
	}

	/**
	 * @param causalId the causalId to set
	 */
	public void setCausalId(Causal causalId) {
		this.causalId = causalId;
	}

	/**
	 * @return the statusId
	 */
	public boolean getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(boolean statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the complianceEvaluationDate
	 */
	public Date getComplianceEvaluationDate() {
		return complianceEvaluationDate;
	}

	/**
	 * @param complianceEvaluationDate the complianceEvaluationDate to set
	 */
	public void setComplianceEvaluationDate(Date complianceEvaluationDate) {
		this.complianceEvaluationDate = complianceEvaluationDate;
	}

	/**
	 * @return the effectiveDateForCompliance
	 */
	public Date getEffectiveDateForCompliance() {
		return effectiveDateForCompliance;
	}

	/**
	 * @param effectiveDateForCompliance the effectiveDateForCompliance to set
	 */
	public void setEffectiveDateForCompliance(Date effectiveDateForCompliance) {
		this.effectiveDateForCompliance = effectiveDateForCompliance;
	}
	

	
	
	
	
}
