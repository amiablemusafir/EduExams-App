package com.oes.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

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


public interface IMasterDetailsDao {
	
			// method to populate NotificationDetailsDto data
			public List<NotificationDetailsDto> getNotificationDetailsDtoList(Integer status) throws DataAccessException;
	
			// method to populate NotificationDetailsDto data
			public List<NotificationDetailsDto> getNotificationDetailsStudentDtoList(Integer student_id, Integer employee_id) throws DataAccessException;
				
			// method to populate CourseDetailsDto data
			public List<CourseDetailsDto> getCourseDetailsDtoList(Integer userId) throws DataAccessException;
						
			// method to populate CourseDetailsDto data
			public List<CourseDetailsDto> getCourseDetailsDtoList() throws DataAccessException;
			
			//method to update CourseDetailsDto Data
			public void updateCourseDetailDto(CourseDetailsDto courseDetailsDto) throws DataAccessException;
			
			// method to populate CourseDetailsDto by Id
		    public CourseDetailsDto findCourseDetailsById(Integer courseDetailsId) throws DataAccessException;
		    
		    // method to populate CourseDetailsDto by name
		    public List<CourseDetailsDto> checkAvailCourseDetails(String course_name) throws DataAccessException;
			
		  
		    // method to populate SectionDetailsDto data
			public List<SectionDetailsDto> getSectionDetailsDtoList() throws DataAccessException;
			
			// method to populate SectionDetailsDto data
			public List<SectionDetailsDto> getSectionDetailsDtoList(Integer user_id) throws DataAccessException;
						
			//method to update SectionDetailsDto Data
			public void updateSectionDetailsDto(SectionDetailsDto sectionDetailsDto) throws DataAccessException;
			
			// method to populate SectionDetailsDto by Id
		    public SectionDetailsDto findSectionDetailsById(Integer id) throws DataAccessException;
		    
		    // method to populate SectionDetailsDto by name
		    public List<SectionDetailsDto> checkAvailSectionDetailsDto(String section_name) throws DataAccessException;
		 
		    // method to populate SectionDetailsDto data
		 	public List<SectionDetailsDto> getSectionDetailsDtoListBySubCategoryId(Integer id) throws DataAccessException;
		 			
		    
		    
		    
			// method to populate CategoryDetailsDto data
			public List<CategoryDetailsDto> getCategoryDetailsDtoList() throws DataAccessException;
			
			// method to populate CategoryDetailsDto data
			public List<CategoryDetailsDto> getCategoryDetailsDtoList(Integer user_id) throws DataAccessException;
						
			//method to update CategoryDetailsDto Data
			public void updateCategoryDetailsDto(CategoryDetailsDto categoryDetailsDto) throws DataAccessException;
				
			// method to populate CategoryDetailsDto by Id
			public CategoryDetailsDto findCategoryDetailsById(Integer id) throws DataAccessException;
			    
			// method to populate CategoryDetailsDto by name
			public List<CategoryDetailsDto> checkAvailCategoryDetailsDto(String category_name) throws DataAccessException;


			
			
			// method to populate CategoryDetailsDto data
			public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoList() throws DataAccessException;
			
			// method to populate CategoryDetailsDto data
			public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoList(Integer user_id) throws DataAccessException;
						
			//method to update CategoryDetailsDto Data
			public void updateSubCategoryDetailsDto(SubCategoryDetailsDto subCategoryDetailsDto) throws DataAccessException;
						
			// method to populate CategoryDetailsDto by Id
			public SubCategoryDetailsDto findSubCategoryDetailsById(Integer id) throws DataAccessException;
						    
			// method to populate CategoryDetailsDto by name
			public List<SubCategoryDetailsDto> checkAvailSubCategoryDetailsDto(String sub_category_name, Integer category_id) throws DataAccessException;
			
			// method to populate CategoryDetailsDto data
			public List<SubCategoryDetailsDto> getSubCategoryDetailsDtoListByCategoryId(Integer id) throws DataAccessException;
						
			
			
		    // method to populate ParagraphDetailsDto data
			public List<ParagraphDetailsDto> getParagraphDetailsDtoList() throws DataAccessException;
			
			// method to populate ParagraphDetailsDto data
			public List<ParagraphDetailsDto> getParagraphDetailsDtoList(Integer user_id) throws DataAccessException;
			
			//method to update ParagraphDetailsDto Data
			public void updateParagraphDetailsDto(ParagraphDetailsDto paragraphDetailsDto) throws DataAccessException;
			
			// method to populate ParagraphDetailsDto by Id
		    public ParagraphDetailsDto findParagraphDetailsById(Integer courseDetailsId) throws DataAccessException;
		    
		    // method to populate ParagraphDetailsDto by name
		    public List<ParagraphDetailsDto> checkAvailParagraphDetails(String course_name) throws DataAccessException;
		
		    
		    
		    // method to populate DashBoardDto data
			public List<DashBoardDto> getDashBoardDtoList() throws DataAccessException;
			
			//method to update DashBoardDto Data
			public void updateDashBoardDto(DashBoardDto dashBoardDto) throws DataAccessException;
			
			// method to populate DashBoardDto by Id
		    public DashBoardDto findDashBoardDtoById(Integer id) throws DataAccessException;
		    
		    // method to populate DashBoardDto by name
		    public List<DashBoardDto> checkAvailDashBoardDto(String name) throws DataAccessException;


		    
		    
			// method to populate ContentDetailsDto data
			public List<ContentDetailsDto> getContentDetailsDtoList() throws DataAccessException;
			
			//method to update ContentDetailsDto Data
			public void updateContentDetailDto(ContentDetailsDto contentDetailsDto) throws DataAccessException;
			
			// method to populate ContentDetailsDto by Id
		    public ContentDetailsDto findContentDetailsById(Integer contentDetailsId) throws DataAccessException;
		    
		    // method to populate ContentDetailsDto by name
		    public List<ContentDetailsDto> checkAvailContentDetails(String content_name) throws DataAccessException;

		    
		    
		    
			// method to populate ChangePasswordDto data
			public List<ChangePasswordDto> getChangePasswordDtoList() throws DataAccessException;
			
			// method to populate ChangePasswordDto data
			public List<ChangePasswordDto> getChangePasswordDtoListByUserId(Integer id) throws DataAccessException;
			
			//method to update ContentDetailsDto Data
			public void updateChangePasswordDto(ChangePasswordDto changePasswordDto) throws DataAccessException;
			
			// method to populate ChangePasswordDto by Id
		    public ChangePasswordDto findChangePasswordDtoById(Integer id) throws DataAccessException;
		    
		    // method to populate ContentDetailsDto by name
		    public List<ChangePasswordDto> checkAvailChangePasswordDto(String name) throws DataAccessException;

		    
		    // method to populate BatchMasterDto data
		    public List<BatchMasterDto> getBatchMasterDtoList(AdminDetailDto adminDetailDto) throws DataAccessException;
		 			
		 	//method to update BatchMasterDto Data
		 	public void updateBatchMasterDto(BatchMasterDto batchMasterDto, AdminDetailDto adminDetailDto) throws DataAccessException;
		 			
		 	// method to populate BatchMasterDto by Id
		 	public BatchMasterDto findBatchMasterById(Integer batchMasterId, AdminDetailDto adminDetailDto) throws DataAccessException;
		 		    
		 	// method to populate BatchMasterDto by name
		 	public List<BatchMasterDto> checkAvailBatchMaster(String batch_name, AdminDetailDto adminDetailDto) throws DataAccessException;
		 			
		 		  
		 		    	
		   // method to populate InstituteDetailsDto data
		   public List<InstituteDetailsDto> getInstituteDetailsDtoList() throws DataAccessException;
		 			
		   //method to update InstituteDetailsDto Data
		   public void updateInstituteDetailsDto(InstituteDetailsDto instituteDetailsDto) throws DataAccessException;
		 			
		   // method to populate InstituteDetailsDto by Id
		   public InstituteDetailsDto findInstituteDetailsById(Integer insDetailsId) throws DataAccessException;
		 		    
		   // method to populate InstituteDetailsDto by name
		   public List<InstituteDetailsDto> checkAvailInstituteDetails(String ins_name) throws DataAccessException;
		 			
		 		  
		 		 
}
