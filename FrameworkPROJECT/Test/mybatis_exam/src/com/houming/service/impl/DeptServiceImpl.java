package com.houming.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.houming.dao.DeptMapper;
import com.houming.dao.EmpMapper;
import com.houming.pojo.Dept;
import com.houming.pojo.Emp;
import com.houming.service.DeptService;
import com.houming.util.MybatisSessionFactory;

public class DeptServiceImpl implements DeptService {

	private SqlSession sqlSession;
	private Map<String, Object> result;
	
	@Override
	public List<Dept> getAllDept() throws Exception {
		try {
			sqlSession = MybatisSessionFactory.getSqlSession();
			DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
			return deptMapper.findAll();
		} finally {
			MybatisSessionFactory.closeSqlSession(sqlSession);
		}
	}

	@Override
	public Dept getDept(String id) throws Exception {
		try {
			sqlSession = MybatisSessionFactory.getSqlSession();
			DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
			return deptMapper.findById(id);
		} finally {
			MybatisSessionFactory.closeSqlSession(sqlSession);
		}
	}

	@Override
	public List<Emp> getEmpByDeptId(String id) throws Exception {
		try {
			sqlSession = MybatisSessionFactory.getSqlSession();
			EmpMapper empMapper =sqlSession.getMapper(EmpMapper.class);
			return empMapper.findByDeptId(id);
		} finally {
			MybatisSessionFactory.closeSqlSession(sqlSession);
		}
	}

	@Override
	public Emp getEmp(String id) throws Exception {
		try {
			sqlSession = MybatisSessionFactory.getSqlSession();
			EmpMapper empMapper =sqlSession.getMapper(EmpMapper.class);
			return empMapper.findById(id);
		} finally {
			MybatisSessionFactory.closeSqlSession(sqlSession);
		}
	}

	@Override
	public Map<String, Object> delEmp(String id) throws Exception {
		try {
			result = new HashMap<>();
			sqlSession = MybatisSessionFactory.getSqlSession();
			EmpMapper empMapper =sqlSession.getMapper(EmpMapper.class);
			if(empMapper.delete(id)==1){
				result.put("code", 200);
				result.put("message", "Ա����Ϣɾ���ɹ�!");
				sqlSession.commit();
			}else{
				result.put("code", 301);
				result.put("message", "Ա����Ϣɾ��ʧ��!");
			}
		} finally {
			MybatisSessionFactory.closeSqlSession(sqlSession);
		}
		return result;
	}

	@Override
	public Map<String, Object> addEmp(Emp emp) throws Exception {
		try {
			result = new HashMap<>();
			sqlSession = MybatisSessionFactory.getSqlSession();
			EmpMapper empMapper =sqlSession.getMapper(EmpMapper.class);
			if(empMapper.insert(emp)==1){
				result.put("code", 200);
				result.put("message", "Ա����Ϣ���ӳɹ�!");
				sqlSession.commit();
			}else{
				result.put("code", 301);
				result.put("message", "Ա����Ϣ����ʧ��!");
			}
		} finally {
			MybatisSessionFactory.closeSqlSession(sqlSession);
		}
		return result;
	}

}
