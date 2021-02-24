package com.oes.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.oes.dao.IStudentDetailsDao;
import com.oes.dto.StudentDetailsDto;
import com.sms.admin.dto.AdminDetailDto;


public class StudentDetailsDaoImpl implements IStudentDetailsDao {
	
	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List<StudentDetailsDto> getStudentDetailsDto(StudentDetailsDto studentDetailsDto, AdminDetailDto adminDetailDto) throws DataAccessException{
		
		String queryStringName = "";
		if(adminDetailDto.getInum_role_id().equals(0)) {
			queryStringName = "from StudentDetailsDto as gkp_student_details where gkp_student_details.inum_is_active = 1 ";
		} else {
			queryStringName = "from StudentDetailsDto as gkp_student_details where gkp_student_details.inum_is_active = 1 and gkp_student_details.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id();
		}
		return this.hibernateTemplate.find(queryStringName);	
	}
	
	public void updateStudentDetailsDto(StudentDetailsDto studentDetailsDto) throws DataAccessException{
		
		this.hibernateTemplate.saveOrUpdate(studentDetailsDto);
	}
	
	public StudentDetailsDto findStudentDetailsById(Integer studentDetailsId) throws DataAccessException{
		try {
					 
			StudentDetailsDto studentDetailsDto = (StudentDetailsDto) this.getHibernateTemplate().get("com.oes.dto.StudentDetailsDto",studentDetailsId);
			return studentDetailsDto;
		} catch (RuntimeException re) {
			throw re;
		}
		
	}
	public List<StudentDetailsDto> checkAvailStudentDetails(String studentDetails) throws DataAccessException{
		
		String queryStringName = "from StudentDetailsDto as gkp_student_details where gkp_student_details.istr_first_name = '"+studentDetails+"' and gkp_student_details.inum_is_active = 1";
		return this.hibernateTemplate.find(queryStringName);
	}
	public List<StudentDetailsDto> checkAvailStudentByUsername(String username,String email) throws DataAccessException{
		
		String queryStringName = "from StudentDetailsDto as gkp_student_details where gkp_student_details.istr_email = '"+email+"'";
		return this.hibernateTemplate.find(queryStringName);
	}

	public List<StudentDetailsDto> checkMaxUniqueByYear(String uniqueId) throws DataAccessException {

		String getAdministrationUserDetailsQry = "from StudentDetailsDto as userDetails where userDetails.istr_unique_id like '"+uniqueId+"'";
		
		return this.getHibernateTemplate().find(getAdministrationUserDetailsQry);
	}
	
	public List<StudentDetailsDto> checkEmailId(String email_id) throws DataAccessException {

		String getAdministrationUserDetailsQry = "from StudentDetailsDto as userDetails where userDetails.inum_is_active = 1 and userDetails.istr_email = '"+email_id+"'";
		
		return this.getHibernateTemplate().find(getAdministrationUserDetailsQry);
	}
	
	public List<StudentDetailsDto> getStudentDetailsListbyCriteria(String uniqueId, String firstName, String lastName, String dob,String genderId, String emailId, String pincode, AdminDetailDto adminDetailDto)
			throws DataAccessException {
	
		String studentDetailsQry = "from StudentDetailsDto as studentDetails " +
				"where studentDetails.inum_is_active = 1";
	
	 
		String addCriteria = new String();
		
		
		// unique Id	
		if(!uniqueId.equals("")){
			   
			   System.out.println("Unique ID......");
			   
			   addCriteria = " and studentDetails.istr_unique_id like '%"+uniqueId+"%'";
			  
			   studentDetailsQry = studentDetailsQry + addCriteria;
		}
		  	
			
		// First Name 
		if(!firstName.equals("")){
			   
			   System.out.println("First Name...............");
			   
			   addCriteria = " and studentDetails.istr_first_name like '%"+firstName+"%'";
			   
			   studentDetailsQry = studentDetailsQry + addCriteria;
		}
		   
			
		// Last Name 
		if(!lastName.equals("")){
			   
			  System.out.println("Last Name .............."); 
			   
			  addCriteria = " and studentDetails.istr_last_name like '%"+lastName+"%'";
			  
			  studentDetailsQry = studentDetailsQry + addCriteria;
			   
		}
		   
		// DOB
		if(!dob.equals("")){
			   
			 System.out.println("DOB ...............");  
			   
			 addCriteria = " and studentDetails.istr_date_of_birth = '"+dob+"'";
			 
			 studentDetailsQry = studentDetailsQry + addCriteria;
		}
		   
		// Gender ID 
		if(!genderId.equals("0")){
		   
			   System.out.println("Gender ID ............");
			   
			   addCriteria = " and studentDetails.istr_gender = '"+genderId+"'";
			   
			   studentDetailsQry = studentDetailsQry + addCriteria;
		}
		   
		// Email ID 
		if(!emailId.equals("")){
			   
			   System.out.println("Email ID .............");
			   
			   addCriteria = " and studentDetails.istr_email like '%"+emailId+"%'";
			   
			   studentDetailsQry = studentDetailsQry + addCriteria;
		}
		   
		// Pin code
		if(!pincode.equals("")){
			   
			   System.out.println("Pincode ..............");
			   
			   addCriteria = " and studentDetails.istr_pin_code = '%"+pincode+"%'";
			   
			   studentDetailsQry = studentDetailsQry + addCriteria;
		}
		
		if(!adminDetailDto.getInum_role_id().equals(1)) {
			 addCriteria = "and studentDetails.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id()+"";
			   
			 studentDetailsQry = studentDetailsQry + addCriteria;			 
		}
		   
		System.out.println("Query : "+studentDetailsQry);
	   
		return this.getHibernateTemplate().find(studentDetailsQry);
	}

	public List<StudentDetailsDto> getStudentDetailsListbyUniqueId(String uniqueId) throws DataAccessException {
	
		String studentDetailsQry = "from StudentDetailsDto as studentDetails where studentDetails.istr_unique_id = '"+uniqueId+"'";
		return this.getHibernateTemplate().find(studentDetailsQry);
	}

	
	@Override
	public List<StudentDetailsDto> getStudentDetailsListbyCriteriaFeeDetails(String uniqueId, String firstName, String lastName, String className, String genderId, String emailId, String fatherName) throws DataAccessException {
		// TODO Auto-generated method stub
		String studentDetailsQry = "from StudentDetailsDto as studentDetails " +
				"where studentDetails.inum_is_active = 1";
	
	 
		String addCriteria = new String();
		
		
		// unique Id	
		if(!uniqueId.equals("")){
			   
			   System.out.println("Unique ID......");
			   
			   addCriteria = " and studentDetails.istr_unique_id like '%"+uniqueId+"%'";
			  
			   studentDetailsQry = studentDetailsQry + addCriteria;
		}
		  	
			
		// First Name 
		if(!firstName.equals("")){
			   
			   System.out.println("First Name...............");
			   
			   addCriteria = " and studentDetails.istr_first_name like '%"+firstName+"%'";
			   
			   studentDetailsQry = studentDetailsQry + addCriteria;
		}
		   
			
		// Last Name 
		if(!lastName.equals("")){
			   
			  System.out.println("Last Name .............."); 
			   
			  addCriteria = " and studentDetails.istr_last_name like '%"+lastName+"%'";
			  
			  studentDetailsQry = studentDetailsQry + addCriteria;
			   
		}
		   
		// DOB
		if(!className.equals("")){
			   
			 System.out.println("Class Name ...............");  
			   
			 addCriteria = " and studentDetails.istr_class = '%"+className+"%'";
			 
			 studentDetailsQry = studentDetailsQry + addCriteria;
		}
		   
		// Gender ID 
		if(!genderId.equals("0")){
		   
			   System.out.println("Gender ID ............");
			   
			   addCriteria = " and studentDetails.istr_gender = '"+genderId+"'";
			   
			   studentDetailsQry = studentDetailsQry + addCriteria;
		}
		   
		// Email ID 
		if(!emailId.equals("")){
			   
			   System.out.println("Email ID .............");
			   
			   addCriteria = " and studentDetails.istr_email like '%"+emailId+"%'";
			   
			   studentDetailsQry = studentDetailsQry + addCriteria;
		}
		   
		// Father Name
		if(!fatherName.equals("")){
			   
			   System.out.println("Father Name ..............");
			   
			   addCriteria = " and studentDetails.istr_father_name = '%"+fatherName+"%'";
			   
			   studentDetailsQry = studentDetailsQry + addCriteria;
		}
		   
		System.out.println("Query : "+studentDetailsQry);
	   
		return this.getHibernateTemplate().find(studentDetailsQry);
	}
	
	
	public List<StudentDetailsDto> getStudentDetailsDtoCompleteList(Integer i) throws DataAccessException{
		String queryStringName = "from StudentDetailsDto as gkp_student_details where gkp_student_details.inum_is_active = "+i+"";
		return this.hibernateTemplate.find(queryStringName);	
	}
	
	public List<StudentDetailsDto> getStudentDetailsDtoCompleteList(AdminDetailDto adminDetailDto) throws DataAccessException{
		String queryStringName = "";
		if(adminDetailDto.getInum_role_id().equals(1)) {
			queryStringName= "from StudentDetailsDto as gkp_student_details where gkp_student_details.inum_is_active = 0 OR gkp_student_details.inum_is_active = 1";
		} else {
			queryStringName= "from StudentDetailsDto as gkp_student_details where gkp_student_details.inum_is_active = 0 OR gkp_student_details.inum_is_active = 1 and  gkp_student_details.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id();
		}
		return this.hibernateTemplate.find(queryStringName);	
	}
	
	public List<StudentDetailsDto> getAllStudentDetailsDto(StudentDetailsDto studentDetailsDto) throws DataAccessException{
		
		String queryStringName = "";
		queryStringName = "from StudentDetailsDto as gkp_student_details";
		return this.hibernateTemplate.find(queryStringName);	
	}
	
}
