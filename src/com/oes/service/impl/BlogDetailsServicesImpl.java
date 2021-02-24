package com.oes.service.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dao.IBlogDetailsDao;
import com.oes.dto.BlogDetailsDto;
import com.oes.dto.SpotLightDetailsDto;
import com.oes.service.IBlogDetailsServices;

public class BlogDetailsServicesImpl implements IBlogDetailsServices {
	
	private IBlogDetailsDao blogDetailsDao;

	public IBlogDetailsDao getBlogDetailsDao() {
		return blogDetailsDao;
	}
	public void setBlogDetailsDao(IBlogDetailsDao blogDetailsDao) {
		this.blogDetailsDao = blogDetailsDao;
	}
	
	@Override
	public List<BlogDetailsDto> getBlogDetailsDtoList(BlogDetailsDto blogDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.blogDetailsDao.getBlogDetailsDtoList(blogDetailsDto);
	}
	
	@Override
	public List<BlogDetailsDto> getBlogDetailsDtoListOnlyThree(BlogDetailsDto blogDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.blogDetailsDao.getBlogDetailsDtoListOnlyThree(blogDetailsDto);
	}
		
	@Override
	public List<BlogDetailsDto> getBlogDetailsDtoListByContentId(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.blogDetailsDao.getBlogDetailsDtoListByContentId(id);
	}
	
	@Override
	public void updateBlogDetailsDto(BlogDetailsDto postOfficeMannualDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.blogDetailsDao.updateBlogDetailsDto(postOfficeMannualDetailsDto);
	}
	@Override
	public BlogDetailsDto findBlogDetailsDtoById(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.blogDetailsDao.findBlogDetailsDtoById(id);
	}



	
	@Override
	public List<SpotLightDetailsDto> getSpotLightDetailsDtoList(SpotLightDetailsDto spotLightDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.blogDetailsDao.getSpotLightDetailsDtoList(spotLightDetailsDto);
	}
	
	@Override
	public List<SpotLightDetailsDto> getSpotLightDetailsDtoListOnlyThree(SpotLightDetailsDto spotLightDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.blogDetailsDao.getSpotLightDetailsDtoListOnlyThree(spotLightDetailsDto);
	}
		
	@Override
	public List<SpotLightDetailsDto> getSpotLightDetailsDtoListByContentId(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.blogDetailsDao.getSpotLightDetailsDtoListByContentId(id);
	}
	
	@Override
	public void updateSpotLightDetailsDto(SpotLightDetailsDto postOfficeMannualDetailsDto) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		this.blogDetailsDao.updateSpotLightDetailsDto(postOfficeMannualDetailsDto);
	}
	@Override
	public SpotLightDetailsDto findSpotLightDetailsDtoById(Integer id) throws POLLINGBusinessException {
		// TODO Auto-generated method stub
		return this.blogDetailsDao.findSpotLightDetailsDtoById(id);
	}

}
