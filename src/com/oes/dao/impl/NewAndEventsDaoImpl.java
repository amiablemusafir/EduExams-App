package com.oes.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.oes.dto.NewsAndEventsDto;
import com.oes.dao.INewsAndEventsDao;

public class NewAndEventsDaoImpl implements INewsAndEventsDao{
	
	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List<NewsAndEventsDto> getNewsAndEventsDto(NewsAndEventsDto newsAndEventsDto) throws DataAccessException{
		String queryStringName = "from NewsAndEventsDto as gkp_news_events where gkp_news_events.gnum_is_active = 1";
		return this.hibernateTemplate.find(queryStringName);	
	}
	
	public void updateNewsAndEventsDto(NewsAndEventsDto newsAndEventsDto) throws DataAccessException{
		
		this.hibernateTemplate.saveOrUpdate(newsAndEventsDto);
	}
	
	public NewsAndEventsDto findNewsAndEventsById(Integer newsAndEventsId) throws DataAccessException{
		try {
					 
			NewsAndEventsDto newsAndEventsDto = (NewsAndEventsDto) this.getHibernateTemplate().get("com.oes.dto.NewsAndEventsDto",newsAndEventsId);
			return newsAndEventsDto;
		} catch (RuntimeException re) {
			throw re;
		}
		
	}
	public List<NewsAndEventsDto> checkAvailNewsAndEvents(String headline) throws DataAccessException{
		
		String queryStringName = "from NewsAndEventsDto as gkp_news_events where gkp_news_events.gstr_headline = '"+headline+"' and gkp_news_events.gnum_is_active = 0";
		return this.hibernateTemplate.find(queryStringName);
	}
	
	

}
