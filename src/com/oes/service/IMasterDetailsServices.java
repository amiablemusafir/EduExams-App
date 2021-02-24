package com.oes.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dto.BatchMasterDto;
import com.oes.dto.CategoryDetailsDto;
import com.oes.dto.ChangePasswordDto;
import com.oes.dto.ContentDetailsDto;
import com.oes.dto.CourseDetailsDto;
import com.oes.dto.DashBoardDto;
import com.oes.dto.InstituteDetailsDto;
import com.oes.dto.NotificationDetailsDto;
import com.oes.dto.ParagraphDetailsDto;
import com.oes.dto.SectionDetailsDto;
import com.oes.dto.SubCategoryDetailsDto;
import com.sms.admin.dto.AdminDetailDto;



public interface IMasterDetailsServices {
	
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<NotificationDetailsDto> getNotificationDetailsDtoList(Integer status) throws POLLINGBusinessException;
		
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<NotificationDetailsDto> getNotificationDetailsStudentDtoList(Integer student_id, Integer employee_id) throws POLLINGBusinessException;
	
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<CourseDetailsDto> getCourseDetailsDtoList(Integer userId) throws POLLINGBusinessException;
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<CourseDetailsDto> getCourseDetailsDtoList() throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateCourseDetailsDto(CourseDetailsDto courseDetailsDto) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<CourseDetailsDto> checkAvailCourseDetails(String course_Name) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public CourseDetailsDto findCourseDetailsById(Integer courseId) throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<SectionDetailsDto> getSectionDetailsDtoList() throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<SectionDetailsDto> getSectionDetailsDtoList(Integer user_id) throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateSectionDetailsDto(SectionDetailsDto sectionDetailsDto) throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public SectionDetailsDto findSectionDetailsById(Integer id) throws DataAccessException;
    
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<SectionDetailsDto> checkAvailSectionDetailsDto(String section_name) throws DataAccessException;
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<SectionDetailsDto> getSectionDetailsDtoListBySubCategoryId(Integer id) throws DataAccessException;
	
	
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<CategoryDetailsDto> getCategoryDetailsDtoList() throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<CategoryDetailsDto> getCategoryDetailsDtoList(Integer user_id) throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateCategoryDetailsDto(CategoryDetailsDto categoryDetailsDto) throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public CategoryDetailsDto findCategoryDetailsById(Integer id) throws DataAccessException;
    
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<CategoryDetailsDto> checkAvailCategoryDetailsDto(String category_name) throws DataAccessException;

	
	

	
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoList() throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoList(Integer user_id) throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateSubCategoryDetailsDto(SubCategoryDetailsDto subCategoryDetailsDto) throws DataAccessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public SubCategoryDetailsDto findSubCategoryDetailsById(Integer id) throws DataAccessException;
    
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<SubCategoryDetailsDto> checkAvailSubCategoryDetailsDto(String sub_category_name, Integer category_id) throws DataAccessException;
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoListByCategoryId(Integer id) throws DataAccessException;
	
	
	
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ParagraphDetailsDto> getParagraphDetailsDtoList() throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ParagraphDetailsDto> getParagraphDetailsDtoList(Integer user_id) throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateParagraphDetailsDto(ParagraphDetailsDto paragraphDetailsDto) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ParagraphDetailsDto> checkAvailParagraphDetails(String name) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public ParagraphDetailsDto findParagraphDetailsById(Integer id) throws POLLINGBusinessException;
	
	
	
	
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<DashBoardDto> getDashBoardDtoList() throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateDashBoardDto(DashBoardDto dto) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<DashBoardDto> checkAvailDashBoardDto(String name) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public DashBoardDto findDashBoardDtoById(Integer id) throws POLLINGBusinessException;
	
	
	
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ContentDetailsDto> getContentDetailsDtoList() throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateContentDetailsDto(ContentDetailsDto contentDetailsDto) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ContentDetailsDto> checkAvailContentDetails(String content_Name) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public ContentDetailsDto findContentDetailsById(Integer contentId) throws POLLINGBusinessException;
	
	
	
	
	
	
	
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ChangePasswordDto> getChangePasswordDtoList() throws POLLINGBusinessException;
	
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ChangePasswordDto> getChangePasswordDtoListByUserId(Integer id) throws POLLINGBusinessException;
				
				
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateChangePasswordDto(ChangePasswordDto changePasswordDto) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<ChangePasswordDto> checkAvailChangePasswordDto(String name) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public ChangePasswordDto findChangePasswordDtoById(Integer id) throws POLLINGBusinessException;

	
    
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
    public List<BatchMasterDto> getBatchMasterDtoList(AdminDetailDto adminDetailDto) throws POLLINGBusinessException;
 			
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
 	public void updateBatchMasterDto(BatchMasterDto batchMasterDto, AdminDetailDto adminDetailDto) throws POLLINGBusinessException;
 			
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
 	public BatchMasterDto findBatchMasterById(Integer batchMasterId, AdminDetailDto adminDetailDto) throws POLLINGBusinessException;
 		    
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
 	public List<BatchMasterDto> checkAvailBatchMaster(String batch_name, AdminDetailDto adminDetailDto) throws POLLINGBusinessException;
	
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<InstituteDetailsDto> getInstituteDetailsDtoList() throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateInstituteDetailsDto(InstituteDetailsDto instituteDetailsDto) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<InstituteDetailsDto> checkAvailInstituteDetails(String ins_Name) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public InstituteDetailsDto findInstituteDetailsById(Integer insId) throws POLLINGBusinessException;

}
