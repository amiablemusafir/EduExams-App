package com.oes.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.oes.dto.StudentDetailsDto;
import com.sms.admin.dto.AdminDetailDto;

public interface IStudentDetailsDao {
	
	// method to populate NewsAndEventsDto data
	public List<StudentDetailsDto> getStudentDetailsDto(StudentDetailsDto studentDetailsDto, AdminDetailDto adminDetailDto) throws DataAccessException;
	
	//method to update NewsAndEventsDto Data
	public void updateStudentDetailsDto(StudentDetailsDto studentDetailsDto) throws DataAccessException;
	
	// method to populate NewsAndEventsDto by Id
    public StudentDetailsDto findStudentDetailsById(Integer studentDetailsId) throws DataAccessException;
    
    public List<StudentDetailsDto> checkAvailStudentDetails(String studentDetails) throws DataAccessException;
    
    public List<StudentDetailsDto> checkAvailStudentByUsername(String username, String email) throws DataAccessException;
    
    public List<StudentDetailsDto> checkMaxUniqueByYear(String uniqueId) throws DataAccessException;
	
    public List<StudentDetailsDto> checkEmailId(String email_id) throws DataAccessException;
    
    public List<StudentDetailsDto> getStudentDetailsListbyCriteria(String uniqueId, String firstName, String lastName, String dob, String genderId, String emailId, String pincode, AdminDetailDto adminDetailDto) throws DataAccessException;
    
    public List<StudentDetailsDto> getStudentDetailsListbyUniqueId(String uniqueId) throws DataAccessException;
    
    
    
    public List<StudentDetailsDto> getStudentDetailsListbyCriteriaFeeDetails(String uniqueId, String firstName, String lastName, String className, String genderId, String emailId, String fatherName) throws DataAccessException;
    
    public List<StudentDetailsDto> getStudentDetailsDtoCompleteList(Integer i) throws DataAccessException;
    
    public List<StudentDetailsDto> getStudentDetailsDtoCompleteList(AdminDetailDto adminDetailDto) throws DataAccessException;
	
    // method to populate NewsAndEventsDto data
 	public List<StudentDetailsDto> getAllStudentDetailsDto(StudentDetailsDto studentDetailsDto) throws DataAccessException;
 	
}
