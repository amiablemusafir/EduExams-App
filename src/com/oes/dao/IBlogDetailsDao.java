package com.oes.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dto.BlogDetailsDto;
import com.oes.dto.SpotLightDetailsDto;

public interface IBlogDetailsDao {
	
	public List<BlogDetailsDto> getBlogDetailsDtoList(BlogDetailsDto blogDetailsDto) throws POLLINGBusinessException;
	
	public List<BlogDetailsDto> getBlogDetailsDtoListOnlyThree(BlogDetailsDto blogDetailsDto) throws POLLINGBusinessException;

	public List<BlogDetailsDto> getBlogDetailsDtoListByContentId(Integer id) throws POLLINGBusinessException;
	
	public void updateBlogDetailsDto(BlogDetailsDto blogDetailsDto) throws POLLINGBusinessException;
	
	public BlogDetailsDto findBlogDetailsDtoById(Integer id) throws POLLINGBusinessException;	
	
	
	
	public List<SpotLightDetailsDto> getSpotLightDetailsDtoList(SpotLightDetailsDto spotLightDetailsDto) throws POLLINGBusinessException;
	
	public List<SpotLightDetailsDto> getSpotLightDetailsDtoListOnlyThree(SpotLightDetailsDto spotLightDetailsDto) throws POLLINGBusinessException;

	public List<SpotLightDetailsDto> getSpotLightDetailsDtoListByContentId(Integer id) throws POLLINGBusinessException;
	
	public void updateSpotLightDetailsDto(SpotLightDetailsDto spotLightDetailsDto) throws POLLINGBusinessException;
	
	public SpotLightDetailsDto findSpotLightDetailsDtoById(Integer id) throws POLLINGBusinessException;	
		
}
