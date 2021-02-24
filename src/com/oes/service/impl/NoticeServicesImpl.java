package com.oes.service.impl;

import java.util.List;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dao.INoticeDao;
import com.oes.dto.NoticeDto;
import com.oes.service.INoticeServices;
import com.sms.admin.dto.AdminDetailDto;

public class NoticeServicesImpl implements INoticeServices {

	
	private INoticeDao noticeDao;

	public INoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(INoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	public List<NoticeDto> getNoticeDto(AdminDetailDto adminDetailDto)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getNoticeDao().getNoticeDto(adminDetailDto);
	}
	
	public List<NoticeDto> getNoticeDtoForStudent(AdminDetailDto adminDetailDto)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getNoticeDao().getNoticeDtoForStudent(adminDetailDto);
	}

	
	public void updateNoticeDto(NoticeDto noticeDto)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub	
		this.getNoticeDao().updateNoticeDto(noticeDto);
		
	}
	
	public NoticeDto findNoticeById(Integer noticeId)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getNoticeDao().findNoticeById(noticeId);
	}

	public List<NoticeDto> checkAvailNotice(String notice)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getNoticeDao().checkAvailNotice(notice);
	}

		
}
