package com.test.pojo;

public class User {

		private Integer userid;
		private String username;// 用户姓名
		private String email;// 
		private String password;//
		
		public int getUserid() { 
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "User [userid=" + userid + ", username=" + username + ", email=" + email + ", password=" + password + "]";
		}

}
