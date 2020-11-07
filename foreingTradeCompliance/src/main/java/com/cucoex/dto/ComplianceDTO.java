/**
 * 
 */
package com.cucoex.dto;

import java.util.Calendar;
import java.util.Set;

import com.cucoex.entity.Instruction;

/**
 * @author enrique
 *
 */
public class ComplianceDTO {
	
	
	 
	 private String id;
	 private String companyId;
	 private String impExpTypeId;
	 private String causalId;
	 private String causalDescription;
	 private String causalCumplimiento;
	 private String statusId;
	 private String isCompliance;
	 private String complianceEvaluationDate;
	 private String effectiveDateForCompliance;
	 private String updated;
	 private String created;
	 private Set<Instruction> instructionList;
	/**
	 * 
	 */
	public ComplianceDTO() {
		// TODO Auto-generated constructor stub
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
	 * @return the impExpTypeId
	 */
	public String getImpExpTypeId() {
		return impExpTypeId;
	}

	/**
	 * @param impExpTypeId the impExpTypeId to set
	 */
	public void setImpExpTypeId(String impExpTypeId) {
		this.impExpTypeId = impExpTypeId;
	}

	/**
	 * @return the causalId
	 */
	public String getCausalId() {
		return causalId;
	}

	/**
	 * @param causalId the causalId to set
	 */
	public void setCausalId(String causalId) {
		this.causalId = causalId;
	}

	/**
	 * @return the statusId
	 */
	public String getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the isCompliance
	 */
	public String getIsCompliance() {
		return isCompliance;
	}

	/**
	 * @param isCompliance the isCompliance to set
	 */
	public void setIsCompliance(String isCompliance) {
		this.isCompliance = isCompliance;
	}

	/**
	 * @return the complianceEvaluationDate
	 */
	public String getComplianceEvaluationDate() {
		return complianceEvaluationDate;
	}

	/**
	 * @param complianceEvaluationDate the complianceEvaluationDate to set
	 */
	public void setComplianceEvaluationDate(String complianceEvaluationDate) {
		this.complianceEvaluationDate = complianceEvaluationDate;
	}

	/**
	 * @return the effectiveDateForCompliance
	 */
	public String getEffectiveDateForCompliance() {
		return effectiveDateForCompliance;
	}

	/**
	 * @param effectiveDateForCompliance the effectiveDateForCompliance to set
	 */
	public void setEffectiveDateForCompliance(String effectiveDateForCompliance) {
		this.effectiveDateForCompliance = effectiveDateForCompliance;
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
	
	

}
