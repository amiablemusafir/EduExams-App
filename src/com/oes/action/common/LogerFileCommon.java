package com.oes.action.common;

import java.util.Date;

import org.apache.log4j.Logger;

public class LogerFileCommon {
	   
	   /* Get actual class name to be printed on */
	   static Logger log = Logger.getLogger(LogerFileCommon.class.getName());
	   public static void setLogMessage(String message) throws Exception {
		   log.info("Date : "+new Date());
		   log.info(message);
	   }
	   
	   /* Only for testing purpose*/
	   public static void main(String[] args)throws Exception {
	       LogerFileCommon.setLogMessage("Hello this is an info message");		
	   }
}
