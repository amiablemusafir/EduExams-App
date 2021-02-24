package com.oes.service.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dao.IExaminationDetailsDao;
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
import com.oes.service.IExaminationDetailsServices;
import com.sms.admin.dao.ISqlHibernateCompatibleDao;
import com.sms.admin.dto.AdminDetailDto;
import com.sms.admin.dto.RolePermissionMasterDto;
import com.sms.common.exception.IHMSException;


public class ExaminationDetailsServicesImpl implements IExaminationDetailsServices {
	
	private IExaminationDetailsDao examinationDetailsDao;
	private ISqlHibernateCompatibleDao sqlHibernateCompatibleDao;

	public IExaminationDetailsDao getExaminationDetailsDao() {
		return examinationDetailsDao;
	}
	public void setExaminationDetailsDao(IExaminationDetailsDao examinationDetailsDao) {
		this.examinationDetailsDao = examinationDetailsDao;
	}

	public ISqlHibernateCompatibleDao getSqlHibernateCompatibleDao() {
		return sqlHibernateCompatibleDao;
	}

	public void setSqlHibernateCompatibleDao(ISqlHibernateCompatibleDao sqlHibernateCompatibleDao) {
		this.sqlHibernateCompatibleDao = sqlHibernateCompatibleDao;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public void saveandupdateExamDetailsDto(ExamDetailsDto examDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.getExaminationDetailsDao().saveandupdateExamDetailsDto(examDetailsDto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public List<ExamDetailsDto> getExamDetailsDtoList(AdminDetailDto adminDetailDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getExamDetailsDtoList(adminDetailDto);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public List<ExamDetailsDto> getActiveExamDetailsDtoList(AdminDetailDto adminDetailDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getActiveExamDetailsDtoList(adminDetailDto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public ExamDetailsDto findExamDetailsById(Integer examId) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().findExamDetailsById(examId);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public List<ExamDetailsDto> getExamDetailsDtoListByCourseId(Integer course_id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getExamDetailsDtoListByCourseId(course_id);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public List<ExamImageMasterDto> getExamImageMasterDtoList() throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getExamImageMasterDtoList();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public void saveandupdateStudentMappedExamDetailsDto(StudentMappedExamDetailsDto studentMappedExamDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.getExaminationDetailsDao().saveandupdateStudentMappedExamDetailsDto(studentMappedExamDetailsDto);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public List<StudentMappedExamDetailsDto> getStudentMappedExamDetailsDtoListByStudentId(Integer student_id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getStudentMappedExamDetailsDtoListByStudentId(student_id);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public List<StudentMappedExamDetailsDto> getStudentMappedExamDetailsDtoListByExamId(Integer exam_id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getStudentMappedExamDetailsDtoListByExamId(exam_id);
	}
	
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public void saveandupdateExamSectionDetailsDto(ExamSectionDetailsDto examSectionDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.getExaminationDetailsDao().saveandupdateExamSectionDetailsDto(examSectionDetailsDto);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public List<ExamSectionDetailsDto> getExamSectionDetailsDtoList() throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getExamSectionDetailsDtoList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public ExamSectionDetailsDto findExamSectionDetailsById(Integer examSectionId) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().findExamSectionDetailsById(examSectionId);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public List<ExamSectionDetailsDto> findExamSectionDetailsByExamId(Integer exam_Id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().findExamSectionDetailsByExamId(exam_Id);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public List<ExamSectionDetailsDto> findExamSectionDetailsByExamIdSectionId(Integer exam_id,Integer section_id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().findExamSectionDetailsByExamIdSectionId(exam_id, section_id);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public QuestionDetailsDto findQuestionDetailsDtoById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().findQuestionDetailsDtoById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public List<QuestionDetailsDto> getQuestionDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getQuestionDetailsDtoList(adminDetailDto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public void saveandupdateQuestionDetailsDto(QuestionDetailsDto questionDetailsDto) throws DataAccessException {
		// TODO Auto-generated method stub
		this.getExaminationDetailsDao().saveandupdateQuestionDetailsDto(questionDetailsDto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = POLLINGBusinessException.class)
	public List<QuestionDetailsDto> getQuestionDetailsDtoListByCretaria(String question, Integer section_id, AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getQuestionDetailsDtoListByCretaria(question, section_id, adminDetailDto);
	}

	@Override
	public List<QuestionDetailsDto> getQuestionDetailsDtoListBySectionId(Integer section_id, Integer status, AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getQuestionDetailsDtoListBySectionId(section_id, status, adminDetailDto);
	}

	@Override
	public List<QuestionDetailsDto> getQuestionDetailsDtoListBySecId(Integer section_id, AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getQuestionDetailsDtoListBySecId(section_id, adminDetailDto);
	}

	@Override
	public List<QuestionDetailsDto> getDuplicateQuestionDetailsDtoList(String question, Integer section_id, AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getDuplicateQuestionDetailsDtoList(question, section_id, adminDetailDto);
	}
	
	
	
	@Override
	public void saveandupdateExamQuestionDetailsDto(ExamQuestionDetailsDto examQuestionDetailsDto) throws DataAccessException {
		// TODO Auto-generated method stub
		this.getExaminationDetailsDao().saveandupdateExamQuestionDetailsDto(examQuestionDetailsDto);
	}
	
	@Override
	public List<ExamQuestionDetailsDto> getExamQuestionDetailsDtoListByExamId(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getExamQuestionDetailsDtoListByExamId(id);
	}

	@Override
	public void saveandupdateStudentExamDetailsDto(StudentExamDetailsDto studentExamDetailsDto) throws DataAccessException {
		// TODO Auto-generated method stub
		this.getExaminationDetailsDao().saveandupdateStudentExamDetailsDto(studentExamDetailsDto);
	}

	@Override
	public List<StudentExamDetailsDto> getStudentExamDetailsDtoList() throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getStudentExamDetailsDtoList();
	}

	@Override
	public StudentExamDetailsDto findStudentExamDetailsDtoById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().findStudentExamDetailsDtoById(id);
	}

	@Override
	public List<StudentExamDetailsDto> getStudentExamDetailsDtoListByExamId(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getStudentExamDetailsDtoListByExamId(id);
	}

	@Override
	public List<StudentExamDetailsDto> getStudentExamDetailsDtoListByStudentId(Integer exam_id, Integer student_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getStudentExamDetailsDtoListByStudentId(exam_id, student_id);
	}
	
	@Override
	public List<StudentExamDetailsDto> getStudentExamDetailsDtoListByStudentId(Integer student_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getStudentExamDetailsDtoListByStudentId(student_id);
	}
	
	@Override
	public void saveandupdateExamRequestDetailsDto(ExamRequestDetailsDto examRequestDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.getExaminationDetailsDao().saveandupdateExamRequestDetailsDto(examRequestDetailsDto);
	}

	@Override
	public List<ExamRequestDetailsDto> getExamRequestDetailsDtoList(AdminDetailDto adminDetailDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getExamRequestDetailsDtoList(adminDetailDto);
	}
	
	@Override
	public List<ExamRequestDetailsDto> getExamRequestDetailsDtoListByStudentId(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getExamRequestDetailsDtoListByStudentId(id);
	}

	@Override
	public ExamRequestDetailsDto findExamRequestDetailsById(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().findExamRequestDetailsById(id);
	}

	@Override
	public List<ExamRequestDetailsDto> getExamRequestDetailsDtoListByStatus(Integer status, AdminDetailDto adminDetailDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getExamRequestDetailsDtoListByStatus(status, adminDetailDto);
	}

	
	
	@Override
	public void saveandupdateResultDetailsDto(ResultDetailsDto resultDetailsDto) throws DataAccessException {
		// TODO Auto-generated method stub
		this.getExaminationDetailsDao().saveandupdateResultDetailsDto(resultDetailsDto);
	}

	@Override
	public List<ResultDetailsDto> getResultDetailsDtoList(AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getResultDetailsDtoList(adminDetailDto);
	}

	@Override
	public ResultDetailsDto getResultDetailsDtoById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getResultDetailsDtoById(id);
	}

	@Override
	public List<ResultDetailsDto> getResultDetailsDtoListByStudentId(Integer student_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getResultDetailsDtoListByStudentId(student_id);
	}

	@Override
	public List<ResultDetailsDto> getResultDetailsDtoListByExamId(Integer exam_id, AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getResultDetailsDtoListByExamId(exam_id, adminDetailDto);
	}
	
	@Override
	public List<ResultDetailsDto> getResultDetailsDtoListByExamAndMonth(Integer exam_id, Integer month, AdminDetailDto adminDetailDto) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getResultDetailsDtoListByExamAndMonth(exam_id, month, adminDetailDto);
	}


	@Override
	public void saveandupdateResultDescriptionDto(ResultDescriptionDto resultDescriptionDto) throws DataAccessException {
		// TODO Auto-generated method stub
		this.getExaminationDetailsDao().saveandupdateResultDescriptionDto(resultDescriptionDto);
	}

	@Override
	public List<ResultDescriptionDto> getResultDescriptionDtoByResultDetailsId(Integer result_details_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getResultDescriptionDtoByResultDetailsId(result_details_id);
	}

	@Override
	public void saveandupdateScoreGenerationDto(ScoreGenerationDto scoreGenerationDto) throws DataAccessException {
		// TODO Auto-generated method stub
		this.getExaminationDetailsDao().saveandupdateScoreGenerationDto(scoreGenerationDto);
	}

	@Override
	public List<ScoreGenerationDto> getScoreGenerationDtoList() throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getScoreGenerationDtoList();
	}

	@Override
	public ScoreGenerationDto getScoreGenerationDtoById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getScoreGenerationDtoById(id);
	}

	@Override
	public List<ScoreGenerationDto> getScoreGenerationDtoListByExamIdAndMonth(Integer exam_id, Integer month) throws DataAccessException {
		// TODO Auto-generated method stub
		return  this.getExaminationDetailsDao().getScoreGenerationDtoListByExamIdAndMonth(exam_id, month);
	}

	@Override
	public List<ResultDetailsDto> getResultDetailsListbyCriteriaDetails(String fromDate, String toDate, String examId, String uniqueId, AdminDetailDto adminDetailsDto) throws DataAccessException {
		// TODO Auto-generated method stub
		return  this.getExaminationDetailsDao().getResultDetailsListbyCriteriaDetails(fromDate, toDate, examId, uniqueId, adminDetailsDto);
	}
	
	
	@Override
	public List<MappedExamDetailsDto> getMappedExamDetailsDtoList() throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getMappedExamDetailsDtoList();
	}
	@Override
	public void saveandupdateMappedExamDetailsDto(MappedExamDetailsDto mappedExamDetailsDto) throws DataAccessException {
		// TODO Auto-generated method stub
		this.getExaminationDetailsDao().saveandupdateMappedExamDetailsDto(mappedExamDetailsDto);
	}
	@Override
	public List<MappedExamDetailsDto> getMappedExamDetailsDtoListByStudentId(Integer student_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getMappedExamDetailsDtoListByStudentId(student_id);
	}
	@Override
	public List<MappedExamDetailsDto> getMappedExamDetailsDtoListByExamId(Integer exam_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().getMappedExamDetailsDtoListByExamId(exam_id);
	}
	
	
	
	public List<ExaminationBatchMappingDto> findExaminationBatchMappingByBatch(Integer batch_id) throws Exception {
		// TODO Auto-generated method stub
		return this.getExaminationDetailsDao().findExaminationBatchMappingByBatch(batch_id);
	}

	public void deleteExaminationBatchMappingDtoDetails(ExaminationBatchMappingDto examinationBatchMappingDto) throws Exception {
		// TODO Auto-generated method stub		
		this.getExaminationDetailsDao().deleteExaminationBatchMappingDetails(examinationBatchMappingDto);
	}

    public void saveExaminationBatchMappingDtoDetails(ExaminationBatchMappingDto examinationBatchMappingDto) throws Exception {
		// TODO Auto-generated method stub		
    	this.getExaminationDetailsDao().saveExaminationBatchMappingDetails(examinationBatchMappingDto);
	}
    
    public List findLeftList(int searchId, Integer user_id) throws Exception {
		 System.out.println("findLeftList.......");
		return this.getSqlHibernateCompatibleDao().examNotInBatchExaminationMapping(searchId, user_id);
	}

	public List findRightList(int searchId, Integer user_id) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlHibernateCompatibleDao().examInBatchExaminationMapping(searchId, user_id);
	}
}
