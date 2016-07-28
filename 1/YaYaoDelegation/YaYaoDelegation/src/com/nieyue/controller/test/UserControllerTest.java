package com.nieyue.controller.test;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.nieyue.controller.UserController;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:config/spring-dao.xml","classpath:config/spring-service.xml","classpath:config/springmvc-servlet.xml"})
public class UserControllerTest {
	@Resource
	UserController userController;
	@Resource
	WebApplicationContext wac;
	MockHttpServletRequest request=new MockHttpServletRequest();
	MockHttpServletResponse response=new MockHttpServletResponse();
	MockMvc mvc;
	@Before
	public void setUp(){
		this.mvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	@Test
	public void testTest1() {
		fail("Not yet implemented");
	}

	@Test
	public void testTest2() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectUserByID() {
		fail("Not yet implemented");
	}
	@Test
	public void xsdfsdfsd() throws Exception {
		Integer type=1;//0是get
		//String url="/1000.xml";
		//String url="/weixin/refund/query";//退款
		//String url="/weixin/refund";//退款
		//String url="/weixin/order/close";//关闭订单
		//String url="/weixin/order/query";//订单查询
		//String url="/weixin/authorize";//授权登录
		//String url="/weixin/test/11";//统一下单
		String url="/weixin/qrcode2/11";//统一下单扫码2
		//String url="/testXmlUser?<xml><user_id>324</user_id><nice_name>sdfsdf</nice_name><name/><password/><reg_time>1468900206858</reg_time><last_login_time/></xml>";
		//String url="/sdfsd/sdf/sdbf/sdf";
		//String url="/user/gobackhtml";
		//String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0cfdb598d619807e&redirect_uri=http://www.baidu.com&response_type=code&scope=snsapi_base&state=200#wechat_redirect";
		//String url="/user/login?name=15111336587&password=123456";
		//String url="/user/test2?niceName=sdf";
		//String url="/user/1000";
		//String url="/user/ysuser.xml?userId=1000&name=15111336587&niceName=聂跃&regTime=2223-11-11 12:11:11";
		//String url="/user/df.xml?date=2015-11-11 11:11:11";//dateformatter
		//String url="/user/model?public=\u007B \"user_id\":\"1000\"\u007D &key=2";
		//String url="/user/model?public=(\"user_id\":\"1000\") &key=(\"format\":\"json\")";
		//String url="/user/model?public=\u007B \"sdf\"\u007D &key=2";
		//String url="/user/connection?url=http://www.baidu.com";
		if(type.equals(0)){
		this.mvc.perform(get(url))
		//.andExpect(status().isOk())
		.andDo(print());
		return;
		}
		this.mvc.perform(post(url))
		//.andExpect(status().isOk())
		.andDo(print());
		
	}

	@Test
	public void testModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testJs() {
		fail("Not yet implemented");
	}

	@Test
	public void testRp() {
		fail("Not yet implemented");
	}

}
