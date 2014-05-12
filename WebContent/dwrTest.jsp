<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>   
<%  
  String path = request.getContextPath();  
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<script type='text/javascript' src="<%=path %>/dwr/interface/Clock.js"></script>  
<script type="text/javascript" src="<%=path %>/dwr/engine.js"></script>  
<script type="text/javascript" src="<%=path %>/dwr/util.js"></script>
  
<body  onload="dwr.engine.setActiveReverseAjax(true);">  
点击查看服务器端时间:  
<input type="button" value="Start/Stop" onclick="Clock.toggle();"/>  
<h2 id="clockDisplay"></h2>  
</body>  
</html>