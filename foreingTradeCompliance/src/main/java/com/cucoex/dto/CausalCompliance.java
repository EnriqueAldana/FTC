/**
 * 
 */
package com.cucoex.dto;

import com.cucoex.entity.Causal;
import com.cucoex.entity.Compliance;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author enrique
 *
 */
@Data
public class CausalCompliance {
	
	@Getter
	@Setter
	private Causal causal;
	@Getter
	@Setter
	private Compliance compliance;

	/**
	 * 
	 */
	public CausalCompliance() {
		
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
	 * @return the compliance
	 */
	public Compliance getCompliance() {
		return compliance;
	}

	/**
	 * @param compliance the compliance to set
	 */
	public void setCompliance(Compliance compliance) {
		this.compliance = compliance;
	}

}
