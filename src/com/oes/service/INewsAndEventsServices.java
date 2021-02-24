package com.oes.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dto.NewsAndEventsDto;

public interface INewsAndEventsServices {

	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<NewsAndEventsDto> getNewsAndEventsDto(NewsAndEventsDto newsAndEventsDto) throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateNewsAndEventsDto(NewsAndEventsDto newsAndEventsDto) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<NewsAndEventsDto> checkAvailNewsAndEvents(String rolename) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public NewsAndEventsDto findNewsAndEventsById(Integer newsAndEventsId) throws POLLINGBusinessException;
	
}
