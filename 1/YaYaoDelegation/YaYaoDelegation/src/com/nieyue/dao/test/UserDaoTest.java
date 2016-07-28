package com.nieyue.dao.test;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nieyue.bean.User;
import com.nieyue.dao.UserDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-dao.xml")
public class UserDaoTest {
	//注入Dao实现类依赖
	@Resource
	private UserDao userDao;
	@Test
	public void testUserLogin() {
		String name="15111336587";
		String password="123456";
		User user = userDao.userLogin(name, password);
		System.out.println(user);
		System.out.println(user.getRegTime().toGMTString());
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( user.getRegTime()));
		System.out.println(user.getRegTime().toLocaleString());
	}

	@Test
	public void testChkLoginName() {
		boolean s = userDao.chkLoginName("15111336587");
		System.out.println(s);
	}

	@Test
	public void testRetrieveAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		for (int i = 0; i < 1; i++) {
			User user=new User();
			user.setNiceName("聂跃"+i);
			user.setName("1511133658"+i);
			user.setPassword("123456");
			userDao.addUser(user);
		}
		
	}

	@Test
	public void testUpdateUser() throws ParseException {
		User user =userDao.loadUser(1001);
		user.setNiceName("聂跃0");
		user.setPassword("122111");
		user.setName("188888883");
		//user.setRegTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-01-11 11:11:11"));
		userDao.updateUser(user);
	}

	@Test
	public void testSearchUser() {
		List<User> l = userDao.searchUser(0, 2);
		for (User user : l) {
			System.out.println(user);
			String name = user.getName();
			System.out.println(name);
		}
	}

	@Test
	public void testBrowseUser() {
		List<User> l = userDao.browseUser();
		for (int i = 0; i < l.size(); i++) {
			System.err.println(l.get(i));
		}
	}

	@Test
	public void testDelUser() {
		userDao.delUser(1004);
	}
	@Test
	public void testweixinlogin() {
		User u = userDao.weixinBaseUserLogin("ohzOyv0Kp4NHMfbluAmi53oJWBgk");
		System.out.println(u);
	}

	@Test
	public void testLoadUser() {
		Integer userId=1001;
		//if(!userDao.loadUser(userId).equals("")){
		User user = userDao.loadUser(userId);
		System.out.println(user.getNiceName());
		//}
		//System.out.println(user.getName());
	}

}
