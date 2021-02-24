package com.oes.service.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dao.IMasterDetailsDao;
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
import com.oes.service.IMasterDetailsServices;
import com.sms.admin.dto.AdminDetailDto;


public class MasterDetailsServicesImpl implements IMasterDetailsServices {
	
	private IMasterDetailsDao masterDetailsDao;

	public IMasterDetailsDao getMasterDetailsDao() {
		return masterDetailsDao;
	}

	public void setMasterDetailsDao(
			IMasterDetailsDao masterDetailsDao) {
		this.masterDetailsDao = masterDetailsDao;
	}

	public List<NotificationDetailsDto> getNotificationDetailsDtoList(Integer status) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getNotificationDetailsDtoList(status);
	}
	
	
	public List<NotificationDetailsDto> getNotificationDetailsStudentDtoList(Integer student_id, Integer employee_id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getNotificationDetailsStudentDtoList(student_id, employee_id);

	}
	
	public List<CourseDetailsDto> getCourseDetailsDtoList(Integer userId) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getCourseDetailsDtoList(userId);
	}	
	public List<CourseDetailsDto> getCourseDetailsDtoList() throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getCourseDetailsDtoList();
	}

	public void updateCourseDetailsDto(CourseDetailsDto courseDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.getMasterDetailsDao().updateCourseDetailDto(courseDetailsDto);
	}

	public List<CourseDetailsDto> checkAvailCourseDetails(String course_Name) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().checkAvailCourseDetails(course_Name);
		
	}

	public CourseDetailsDto findCourseDetailsById(Integer courseId) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().findCourseDetailsById(courseId);
	}

	@Override
	public List<SectionDetailsDto> checkAvailSectionDetailsDto(
			String sectionName) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().checkAvailSectionDetailsDto(sectionName);
	}

	@Override
	public SectionDetailsDto findSectionDetailsById(Integer id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().findSectionDetailsById(id);
	}

	@Override
	public List<SectionDetailsDto> getSectionDetailsDtoList()
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getSectionDetailsDtoList();
	}
	
	@Override
	public List<SectionDetailsDto> getSectionDetailsDtoList(Integer user_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getSectionDetailsDtoList(user_id);
	}

	@Override
	public void updateSectionDetailsDto(SectionDetailsDto sectionDetailsDto)
			throws DataAccessException {
		// TODO Auto-generated method stub
		this.getMasterDetailsDao().updateSectionDetailsDto(sectionDetailsDto);
	}
	
	@Override
	public List<SectionDetailsDto> getSectionDetailsDtoListBySubCategoryId(Integer id) 
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getSectionDetailsDtoListBySubCategoryId(id);
	}
	
	
	@Override
	public List<CategoryDetailsDto> checkAvailCategoryDetailsDto(
			String categoryName) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().checkAvailCategoryDetailsDto(categoryName);
	}

	@Override
	public CategoryDetailsDto findCategoryDetailsById(Integer id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().findCategoryDetailsById(id);
	}

	@Override
	public List<CategoryDetailsDto> getCategoryDetailsDtoList()
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getCategoryDetailsDtoList();
	}
	
	@Override
	public List<CategoryDetailsDto> getCategoryDetailsDtoList(Integer user_id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getCategoryDetailsDtoList(user_id);
	}

	@Override
	public void updateCategoryDetailsDto(CategoryDetailsDto categoryDetailsDto)
			throws DataAccessException {
		// TODO Auto-generated method stub
		this.getMasterDetailsDao().updateCategoryDetailsDto(categoryDetailsDto);
	}
	
	
	


	@Override
	public List<SubCategoryDetailsDto> checkAvailSubCategoryDetailsDto(
			String subcategoryName, Integer categoryId) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().checkAvailSubCategoryDetailsDto(subcategoryName, categoryId);
	}

	@Override
	public SubCategoryDetailsDto findSubCategoryDetailsById(Integer id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().findSubCategoryDetailsById(id);
	}

	@Override
	public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoList()
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getSubCategoryDetailsDtoList();
	}
	
	@Override
	public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoList(Integer user_id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getSubCategoryDetailsDtoList(user_id);
	}

	@Override
	public void updateSubCategoryDetailsDto(SubCategoryDetailsDto subCategoryDetailsDto)
			throws DataAccessException {
		// TODO Auto-generated method stub
		this.getMasterDetailsDao().updateSubCategoryDetailsDto(subCategoryDetailsDto);
	}
	
	@Override
	public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoListByCategoryId(Integer id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getSubCategoryDetailsDtoListByCategoryId(id);
	}
	
	
	
	public List<ParagraphDetailsDto> getParagraphDetailsDtoList() throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getParagraphDetailsDtoList();
	}
	
	public List<ParagraphDetailsDto> getParagraphDetailsDtoList(Integer user_id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getParagraphDetailsDtoList(user_id);
	}

	public void updateParagraphDetailsDto(ParagraphDetailsDto paragraphDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.getMasterDetailsDao().updateParagraphDetailsDto(paragraphDetailsDto);
	}

	public List<ParagraphDetailsDto> checkAvailParagraphDetails(String name) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().checkAvailParagraphDetails(name);
		
	}
	public ParagraphDetailsDto findParagraphDetailsById(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().findParagraphDetailsById(id);
	}
	
	
	
	
	public List<DashBoardDto> getDashBoardDtoList() throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getDashBoardDtoList();
	}

	public void updateDashBoardDto(DashBoardDto dashBoardDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.getMasterDetailsDao().updateDashBoardDto(dashBoardDto);
	}

	public List<DashBoardDto> checkAvailDashBoardDto(String name) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().checkAvailDashBoardDto(name);
		
	}
	public DashBoardDto findDashBoardDtoById(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().findDashBoardDtoById(id);
	}

	
	
	public List<ContentDetailsDto> getContentDetailsDtoList() throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getContentDetailsDtoList();
	}

	public void updateContentDetailsDto(ContentDetailsDto contentDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.getMasterDetailsDao().updateContentDetailDto(contentDetailsDto);
	}

	public List<ContentDetailsDto> checkAvailContentDetails(String content_Name) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().checkAvailContentDetails(content_Name);
		
	}

	public ContentDetailsDto findContentDetailsById(Integer contentId) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().findContentDetailsById(contentId);
	}

	
	
	
	
	@Override
	public List<ChangePasswordDto> getChangePasswordDtoList() throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getChangePasswordDtoList();
	}
	
	@Override
	public List<ChangePasswordDto> getChangePasswordDtoListByUserId(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getChangePasswordDtoListByUserId(id);
	}

	@Override
	public void updateChangePasswordDto(ChangePasswordDto changePasswordDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.getMasterDetailsDao().updateChangePasswordDto(changePasswordDto);
	}

	@Override
	public List<ChangePasswordDto> checkAvailChangePasswordDto(String name) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().checkAvailChangePasswordDto(name);
	}

	@Override
	public ChangePasswordDto findChangePasswordDtoById(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().findChangePasswordDtoById(id);
	}

	
	
	@Override
	public List<BatchMasterDto> getBatchMasterDtoList(AdminDetailDto adminDetailDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getBatchMasterDtoList(adminDetailDto);
	}

	@Override
	public void updateBatchMasterDto(BatchMasterDto batchMasterDto, AdminDetailDto adminDetailDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.getMasterDetailsDao().updateBatchMasterDto(batchMasterDto, adminDetailDto);
	}

	@Override
	public BatchMasterDto findBatchMasterById(Integer batchMasterId, AdminDetailDto adminDetailDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().findBatchMasterById(batchMasterId, adminDetailDto);
	}

	@Override
	public List<BatchMasterDto> checkAvailBatchMaster(String batch_name, AdminDetailDto adminDetailDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().checkAvailBatchMaster(batch_name, adminDetailDto);
	}
	
	
	public List<InstituteDetailsDto> getInstituteDetailsDtoList() throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().getInstituteDetailsDtoList();
	}

	public void updateInstituteDetailsDto(InstituteDetailsDto instituteDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.getMasterDetailsDao().updateInstituteDetailsDto(instituteDetailsDto);
	}

	public List<InstituteDetailsDto> checkAvailInstituteDetails(String ins_Name) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().checkAvailInstituteDetails(ins_Name);
		
	}

	public InstituteDetailsDto findInstituteDetailsById(Integer insId) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getMasterDetailsDao().findInstituteDetailsById(insId);
	}

}
