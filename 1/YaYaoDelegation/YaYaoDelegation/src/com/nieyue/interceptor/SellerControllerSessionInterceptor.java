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

	private static String getId(HttpServletRequest request,String id,String oid){
		if(request.getParameter(id)!=null){
			return request.getParameter(id);
		}
		return oid;
	}
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws MySellerSessionException {
		String sellerId="";
		sellerId=getId(request, "seller_id",sellerId);
		sellerId=getId(request, "sellerId",sellerId);
		//不拦截系统管理员
		if(request.getSession().getAttribute("admin")!=null){
			return true;
		}
		if(request.getSession().getAttribute("seller")!=null && (((Seller)request.getSession().getAttribute("seller")).getSellerId().equals(Integer.valueOf(sellerId)))){
		return true;
		}
		throw new MySellerSessionException();
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
