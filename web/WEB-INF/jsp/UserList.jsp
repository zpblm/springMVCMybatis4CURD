<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CURD</title>
</head>
<body>
	<h1>springmvc+Mybatis for CURD</h1>
	<hr>
	<table>
		<tr>
			<th>ID</th>
			<th>用户名</th>
			<th>住址</th>
			<th>操作</th>
		</tr>
		<c:forEach var="user" items="${users }">

			<form action="${pageContext.request.contextPath }/updata" method="post">
				<input type="text" value="${user.id }" name="id" style="visibility: hidden">
				<input type="text" value="${user.name }" name="name" style="visibility: hidden">
				<input type="text" value="${user.addr }" name="addr" style="visibility: hidden">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.addr }</td>
				<td><button type="submit">编辑</button></td>
			</tr>
			</form>
		</c:forEach>
	</table>
<a href="login.html">添加新用户</a>
</body>
</html>