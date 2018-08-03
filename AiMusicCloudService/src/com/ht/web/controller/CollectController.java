package com.ht.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.entity.Collect;
import com.ht.service.ICollectService;

@Controller                     
@RequestMapping("/jsp/collect")
public class CollectController {
	
	@Autowired
	private ICollectService collectService;
	
	@RequestMapping("/getAllCollect.action")
	private String getAllCollect(HttpServletRequest request) {
		System.out.println("-----------------------------------");
		List<Collect> collectList = collectService.getAllCollect();
		request.setAttribute("collectList", collectList);
		return "collect/collectList";
	}
	
	@RequestMapping("/getCollect.action")
    public String getCollect(String id,HttpServletRequest request){
        Collect collect = collectService.getCollect(id);
        request.setAttribute("collect", collect);
        return "collect/collectEdit";
    }
	
	@RequestMapping("/getCollectAdd.action")
    public String toAddCollect(){
        return "collect/collectAdd";
    }
	
	@RequestMapping("/collectAdd.action")
    public String addCollect(Collect collect,HttpServletRequest request){
		collectService.collectAdd(collect);
        return "redirect:/jsp/collect/getAllCollect.action";
    }
	
	@RequestMapping("/delCollect.action")
    public void delCollect(String id,HttpServletResponse response){
		System.out.println("del");
        String result = "{\"result\":\"error\"}";
        if(collectService.delCollect(id)){
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
	
	
	 @RequestMapping("/updateCollect.action")
	    public String updateCollect(Collect collect,HttpServletRequest request){
	        if(collectService.updateCollect(collect)){
	        	collect = collectService.getCollect(collect.getSocl_id());
	            request.setAttribute("collect", collect);
	            return "redirect:/jsp/collect/getAllCollect.action";
	        }else{
	            return "user/error";
	        }
	    }

}
