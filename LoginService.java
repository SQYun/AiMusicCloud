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
	String DBName="root"; //�����û���
	String DBPwd="";//��������
    //��������
	Class.forName("com.mysql.jdbc.Driver");
	//�������ݿ�
	Connection conn=DriverManager.getConnection(DBURL,DBName,DBPwd);
	//����Statement����
	Statement st=conn.createStatement();
	String sql="select * from user where name='"+username+"'and pwd='"+password+"'";
	//����sql��䣬���ѵõ��Ľ����������ResultSet��
	ResultSet rs=st.executeQuery(sql);
	//�ж����������Ƿ���ڣ�һ��usernameֻ��һ��
	if(rs.next()){
		if(password.equals(rs.getObject("password"))){
            resp.sendRedirect("success.jsp");
        }
        else{
            System.out.print("<script language='javaScript'> alert('�������');</script>");
            resp.setHeader("refresh", "0;url=login.jsp");
        }
    }else{
	  //����һ��error,��������ָ������error���Ա���һ����תҳ���ʹ�ã�request������������
	  req.setAttribute("error", "�û������������!!!");
	  req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	 
	 
	conn.close();
	rs.close();
}
}
