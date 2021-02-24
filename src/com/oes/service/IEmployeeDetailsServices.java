package com.oes.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dto.EmployeeDetailsDto;
import com.oes.dto.StudentDetailsDto;

public interface IEmployeeDetailsServices {
	

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<EmployeeDetailsDto> getEmployeeDetailsDto(EmployeeDetailsDto employeeDetailsDto) throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateEmployeeDetailsDto(EmployeeDetailsDto employeeDetailsDto) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<EmployeeDetailsDto> checkAvailEmployeeDetails(String employee) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public EmployeeDetailsDto findEmployeeDetailsById(Integer employeeId) throws POLLINGBusinessException;	
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<EmployeeDetailsDto> checkAvailEmployeeDetailsByUsername(String username,String email) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<EmployeeDetailsDto> checkMaxUniqueByYear(String uniqueId) throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<EmployeeDetailsDto> checkEmailId(String email_id) throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<EmployeeDetailsDto> getEmployeeDetailsListbyCriteria(String uniqueId, String firstName, String lastName, String dob, String genderId, String emailId, String pincode) throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<EmployeeDetailsDto> getAllEmployeeDetailsDto(EmployeeDetailsDto employeeDetailsDto) throws POLLINGBusinessException;


}
