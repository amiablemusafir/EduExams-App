package com.oes.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.oes.dao.IExaminationDetailsDao;
import com.oes.dto.CourseDetailsDto;
import com.oes.dto.ExamDetailsDto;
import com.oes.dto.ExamImageMasterDto;
import com.oes.dto.ExamQuestionDetailsDto;
import com.oes.dto.ExamRequestDetailsDto;
import com.oes.dto.ExamSectionDetailsDto;
import com.oes.dto.ExaminationBatchMappingDto;
import com.oes.dto.MappedExamDetailsDto;
import com.oes.dto.QuestionDetailsDto;
import com.oes.dto.ResultDescriptionDto;
import com.oes.dto.ResultDetailsDto;
import com.oes.dto.ScoreGenerationDto;
import com.oes.dto.StudentDetailsDto;
import com.oes.dto.StudentExamDetailsDto;
import com.oes.dto.StudentMappedExamDetailsDto;
import com.sms.admin.dao.ISqlHibernateCompatibleDao;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.dto.PermissionMasterDto;
import com.sms.admin.dto.RolePermissionMasterDto;


public class ExaminationDetailsDaoImpl implements IExaminationDetailsDao {

	public HibernateTemplate hibernateTemplate;
	private ISqlHibernateCompatibleDao sqlHibernateCompatibleDao;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public ISqlHibernateCompatibleDao getSqlHibernateCompatibleDao() {
		return sqlHibernateCompatibleDao;
	}
	public void setSqlHibernateCompatibleDao(ISqlHibernateCompatibleDao sqlHibernateCompatibleDao) {
		this.sqlHibernateCompatibleDao = sqlHibernateCompatibleDao;
	}

	@Override
	public void saveandupdateExamDetailsDto(ExamDetailsDto examDetailsDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(examDetailsDto);
		
	}

	@Override
	public List<ExamDetailsDto> getExamDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException {
		String examDetails = "";
		if(adminDetailDto.getInum_role_id().equals(1)) {
			examDetails = "from ExamDetailsDto as details where details.onum_is_active=1";
		} else {
			examDetails = "from ExamDetailsDto as details where details.onum_is_active=1 and details.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id();
		}
		return this.hibernateTemplate.find(examDetails);
	}
	
	@Override
	public List<ExamDetailsDto> getActiveExamDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException {
		String examDetails = ""; 
		if(adminDetailDto.getInum_role_id().equals(1)) {
			examDetails="from ExamDetailsDto as details where details.onum_is_active=1 and details.onum_exam_activation_flag=1";
		} else {
			examDetails="from ExamDetailsDto as details where details.onum_is_active=1 and details.onum_exam_activation_flag=1 and details.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id();
		}
		return this.hibernateTemplate.find(examDetails);
	}

	@Override
	public ExamDetailsDto findExamDetailsById(Integer examDetailsId) throws DataAccessException {
		try {
			 ExamDetailsDto  examDetailsDto = ( ExamDetailsDto) this.getHibernateTemplate().get("com.oes.dto.ExamDetailsDto", examDetailsId);
			return examDetailsDto;
		  }
		catch (RuntimeException re) {
			throw re;
		}
	}
	
	@Override
	public List<ExamDetailsDto> getExamDetailsDtoListByCourseId(Integer course_id) throws DataAccessException {
		String examDetails="from ExamDetailsDto as details where details.onum_is_active=1 and details.onum_exam_activation_flag = 1 and details.adminDetailDto.inum_role_id = 1 and details.courseDetailsDto.onum_slno ="+course_id;
		return this.hibernateTemplate.find(examDetails);
	}

	
	@Override
	public List<ExamImageMasterDto> getExamImageMasterDtoList() throws DataAccessException {
		String examDetails="from ExamImageMasterDto as details where details.onum_is_active=1";
		return this.hibernateTemplate.find(examDetails);
	}
	@Override
	public void saveandupdateStudentMappedExamDetailsDto(StudentMappedExamDetailsDto studentMappedExamDetailsDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(studentMappedExamDetailsDto);		
	}
	@Override
	public List<StudentMappedExamDetailsDto> getStudentMappedExamDetailsDtoListByStudentId(Integer student_id) throws DataAccessException {
		String examDetails="from StudentMappedExamDetailsDto as details where details.onum_is_active = 1 and details.onum_exam_activation_flag = 1 and details.adminDetailDto.inum_user_id ="+student_id;
		return this.hibernateTemplate.find(examDetails);
	}
	@Override
	public List<StudentMappedExamDetailsDto> getStudentMappedExamDetailsDtoListByExamId(Integer exam_id) throws DataAccessException {
		String examDetails="from StudentMappedExamDetailsDto as details where details.onum_is_active = 1 and details.examDetailsDto.onum_id ="+exam_id;
		return this.hibernateTemplate.find(examDetails);
	}

	
	//>>>>>>>>>>>>>>>>>>>>>>>for Exam SECTION>>>>>>>>>>>>>>>>>>>
	@Override
	public void saveandupdateExamSectionDetailsDto(ExamSectionDetailsDto examSectionDetailsDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(examSectionDetailsDto);
		
	}
	@Override
	public List<ExamSectionDetailsDto> getExamSectionDetailsDtoList() throws DataAccessException {
		String examSectionDetails="from ExamSectionDetailsDto as details where details.onum_is_active=1";
		return this.hibernateTemplate.find(examSectionDetails);
	}

	@Override
	public ExamSectionDetailsDto findExamSectionDetailsById(Integer examSectionDetailsId) throws DataAccessException {
		try {
			ExamSectionDetailsDto  examSectionDetailsDto = (ExamSectionDetailsDto) this.getHibernateTemplate().get("com.oes.dto.ExamSectionDetailsDto", examSectionDetailsId);
			return examSectionDetailsDto;
		  }
		catch (RuntimeException re) {
			throw re;
		}
	}
	
	@Override
	public List<ExamSectionDetailsDto> findExamSectionDetailsByExamId(Integer exam_id) throws DataAccessException {
		String examSectionDetails="from ExamSectionDetailsDto as details where details.onum_is_active=1 and details.examDetailsDto.onum_id ="+exam_id;
		return this.hibernateTemplate.find(examSectionDetails);
	}
	
	public List<ExamSectionDetailsDto> findExamSectionDetailsByExamIdSectionId(Integer exam_id,Integer section_id) throws DataAccessException {
		String examSectionDetails="from ExamSectionDetailsDto as details where details.onum_is_active=1 and details.examDetailsDto.onum_id ="+exam_id+" and details.sectionDetailsDto.onum_slno = "+section_id;
		return this.hibernateTemplate.find(examSectionDetails);
	}

	
	
	//>>>>>>>>>>>>>>>>>>>>>>>for Exam Question>>>>>>>>>>>>>>>>>>>
	@Override
	public void saveandupdateQuestionDetailsDto(QuestionDetailsDto questionDetailsDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(questionDetailsDto);
		
	}
	@Override
	public List<QuestionDetailsDto> getQuestionDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException {
		String questionDetails = "";
		if(adminDetailDto.getInum_role_id().equals(1)) {
			questionDetails = "from QuestionDetailsDto as details where details.onum_is_active=1";
		} else {
			questionDetails = "from QuestionDetailsDto as details where details.onum_is_active=1 and details.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id();
		}
		return this.hibernateTemplate.find(questionDetails);
	}

	@Override
	public QuestionDetailsDto findQuestionDetailsDtoById(Integer id) throws DataAccessException {
		try {
			QuestionDetailsDto  questionDetailsDto = (QuestionDetailsDto) this.getHibernateTemplate().get("com.oes.dto.QuestionDetailsDto", id);
			return questionDetailsDto;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@Override
	public List<QuestionDetailsDto> getQuestionDetailsDtoListByCretaria(String question, Integer section_id, AdminDetailDto adminDetailDto) throws DataAccessException {
		String questionDetails = "";
		if(adminDetailDto.getInum_role_id().equals(1)) {
			questionDetails = "from QuestionDetailsDto as details where details.onum_is_active=1";
			if(!question.equals("")) {
				questionDetails = questionDetails+" and details.ostr_question like '%"+question+"%'";
			}
			if(!section_id.equals(0)) {
				questionDetails = questionDetails+" and details.sectionDetailsDto.onum_slno = "+section_id+"";
			}
		} else {
			questionDetails = "from QuestionDetailsDto as details where details.onum_is_active=1 and details.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id()+"";
			if(!question.equals("")) {
				questionDetails = questionDetails+" and details.ostr_question like '%"+question+"%'";
			}
			if(!section_id.equals(0)) {
				questionDetails = questionDetails+" and details.sectionDetailsDto.onum_slno = "+section_id+"";
			}
		}		
		return this.hibernateTemplate.find(questionDetails);
	}

	@Override
	public List<QuestionDetailsDto> getQuestionDetailsDtoListBySectionId(Integer section_id, Integer status, AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		String questionDetails = "";
		if(adminDetailDto.getInum_role_id().equals(1)) {
			questionDetails = "from QuestionDetailsDto as details where details.onum_is_active=1 and details.onum_question_status="+status+" and details.sectionDetailsDto.onum_slno = "+section_id;
		} else {
			questionDetails = "from QuestionDetailsDto as details where details.onum_is_active=1 and details.onum_question_status="+status+" and details.sectionDetailsDto.onum_slno = "+section_id+" and details.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id();
		}
		return this.hibernateTemplate.find(questionDetails);
	}
	
	@Override
	public List<QuestionDetailsDto> getQuestionDetailsDtoListBySecId(Integer section_id, AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		String questionDetails = "";
		if(adminDetailDto.getInum_role_id().equals(1)) {
			questionDetails = "from QuestionDetailsDto as details where details.onum_is_active=1 and details.sectionDetailsDto.onum_slno = "+section_id;
		} else {
			questionDetails = "from QuestionDetailsDto as details where details.onum_is_active=1 and details.sectionDetailsDto.onum_slno = "+section_id+" and details.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id();
		}
		return this.hibernateTemplate.find(questionDetails);
	}
	
	/*Find duplicate question*/
	@Override
	public List<QuestionDetailsDto> getDuplicateQuestionDetailsDtoList(String question, Integer section_id, AdminDetailDto adminDetailDto) throws DataAccessException {
		String questionDetails = "";
		if(adminDetailDto.getInum_role_id().equals(1)) {
			questionDetails = "from QuestionDetailsDto as details where details.onum_is_active=1";
			questionDetails = questionDetails+" and details.ostr_question = '"+question+"' and details.sectionDetailsDto.onum_slno = "+section_id+"";
			
		} else {
			questionDetails = "from QuestionDetailsDto as details where details.onum_is_active=1 and details.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id()+"";
			questionDetails = questionDetails+" and details.ostr_question = '"+question+"' and details.sectionDetailsDto.onum_slno = "+section_id+"";
		}		
		return this.hibernateTemplate.find(questionDetails);
	}
	/*===================== End ==========================*/
	
	
	@Override
	public void saveandupdateExamQuestionDetailsDto(ExamQuestionDetailsDto examQuestionDetailsDto) throws DataAccessException {
		// TODO Auto-generated method stub
		this.hibernateTemplate.saveOrUpdate(examQuestionDetailsDto);
	}
	@Override
	public  List<ExamQuestionDetailsDto> getExamQuestionDetailsDtoListByExamId(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		String details="from ExamQuestionDetailsDto as details where details.onum_is_active=1 and details.examDetailsDto.onum_id="+id;
		return this.hibernateTemplate.find(details);
	}

	
	@Override
	public void saveandupdateStudentExamDetailsDto(StudentExamDetailsDto studentExamDetailsDto) throws DataAccessException {
		// TODO Auto-generated method stub
		this.hibernateTemplate.saveOrUpdate(studentExamDetailsDto);
	}
	@Override
	public List<StudentExamDetailsDto> getStudentExamDetailsDtoList() throws DataAccessException {
		// TODO Auto-generated method stub
		String details="from StudentExamDetailsDto as details where details.onum_is_active=1";
		return this.hibernateTemplate.find(details);
	}
	@Override
	public StudentExamDetailsDto findStudentExamDetailsDtoById(Integer id) throws DataAccessException {
		try {
			StudentExamDetailsDto  studentExamDetailsDto = (StudentExamDetailsDto) this.getHibernateTemplate().get("com.oes.dto.StudentExamDetailsDto", id);
			return studentExamDetailsDto;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	@Override
	public List<StudentExamDetailsDto> getStudentExamDetailsDtoListByExamId(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		String questionDetails = "from StudentExamDetailsDto as details where details.onum_is_active=1 and details.examDetailsDto.onum_id = "+id;
		return this.hibernateTemplate.find(questionDetails);
	}
	@Override
	public List<StudentExamDetailsDto> getStudentExamDetailsDtoListByStudentId(Integer exam_id, Integer student_id) throws DataAccessException {
		// TODO Auto-generated method stub
		String questionDetails = "from StudentExamDetailsDto as details where details.onum_is_active=1 and details.examDetailsDto.onum_id = "+exam_id+" and details.examDetailsDto.onum_exam_activation_flag = 1 and details.examDetailsDto.onum_is_active = 1 and details.studentDetailsDto.inum_student_id="+student_id;
		return this.hibernateTemplate.find(questionDetails);
	}
	@Override
	public List<StudentExamDetailsDto> getStudentExamDetailsDtoListByStudentId(Integer student_id) throws DataAccessException {
		// TODO Auto-generated method stub
		String questionDetails = "from StudentExamDetailsDto as details where details.onum_is_active=1 and details.examDetailsDto.onum_exam_activation_flag = 1 and details.examDetailsDto.onum_is_active = 1 and details.studentDetailsDto.inum_student_id="+student_id;
		return this.hibernateTemplate.find(questionDetails);
	}
	
	
	
	@Override
	public List<ExamRequestDetailsDto> getExamRequestDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException {
		String examDetails = "";
		if(adminDetailDto.getInum_role_id().equals(1)) {
			examDetails = "from ExamRequestDetailsDto as details where details.onum_is_active=1";			
		} else {
			examDetails = "from ExamRequestDetailsDto as details where details.onum_is_active=1 and details.examDetailsDto.adminDetailDto.inum_user_id ="+adminDetailDto.getInum_user_id();
		}
		return this.hibernateTemplate.find(examDetails);
	}
	
	@Override
	public List<ExamRequestDetailsDto> getExamRequestDetailsDtoListByStudentId(Integer id) throws DataAccessException {
		String examDetails="from ExamRequestDetailsDto as details where details.onum_is_active=1 and details.studentDetailsDto.inum_student_id="+id;
		return this.hibernateTemplate.find(examDetails);
	}
	
	@Override
	public void saveandupdateExamRequestDetailsDto(ExamRequestDetailsDto examRequestDetailsDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(examRequestDetailsDto);
		
	}

	@Override
	public ExamRequestDetailsDto findExamRequestDetailsById(Integer id) throws DataAccessException {
		try {
			ExamRequestDetailsDto  examRequestDetailsDto = (ExamRequestDetailsDto) this.getHibernateTemplate().get("com.oes.dto.ExamRequestDetailsDto", id);
			return examRequestDetailsDto;
		  }
		catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<ExamRequestDetailsDto> getExamRequestDetailsDtoListByStatus(Integer status, AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		String examDetails = "";
		if(adminDetailDto.getInum_role_id().equals(1)) {
			examDetails="from ExamRequestDetailsDto as details where details.onum_is_active=1 and details.onum_status="+status;
		} else {
			examDetails="from ExamRequestDetailsDto as details where details.onum_is_active=1 and details.onum_status="+status+" and  details.examDetailsDto.adminDetailDto.inum_user_id ="+adminDetailDto.getInum_user_id();
		}
		return this.hibernateTemplate.find(examDetails);
	}

	
	/*Result Details Dto*/
	@Override
	public void saveandupdateResultDetailsDto(ResultDetailsDto resultDetailsDto) throws DataAccessException {
		// TODO Auto-generated method stub
		this.hibernateTemplate.saveOrUpdate(resultDetailsDto);
	}

	@Override
	public List<ResultDetailsDto> getResultDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		String resultDetails = "";
		if(adminDetailDto.getInum_role_id().equals(1)) {
			resultDetails="from ResultDetailsDto as details where details.onum_is_active=1";
		} else {
			resultDetails="from ResultDetailsDto as details where details.onum_is_active=1 and details.examDetailsDto.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id()+"";
		}
		return this.hibernateTemplate.find(resultDetails);
	}

	@Override
	public ResultDetailsDto getResultDetailsDtoById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			ResultDetailsDto  resultDetailsDto = (ResultDetailsDto) this.getHibernateTemplate().get("com.oes.dto.ResultDetailsDto", id);
			return resultDetailsDto;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<ResultDetailsDto> getResultDetailsDtoListByStudentId(Integer student_id) throws DataAccessException {
		// TODO Auto-generated method stub
		String resultDetails="from ResultDetailsDto as details where details.onum_is_active=1 and details.studentDetailsDto.inum_student_id = "+student_id+" ORDER By details.odt_entry_date DESC";
		return this.hibernateTemplate.find(resultDetails);
	}

	@Override
	public List<ResultDetailsDto> getResultDetailsDtoListByExamId(Integer exam_id, AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		String resultDetails = "";
		if(adminDetailDto.getInum_role_id().equals(1)) {
			resultDetails="from ResultDetailsDto as details where details.onum_is_active=1 and details.examDetailsDto.onum_id = "+exam_id+"";
		} else {
			resultDetails="from ResultDetailsDto as details where details.onum_is_active=1 and details.examDetailsDto.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id()+" and details.examDetailsDto.onum_id = "+exam_id+"";
		}
		return this.hibernateTemplate.find(resultDetails);
	}
	
	@Override
	public List<ResultDetailsDto> getResultDetailsDtoListByExamAndMonth(Integer exam_id, Integer month, AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		String resultDetails = "";
		if(adminDetailDto.getInum_role_id().equals(1)) {
			resultDetails="from ResultDetailsDto as details where details.onum_is_active=1 and details.examDetailsDto.onum_id = "+exam_id+" and DATE_FORMAT(details.odt_entry_date, '%m') = "+month+" ORDER BY details.odec_total_mark DESC";
		} else {
			resultDetails="from ResultDetailsDto as details where details.onum_is_active=1 and details.examDetailsDto.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id()+" and details.examDetailsDto.onum_id = "+exam_id+" and DATE_FORMAT(details.odt_entry_date, '%m') = "+month+" ORDER BY details.odec_total_mark DESC";
		}
		System.out.println("Query"+resultDetails);		
		return this.hibernateTemplate.find(resultDetails);
	}

	/*Result Description Details*/
	@Override
	public void saveandupdateResultDescriptionDto(ResultDescriptionDto resultDescriptionDto) throws DataAccessException {
		// TODO Auto-generated method stub
		this.hibernateTemplate.saveOrUpdate(resultDescriptionDto);
	}

	@Override
	public List<ResultDescriptionDto> getResultDescriptionDtoByResultDetailsId(Integer result_details_id) throws DataAccessException {
		// TODO Auto-generated method stub
		String resultDetails="from ResultDescriptionDto as details where details.onum_is_active=1 and details.resultDetailsDto.onum_result_details_id = "+result_details_id+"";
		return this.hibernateTemplate.find(resultDetails);

	}

	@Override
	public void saveandupdateScoreGenerationDto(ScoreGenerationDto scoreGenerationDto) throws DataAccessException {
		// TODO Auto-generated method stub
		this.hibernateTemplate.saveOrUpdate(scoreGenerationDto);
	}

	@Override
	public List<ScoreGenerationDto> getScoreGenerationDtoList() throws DataAccessException {
		// TODO Auto-generated method stub
		String details="from ScoreGenerationDto as details where details.onum_is_active=1";
		return this.hibernateTemplate.find(details);
	}

	@Override
	public ScoreGenerationDto getScoreGenerationDtoById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			ScoreGenerationDto  detailsDto = (ScoreGenerationDto) this.getHibernateTemplate().get("com.oes.dto.ScoreGenerationDto", id);
			return detailsDto;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<ScoreGenerationDto> getScoreGenerationDtoListByExamIdAndMonth(Integer exam_id, Integer month) throws DataAccessException {
		// TODO Auto-generated method stub
		String details="from ScoreGenerationDto as details where details.onum_is_active=1 and details.examDetailsDto.onum_id = "+exam_id+" and details.onum_month = "+month;
		return this.hibernateTemplate.find(details);
	}
	
	@Override
	public List<ResultDetailsDto> getResultDetailsListbyCriteriaDetails(String fromDate, String toDate, String examId, String uniqueId, AdminDetailDto adminDetailsDto) throws DataAccessException {
		
		// TODO Auto-generated method stub
		String resultDetailsQry = "from ResultDetailsDto as resultDetails where resultDetails.onum_is_active = 1";
		if(adminDetailsDto.getInum_role_id().equals(1)) {
		
		} else {
			resultDetailsQry= resultDetailsQry.concat(" and resultDetails.studentDetailsDto.adminDetailDto.inum_user_id = "+adminDetailsDto.getInum_user_id()+"");
		}
	 
		String addCriteria = new String();		
		
		// Unique Id	
		if(!uniqueId.equals("")){
			   
			System.out.println("Unique ID......");			   
			
			addCriteria = " and resultDetails.studentDetailsDto.istr_unique_id like '%"+uniqueId+"%'";			  
			
			resultDetailsQry = resultDetailsQry + addCriteria;
		
		}
		  	
		// Exam Id
		if(!examId.equals("0")){
			   
			   System.out.println("First Name...............");
			   
			   addCriteria = " and resultDetails.examDetailsDto.onum_id = "+examId+"";
			   
			   resultDetailsQry = resultDetailsQry + addCriteria;
		}
		   
			
		// Last Name 
		if(!fromDate.equals("") && !toDate.equals("")) {
			
			   System.out.println("From Date and To Date .............."); 
			   
			   addCriteria = " and STR_TO_DATE(resultDetails.ostr_date,'%d-%m-%Y') BETWEEN STR_TO_DATE('"+fromDate+"','%d-%m-%Y')  and STR_TO_DATE('"+toDate+"','%d-%m-%Y')";

			   resultDetailsQry = resultDetailsQry + addCriteria;
			   
		} else {
			if(!fromDate.equals("")){
				   
				System.out.println("From Date .............."); 
				   
				addCriteria = " and STR_TO_DATE(resultDetails.ostr_date,'%d-%m-%Y') = STR_TO_DATE('"+fromDate+"','%d-%m-%Y')";
				
				resultDetailsQry = resultDetailsQry + addCriteria;
			}
			if(!toDate.equals("")){
				   
				System.out.println("To Date ..............");
				
				addCriteria = " and STR_TO_DATE(resultDetails.ostr_date,'%d-%m-%Y') = STR_TO_DATE('"+toDate+"','%d-%m-%Y')";

				resultDetailsQry = resultDetailsQry + addCriteria;
			}
		}
		
		System.out.println("Query : "+resultDetailsQry);
	   	return this.getHibernateTemplate().find(resultDetailsQry);
	}		
	
	
	
	@Override
	public List<MappedExamDetailsDto> getMappedExamDetailsDtoList() throws DataAccessException {
		// TODO Auto-generated method stub
		String details="from MappedExamDetailsDto as details where details.onum_is_active=1";
		return this.hibernateTemplate.find(details);
	}
	@Override
	public void saveandupdateMappedExamDetailsDto(MappedExamDetailsDto mappedExamDetailsDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(mappedExamDetailsDto);		
	}
	@Override
	public List<MappedExamDetailsDto> getMappedExamDetailsDtoListByStudentId(Integer student_id) throws DataAccessException {
		String examDetails="from MappedExamDetailsDto as details where details.onum_is_active = 1 and details.onum_exam_activation_flag = 1 and details.adminDetailDto.inum_user_id ="+student_id;
		return this.hibernateTemplate.find(examDetails);
	}
	@Override
	public List<MappedExamDetailsDto> getMappedExamDetailsDtoListByExamId(Integer exam_id) throws DataAccessException {
		String examDetails="from MappedExamDetailsDto as details where details.onum_is_active = 1 and details.examDetailsDto.onum_id ="+exam_id;
		return this.hibernateTemplate.find(examDetails);
	}
	
	
	
	public List<ExaminationBatchMappingDto> findExaminationBatchMappingByBatch(Integer batch_id) throws Exception {
	  
		String query = "from ExaminationBatchMappingDto as exambatchdto where exambatchdto.batchMasterDto.onum_slno = '"+batch_id+"' and exambatchdto.examDetailsDto.onum_is_active = 1  and exambatchdto.inum_is_active = 1";
		
		List<ExaminationBatchMappingDto> examBatchList = this.getHibernateTemplate().find(query);
		return examBatchList;
	}
	public void deleteExaminationBatchMappingDetails(ExaminationBatchMappingDto examinationBatchMappingDto) throws DataAccessException {
		this.getHibernateTemplate().delete(examinationBatchMappingDto);
	}

	
	public void saveExaminationBatchMappingDetails(ExaminationBatchMappingDto examinationBatchMappingDto) throws DataAccessException {
		this.getHibernateTemplate().saveOrUpdate(examinationBatchMappingDto);
	}
}
