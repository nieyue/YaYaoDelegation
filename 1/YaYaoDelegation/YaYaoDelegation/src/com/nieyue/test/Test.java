package com.nieyue.test;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nieyue.bean.User;
import com.nieyue.comments.MyDateFormatter;
import com.nieyue.comments.MyObjectMapper;

public class Test {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String json1="{\"user_password\":\"123456\"}";
		//String json1="{\"user_name\":\"nieyue\",\"user_password\":\"123456\"}";
		String json2="{\"userName\":\"nieyue\",\"userPassword\":\"123456\"}";
		String json3="{\"userName\"=\"nieyue\",\"userPassword\"=\"123456\"}";
		ObjectMapper maper=new ObjectMapper();
		maper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);//下划线转驼峰
		//maper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
		//maper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);//
		//maper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);//下划线转驼峰
		//maper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE);//驼峰转下划线
		//maper.setPropertyNamingStrategy(PropertyNamingStrategy.PASCAL_CASE_TO_CAMEL_CASE);//驼峰转下划线
		//maper.setPropertyNamingStrategy(PropertyNamingStrategy.KEBAB_CASE);//驼峰转下划线
		Integer check=0;
		if(check==0){
		O o = maper.readValue(json1, O.class);
		System.err.println(o.getUserName());
		System.err.println(o);
		}
		if(check==1){
			L l = maper.readValue(json2, L.class);
			System.err.println(l.getUser_name());
			System.err.println(l);
		}
		String p="public={\"user_id\":2,\"reg_time\":\"2015-11-11 11:11:11\"}";
		p=p.substring(p.indexOf("public=")).substring(7);
		System.err.println(p);
		System.err.println("\u007b \u007d");
		User u = (User) MyObjectMapper.getObjectMapper(p, new User());
		System.out.println(u);
	}
}
class O implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userPassword;
	public O(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public O() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "O [userName=" + userName + ", userPassword=" + userPassword
				+ "]";
	}
	
}
class L implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user_name;
	private String user_password;
	public L(String user_name, String user_password) {
		super();
		this.user_name = user_name;
		this.user_password = user_password;
	}
	public L() {
		super();
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	@Override
	public String toString() {
		return "L [user_name=" + user_name + ", user_password=" + user_password
				+ "]";
	}
	
	
	
}
