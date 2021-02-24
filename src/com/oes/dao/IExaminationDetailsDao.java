package com.oes.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

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
import com.oes.dto.StudentExamDetailsDto;
import com.oes.dto.StudentMappedExamDetailsDto;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.dto.RolePermissionMasterDto;

public interface IExaminationDetailsDao {
	
	//method to update ExamDetailsDto Data
	public void saveandupdateExamDetailsDto(ExamDetailsDto examDetailsDto) throws DataAccessException;
	
	// method to populate ExamDetailsDto data
	public List<ExamDetailsDto> getExamDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException;
	
	// method to populate ExamDetailsDto data
	public List<ExamDetailsDto> getActiveExamDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException;
		
	// method to populate ExamDetailsDto by Id
    public ExamDetailsDto findExamDetailsById(Integer examDetailsId) throws DataAccessException;
	
	public List<ExamDetailsDto> getExamDetailsDtoListByCourseId(Integer course_id) throws DataAccessException;
    
    
	// method to populate ExamDetailsDto data
	public List<ExamImageMasterDto> getExamImageMasterDtoList() throws DataAccessException;
		
	public void saveandupdateStudentMappedExamDetailsDto(StudentMappedExamDetailsDto studentMappedExamDetailsDto) throws DataAccessException;
	
	public List<StudentMappedExamDetailsDto> getStudentMappedExamDetailsDtoListByStudentId(Integer student_id) throws DataAccessException;
	  
	public List<StudentMappedExamDetailsDto> getStudentMappedExamDetailsDtoListByExamId(Integer exam_id) throws DataAccessException;
	//>>>>>>>>>>>>>>>>>>>>>>>for Exam SECTION>>>>>>>>>>>>>>>>>>>
	
	//method to update ExamSectionDetailsDto Data
  	public void saveandupdateExamSectionDetailsDto(ExamSectionDetailsDto examSectionDetailsDto) throws DataAccessException;
	
  	//method to populate ExamSectionDetailsDto data
  	public List<ExamSectionDetailsDto> getExamSectionDetailsDtoList() throws DataAccessException;
  	
  	// method to populate ExamDetailsDto by Id
    public ExamSectionDetailsDto findExamSectionDetailsById(Integer examSectionDetailsId) throws DataAccessException;
    
    public List<ExamSectionDetailsDto> findExamSectionDetailsByExamId(Integer exam_id) throws DataAccessException;

    public List<ExamSectionDetailsDto> findExamSectionDetailsByExamIdSectionId(Integer exam_id,Integer section_id) throws DataAccessException;

    
    
    //>>>>>>>>>>>>>>>>>>>>>>>for CREATE QUESTION >>>>>>>>>>>>>>>>>>>
	
	//method to update QuestionDetailsDto Data
  	public void saveandupdateQuestionDetailsDto(QuestionDetailsDto questionDetailsDto) throws DataAccessException;
	
  	//method to populate QuestionDetailsDto data
  	public List<QuestionDetailsDto> getQuestionDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException;
  	
  	// method to populate QuestionDetailsDto by Id
    public QuestionDetailsDto findQuestionDetailsDtoById(Integer id) throws DataAccessException;
   
    //method to populate QuestionDetailsDto data
  	public List<QuestionDetailsDto> getQuestionDetailsDtoListByCretaria(String question, Integer section_id, AdminDetailDto adminDetailDto) throws DataAccessException;
  	
    //method to populate QuestionDetailsDto data
  	public List<QuestionDetailsDto> getQuestionDetailsDtoListBySectionId(Integer section_id, Integer status, AdminDetailDto adminDetailDto) throws DataAccessException;
  	
  	//method to populate QuestionDetailsDto data
  	public List<QuestionDetailsDto> getQuestionDetailsDtoListBySecId(Integer section_id, AdminDetailDto adminDetailDto) throws DataAccessException;
  	
  	public List<QuestionDetailsDto> getDuplicateQuestionDetailsDtoList(String question, Integer section_id, AdminDetailDto adminDetailDto) throws DataAccessException;
  	
  	
  	//>>>>>>>>>>>>>>>>>>>>>>>for CREATE QUESTION SET >>>>>>>>>>>>>>>>>>>
  	
  	//method to update ExamQuestionDetailsDto Data
  	public void saveandupdateExamQuestionDetailsDto(ExamQuestionDetailsDto examQuestionDetailsDto) throws DataAccessException;
	
  	// method to populate ExamQuestionDetailsDto data
   	public List<ExamQuestionDetailsDto> getExamQuestionDetailsDtoListByExamId(Integer id) throws DataAccessException;
   	
  	
  	
    //>>>>>>>>>>>>>>>>>>>>>>>for Exam SECTION>>>>>>>>>>>>>>>>>>> 
  	
    //method to update StudentExamDetailsDto Data
  	public void saveandupdateStudentExamDetailsDto(StudentExamDetailsDto studentExamDetailsDto) throws DataAccessException;
  	
  	// method to populate StudentExamDetailsDto data
  	public List<StudentExamDetailsDto> getStudentExamDetailsDtoList() throws DataAccessException;
  	
  	// method to populate StudentExamDetailsDto by Id
    public StudentExamDetailsDto findStudentExamDetailsDtoById(Integer id) throws DataAccessException;
  	
    // method to populate StudentExamDetailsDto data
   	public List<StudentExamDetailsDto> getStudentExamDetailsDtoListByExamId(Integer id) throws DataAccessException;
   	
   	// method to populate StudentExamDetailsDto data
   	public List<StudentExamDetailsDto> getStudentExamDetailsDtoListByStudentId(Integer exam_id,Integer student_id) throws DataAccessException;
   	
   	// method to populate StudentExamDetailsDto data
   	public List<StudentExamDetailsDto> getStudentExamDetailsDtoListByStudentId(Integer student_id) throws DataAccessException;
   	
   	
    //>>>>>>>>>>>>>>>>>>>>>>>for Exam REQUEST DETAILS >>>>>>>>>>>>>>>>
   	
    //method to update ExamRequestDetailsDto Data
  	public void saveandupdateExamRequestDetailsDto(ExamRequestDetailsDto examRequestDetailsDto) throws DataAccessException;
  	
  	// method to populate ExamRequestDetailsDto data
  	public List<ExamRequestDetailsDto> getExamRequestDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException;
  	
  	// method to populate ExamRequestDetailsDto data
   	public List<ExamRequestDetailsDto> getExamRequestDetailsDtoListByStudentId(Integer id) throws DataAccessException;
   	
  	// method to populate ExamRequestDetailsDto by Id
    public ExamRequestDetailsDto findExamRequestDetailsById(Integer id) throws DataAccessException;
    
    // method to populate ExamRequestDetailsDto data
   	public List<ExamRequestDetailsDto> getExamRequestDetailsDtoListByStatus(Integer status, AdminDetailDto adminDetailDto) throws DataAccessException;
   	
   	
   	

   	// Result Details Dto
	public void saveandupdateResultDetailsDto(ResultDetailsDto resultDetailsDto) throws DataAccessException;
	
	public List<ResultDetailsDto> getResultDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException;
	
	public ResultDetailsDto getResultDetailsDtoById(Integer id) throws DataAccessException;
	
	public List<ResultDetailsDto> getResultDetailsDtoListByStudentId(Integer student_id) throws DataAccessException;
	
	public List<ResultDetailsDto> getResultDetailsDtoListByExamId(Integer exam_id, AdminDetailDto adminDetailDto) throws DataAccessException;
	
	public List<ResultDetailsDto> getResultDetailsDtoListByExamAndMonth(Integer exam_id, Integer month, AdminDetailDto adminDetailDto) throws DataAccessException;
	
	
	//Result Description Details
	public void saveandupdateResultDescriptionDto(ResultDescriptionDto resultDescriptionDto) throws DataAccessException;
	
	public List<ResultDescriptionDto> getResultDescriptionDtoByResultDetailsId(Integer result_details_id) throws DataAccessException;

	
	// Score Details Dto
	public void saveandupdateScoreGenerationDto(ScoreGenerationDto scoreGenerationDto) throws DataAccessException;
	
	public List<ScoreGenerationDto> getScoreGenerationDtoList() throws DataAccessException;
	
	public ScoreGenerationDto getScoreGenerationDtoById(Integer id) throws DataAccessException;
	
	public List<ScoreGenerationDto> getScoreGenerationDtoListByExamIdAndMonth(Integer exam_id, Integer month) throws DataAccessException;
	
	
	public List<ResultDetailsDto> getResultDetailsListbyCriteriaDetails(String fromDate, String toDate, String examId, String uniqueId, AdminDetailDto adminDetailsDto) throws DataAccessException;

	
	
	public List<MappedExamDetailsDto> getMappedExamDetailsDtoList() throws DataAccessException;
	
	public void saveandupdateMappedExamDetailsDto(MappedExamDetailsDto mappedExamDetailsDto) throws DataAccessException;
		
	public List<MappedExamDetailsDto> getMappedExamDetailsDtoListByStudentId(Integer student_id) throws DataAccessException;
		  
	public List<MappedExamDetailsDto> getMappedExamDetailsDtoListByExamId(Integer exam_id) throws DataAccessException;
	
	
	public List<ExaminationBatchMappingDto> findExaminationBatchMappingByBatch(Integer batch_id) throws Exception;
	public void deleteExaminationBatchMappingDetails(ExaminationBatchMappingDto examinationBatchMappingDto) throws Exception;	 
	public void saveExaminationBatchMappingDetails(ExaminationBatchMappingDto examinationBatchMappingDto) throws Exception;
		
}
