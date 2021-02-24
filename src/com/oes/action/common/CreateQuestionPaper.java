package com.oes.action.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import com.oes.dto.ExamQuestionDetailsDto;

public class CreateQuestionPaper {

	public static void createQuestionPaper(Map<String, ArrayList<ExamQuestionDetailsDto>> map, HttpServletRequest request) {
		
		Map<String, List<ExamQuestionDetailsDto>> questionDetailsMap = new HashMap<String, List<ExamQuestionDetailsDto>>();
		if(map != null && map.size()>0) {
		
			for(String key : map.keySet()) {
				 List<ExamQuestionDetailsDto> examList = new ArrayList<ExamQuestionDetailsDto>();
				 examList = map.get(key);
				 examList = createQuestion(examList);
				 questionDetailsMap.put(key, examList);				 
			}			
		}
		
		Map<String, List<List<ExamQuestionDetailsDto>>> questionDetailsMapCourse = new HashMap<String, List<List<ExamQuestionDetailsDto>>>();
		if(questionDetailsMap != null && questionDetailsMap.size()>0) {
			List<ExamQuestionDetailsDto> examList;
			List<List<ExamQuestionDetailsDto>> listDetailsBySection;
			for(String key : questionDetailsMap.keySet()) {
				examList = new ArrayList<ExamQuestionDetailsDto>();
				examList = questionDetailsMap.get(key);
				if(examList != null && examList.size()>0) {
					if(questionDetailsMapCourse.containsKey(examList.get(0).getQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOstr_sub_category_name())) {
						listDetailsBySection = new ArrayList<List<ExamQuestionDetailsDto>>();
						listDetailsBySection = questionDetailsMapCourse.get(examList.get(0).getQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOstr_sub_category_name());
						listDetailsBySection.add(examList);
						questionDetailsMapCourse.put(examList.get(0).getQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOstr_sub_category_name(), listDetailsBySection);						
					} else {
						listDetailsBySection = new ArrayList<List<ExamQuestionDetailsDto>>();
						listDetailsBySection.add(examList);
						questionDetailsMapCourse.put(examList.get(0).getQuestionDetailsDto().getSectionDetailsDto().getSubCategoryDetailsDto().getOstr_sub_category_name(), listDetailsBySection);
					}			
				}
			}
		}	
		questionDetailsMap = new HashMap<String, List<ExamQuestionDetailsDto>>();
		if(questionDetailsMapCourse != null && questionDetailsMapCourse.size()>0) {			
			List<List<ExamQuestionDetailsDto>> questionDetailsCourseList;
			List<ExamQuestionDetailsDto> examQuestionDetailsDtoList;
			
			for(String key : questionDetailsMapCourse.keySet()) {
				questionDetailsCourseList = new ArrayList<List<ExamQuestionDetailsDto>>();
				questionDetailsCourseList = questionDetailsMapCourse.get(key);
				
				examQuestionDetailsDtoList = new ArrayList<ExamQuestionDetailsDto>();
				for(List<ExamQuestionDetailsDto> dtoList: questionDetailsCourseList) {
					for(ExamQuestionDetailsDto dto: dtoList){
						examQuestionDetailsDtoList.add(dto);						
					}					
				}
				questionDetailsMap.put(key, examQuestionDetailsDtoList);
			 }
		}
		request.getSession().setAttribute("studentExamDetails", questionDetailsMap);
	}
	
	
	public static List<ExamQuestionDetailsDto> createQuestion(List<ExamQuestionDetailsDto> examList) {
		
		Map<String, ExamQuestionDetailsDto> questionDetailsMap = new HashMap<String, ExamQuestionDetailsDto>();
		
		if(examList != null && examList.size()>0) {
		
			for(ExamQuestionDetailsDto dto : examList) {
				String key = randomGeneratedString();
				while(questionDetailsMap.containsKey(key)) {
					key = randomGeneratedString();
				}
				questionDetailsMap.put(key, dto);	
			}
			
			examList = new ArrayList<ExamQuestionDetailsDto>();
			TreeMap<String, ExamQuestionDetailsDto> treeMap = new TreeMap<String, ExamQuestionDetailsDto>();
			if(questionDetailsMap != null && questionDetailsMap.size()>0) {
				for(String key : questionDetailsMap.keySet()) {
					treeMap.put(key, questionDetailsMap.get(key));					
				}	
			}
			
			if(treeMap != null && treeMap.size()>0) {
				
				for(String key : treeMap.keySet()) {
					examList.add(treeMap.get(key));					
				}				
			}
		}	
		
		return examList;
	}
	
	// this method is used for generating string
	public static String randomGeneratedString() {

		final int PASSWORD_LENGTH = 8;
		StringBuffer sb = new StringBuffer();
		for (int x = 0; x < PASSWORD_LENGTH; x++) {
			sb.append((char) ((int) (Math.random() * 26) + 97));
		}
		String a = sb.toString();
		System.out.println(a);

		return a;
	}
}
