<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sc.chris.entity.User" %>
<%@ page import="com.sc.chris.service.UserService" %>
<%@ page import="com.sc.chris.service.Impl.UserServiceImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
</head>
<body>

<%
String username = request.getParameter("username");
String password = request.getParameter("password");

User user = new User(username,password);
UserService userService = new UserServiceImpl();
boolean exist = userService.exists(user);
if (!exist){
	userService.addUser(user);
	response.sendRedirect("registerSucess.jsp");
} else{
	response.sendRedirect("registerFail.jsp");
}

%>

</body>
</html>