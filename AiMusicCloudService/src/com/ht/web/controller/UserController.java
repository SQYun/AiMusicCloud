package com.ht.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.entity.User;
import com.ht.service.IUserService;

@Controller                     // ָ����ǰ���ǿ�����
@RequestMapping("/jsp/user")    // ��·��
public class UserController {

    @Autowired                  // �����͵ķ�ʽע��(Spring�ж��ַ�ʽʵ���Զ�ע�룬��������ע���������)
    private IUserService userService;

    @RequestMapping("/getAllUser.action")
    public String getAllUser(HttpServletRequest request){
        List<User> userList = userService.getAllUser();
        request.setAttribute("userList", userList);
        return "user/index";
    }
    
    @RequestMapping("/getUser.action")
    public String getUser(String id,HttpServletRequest request){
        User user = userService.getUser(id);
        request.setAttribute("user", user);
        return "user/editUser";
    }
    
    @RequestMapping("/toAddUser.action")
    public String toAddUser(){
        return "user/addUser";
    }
    
    @RequestMapping("/addUser.action")
    public String addUser(User user,HttpServletRequest request){
        userService.addUser(user);
        return "redirect:/jsp/user/getAllUser.action";
    }
    
    @RequestMapping("/delUser.action")
    public void delUser(String id,HttpServletResponse response){
        String result = "{\"result\":\"error\"}";
        if(userService.delUser(id)){
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
    
    @RequestMapping("/updateUser")
    public String updateUser(User user,HttpServletRequest request){
        
        if(userService.updateUser(user)){
            user = userService.getUser(user.getId());
            request.setAttribute("user", user);
            return "redirect:/jsp/user/getAllUser.action";
        }else{
            return "user/error";
        }
    }
}