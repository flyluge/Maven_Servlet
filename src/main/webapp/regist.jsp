<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生注册</title>
</head>
<body>
	<form action="StudentServlet?method=regist" method="post">
		<table>
			<tr>
				<td>
					<label>账号</label>
				</td>
				<td>
					<input type="text" name="stuid" placeholder="请输入账号">
				</td>
			</tr>
			<tr>
				<td>
					<label>姓名</label>
				</td>
				<td>
					<input type="text" name="stuname" placeholder="请输入姓名">
				</td>
			</tr>
			<tr>
				<td>
					<label>性别</label>
				</td>
				<td>
					<select name="sex">
						<option>--请选择--</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label>密码</label>
				</td>
				<td>
					<input type="password" name="password" placeholder="请输入密码">
				</td>
			</tr>
			<tr>
				<td>
					<label>介绍</label>
				</td>
				<td>
					<input type="text" name="mess" placeholder="请输入个人介绍">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交">
				</td>
				<td>
					<input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>