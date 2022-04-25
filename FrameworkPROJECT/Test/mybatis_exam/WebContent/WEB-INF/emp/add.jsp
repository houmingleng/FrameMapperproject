<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工添加</title>
<style type="text/css">
	th{
		text-align: left;
	}
	.error{
		color: red;
		font-weight: bolder;
	}
</style>
</head>
<body>
	<form action="${root}/dept" method="post">
	<table>
		<tr>
			<th colspan="2">
				<h4>详细信息</h4>
			</th>
		</tr>
		<tr>
			<td>员工姓名</td>
			<td><input type="text" name="ename" /></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><input type="text" name="egender" /></td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text" name="eage" /></td>
		</tr>
		<tr>
			<td>职位</td>
			<td><input type="text" name="post" /></td>
		</tr>
		<tr>
			<td>电话</td>
			<td><input type="text" name="tel" /></td>
		</tr>
		<tr>
			<td>住址</td>
			<td><input type="text" name="address" /></td>
		</tr>
		<tr>
			<td><input type="reset" value="重置" /></td>
			<td>
				<input type="hidden" name="op" value="addemp" />
				<input type="hidden" name="deptId" value="${requestScope.deptId}" />
				<input type="submit" value="添加" />
				<span class="error">${requestScope.result}</span>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>