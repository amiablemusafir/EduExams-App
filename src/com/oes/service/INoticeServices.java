package com.oes.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dto.NoticeDto;
import com.sms.admin.dto.AdminDetailDto;

public interface INoticeServices {
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<NoticeDto> getNoticeDto(AdminDetailDto adminDetailDto) throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<NoticeDto> getNoticeDtoForStudent(AdminDetailDto adminDetailDto) throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateNoticeDto(NoticeDto noticeDto) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<NoticeDto> checkAvailNotice(String notice) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public NoticeDto findNoticeById(Integer noticeId) throws POLLINGBusinessException;
}
