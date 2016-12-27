<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/addUser.do" method="post">
		ID：<input type="text" name="id"/>
		用户名：<input type="text" name="username"/>
		密码：<input type="text" name="age"/>
		生日：<input type="text" name="birthday"/>
		地址：<input type="text" name="address"/>
		<input type="submit" value="提交" />
	</form>
</body>
</html>