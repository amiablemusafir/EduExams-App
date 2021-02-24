package com.sms.common.exception;

import java.util.ArrayList;
import java.util.List;



public class IHMSException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IHMSException() {
		// TODO Auto-generated constructor stub
      super();
	}
	
	private String  errorCode;
	private Integer  errorId;
	private String  errorDesc;
	private List<String>  errorCodeList;
	
	public IHMSException(String errorCode){
	
		super(errorCode);
		setErrorCode(errorCode);
		
	}
	
	public IHMSException(List<String> errorCodeList){
		
		super();
		this.errorCodeList = errorCodeList;
		
	}
	public IHMSException(Integer errorId,String errorCode,String errorDesc){
		super(errorCode);
		setErrorCode(errorCode);
		setErrorId(errorId);
		setErrorDesc(errorDesc);
	}
	public IHMSException(Throwable thro){
		super(thro);
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
		if(this.errorCodeList == null){
			this.errorCodeList = new ArrayList<String>();
		}
		this.errorCodeList.add(errorCode);
	}
	public Integer getErrorId() {
		return errorId;
	}
	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public List<String> getErrorCodeList() {
		return errorCodeList;
	}
	public void setErrorCodeList(List<String> errorCodeList) {
		this.errorCodeList = errorCodeList;
	}

	
}
