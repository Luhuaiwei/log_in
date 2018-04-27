<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>欢迎光临</title>
</head>
<body>
	<%ResultSet rs = (ResultSet)request.getAttribute("result");%>
	ID is:<%rs.getString(1); %><br>
	name is:<%rs.getString(2); %><br>
	password is:<%rs.getString(3); %><br>
	<br>
</body>
</html>