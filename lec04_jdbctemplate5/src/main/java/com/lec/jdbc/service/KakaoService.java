package com.lec.jdbc.service;

import java.io.IOException;
import java.util.Map;

public interface KakaoService {
	 String getToken(String code) throws IOException; 
	 Map<String, Object> getUserInfo(String access_token);
	 String getAgreementInfo(String access_token);
}
