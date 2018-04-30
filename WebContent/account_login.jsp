<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
	<title>欢迎光临</title>
	<style>
		div{
			text-align:center;
		}
	</style>
</head>
<body>
	<div>
	<br>
	登录成功！
	<br><br><br><br><br>
	<%String s1 = null; %>
	<%String s2 = null; %>
	<%String s3 = null; %>
	<%ResultSet rs = (ResultSet)request.getAttribute("result");%>
	<%if(rs.next()){
		s1 = rs.getString(1);	
		s2 = rs.getString(2);
		s3 = rs.getString(3);
	} %>
	身份证： is:<%=s1%><br>
	名字:<%=s2%><br>
	密码： is:<%=s3%><br>
	<br>
	</div>
</body>
</html>