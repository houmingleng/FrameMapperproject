<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门列表</title>
</head>
<body>
	<table border="1">
		<caption><h3>部门信息</h3></caption>
		<tr>
			<th>部门编号</th>
			<th>部门名称</th>
			<th>查看部门详情</th>
		</tr>
		<c:forEach var="dept" items="${requestScope.depts}">
		<tr>
			<td>${dept.deptId}</td>
			<td>${dept.deptName}</td>
			<td><a href="${root}/dept?op=emps&id=${dept.deptId}">查看</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>