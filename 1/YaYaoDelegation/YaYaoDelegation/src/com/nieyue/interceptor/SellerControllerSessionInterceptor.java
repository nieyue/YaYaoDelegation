package com.nieyue.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nieyue.bean.Seller;
import com.nieyue.exception.MySellerSessionException;

/**
 * 商户session控制拦截器
 * @author yy
 *
 */
public class SellerControllerSessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	/*	String sellerId="";
		if(request.getParameter("seller_id")!=null){
			sellerId = request.getParameter("seller_id");
			
		}
		if(request.getParameter("sellerId")!=null){
			sellerId = request.getParameter("sellerId");
			
		}*/
		if(request.getSession().getAttribute("seller")==null/*||!(((Seller)request.getSession().getAttribute("seller")).getSellerId().equals(Integer.valueOf(sellerId)))*/){
			throw new MySellerSessionException();
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
