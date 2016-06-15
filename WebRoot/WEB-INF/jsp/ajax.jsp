<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("#mybutton").click(function() {
			$.ajax({
				url : "test/ajax.do",
				type : "post",
				dataType : "text",
				data : {
					name : "zhangshan"
				},
				success : function(requestText) {
					alert(requestText);
				},
				error : function() {
					alert("error");
				}

			});
		});
	});
</script>
</head>

<body>
	<input id="mybutton" type="button" value="click">
</body>
</html>
