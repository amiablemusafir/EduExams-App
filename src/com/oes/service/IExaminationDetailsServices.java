package com.oes.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oes.common.exception.POLLINGBusinessException;
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
import com.oes.dto.StudentExamDetailsDto;
import com.oes.dto.StudentMappedExamDetailsDto;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.dto.RolePermissionMasterDto;
import com.sms.common.exception.IHMSException;


public interface IExaminationDetailsServices {
	
	//for Exam Details Dto
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void saveandupdateExamDetailsDto(ExamDetailsDto examDetailsDto) throws POLLINGBusinessException;
	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ExamDetailsDto> getExamDetailsDtoList(AdminDetailDto adminDetailDto) throws POLLINGBusinessException;
    
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ExamDetailsDto> getActiveExamDetailsDtoList(AdminDetailDto adminDetailDto) throws POLLINGBusinessException;

    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public ExamDetailsDto findExamDetailsById(Integer examId) throws POLLINGBusinessException;
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ExamDetailsDto> getExamDetailsDtoListByCourseId(Integer course_id) throws POLLINGBusinessException;

    
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ExamImageMasterDto> getExamImageMasterDtoList() throws POLLINGBusinessException;
    
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public void saveandupdateStudentMappedExamDetailsDto(StudentMappedExamDetailsDto studentMappedExamDetailsDto) throws POLLINGBusinessException;
	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<StudentMappedExamDetailsDto> getStudentMappedExamDetailsDtoListByStudentId(Integer student_id) throws POLLINGBusinessException;
	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<StudentMappedExamDetailsDto> getStudentMappedExamDetailsDtoListByExamId(Integer exam_id) throws POLLINGBusinessException;
	
    
    //>>>>>>>>>>>>>>EXAM SECTION>>>>>>>>>>>>>>>>>
    
  
    //for Exam Section Details Dto
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void saveandupdateExamSectionDetailsDto(ExamSectionDetailsDto examSectionDetailsDto) throws POLLINGBusinessException;
    
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ExamSectionDetailsDto> getExamSectionDetailsDtoList() throws POLLINGBusinessException;
    
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public ExamSectionDetailsDto findExamSectionDetailsById(Integer examSectionId) throws POLLINGBusinessException;
    
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ExamSectionDetailsDto> findExamSectionDetailsByExamId(Integer exam_Id) throws POLLINGBusinessException;
    
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<ExamSectionDetailsDto> findExamSectionDetailsByExamIdSectionId(Integer exam_id,Integer section_id) throws POLLINGBusinessException;
    	
    //>>>>>>>>>>>>>>>>>>>>>>>for CREATE QUESTION >>>>>>>>>>>>>>>>>>>
	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
  	public void saveandupdateQuestionDetailsDto(QuestionDetailsDto questionDetailsDto) throws DataAccessException;
	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
  	public List<QuestionDetailsDto> getQuestionDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException;
  	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public QuestionDetailsDto findQuestionDetailsDtoById(Integer id) throws DataAccessException;
   
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<QuestionDetailsDto> getQuestionDetailsDtoListByCretaria(String question, Integer section_id, AdminDetailDto adminDetailDto) throws DataAccessException;
  	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<QuestionDetailsDto> getQuestionDetailsDtoListBySectionId(Integer section_id, Integer status, AdminDetailDto adminDetailDto) throws DataAccessException;
    
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<QuestionDetailsDto> getQuestionDetailsDtoListBySecId(Integer section_id, AdminDetailDto adminDetailDto) throws DataAccessException;

    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<QuestionDetailsDto> getDuplicateQuestionDetailsDtoList(String question, Integer section_id, AdminDetailDto adminDetailDto) throws DataAccessException;
    //>>>>>>>>>>>>>>>>>>>>>>>for CREATE QUESTION Set>>>>>>>>>>>>>>>>>>>
	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
  	public void saveandupdateExamQuestionDetailsDto(ExamQuestionDetailsDto examQuestionDetailsDto) throws DataAccessException;

    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<ExamQuestionDetailsDto> getExamQuestionDetailsDtoListByExamId(Integer id) throws DataAccessException;

    
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public void saveandupdateStudentExamDetailsDto(StudentExamDetailsDto studentExamDetailsDto) throws DataAccessException;
  	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<StudentExamDetailsDto> getStudentExamDetailsDtoList() throws DataAccessException;
  	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public StudentExamDetailsDto findStudentExamDetailsDtoById(Integer id) throws DataAccessException;
  	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<StudentExamDetailsDto> getStudentExamDetailsDtoListByExamId(Integer id) throws DataAccessException;
   
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<StudentExamDetailsDto> getStudentExamDetailsDtoListByStudentId(Integer exam_id, Integer student_id) throws DataAccessException;
    
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<StudentExamDetailsDto> getStudentExamDetailsDtoListByStudentId(Integer student_id) throws DataAccessException;

    
    //for Exam Request Details Dto
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void saveandupdateExamRequestDetailsDto(ExamRequestDetailsDto examRequestDetailsDto) throws POLLINGBusinessException;
	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ExamRequestDetailsDto> getExamRequestDetailsDtoListByStudentId(Integer id) throws POLLINGBusinessException;

    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ExamRequestDetailsDto> getExamRequestDetailsDtoList(AdminDetailDto adminDetailDto) throws POLLINGBusinessException;

    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public ExamRequestDetailsDto findExamRequestDetailsById(Integer id) throws POLLINGBusinessException;
 
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ExamRequestDetailsDto> getExamRequestDetailsDtoListByStatus(Integer status, AdminDetailDto adminDetailDto) throws POLLINGBusinessException;
    
    
    // Result Details Dto
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
 	public void saveandupdateResultDetailsDto(ResultDetailsDto resultDetailsDto) throws DataAccessException;
 	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
 	public List<ResultDetailsDto> getResultDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException;
 	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
 	public ResultDetailsDto getResultDetailsDtoById(Integer id) throws DataAccessException;
 	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
 	public List<ResultDetailsDto> getResultDetailsDtoListByStudentId(Integer student_id) throws DataAccessException;
 	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
 	public List<ResultDetailsDto> getResultDetailsDtoListByExamId(Integer exam_id, AdminDetailDto adminDetailDto) throws DataAccessException;
 	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
 	public List<ResultDetailsDto> getResultDetailsDtoListByExamAndMonth(Integer exam_id, Integer month, AdminDetailDto adminDetailDto) throws DataAccessException;
 	
 
 	
 	//Result Description Details
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public void saveandupdateResultDescriptionDto(ResultDescriptionDto resultDescriptionDto) throws DataAccessException;
 	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
 	public List<ResultDescriptionDto> getResultDescriptionDtoByResultDetailsId(Integer result_details_id) throws DataAccessException;

    
	// Score Details Dto
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void saveandupdateScoreGenerationDto(ScoreGenerationDto scoreGenerationDto) throws DataAccessException;
	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ScoreGenerationDto> getScoreGenerationDtoList() throws DataAccessException;
	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public ScoreGenerationDto getScoreGenerationDtoById(Integer id) throws DataAccessException;
	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ScoreGenerationDto> getScoreGenerationDtoListByExamIdAndMonth(Integer exam_id, Integer month) throws DataAccessException;

    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<ResultDetailsDto> getResultDetailsListbyCriteriaDetails(String fromDate, String toDate, String examId, String uniqueId, AdminDetailDto adminDetailsDto) throws DataAccessException;
    
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<MappedExamDetailsDto> getMappedExamDetailsDtoList() throws DataAccessException;
	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void saveandupdateMappedExamDetailsDto(MappedExamDetailsDto studentMappedExamDetailsDto) throws DataAccessException;
	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<MappedExamDetailsDto> getMappedExamDetailsDtoListByStudentId(Integer student_id) throws DataAccessException;
	
    @Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<MappedExamDetailsDto> getMappedExamDetailsDtoListByExamId(Integer exam_id) throws DataAccessException;
	
    
    //Used for batch and examination mapping
    public List findLeftList(int searchId, Integer user_id) throws Exception;
	public List findRightList(int searchId, Integer user_id) throws Exception;
	public List<ExaminationBatchMappingDto> findExaminationBatchMappingByBatch(Integer batch_id) throws Exception;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public void deleteExaminationBatchMappingDtoDetails(ExaminationBatchMappingDto examinationBatchMappingDto) throws Exception;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = IHMSException.class
	)
	public void saveExaminationBatchMappingDtoDetails(ExaminationBatchMappingDto examinationBatchMappingDto) throws Exception;
	
}
