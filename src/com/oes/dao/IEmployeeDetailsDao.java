package com.oes.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.oes.dto.EmployeeDetailsDto;
import com.oes.dto.StudentDetailsDto;

public interface IEmployeeDetailsDao {
	
	// method to populate NewsAndEventsDto data
		public List<EmployeeDetailsDto> getEmployeeDetailsDto(EmployeeDetailsDto employeeDetailsDto) throws DataAccessException;
		
		//method to update NewsAndEventsDto Data
		public void updateEmployeeDetailsDto(EmployeeDetailsDto employeeDetailsDto) throws DataAccessException;
		
		// method to populate NewsAndEventsDto by Id
	    public EmployeeDetailsDto findEmployeeDetailsById(Integer employeeDetailsId) throws DataAccessException;
	    
	    public List<EmployeeDetailsDto> checkAvailEmployeeDetails(String employeeDetails) throws DataAccessException;
	    
	    public List<EmployeeDetailsDto> checkAvailEmployeeByUsername(String username, String email) throws DataAccessException;
	    
	    public List<EmployeeDetailsDto> checkMaxUniqueByYear(String uniqueId) throws DataAccessException;
		
	    public List<EmployeeDetailsDto> checkEmailId(String email_id) throws DataAccessException;
	    
	    public List<EmployeeDetailsDto> getEmployeeDetailsListbyCriteria(String uniqueId, String firstName, String lastName, String dob, String genderId, String emailId, String pincode) throws DataAccessException;

	    //method to populate NewsAndEventsDto data
	 	public List<EmployeeDetailsDto> getAllEmployeeDetailsDto(EmployeeDetailsDto employeeDetailsDto) throws DataAccessException;
	 	
}
