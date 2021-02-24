package com.oes.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dao.IBlogDetailsDao;
import com.oes.dto.BlogDetailsDto;
import com.oes.dto.SpotLightDetailsDto;

public class BlogDetailsDaoImpl implements IBlogDetailsDao {

	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<BlogDetailsDto> getBlogDetailsDtoListByContentId(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		String queryStringName = "from BlogDetailsDto as details where details.onum_is_active = 1 and details.contentDetailsDto.onum_slno ="+id+"";
		return this.hibernateTemplate.find(queryStringName);	
	}
	

	@Override
	public List<BlogDetailsDto> getBlogDetailsDtoListOnlyThree(BlogDetailsDto blogDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		String queryStringName = "from BlogDetailsDto as details where details.onum_is_active = 1 ORDER BY details.odt_entry_date DESC LIMIT 3";
		return this.hibernateTemplate.find(queryStringName);	
	}

	
	@Override
	public List<BlogDetailsDto> getBlogDetailsDtoList(BlogDetailsDto blogDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		String queryStringName = "from BlogDetailsDto as details where details.onum_is_active = 1 ORDER BY details.odt_entry_date DESC";
		return this.hibernateTemplate.find(queryStringName);	
	}

	@Override
	public void updateBlogDetailsDto(BlogDetailsDto blogDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.hibernateTemplate.saveOrUpdate(blogDetailsDto);
	}

	@Override
	public BlogDetailsDto findBlogDetailsDtoById(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		try {
			 
			BlogDetailsDto blogDetailsDto = (BlogDetailsDto) this.getHibernateTemplate().get("com.oes.dto.BlogDetailsDto",id);
			return blogDetailsDto;
		} catch (RuntimeException re) {
			throw re;
		}
	}	
	
	
	
	
	
	@Override
	public List<SpotLightDetailsDto> getSpotLightDetailsDtoListByContentId(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		String queryStringName = "from SpotLightDetailsDto as details where details.onum_is_active = 1 and details.contentDetailsDto.onum_slno ="+id+"";
		return this.hibernateTemplate.find(queryStringName);	
	}
	

	@Override
	public List<SpotLightDetailsDto> getSpotLightDetailsDtoListOnlyThree(SpotLightDetailsDto spotLightDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		String queryStringName = "from SpotLightDetailsDto as details where details.onum_is_active = 1 ORDER BY details.odt_entry_date DESC LIMIT 3";
		return this.hibernateTemplate.find(queryStringName);	
	}

	
	@Override
	public List<SpotLightDetailsDto> getSpotLightDetailsDtoList(SpotLightDetailsDto spotLightDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		String queryStringName = "from SpotLightDetailsDto as details where details.onum_is_active = 1 ORDER BY details.odt_entry_date DESC";
		return this.hibernateTemplate.find(queryStringName);	
	}

	@Override
	public void updateSpotLightDetailsDto(SpotLightDetailsDto spotLightDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.hibernateTemplate.saveOrUpdate(spotLightDetailsDto);
	}

	@Override
	public SpotLightDetailsDto findSpotLightDetailsDtoById(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		try {
			 
			SpotLightDetailsDto spotLightDetailsDto = (SpotLightDetailsDto) this.getHibernateTemplate().get("com.oes.dto.SpotLightDetailsDto",id);
			return spotLightDetailsDto;
		} catch (RuntimeException re) {
			throw re;
		}
	}	
	
}
