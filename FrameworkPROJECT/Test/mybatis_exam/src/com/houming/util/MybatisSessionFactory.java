package com.houming.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSessionFactory {
	private static SqlSessionFactory factory = null;
	static{
		try {
			InputStream in = Resources.getResourceAsStream("mybatis.cfg.xml");
			factory = new SqlSessionFactoryBuilder().build(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSession(){
		return factory.openSession(false);
	}
	public static void closeSqlSession(SqlSession sqlSession){
		if(sqlSession!=null)sqlSession.close();
	}
}
