package com.oes.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.oes.dto.NoticeDto;
import com.sms.admin.dto.AdminDetailDto;

public interface INoticeDao {
	
	        // method to populate NewsAndEventsDto data
			public List<NoticeDto> getNoticeDto(AdminDetailDto adminDetailDto) throws DataAccessException;
			
			// method to populate NewsAndEventsDto data
			public List<NoticeDto> getNoticeDtoForStudent(AdminDetailDto adminDetailDto) throws DataAccessException;
						
			//method to update NewsAndEventsDto Data
			public void updateNoticeDto(NoticeDto noticeDto) throws DataAccessException;
			
			// method to populate NewsAndEventsDto by Id
		    public NoticeDto findNoticeById(Integer noticeId) throws DataAccessException;
		    
		    public List<NoticeDto> checkAvailNotice(String notice) throws DataAccessException;
			
		  	
}
