package com.oes.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GoogleConnection {
	
	static String accessToken = "";

	public String getGBAuthUrl() {
		String googleLoginUrl = "";
		try {
			googleLoginUrl = "https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri="+ URLEncoder.encode(Setup.GOOGLE_REDIRECT_URL, "UTF-8")+"&response_type=code&client_id="+ Setup.GOOGLE_CLIENT_ID + "&approval_prompt=force";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return googleLoginUrl;
	}
}
