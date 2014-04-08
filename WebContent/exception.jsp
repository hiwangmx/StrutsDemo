<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>异常</title>
</head>
<body>
	<s:property value="exception"/> <!-- 输出异常对象 -->
	<s:property value="exceptionStack"/> <!-- 输出异常对象的堆栈信息： -->
	<s:property value="exception.message"/> <!-- 输出异常信息 -->
</body>
</html>