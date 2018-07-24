package com.wj.loginSevice;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;


public class LoginService {

	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
	 String username=req.getParameter("username");

	String password=req.getParameter("password");

	String DBURL="jdbc:mysql://localhost:3306/zhou?useUnicode=true&characterEncoding=utf-8"; 
	String DBName="root"; //登入用户名
	String DBPwd="";//登入密码
    //加载驱动
	Class.forName("com.mysql.jdbc.Driver");
	//连接数据库
	Connection conn=DriverManager.getConnection(DBURL,DBName,DBPwd);
	//创建Statement对象
	Statement st=conn.createStatement();
	String sql="select * from user where name='"+username+"'and pwd='"+password+"'";
	//运行sql语句，并把得到的结果放入结果集ResultSet中
	ResultSet rs=st.executeQuery(sql);
	//判断这个结果集是否存在，一般username只有一个
	if(rs.next()){
		if(password.equals(rs.getObject("password"))){
            resp.sendRedirect("success.jsp");
        }
        else{
            System.out.print("<script language='javaScript'> alert('密码错误');</script>");
            resp.setHeader("refresh", "0;url=login.jsp");
        }
    }else{
	  //设置一个error,将后面的字赋给这个error，以便先一个跳转页面的使用，request的作用域有限
	  req.setAttribute("error", "用户名或密码错误!!!");
	  req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	 
	 
	conn.close();
	rs.close();
}
}
