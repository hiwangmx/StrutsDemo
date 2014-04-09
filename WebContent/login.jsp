<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = "http://" + request.getServerName() + ":"
			+ request.getServerPort() + request.getContextPath() + "/";
	request.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">

</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
	<!-- struts2中theme属性包括xhtml,html,simple,ajax -->
	<!-- <s:form id="loginForm" name="loginForm" acion="/login/LoginAction_login" method="post" theme="simple" > -->
	<form action="<%=path %>login/LoginAction_login" method="post">
		<table align="center" border="1">
			<tr>
				<td><s:label>用户名：</s:label></td>
				<td><s:textfield label="用户名：" name="userName"/></td>
			</tr>
			<tr>
				<td><s:label>密码：</s:label></td>
				<td><s:textfield name="password"/></td>
			</tr>
			<tr>
				<td colspan="2"	align="center">
					<s:submit value="提交" ></s:submit>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<s:property value="%{#request.message}"/>
				</td>
			</tr>
		</table>
	</form>
	<!-- </s:form> -->
</body>
</html>