package com.oes.action;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import sun.misc.BASE64Encoder;

import com.oes.action.common.CommonMethod;
import com.oes.action.common.CreateQuestionPaper;
import com.oes.action.common.Enums;
import com.oes.common.exception.POLLINGBusinessException;
import com.oes.constants.CommonConstants;
import com.oes.dto.BatchMasterDto;
import com.oes.dto.CategoryDetailsDto;
import com.oes.dto.CourseDetailsDto;
import com.oes.dto.ErrorDetailsDto;
import com.oes.dto.ExamDetailsDto;
import com.oes.dto.ExamImageMasterDto;
import com.oes.dto.ExamQuestionDetailsDto;
import com.oes.dto.ExamRequestDetailsDto;
import com.oes.dto.ExamSectionDetailsDto;
import com.oes.dto.ExamSubCategoryDetailsDto;
import com.oes.dto.ExaminationBatchMappingDto;
import com.oes.dto.MappedExamDetailsDto;
import com.oes.dto.QuestionDetailsDto;
import com.oes.dto.ResultDescriptionDto;
import com.oes.dto.ResultDetailsDto;
import com.oes.dto.ResultReviewSubjectDto;
import com.oes.dto.ScoreGenerationDto;
import com.oes.dto.SectionDetailsDto;
import com.oes.dto.StudentDetailsDto;
import com.oes.dto.StudentExamDetailsDto;
import com.oes.dto.StudentMappedExamDetailsDto;
import com.oes.dto.SubCategoryDetailsDto;
import com.oes.service.IExaminationDetailsServices;
import com.oes.service.IMasterDetailsServices;
import com.oes.service.IStudentDetailsServices;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.dto.PermissionMasterDto;
import com.sms.admin.dto.RoleMasterDto;
import com.sms.admin.dto.RolePermissionMasterDto;
import com.sms.admin.service.IAdminService;
import com.sms.common.exception.IHMSException;
import com.sms.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class ExamDetailsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private String randomStingJsp;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String messages;
	private String info;
	private String header_info;
	private CourseDetailsDto courseDetailsDto;
	private List<CourseDetailsDto> courseDetailsDtoList;
	private List<StudentMappedExamDetailsDto> studentMappedExamDetailsDtoList;
	
	ExaminationBatchMappingDto examinationBatchMappingDto;
	List<ExaminationBatchMappingDto> examinationBatchMappingDtoList;
	List examBatchMappingDtoList;
	
	BatchMasterDto batchMasterDto;
	List<BatchMasterDto> batchMasterDtoList;
	
	private ExamDetailsDto examDetailsDto;
	private List<ExamDetailsDto> examDetailsDtoList;
	private List examinationDetailsDtoList;
	
	private ExamImageMasterDto examImageMasterDto;
	private List<ExamImageMasterDto> examImageMasterDtoList;
	
	private ExamQuestionDetailsDto examQuestionDetailsDto;
	private List<ExamQuestionDetailsDto> examQuestionDetailsDtoList;
		
	private ExamSectionDetailsDto examSectionDetailsDto;
	private List<ExamSectionDetailsDto> examSectionDetailsDtoList;
	
	private SectionDetailsDto sectionDetailsDto;
	private List<SectionDetailsDto> sectionDetailsDtoList;
	
	private QuestionDetailsDto questionDetailsDto;
	private List<QuestionDetailsDto> questionDetailsDtoList;
	
	private StudentExamDetailsDto studentExamDetailsDto;
	private List<StudentExamDetailsDto> studentExamDetailsDtoList;
	
	private StudentDetailsDto studentDetailsDto;
	private List<StudentDetailsDto> studentDetailsDtoList;
	
	private ExamRequestDetailsDto examRequestDetailsDto;
	private List<ExamRequestDetailsDto> examRequestDetailsDtoList;
	
	private ResultDetailsDto resultDetailsDto;
	private List<ResultDetailsDto> resultDetailsDtoList;
	
	private CategoryDetailsDto categoryDetailsDto;
	private List<CategoryDetailsDto> categoryDetailsDtoList;
	
	private SubCategoryDetailsDto subCategoryDetailsDto;
	private List<SubCategoryDetailsDto> subCategoryDetailsDtoList;
	
	private String exam_name;
	private String month_name;
	
	private String section[];
	private String question[];
	private String mark[];
	
    private File obl_question;
	private String obl_questionContentType;
	private String obl_questionname;
	
	private File option1;
	private String option1ContentType;
	private String option1name;
	
	private File option2;
	private String option2ContentType;
	private String option2name;
	
	private File option3;
	private String option3ContentType;
	private String option3name;
	
	private File option4;
	private String option4ContentType;
	private String option4name;
	
	private File option5;
	private String option5ContentType;
	private String option5name;
	
	private File myfile;
	private String myfileContentType;
	private String myfilename;
 	
	private File obl_solution;
	private String obl_solutionContentType;
	private String obl_solutionname;
	
	private File uploaded_excel;
	private String uploaded_excelContentType;
	private String uploaded_excelname;
	
	
	public List getExamBatchMappingDtoList() {
		return examBatchMappingDtoList;
	}
	public void setExamBatchMappingDtoList(List examBatchMappingDtoList) {
		this.examBatchMappingDtoList = examBatchMappingDtoList;
	}
	public List getExaminationDetailsDtoList() {
		return examinationDetailsDtoList;
	}
	public void setExaminationDetailsDtoList(List examinationDetailsDtoList) {
		this.examinationDetailsDtoList = examinationDetailsDtoList;
	}
	public File getOption5() {
		return option5;
	}
	public void setOption5(File option5) {
		this.option5 = option5;
	}
	public String getOption5ContentType() {
		return option5ContentType;
	}
	public void setOption5ContentType(String option5ContentType) {
		this.option5ContentType = option5ContentType;
	}
	public String getOption5name() {
		return option5name;
	}
	public void setOption5name(String option5name) {
		this.option5name = option5name;
	}
	public File getUploaded_excel() {
		return uploaded_excel;
	}
	public void setUploaded_excel(File uploaded_excel) {
		this.uploaded_excel = uploaded_excel;
	}
	public String getUploaded_excelContentType() {
		return uploaded_excelContentType;
	}
	public void setUploaded_excelContentType(String uploaded_excelContentType) {
		this.uploaded_excelContentType = uploaded_excelContentType;
	}
	public String getUploaded_excelname() {
		return uploaded_excelname;
	}
	public void setUploaded_excelname(String uploaded_excelname) {
		this.uploaded_excelname = uploaded_excelname;
	}
	public CategoryDetailsDto getCategoryDetailsDto() {
		return categoryDetailsDto;
	}
	public void setCategoryDetailsDto(CategoryDetailsDto categoryDetailsDto) {
		this.categoryDetailsDto = categoryDetailsDto;
	}
	public List<CategoryDetailsDto> getCategoryDetailsDtoList() {
		return categoryDetailsDtoList;
	}
	public void setCategoryDetailsDtoList(
			List<CategoryDetailsDto> categoryDetailsDtoList) {
		this.categoryDetailsDtoList = categoryDetailsDtoList;
	}
	public SubCategoryDetailsDto getSubCategoryDetailsDto() {
		return subCategoryDetailsDto;
	}
	public void setSubCategoryDetailsDto(SubCategoryDetailsDto subCategoryDetailsDto) {
		this.subCategoryDetailsDto = subCategoryDetailsDto;
	}
	public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoList() {
		return subCategoryDetailsDtoList;
	}
	public void setSubCategoryDetailsDtoList(
			List<SubCategoryDetailsDto> subCategoryDetailsDtoList) {
		this.subCategoryDetailsDtoList = subCategoryDetailsDtoList;
	}
	public File getObl_solution() {
		return obl_solution;
	}
	public void setObl_solution(File obl_solution) {
		this.obl_solution = obl_solution;
	}
	public String getObl_solutionContentType() {
		return obl_solutionContentType;
	}
	public void setObl_solutionContentType(String obl_solutionContentType) {
		this.obl_solutionContentType = obl_solutionContentType;
	}
	public String getObl_solutionname() {
		return obl_solutionname;
	}
	public void setObl_solutionname(String obl_solutionname) {
		this.obl_solutionname = obl_solutionname;
	}
	public List<StudentMappedExamDetailsDto> getStudentMappedExamDetailsDtoList() {
		return studentMappedExamDetailsDtoList;
	}
	public void setStudentMappedExamDetailsDtoList(
			List<StudentMappedExamDetailsDto> studentMappedExamDetailsDtoList) {
		this.studentMappedExamDetailsDtoList = studentMappedExamDetailsDtoList;
	}
	public ExamImageMasterDto getExamImageMasterDto() {
		return examImageMasterDto;
	}
	public void setExamImageMasterDto(ExamImageMasterDto examImageMasterDto) {
		this.examImageMasterDto = examImageMasterDto;
	}
	public List<ExamImageMasterDto> getExamImageMasterDtoList() {
		return examImageMasterDtoList;
	}
	public void setExamImageMasterDtoList(
			List<ExamImageMasterDto> examImageMasterDtoList) {
		this.examImageMasterDtoList = examImageMasterDtoList;
	}
	public String getRandomStingJsp() {
		return randomStingJsp;
	}
	public void setRandomStingJsp(String randomStingJsp) {
		this.randomStingJsp = randomStingJsp;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	public String getMonth_name() {
		return month_name;
	}
	public void setMonth_name(String month_name) {
		this.month_name = month_name;
	}
	public ResultDetailsDto getResultDetailsDto() {
		return resultDetailsDto;
	}
	public void setResultDetailsDto(ResultDetailsDto resultDetailsDto) {
		this.resultDetailsDto = resultDetailsDto;
	}
	public List<ResultDetailsDto> getResultDetailsDtoList() {
		return resultDetailsDtoList;
	}
	public void setResultDetailsDtoList(List<ResultDetailsDto> resultDetailsDtoList) {
		this.resultDetailsDtoList = resultDetailsDtoList;
	}
	public ExamQuestionDetailsDto getExamQuestionDetailsDto() {
		return examQuestionDetailsDto;
	}
	public void setExamQuestionDetailsDto(
			ExamQuestionDetailsDto examQuestionDetailsDto) {
		this.examQuestionDetailsDto = examQuestionDetailsDto;
	}
	public List<ExamQuestionDetailsDto> getExamQuestionDetailsDtoList() {
		return examQuestionDetailsDtoList;
	}
	public void setExamQuestionDetailsDtoList(
			List<ExamQuestionDetailsDto> examQuestionDetailsDtoList) {
		this.examQuestionDetailsDtoList = examQuestionDetailsDtoList;
	}
	public String getHeader_info() {
		return header_info;
	}
	public void setHeader_info(String header_info) {
		this.header_info = header_info;
	}
	public StudentDetailsDto getStudentDetailsDto() {
		return studentDetailsDto;
	}
	public void setStudentDetailsDto(StudentDetailsDto studentDetailsDto) {
		this.studentDetailsDto = studentDetailsDto;
	}
	public List<StudentDetailsDto> getStudentDetailsDtoList() {
		return studentDetailsDtoList;
	}
	public void setStudentDetailsDtoList(
			List<StudentDetailsDto> studentDetailsDtoList) {
		this.studentDetailsDtoList = studentDetailsDtoList;
	}
	public ExamRequestDetailsDto getExamRequestDetailsDto() {
		return examRequestDetailsDto;
	}
	public void setExamRequestDetailsDto(ExamRequestDetailsDto examRequestDetailsDto) {
		this.examRequestDetailsDto = examRequestDetailsDto;
	}
	public List<ExamRequestDetailsDto> getExamRequestDetailsDtoList() {
		return examRequestDetailsDtoList;
	}
	public void setExamRequestDetailsDtoList(
			List<ExamRequestDetailsDto> examRequestDetailsDtoList) {
		this.examRequestDetailsDtoList = examRequestDetailsDtoList;
	}
	public StudentExamDetailsDto getStudentExamDetailsDto() {
		return studentExamDetailsDto;
	}
	public void setStudentExamDetailsDto(StudentExamDetailsDto studentExamDetailsDto) {
		this.studentExamDetailsDto = studentExamDetailsDto;
	}
	
	public List<StudentExamDetailsDto> getStudentExamDetailsDtoList() {
		return studentExamDetailsDtoList;
	}
	public void setStudentExamDetailsDtoList(
			List<StudentExamDetailsDto> studentExamDetailsDtoList) {
		this.studentExamDetailsDtoList = studentExamDetailsDtoList;
	}
	public ExamSectionDetailsDto getExamSectionDetailsDto() {
		return examSectionDetailsDto;
	}
	public void setExamSectionDetailsDto(ExamSectionDetailsDto examSectionDetailsDto) {
		this.examSectionDetailsDto = examSectionDetailsDto;
	}
	public List<ExamSectionDetailsDto> getExamSectionDetailsDtoList() {
		return examSectionDetailsDtoList;
	}
	public void setExamSectionDetailsDtoList(
			List<ExamSectionDetailsDto> examSectionDetailsDtoList) {
		this.examSectionDetailsDtoList = examSectionDetailsDtoList;
	}
	public QuestionDetailsDto getQuestionDetailsDto() {
		return questionDetailsDto;
	}
	public void setQuestionDetailsDto(QuestionDetailsDto questionDetailsDto) {
		this.questionDetailsDto = questionDetailsDto;
	}
	public List<QuestionDetailsDto> getQuestionDetailsDtoList() {
		return questionDetailsDtoList;
	}
	public void setQuestionDetailsDtoList(
			List<QuestionDetailsDto> questionDetailsDtoList) {
		this.questionDetailsDtoList = questionDetailsDtoList;
	}
	public File getObl_question() {
		return obl_question;
	}
	public void setObl_question(File oblQuestion) {
		obl_question = oblQuestion;
	}
	public String getObl_questionContentType() {
		return obl_questionContentType;
	}
	public void setObl_questionContentType(String oblQuestionContentType) {
		obl_questionContentType = oblQuestionContentType;
	}
	public String getObl_questionname() {
		return obl_questionname;
	}
	public void setObl_questionname(String oblQuestionname) {
		obl_questionname = oblQuestionname;
	}
	public File getOption1() {
		return option1;
	}
	public void setOption1(File option1) {
		this.option1 = option1;
	}
	public String getOption1ContentType() {
		return option1ContentType;
	}
	public void setOption1ContentType(String option1ContentType) {
		this.option1ContentType = option1ContentType;
	}
	public String getOption1name() {
		return option1name;
	}
	public void setOption1name(String option1name) {
		this.option1name = option1name;
	}
	public File getOption2() {
		return option2;
	}
	public void setOption2(File option2) {
		this.option2 = option2;
	}
	public String getOption2ContentType() {
		return option2ContentType;
	}
	public void setOption2ContentType(String option2ContentType) {
		this.option2ContentType = option2ContentType;
	}
	public String getOption2name() {
		return option2name;
	}
	public void setOption2name(String option2name) {
		this.option2name = option2name;
	}
	public File getOption3() {
		return option3;
	}
	public void setOption3(File option3) {
		this.option3 = option3;
	}
	public String getOption3ContentType() {
		return option3ContentType;
	}
	public void setOption3ContentType(String option3ContentType) {
		this.option3ContentType = option3ContentType;
	}
	public String getOption3name() {
		return option3name;
	}
	public void setOption3name(String option3name) {
		this.option3name = option3name;
	}
	public File getOption4() {
		return option4;
	}
	public void setOption4(File option4) {
		this.option4 = option4;
	}
	public String getOption4ContentType() {
		return option4ContentType;
	}
	public void setOption4ContentType(String option4ContentType) {
		this.option4ContentType = option4ContentType;
	}
	public String getOption4name() {
		return option4name;
	}
	public void setOption4name(String option4name) {
		this.option4name = option4name;
	}
	public String[] getSection() {
		return section;
	}
	public void setSection(String[] section) {
		this.section = section;
	}
	public String[] getQuestion() {
		return question;
	}
	public void setQuestion(String[] question) {
		this.question = question;
	}
	public String[] getMark() {
		return mark;
	}
	public void setMark(String[] mark) {
		this.mark = mark;
	}
	public CourseDetailsDto getCourseDetailsDto() {
		return courseDetailsDto;
	}
	public void setCourseDetailsDto(CourseDetailsDto courseDetailsDto) {
		this.courseDetailsDto = courseDetailsDto;
	}
	public ExamDetailsDto getExamDetailsDto() {
		return examDetailsDto;
	}
	public void setExamDetailsDto(ExamDetailsDto examDetailsDto) {
		this.examDetailsDto = examDetailsDto;
	}
	public List<ExamDetailsDto> getExamDetailsDtoList() {
		return examDetailsDtoList;
	}
	public void setExamDetailsDtoList(List<ExamDetailsDto> examDetailsDtoList) {
		this.examDetailsDtoList = examDetailsDtoList;
	}
	public List<CourseDetailsDto> getCourseDetailsDtoList() {
		return courseDetailsDtoList;
	}
	public void setCourseDetailsDtoList(List<CourseDetailsDto> courseDetailsDtoList) {
		this.courseDetailsDtoList = courseDetailsDtoList;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	public SectionDetailsDto getSectionDetailsDto() {
		return sectionDetailsDto;
	}
	public void setSectionDetailsDto(SectionDetailsDto sectionDetailsDto) {
		this.sectionDetailsDto = sectionDetailsDto;
	}
	public List<SectionDetailsDto> getSectionDetailsDtoList() {
		return sectionDetailsDtoList;
	}
	public void setSectionDetailsDtoList(
			List<SectionDetailsDto> sectionDetailsDtoList) {
		this.sectionDetailsDtoList = sectionDetailsDtoList;
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
	public String getMyfilename() {
		return myfilename;
	}
	public void setMyfilename(String myfilename) {
		this.myfilename = myfilename;
	}
	public ExaminationBatchMappingDto getExaminationBatchMappingDto() {
		return examinationBatchMappingDto;
	}
	public void setExaminationBatchMappingDto(
			ExaminationBatchMappingDto examinationBatchMappingDto) {
		this.examinationBatchMappingDto = examinationBatchMappingDto;
	}
	public List<ExaminationBatchMappingDto> getExaminationBatchMappingDtoList() {
		return examinationBatchMappingDtoList;
	}
	public void setExaminationBatchMappingDtoList(
			List<ExaminationBatchMappingDto> examinationBatchMappingDtoList) {
		this.examinationBatchMappingDtoList = examinationBatchMappingDtoList;
	}
	public BatchMasterDto getBatchMasterDto() {
		return batchMasterDto;
	}
	public void setBatchMasterDto(BatchMasterDto batchMasterDto) {
		this.batchMasterDto = batchMasterDto;
	}
	public List<BatchMasterDto> getBatchMasterDtoList() {
		return batchMasterDtoList;
	}
	public void setBatchMasterDtoList(List<BatchMasterDto> batchMasterDtoList) {
		this.batchMasterDtoList = batchMasterDtoList;
	}
	public void populateMenu()
	{
		try
		{
			if(request.getParameter("currentMenu")!=null)
			{
				request.getSession().setAttribute("permissionSelect", request.getParameter("permissionSelect"));
				request.getSession().setAttribute("currentMenu", request.getParameter("currentMenu"));
			}
			else if(request.getParameter("permissionSelect")!=null)
			{
				request.getSession().setAttribute("permissionDtoSideMenuList", request.getSession().getAttribute("permissionDtoSideMenuList"));
				request.getSession().setAttribute("permissionSelect", request.getParameter("permissionSelect"));
				request.getSession().setAttribute("currentMenu", request.getSession().getAttribute("currentMenu"));
			}
			else
			{
				request.getSession().setAttribute("permissionDtoSideMenuList", request.getSession().getAttribute("permissionDtoSideMenuList"));
				request.getSession().setAttribute("permissionSelect", request.getSession().getAttribute("permissionSelect"));
				request.getSession().setAttribute("currentMenu", request.getSession().getAttribute("currentMenu"));
			}		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*Method will be changed after payment menthod*/
	public String purchaseExaminationDetailsCnf() throws POLLINGBusinessException {
		
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		try {
			String slno = request.getParameter("slno");
			String decSlno = Encryption.decryptText(slno);			
			
			/*Get StudentMappedExamDetailsDtoList by student id and exam id and checked for validation
			 * if already exist so message and dont allow it to save the exam*/
			
			
			
			
			/*Pending work Date : 15/02/2017*/			
			
			examDetailsDto = this.getExaminationDetailsServices().findExamDetailsById(Integer.parseInt(decSlno));
			StudentMappedExamDetailsDto studentMappedExamDetailsDto = new StudentMappedExamDetailsDto();
			
			studentMappedExamDetailsDto.setAdminDetailDto(adminDetailDto);
			studentMappedExamDetailsDto.setExamDetailsDto(examDetailsDto);
			studentMappedExamDetailsDto.setOdt_entry_date(new Date());
			studentMappedExamDetailsDto.setOnum_is_active(1);
			studentMappedExamDetailsDto.setOnum_exam_activation_flag(1);
			
			this.getExaminationDetailsServices().saveandupdateStudentMappedExamDetailsDto(studentMappedExamDetailsDto);
			studentMappedExamDetailsDto = null;
			
			info = "We have successfully added examination to your examination list. All the Best";	
			
			studentMappedExamDetailsDtoList = this.getExaminationDetailsServices().getStudentMappedExamDetailsDtoListByStudentId(adminDetailDto.getInum_user_id());	
			request.getSession().setAttribute("studentMappedExamDetailsDtoList", studentMappedExamDetailsDtoList);
			
		} catch(Exception ex) {
			ex.printStackTrace();
			flag = "error";
			this.purchaseExaminationDetails();
		}		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String purchaseExaminationDetails() throws POLLINGBusinessException {
		
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		try {
			String slno = request.getParameter("slno");
			System.out.println("SLNO ENC ::"+slno);
			
			String decSlno = Encryption.decryptText(slno);
			System.out.println("SLNO DEC ::"+decSlno);
			
			examDetailsDto = this.getExaminationDetailsServices().findExamDetailsById(Integer.parseInt(decSlno));
			examQuestionDetailsDtoList = this.getExaminationDetailsServices().getExamQuestionDetailsDtoListByExamId(examDetailsDto.getOnum_id());
			
			List<ExamSectionDetailsDto> examSectionDetailsDtoList = new ArrayList<ExamSectionDetailsDto>();
			examSectionDetailsDtoList = this.getExaminationDetailsServices().findExamSectionDetailsByExamId(examDetailsDto.getOnum_id());
			request.getSession().setAttribute("examSectionDetailsDtoList", examSectionDetailsDtoList);
			
			Map<String, List<ExamQuestionDetailsDto>> questionDetailsDtoMap = new HashMap<String, List<ExamQuestionDetailsDto>>();
			if(examQuestionDetailsDtoList != null && examQuestionDetailsDtoList.size()>0) {
				for(ExamQuestionDetailsDto dto : examQuestionDetailsDtoList) {
					if(questionDetailsDtoMap.containsKey(dto.getSectionDetailsDto().getOstr_section_name())) {
						
						Double mark = this.getTotalMark(dto.getSectionDetailsDto(), examDetailsDto);
						dto.setMarkDetails(mark);
						
						List<ExamQuestionDetailsDto> list = new ArrayList<ExamQuestionDetailsDto>();
						list = questionDetailsDtoMap.get(dto.getSectionDetailsDto().getOstr_section_name());
						list.add(dto);
						questionDetailsDtoMap.put(dto.getSectionDetailsDto().getOstr_section_name(), list);
					
					} else {
						Double mark = this.getTotalMark(dto.getSectionDetailsDto(), examDetailsDto);
						dto.setMarkDetails(mark);
						
						List<ExamQuestionDetailsDto> list = new ArrayList<ExamQuestionDetailsDto>();
						list.add(dto);
						questionDetailsDtoMap.put(dto.getSectionDetailsDto().getOstr_section_name(), list);							
					}						
				}					
				request.getSession().setAttribute("studentExamDetails", questionDetailsDtoMap);
				request.getSession().setAttribute("examDetailsDto", examDetailsDto);
				
				Map<Integer, ExamSubCategoryDetailsDto> subCategoryMap = new HashMap<Integer, ExamSubCategoryDetailsDto> ();
				for(ExamSectionDetailsDto exDto : examSectionDetailsDtoList) {
					if(subCategoryMap.containsKey(exDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno())) {
						
						ExamSubCategoryDetailsDto examSubCategoryDetailsDto = new ExamSubCategoryDetailsDto();
						examSubCategoryDetailsDto = subCategoryMap.get(exDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno());
						
						Integer totalMark = exDto.getOnum_total_marks()+examSubCategoryDetailsDto.getOnum_total_marks();
						examSubCategoryDetailsDto.setOnum_total_marks(totalMark);
						
						Integer totalQuestion = exDto.getOnum_total_question()+examSubCategoryDetailsDto.getOnum_total_question();
						examSubCategoryDetailsDto.setOnum_total_question(totalQuestion);
						
						subCategoryMap.put(exDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno(), examSubCategoryDetailsDto);
						
					} else {
						
						ExamSubCategoryDetailsDto examSubCategoryDetailsDto = new ExamSubCategoryDetailsDto();
						
						examSubCategoryDetailsDto.setOnum_id(exDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno());
						examSubCategoryDetailsDto.setSubCategoryDetailsDto(exDto.getSectionDetailsDto().getSubCategoryDetailsDto());
						examSubCategoryDetailsDto.setOnum_total_marks(exDto.getOnum_total_marks());
						examSubCategoryDetailsDto.setOnum_total_question(exDto.getOnum_total_question());
						
						subCategoryMap.put(exDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno(), examSubCategoryDetailsDto);
					   // subCategoryMap.
					}				
				}
				request.getSession().setAttribute("subCategoryMap", subCategoryMap);
				
			} else {
				info = "Due to some technical problem exam is not available please contact with Administrator.";
			}		
		} catch(Exception ex) {
			ex.printStackTrace();
		}		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;		
	}
	
	public String showCreateExamDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
		this.populateMenu();
				
		courseDetailsDtoList = this.getMasterDetailsServices().getCourseDetailsDtoList(adminDetailDto.getInum_user_id());
		//sectionDetailsDtoList = this.getMasterDetailsServices().getSectionDetailsDtoList();
		examImageMasterDtoList = this.getExaminationDetailsServices().getExamImageMasterDtoList();
		categoryDetailsDtoList = this.getMasterDetailsServices().getCategoryDetailsDtoList(adminDetailDto.getInum_user_id());
		//subCategoryDetailsDtoList = this.getMasterDetailsServices().getSubCategoryDetailsDtoList();
		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showManageExamDetailsPage() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
		this.populateMenu();
		
		examDetailsDtoList = this.getExaminationDetailsServices().getExamDetailsDtoList(adminDetailDto);	
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showAllExamPage() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		
		this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
		this.populateMenu();
		
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		studentMappedExamDetailsDtoList = this.getExaminationDetailsServices().getStudentMappedExamDetailsDtoListByStudentId(adminDetailDto.getInum_user_id());	
		request.getSession().setAttribute("studentMappedExamDetailsDtoList", studentMappedExamDetailsDtoList);
		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showExamRequestDetailsPage() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
		this.populateMenu();
		
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		try {
			studentDetailsDtoList = this.getStudentDetailsServices().getStudentDetailsListbyUniqueId(adminDetailDto.getIstr_login_id());
			if(studentDetailsDtoList != null && studentDetailsDtoList.size()>0) {
				
				studentDetailsDto = studentDetailsDtoList.get(0);
				studentExamDetailsDtoList = this.getExaminationDetailsServices().getStudentExamDetailsDtoListByStudentId(studentDetailsDto.getInum_student_id());
				
				examDetailsDtoList = new ArrayList<ExamDetailsDto>();
				if(studentExamDetailsDtoList != null && studentExamDetailsDtoList.size()>0) {
					for(StudentExamDetailsDto dto : studentExamDetailsDtoList) {
						if(dto.getOnum_exam_status().equals(Enums.ExamStatus.PENDING.ordinal()) || dto.getOnum_exam_status().equals(Enums.ExamStatus.REJECT.ordinal()) || dto.getOnum_exam_status().equals(Enums.ExamStatus.REQUESTFOREXAM.ordinal())) {
							examDetailsDtoList.add(dto.getExamDetailsDto());
						}
					}
				}			
				examRequestDetailsDtoList = this.getExaminationDetailsServices().getExamRequestDetailsDtoListByStudentId(studentDetailsDto.getInum_student_id());
			}
			
			if(!(examDetailsDtoList != null && examDetailsDtoList.size()>0)) {
				info = "We didn't find any exam for request.";
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String saveExamRequestDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());	
		
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		studentDetailsDtoList = this.getStudentDetailsServices().getStudentDetailsListbyUniqueId(adminDetailDto.getIstr_login_id());
		if(studentDetailsDtoList != null && studentDetailsDtoList.size()>0) {
			studentDetailsDto = studentDetailsDtoList.get(0);
			
			examRequestDetailsDtoList = this.getExaminationDetailsServices().getExamRequestDetailsDtoListByStudentId(studentDetailsDto.getInum_student_id());
			
			Integer status = 0;
			if(examRequestDetailsDtoList != null && examRequestDetailsDtoList.size()>0) {
				
				for(ExamRequestDetailsDto dto : examRequestDetailsDtoList) {
					
					if(dto.getExamDetailsDto().getOnum_id().equals(examRequestDetailsDto.getExamDetailsDto().getOnum_id())) {
						
						if(dto.getOnum_status().equals(Enums.ExamStatus.PENDING.ordinal())) {
							status = 1;
						}						
					}					
				}				
			}
			
			if(status.equals(0)) {
				examRequestDetailsDto.setStudentDetailsDto(studentDetailsDto);
				examRequestDetailsDto.setOdt_entry_date(new Date());
				examRequestDetailsDto.setOnum_is_active(1);
				
				SimpleDateFormat st = new SimpleDateFormat("dd/mm/yyyy");
				String date = st.format(new Date());
				
				examRequestDetailsDto.setOdt_request_date(date);
				examRequestDetailsDto.setOnum_status(Enums.ExamStatus.PENDING.ordinal());
			
				this.getExaminationDetailsServices().saveandupdateExamRequestDetailsDto(examRequestDetailsDto);
				
				studentExamDetailsDtoList = this.getExaminationDetailsServices().getStudentExamDetailsDtoListByStudentId(examRequestDetailsDto.getExamDetailsDto().getOnum_id(), examRequestDetailsDto.getStudentDetailsDto().getInum_student_id());
				if(studentExamDetailsDtoList != null && studentExamDetailsDtoList.size()>0) {
						studentExamDetailsDto = studentExamDetailsDtoList.get(0);
						
						studentExamDetailsDto.setOnum_exam_status(Enums.ExamStatus.PENDING.ordinal());
						this.getExaminationDetailsServices().saveandupdateStudentExamDetailsDto(studentExamDetailsDto);
						studentExamDetailsDto = null;
				}
				
				examRequestDetailsDto = null;
				this.showExamRequestDetailsPage();
				info = "Exam Request Details Saved Successfully";
			} else {
				this.showExamRequestDetailsPage();
				info = "Your exam request for this exam is already pending.. Please contact Administrator";
			}			
		}		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String examDetailPage() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		String sl_no = request.getParameter("sl_no");
		Integer slNo = Integer.parseInt(sl_no);
		
		examDetailsDto = this.getExaminationDetailsServices().findExamDetailsById(slNo);
		request.getSession().setAttribute("examDetailsDto",examDetailsDto);
		examSectionDetailsDtoList = this.getExaminationDetailsServices().findExamSectionDetailsByExamId(examDetailsDto.getOnum_id());
		
		request.getSession().setAttribute("sl_no", examDetailsDto.getOnum_id());
		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showManageExamRequestDetailsPage() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
		this.populateMenu();
		
		examRequestDetailsDtoList = this.getExaminationDetailsServices().getExamRequestDetailsDtoList(adminDetailDto);
		header_info = "All Request";
		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showManageExamPendingRequest() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
		this.populateMenu();
		
		examRequestDetailsDtoList = this.getExaminationDetailsServices().getExamRequestDetailsDtoListByStatus(Enums.ExamStatus.PENDING.ordinal(), adminDetailDto);
		header_info = "Pending Request";
		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showManageExamRequestDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		try {
			this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
			this.populateMenu();
			
			Integer slNo = Integer.parseInt(request.getParameter("sl_no"));
			System.out.println("SL NO is ::"+slNo);
			examRequestDetailsDto = this.getExaminationDetailsServices().findExamRequestDetailsById(slNo);
			request.getSession().setAttribute("examRequestDetailsDto",examRequestDetailsDto);
			studentExamDetailsDtoList = this.getExaminationDetailsServices().getStudentExamDetailsDtoListByStudentId(examRequestDetailsDto.getExamDetailsDto().getOnum_id(), examRequestDetailsDto.getStudentDetailsDto().getInum_student_id());
			if(studentExamDetailsDtoList != null && studentExamDetailsDtoList.size()>0) {
				studentExamDetailsDto = studentExamDetailsDtoList.get(0);			
			}
			request.getSession().setAttribute("studentExamDetailsDto",studentExamDetailsDto);
		} catch(Exception ex) {
			ex.printStackTrace();		
		}	
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;		
	}
	
	public String deleteExamRequestDetail() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());	
		
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		
		Integer slNo = Integer.parseInt(request.getParameter("slno"));
		System.out.println("SL NO is ::"+slNo);
		examRequestDetailsDto = this.getExaminationDetailsServices().findExamRequestDetailsById(slNo);
		examRequestDetailsDto.setOnum_is_active(0);
		
		this.getExaminationDetailsServices().saveandupdateExamRequestDetailsDto(examRequestDetailsDto);
		examRequestDetailsDto = null;
		
		this.showManageExamRequestDetailsPage();
		info = "Exam request details has been deleted successfully";
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String studentDeleteExamRequestDetail() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());	
		
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		
		Integer slNo = Integer.parseInt(request.getParameter("slno"));
		System.out.println("SL NO is ::"+slNo);
		examRequestDetailsDto = this.getExaminationDetailsServices().findExamRequestDetailsById(slNo);
		examRequestDetailsDto.setOnum_is_active(0);
		
		this.getExaminationDetailsServices().saveandupdateExamRequestDetailsDto(examRequestDetailsDto);
		examRequestDetailsDto = null;
		
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		this.showExamRequestDetailsPage();
		
		info = "Exam request details has been deleted successfully";
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String manageExamRequestStatus() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());	
		
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		
		String status = request.getParameter("status");
		examRequestDetailsDto = (ExamRequestDetailsDto) request.getSession().getAttribute("examRequestDetailsDto");
		studentExamDetailsDto = (StudentExamDetailsDto) request.getSession().getAttribute("studentExamDetailsDto");
		
		String remark = request.getParameter("istr_remark");
		System.out.println("Remark ::::"+remark);
		
		examRequestDetailsDto.setOstr_admin_remark(remark);
		if(status.equals("1")) {
			examRequestDetailsDto.setOnum_status(Enums.ExamStatus.APPROVED.ordinal());
			studentExamDetailsDto.setOnum_exam_status(Enums.ExamStatus.APPROVED.ordinal());
			info = "Exam request details has been approved successfully";			
		} else {
			examRequestDetailsDto.setOnum_status(Enums.ExamStatus.REJECT.ordinal());
			studentExamDetailsDto.setOnum_exam_status(Enums.ExamStatus.REJECT.ordinal());
			info = "Exam request details has been rejected successfully";			
		}
		
		this.getExaminationDetailsServices().saveandupdateStudentExamDetailsDto(studentExamDetailsDto);
		this.getExaminationDetailsServices().saveandupdateExamRequestDetailsDto(examRequestDetailsDto);
		examRequestDetailsDto = null;
				
		this.showManageExamRequestDetailsPage();
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showManageExamApprovedRequest() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
		this.populateMenu();
		
		examRequestDetailsDtoList = this.getExaminationDetailsServices().getExamRequestDetailsDtoListByStatus(Enums.ExamStatus.APPROVED.ordinal(), adminDetailDto);
		header_info = "Approved Request";
		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showManageExamRejectRequest() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
		this.populateMenu();
		
		examRequestDetailsDtoList = this.getExaminationDetailsServices().getExamRequestDetailsDtoListByStatus(Enums.ExamStatus.REJECT.ordinal(), adminDetailDto);
		header_info = "Reject Request";
		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String deleteExamDetail() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());	
		
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		String sl_no = request.getParameter("sl_no");
		Integer slNo = Integer.parseInt(sl_no);
		
		examDetailsDto = this.getExaminationDetailsServices().findExamDetailsById(slNo);
		examDetailsDto.setOnum_is_active(0);
		
		this.getExaminationDetailsServices().saveandupdateExamDetailsDto(examDetailsDto);
		examDetailsDtoList = this.getExaminationDetailsServices().getExamDetailsDtoList(adminDetailDto);
		info = "Exam Details has been deleted successfully";
		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String changeExamStatus() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());	
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			String sl_no = request.getParameter("sl_no");
			Integer slNo = Integer.parseInt(sl_no);
			
			examDetailsDto = this.getExaminationDetailsServices().findExamDetailsById(slNo);
			Integer status = examDetailsDto.getOnum_exam_activation_flag();
			
			if(status.equals(0)) {
				examDetailsDto.setOnum_exam_activation_flag(1);
				studentMappedExamDetailsDtoList = this.getExaminationDetailsServices().getStudentMappedExamDetailsDtoListByExamId(examDetailsDto.getOnum_id());
				
				if(studentMappedExamDetailsDtoList != null && studentMappedExamDetailsDtoList.size()>0) {
					for(StudentMappedExamDetailsDto dto : studentMappedExamDetailsDtoList) {
						dto.setOnum_exam_activation_flag(1);
						this.getExaminationDetailsServices().saveandupdateStudentMappedExamDetailsDto(dto);
					}
				}				
			} else {
				examDetailsDto.setOnum_exam_activation_flag(0);
				studentMappedExamDetailsDtoList = this.getExaminationDetailsServices().getStudentMappedExamDetailsDtoListByExamId(examDetailsDto.getOnum_id());
				
				if(studentMappedExamDetailsDtoList != null && studentMappedExamDetailsDtoList.size()>0) {
					for(StudentMappedExamDetailsDto dto : studentMappedExamDetailsDtoList) {
						dto.setOnum_exam_activation_flag(0);
						this.getExaminationDetailsServices().saveandupdateStudentMappedExamDetailsDto(dto);
					}
				}	
			}
			
			this.getExaminationDetailsServices().saveandupdateExamDetailsDto(examDetailsDto);
			examDetailsDtoList = this.getExaminationDetailsServices().getExamDetailsDtoList(adminDetailDto);
			
			info = "Exam Status Change Successfully";
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String saveExamSectionDetails() throws POLLINGBusinessException {
	   String flag = CommonConstants.FAILURE_ERROR;
	   if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
	   }
	   AdminDetailDto adminDetailDto = new AdminDetailDto();
	   adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
	   try{
		
		   	examDetailsDto.setOnum_is_active(1);
			examDetailsDto.setOdt_entry_date(new Date());
			examDetailsDto.setOnum_exam_activation_flag(1);
			examDetailsDto.setAdminDetailDto(adminDetailDto);
			
			this.getExaminationDetailsServices().saveandupdateExamDetailsDto(examDetailsDto);
			
			ExamSectionDetailsDto examSectionDetailsDto;
			for (int i = 0; i < section.length; i++) {
				
				examSectionDetailsDto = new ExamSectionDetailsDto();
				examSectionDetailsDto.setExamDetailsDto(examDetailsDto);
				examSectionDetailsDto.setOdt_entry_date(new Date());
				
				sectionDetailsDto = new SectionDetailsDto();
				sectionDetailsDto = this.getMasterDetailsServices().findSectionDetailsById(Integer.parseInt(section[i]));
				
				examSectionDetailsDto.setSectionDetailsDto(sectionDetailsDto);
				examSectionDetailsDto.setOnum_total_question(Integer.parseInt(question[i]));
				examSectionDetailsDto.setOnum_remaining_question(Integer.parseInt(question[i]));
				examSectionDetailsDto.setOnum_total_marks(Integer.parseInt(mark[i]));
				examSectionDetailsDto.setOnum_is_active(1);
				
				this.getExaminationDetailsServices().saveandupdateExamSectionDetailsDto(examSectionDetailsDto);			
			}
			
			/*Process start to generate Question Set*/
			List<ExamSectionDetailsDto> examSectionDetailsDtoList = new ArrayList<ExamSectionDetailsDto>();
			examSectionDetailsDtoList = this.getExaminationDetailsServices().findExamSectionDetailsByExamId(examDetailsDto.getOnum_id());
			
			int question_status = 0;
			questionDetailsDtoList = new ArrayList<QuestionDetailsDto>();
			
			List<ExamQuestionDetailsDto> examQuestionDetailsDtoList = new ArrayList<ExamQuestionDetailsDto>();
			
			if(examSectionDetailsDtoList != null && examSectionDetailsDtoList.size()>0) {
				for(ExamSectionDetailsDto examSecDto : examSectionDetailsDtoList) {
					
					question_status = 0;
					System.out.println("No of Question :"+examSecDto.getOnum_total_question());
					
					List<QuestionDetailsDto> tempQuestionDetailsDtoList = new ArrayList<QuestionDetailsDto>(); 
					
					while(tempQuestionDetailsDtoList.size() != examSecDto.getOnum_total_question()) {
						
						questionDetailsDtoList = this.getExaminationDetailsServices().getQuestionDetailsDtoListBySectionId(examSecDto.getSectionDetailsDto().getOnum_slno(), question_status, adminDetailDto);
						if(questionDetailsDtoList != null && questionDetailsDtoList.size()>0) {
							for(QuestionDetailsDto dto : questionDetailsDtoList) {
								if(tempQuestionDetailsDtoList.size() != examSecDto.getOnum_total_question()) {
									tempQuestionDetailsDtoList.add(dto);
								}							
							}						
						}						
						question_status++;
					}
					
					if(tempQuestionDetailsDtoList != null && tempQuestionDetailsDtoList.size()>0) {
						for(QuestionDetailsDto tempDto : tempQuestionDetailsDtoList) {
							
							ExamQuestionDetailsDto examQuestionDetailsDto = new ExamQuestionDetailsDto();
							
							examQuestionDetailsDto.setQuestionDetailsDto(tempDto);
							examQuestionDetailsDto.setSectionDetailsDto(examSecDto.getSectionDetailsDto());
							examQuestionDetailsDto.setExamDetailsDto(examDetailsDto);
							examQuestionDetailsDto.setOnum_is_active(1);
							examQuestionDetailsDto.setOdt_entry_date(new Date());
							
							examQuestionDetailsDtoList.add(examQuestionDetailsDto);
						}					
					}
				}		
			}		
			
			System.out.println("Size Of Final List is :::"+examQuestionDetailsDtoList.size());
			if(examQuestionDetailsDtoList != null && examQuestionDetailsDtoList.size()>0) {
				for(ExamQuestionDetailsDto tempDto : examQuestionDetailsDtoList) {
					
					Integer q_status = tempDto.getQuestionDetailsDto().getOnum_question_status();
					QuestionDetailsDto detailsDto = tempDto.getQuestionDetailsDto();
					q_status++;
					detailsDto.setOnum_question_status(q_status);
					
					this.getExaminationDetailsServices().saveandupdateQuestionDetailsDto(detailsDto);
					
					Double mark = this.getTotalMark(tempDto.getSectionDetailsDto(), tempDto.getExamDetailsDto());
					tempDto.setMarkDetails(mark);
					
					this.getExaminationDetailsServices().saveandupdateExamQuestionDetailsDto(tempDto);				
				}					
			}
			
			
			info = "Exam saved successfully";
		   
	   } catch(Exception e) {
	   	  e.printStackTrace();   
	   }
	   examDetailsDto=null;
	   this.showCreateExamDetails();
	   return flag;
	}
	
	public String showCreateQuestionDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		try {
			this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
			this.populateMenu();
			
			categoryDetailsDtoList = this.getMasterDetailsServices().getCategoryDetailsDtoList(adminDetailDto.getInum_user_id());
			if(questionDetailsDto != null) {
				if(questionDetailsDto.getOnum_id() != null) {
					if(questionDetailsDto.getCategoryDetailsDto().getOnum_slno() != null) {
						subCategoryDetailsDtoList = this.getMasterDetailsServices().getSubCategoryDetailsDtoListByCategoryId(questionDetailsDto.getSectionDetailsDto().getCategoryDetailsDto().getOnum_slno());
						sectionDetailsDtoList = this.getMasterDetailsServices().getSectionDetailsDtoListBySubCategoryId(questionDetailsDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno());
					}
				}
			}
			if(questionDetailsDtoList != null && questionDetailsDtoList.size()>0) {
				subCategoryDetailsDtoList = this.getMasterDetailsServices().getSubCategoryDetailsDtoListByCategoryId(questionDetailsDtoList.get(0).getCategoryDetailsDto().getOnum_slno());
				sectionDetailsDtoList = this.getMasterDetailsServices().getSectionDetailsDtoListBySubCategoryId(questionDetailsDtoList.get(0).getSubCategoryDetailsDto().getOnum_slno());
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String saveUploadQuestionDetailsDto() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());	
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		List<QuestionDetailsDto> quDetailsDtoList = new ArrayList<QuestionDetailsDto>(); 
		questionDetailsDtoList =  new ArrayList<QuestionDetailsDto>();
		List<ErrorDetailsDto> errorDetailsDtoList = new ArrayList<ErrorDetailsDto>(); 
		try {
			FileInputStream fs = new FileInputStream(getUploaded_excel());
			Workbook wb = Workbook.getWorkbook(fs);
			
			//To get the access to the sheet
			Sheet sh = wb.getSheet(0);
			
			//To get the number number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			
			//To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			
			if(questionDetailsDto.getSectionDetailsDto().getOnum_slno() != null) {
				sectionDetailsDto = this.getMasterDetailsServices().findSectionDetailsById(questionDetailsDto.getSectionDetailsDto().getOnum_slno());
				
				QuestionDetailsDto queDetailsDto = null;
				ErrorDetailsDto errorDetailsDto = null;
				for(int row = 1; row < totalNoOfRows; row++) {
					
					queDetailsDto = new QuestionDetailsDto();		
								
					queDetailsDto.setAdminDetailDto(adminDetailDto);
					queDetailsDto.setCategoryDetailsDto(sectionDetailsDto.getCategoryDetailsDto());
					queDetailsDto.setSubCategoryDetailsDto(sectionDetailsDto.getSubCategoryDetailsDto());
					queDetailsDto.setSectionDetailsDto(sectionDetailsDto);
					queDetailsDto.setOnum_is_active(1);
					queDetailsDto.setOdt_entry_date(new Date());
					queDetailsDto.setOnum_question_status(0);
							
					queDetailsDto.setOstr_question(sh.getCell(1, row).getContents());
					queDetailsDto.setOstr_option1(sh.getCell(2, row).getContents());
					queDetailsDto.setOstr_option2(sh.getCell(3, row).getContents());
					queDetailsDto.setOstr_option3(sh.getCell(4, row).getContents());
					queDetailsDto.setOstr_option4(sh.getCell(5, row).getContents());
					queDetailsDto.setOstr_option5(sh.getCell(6, row).getContents());
					queDetailsDto.setOstr_correct_option(sh.getCell(7, row).getContents());
					queDetailsDto.setOstr_solution(sh.getCell(8, row).getContents());
							
					quDetailsDtoList.add(queDetailsDto);							
					
				}
							
				questionDetailsDtoList =  new ArrayList<QuestionDetailsDto>();
				List<QuestionDetailsDto> duplicateQuestionDetailsDtoList =  new ArrayList<QuestionDetailsDto>();
				int count = 0;
				Integer i = 1;
				if(quDetailsDtoList != null && quDetailsDtoList.size()>0) {
					for(QuestionDetailsDto dto : quDetailsDtoList) {
						if(dto.getOstr_question().equals("") || dto.getOstr_correct_option().equals("") || dto.getOstr_option1().equals("") || dto.getOstr_option2().equals("") || dto.getOstr_option3().equals("") || dto.getOstr_option4().equals("")) {
							errorDetailsDto = new ErrorDetailsDto();
							errorDetailsDto.setSlno(i.toString());
							errorDetailsDto.setError_message("Invalid Data");
							errorDetailsDtoList.add(errorDetailsDto);
						} else {
							duplicateQuestionDetailsDtoList = this.getExaminationDetailsServices().getDuplicateQuestionDetailsDtoList(dto.getOstr_question(), sectionDetailsDto.getOnum_slno(), adminDetailDto);
							if(!(duplicateQuestionDetailsDtoList != null && duplicateQuestionDetailsDtoList.size()>0)) {
							
								this.getExaminationDetailsServices().saveandupdateQuestionDetailsDto(dto);
								questionDetailsDtoList.add(dto);
								count++;
							} else {
								errorDetailsDto = new ErrorDetailsDto();
								errorDetailsDto.setSlno(i.toString());
								errorDetailsDto.setError_message("Duplicate Data");
								errorDetailsDtoList.add(errorDetailsDto);
							}
						}
						i++;
					}
					Integer remaining_question = sectionDetailsDto.getOnum_remaining_question();
					remaining_question = (remaining_question)+count;
								
					sectionDetailsDto.setOnum_remaining_question(remaining_question);
					this.getMasterDetailsServices().updateSectionDetailsDto(sectionDetailsDto);
					
					request.getSession().setAttribute("questionDetailsDtoList", questionDetailsDtoList);
					request.getSession().setAttribute("errorDetailsDtoList", errorDetailsDtoList);
				}				
				System.out.println("Size of Question list ::"+questionDetailsDtoList.size());
				System.out.println("Size of Error list ::"+errorDetailsDtoList.size());
			}
			this.showCreateQuestionDetails();
			questionDetailsDto = new QuestionDetailsDto();
			if(questionDetailsDtoList != null && questionDetailsDtoList.size()>0) {
				info = "Question details has been inserted successfully";
			} else {
				info = "Somthing went wrong please check below error message";
			}
			flag = CommonConstants.SUCCESS_FLAG;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String saveQuestionDetailsDto() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());	
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			if(!questionDetailsDto.getOstr_question().equals("")) {				
				questionDetailsDtoList = this.getExaminationDetailsServices().getDuplicateQuestionDetailsDtoList(questionDetailsDto.getOstr_question(), questionDetailsDto.getSectionDetailsDto().getOnum_slno(), adminDetailDto);
			}
			
			if(!(questionDetailsDtoList != null && questionDetailsDtoList.size()>0)) {
				// For Question Image
				if(getObl_question() != null) {
			    	
					System.out.println("========"+getObl_questionContentType()+"===="+getObl_questionname());
	    			BufferedImage imgFile = getImageAndReduceQuestionSize(getObl_question());
		    		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		    		ImageIO.write(imgFile, "jpg", bas);
		    		byte[] fileContents = bas.toByteArray();
		    		
		    		BASE64Encoder encodeData = new BASE64Encoder();
		    		String fileData = encodeData.encode(fileContents);
	    			
		    		questionDetailsDto.setObl_question(fileData);
		    	}
				// For Option 1
				if(getOption1() != null) {
			    	
	    			BufferedImage imgFile = getImageAndReduceAnswerSize(getOption1());
		    		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		    		ImageIO.write(imgFile, "jpg", bas);
		    		byte[] fileContents = bas.toByteArray();
		    		
		    		BASE64Encoder encodeData = new BASE64Encoder();
		    		String fileData = encodeData.encode(fileContents);
	    			
		    		questionDetailsDto.setObl_option1(fileData);
		    	}
				// For Option 2
				if(getOption2() != null) {
			    	
	    			BufferedImage imgFile = getImageAndReduceAnswerSize(getOption2());
		    		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		    		ImageIO.write(imgFile, "jpg", bas);
		    		byte[] fileContents = bas.toByteArray();
		    		
		    		BASE64Encoder encodeData = new BASE64Encoder();
		    		String fileData = encodeData.encode(fileContents);
	    			
		    		questionDetailsDto.setObl_option2(fileData);
		    	}
				// For Option 3
				if(getOption3() != null) {
			    	
	    			BufferedImage imgFile = getImageAndReduceAnswerSize(getOption3());
		    		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		    		ImageIO.write(imgFile, "jpg", bas);
		    		byte[] fileContents = bas.toByteArray();
		    		
		    		BASE64Encoder encodeData = new BASE64Encoder();
		    		String fileData = encodeData.encode(fileContents);
	    			
		    		questionDetailsDto.setObl_option3(fileData);
		    	}
				// For Option 4
				if(getOption4() != null) {
			    	
	    			BufferedImage imgFile = getImageAndReduceAnswerSize(getOption4());
		    		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		    		ImageIO.write(imgFile, "jpg", bas);
		    		byte[] fileContents = bas.toByteArray();
		    		
		    		BASE64Encoder encodeData = new BASE64Encoder();
		    		String fileData = encodeData.encode(fileContents);
	    			
		    		questionDetailsDto.setObl_option4(fileData);
		    	}
				// For Option 5
				if(getOption5() != null) {
			    	
	    			BufferedImage imgFile = getImageAndReduceAnswerSize(getOption5());
		    		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		    		ImageIO.write(imgFile, "jpg", bas);
		    		byte[] fileContents = bas.toByteArray();
		    		
		    		BASE64Encoder encodeData = new BASE64Encoder();
		    		String fileData = encodeData.encode(fileContents);
	    			
		    		questionDetailsDto.setObl_option5(fileData);
		    	}
				
				// For Question Image
				if(getObl_solution() != null) {
						    	
				    BufferedImage imgFile = getImageAndReduceQuestionSize(getObl_solution());
					ByteArrayOutputStream bas = new ByteArrayOutputStream();
					ImageIO.write(imgFile, "jpg", bas);
					byte[] fileContents = bas.toByteArray();
					    		
					BASE64Encoder encodeData = new BASE64Encoder();
					String fileData = encodeData.encode(fileContents);
				    			
					questionDetailsDto.setObl_solution(fileData);
				}			
				
				questionDetailsDto.setOnum_is_active(1);
				questionDetailsDto.setOdt_entry_date(new Date());
				questionDetailsDto.setOnum_question_status(0);
				questionDetailsDto.setAdminDetailDto(adminDetailDto);
				
				this.getExaminationDetailsServices().saveandupdateQuestionDetailsDto(questionDetailsDto);
				
				sectionDetailsDto = new SectionDetailsDto();
				sectionDetailsDto = this.getMasterDetailsServices().findSectionDetailsById(questionDetailsDto.getSectionDetailsDto().getOnum_slno());
				
				Integer remaining_question = sectionDetailsDto.getOnum_remaining_question();
				remaining_question = (remaining_question)+1;
							
				sectionDetailsDto.setOnum_remaining_question(remaining_question);
				this.getMasterDetailsServices().updateSectionDetailsDto(sectionDetailsDto);
				
				questionDetailsDto = new QuestionDetailsDto();
				info = "Question details has been inserted successfully";
				this.showCreateQuestionDetails();
				flag = CommonConstants.SUCCESS_FLAG;
			} else {
				questionDetailsDto = new QuestionDetailsDto();
				info = "Question already exist in database.";
				this.showCreateQuestionDetails();
				flag = CommonConstants.SUCCESS_FLAG;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String searchQuestionByCretaria() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();		
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());	
		
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		String question = request.getParameter("question");
		System.out.println("question ::::"+question);
		
		String section_id = request.getParameter("section_id");
		System.out.println("section_id ::::"+section_id);		
		Integer sectionId = Integer.parseInt(section_id);
		
		questionDetailsDtoList = this.getExaminationDetailsServices().getQuestionDetailsDtoListByCretaria(question, sectionId, adminDetailDto);
		
		this.showCreateQuestionDetails();
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String deleteQuestionDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();		
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());	
		
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		
		String sl_no = request.getParameter("sl_no");
		System.out.println("question ::::"+sl_no);
		
		Integer slNo = Integer.parseInt(sl_no);
		
		questionDetailsDto = this.getExaminationDetailsServices().findQuestionDetailsDtoById(slNo);
		questionDetailsDto.setOnum_is_active(0);
		questionDetailsDto.setOdt_entry_date(new Date());
		
		this.getExaminationDetailsServices().saveandupdateQuestionDetailsDto(questionDetailsDto);
		info = "Question details has been deleted successfully";
		
		questionDetailsDto = null;
		this.showCreateQuestionDetails();
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
	}
	
	public String editQuestionDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();	
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());	
		
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		
		String sl_no = request.getParameter("sl_no");
		System.out.println("question ::::"+sl_no);
		
		Integer slNo = Integer.parseInt(sl_no);
		questionDetailsDto = this.getExaminationDetailsServices().findQuestionDetailsDtoById(slNo);
		
		categoryDetailsDtoList = this.getMasterDetailsServices().getCategoryDetailsDtoList();
		if(questionDetailsDto != null) {
			if(questionDetailsDto.getCategoryDetailsDto().getOnum_slno() != null) {
				subCategoryDetailsDtoList = this.getMasterDetailsServices().getSubCategoryDetailsDtoListByCategoryId(questionDetailsDto.getSectionDetailsDto().getCategoryDetailsDto().getOnum_slno());
				sectionDetailsDtoList = this.getMasterDetailsServices().getSectionDetailsDtoListBySubCategoryId(questionDetailsDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno());
				
				System.out.println("============="+subCategoryDetailsDtoList.size());
			}
		}
		request.getSession().setAttribute("questionDetailsDto", questionDetailsDto);
		
		this.showCreateQuestionDetails();
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
	}
	
	public String saveEditQuestionDetailsDto() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();	
		
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			QuestionDetailsDto questionDto = new QuestionDetailsDto();
			questionDto = this.getExaminationDetailsServices().findQuestionDetailsDtoById(questionDetailsDto.getOnum_id());
			
			// For Question Image
			if(getObl_question() != null) {
				
				System.out.println("========"+getObl_questionContentType()+"===="+getObl_questionname());
    			BufferedImage imgFile = getImageAndReduceQuestionSize(getObl_question());
	    		ByteArrayOutputStream bas = new ByteArrayOutputStream();
	    		ImageIO.write(imgFile, "jpg", bas);
	    		byte[] fileContents = bas.toByteArray();
	    		
	    		BASE64Encoder encodeData = new BASE64Encoder();
	    		String fileData = encodeData.encode(fileContents);
    			
	    		questionDetailsDto.setObl_question(fileData);
	    	} else {
	    		String question_img_status = request.getParameter("question_img_status");
	    		if(question_img_status.equals("1")) {
	    			questionDetailsDto.setObl_question(questionDto.getObl_question());
	    		}
	    	}
			// For Option 1
			if(getOption1() != null) {
		    	
    			BufferedImage imgFile = getImageAndReduceAnswerSize(getOption1());
	    		ByteArrayOutputStream bas = new ByteArrayOutputStream();
	    		ImageIO.write(imgFile, "jpg", bas);
	    		byte[] fileContents = bas.toByteArray();
	    		
	    		BASE64Encoder encodeData = new BASE64Encoder();
	    		String fileData = encodeData.encode(fileContents);
    			
	    		questionDetailsDto.setObl_option1(fileData);
	    	} else {
	    		String option1_img_status = request.getParameter("option1_img_status");
	    		if(option1_img_status.equals("1")) {
	    			questionDetailsDto.setObl_option1(questionDto.getObl_option1());
	    		}
	    	}
			// For Option 2
			if(getOption2() != null) {
		    	
    			BufferedImage imgFile = getImageAndReduceAnswerSize(getOption2());
	    		ByteArrayOutputStream bas = new ByteArrayOutputStream();
	    		ImageIO.write(imgFile, "jpg", bas);
	    		byte[] fileContents = bas.toByteArray();
	    		
	    		BASE64Encoder encodeData = new BASE64Encoder();
	    		String fileData = encodeData.encode(fileContents);
    			
	    		questionDetailsDto.setObl_option2(fileData);
	    	} else {
	    		String option2_img_status = request.getParameter("option2_img_status");
	    		if(option2_img_status.equals("1")) {
	    			questionDetailsDto.setObl_option2(questionDto.getObl_option2());
	    		}
	    	}
			// For Option 3
			if(getOption3() != null) {
		    	
    			BufferedImage imgFile = getImageAndReduceAnswerSize(getOption3());
	    		ByteArrayOutputStream bas = new ByteArrayOutputStream();
	    		ImageIO.write(imgFile, "jpg", bas);
	    		byte[] fileContents = bas.toByteArray();
	    		
	    		BASE64Encoder encodeData = new BASE64Encoder();
	    		String fileData = encodeData.encode(fileContents);
    			
	    		questionDetailsDto.setObl_option3(fileData);
	    	} else {
	    		String option3_img_status = request.getParameter("option3_img_status");
	    		if(option3_img_status.equals("1")) {
	    			questionDetailsDto.setObl_option3(questionDto.getObl_option3());
	    		}
	    	}
			// For Option 4
			if(getOption4() != null) {
		    	
    			BufferedImage imgFile = getImageAndReduceAnswerSize(getOption4());
	    		ByteArrayOutputStream bas = new ByteArrayOutputStream();
	    		ImageIO.write(imgFile, "jpg", bas);
	    		byte[] fileContents = bas.toByteArray();
	    		
	    		BASE64Encoder encodeData = new BASE64Encoder();
	    		String fileData = encodeData.encode(fileContents);
    			
	    		questionDetailsDto.setObl_option4(fileData);
	    	} else {
	    		String option4_img_status = request.getParameter("option4_img_status");
	    		if(option4_img_status.equals("1")) {
	    			questionDetailsDto.setObl_option4(questionDto.getObl_option4());
	    		}
	    	}
			// For Option 5
			if(getOption5() != null) {
				    	
				BufferedImage imgFile = getImageAndReduceAnswerSize(getOption5());
				ByteArrayOutputStream bas = new ByteArrayOutputStream();
				ImageIO.write(imgFile, "jpg", bas);
				byte[] fileContents = bas.toByteArray();
				    		
				BASE64Encoder encodeData = new BASE64Encoder();
				String fileData = encodeData.encode(fileContents);
			    			
				questionDetailsDto.setObl_option5(fileData);
			} else {
				String option5_img_status = request.getParameter("option5_img_status");
				if(option5_img_status.equals("1")) {
					questionDetailsDto.setObl_option5(questionDto.getObl_option5());
				}
			}
			
			// For Solution Image
			if(getObl_solution() != null) {
					    	
			    BufferedImage imgFile = getImageAndReduceQuestionSize(getObl_solution());
				ByteArrayOutputStream bas = new ByteArrayOutputStream();
				ImageIO.write(imgFile, "jpg", bas);
				byte[] fileContents = bas.toByteArray();
				    		
			  	BASE64Encoder encodeData = new BASE64Encoder();
			  	String fileData = encodeData.encode(fileContents);
			    			
			   	questionDetailsDto.setObl_solution(fileData);
			} else {
				String solution_img_status = request.getParameter("solution_img_status");
				if(solution_img_status.equals("1")) {
					questionDetailsDto.setObl_solution(questionDto.getObl_solution());
				}
			}
			
			questionDetailsDto.setOnum_is_active(1);
			questionDetailsDto.setOdt_entry_date(new Date());
			questionDetailsDto.setOnum_question_status(0);
			questionDetailsDto.setAdminDetailDto(adminDetailDto);
			
			this.getExaminationDetailsServices().saveandupdateQuestionDetailsDto(questionDetailsDto);
			
			sectionDetailsDto = new SectionDetailsDto();
			sectionDetailsDto = this.getMasterDetailsServices().findSectionDetailsById(questionDetailsDto.getSectionDetailsDto().getOnum_slno());
			
			Integer remaining_question = sectionDetailsDto.getOnum_remaining_question();
			remaining_question = (remaining_question)+1;
			
			sectionDetailsDto.setOnum_remaining_question(remaining_question);
			this.getMasterDetailsServices().updateSectionDetailsDto(sectionDetailsDto);
			
			questionDetailsDto = new QuestionDetailsDto();
			info = "Question details has been updated successfully";
			this.showCreateQuestionDetails();
			flag = CommonConstants.SUCCESS_FLAG;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}

	public void ajaxDetails() {
		  
		StringBuffer pageRequest = new StringBuffer();
		if(request.getSession().getAttribute("adminDetailDto") != null) {
			
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			try {
				
				String flag = request.getParameter("flag");
				System.out.println("flag id ::"+flag);
				if(flag.equals("EXAM_SECTION_DETAILS")) {
				String examSection_id=request.getParameter("examSection_id");
					System.out.println("the section id is:::"+examSection_id);
					
					sectionDetailsDto = this.getMasterDetailsServices().findSectionDetailsById(Integer.parseInt(examSection_id));
				    pageRequest.append(sectionDetailsDto.getOnum_total_question());
				    pageRequest.append("@@@");
				    pageRequest.append(sectionDetailsDto.getOnum_remaining_question());
				    
				    
				    System.out.println("Output:::::: :"+pageRequest);
					   
					response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					try {
						response.getWriter().write(pageRequest.toString());
					} catch(IOException e) {
						e.printStackTrace();
					} 	
				
				} if(flag.equals("EXAM_SECTION_DETAILS_BY_ID")) {
					
					String examSection_id=request.getParameter("examSection_id");
					System.out.println("the section id is:::"+examSection_id);
					
					questionDetailsDtoList = new ArrayList<QuestionDetailsDto>();
					questionDetailsDtoList = this.getExaminationDetailsServices().getQuestionDetailsDtoListBySecId(Integer.parseInt(examSection_id), adminDetailDto);
					
					pageRequest.append(questionDetailsDtoList.size());
				    			    
				    System.out.println("Output:::::: :"+pageRequest);
					
				    response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					try {
						response.getWriter().write(pageRequest.toString());
					} catch(IOException e) {
						e.printStackTrace();
					} 	
				} else if(flag.equals("EXAM_DETAILS")) {
					
					String exam_id=request.getParameter("exam_id");
					System.out.println("the section id is:::"+exam_id);
					exam_id = Encryption.decryptText(exam_id);
					
					studentDetailsDtoList = this.getStudentDetailsServices().getStudentDetailsListbyUniqueId(adminDetailDto.getIstr_login_id());
					if(studentDetailsDtoList != null && studentDetailsDtoList.size()>0) {
						studentDetailsDto = studentDetailsDtoList.get(0);
						
						examDetailsDto = this.getExaminationDetailsServices().findExamDetailsById(Integer.parseInt(exam_id));
						studentExamDetailsDtoList = this.getExaminationDetailsServices().getStudentExamDetailsDtoListByStudentId(Integer.parseInt(exam_id), studentDetailsDto.getInum_student_id());
					}
					pageRequest.append("<div class='dms_admin_cover'>");
					
					pageRequest.append("<table width='80%'>");
					pageRequest.append("<tr><td width='20%' style='font-size: 12px; font-weight: bold;'> Exam Name :</td><td width='30%' style='font-size: 12px; font-weight: bold;'>"+examDetailsDto.getOstr_exam_name()+"</td>");
					pageRequest.append("<td width='20%' style='font-size: 12px; font-weight: bold;'>Course Name :</td><td width='30%' style='font-size: 12px; font-weight: bold;'>"+examDetailsDto.getCourseDetailsDto().getOstr_course_name()+"</td></tr>");
					
					pageRequest.append("<tr><td width='20%' style='font-size: 12px; font-weight: bold;'> Date :</td><td width='30%' style='font-size: 12px; font-weight: bold;'>"+examDetailsDto.getOdt_exam_date()+"</td>");
					pageRequest.append("<td width='20%' style='font-size: 12px; font-weight: bold;'>Time Duration :</td><td width='30%' style='font-size: 12px; font-weight: bold;'>"+examDetailsDto.getOdt_exam_time()+"</td></tr>");
									
					if(studentExamDetailsDtoList != null && studentExamDetailsDtoList.size()>0) {
				    	studentExamDetailsDto = studentExamDetailsDtoList.get(0);		    	
				    	pageRequest.append("<tr><td width='20%' style='font-size: 12px; font-weight: bold;'>Attempt :</td><td style='font-size: 12px; font-weight: bold;'>"+studentExamDetailsDto.getOnum_no_of_time_attempt()+"</td>");
						
				    	if (studentExamDetailsDto.getOnum_exam_status().equals(Enums.ExamStatus.APPROVED.ordinal())) {
				    	
				    		pageRequest.append("<td style='font-size: 12px; font-weight: bold;'>Status :</td><td style='font-size: 12px; font-weight: bold;'>Approved</td></tr>");
				    		
				    		pageRequest.append("<table width='80%'>");
							pageRequest.append("<tr>");
							pageRequest.append("<td>");
							pageRequest.append("<center>");
							pageRequest.append("<input type='button' value='Start Exam' style='width: 130px; height: 35px;'  onclick='showExamDetailsPage(\""+Encryption.encryptText(examDetailsDto.getOnum_id().toString())+"\");' class='btn'/>&nbsp;&nbsp;&nbsp;");
							pageRequest.append("<input type='button' value='Close' style='width: 130px; height: 35px;' onclick='closeExam();' class='btn'/>");
							pageRequest.append("</center>");
							pageRequest.append("</td>");
							pageRequest.append("</tr>");
							pageRequest.append("</table>");
				    	
				    	} else if(studentExamDetailsDto.getOnum_exam_status().equals(Enums.ExamStatus.REJECT.ordinal())) {
				    		
				    		pageRequest.append("<td style='font-size: 12px; font-weight: bold;'>Status :</td><td style='font-size: 12px; font-weight: bold;'>Reject</td></tr>");
				    		
				    	} else if(studentExamDetailsDto.getOnum_exam_status().equals(Enums.ExamStatus.PENDING.ordinal())) {
				    		
				    		pageRequest.append("<td style='font-size: 12px; font-weight: bold;'>Status :</td><td style='font-size: 12px; font-weight: bold;'>Pending</td></tr>");
				    		
				    	} else if(studentExamDetailsDto.getOnum_exam_status().equals(Enums.ExamStatus.NEWENTRY.ordinal())) {
				    		
				    		pageRequest.append("<td style='font-size: 12px; font-weight: bold;'>Status :</td><td style='font-size: 12px; font-weight: bold;'>Pending</td></tr>");
				    		
				    	} else if(studentExamDetailsDto.getOnum_exam_status().equals(Enums.ExamStatus.REQUESTFOREXAM.ordinal())) {
				    		
				    		pageRequest.append("<td style='font-size: 12px; font-weight: bold;'>Status :</td><td style='font-size: 12px; font-weight: bold;'>Request for exam</td></tr>");
				    		
				    	}
				    	pageRequest.append("</table>");
				    	pageRequest.append("</centre>");
				    	
				    	pageRequest.append("</br>");
				    	pageRequest.append("</br>");
				    	
					} else {
						
						pageRequest.append("<tr><td width='20%' style='font-size: 12px; font-weight: bold;'>Attempt :</td><td style='font-size: 12px; font-weight: bold;'>0</td>");
						pageRequest.append("<td style='font-size: 12px; font-weight: bold;'>Status :</td><td style='font-size: 12px; font-weight: bold;'>Approved</td></tr>");
						pageRequest.append("</table>");
						
						pageRequest.append("</br>");
						pageRequest.append("</br>");
						
						pageRequest.append("<table width='80%'>");
						pageRequest.append("<tr>");
						pageRequest.append("<td>");
						pageRequest.append("<center>");
						pageRequest.append("<input type='button' value='Start Exam' style='width: 130px; height: 35px;'  onclick='showExamDetailsPage(\""+Encryption.encryptText(examDetailsDto.getOnum_id().toString())+"\");' class='btn'/>&nbsp;&nbsp;&nbsp;");
						pageRequest.append("<input type='button' value='Close' style='width: 130px; height: 35px;' onclick='closeExam();' class='btn'/>");
						pageRequest.append("</center>");
						pageRequest.append("</td>");
						pageRequest.append("</tr>");
						pageRequest.append("</table>");
					}
					
					
					pageRequest.append("<div class='clear'></div>");
					
					pageRequest.append("</div>");
					System.out.println("Output:::::: :"+pageRequest);
									
				    response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					try {
						response.getWriter().write(pageRequest.toString());
					} catch(IOException e) {
						e.printStackTrace();
					} 	
				} else if(flag.equals("STUDENT_EXAM_DETAILS")) {
					
					String exam_id = request.getParameter("exam_id");
					System.out.println("The Section Id Is:::"+exam_id);
					exam_id = Encryption.decryptText(exam_id);
					
					examDetailsDto = this.getExaminationDetailsServices().findExamDetailsById(Integer.parseInt(exam_id));
					examQuestionDetailsDtoList = this.getExaminationDetailsServices().getExamQuestionDetailsDtoListByExamId(examDetailsDto.getOnum_id());
					
					Map<String, List<ExamQuestionDetailsDto>> questionDetailsDtoMap = new HashMap<String, List<ExamQuestionDetailsDto>>();
					if(examQuestionDetailsDtoList != null && examQuestionDetailsDtoList.size()>0) {
						for(ExamQuestionDetailsDto dto : examQuestionDetailsDtoList) {
							
							
							if(questionDetailsDtoMap.containsKey(dto.getSectionDetailsDto().getOstr_section_name())) {
								
								Double mark = this.getTotalMark(dto.getSectionDetailsDto(), examDetailsDto);
								dto.setMarkDetails(mark);
								
								List<ExamQuestionDetailsDto> list = new ArrayList<ExamQuestionDetailsDto>();
								list = questionDetailsDtoMap.get(dto.getSectionDetailsDto().getOstr_section_name());
								list.add(dto);
								questionDetailsDtoMap.put(dto.getSectionDetailsDto().getOstr_section_name(), list);
							
							} else {
								Double mark = this.getTotalMark(dto.getSectionDetailsDto(), examDetailsDto);
								dto.setMarkDetails(mark);
								
								List<ExamQuestionDetailsDto> list = new ArrayList<ExamQuestionDetailsDto>();
								list.add(dto);
								questionDetailsDtoMap.put(dto.getSectionDetailsDto().getOstr_section_name(), list);							
							}						
						}					
						request.getSession().setAttribute("studentExamDetails", questionDetailsDtoMap);
						request.getSession().setAttribute("examDetailsDto", examDetailsDto);
						pageRequest.append("true");
					} else {
						pageRequest.append("false");
					}
					
					System.out.println("====== Map Size ====="+questionDetailsDtoMap.size());
					System.out.println("Output:::::: :"+pageRequest);
					
				    response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					try {
						response.getWriter().write(pageRequest.toString());
					} catch(IOException e) {
						e.printStackTrace();
					} 	
				} else if(flag.equals("COURSE_EXAM_DETAILS")) {
					
					String course_id = request.getParameter("course_id");
					System.out.println("the course id is:::"+course_id);
					
					if(adminDetailDto != null) {
						examDetailsDtoList = new ArrayList<ExamDetailsDto>();
						examDetailsDtoList = this.getExaminationDetailsServices().getExamDetailsDtoListByCourseId(Integer.parseInt(course_id));
						if(examDetailsDtoList != null && examDetailsDtoList.size()>0) {
							
							examDetailsDto = new ExamDetailsDto();
							examDetailsDto = examDetailsDtoList.get(0);
							
							pageRequest.append("<table width='100%' border='0'>");
							pageRequest.append("<tr>");
							pageRequest.append("<td style='width: 10%;'><img src='images/backbutton.png' style='width: 80px; height: 35px; cursor: pointer;' onclick='goback();'/></td>");
							pageRequest.append("<td style='width: 80%;'>");
							pageRequest.append("<div align='center'><h1>"+examDetailsDto.getCourseDetailsDto().getOstr_course_name()+"</h1></div>");
							pageRequest.append("</td><td style='width: 10%'></td>");
							pageRequest.append("</tr>");
							pageRequest.append("</table>");
							
							//pageRequest.append("<marquee><p style='color: maroon;'>"+examDetailsDto.getCourseDetailsDto().getOstr_course_details()+"</p></marquee>");
							
							/**
							 * Get Student Details List from Table and checked already mapped 
							 * examination with student and make examination button inactive
							 **/
							List<StudentMappedExamDetailsDto> studentMappedExamDetailsDtoList = new ArrayList<StudentMappedExamDetailsDto>();
							studentMappedExamDetailsDtoList = this.getExaminationDetailsServices().getStudentMappedExamDetailsDtoListByStudentId(adminDetailDto.getInum_user_id());
							
							for(ExamDetailsDto dto : examDetailsDtoList) {
								pageRequest.append("<div class='col-4' style='margin-top: -20px;'>");
								pageRequest.append("<div class='aside'>");
									if(dto.getObl_exam_pic() != null) {
										pageRequest.append("<img id='blah' src='"+dto.getObl_exam_pic()+"' style='width : 100%; height : 100%;'/>"); /* Put Image Here */
									} else {
										pageRequest.append("<img id='blah' src='image/xamdesk_default_exam.jpg' style='width : 100%; height : 100%;''/>"); /* Put Image Here */
									}
									pageRequest.append("<p>"+dto.getOstr_exam_name()+"</p>");
									pageRequest.append("<div class='col-5'>");
									pageRequest.append("<div class='buy_section'>");
									int i = 0;
									if(studentMappedExamDetailsDtoList != null && studentMappedExamDetailsDtoList.size()>0) {
										for(StudentMappedExamDetailsDto stdDto : studentMappedExamDetailsDtoList) {
											if(stdDto.getExamDetailsDto().getOnum_id().equals(dto.getOnum_id())) {
												i = 1;
											}										
										}
									}
									
									if(i == 0) {
										if(dto.getOstr_price().equals("0")) {
											pageRequest.append("<p style='color: #000000;'><b><img src='img/rupee.png' style='height: 12px;'> "+dto.getOstr_price()+" &nbsp;&nbsp;</b><input type='submit' name='Try' value='Try' style='width: 60px; height: 30px; margin-top: 3px; margin-bottom: 3px;' class='btn' onclick='submitpage(\""+Encryption.encryptText(dto.getOnum_id().toString())+"\");'></p>");
										} else {
											pageRequest.append("<p style='color: #000000;'><b><img src='img/rupee.png' style='height: 12px;'> "+dto.getOstr_price()+" &nbsp;&nbsp;</b><input type='submit' name='Buy' value='Buy' style='width: 60px; height: 30px; margin-top: 3px; margin-bottom: 3px;' class='btn' onclick='submitpage(\""+Encryption.encryptText(dto.getOnum_id().toString())+"\");'></p>");	
										}
									} else {
										if(dto.getOstr_price().equals("0")) {
											pageRequest.append("<p style='color: #000000;'><b><img src='img/rupee.png' style='height: 12px;'><strike> "+dto.getOstr_price()+" </strike>&nbsp;&nbsp;</b><input type='submit' disabled='disabled' name='Try' value='Try' style='width: 60px; height: 30px; margin-top: 3px; margin-bottom: 3px;' onclick='submitpage(\""+Encryption.encryptText(dto.getOnum_id().toString())+"\");'></p>");
										} else {
											pageRequest.append("<p style='color: #000000;'><b><img src='img/rupee.png' style='height: 12px;'><strike> "+dto.getOstr_price()+" </strike>&nbsp;&nbsp;</b><input type='submit' disabled='disabled' name='Buy' value='Buy' style='width: 60px; height: 30px; margin-top: 3px; margin-bottom: 3px;' onclick='submitpage(\""+Encryption.encryptText(dto.getOnum_id().toString())+"\");'></p>");
										}
									}
									pageRequest.append("</div>");
									pageRequest.append("</div>");
									pageRequest.append("</div>");
									pageRequest.append("</div>");
							}
						} else {
							pageRequest.append("<table width='100%' border='0'>");
							pageRequest.append("<tr>");
							pageRequest.append("<td style='width: 10%;'><img src='images/backbutton.png' style='width: 80px; height: 35px; cursor: pointer;' onclick='goback();'/></td>");
							pageRequest.append("<td style='width: 80%;'>");
							pageRequest.append("<div align='center'><div align='center'><b>We didn't find any examination for selected course.</b></div>");
							pageRequest.append("</td><td style='width: 10%'></td>");
							pageRequest.append("</tr>");
							pageRequest.append("</table>");
							
							pageRequest.append("<br/><br/>");
						}
					}				
					System.out.println("Output:::::: :"+pageRequest);
									
				    response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					try {
						response.getWriter().write(pageRequest.toString());
					} catch(IOException e) {
						e.printStackTrace();
					} 	
				} else if(flag.equals("SUB_CATEGORY_DETAILS_BY_CATEGORY")) {
					
					String onum_category_slno = request.getParameter("onum_category_slno");
					System.out.println("the category id is:::"+onum_category_slno);
					Integer categoryId = Integer.parseInt(onum_category_slno);
					
					if(adminDetailDto != null) {
						List<SubCategoryDetailsDto> subCategoryDetailsDtoList = new ArrayList<SubCategoryDetailsDto>();
						subCategoryDetailsDtoList = this.getMasterDetailsServices().getSubCategoryDetailsDtoListByCategoryId(categoryId);
						pageRequest.append("<div class='styled-select2'>");
						pageRequest.append("<select id='onum_sub_category_slno' name='sectionDetailsDto.subCategoryDetailsDto.onum_slno' tabindex='1'>");
						pageRequest.append("<option value='0'>Select</option>");
						if(subCategoryDetailsDtoList != null && subCategoryDetailsDtoList.size()>0) {
							for(SubCategoryDetailsDto dto : subCategoryDetailsDtoList) {
								pageRequest.append("<option value='"+dto.getOnum_slno()+"'>"+dto.getOstr_sub_category_name()+"</option>");									
							}
						} 
						pageRequest.append("</select>");
						pageRequest.append("</div>");					
					}				
					System.out.println("Output:::::: :"+pageRequest);
									
				    response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					try {
						response.getWriter().write(pageRequest.toString());
					} catch(IOException e) {
						e.printStackTrace();
					} 	
				} else if(flag.equals("QUESTION_SUB_CATEGORY_DETAILS")) {
					
					String onum_category_slno = request.getParameter("onum_category_slno");
					System.out.println("the category id is:::"+onum_category_slno);
					Integer categoryId = Integer.parseInt(onum_category_slno);
					
					if(adminDetailDto != null) {
						List<SubCategoryDetailsDto> subCategoryDetailsDtoList = new ArrayList<SubCategoryDetailsDto>();
						subCategoryDetailsDtoList = this.getMasterDetailsServices().getSubCategoryDetailsDtoListByCategoryId(categoryId);
						pageRequest.append("<div class='styled-select2'>");
						pageRequest.append("<select id='onum_sub_category_slno' name='questionDetailsDto.subCategoryDetailsDto.onum_slno' onChange='showSectionDetailsList();' tabindex='1'>");
						pageRequest.append("<option value='0'>Select</option>");
						if(subCategoryDetailsDtoList != null && subCategoryDetailsDtoList.size()>0) {
							for(SubCategoryDetailsDto dto : subCategoryDetailsDtoList) {
								pageRequest.append("<option value='"+dto.getOnum_slno()+"'>"+dto.getOstr_sub_category_name()+"</option>");									
							}
						} 
						pageRequest.append("</select>");
						pageRequest.append("</div>");					
					}				
					System.out.println("Output:::::: :"+pageRequest);
									
				    response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					try {
						response.getWriter().write(pageRequest.toString());
					} catch(IOException e) {
						e.printStackTrace();
					} 	
				} else if(flag.equals("QUESTION_SECTION_DETAILS")) {
					
					String onum_sub_category_slno = request.getParameter("onum_sub_category_slno");
					System.out.println("the category id is:::"+onum_sub_category_slno);
					Integer subCategoryId = Integer.parseInt(onum_sub_category_slno);
					
					if(adminDetailDto != null) {
						sectionDetailsDtoList = this.getMasterDetailsServices().getSectionDetailsDtoListBySubCategoryId(subCategoryId);
						pageRequest.append("<div class='styled-select2'>");
						pageRequest.append("<select id='onum_slno' name='questionDetailsDto.sectionDetailsDto.onum_slno' tabindex='1' onChange='showSectionDetails();'>");
						pageRequest.append("<option value='0'>Select</option>");
						if(sectionDetailsDtoList != null && sectionDetailsDtoList.size()>0) {
							for(SectionDetailsDto dto : sectionDetailsDtoList) {
								pageRequest.append("<option value='"+dto.getOnum_slno()+"'>"+dto.getOstr_section_name()+"</option>");									
							}
						} 
						pageRequest.append("</select>");
						pageRequest.append("</div>");					
					}				
					System.out.println("Output:::::: :"+pageRequest);
									
				    response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					try {
						response.getWriter().write(pageRequest.toString());
					} catch(IOException e) {
						e.printStackTrace();
					} 	
				} else if(flag.equals("SEARCH_SECTION_DETAILS")) {
					
					String onum_sub_category_slno = request.getParameter("onum_sub_category_slno");
					System.out.println("the category id is:::"+onum_sub_category_slno);
					Integer subCategoryId = Integer.parseInt(onum_sub_category_slno);
					
					if(adminDetailDto != null) {
						sectionDetailsDtoList = this.getMasterDetailsServices().getSectionDetailsDtoListBySubCategoryId(subCategoryId);
						pageRequest.append("<div class='styled-select2'>");
						pageRequest.append("<select id='onum_slno' name='section_id' tabindex='1'>");
						pageRequest.append("<option value='0'>Select</option>");
						if(sectionDetailsDtoList != null && sectionDetailsDtoList.size()>0) {
							for(SectionDetailsDto dto : sectionDetailsDtoList) {
								pageRequest.append("<option value='"+dto.getOnum_slno()+"'>"+dto.getOstr_section_name()+"</option>");									
							}
						} 
						pageRequest.append("</select>");
						pageRequest.append("</div>");					
					}				
					System.out.println("Output:::::: :"+pageRequest);
									
				    response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					try {
						response.getWriter().write(pageRequest.toString());
					} catch(IOException e) {
						e.printStackTrace();
					} 	
				}  else if(flag.equals("CREATE_EXAM_SUB_CATEGORY_DETAILS")) {
					
					String onum_category_slno = request.getParameter("onum_category_slno");
					String id = request.getParameter("id");
					System.out.println("the category id is:::"+onum_category_slno);
					Integer categoryId = Integer.parseInt(onum_category_slno);
					
					if(adminDetailDto != null) {
						List<SubCategoryDetailsDto> subCategoryDetailsDtoList = new ArrayList<SubCategoryDetailsDto>();
						subCategoryDetailsDtoList = this.getMasterDetailsServices().getSubCategoryDetailsDtoListByCategoryId(categoryId);
						pageRequest.append("<div class='styled-select2'>");
						pageRequest.append("<select id='onum_sub_category_slno"+id+"' name='sub_category' onChange='showSectionDetailsList("+id+");' tabindex='1'>");
						pageRequest.append("<option value='0'>Select</option>");
						if(subCategoryDetailsDtoList != null && subCategoryDetailsDtoList.size()>0) {
							for(SubCategoryDetailsDto dto : subCategoryDetailsDtoList) {
								pageRequest.append("<option value='"+dto.getOnum_slno()+"'>"+dto.getOstr_sub_category_name()+"</option>");									
							}
						} 
						pageRequest.append("</select>");
						pageRequest.append("</div>");					
					}				
					System.out.println("Output:::::: :"+pageRequest);
									
				    response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					try {
						response.getWriter().write(pageRequest.toString());
					} catch(IOException e) {
						e.printStackTrace();
					} 	
				} else if(flag.equals("CREATE_EXAM_QUESTION_SECTION_DETAILS")) {
					
					String onum_sub_category_slno = request.getParameter("onum_sub_category_slno");
					String id = request.getParameter("id");
					System.out.println("the category id is:::"+onum_sub_category_slno);
					Integer subCategoryId = Integer.parseInt(onum_sub_category_slno);
					
					if(adminDetailDto != null) {
						sectionDetailsDtoList = this.getMasterDetailsServices().getSectionDetailsDtoListBySubCategoryId(subCategoryId);
						pageRequest.append("<div class='styled-select2'>");
						pageRequest.append("<select id='section"+id+"' name='section' onChange='showSectionDetails("+id+");' tabindex='1'>");
						pageRequest.append("<option value='0'>Select</option>");
						if(sectionDetailsDtoList != null && sectionDetailsDtoList.size()>0) {
							for(SectionDetailsDto dto : sectionDetailsDtoList) {
								pageRequest.append("<option value='"+dto.getOnum_slno()+"'>"+dto.getOstr_section_name()+"</option>");									
							}
						} 
						pageRequest.append("</select>");
						pageRequest.append("</div>");					
					}				
					System.out.println("Output:::::: :"+pageRequest);
									
				    response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					try {
						response.getWriter().write(pageRequest.toString());
					} catch(IOException e) {
						e.printStackTrace();
					} 	
				} else if(flag.equals("REGISTER_EXAM_DETAILS")) { 				
					
					String exam_id = request.getParameter("exam_details");
					System.out.println("The Section Id Is:::"+exam_id);
					exam_id = Encryption.decryptText(exam_id);
					
					examDetailsDto = this.getExaminationDetailsServices().findExamDetailsById(Integer.parseInt(exam_id));
					
					
					MappedExamDetailsDto detailsDto = new MappedExamDetailsDto();
					detailsDto.setAdminDetailDto(adminDetailDto);
					detailsDto.setExamDetailsDto(examDetailsDto);
					detailsDto.setOdt_entry_date(new Date());
					detailsDto.setOnum_exam_activation_flag(1);
					detailsDto.setOnum_is_active(1);
					
					this.getExaminationDetailsServices().saveandupdateMappedExamDetailsDto(detailsDto);
					
					StudentMappedExamDetailsDto stddetailsDto = new StudentMappedExamDetailsDto();
					stddetailsDto.setAdminDetailDto(adminDetailDto);
					stddetailsDto.setExamDetailsDto(examDetailsDto);
					stddetailsDto.setOdt_entry_date(new Date());
					stddetailsDto.setOnum_exam_activation_flag(0);
					stddetailsDto.setOnum_is_active(0);
					
					this.getExaminationDetailsServices().saveandupdateStudentMappedExamDetailsDto(stddetailsDto);
					detailsDto = null;
					stddetailsDto = null;
					request.getSession().setAttribute("register_button_status", "1");
					
					pageRequest.append("true");					
					System.out.println("Output:::::: :"+pageRequest);
								
					response.setContentType("text/html");
					response.setHeader("Cache-Control", "no-cache");
					try {
						response.getWriter().write(pageRequest.toString());
					} catch(IOException e) {
						e.printStackTrace();
					} 	
				}
		   } catch(Exception ex){
		       ex.printStackTrace();
		   }
		}
	}
	

	public String saveUserResultDetails() throws POLLINGBusinessException {
		
		String flag = CommonConstants.FAILURE_ERROR;
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());	
		
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}	
			
			//Login to execute save
			Map<String, List<ExamQuestionDetailsDto>> questionDetailsDtoMap = new HashMap<String, List<ExamQuestionDetailsDto>>();
		    questionDetailsDtoMap = (Map<String, List<ExamQuestionDetailsDto>>) request.getSession().getAttribute("studentExamDetails");
		    ExamDetailsDto examDetailsDto = (ExamDetailsDto) request.getSession().getAttribute("examDetailsDto");	
		    AdminDetailDto adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		    
		    StudentDetailsDto studentDetailsDto = new StudentDetailsDto();
		    studentDetailsDto = this.getStudentDetailsServices().findStudentDetailsById(adminDetailDto.getInum_student_employee_id());
		    
		    if(studentDetailsDto != null) {
		    
			    List<ExamQuestionDetailsDto> dtoList = new ArrayList<ExamQuestionDetailsDto>();
			    	
			    ResultDetailsDto resultDetailsDto = new ResultDetailsDto();
			    List<ResultDescriptionDto> resultDescriptionDtoList = new ArrayList<ResultDescriptionDto>(); 
			    
			    Integer keyId = 1;
			    int j = 1;
			    
			    Integer wright = 0;
			    Integer wrong = 0;
			    Integer left = 0;
			    Double total_obtain_mark = 0.0;
			    Integer rank = 0;
			    Double total_negative_mark = 0.0;
			    Double total_mark = 0.0;
			    
			    Double examNegMark = Double.parseDouble(examDetailsDto.getOstr_negative_mark());			    
			    
			    if(questionDetailsDtoMap != null && questionDetailsDtoMap.size()>0) {
			    	for(String key : questionDetailsDtoMap.keySet()) {
			    		
			    		dtoList = questionDetailsDtoMap.get(key);
			    		if(dtoList != null && dtoList.size()>0) {
			    			for(int i = 0; i<dtoList.size(); i++) {
			    				
			    				QuestionDetailsDto questionDto = new QuestionDetailsDto();
			    				ExamQuestionDetailsDto questionDetailsDto = new ExamQuestionDetailsDto();
			    				
			    				questionDetailsDto = dtoList.get(i);
			    				questionDto = questionDetailsDto.getQuestionDetailsDto();
			    				
			    				ResultDescriptionDto resultDescriptionDto = new ResultDescriptionDto();
			    				
			    				resultDescriptionDto.setExamQuestionDetailsDto(questionDetailsDto);
			    				resultDescriptionDto.setOdt_entry_date(new Date());
			    				resultDescriptionDto.setOnum_correct_option(Integer.parseInt(questionDto.getOstr_correct_option()));
			    				resultDescriptionDto.setOnum_is_active(1);
			    				
			    				String selected_option = request.getParameter("answer"+keyId+""+i);
			    				
			    				if(selected_option != null) {
			    					resultDescriptionDto.setOnum_selected_option(Integer.parseInt(selected_option));	
			    				}
			    				
			    				if(selected_option == null) {
			    					left++;
			    				} else if(selected_option.equals(questionDto.getOstr_correct_option())) {
			    					wright++;
			    					total_obtain_mark = (total_obtain_mark)+(questionDetailsDto.getMarkDetails());
			    				} else {
			    					Double tempMark = 0.0;
			    					tempMark = (examNegMark/100)*(questionDetailsDto.getMarkDetails());
			    					total_obtain_mark = (total_obtain_mark)-(tempMark);
			    					total_negative_mark = (total_negative_mark)+(tempMark);
			    					wrong++;
			    				}	
			    				total_mark = (total_mark)+(questionDetailsDto.getMarkDetails());
			    				resultDescriptionDtoList.add(resultDescriptionDto);
			    				
			    				questionDto = null;
			    				questionDetailsDto = null;
			    				
			    				j++;
			    			}
			    		}
			    		keyId++;
			    	}
			    	
			    	resultDetailsDto.setExamDetailsDto(examDetailsDto);
			    	resultDetailsDto.setStudentDetailsDto(studentDetailsDto);
			    	resultDetailsDto.setOdt_entry_date(new Date());
			    	resultDetailsDto.setOnum_is_active(1);
			    	resultDetailsDto.setOnum_left(left);
			    	resultDetailsDto.setOnum_wright(wright);
			    	resultDetailsDto.setOnum_wrong(wrong);
			    	resultDetailsDto.setOnum_rank(rank);
			    	resultDetailsDto.setOdec_total_obtain_mark(total_obtain_mark);
			    	resultDetailsDto.setOdec_total_mark(total_mark);
			    	resultDetailsDto.setOdec_total_negative_mark(total_negative_mark);
			    	resultDetailsDto.setOnum_total_question((wright)+(wrong)+(left));
			    	
			    	// To calculate accuracy
			    	Double accuracy = 0.0;
			    	accuracy = (total_obtain_mark/total_mark)*100;
			    	
			    	accuracy = Double.parseDouble(new DecimalFormat("##.##").format(accuracy));
			    	resultDetailsDto.setOdec_accuracy(accuracy);
			    	
			    	SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
			    	String date = sf.format(new Date());
			    	
			    	SimpleDateFormat tm = new SimpleDateFormat("hh:mm a");
			    	String time = tm.format(new Date());
			    	
			    	resultDetailsDto.setOstr_date(date);
			    	resultDetailsDto.setOstr_time(time);
			    	
			    	// Save Result Details
			    	this.getExaminationDetailsServices().saveandupdateResultDetailsDto(resultDetailsDto);
			    	
			    	if(resultDescriptionDtoList != null && resultDescriptionDtoList.size()>0) {
			    		for(ResultDescriptionDto dto : resultDescriptionDtoList) {
			    			dto.setResultDetailsDto(resultDetailsDto);
			    			this.getExaminationDetailsServices().saveandupdateResultDescriptionDto(dto);
			    		}
			    	}		    	
			    }
			    
			    resultDescriptionDtoList = null;
			    resultDetailsDto = null;
			    studentDetailsDto = null;
			    questionDetailsDtoMap = null;
			    examDetailsDto = null;
			    adminDetailDto = null;
			    
		    } else {
		    	// Please contact administrator 
		    	// StudentDetailsDto is null
		    }
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		request.getSession().setAttribute("studentExamDetails", null);
		request.getSession().setAttribute("examDetailsDto", null);
		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showGenerateScoreCard() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
			this.populateMenu();
			
			resultDetailsDtoList = this.getExaminationDetailsServices().getResultDetailsDtoList(adminDetailDto);
			
			Set<ExamDetailsDto> examDtoList = new HashSet<ExamDetailsDto>();
			if(resultDetailsDtoList != null && resultDetailsDtoList.size()>0) {
				for(ResultDetailsDto dto : resultDetailsDtoList) {
					examDtoList.add(dto.getExamDetailsDto());
				}
			}
			
			examDetailsDtoList = new ArrayList<ExamDetailsDto>();
			if(examDtoList != null && examDtoList.size()>0) {
				for(ExamDetailsDto dto : examDtoList) {
					examDetailsDtoList.add(dto);
				}
			}
			resultDetailsDtoList = null;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;		
	}
	
	public String generateScoreCardDetails() throws POLLINGBusinessException {
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());	
		
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		try {
			
			String exam_id = request.getParameter("ostr_exam_name");
			String month = request.getParameter("onum_month");
			
			if(exam_id == null) {
				
				info = "Please select Exam";
				this.showGenerateScoreCard();
				return flag;
				
			} else if(month.equals("0")) {
				
				info = "Please select Month";
				this.showGenerateScoreCard();
				return flag;
				
			} else {
				
				Integer examId = Integer.parseInt(exam_id);
				Integer monthDetails = Integer.parseInt(month);
				
				Calendar now = Calendar.getInstance();
				Integer mon = now.get(Calendar.MONTH) + 1;
				
				System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
				System.out.println("Current Month ::::"+mon);
				System.out.println("Future Date ::::"+monthDetails);
				
				if(mon <= monthDetails) {
					info = "You are only eligible to generate the score card for past month.";
					this.showGenerateScoreCard();
					return flag;
				}	
				
				List<ScoreGenerationDto> scoreGenerationDtoList = new ArrayList<ScoreGenerationDto>();
				scoreGenerationDtoList = this.getExaminationDetailsServices().getScoreGenerationDtoListByExamIdAndMonth(examId, monthDetails);
				if(scoreGenerationDtoList != null && scoreGenerationDtoList.size()>0) {
					info = "Score already generated for this Exam and Month";
					this.showGenerateScoreCard();
					return flag;	
				}
				resultDetailsDtoList = this.getExaminationDetailsServices().getResultDetailsDtoListByExamAndMonth(examId, monthDetails, adminDetailDto);
				if(resultDetailsDtoList != null && resultDetailsDtoList.size()>0) {
					
					Integer rank = 1;
					for(ResultDetailsDto dto : resultDetailsDtoList) {						
						dto.setOnum_rank(rank);
						examDetailsDto = dto.getExamDetailsDto();
						this.getExaminationDetailsServices().saveandupdateResultDetailsDto(dto);
						rank++;						
					}
					this.showGenerateScoreCard();
					ScoreGenerationDto scoreGenerationDto = new ScoreGenerationDto();
					
					scoreGenerationDto.setExamDetailsDto(examDetailsDto);
					scoreGenerationDto.setOnum_is_active(1);
					scoreGenerationDto.setOdt_entry_date(new Date());
					scoreGenerationDto.setOnum_month(monthDetails);
					
					this.getExaminationDetailsServices().saveandupdateScoreGenerationDto(scoreGenerationDto);
					
					this.setExam_name(examDetailsDto.getOstr_exam_name());
					this.setMonth_name(this.theMonth(monthDetails));
					
					this.showGenerateScoreCard();
					resultDetailsDtoList = this.getExaminationDetailsServices().getResultDetailsDtoListByExamAndMonth(examId, monthDetails, adminDetailDto);
					info = "All student score generated for the selected exam and month";
					flag = CommonConstants.SUCCESS_FLAG;
				} else {
					info = "We didn�t find any record for this exam and month.";
					this.showGenerateScoreCard();
					return flag;
				}
			}		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;		
	}
	
	public String showAdminResultDetailsPage() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
			this.populateMenu();
			
			resultDetailsDtoList = this.getExaminationDetailsServices().getResultDetailsDtoList(adminDetailDto);
			request.getSession().setAttribute("adminStatus","myadmin");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showStudentResultDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
		this.populateMenu();
		
		AdminDetailDto adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		studentDetailsDto = this.getStudentDetailsServices().findStudentDetailsById(adminDetailDto.getInum_student_employee_id());
		resultDetailsDtoList = this.getExaminationDetailsServices().getResultDetailsDtoListByStudentId(studentDetailsDto.getInum_student_id());
		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	
	public String showAdminjResultDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
		this.populateMenu();
		
		String status = (String) request.getSession().getAttribute("adminStatus");
		resultDetailsDtoList = this.getExaminationDetailsServices().getResultDetailsDtoList(adminDetailDto);
			
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showStudentResultDetailsPage() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		try {
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
		this.populateMenu();
	
		Integer student_result_id = Integer.parseInt(request.getParameter("student_id"));
		if(student_result_id != null) {
			resultDetailsDto = this.getExaminationDetailsServices().getResultDetailsDtoById(student_result_id);
			
			/*Logic to calculate result subject analysis*/
			List<ResultDescriptionDto> resultDescriptionDtoList = new ArrayList<ResultDescriptionDto>();
			resultDescriptionDtoList = this.getExaminationDetailsServices().getResultDescriptionDtoByResultDetailsId(resultDetailsDto.getOnum_result_details_id());
			Map<Integer, ResultReviewSubjectDto> subjectMapDetails = new HashMap<Integer, ResultReviewSubjectDto>();
			List<ResultReviewSubjectDto> reviewSubjectDtoList = new ArrayList<ResultReviewSubjectDto>();
			
			if(resultDescriptionDtoList != null && resultDescriptionDtoList.size()>0) {
				for(ResultDescriptionDto dto : resultDescriptionDtoList) {
					if(subjectMapDetails.containsKey(dto.getExamQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno())) {
						ResultReviewSubjectDto resultReviewSubjectDto = new ResultReviewSubjectDto();
						
						resultReviewSubjectDto = subjectMapDetails.get(dto.getExamQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno());
						if(dto.getOnum_selected_option() == null) {
							//Unattempted
							Integer total = resultReviewSubjectDto.getTotal_left(); 
							total = total+1;
							resultReviewSubjectDto.setTotal_left(total);
						} else if(dto.getOnum_selected_option().equals(dto.getOnum_correct_option())) {
							//correct
							Integer total = resultReviewSubjectDto.getTotal_right(); 
							total = total+1;
							resultReviewSubjectDto.setTotal_right(total);
						} else {							
							//wrong
							Integer total = resultReviewSubjectDto.getTotal_wrong(); 
							total = total+1;
							resultReviewSubjectDto.setTotal_wrong(total);
						}
						Integer total_question = resultReviewSubjectDto.getTotal_question();
						total_question = total_question+1;
						resultReviewSubjectDto.setTotal_question(total_question);
						subjectMapDetails.put(dto.getExamQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno(), resultReviewSubjectDto);
					} else {
						ResultReviewSubjectDto resultReviewSubjectDto = new ResultReviewSubjectDto();
						resultReviewSubjectDto.setSectionDetailsDto(dto.getExamQuestionDetailsDto().getSectionDetailsDto());
						if(dto.getOnum_selected_option() == null) {
							//Unattempted
							resultReviewSubjectDto.setTotal_left(1);
							resultReviewSubjectDto.setTotal_right(0);
							resultReviewSubjectDto.setTotal_wrong(0);
						} else if(dto.getOnum_selected_option().equals(dto.getOnum_correct_option())) {
							//correct
							resultReviewSubjectDto.setTotal_right(1);
							resultReviewSubjectDto.setTotal_wrong(0);
							resultReviewSubjectDto.setTotal_left(0);
						} else {							
							//wrong
							resultReviewSubjectDto.setTotal_wrong(1);
							resultReviewSubjectDto.setTotal_right(0);
							resultReviewSubjectDto.setTotal_left(0);
						}
						resultReviewSubjectDto.setTotal_question(1);
						subjectMapDetails.put(dto.getExamQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno(), resultReviewSubjectDto);
					}					
				}			
			}
			
			request.getSession().setAttribute("resultDescriptionDtoList", resultDescriptionDtoList);
			request.getSession().setAttribute("subjectMapDetails", subjectMapDetails);
			
		} else {
			info="Due to some technical problem we are not able to show you result please contact administrator";
		}
		flag = CommonConstants.SUCCESS_FLAG;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;		
	}
	
	public String homePageResultSearchDetails() throws POLLINGBusinessException
	{
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		try {
		AdminDetailDto adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		studentDetailsDto = this.getStudentDetailsServices().findStudentDetailsById(adminDetailDto.getInum_student_employee_id());
		resultDetailsDtoList = this.getExaminationDetailsServices().getResultDetailsDtoListByStudentId(studentDetailsDto.getInum_student_id());
		
		if(resultDetailsDtoList != null && resultDetailsDtoList.size()>0) {
			resultDetailsDto = new ResultDetailsDto();
			resultDetailsDto = resultDetailsDtoList.get(0);
				
			/*Logic to calculate result subject analysis*/
			List<ResultDescriptionDto> resultDescriptionDtoList = new ArrayList<ResultDescriptionDto>();
			resultDescriptionDtoList = this.getExaminationDetailsServices().getResultDescriptionDtoByResultDetailsId(resultDetailsDto.getOnum_result_details_id());
			Map<Integer, ResultReviewSubjectDto> subjectMapDetails = new HashMap<Integer, ResultReviewSubjectDto>();
			List<ResultReviewSubjectDto> reviewSubjectDtoList = new ArrayList<ResultReviewSubjectDto>();
				
			if(resultDescriptionDtoList != null && resultDescriptionDtoList.size()>0) {
				for(ResultDescriptionDto dto : resultDescriptionDtoList) {
					if(subjectMapDetails.containsKey(dto.getExamQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno())) {
						ResultReviewSubjectDto resultReviewSubjectDto = new ResultReviewSubjectDto();
						
						resultReviewSubjectDto = subjectMapDetails.get(dto.getExamQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno());
						if(dto.getOnum_selected_option() == null) {
							//Unattempted
							Integer total = resultReviewSubjectDto.getTotal_left(); 
							total = total+1;
							resultReviewSubjectDto.setTotal_left(total);
						} else if(dto.getOnum_selected_option().equals(dto.getOnum_correct_option())) {
							//correct
							Integer total = resultReviewSubjectDto.getTotal_right(); 
							total = total+1;
							resultReviewSubjectDto.setTotal_right(total);
						} else {							
							//wrong
							Integer total = resultReviewSubjectDto.getTotal_wrong(); 
							total = total+1;
							resultReviewSubjectDto.setTotal_wrong(total);
						}
						Integer total_question = resultReviewSubjectDto.getTotal_question();
						total_question = total_question+1;
						resultReviewSubjectDto.setTotal_question(total_question);
						subjectMapDetails.put(dto.getExamQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno(), resultReviewSubjectDto);
					} else {
						ResultReviewSubjectDto resultReviewSubjectDto = new ResultReviewSubjectDto();
						resultReviewSubjectDto.setSectionDetailsDto(dto.getExamQuestionDetailsDto().getSectionDetailsDto());
						if(dto.getOnum_selected_option() == null) {
							//Unattempted
							resultReviewSubjectDto.setTotal_left(1);
							resultReviewSubjectDto.setTotal_right(0);
							resultReviewSubjectDto.setTotal_wrong(0);
						} else if(dto.getOnum_selected_option().equals(dto.getOnum_correct_option())) {
							//correct
							resultReviewSubjectDto.setTotal_right(1);
							resultReviewSubjectDto.setTotal_wrong(0);
							resultReviewSubjectDto.setTotal_left(0);
						} else {							
							//wrong
							resultReviewSubjectDto.setTotal_wrong(1);
							resultReviewSubjectDto.setTotal_right(0);
							resultReviewSubjectDto.setTotal_left(0);
						}
						resultReviewSubjectDto.setTotal_question(1);
						subjectMapDetails.put(dto.getExamQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOnum_slno(), resultReviewSubjectDto);
					}					
				}			
			}
			request.getSession().setAttribute("resultDescriptionDtoList", resultDescriptionDtoList);
			request.getSession().setAttribute("subjectMapDetails", subjectMapDetails);
		} else {
			info="Due to some technical problem we are not able to show you result please contact administrator";
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
		
	}
	
	public String showResultDetailsReport() throws POLLINGBusinessException {
		String flag = CommonConstants.FAILURE_ERROR;
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		this.setRandomStingJsp(CommonMethod.generateStringValidation(request));
		this.populateMenu();
		
		examDetailsDtoList = this.getExaminationDetailsServices().getExamDetailsDtoList(adminDetailDto);
		resultDetailsDtoList = this.getExaminationDetailsServices().getResultDetailsDtoList(adminDetailDto);
			
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;		
	}	
	
	public String searchStudentsDetailsReportByCretariaReport() throws POLLINGBusinessException {
		
		String flag = CommonConstants.FAILURE_ERROR;
		this.populateMenu();
		
		if(request.getSession().getAttribute("adminDetailDto") == null) {
			return "login";
		}
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		
		CommonMethod.checkRandomStringValidation(response, request, this.getRandomStingJsp());			
		String from_date = request.getParameter("idt_from_date");
		String to_date = request.getParameter("idt_to_date");
		String exam_id = request.getParameter("onum_id");
		String unique_id = request.getParameter("istr_unique_id");
		
		String fromDate = "";
		if(from_date != null) {
			fromDate = from_date;
			System.out.println("From Date :"+fromDate);			
		}
		
		String toDate = "";
		if(to_date != null) {
			toDate = to_date;
			System.out.println("To Date :"+toDate);			
		}
		
		String examId = "0";
		if(exam_id != null) {
			examId = exam_id;
			System.out.println("Exam Id :"+examId);			
		}
		
		String uniqueId = "";
		if(unique_id != null) {
			uniqueId = unique_id;
			System.out.println("Unique Id :"+uniqueId);			
		}
		
		examDetailsDtoList = this.getExaminationDetailsServices().getExamDetailsDtoList(adminDetailDto);
		resultDetailsDtoList = this.getExaminationDetailsServices().getResultDetailsListbyCriteriaDetails(fromDate, toDate, examId, uniqueId, adminDetailDto);
		
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;		
	}
	
	/*
	public void examination() throws POLLINGBusinessException {
		
		String exam_id = request.getParameter("page_setup");
		System.out.println("The Section Id Is:::"+exam_id);
		
		examDetailsDto = this.getExaminationDetailsServices().findExamDetailsById(Integer.parseInt(exam_id));
		examQuestionDetailsDtoList = this.getExaminationDetailsServices().getExamQuestionDetailsDtoListByExamId(examDetailsDto.getOnum_id());
		
		Map<String, List<ExamQuestionDetailsDto>> questionDetailsDtoMap = new HashMap<String, List<ExamQuestionDetailsDto>>();
		if(examQuestionDetailsDtoList != null && examQuestionDetailsDtoList.size()>0) {
			for(ExamQuestionDetailsDto dto : examQuestionDetailsDtoList) {
				
				
				if(questionDetailsDtoMap.containsKey(dto.getSectionDetailsDto().getOstr_section_name())) {
					
					Double mark = this.getTotalMark(dto.getSectionDetailsDto(), examDetailsDto);
					dto.setMarkDetails(mark);
					
					List<ExamQuestionDetailsDto> list = new ArrayList<ExamQuestionDetailsDto>();
					list = questionDetailsDtoMap.get(dto.getSectionDetailsDto().getOstr_section_name());
					list.add(dto);
					questionDetailsDtoMap.put(dto.getSectionDetailsDto().getOstr_section_name(), list);
				
				} else {
					Double mark = this.getTotalMark(dto.getSectionDetailsDto(), examDetailsDto);
					dto.setMarkDetails(mark);
					
					List<ExamQuestionDetailsDto> list = new ArrayList<ExamQuestionDetailsDto>();
					list.add(dto);
					questionDetailsDtoMap.put(dto.getSectionDetailsDto().getOstr_section_name(), list);							
				}						
			}					
			request.getSession().setAttribute("studentExamDetails", questionDetailsDtoMap);
			request.getSession().setAttribute("examDetailsDto", examDetailsDto);
		} else {
			info = "Due to some technical problem exam is not available please contact with Administrator.";
		}
		System.out.println("Map Size ====="+questionDetailsDtoMap.size());
	}
	*/
	
	public String descriptionPage() throws Exception {
		
		String flag = CommonConstants.SUCCESS_FLAG;
		
		//this.examination();
		Map<String, ArrayList<ExamQuestionDetailsDto>> questionDetailsMap = (Map<String, ArrayList<ExamQuestionDetailsDto>>) request.getSession().getAttribute("studentExamDetails");
		
		CreateQuestionPaper.createQuestionPaper(questionDetailsMap, request);
		
		AdminDetailDto adminDetailDto = new AdminDetailDto();
		adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
		request.getSession().setAttribute("adminDetailDto", adminDetailDto);
		
		request.getSession().setAttribute("exam_key", "syso_my_exam");
		
		if(adminDetailDto.getInum_account_status().equals(1)) {
			ExamDetailsDto examDetailsDto = new ExamDetailsDto();
			examDetailsDto = (ExamDetailsDto) request.getSession().getAttribute("examDetailsDto");	
			request.getSession().setAttribute("examDetailsDto", examDetailsDto);
			
			List<ExamSectionDetailsDto> examSectionDetailsDtoList = new ArrayList<ExamSectionDetailsDto>();
			examSectionDetailsDtoList = this.getExaminationDetailsServices().findExamSectionDetailsByExamId(examDetailsDto.getOnum_id());
			request.getSession().setAttribute("examSectionDetailsDtoList", examSectionDetailsDtoList);
			
			try {
				List<StudentExamDetailsDto> studentExamDetailsDtoList = new ArrayList<StudentExamDetailsDto>();
				studentExamDetailsDtoList = this.getExaminationDetailsServices().getStudentExamDetailsDtoListByStudentId(examDetailsDto.getOnum_id(), adminDetailDto.getInum_student_employee_id());
				
				if(studentExamDetailsDtoList != null && studentExamDetailsDtoList.size()>0) {
					StudentExamDetailsDto studentExamDetailsDto = new StudentExamDetailsDto();
					studentExamDetailsDto = studentExamDetailsDtoList.get(0);
					
					if(studentExamDetailsDto.getOnum_exam_status().equals(com.oes.action.common.Enums.ExamStatus.PENDING.ordinal())) {
						info = "You are not eligible to take this exam. Your Request is on pending state please contact administrator.";
						//examDetailsDtoList = this.getExaminationDetailsServices().getActiveExamDetailsDtoList(adminDetailDto);
						flag = CommonConstants.ERROR_FLAG;
					} else if(studentExamDetailsDto.getOnum_exam_status().equals(com.oes.action.common.Enums.ExamStatus.REQUESTFOREXAM.ordinal())) {
						info = "You are not eligible to take this exam. Please Request for this exam.";
						//examDetailsDtoList = this.getExaminationDetailsServices().getActiveExamDetailsDtoList(adminDetailDto);
						flag = CommonConstants.ERROR_FLAG;
					} else if(studentExamDetailsDto.getOnum_exam_status().equals(com.oes.action.common.Enums.ExamStatus.REJECT.ordinal())) {
						info = "You are not eligible to take this exam. Your Request has been rejected please request once again.";
						//examDetailsDtoList = this.getExaminationDetailsServices().getActiveExamDetailsDtoList(adminDetailDto);
						flag = CommonConstants.ERROR_FLAG;
					}
				}
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		} else if(adminDetailDto.getInum_account_status().equals(2)) {
			ExamDetailsDto examDetailsDto = new ExamDetailsDto();
			examDetailsDtoList = this.getExaminationDetailsServices().getActiveExamDetailsDtoList(adminDetailDto);
			
			if(examDetailsDtoList != null && examDetailsDtoList.size()>0) {
				
				examDetailsDto = examDetailsDtoList.get(0);
				request.getSession().setAttribute("examDetailsDto", examDetailsDto);
				
				List<ExamSectionDetailsDto> examSectionDetailsDtoList = new ArrayList<ExamSectionDetailsDto>();
				examSectionDetailsDtoList = this.getExaminationDetailsServices().findExamSectionDetailsByExamId(examDetailsDto.getOnum_id());
				request.getSession().setAttribute("examSectionDetailsDtoList", examSectionDetailsDtoList);
				
				List<ExamQuestionDetailsDto> examQuestionDetailsDtoList = new ArrayList<ExamQuestionDetailsDto>();
				examQuestionDetailsDtoList = this.getExaminationDetailsServices().getExamQuestionDetailsDtoListByExamId(examDetailsDto.getOnum_id());
				
				Map<String, List<ExamQuestionDetailsDto>> questionDetailsDtoMap = new HashMap<String, List<ExamQuestionDetailsDto>>();
				if(examQuestionDetailsDtoList != null && examQuestionDetailsDtoList.size()>0) {
					for(ExamQuestionDetailsDto dto : examQuestionDetailsDtoList) {
						
						if(questionDetailsDtoMap.containsKey(dto.getSectionDetailsDto().getOstr_section_name())) {
							
							List<ExamQuestionDetailsDto> list = new ArrayList<ExamQuestionDetailsDto>();
							list = questionDetailsDtoMap.get(dto.getSectionDetailsDto().getOstr_section_name());
							list.add(dto);
							questionDetailsDtoMap.put(dto.getSectionDetailsDto().getOstr_section_name(), list);
						
						} else {
							List<ExamQuestionDetailsDto> list = new ArrayList<ExamQuestionDetailsDto>();
							list.add(dto);
							questionDetailsDtoMap.put(dto.getSectionDetailsDto().getOstr_section_name(), list);							
						}						
					}					
					request.getSession().setAttribute("studentExamDetails", questionDetailsDtoMap);
					request.getSession().setAttribute("examDetailsDto", examDetailsDto);
					
				} else {
					info = "Sorry.. We didn't find any Examination. Please contact management.";
					flag = CommonConstants.ERROR_FLAG;
				}				
			} else {
				info = "Sorry.. We didn't find any Examination. Please contact management.";
				flag = CommonConstants.ERROR_FLAG;
			}
		} else {
			info = "Sorry.. We didn't find any Examination. Please contact management.";
			flag = CommonConstants.ERROR_FLAG;
		}
		return flag;
	
	}
	// Resize of Image 
	protected BufferedImage getImageAndReduceQuestionSize(File imageFile){
	   
	   BufferedImage originalImage = null;
	   try {
		   originalImage = ImageIO.read(imageFile);
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
	  
	   	int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
       	//call function
       	BufferedImage resizeImageJpg = resizeImageQuestion(originalImage, type);
        return resizeImageJpg;
    }
	  
	  
	// Reduce the height and width of images
	protected BufferedImage resizeImageQuestion(BufferedImage originalImage, int type){
	       /*
	       BufferedImage resizedImage = new BufferedImage(CommonConstants.IMG_WIDTH_QUESTION, CommonConstants.IMG_HEIGHT_QUESTION, type);
	       Graphics2D g = resizedImage.createGraphics();
	       g.drawImage(originalImage, 0, 0, CommonConstants.IMG_WIDTH_QUESTION, CommonConstants.IMG_HEIGHT_QUESTION, null);
	       g.dispose();

	       return resizedImage;*/
		   return originalImage;
	}
	
	// Resize of Image 
	protected BufferedImage getImageAndReduceAnswerSize(File imageFile){
	   
	   BufferedImage originalImage = null;
	   try {
		   originalImage = ImageIO.read(imageFile);
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
	  
	   int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
       //call function
       BufferedImage resizeImageJpg = resizeImageAnswer(originalImage, type);
       return resizeImageJpg;
    }
	  
	  
	// Reduce the height and width of images
	protected BufferedImage resizeImageAnswer(BufferedImage originalImage, int type){
	       /*
		   BufferedImage resizedImage = new BufferedImage(CommonConstants.IMG_WIDTH_ANSWER, CommonConstants.IMG_HEIGHT_ANSWER, type);
	       Graphics2D g = resizedImage.createGraphics();
	       g.drawImage(originalImage, 0, 0, CommonConstants.IMG_WIDTH_ANSWER, CommonConstants.IMG_HEIGHT_ANSWER, null);
	       g.dispose();

	       return resizedImage;
	       */
		   return originalImage;
	}
	
	public Double getTotalMark(SectionDetailsDto sectionDetailsDto, ExamDetailsDto examDetailsDto) {
		Double totalMark = 0.0;
		try {
			//List<ExamSectionDetailsDto> examSectionDetailsDtoList = new ArrayList<ExamSectionDetailsDto>();
			List<ExamSectionDetailsDto> examSectionDetailsDtoLink = this.getExaminationDetailsServices().findExamSectionDetailsByExamIdSectionId(examDetailsDto.getOnum_id(), sectionDetailsDto.getOnum_slno());
			
			if(examSectionDetailsDtoLink != null && examSectionDetailsDtoLink.size()>0) {
				examSectionDetailsDto = examSectionDetailsDtoLink.get(0);
				Integer totalMarkDetails = examSectionDetailsDto.getOnum_total_marks();
				Integer totalQuestion = examSectionDetailsDto.getOnum_total_question();
				
				totalMark = (double) (totalMarkDetails/totalQuestion);
			}			
							
		} catch(Exception ex) {
			
		}
		return totalMark;
	}
	
	public String showExamBatchDetailsPage() throws Exception
	{
		String flag = CommonConstants.FAILURE_ERROR;		
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				return "login";
			}
			AdminDetailDto adminDetailDto = new AdminDetailDto();
			adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
			
			batchMasterDtoList = this.getMasterDetailsServices().getBatchMasterDtoList(adminDetailDto);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;		
	}
	
	// method to populate Role Permission Boxes
	public void getExamBatchBoxes() throws IHMSException {

		System.out.println("Role Permission boxes Action");
		String stateOption = "";
		try {
			if(request.getSession().getAttribute("adminDetailDto") == null) {
				
			} else {
				AdminDetailDto adminDetailDto = new AdminDetailDto();
				adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
					
				String DropDownMode = request.getParameter("SelectMode");
				String searchId = request.getParameter("searchBy");
				System.out.println("SearchId = "+searchId);
				System.out.println("DropDownMode is "+DropDownMode);
				
				if (DropDownMode.equalsIgnoreCase("examBatchBox")) {
					if (searchId != null && searchId != "") {
								
						System.out.println("PermissionName");
						examinationDetailsDtoList = this.getExaminationDetailsServices().findLeftList(Integer.parseInt(searchId), adminDetailDto.getInum_user_id());
						System.out.println("examDetailsDtoList is "+examinationDetailsDtoList.size());
						
						examBatchMappingDtoList = this.getExaminationDetailsServices().findRightList(Integer.parseInt(searchId), adminDetailDto.getInum_user_id());
						System.out.println("rolePermissionMasterListsize is "+examBatchMappingDtoList.size());
						
						String optionLeftList = "<select name='examinationBatchMappingDto.leftList' multiple='true' style='height:190px;width:300px'>";
							for (int u = 0; u < examinationDetailsDtoList.size(); u++) {
								Map examDetailMap = (HashMap) examinationDetailsDtoList.get(u);
								optionLeftList += "<option value="
										+ examDetailMap.get("onum_id").toString()
										+ ">"
										+ examDetailMap.get("ostr_exam_name").toString() + "</option>";
							}
							optionLeftList += "</select>";
							
							
							
							
							String optionRightList = "<select name='examinationBatchMappingDto.rightList' multiple='true' style='height:190px;width:300px'>";
							for (int u = 0; u < examBatchMappingDtoList.size(); u++) {
								Map examDetailMap = (HashMap) examBatchMappingDtoList.get(u);
								optionRightList += "<option value="
										+ examDetailMap.get("onum_id").toString()
										+ ">"
										+ examDetailMap.get("ostr_exam_name").toString() + "</option>";
							}
							optionRightList += "</select>";
		
							stateOption = optionLeftList + "^" + optionRightList;
							System.out.println("stateoption"+stateOption);						
					}
			    }
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(stateOption);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public String saveExamBatchMasterDetail() throws Exception
	{
		String flag = CommonConstants.SUCCESS_FLAG;
		
		System.out.println("Save Role Permission Master Action...");
		populateMenu();
		int batch_id = batchMasterDto.getOnum_slno();
		
		System.out.println("Batch id = "+batch_id);
		if(examinationBatchMappingDto.getStrChosenitems() != null && examinationBatchMappingDto.getStrChosenitems().length()>0) {
			if(batch_id == 0){
				
				System.out.println("Batch Id is Zero");
			
	            messages = "Please select Batch";//"Try Again, Atleast shift one permission";
				
	            this.showExamBatchDetailsPage();
	            
				flag = CommonConstants.ERROR_FLAG;		
			} else {
		
			try {	
			
			   examinationBatchMappingDtoList = this.getExaminationDetailsServices().findExaminationBatchMappingByBatch(batch_id);
			   System.out.println("Size = "+examinationBatchMappingDtoList.size());
			   if(examinationBatchMappingDtoList!= null && examinationBatchMappingDtoList.size()>0){
				   for(ExaminationBatchMappingDto examinationBatchMappingDto: examinationBatchMappingDtoList){
					   System.out.println("id is "+examinationBatchMappingDto.getInum_exam_batch_id());
					   this.getExaminationDetailsServices().deleteExaminationBatchMappingDtoDetails(examinationBatchMappingDto);
					   info = "Role Permission has been shifted successfully";
				   }
			   }
			   
			   String chosenitem[] = examinationBatchMappingDto.getStrChosenitems().replace("@", "#").split("#");
			   System.out.println("Chosenitem length = "+chosenitem.length);
			   for(int i=0;i<chosenitem.length;i++ ){
				   
				   String dataElement=chosenitem[i];
				   examinationBatchMappingDto.setInum_user_id(Enums.MasterStatus.INACTIVE.ordinal());
				   examinationBatchMappingDto.setInum_is_active(1);
				   examinationBatchMappingDto.setIdt_entry_date(new Date());
				   System.out.println("Date has been filled");
				   
				   if(examinationBatchMappingDto.getBatchMasterDto()==null){				   
					   examinationBatchMappingDto.setBatchMasterDto(new BatchMasterDto());
					   examinationBatchMappingDto.getBatchMasterDto().setOnum_slno(batch_id);				   
				   }
				   
				   System.out.println("Conti...1");
				   examinationBatchMappingDto.setExamDetailsDto(new ExamDetailsDto());
				   examinationBatchMappingDto.getExamDetailsDto().setOnum_id(Integer.parseInt(chosenitem[i]));
				   this.getExaminationDetailsServices().saveExaminationBatchMappingDtoDetails(examinationBatchMappingDto);
				   info = "Role Permission has been shifted";
				   examinationBatchMappingDto = new ExaminationBatchMappingDto();
	     
				   System.out.println("Conti...2");
			   }	
			   System.out.println("Method End......");	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		}
		this.showExamBatchDetailsPage();
		flag = CommonConstants.SUCCESS_FLAG;
		return flag;
	}
	
	public String theMonth(int month){
	    String[] monthNames = {"None","January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	    return monthNames[month];
	}
	// Admin service locater
	private IAdminService getAdminManagementServices() {
		Object serviceObj = ServiceLocator.getInstance().getService(com.sms.constants.CommonConstants.ADMIN_MANAGEMENT_SERVICE);
			return serviceObj == null ? null : (IAdminService) serviceObj;
	}
	// Examination service locater
	private IExaminationDetailsServices getExaminationDetailsServices() {
		Object serviceObj = ServiceLocator.getInstance().getService(CommonConstants.EXAMINATION_DETAILS);
			return serviceObj == null ? null : (IExaminationDetailsServices) serviceObj;
	}
	// Admin service locater
	private IMasterDetailsServices getMasterDetailsServices () {
		Object serviceObj = ServiceLocator.getInstance().getService(com.oes.constants.CommonConstants.MASTER_DETAILS);
			return serviceObj == null ? null : (IMasterDetailsServices) serviceObj;
	}
	
	private IStudentDetailsServices getStudentDetailsServices(){
		Object serviceObj = ServiceLocator.getInstance().getService(CommonConstants.STUDENT_DETAILS);
				return serviceObj == null ? null : (IStudentDetailsServices) serviceObj;
	}
	

}
