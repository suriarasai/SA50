package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Comparable<User> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String nickName;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userName, String nickName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
	}
	public User(String userName, String nickName) {
		super();
		this.userName = userName;
		this.nickName = nickName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + "]";
	}
	@Override
	public int compareTo(User o) {
		return this.getUserName().compareTo(o.getUserName());
	}
	
    
}
