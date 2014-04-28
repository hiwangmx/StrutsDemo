<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = "http://" + request.getServerName() + ":"
			+ request.getServerPort() + request.getContextPath() + "/";
	request.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=path %>FileUpload" method="post" enctype="multipart/form-data">
		<input name="file" type="file" />
		<input name="submit" type="submit"/> 
	</form>
	<s:fielderror/>
</body>
</html>