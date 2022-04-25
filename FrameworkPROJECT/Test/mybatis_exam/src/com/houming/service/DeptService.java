package com.houming.service;

import java.util.List;
import java.util.Map;

import com.houming.pojo.Dept;
import com.houming.pojo.Emp;

public interface DeptService {
	List<Dept> getAllDept() throws Exception;
	Dept getDept(String id) throws Exception;
	List<Emp> getEmpByDeptId(String id) throws Exception;
	Emp getEmp(String id) throws Exception;
	Map<String, Object> delEmp(String id) throws Exception;
	Map<String, Object> addEmp(Emp emp) throws Exception;
	
}
