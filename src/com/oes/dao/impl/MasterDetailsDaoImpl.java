package com.oes.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

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
import com.sms.admin.dto.AdminDetailDto;


public class MasterDetailsDaoImpl implements IMasterDetailsDao {

	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	@Override
	public List<NotificationDetailsDto> getNotificationDetailsDtoList(Integer status) throws DataAccessException {
		String queryDetails="";
		if(status.equals(1)) {
			//Superadmin	
			queryDetails="from NotificationDetailsDto as details where details.onum_is_active=1 and details.ostr_status in('4', '1') ORDER BY details.odt_entry_date DESC";
		} else if(status.equals(2)) {
			//Employee
			queryDetails="from NotificationDetailsDto as details where details.onum_is_active=1 and details.ostr_status in('3', '1') ORDER BY details.odt_entry_date DESC";
		}
		return this.hibernateTemplate.find(queryDetails);
	}
		
	@Override
	public List<NotificationDetailsDto> getNotificationDetailsStudentDtoList(Integer student_id, Integer employee_id) throws DataAccessException {
		 String queryDetails ="from NotificationDetailsDto as details where details.onum_is_active=1 and details.studentsDetailDto.inum_user_id="+student_id+" and details.adminDetailDto.inum_user_id="+employee_id+" OR details.ostr_status in(2, 1) ORDER BY details.odt_entry_date DESC";
		return this.hibernateTemplate.find(queryDetails);
	}			
				
	@Override
	public List<CourseDetailsDto> getCourseDetailsDtoList(Integer userId) throws DataAccessException {
		String courseDetails="from CourseDetailsDto as details where details.onum_is_active=1 and details.adminDetailDto.inum_user_id = "+userId;
		return this.hibernateTemplate.find(courseDetails);
	}
	
	@Override
	public List<CourseDetailsDto> getCourseDetailsDtoList() throws DataAccessException {
		String courseDetails="from CourseDetailsDto as details where details.onum_is_active=1";
		return this.hibernateTemplate.find(courseDetails);
	}

	@Override
	public void updateCourseDetailDto(CourseDetailsDto courseDetailsDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(courseDetailsDto);
		
	}

	@Override
	public CourseDetailsDto findCourseDetailsById(Integer courseDetailsId) throws DataAccessException {
		try {
			CourseDetailsDto courseDetailsDto = (CourseDetailsDto) this.getHibernateTemplate().get("com.oes.dto.CourseDetailsDto",courseDetailsId);
			return courseDetailsDto;
		  }
		catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<CourseDetailsDto> checkAvailCourseDetails(String course_name) throws DataAccessException {
		String courseDetails="from CourseDetailsDto as details where details.ostr_course_name='"+course_name+"' and details.onum_is_active=1";
		return this.hibernateTemplate.find(courseDetails);
	}
	
	
	
	
	@Override
	public List<SectionDetailsDto> getSectionDetailsDtoList() throws DataAccessException {
		String sectionDetails="from SectionDetailsDto as details where details.onum_is_active=1";
		return this.hibernateTemplate.find(sectionDetails);
	}
	
	@Override
	public List<SectionDetailsDto> getSectionDetailsDtoList(Integer user_id) throws DataAccessException {
		String sectionDetails="from SectionDetailsDto as details where details.onum_is_active=1 and details.adminDetailDto.inum_user_id = "+user_id;
		return this.hibernateTemplate.find(sectionDetails);
	}

	@Override
	public void updateSectionDetailsDto(SectionDetailsDto sectionDetailsDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(sectionDetailsDto);
		
	}

	@Override
	public SectionDetailsDto findSectionDetailsById(Integer id) throws DataAccessException {
		try {
			SectionDetailsDto sectionDetailsDto = (SectionDetailsDto) this.getHibernateTemplate().get("com.oes.dto.SectionDetailsDto",id);
			return sectionDetailsDto;
		  }
		catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<SectionDetailsDto> checkAvailSectionDetailsDto(String section_name) throws DataAccessException {
		String sectionDetails="from SectionDetailsDto as details where details.ostr_section_name='"+section_name+"' and details.onum_is_active=1";
		return this.hibernateTemplate.find(sectionDetails);
	}
	
	@Override
	public List<SectionDetailsDto> getSectionDetailsDtoListBySubCategoryId(Integer id) throws DataAccessException {
		String sectionDetails="from SectionDetailsDto as details where details.onum_is_active=1 and details.subCategoryDetailsDto.onum_slno = "+id;
		return this.hibernateTemplate.find(sectionDetails);
	}

	
	
	
	
	
	@Override
	public List<CategoryDetailsDto> getCategoryDetailsDtoList() throws DataAccessException {
		String categoryDetails="from CategoryDetailsDto as details where details.onum_is_active=1";
		return this.hibernateTemplate.find(categoryDetails);
	}
	
	@Override
	public List<CategoryDetailsDto> getCategoryDetailsDtoList(Integer user_id) throws DataAccessException {
		String categoryDetails="from CategoryDetailsDto as details where details.onum_is_active=1 and details.adminDetailDto.inum_user_id = "+user_id;
		return this.hibernateTemplate.find(categoryDetails);
	}

	@Override
	public void updateCategoryDetailsDto(CategoryDetailsDto categoryDetailsDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(categoryDetailsDto);
		
	}

	@Override
	public CategoryDetailsDto findCategoryDetailsById(Integer id) throws DataAccessException {
		try {
			CategoryDetailsDto categoryDetailsDto = (CategoryDetailsDto) this.getHibernateTemplate().get("com.oes.dto.CategoryDetailsDto",id);
			return categoryDetailsDto;
		  }
		catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<CategoryDetailsDto> checkAvailCategoryDetailsDto(String category_name) throws DataAccessException {
		String categoryDetails="from CategoryDetailsDto as details where details.ostr_category_name='"+category_name+"' and details.onum_is_active=1";
		return this.hibernateTemplate.find(categoryDetails);
	}
	
	
	
	
	@Override
	public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoList() throws DataAccessException {
		String categoryDetails="from SubCategoryDetailsDto as details where details.onum_is_active=1";
		return this.hibernateTemplate.find(categoryDetails);
	}
	
	@Override
	public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoList(Integer user_id) throws DataAccessException {
		String categoryDetails="from SubCategoryDetailsDto as details where details.onum_is_active=1 and details.adminDetailDto.inum_user_id = "+user_id;
		return this.hibernateTemplate.find(categoryDetails);
	}

	@Override
	public void updateSubCategoryDetailsDto(SubCategoryDetailsDto subCategoryDetailsDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(subCategoryDetailsDto);
		
	}

	@Override
	public SubCategoryDetailsDto findSubCategoryDetailsById(Integer id) throws DataAccessException {
		try {
			SubCategoryDetailsDto subCategoryDetailsDto = (SubCategoryDetailsDto) this.getHibernateTemplate().get("com.oes.dto.SubCategoryDetailsDto",id);
			return subCategoryDetailsDto;
		  }
		catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<SubCategoryDetailsDto> checkAvailSubCategoryDetailsDto(String sub_category_name, Integer category_id) throws DataAccessException {
		String subCategoryDetails="from SubCategoryDetailsDto as details where details.ostr_sub_category_name='"+sub_category_name+"' and  details.categoryDetailsDto.onum_slno = "+category_id+" and details.onum_is_active=1";
		return this.hibernateTemplate.find(subCategoryDetails);
	}
	
	@Override
	public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoListByCategoryId(Integer id) throws DataAccessException {
		String categoryDetails="from SubCategoryDetailsDto as details where details.onum_is_active=1 and details.categoryDetailsDto.onum_slno = "+id;
		return this.hibernateTemplate.find(categoryDetails);
	}

	
	
	@Override
	public List<ParagraphDetailsDto> getParagraphDetailsDtoList() throws DataAccessException {
		String courseDetails="from ParagraphDetailsDto as details where details.onum_is_active=1";
		return this.hibernateTemplate.find(courseDetails);
	}
	
	@Override
	public List<ParagraphDetailsDto> getParagraphDetailsDtoList(Integer user_id) throws DataAccessException {
		String courseDetails="from ParagraphDetailsDto as details where details.onum_is_active=1 and details.adminDetailDto.inum_user_id = "+user_id;
		return this.hibernateTemplate.find(courseDetails);
	}
	
	@Override
	public void updateParagraphDetailsDto(ParagraphDetailsDto paragraphDetailsDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(paragraphDetailsDto);
		
	}

	@Override
	public ParagraphDetailsDto findParagraphDetailsById(Integer paragraphDetailsId) throws DataAccessException {
		try {
			ParagraphDetailsDto paragraphDetailsDto = (ParagraphDetailsDto) this.getHibernateTemplate().get("com.oes.dto.ParagraphDetailsDto", paragraphDetailsId);
			return paragraphDetailsDto;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<ParagraphDetailsDto> checkAvailParagraphDetails(String name) throws DataAccessException {
		String courseDetails="from ParagraphDetailsDto as details where details.ostr_paragraph_name='"+name+"' and details.onum_is_active=1";
		return this.hibernateTemplate.find(courseDetails);
	}
	
	
	
	
	
	
	@Override
	public List<DashBoardDto> getDashBoardDtoList() throws DataAccessException {
		String details="from DashBoardDto as details where details.onum_is_active=1";
		return this.hibernateTemplate.find(details);
	}

	
	@Override
	public void updateDashBoardDto(DashBoardDto dto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(dto);
		
	}

	@Override
	public DashBoardDto findDashBoardDtoById(Integer id) throws DataAccessException {
		try {
			DashBoardDto dashBoardDto = (DashBoardDto) this.getHibernateTemplate().get("com.oes.dto.DashBoardDto", id);
			return dashBoardDto;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<DashBoardDto> checkAvailDashBoardDto(String name) throws DataAccessException {
		String details="from DashBoardDto as details where details.ostr_dashboard = '"+name+"' and details.onum_is_active=1";
		return this.hibernateTemplate.find(details);
	}
	
	
	
	
	@Override
	public List<ContentDetailsDto> getContentDetailsDtoList() throws DataAccessException {
		String courseDetails="from ContentDetailsDto as details where details.onum_is_active=1";
		return this.hibernateTemplate.find(courseDetails);
	}

	@Override
	public void updateContentDetailDto(ContentDetailsDto contentDetailsDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(contentDetailsDto);
		
	}

	@Override
	public ContentDetailsDto findContentDetailsById(Integer contentDetailsId) throws DataAccessException {
		try {
			ContentDetailsDto courseDetailsDto = (ContentDetailsDto) this.getHibernateTemplate().get("com.oes.dto.ContentDetailsDto",contentDetailsId);
			return courseDetailsDto;
		  }
		catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<ContentDetailsDto> checkAvailContentDetails(String content_name) throws DataAccessException {
		String courseDetails="from ContentDetailsDto as details where details.ostr_content_name='"+content_name+"' and details.onum_is_active=1";
		return this.hibernateTemplate.find(courseDetails);
	}
	
	

	
	@Override
	public List<ChangePasswordDto> getChangePasswordDtoList() throws DataAccessException {
		String courseDetails="from ChangePasswordDto as details where details.onum_is_active = 1";
		return this.hibernateTemplate.find(courseDetails);
	}

	@Override
	public List<ChangePasswordDto> getChangePasswordDtoListByUserId(Integer id) throws DataAccessException {
		String courseDetails="from ChangePasswordDto as details where details.onum_is_active = 1 and details.adminDetailDto.inum_user_id = "+id;
		return this.hibernateTemplate.find(courseDetails);
	}

	@Override
	public void updateChangePasswordDto(ChangePasswordDto changePasswordDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(changePasswordDto);
		
	}

	@Override
	public ChangePasswordDto findChangePasswordDtoById(Integer id) throws DataAccessException {
		try {
			ChangePasswordDto changePasswordDto = (ChangePasswordDto) this.getHibernateTemplate().get("com.oes.dto.ChangePasswordDto",id);
			return changePasswordDto;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	
	@Override
	public List<ChangePasswordDto> checkAvailChangePasswordDto(String name) throws DataAccessException {
		String courseDetails="from ChangePasswordDto as details where details.ostr_link = '"+name+"' and details.onum_is_active = 1";
		return this.hibernateTemplate.find(courseDetails);
	}
	
	
	
	@Override
	public List<BatchMasterDto> getBatchMasterDtoList(AdminDetailDto adminDetailDto) throws DataAccessException {
		String batchMaster="from BatchMasterDto as details where details.onum_is_active=1 and details.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id();
		return this.hibernateTemplate.find(batchMaster);
	}

	@Override
	public void updateBatchMasterDto(BatchMasterDto batchMasterDto, AdminDetailDto adminDetailDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(batchMasterDto);		
	}

	@Override
	public BatchMasterDto findBatchMasterById(Integer batchMasterId, AdminDetailDto adminDetailDto) throws DataAccessException {
		try {
			BatchMasterDto batchMasterDto = (BatchMasterDto) this.getHibernateTemplate().get("com.oes.dto.BatchMasterDto",batchMasterId);
			return batchMasterDto;
		  }
		catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<BatchMasterDto> checkAvailBatchMaster(String batch_name, AdminDetailDto adminDetailDto) throws DataAccessException {
		String batchMaster="from BatchMasterDto as details where details.ostr_batch_name='"+batch_name+"' and details.onum_is_active=1 and details.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id();
		return this.hibernateTemplate.find(batchMaster);
	}
	
	
	
	
	@Override
	public List<InstituteDetailsDto> getInstituteDetailsDtoList() throws DataAccessException {
		String insDetails="from InstituteDetailsDto as details where details.onum_is_active=1";
		return this.hibernateTemplate.find(insDetails);
	}

	@Override
	public void updateInstituteDetailsDto(InstituteDetailsDto instituteDetailsDto) throws DataAccessException {
		this.hibernateTemplate.saveOrUpdate(instituteDetailsDto);
		
	}

	@Override
	public InstituteDetailsDto findInstituteDetailsById(Integer insDetailsId) throws DataAccessException {
		try {
			InstituteDetailsDto instituteDetailsDto = (InstituteDetailsDto) this.getHibernateTemplate().get("com.oes.dto.InstituteDetailsDto",insDetailsId);
			return instituteDetailsDto;
		  }
		catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<InstituteDetailsDto> checkAvailInstituteDetails(String ins_name) throws DataAccessException {
		String insDetails="from InstituteDetailsDto as details where details.ostr_institute_name='"+ins_name+"' and details.onum_is_active=1";
		return this.hibernateTemplate.find(insDetails);
	}
}
