package com.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.test.pojo.User;
/**
 * DAO的开发
 * 1.原生dao的开发
 * @author qiang
 *
 */
public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;
	
	//提供构造方法
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	/**
	 * 按id查找
	 */
	@Override
	public User findUserById(Integer id) {
		SqlSession openSession = sqlSessionFactory.openSession();
		User user = openSession.selectOne("test.findById", 2);
		return user;
	}
	
	/**
	 * 按名称查找
	 */
	@Override
	public List<User> findUserByName(String name) {
		SqlSession openSession = sqlSessionFactory.openSession();
		List<User> list = openSession.selectList("test.findByName", "王");
		return list;
	}

}
