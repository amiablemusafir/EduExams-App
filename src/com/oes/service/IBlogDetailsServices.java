package com.oes.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oes.common.exception.POLLINGBusinessException;
import com.oes.dto.BlogDetailsDto;
import com.oes.dto.SpotLightDetailsDto;


public interface IBlogDetailsServices {
	

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<BlogDetailsDto> getBlogDetailsDtoList(BlogDetailsDto blogDetailsDto) throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<BlogDetailsDto> getBlogDetailsDtoListOnlyThree(BlogDetailsDto blogDetailsDto) throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<BlogDetailsDto> getBlogDetailsDtoListByContentId(Integer id) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateBlogDetailsDto(BlogDetailsDto blogDetailsDto) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public BlogDetailsDto findBlogDetailsDtoById(Integer id) throws POLLINGBusinessException;	

	
	
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<SpotLightDetailsDto> getSpotLightDetailsDtoList(SpotLightDetailsDto spotLightDetailsDto) throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<SpotLightDetailsDto> getSpotLightDetailsDtoListOnlyThree(SpotLightDetailsDto spotLightDetailsDto) throws POLLINGBusinessException;

	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public List<SpotLightDetailsDto> getSpotLightDetailsDtoListByContentId(Integer id) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public void updateSpotLightDetailsDto(SpotLightDetailsDto spotLightDetailsDto) throws POLLINGBusinessException;
	
	@Transactional(
			propagation = Propagation.REQUIRED,
			rollbackFor = POLLINGBusinessException.class
	)
	public SpotLightDetailsDto findSpotLightDetailsDtoById(Integer id) throws POLLINGBusinessException;	
}
