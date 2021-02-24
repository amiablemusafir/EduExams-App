package com.oes.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dto.StudentDetailsDto;
import com.sms.admin.dto.AdminDetailDto;

public interface IStudentDetailsServices {

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<StudentDetailsDto> getStudentDetailsDto(StudentDetailsDto studentDetailsDto, AdminDetailDto adminDetailDto) throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateStudentDetailsDto(StudentDetailsDto studentDetailsDto) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<StudentDetailsDto> checkAvailStudentDetails(String student) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public StudentDetailsDto findStudentDetailsById(Integer studentId) throws POLLINGBusinessException;	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<StudentDetailsDto> checkAvailStudentDetailsByUsername(String username,String email) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<StudentDetailsDto> checkMaxUniqueByYear(String uniqueId) throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<StudentDetailsDto> checkEmailId(String email_id) throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<StudentDetailsDto> getStudentDetailsListbyCriteria(String uniqueId, String firstName, String lastName, String dob, String genderId, String emailId, String pincode, AdminDetailDto adminDetailDto) throws DataAccessException;
	 
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<StudentDetailsDto> getStudentDetailsListbyUniqueId(String uniqueId) throws DataAccessException;

	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<StudentDetailsDto> getStudentDetailsListbyCriteriaFeeDetails(String uniqueId, String firstName, String lastName, String className, String genderId, String emailId, String fatherName) throws DataAccessException;

	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<StudentDetailsDto> getStudentDetailsDtoCompleteList(Integer i) throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<StudentDetailsDto> getStudentDetailsDtoCompleteList(AdminDetailDto adminDetailDto) throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<StudentDetailsDto> getAllStudentDetailsDto(StudentDetailsDto studentDetailsDto) throws POLLINGBusinessException;

}
