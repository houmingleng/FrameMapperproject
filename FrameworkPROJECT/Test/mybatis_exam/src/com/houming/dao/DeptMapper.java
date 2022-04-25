package com.houming.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.houming.pojo.Dept;

public interface DeptMapper {
	List<Dept> findAll();
	Dept findById(@Param("id")String id);
}
