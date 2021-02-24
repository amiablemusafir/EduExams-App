package com.oes.service.impl;

import java.util.List;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dao.INewsAndEventsDao;
import com.oes.dto.NewsAndEventsDto;
import com.oes.service.INewsAndEventsServices;
import com.oes.service.INewsAndEventsServices;



public class NewsAndEventsServicesImpl implements INewsAndEventsServices {
	
	private INewsAndEventsDao newsAndEventsDao;

	public INewsAndEventsDao getNewsAndEventsDao() {
		return newsAndEventsDao;
	}

	public void setNewsAndEventsDao(INewsAndEventsDao newsAndEventsDao) {
		this.newsAndEventsDao = newsAndEventsDao;
	}
	
	public List<NewsAndEventsDto> getNewsAndEventsDto(NewsAndEventsDto newsAndEventsDto)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getNewsAndEventsDao().getNewsAndEventsDto(newsAndEventsDto);
	}

	
	public void updateNewsAndEventsDto(NewsAndEventsDto newsAndEventsDto)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub	
		this.getNewsAndEventsDao().updateNewsAndEventsDto(newsAndEventsDto);
		
	}
	
	public NewsAndEventsDto findNewsAndEventsById(Integer newsAndEventsId)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getNewsAndEventsDao().findNewsAndEventsById(newsAndEventsId);
	}

	public List<NewsAndEventsDto> checkAvailNewsAndEvents(String headline)
			throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.getNewsAndEventsDao().checkAvailNewsAndEvents(headline);
	}

		
}
