package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户类
 * @author yy
 *
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 8198930199550185349L;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 昵称
	 */
	private String niceName;
	/**
	 * 微信openid
	 */
	private String openid;
	/**
	 * 登录名
	 */
	private String name;
	/**
	 * 登录密码
	 */
	private String password;
	/**
	 * 注册时间 
	 */
	private Date regTime;
	/**
	 * 最后登陆时间
	 */
	private Date lastLoginTime;
	public User(Integer userId, String niceName, String name, String password,
			Date regTime, Date lastLoginTime,String openid) {
		super();
		this.userId = userId;
		this.niceName = niceName;
		this.name = name;
		this.password = password;
		this.regTime = regTime;
		this.lastLoginTime = lastLoginTime;
		this.openid=openid;
	}
	public User() {
		super();
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNiceName() {
		return niceName;
	}
	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
}
