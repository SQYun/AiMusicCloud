package com.ht.web.controller;


import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;



public class Result {

	
	public static String getSuccess(Object content) {
		
		/*JSONObject jsonObject = new JSONObject();
		String objJson = JSON.toJSONString(content);
		jsonObject.put("status", true);
		jsonObject.put("code", 200);
		jsonObject.put("content", objJson);
		System.out.println(jsonObject);
		return jsonObject;*/
		
		Map<String, Object> jsonlist= new HashMap<>();
		
		jsonlist.put("status", true);
		jsonlist.put("code", 200);
		jsonlist.put("content",content);
		return JSON.toJSONString(jsonlist);
		
	}
	
	
	public static String getError(String errMsg) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", false);
		jsonObject.put("code", 500);
		JSONObject errJsonObject = new JSONObject();
		errJsonObject.put("errMsg", errMsg);
		jsonObject.put("error", errJsonObject);
		System.out.println(jsonObject);
//		return jsonObject;
		return null;
	}
	
}
