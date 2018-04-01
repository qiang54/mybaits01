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

import com.test.mapper.UserMapper;
import com.test.pojo.User;

public class UserMapperTest {

	private SqlSessionFactory factory;
	@Before
	public void init() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	/**
	 * 代理方式
	 * getMapper(UserMapper.class)
	 */
	@Test
	public void testFindById() {
		
		SqlSession openSession = factory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		User user = userMapper.findById(3);
		System.out.println(user);
	}
	
	
	@Test
	public void testFindByName() {
		
		SqlSession openSession = factory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findByName("王");
		System.out.println(list);
	}
	
	@Test
	public void testInsertUser() {
		
		SqlSession openSession = factory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		
		User user = new User();
		user.setUsername("你哈"); 
		user.setEmail("231@ppp.com");
		user.setPassword("234");
		
		userMapper.insertUser(user);
		openSession.commit();

	}
	
	
	
}
