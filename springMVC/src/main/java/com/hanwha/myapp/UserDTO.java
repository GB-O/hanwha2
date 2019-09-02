package com.hanwha.myapp;

public class UserDTO {
	int userid;
	String username;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userame) {
		this.username = userame;
	}
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", username=" + username + "]";
	}
	
	
}
