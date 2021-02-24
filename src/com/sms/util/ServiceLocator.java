package com.sms.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public final class ServiceLocator implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	private static final ServiceLocator serviceLocator = new ServiceLocator();
	
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	// This method return a instance of service.
	public static ServiceLocator getInstance(){
		return serviceLocator;
	}
	public Object getService(String ServiceName){
		return this.applicationContext == null ? null : this.applicationContext.getBean(ServiceName);
	}

}
