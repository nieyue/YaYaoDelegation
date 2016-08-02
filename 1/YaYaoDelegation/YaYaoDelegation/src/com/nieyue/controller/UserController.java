package com.nieyue.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.bean.User;
import com.nieyue.dto.StateResult;
import com.nieyue.service.UserService;

/**
 * 用户控制类
 * @author yy
 *
 */
@Controller("userController")
public class UserController {
	@Resource
	private UserService userService;
	
	/**
	 * xml
	 * @return
	 */
	@RequestMapping(value="/xml",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult test2(@RequestBody User u){
		System.out.println(u);
		return StateResult.getFail();
		
	}
	
	
}
