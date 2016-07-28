package com.nieyue.test;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.nieyue.bean.User;
import com.nieyue.filter.params.MyNamingStrategy;
import com.nieyue.util.MyConvertXML;
import com.nieyue.weixin.bean.UnifiedOrder;
import com.thoughtworks.xstream.XStream;

public class Test4 {
public static void main(String[] args) throws IOException {
	// and then configure, for example:
			User u=new User();
			u.setUserId(324);
			u.setRegTime(new Date());
			u.setNiceName("sdfs_dFFf");
		//getXML(uo);
			System.out.println(new Date().getTime()/1000);
}
   public static String getXML(Object o) throws IOException{
				XmlMapper xmlMapper = new XmlMapper();
				xmlMapper.setConfig(xmlMapper.getSerializationConfig().withRootName("xml").with(PropertyNamingStrategy.SNAKE_CASE));
				String xml = xmlMapper.writeValueAsString(o);
				//<xml><user_id>324</user_id><nice_name>sdfsdf</nice_name><name/><password/><reg_time>1468900206858</reg_time><last_login_time/></xml>
				System.out.println(xml);
				JsonNode json = xmlMapper.readTree(xml);
				//{"user_id":"324","nice_name":"sdfsdf","name":null,"password":null,"reg_time":"1468900206858","last_login_time":null}
				
				System.out.println(json);
				//xmlMapper.setConfig(xmlMapper.getSerializationConfig().withRootName("xml").with(PropertyNamingStrategy.PASCAL_CASE_TO_CAMEL_CASE));
				String xx = MyNamingStrategy.underlineToCamel(xml);
				System.out.println(xx);
				User u2 = xmlMapper.readValue(xx, User.class);
				System.out.println(u2);
	   return "";
   }
}
