<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工详情</title>
<style type="text/css">
	th{
		text-align: left;
	}
</style>
</head>
<body>
	<h3>员工信息查询>>>${requestScope.emp.ename}</h3>
	<hr/>
	<table>
		<tr>
			<th colspan="2">
				<h4>详细信息</h4>
			</th>
		</tr>
		<tr>
			<td>员工姓名</td>
			<th>${requestScope.emp.ename}</th>
		</tr>
		<tr>
			<td>性别</td>
			<th>${requestScope.emp.egender}</th>
		</tr>
		<tr>
			<td>年龄</td>
			<th>${requestScope.emp.eage}</th>
		</tr>
		<tr>
			<td>所属部门</td>
			<th>${requestScope.emp.dept.deptName}</th>
		</tr>
		<tr>
			<td>职位</td>
			<th>${requestScope.emp.post}</th>
		</tr>
		<tr>
			<td>电话</td>
			<th>${requestScope.emp.tel}</th>
		</tr>
		<tr>
			<td>住址</td>
			<th>${requestScope.emp.address}</th>
		</tr>
	</table>
	<hr/>
	<a href="${root}/dept?op=emps&id=${requestScope.emp.deptId}">${requestScope.emp.dept.deptName}</a>
</body>
</html>