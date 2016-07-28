package com.nieyue.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.nieyue.bean.User;

public class Test3 {
	public static void main(String[] args) {
 ObjectMapper om=new ObjectMapper();
 	XmlMapper xml=new  XmlMapper();
 	try {  
 		//javaBean转换成xml  
 		//xml.writeValue(System.out, bean);  
 		/*StringWriter sw = new StringWriter();  
 		xml.writeValue(sw, User.class);  
 		System.out.println(sw.toString()); */
 		//xml.setConfig(xml.getSerializationConfig().withRootName("xml"));
 		PropertyName pn=new PropertyName("xml");
 		pn.withSimpleName("sss");
 		xml.setConfig(xml.getSerializationConfig().withRootName(pn));
 		User user=new User();
 		user.setLastLoginTime(new Date());
 		//List转换成xml  
 		List<User> list = new ArrayList<User>();  
 		list.add(user);  
 		System.out.println(xml.writeValueAsString(list));
 		
 		//Map转换xml文档  
 		Map<String, User> map = new HashMap<String, User>();  
 		map.put("A", user);  
 		map.put("B", user);  
 		System.out.println(xml.writeValueAsString(map));  
 	
 		//MyXMLMapper myxml=new MyXMLMapper();
 		User user2=new User();
 	//List转换成xml  
		List<User> list2 = new ArrayList<User>();  
		list.add(user2);  
		System.out.println(xml.writeValueAsString(list2));
		
		Map<String, User> map2 = new HashMap<String, User>();  
 		map.put("C", user2);  
 		map.put("DD", user2);  
 		System.out.println(xml.writeValueAsString(map2)); 
 	} catch (Exception e) {  
 		e.printStackTrace();  
 	}  
	}
	
	
	
}
