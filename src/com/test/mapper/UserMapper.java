package com.test.mapper;



import java.util.List;

import com.test.pojo.CustOrder;
import com.test.pojo.Orders;
import com.test.pojo.QueryVo;
import com.test.pojo.User;
/**
 * 动态代理接口类，不用写实现类
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
	
	public List<User> findByVo(QueryVo vo);
	
	public Integer findAllCount();
	//动态sql
	public List<User> findByDynSql(User user);
	
	//foreach 标签
	public List<User> findByIds(QueryVo vo);

	public List<CustOrder> findByOrderAndUser();
	public List<Orders> findByOrderAndUser2();
}
