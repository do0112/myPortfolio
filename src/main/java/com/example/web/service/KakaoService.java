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
public class KakaoService {

	@Value("${kakao.client.id}")
	private String KAKAO_CLIENT_ID;
	
	@Value("${kakao.client.secret}")
	private String KAKAO_CLIENT_SECRET;
	
	@Value("${kakao.redirect.uri}")
	private String KAKAO_REDIRECT_URI;
	
	private final static String KAKAO_AUTH_URI="https://kauth.kakao.com";

	public Object getKakaoLogin() {
		return KAKAO_AUTH_URI + "/oauth/authorize?" + "client_id=" + KAKAO_CLIENT_ID + "&redirect_uri=" + KAKAO_REDIRECT_URI + "&response_type=code";
	}
	
	public String getKakaoInfo(String code) {
		
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
			params.add("client_id", KAKAO_CLIENT_ID);
			params.add("client_secret", KAKAO_CLIENT_SECRET);
			params.add("code", code);
			params.add("redirect_uri", KAKAO_REDIRECT_URI);

			RestTemplate rest = new RestTemplate();
			
			HttpEntity<MultiValueMap<String, String>> httpEn = new HttpEntity<MultiValueMap<String,String>>(params,headers);
			ResponseEntity<String> response = rest.exchange(KAKAO_AUTH_URI + "/oauth/token", HttpMethod.POST , httpEn,String.class);
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject)jsonParser.parse(response.getBody());
			
			accessToken = (String)jsonObj.get("access_token");
			refreshToken = (String)jsonObj.get("refresh_token");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String nickName = getUserInfoWithToken(accessToken);
		
		return nickName;
	}
	
	private String getUserInfoWithToken(String accessToken) {
		
		String nickName = "";
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer " + accessToken);
			headers.add("content-type", "application/x-www-form-urlencoded");
			
			RestTemplate rt = new RestTemplate();
			HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
			
			ResponseEntity<String> responseEn = rt.exchange("https://kapi.kakao.com/v2/user/me",HttpMethod.POST,httpEntity, String.class);
				
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject)jsonParser.parse(responseEn.getBody());
			JSONObject account = (JSONObject)jsonObj.get("kakao_account");
			JSONObject profile = (JSONObject)account.get("profile");
			nickName = String.valueOf(profile.get("nickname"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return nickName;
	}

}
