package com.oes.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class FBConnection {
	
	static String accessToken = "";

	public String getFBAuthUrl() {
		String fbLoginUrl = "";
		try {
			fbLoginUrl = "https://www.facebook.com/dialog/oauth?"+"client_id="+ Setup.FACEBOOK_CLIENT_ID + "&redirect_uri="+ URLEncoder.encode(Setup.FACEBOOK_REDIRECT_URI, "UTF-8")+"&scope=email";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fbLoginUrl;
	}
}
