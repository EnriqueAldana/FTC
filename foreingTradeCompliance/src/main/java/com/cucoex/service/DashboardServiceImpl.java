/**
 * 
 */
package com.cucoex.service;

import java.util.Set;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cucoex.entity.Causal;
import com.cucoex.entity.Company;
import com.cucoex.entity.Compliance;
import com.cucoex.entity.Status;
import com.cucoex.entity.User;
import com.cucoex.exception.UsernameOrIdNotFound;
import com.cucoex.repository.StatusRepository;
import com.cucoex.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enrique
 *
 */
@Service
public class DashboardServiceImpl {
	
	@Autowired
	IUserService userService;
	@Autowired
	CausalService causalService;
	
	@Autowired
	ComplianceService complianceService;
	@Autowired
	StatusRepository statusRepository;
	
public Long getTotalCausalsByUserId(Long userId) throws UsernameOrIdNotFound {
		
	Long ret=0L;
		User userFounded= new User();

			try {
				userFounded = userService.getUserById(userId);
				for(Company company : userFounded.getCompanies()) {
					List<Causal> listCausals =  new ArrayList<Causal>();
					listCausals=	causalService.getAllCausalByCompanyId(company.getId());
					ret+=  listCausals.size();
					 
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		return ret;
	}

public Long getTotalCausalsComplianceByUserIdAndStatus(Long userId, String statusKey) throws UsernameOrIdNotFound {
	
	Long ret=0L;
		User userFounded= new User();

			try {
				userFounded = userService.getUserById(userId);
				Status status= statusRepository.findByStatusKey(statusKey);
				for(Company company : userFounded.getCompanies()) {
					
					  List<Compliance> listCompliance = new ArrayList<Compliance>(); 
					  listCompliance =   (List<Compliance>) complianceService.getAllComplianceByCompanyAndStatus(company, status); 
					  ret+=listCompliance.size();
					 
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		return ret;
	}

	/**
	 * 
	 */
	public DashboardServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
