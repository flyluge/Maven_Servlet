<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="TestServlet?method=test04">
		<table>
			<tr>
				<td colspan=2>表单测试</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>介绍</td>
				<td><input type="text" name="mess"></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="text" name="birthday"></td>
			</tr>
			<tr>
				<td colspan=2><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>