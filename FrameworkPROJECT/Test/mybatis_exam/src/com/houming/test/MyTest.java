package com.houming.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.houming.pojo.Emp;
import com.houming.service.DeptService;
import com.houming.service.impl.DeptServiceImpl;
import com.houming.util.MybatisSessionFactory;

public class MyTest {

	@Test
	public void test() throws Exception {
		//System.out.println(MybatisSessionFactory.getSqlSession().getConnection());
		
		DeptService deptService = new DeptServiceImpl();
		//System.out.println(deptService.getEmp("1"));
		
		Emp emp = new Emp();
		emp.setAddress("aa");
		emp.setDeptId("1");
		emp.setEage("22");
		emp.setEgender("a");
		emp.setEname("aaa");
		emp.setPost("aaa");
		emp.setTel("aaa");
		System.out.println(deptService.addEmp(emp));
		
	}

}
