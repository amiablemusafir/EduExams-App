package com.oes.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.oes.dao.INoticeDao;
import com.oes.dto.NoticeDto;
import com.oes.dto.StudentDetailsDto;
import com.sms.admin.dto.AdminDetailDto;

public class NoticeDaoImpl implements INoticeDao {
	
	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List<NoticeDto> getNoticeDto(AdminDetailDto adminDetailDto) throws DataAccessException{
		
		String queryStringName = "";
		if(adminDetailDto.getInum_role_id().equals(0)) {
			queryStringName = "from NoticeDto as notice where notice.gnum_is_active = 1";
		} else {
			queryStringName = "from NoticeDto as notice where notice.gnum_is_active = 1 and notice.adminDetailDto.inum_user_id = "+adminDetailDto.getInum_user_id();
		}
		return this.hibernateTemplate.find(queryStringName);	
	}
	
	public List<NoticeDto> getNoticeDtoForStudent(AdminDetailDto adminDetailDto) throws DataAccessException{
		String studentQuery = "from StudentDetailsDto as details where details.inum_is_active = 1 and details.inum_student_id = "+adminDetailDto.getInum_student_employee_id();
		List<StudentDetailsDto> stuList = new ArrayList<StudentDetailsDto>();
		stuList = (ArrayList<StudentDetailsDto>) this.hibernateTemplate.find(studentQuery);
		
		List<NoticeDto> noticeList = new ArrayList<NoticeDto>();
		if(stuList != null && stuList.size()>0) {
			Integer admin_id = stuList.get(0).getAdminDetailDto().getInum_user_id();
			String queryStringName = "from NoticeDto as notice where notice.gnum_is_active = 1 and notice.adminDetailDto.inum_user_id = "+admin_id;
			noticeList = (ArrayList<NoticeDto>) this.hibernateTemplate.find(queryStringName);
		}
		return noticeList;
	}
	
	public void updateNoticeDto(NoticeDto noticeDto) throws DataAccessException{
		
		this.hibernateTemplate.saveOrUpdate(noticeDto);
	}
	
	public NoticeDto findNoticeById(Integer noticeId) throws DataAccessException{
		try {
					 
			NoticeDto noticeDto = (NoticeDto) this.getHibernateTemplate().get("com.oes.dto.NoticeDto",noticeId);
			return noticeDto;
		} catch (RuntimeException re) {
			throw re;
		}
		
	}
	public List<NoticeDto> checkAvailNotice(String notice) throws DataAccessException{
		
		String queryStringName = "from NoticeDto as notice where notice.gstr_notice = '"+notice+"' and notice.gnum_is_active = 1";
		return this.hibernateTemplate.find(queryStringName);
	}

}
