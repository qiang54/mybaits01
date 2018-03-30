package com.mybatis.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.management.openmbean.OpenMBeanAttributeInfoSupport;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.test.pojo.User;

public class UserTest {

	@Test
	public void findById()   {
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = null;
		SqlSession openSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			 openSession = factory.openSession();
			User user = openSession.selectOne("test.findById", 1);
			System.out.println(user);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			openSession.close();
		}
		
	}
	
	@Test
	public void findByName() {
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = null;
		SqlSession openSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			
		     openSession = factory.openSession();
			List<User> list = openSession.selectList("test.findByName", "王");
			System.out.println(list);
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally {
			openSession.close();
		}
	}
	
	
	
	
	
	
	
	
	
}
