package com.ht.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.entity.Manager;
import com.ht.service.IManagerService;

@Controller                     // 指明当前类是控制器
@RequestMapping("/jsp/manager")    // 根路径
public class ManagerController {
	
	@Autowired
	private IManagerService managerService;
	
	
	@RequestMapping("/Login.action")
	private String Login(String manager_name,String manager_pwd,HttpServletRequest request,HttpServletResponse response) {
		String managerPwd = managerService.getPwdByName(manager_name);
		String md5pwd = MD5Password.createPassword(manager_pwd);
		if(managerPwd.equals(md5pwd)) {
			return "../jsp/admin/index";
		}else {
				return "../jsp/admin/error";
		}
		
	}
	
	@RequestMapping("/getAllManager.action")
	private String getAllManager(HttpServletRequest request) {
		List<Manager> managerList = managerService.getAllManager();
		request.setAttribute("managerList", managerList);
		System.out.println("-----------------------------------");
		return "manager/managerList";
	}
	
	@RequestMapping("/getManager.action")
    public String getManager(String id,HttpServletRequest request){
		Manager manager = managerService.getManager(id);
        request.setAttribute("manager", manager);
        return "manager/managerEdit";
    }
	
	@RequestMapping("/getmanagerAdd.action")
    public String toAddManager(){
        return "manager/managerAdd";
    }
	
	@RequestMapping("/managerAdd.action")
    public String addManager(Manager manager,HttpServletRequest request){
		System.out.println("===================================");
		String managerPwd = MD5Password.createPassword(manager.getManager_pwd());
		manager.setManager_pwd(managerPwd);
		managerService.managerAdd(manager);
        return "redirect:/jsp/manager/getAllManager.action";
    }
	
	@RequestMapping("/delManager.action")
    public void delManager(String id,HttpServletResponse response){
		System.out.println("del");
        String result = "{\"result\":\"error\"}";
        if(managerService.delManager(id)){
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
	
	
	 @RequestMapping("/updateManager.action")
	    public String updateManager(Manager manager,HttpServletRequest request){
	        
	        if(managerService.updateManager(manager)){
	        	manager = managerService.getManager(manager.getManager_id());
	            request.setAttribute("manager", manager);
	            return "redirect:/jsp/manager/getAllManager.action";
	        }else{
	            return "manager/error";
	        }
	    }

}
