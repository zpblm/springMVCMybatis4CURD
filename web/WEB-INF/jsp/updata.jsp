<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/updataUser" method="post">
		ID:<input type="text" name="id" value="${user.id }"><br>
		用户名:<input type="text" name="name" value="${user.name }"><br>
		地址:<input type="text" name="addr" value="${user.addr }"><br>
		<input type="submit" value="确定">
	</form>
</body>
</html>