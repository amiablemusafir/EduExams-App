package com.oes.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.oes.dto.NewsAndEventsDto;

public interface INewsAndEventsDao {

	
		// method to populate NewsAndEventsDto data
		public List<NewsAndEventsDto> getNewsAndEventsDto(NewsAndEventsDto newsAndEventsDto) throws DataAccessException;
		
		//method to update NewsAndEventsDto Data
		public void updateNewsAndEventsDto(NewsAndEventsDto newsAndEventsDto) throws DataAccessException;
		
		// method to populate NewsAndEventsDto by Id
	    public NewsAndEventsDto findNewsAndEventsById(Integer newsAndEventsId) throws DataAccessException;
	    
	    public List<NewsAndEventsDto> checkAvailNewsAndEvents(String headline) throws DataAccessException;
		
}
