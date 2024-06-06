package com.example.web.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class NaverService {
	
	@Value("${naver.client.id}")
	private String NAVER_CLIENT_ID;
	
	@Value("${naver.client.secret}")
	private String NAVER_CLIENT_SECRET;
	
	@Value("${naver.redirect.uri}")
	private String NAVER_REDIRECT_URI;
	
	private final static String NAVER_AUTH_URI="https://nid.naver.com";

	public Object getNaverLogin() {
		return NAVER_AUTH_URI + "/oauth2.0/authorize?" + "client_id=" + NAVER_CLIENT_ID + "&redirect_uri=" + NAVER_REDIRECT_URI + "&response_type=code";
	}
	
public String getNaverInfo(String code) {
		
		if(code == null) {
			try {
				throw new Exception("인가코드가 오지 않음");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String accessToken = "";
		String refreshToken = "";
		
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-type", "application/x-www-form-urlencoded");
			
			MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
			params.add("grant_type", "authorization_code");
			params.add("client_id", NAVER_CLIENT_ID);
			params.add("client_secret", NAVER_CLIENT_SECRET);
			params.add("code", code);
			params.add("redirect_uri", NAVER_REDIRECT_URI);

			RestTemplate rest = new RestTemplate();
			
			HttpEntity<MultiValueMap<String, String>> httpEn = new HttpEntity<MultiValueMap<String,String>>(params,headers);
			ResponseEntity<String> response = rest.exchange(NAVER_AUTH_URI + "/oauth2.0/token", HttpMethod.POST , httpEn,String.class);
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject)jsonParser.parse(response.getBody());
			
			accessToken = (String)jsonObj.get("access_token");
			refreshToken = (String)jsonObj.get("refresh_token");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String name = getUserInfoWithToken(accessToken);
		
		return name;
	}
	
	private String getUserInfoWithToken(String accessToken) {
		
		String name = "";
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer " + accessToken);
			headers.add("content-type", "application/x-www-form-urlencoded");
			
			RestTemplate rt = new RestTemplate();
			HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
			
			ResponseEntity<String> responseEn = rt.exchange("https://openapi.naver.com/v1/nid/me",HttpMethod.POST,httpEntity, String.class);
				
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject)jsonParser.parse(responseEn.getBody());
			JSONObject response = (JSONObject)jsonObj.get("response");
			name = String.valueOf(response.get("name"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return name;
	}

}
