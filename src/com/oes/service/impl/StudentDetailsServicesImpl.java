package com.oes.service.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dao.IStudentDetailsDao;
import com.oes.dto.StudentDetailsDto;
import com.oes.service.IStudentDetailsServices;
import com.sms.admin.dto.AdminDetailDto;

public class StudentDetailsServicesImpl implements IStudentDetailsServices {
	
	private IStudentDetailsDao studentDetailsDao;

	public IStudentDetailsDao getStudentDetailsDao() {
		return studentDetailsDao;
	}

	public void setStudentDetailsDao(IStudentDetailsDao studentDetailsDao) {
		this.studentDetailsDao = studentDetailsDao;
	}
	
	public List<StudentDetailsDto> getStudentDetailsDto(StudentDetailsDto studentDetailsDto,  AdminDetailDto adminDetailDto)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getStudentDetailsDao().getStudentDetailsDto(studentDetailsDto, adminDetailDto);
	}

	
	public void updateStudentDetailsDto(StudentDetailsDto studentDetailsDto)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub	
		this.getStudentDetailsDao().updateStudentDetailsDto(studentDetailsDto);
		
	}
	
	public StudentDetailsDto findStudentDetailsById(Integer studentId)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getStudentDetailsDao().findStudentDetailsById(studentId);
	}

	public List<StudentDetailsDto> checkAvailStudentDetails(String student)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getStudentDetailsDao().checkAvailStudentDetails(student);
	}
	public List<StudentDetailsDto> checkAvailStudentDetailsByUsername(String username,String email)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getStudentDetailsDao().checkAvailStudentByUsername(username, email);
	}

	@Override
	public List<StudentDetailsDto> checkMaxUniqueByYear(String uniqueId) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getStudentDetailsDao().checkMaxUniqueByYear(uniqueId);
	}

	@Override
	public List<StudentDetailsDto> checkEmailId(String email_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getStudentDetailsDao().checkEmailId(email_id);
	}

	@Override
	public List<StudentDetailsDto> getStudentDetailsListbyCriteria(String uniqueId, String firstName, String lastName, String dob, String genderId, String emailId, String pincode,  AdminDetailDto adminDetailDto) throws DataAccessException {
		
				// TODO Auto-generated method stub
		return this.getStudentDetailsDao().getStudentDetailsListbyCriteria(uniqueId, firstName, lastName, dob, genderId, emailId, pincode, adminDetailDto);
		
	}
	
	@Override
	public List<StudentDetailsDto> getStudentDetailsListbyUniqueId(String uniqueId) throws DataAccessException {
		
		// TODO Auto-generated method stub
		return this.getStudentDetailsDao().getStudentDetailsListbyUniqueId(uniqueId);
		
	}

	@Override
	public List<StudentDetailsDto> getStudentDetailsListbyCriteriaFeeDetails(String uniqueId, String firstName, String lastName, String className, String genderId, String emailId, String fatherName) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getStudentDetailsDao().getStudentDetailsListbyCriteriaFeeDetails(uniqueId, firstName, lastName, className, genderId, emailId, fatherName);
	}
	
	@Override
	public List<StudentDetailsDto> getStudentDetailsDtoCompleteList(Integer i) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getStudentDetailsDao().getStudentDetailsDtoCompleteList(i);
	}
	
	@Override
	public List<StudentDetailsDto> getStudentDetailsDtoCompleteList(AdminDetailDto adminDetailDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getStudentDetailsDao().getStudentDetailsDtoCompleteList(adminDetailDto);
	}
	
	public List<StudentDetailsDto> getAllStudentDetailsDto(StudentDetailsDto studentDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getStudentDetailsDao().getAllStudentDetailsDto(studentDetailsDto);
	}
	
}
