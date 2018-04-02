package com.mybatis.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.test.mapper.UserMapper;
import com.test.pojo.CustOrder;
import com.test.pojo.Orders;
import com.test.pojo.QueryVo;
import com.test.pojo.User;
/**
 * 输入映射
 * @author qiang
 *
 */
public class UserVoTest {

	private SqlSessionFactory factory;
	@Before
	public void init() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	/**
	 * 输入映射
	 *通过姓名和邮箱，模糊查询
	 */
	@Test
	public void testFindByVo() {
		
		SqlSession openSession = factory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("小");
		user.setEmail("com");
		vo.setUser(user);
		List<User> list = userMapper.findByVo(vo);
		System.out.println(list);
	}
	
	/**
	 * 查找总个数
	 */
	@Test
	public void testFindAllCount() {
		
		SqlSession openSession = factory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		Integer count = userMapper.findAllCount();
		System.out.println(count);
	}
	
	/**
	 * 动态sql
	 * 拼接查询，模糊查询，
	 */
	@Test
	public void testFindByDynSql() {
		
		SqlSession openSession = factory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		User user = new User();
		//user.setUsername("小");
		//user.setEmail("com");
		List<User> list = userMapper.findByDynSql(user);
		System.out.println(list);
	}
	
	/**
	 * foreach标签
	 * 
	 */
	@Test
	public void testFindByIds() {
		SqlSession openSession = factory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		List<Integer> ids = new ArrayList<>();
		ids.add(1);		
		ids.add(3);		
		ids.add(4);		
		ids.add(7);	
		vo.setIds(ids);
		
		List<User> list = userMapper.findByIds(vo);
		System.out.println(list);
	}
	
	/**
	 * 关联查询
	 */
	
	@Test
	public void testFindByOrderAndUser() {
		SqlSession openSession = factory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		
		List<CustOrder> list = userMapper.findByOrderAndUser();
		System.out.println(list);
	}
	
	/**
	 * 关联查询，一对多
	 * mybatis标准做法
	 */
	@Test
	public void testFindByOrderAndUser2() {
		SqlSession openSession = factory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		
		List<Orders> list = userMapper.findByOrderAndUser2();
		System.out.println(list);
	}
	
	
}
