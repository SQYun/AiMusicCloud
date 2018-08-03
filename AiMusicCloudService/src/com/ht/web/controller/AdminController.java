package com.ht.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.entity.Admin;
import com.ht.service.IAdminService;

@Controller                  
@RequestMapping("/jsp/admin")   
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping("/getAllAdmin.action")
	private String getAllAdmin(HttpServletRequest request) {
		List<Admin> adminList = adminService.getAllAdmin();
		request.setAttribute("adminList", adminList);
		System.out.println("-----------------------------------");
		return "admin/userList";
	}
	
	@RequestMapping("/getAdmin.action")
    public String getAdmin(String id,HttpServletRequest request){
        Admin admin = adminService.getAdmin(id);
        request.setAttribute("admin", admin);
        return "admin/userEdit";
    }
	
	@RequestMapping("/getuserAdd.action")
    public String toAddUser(){
        return "admin/userAdd";
    }
	
	@RequestMapping("/userAdd.action")
    public String addUser(Admin admin,HttpServletRequest request){
		System.out.println("===================================");
		String userPwd = MD5Password.createPassword(admin.getUser_pwd());
		admin.setUser_pwd(userPwd);
		adminService.userAdd(admin);
        return "redirect:/jsp/admin/getAllAdmin.action";
    }
	
	@RequestMapping("/delAdmin.action")
    public void delAdmin(String id,HttpServletResponse response){
		System.out.println("del");
        String result = "{\"result\":\"error\"}";
        if(adminService.delAdmin(id)){
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
	
	
	 @RequestMapping("/updateAdmin.action")
	    public String updateAdmin(Admin admin,HttpServletRequest request){
	        if(adminService.updateAdmin(admin)){
	        	admin = adminService.getAdmin(admin.getUser_id());
	            request.setAttribute("admin", admin);
	            return "redirect:/jsp/admin/getAllAdmin.action";
	        }else{
	            return "user/error";
	        }
	    }

}
