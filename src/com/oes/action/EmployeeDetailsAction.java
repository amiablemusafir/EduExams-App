package com.oes.action;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import sun.misc.BASE64Encoder;

import com.oes.action.common.SendMailTLS;
import com.oes.common.exception.POLLINGBusinessException;
import com.oes.constants.CommonConstants;
import com.oes.dto.EmployeeDetailsDto;
import com.oes.dto.InstituteDetailsDto;
import com.oes.service.IEmployeeDetailsServices;
import com.oes.service.IMasterDetailsServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.service.IAdminService;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;


public class EmployeeDetailsAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	static Connection con;
	static PreparedStatement st;
	static ResultSet rs;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private EmployeeDetailsDto employeeDetailsDto = new EmployeeDetailsDto();
	private List<EmployeeDetailsDto> employeeDetailsDtoList;
	
	private InstituteDetailsDto instituteDetailsDto = new InstituteDetailsDto();
	private List<InstituteDetailsDto> instituteDetailsDtoList;
	
	private List<EmployeeDetailsDto> checkAvailEmployeeDetailsList;
	private String info;

	File myfile;
	String myfileContentType;
	String myfileFileName;
	String datafile;

	private String unique_id;
	private String first_name;
	private String last_name;
	private String dob;
	private String istr_gender;
	private String email_id;
	private String istr_pin_code;

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

	public String getMyfileContentType() {
		return myfileContentType;
	}

	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}

	public String getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public String getDatafile() {
		return datafile;
	}

	public void setDatafile(String datafile) {
		this.datafile = datafile;
	}

	public String getUnique_id() {
		return unique_id;
	}

	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getIstr_gender() {
		return istr_gender;
	}

	public void setIstr_gender(String istr_gender) {
		this.istr_gender = istr_gender;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getIstr_pin_code() {
		return istr_pin_code;
	}

	public void setIstr_pin_code(String istr_pin_code) {
		this.istr_pin_code = istr_pin_code;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public EmployeeDetailsDto getEmployeeDetailsDto() {
		return employeeDetailsDto;
	}

	public void setEmployeeDetailsDto(EmployeeDetailsDto employeeDetailsDto) {
		this.employeeDetailsDto = employeeDetailsDto;
	}

	public List<EmployeeDetailsDto> getEmployeeDetailsDtoList() {
		return employeeDetailsDtoList;
	}

	public void setEmployeeDetailsDtoList(
			List<EmployeeDetailsDto> employeeDetailsDtoList) {
		this.employeeDetailsDtoList = employeeDetailsDtoList;
	}

	public List<EmployeeDetailsDto> getCheckAvailEmployeeDetailsList() {
		return checkAvailEmployeeDetailsList;
	}

	public void setCheckAvailEmployeeDetailsList(
			List<EmployeeDetailsDto> checkAvailEmployeeDetailsList) {
		this.checkAvailEmployeeDetailsList = checkAvailEmployeeDetailsList;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public InstituteDetailsDto getInstituteDetailsDto() {
		return instituteDetailsDto;
	}

	public void setInstituteDetailsDto(InstituteDetailsDto instituteDetailsDto) {
		this.instituteDetailsDto = instituteDetailsDto;
	}

	public List<InstituteDetailsDto> getInstituteDetailsDtoList() {
		return instituteDetailsDtoList;
	}

	public void setInstituteDetailsDtoList(
			List<InstituteDetailsDto> instituteDetailsDtoList) {
		this.instituteDetailsDtoList = instituteDetailsDtoList;
	}

	public void populateMenu() {
		try {
			if (request.getParameter("currentMenu") != null) {
				request.getSession().setAttribute("permissionSelect",
						request.getParameter("permissionSelect"));
				request.getSession().setAttribute("currentMenu",
						request.getParameter("currentMenu"));
			} else if (request.getParameter("permissionSelect") != null) {
				request.getSession().setAttribute(
						"permissionDtoSideMenuList",
						request.getSession().getAttribute(
								"permissionDtoSideMenuList"));
				request.getSession().setAttribute("permissionSelect",
						request.getParameter("permissionSelect"));
				request.getSession().setAttribute("currentMenu",
						request.getSession().getAttribute("currentMenu"));
			} else {
				request.getSession().setAttribute(
						"permissionDtoSideMenuList",
						request.getSession().getAttribute(
								"permissionDtoSideMenuList"));
				request.getSession().setAttribute("permissionSelect",
						request.getSession().getAttribute("permissionSelect"));
				request.getSession().setAttribute("currentMenu",
						request.getSession().getAttribute("currentMenu"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String showEmployeeDetails() throws POLLINGBusinessException {
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		employeeDetailsDto = new EmployeeDetailsDto();

		request.getSession().setAttribute("employeeDetailsDto", null);
		if (request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}

		SimpleDateFormat st = new SimpleDateFormat("dd-MMM-yyyy");
		String redDate = st.format(new Date());

		employeeDetailsDtoList = this.getEmployeeDetailsServices().getEmployeeDetailsDto(employeeDetailsDto);
		instituteDetailsDtoList = this.getMasterDetailsServices().getInstituteDetailsDtoList();
		
		employeeDetailsDto.setIdt_registration_date(redDate);
		employeeDetailsDto.setIstr_unique_id(this.generateEmployeeUniqueId());

		flag = CommonConstants.SUCCESS_FLAG;
		return flag;

	}

	public String searchEmployeeDetailsByCriteria() throws Exception {

		String flag = CommonConstants.ERROR_FLAG;
		System.out.println("Search Students Details By Criteria Action......");

		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		try {
			String uniqueId = "";
			if (this.getUnique_id() != null) {
				uniqueId = this.getUnique_id();
				System.out.println("Unique ID : " + uniqueId);
			}

			String firstName = "";
			if (this.getFirst_name() != null) {
				firstName = this.getFirst_name();
				System.out.println("First Name : " + firstName);
			}

			String lastName = "";
			if (this.getLast_name() != null) {
				lastName = this.getLast_name();
				System.out.println("Last Name : " + lastName);
			}

			String dateOfBirth = this.getDob();
			System.out.println("Date OF Birth : " + dateOfBirth);

			String genderId = "0";
			if (this.getIstr_gender() != null) {
				genderId = this.getIstr_gender();
				System.out.println("Gender ID : " + genderId);
			}

			String emailId = "";
			if (this.getEmail_id() != null) {
				emailId = this.getEmail_id();
				System.out.println("Email ID : " + emailId);
			}

			String pincode = "";
			if (this.getIstr_pin_code() != null) {
				pincode = this.getIstr_pin_code();
				System.out.println("Pincode : " + pincode);
			}

			employeeDetailsDtoList = new ArrayList<EmployeeDetailsDto>();
			employeeDetailsDtoList = this.getEmployeeDetailsServices()
					.getEmployeeDetailsListbyCriteria(uniqueId, firstName,
							lastName, dateOfBirth, genderId, emailId, pincode);

			flag = CommonConstants.SUCCESS_FLAG;
		} catch (Exception er) {
			er.printStackTrace();
		}
		return flag;
	}

	public String saveEmployeeDetails() throws POLLINGBusinessException {

		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		if (request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		try {

			if (employeeDetailsDto.getInum_employee_id() == null) {

				List<EmployeeDetailsDto> employeeDetailsDtoList = this
						.getEmployeeDetailsServices()
						.checkAvailEmployeeDetailsByUsername(
								employeeDetailsDto.getIstr_first_name(),
								employeeDetailsDto.getIstr_email());
				if (employeeDetailsDtoList != null
						&& employeeDetailsDtoList.size() > 0) {

					this.showEmployeeDetails();
					employeeDetailsDto = null;
					info = "Unique Employee ID is already generated. Kindly use the �Forget Password� to know about your password.";
					flag = "already_exist";

				} else {

					BufferedImage imgFile = getImageAndReduceSize(getMyfile());
					ByteArrayOutputStream bas = new ByteArrayOutputStream();
					ImageIO.write(imgFile, "jpg", bas);

					byte[] fileContents = bas.toByteArray();

					BASE64Encoder encodeData = new BASE64Encoder();
					String fileData = encodeData.encode(fileContents);

					employeeDetailsDto.setIbl_std_pic(fileData);

					employeeDetailsDto.setIdt_entry_date(new Date());
					employeeDetailsDto.setInum_is_active(1);

					SimpleDateFormat st = new SimpleDateFormat("dd-MMM-yyyy");
					String redDate = st.format(new Date());

					employeeDetailsDto.setAdminDetailDto(adminDetailDto);
					employeeDetailsDto.setIdt_registration_date(redDate);
					
					if(employeeDetailsDto.getInstituteDetailsDto().getOnum_slno() == null) {
						employeeDetailsDto.setInstituteDetailsDto(null);
					}

					this.getEmployeeDetailsServices().updateEmployeeDetailsDto(employeeDetailsDto);

					AdminDetailDto adminDetailDto2 = new AdminDetailDto();

					adminDetailDto2.setIdt_entry_date(new Date());
					adminDetailDto2.setInum_account_status(2);
					adminDetailDto2.setInum_is_active(1);
					adminDetailDto2.setInum_is_verified(2);
					adminDetailDto2.setInum_role_id(4);
					adminDetailDto2.setInum_account_status(1);
					adminDetailDto2.setIstr_address(employeeDetailsDto.getIstr_street_address());
					adminDetailDto2.setIstr_email(employeeDetailsDto.getIstr_email());
					adminDetailDto2.setIstr_login_id(employeeDetailsDto.getIstr_unique_id());
					adminDetailDto2.setIstr_dob(employeeDetailsDto.getIstr_date_of_birth());
					adminDetailDto2.setIstr_password("");
					adminDetailDto2.setIstr_user_name(employeeDetailsDto.getIstr_first_name());
					adminDetailDto2.setInum_student_employee_id(employeeDetailsDto.getInum_employee_id());

					if(employeeDetailsDto.getInstituteDetailsDto().getOnum_slno().equals("0")) {
						InstituteDetailsDto detailsDto = new InstituteDetailsDto();
						adminDetailDto2.setInstituteDetailsDto(detailsDto);						
					} else {
						adminDetailDto2.setInstituteDetailsDto(employeeDetailsDto.getInstituteDetailsDto());	
					}

					String password = this.randomGeneratedString();

					adminDetailDto2.setIstr_password(this.Md5value(password));
					this.getAdminManagementServices().saveOrUpdatUserDetailDto(adminDetailDto2);
					adminDetailDto2 = null;

					info = "Data has been submited successfully. Please check Email id for Username and Password.";
					try {
						this.sendMailToRegisteredUser(employeeDetailsDto, password);
					} catch (Exception e) {
						e.printStackTrace();
					}
					employeeDetailsDto = null;
					this.showEmployeeDetails();
					flag = CommonConstants.SUCCESS_FLAG;
				}

			} else {
				System.out.println("My File Name" + getMyfileFileName());
				if (getMyfileFileName() != null) {
					BufferedImage imgFile = getImageAndReduceSize(getMyfile());
					ByteArrayOutputStream bas = new ByteArrayOutputStream();
					ImageIO.write(imgFile, "jpg", bas);

					byte[] fileContents = bas.toByteArray();

					BASE64Encoder encodeData = new BASE64Encoder();
					String fileData = encodeData.encode(fileContents);

					employeeDetailsDto.setIbl_std_pic(fileData);
				}
				employeeDetailsDto.setIdt_entry_date(new Date());
				employeeDetailsDto.setInum_is_active(1);
				employeeDetailsDto.setAdminDetailDto(adminDetailDto);
				if(employeeDetailsDto.getInstituteDetailsDto().getOnum_slno().equals("0")) {
					InstituteDetailsDto detailsDto = new InstituteDetailsDto();
					employeeDetailsDto.setInstituteDetailsDto(detailsDto);
				}
				SimpleDateFormat st = new SimpleDateFormat("dd-MMM-yyyy");
				String redDate = st.format(new Date());

				employeeDetailsDto.setIdt_registration_date(redDate);

				this.getEmployeeDetailsServices().updateEmployeeDetailsDto(employeeDetailsDto);

				info = "Employee details has been Updated successfully.";
				employeeDetailsDto = null;
				this.showEmployeeDetails();
				flag = "update_success";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public String editEmployeeDetails() throws Exception {

		String flag = CommonConstants.FAILURE_ERROR;
		if (request.getSession().getAttribute("username") == null) {
			return flag;
		}
		String emp_id = request.getParameter("emp_id");
		Integer empid = Integer.parseInt(emp_id);

		employeeDetailsDto = new EmployeeDetailsDto();
		employeeDetailsDto = this.getEmployeeDetailsServices().findEmployeeDetailsById(empid);
		instituteDetailsDtoList = this.getMasterDetailsServices().getInstituteDetailsDtoList();
		
		request.getSession().setAttribute("employeeDetailsDto",employeeDetailsDto);
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;

	}

	public String deleteEmployeeInfo() throws Exception {

		String flag = CommonConstants.FAILURE_ERROR;
		if (request.getSession().getAttribute("username") == null) {
			return flag;
		}
		Integer empid = Integer.parseInt(request.getParameter("emp_id"));
		employeeDetailsDto = this.getEmployeeDetailsServices().findEmployeeDetailsById(empid);
		employeeDetailsDto.setInum_is_active(0);
		this.getEmployeeDetailsServices().updateEmployeeDetailsDto(employeeDetailsDto);
		info = "Employee Details has been deleted successfully";
		employeeDetailsDto = new EmployeeDetailsDto();
		flag = CommonConstants.SUCCESS_FLAG;
		showEmployeeDetails();
		return flag;
	}

	public void sendMailToRegisteredUser(EmployeeDetailsDto employeeDetailsDto, String password) {

		Calendar cal = Calendar.getInstance();
		String date = " Date:" + cal.getTime();
		String url = "https://www.xamdesk.com";

		String emailBody = "Hi "+employeeDetailsDto.getIstr_first_name()+"<br/><br/>Here is your member account login information for Xamdesk as requested. Please be sure to change your password after login."+
						   "<br/><br/><h4>Your Member Account</h4><br/><br/>Username :&nbsp;&nbsp;&nbsp;"+employeeDetailsDto.getAdminDetailDto().getIstr_login_id()+"<br/>Password :&nbsp;&nbsp;&nbsp;"+password+
						   "<br/><br/>If you have any enquiries, please do not hesitate to contact our support team who are available 24/7 to assist you. Call (+91) 9958903074.<br/><br/>Regards<br/>Xamdesk Team";


		System.out.println("emailBody************************************"+ emailBody);
		SendMailTLS sendMailTLS = new SendMailTLS(employeeDetailsDto.getAdminDetailDto().getIstr_email(), "Registration Mail", emailBody);
		sendMailTLS.sendEmail();
	}

	// Resize of Image
	protected BufferedImage getImageAndReduceSize(File imageFile) {

		BufferedImage originalImage = null;
		try {
			originalImage = ImageIO.read(imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
				: originalImage.getType();
		// call function
		BufferedImage resizeImageJpg = resizeImage(originalImage, type);
		return resizeImageJpg;
	}

	// Reduce the height and width of images
	protected BufferedImage resizeImage(BufferedImage originalImage, int type) {
		BufferedImage resizedImage = new BufferedImage(400, 600, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, 400, 600, null);
		g.dispose();

		return resizedImage;
	}

	public String generateEmployeeUniqueId() {

		// code start to create unique id for a student

		DateFormat dateFormat = new SimpleDateFormat("yy");
		String yy = dateFormat.format(new Date());
		System.out.println("To get yy(e.g-14)" + yy);
		String unique_id = "";
		Integer maxUniqueId = 0;
		Integer finalMaxUniqueId = 0;

		try {
			List<EmployeeDetailsDto> userDetailsList = this.getEmployeeDetailsServices().getAllEmployeeDetailsDto(employeeDetailsDto);
			if (userDetailsList != null && userDetailsList.size() > 0) {
				unique_id = "XD/EMP/" + yy + "/%";
				List<EmployeeDetailsDto> userDetailsDtoList = this
						.getEmployeeDetailsServices().checkMaxUniqueByYear(
								unique_id);
				if (userDetailsDtoList != null && userDetailsDtoList.size() > 0) {
					for (int i = 0; i < userDetailsDtoList.size(); i++) {

						String maxIdValue = userDetailsDtoList.get(i)
								.getIstr_unique_id();
						String[] uniqueIdArray = maxIdValue.split("/");

						maxUniqueId = Integer.parseInt(uniqueIdArray[3]);
						if (maxUniqueId > finalMaxUniqueId) {
							finalMaxUniqueId = maxUniqueId;
						}
					}

					finalMaxUniqueId++;
					unique_id = "XD/EMP/" + yy + "/" + finalMaxUniqueId;
					System.out.println("The final unique id is :::::::"
							+ unique_id);

				} else {
					unique_id = "XD/EMP/" + yy + "/101";
				}
			} else {
				unique_id = "XD/EMP/" + yy + "/101";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// end of code
		return unique_id;
	}

	// this method is used for generating string
	public String randomGeneratedString() {

		final int PASSWORD_LENGTH = 8;
		StringBuffer sb = new StringBuffer();
		for (int x = 0; x < PASSWORD_LENGTH; x++) {
			sb.append((char) ((int) (Math.random() * 26) + 97));
		}
		String a = sb.toString();
		System.out.println(a);

		return a;
	}

	// Method Of MD5 algorithm...........
	public String Md5value(String pass) throws Exception, NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();

		m.update(pass.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		String hashtext = bigInt.toString(16);
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

	private HttpServletRequest getRequest() {
		return request;
	}

	private IEmployeeDetailsServices getEmployeeDetailsServices() {
		Object serviceObj = ServiceLocator.getInstance().getService(
				CommonConstants.EMPLOYEE_DETAILS);
		return serviceObj == null ? null
				: (IEmployeeDetailsServices) serviceObj;
	}

	// Admin service locater
	private IAdminService getAdminManagementServices() {
		Object serviceObj = ServiceLocator.getInstance().getService(
				com.sms.constants.CommonConstants.ADMIN_MANAGEMENT_SERVICE);
		return serviceObj == null ? null : (IAdminService) serviceObj;
	}
	
	// Admin service locater
	private IMasterDetailsServices getMasterDetailsServices () {
		Object serviceObj = ServiceLocator.getInstance().getService(com.oes.constants.CommonConstants.MASTER_DETAILS);
			return serviceObj == null ? null : (IMasterDetailsServices) serviceObj;
	}
}
