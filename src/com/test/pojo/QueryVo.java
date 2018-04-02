package com.test.pojo;

import java.util.List;

/**
 * 输出/输入映射类
 * @author qiang
 *
 */
public class QueryVo {

	private User user;
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
