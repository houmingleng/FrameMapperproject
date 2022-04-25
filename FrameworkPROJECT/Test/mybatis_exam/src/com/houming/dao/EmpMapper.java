package com.houming.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.houming.pojo.Emp;

public interface EmpMapper {
	List<Emp> findByDeptId(@Param("id")String id);
	Emp findById(@Param("id")String id);
	int insert(Emp emp);
	int delete(@Param("id")String id);
}
