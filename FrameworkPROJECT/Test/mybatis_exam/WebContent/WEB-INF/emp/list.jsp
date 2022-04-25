<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<style type="text/css">
	.error{
		color: red;
		font-weight: bolder;
	}
</style>
</head>
<body>
	<h3>查询部门>>>${requestScope.dept.deptName}</h3>
	<hr/>
	<c:if test="${requestScope.emps.size()==0}">
		<p>该部门暂无员工</p>
	</c:if>
	<c:if test="${requestScope.emps.size()>0}">
		<table border="1">
			<tr>
				<th>员工编号</th>
				<th>员工姓名</th>
				<th>员工性别</th>
				<th>查看员工详情</th>
				<th>删除</th>
			</tr>
			<c:forEach var="emp" items="${requestScope.emps}">
			<tr>
				<td>${emp.eid}</td>
				<td>${emp.ename}</td>
				<td>${emp.egender}</td>
				<td><a href="${root}/dept?op=emp&id=${emp.eid}">查看</a></td>
				<td><a href="${root}/dept?op=delemp&eid=${emp.eid}&id=${requestScope.dept.deptId}"
					onclick="return confirm('是否确定删除?')">删除</a></td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
	<hr/>
	<a href="${root}/dept?op=depts">返回首页</a>
	<a href="${root}/dept?op=addemp&id=${requestScope.dept.deptId}">添加员工</a>
	<span class="error">${requestScope.result}</span>
</body>
</html>