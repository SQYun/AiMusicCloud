package com.ht.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.entity.Cd;
import com.ht.service.ICdService;

@Controller                     
@RequestMapping("/jsp/cd")
public class CdController {
	
	@Autowired
	private ICdService cdService;
	
	@RequestMapping("/getAllCd.action")
	private String getAllCd(HttpServletRequest request) {
		System.out.println("-----------------------------------");
		List<Cd> cdList = cdService.getAllCd();
		request.setAttribute("cdList", cdList);
		return "cd/cdList";
	}
	
	@RequestMapping("/getCd.action")
    public String getCd(String id,HttpServletRequest request){
        Cd cd = cdService.getCd(id);
        request.setAttribute("cd", cd);
        return "cd/cdEdit";
    }
	
	@RequestMapping("/getCdAdd.action")
    public String toAddCd(){
        return "cd/cdAdd";
    }
	
	@RequestMapping("/cdAdd.action")
    public String addCd(Cd cd,HttpServletRequest request){
		cdService.cdAdd(cd);
        return "redirect:/jsp/cd/getAllCd.action";
    }
	
	@RequestMapping("/delCd.action")
    public void delCd(String id,HttpServletResponse response){
		System.out.println("del");
        String result = "{\"result\":\"error\"}";
        if(cdService.delCd(id)){
            result = "{\"result\":\"success\"}";
        }
        response.setContentType("application/json");
        
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	 @RequestMapping("/updateCd.action")
	    public String updateCd(Cd cd,HttpServletRequest request){
	        if(cdService.updateCd(cd)){
	        	cd = cdService.getCd(cd.getCd_id());
	            request.setAttribute("cd", cd);
	            return "redirect:/jsp/cd/getAllCd.action";
	        }else{
	            return "user/error";
	        }
	    }

}
