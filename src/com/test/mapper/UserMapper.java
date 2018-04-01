package com.test.mapper;



import java.util.List;

import com.test.pojo.User;
/**
 * 接口名必须和映射文件名一样
 * 核心配置文件SqlMapConfig.xml必须引入接口类的全路径
 * <mapper class="com.test.mapper.UserMapper"/>
 * @author qiang
 *
 */
public interface UserMapper {

	public User findById(Integer id);
	//返回值为List
	public List<User> findByName(String name);
	
	public void insertUser(User user);
}
