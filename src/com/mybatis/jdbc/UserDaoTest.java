package com.mybatis.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.test.pojo.User;

public class UserDaoTest {

	private SqlSessionFactory factory;
	
	@Before
	public void init() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	@Test
	public void testFindById() {
		SqlSession openSession = factory.openSession();
		User user = openSession.selectOne("test.findById", 1);
		System.out.println(user);
	}
	@Test
	public void testFindByName() {
		SqlSession openSession = factory.openSession();
		List<Object> list = openSession.selectList("test.findByName", "王");
		System.out.println(list);
	}
	
}
