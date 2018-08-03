package com.ht.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.entity.CdList;
import com.ht.entity.SongNews;
import com.ht.service.IJsonService;


@Controller
@RequestMapping("/music") 
public class JsonController {
	
	@Autowired
	private IJsonService jsonService;
	
	@RequestMapping(value = "/getSongNews",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	private String getSongJson(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			List<SongNews> songList = jsonService.getSongNews();
			return Result.getSuccess(songList);
			
		} catch (Exception e) {
			return Result.getError(getExceptionAllinformation(e));
		}
		
	}
	
	
	@RequestMapping(value = "/getCdList",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	private String getCdList(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			List<CdList> songList = jsonService.getCdList();
			return Result.getSuccess(songList);
			
		} catch (Exception e) {
			return Result.getError(getExceptionAllinformation(e));
		}
		
	}
	
	@RequestMapping(value = "/getSongShow",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	private String getSongShow(HttpServletRequest request,HttpServletResponse response,String cdId) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			List<SongNews> songList = jsonService.getSongShow(cdId);
			return Result.getSuccess(songList);
			
		} catch (Exception e) {
			return Result.getError(getExceptionAllinformation(e));
		}
		
	}


	private String getExceptionAllinformation(Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

}
