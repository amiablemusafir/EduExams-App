package com.oes.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonMethod {
	// this method is used for generating string
	
	
	public static String randomGeneratedString() {

		final int PASSWORD_LENGTH = 6;
		StringBuffer sb = new StringBuffer();
		for (int x = 0; x < PASSWORD_LENGTH; x++) {
			sb.append((char) ((int) (Math.random() * 26) + 97));
		}
		String a = sb.toString();
		System.out.println(a);

		return a;
	}
	
	public static boolean checkRandomStringValidation(HttpServletResponse response, HttpServletRequest request, String randomStringJsp) {
		
		boolean status = false;
		/*String sessionRandomString = (String) request.getSession().getAttribute("session_random_string");
		
		try {
			
			System.out.println("Session Key :::"+sessionRandomString);
			
			System.out.println("Jsp Key :::::::"+randomStringJsp);
			
			if(sessionRandomString == null || sessionRandomString.equals("")) {
			
				status = false;
				request.getSession().setAttribute("adminDetailDto",null);
				String info = "We have found some malicious activity in your account so please login once again and contiunue.";
				request.getSession().setAttribute("info", info);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			} else if(randomStringJsp == null || randomStringJsp.equals("")) {
			
				status = false;
				request.getSession().setAttribute("adminDetailDto",null);
				String info = "We have found some malicious activity in your account so please login once again and contiunue.";
				request.getSession().setAttribute("info", info);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				
			} else if(sessionRandomString.equals(randomStringJsp)) {
			
				status = true;
				request.getSession().setAttribute("session_random_string", null);
			
			} else {
			
				status = false;
				request.getSession().setAttribute("adminDetailDto",null);
				String info = "We have found some malicious activity in your account so please login once again and contiunue.";
				request.getSession().setAttribute("info", info);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}*/
		return status;
	}
	
	public static String generateStringValidation(HttpServletRequest request) {
		
		String random_string = randomGeneratedString();
		/*request.getSession().setAttribute("info", "");
		request.getSession().setAttribute("session_random_string", random_string);		
*/		return random_string;
		
	}
	
	
}
