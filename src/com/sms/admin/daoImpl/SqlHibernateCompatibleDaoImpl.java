package com.sms.admin.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sms.admin.dao.ISqlHibernateCompatibleDao;


public class SqlHibernateCompatibleDaoImpl extends JdbcDaoSupport implements ISqlHibernateCompatibleDao {

	public HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List permissionNotInRolePermission(int roleId)
			throws DataAccessException {
		JdbcTemplate template = new JdbcTemplate();
	   final List permissionList=new ArrayList();
		template.setDataSource(this.getDataSource());
		class LoadUserHandler implements RowCallbackHandler {
	           public void processRow(ResultSet rs) throws SQLException 
	           {
	        	   Map emailMap=new HashMap();
	        	   emailMap.put("inum_permission_id",rs.getInt(1));
	        	   emailMap.put("istr_permission_name",rs.getString(2));
	        	   permissionList.add(emailMap);
	           }
		}
		System.out.println("PermissionNotInRole");
		String sql_qry = "";
		sql_qry = "select p.inum_permission_id,p.istr_permission_name from admin_permission_mst p where p.inum_is_active = 1 and p.inum_permission_id not in (select inum_permission_id from admin_role_permission_mst where inum_is_active = 1 and inum_role_id='"+roleId+"')";
		template.query(sql_qry, new LoadUserHandler());
		//permissionList = template.queryForList(sql_qry);
		System.out.println("Pemrission size is "+permissionList.size());
		return permissionList;

		
	}

	
	public List permissionInRolePermission(int roleId)
			throws DataAccessException {
		JdbcTemplate template = new JdbcTemplate();
	   final List permissionList=new ArrayList();
		template.setDataSource(this.getDataSource());
		class LoadUserHandler implements RowCallbackHandler {
	           public void processRow(ResultSet rs) throws SQLException 
	           {
	        	   Map emailMap=new HashMap();
	        	   emailMap.put("inum_permission_id",rs.getInt(1));
	        	   emailMap.put("istr_permission_name",rs.getString(2));
	        	   permissionList.add(emailMap);
	           }
		}
		
		System.out.println("PermissionInRole");
		String sql_qry = "";
		sql_qry = "select p.inum_permission_id,p.istr_permission_name from admin_permission_mst p where p.inum_is_active=1 and p.inum_permission_id in (select inum_permission_id from admin_role_permission_mst where inum_is_active = 1 and inum_role_id='"+roleId+"')";
		template.query(sql_qry, new LoadUserHandler());
		//permissionList = template.queryForList(sql_qry);
		System.out.println("size is "+permissionList.size());
		return permissionList;
	}
	
	public List examNotInBatchExaminationMapping(int batchId, Integer user_id) throws Exception {
		JdbcTemplate template = new JdbcTemplate();
	    final List batchList=new ArrayList();
		template.setDataSource(this.getDataSource());
		class LoadUserHandler implements RowCallbackHandler {
	           public void processRow(ResultSet rs) throws SQLException 
	           {
	        	   Map emailMap=new HashMap();
	        	   emailMap.put("onum_id",rs.getInt(1));
	        	   emailMap.put("ostr_exam_name",rs.getString(2));
	        	   batchList.add(emailMap);
	           }
		}
		System.out.println("PermissionNotInRole");
		String sql_qry = "";
		sql_qry = "select p.onum_id,p.ostr_exam_name from oes_exam_details p where p.onum_is_active = 1 and p.onum_user_id = '"+user_id+"' and p.onum_id not in (select inum_exam_id from examination_batch_mapping where inum_is_active = 1 and inum_batch_id='"+batchId+"')";
		template.query(sql_qry, new LoadUserHandler());
		//permissionList = template.queryForList(sql_qry);
		System.out.println("Pemrission size is "+batchList.size());
		return batchList;

		
	}

	
	public List examInBatchExaminationMapping(int batchId, Integer user_id) throws Exception {
		JdbcTemplate template = new JdbcTemplate();
	    final List batchList=new ArrayList();
		template.setDataSource(this.getDataSource());
		class LoadUserHandler implements RowCallbackHandler {
	           public void processRow(ResultSet rs) throws SQLException 
	           {
	        	   Map emailMap=new HashMap();
	        	   emailMap.put("onum_id",rs.getInt(1));
	        	   emailMap.put("ostr_exam_name",rs.getString(2));
	        	   batchList.add(emailMap);
	           }
		}
		
		System.out.println("PermissionInRole");
		String sql_qry = "";
		sql_qry = "select p.onum_id,p.ostr_exam_name from oes_exam_details p where p.onum_is_active=1 and p.onum_user_id = '"+user_id+"' and p.onum_id in (select inum_exam_id from examination_batch_mapping where inum_is_active = 1 and inum_batch_id='"+batchId+"')";
		template.query(sql_qry, new LoadUserHandler());
		//permissionList = template.queryForList(sql_qry);
		System.out.println("size is "+batchList.size());
		return batchList;
	}

	
	public String findLoginIdExists(String loginId) throws DataAccessException {
		// TODO Auto-generated method stub
		JdbcTemplate template = new JdbcTemplate();
		final List acknowlegdeList=new ArrayList();
		template.setDataSource(this.getDataSource());
		class LoadUserHandler implements RowCallbackHandler {
	           public void processRow(ResultSet rs) throws SQLException 
	           {
	        	   Map acknowlegeMap=new HashMap();
	        	   acknowlegeMap.put("",rs.getInt(1));
	        	   acknowlegdeList.add(acknowlegeMap);
	           }
		}
		String sql_qry = "";
		sql_qry = "select count(istr_login_id) from admin_dtl a where a.istr_login_id='"+loginId+"' and a.inum_is_active = 1";
		template.query(sql_qry, new LoadUserHandler());
		
		String str=acknowlegdeList.get(0).toString();	
		
		return str.split("=")[1].split("}")[0];
	}


	



}
