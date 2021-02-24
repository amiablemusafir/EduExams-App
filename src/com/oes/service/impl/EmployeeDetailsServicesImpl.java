package com.oes.service.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dao.IEmployeeDetailsDao;
import com.oes.dto.EmployeeDetailsDto;
import com.oes.dto.StudentDetailsDto;
import com.oes.service.IEmployeeDetailsServices;

public class EmployeeDetailsServicesImpl implements IEmployeeDetailsServices {
	
	private IEmployeeDetailsDao employeeDetailsDao;

	public IEmployeeDetailsDao getEmployeeDetailsDao() {
		return employeeDetailsDao;
	}

	public void setEmployeeDetailsDao(IEmployeeDetailsDao employeeDetailsDao) {
		this.employeeDetailsDao = employeeDetailsDao;
	}
	
	public List<EmployeeDetailsDto> getEmployeeDetailsDto(EmployeeDetailsDto employeeDetailsDto)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getEmployeeDetailsDao().getEmployeeDetailsDto(employeeDetailsDto);
	}

	
	public void updateEmployeeDetailsDto(EmployeeDetailsDto employeeDetailsDto)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub	
		this.getEmployeeDetailsDao().updateEmployeeDetailsDto(employeeDetailsDto);
		
	}
	
	public EmployeeDetailsDto findEmployeeDetailsById(Integer employeeDetailsId)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getEmployeeDetailsDao().findEmployeeDetailsById(employeeDetailsId);
	}

	
	public List<EmployeeDetailsDto> checkAvailEmployeeDetails(String name)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getEmployeeDetailsDao().checkAvailEmployeeDetails(name);
	}

	public List<EmployeeDetailsDto> checkAvailEmployeeDetailsByUsername(String username,String email)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getEmployeeDetailsDao().checkAvailEmployeeByUsername(username, email);
	}
	@Override
	public List<EmployeeDetailsDto> checkMaxUniqueByYear(String uniqueId) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getEmployeeDetailsDao().checkMaxUniqueByYear(uniqueId);
	}

	@Override
	public List<EmployeeDetailsDto> checkEmailId(String email_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getEmployeeDetailsDao().checkEmailId(email_id);
	}

	@Override
	public List<EmployeeDetailsDto> getEmployeeDetailsListbyCriteria(String uniqueId, String firstName, String lastName, String dob, String genderId, String emailId, String pincode) throws DataAccessException {
		
				// TODO Auto-generated method stub
		return this.getEmployeeDetailsDao().getEmployeeDetailsListbyCriteria(uniqueId, firstName, lastName, dob, genderId, emailId, pincode);
		
	}
	
	public List<EmployeeDetailsDto> getAllEmployeeDetailsDto(EmployeeDetailsDto employeeDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getEmployeeDetailsDao().getAllEmployeeDetailsDto(employeeDetailsDto);
	}
}
