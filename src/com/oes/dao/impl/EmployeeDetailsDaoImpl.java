package com.oes.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.oes.dao.IEmployeeDetailsDao;
import com.oes.dto.EmployeeDetailsDto;
import com.oes.dto.StudentDetailsDto;

public class EmployeeDetailsDaoImpl implements IEmployeeDetailsDao {

	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List<EmployeeDetailsDto> getEmployeeDetailsDto(EmployeeDetailsDto employeeDetailsDto) throws DataAccessException{
		String queryStringName = "from EmployeeDetailsDto as gkp_employee_details where gkp_employee_details.inum_is_active = 1 ";
	return this.hibernateTemplate.find(queryStringName);	
	}
	
	public void updateEmployeeDetailsDto(EmployeeDetailsDto employeeDetailsDto) throws DataAccessException{
		
		this.hibernateTemplate.saveOrUpdate(employeeDetailsDto);
	}
	
	public EmployeeDetailsDto findEmployeeDetailsById(Integer employeeDetailsId) throws DataAccessException{
		try {
					 
			EmployeeDetailsDto employeeDetailsDto = (EmployeeDetailsDto) this.getHibernateTemplate().get("com.oes.dto.EmployeeDetailsDto",employeeDetailsId);
			return employeeDetailsDto;
		} catch (RuntimeException re) {
			throw re;
		}
		
	}
	public List<EmployeeDetailsDto> checkAvailEmployeeDetails(String employeeDetails) throws DataAccessException{
		
		String queryStringName = "from EmployeeDetailsDto as gkp_employee_details where gkp_employee_details.istr_first_name = '"+employeeDetails+"' and gkp_employee_details.Inum_is_active = 1";
		return this.hibernateTemplate.find(queryStringName);
	}
	
	public List<EmployeeDetailsDto> checkAvailEmployeeByUsername(String username,String email) throws DataAccessException{
		
		String queryStringName = "from EmployeeDetailsDto as gkp_emp_details where gkp_emp_details.istr_first_name = '"+username+"' and gkp_emp_details.istr_email = '"+email+"'";
		return this.hibernateTemplate.find(queryStringName);
	}

	public List<EmployeeDetailsDto> checkMaxUniqueByYear(String uniqueId) throws DataAccessException {

		String getAdministrationUserDetailsQry = "from EmployeeDetailsDto as userDetails where userDetails.istr_unique_id like '"+uniqueId+"'";
		
		return this.getHibernateTemplate().find(getAdministrationUserDetailsQry);
	}
	
	public List<EmployeeDetailsDto> checkEmailId(String email_id) throws DataAccessException {

		String getAdministrationUserDetailsQry = "from EmployeeDetailsDto as userDetails where userDetails.inum_is_active = 1 and userDetails.istr_email = '"+email_id+"'";
		
		return this.getHibernateTemplate().find(getAdministrationUserDetailsQry);
	}
	
	public List<EmployeeDetailsDto> getEmployeeDetailsListbyCriteria(String uniqueId, String firstName, String lastName, String dob,String genderId, String emailId, String pincode)
			throws DataAccessException {
	
		String studentDetailsQry = "from EmployeeDetailsDto as studentDetails where studentDetails.inum_is_active = 1";

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
			   
			   addCriteria = " and studentDetails.istr_pin_code = '%"+pincode+"%'";;
			   
			   studentDetailsQry = studentDetailsQry + addCriteria;
		}		   
		System.out.println("Query : "+studentDetailsQry);	   
		return this.getHibernateTemplate().find(studentDetailsQry);
	}

	public List<EmployeeDetailsDto> getAllEmployeeDetailsDto(EmployeeDetailsDto employeeDetailsDto) throws DataAccessException{
		String queryStringName = "from EmployeeDetailsDto as gkp_employee_details";
		return this.hibernateTemplate.find(queryStringName);	
	}
}
