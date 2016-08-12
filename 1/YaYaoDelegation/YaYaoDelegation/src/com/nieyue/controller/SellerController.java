package com.nieyue.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nieyue.bean.User;
import com.nieyue.comments.MyValidator;
import com.nieyue.dto.StateResult;
import com.nieyue.mail.SendMailDemo;
import com.nieyue.service.SellerService;
import com.nieyue.util.DateUtil;
import com.nieyue.util.StatusCode;


/**
 * 商户控制类
 * @author yy
 *
 */
@Controller("sellerController")
public class SellerController {
	@Resource
	private SellerService sellerService;
	
	/**
	 * 商户名检查，邮箱和手机
	 * 
	 * @param merSeller
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/chkSellerName", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult chkSellerName(@RequestParam("sellerName") String sellerName) {
		boolean state=false;
		if(Pattern.matches(MyValidator.REGEX_EMAIL,sellerName)){
			state =sellerService.chkEmailLoginName(sellerName);
			if (state) {
				return StateResult.getSlefSR(StatusCode.GetValueByKey(StatusCode.SUCCESS), StatusCode.GetValueByKey(StatusCode.SELLER_EMAIL_EXIST));//商户Email已经存在
			}
			return StateResult.getSlefSR(StatusCode.GetValueByKey(StatusCode.SUCCESS), StatusCode.GetValueByKey(StatusCode.SELLER_EMAIL_NOT_EXIST));//商户Email不存在
		}
		if(Pattern.matches(MyValidator.REGEX_PHONE,sellerName)){
			state =sellerService.chkPhoneLoginName(sellerName);
			if (state) {
				return StateResult.getSlefSR(StatusCode.GetValueByKey(StatusCode.SUCCESS), StatusCode.GetValueByKey(StatusCode.SELLER_PHONE_EXIST));//商户手机已经存在
			}
			return StateResult.getSlefSR(StatusCode.GetValueByKey(StatusCode.SUCCESS), StatusCode.GetValueByKey(StatusCode.SELLER_PHONE_NOT_EXIST));//商户手机不存在
		}
		return StateResult.getSlefSR(StatusCode.GetValueByKey(StatusCode.SUCCESS), StatusCode.GetValueByKey(StatusCode.INPUT_ERROR));//输入错误
	}
	/**
	 * 邮箱/手机验证码发送
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws ParseException 
	 */
	/*@RequestMapping(value = "/sellerPhoneValidCode", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	StateResult validCode(@RequestParam("sellerName") final String sellerName,HttpSession session) throws ParseException {
		String uvc="";
		String uvce="";
		if(Pattern.matches(MyValidator.REGEX_EMAIL,sellerName)){
			uvc="userEmailValidCode";
			uvce="userEmailValidCodeExpire";
		}
		if(Pattern.matches(MyValidator.REGEX_PHONE,sellerName)){
			uvc="userPhoneValidCode";
			uvce="userPhoneValidCodeExpire";
		}
		
		if(session.getAttribute(uvce)!=null){
			String sessionvce = session.getAttribute(uvce).toString();
			if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 1)))){//没超过一分钟
				return StateResult.getSlefSR(StatusCode.GetValueByKey(StatusCode.SUCCESS), StatusCode.GetValueByKey(StatusCode.ONE_ASK_ONE));
		}
			
		}		
		Integer userValidCode=(int) (Math.random()*8999)+1000;
		try {
			if(Pattern.matches(MyValidator.REGEX_EMAIL,sellerName)){
				SendMailDemo.sendSafeMail(sellerName,Integer.valueOf(userValidCode));
			}
			if(Pattern.matches(MyValidator.REGEX_PHONE,accountName)){
				SMSInterface.SmsNumSend(String.valueOf(userValidCode), accountName,StatusCode.GetValueByKey(StatusCode.SMS_TEMPLATE_CODE_REG));
			}
		} catch (NumberFormatException e) {
			return null;
		} catch (InterruptedException e) {
			return null;
		}
		session.setAttribute(uvc,userValidCode);
		session.setAttribute(uvce,DateUtil.getCurrentTime());
		return StatusCode.GetValueByKey(StatusCode.SUCCESS);
	}*/
	/**
	 * 手机验证码发送
	 * 
	 * @param seller
	 * @param session
	 * @return
	 * @throws ParseException 
	 */
	/*@RequestMapping(value = "/sellerPhoneValidCode", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String validCode34(@RequestParam("accountName") final String sellerPhone,HttpSession session) throws ParseException {
		if(session.getAttribute("sellerPhoneValidCodeExpire")!=null){
			String sessionvce = session.getAttribute("sellerPhoneValidCodeExpire").toString();
			if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 1)))){//没超过一分钟
			return StatusCode.GetValueByKey(StatusCode.ONE_ASK_ONE);
		}
			
		}		
		
		Integer sellerPhoneValidCode=(int) (Math.random()*9000+1000);
		try {
				SMSInterface.SmsNumSend(String.valueOf(sellerPhoneValidCode), sellerPhone,StatusCode.GetValueByKey(StatusCode.SMS_TEMPLATE_CODE_REG));
		} catch (Exception e) {
			return null;
		} 
		session.setAttribute("sellerPhoneValidCode",sellerPhoneValidCode);
		session.setAttribute("sellerPhoneValidCodeExpire",DateUtil.getCurrentTime());
		return StatusCode.GetValueByKey(StatusCode.SUCCESS);
	}
	*//**
	 * 手机验证码验证
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 *//*
	@RequestMapping(value = "/chkSellerPhoneValidCode", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String chkValidCode(@RequestParam("validCode")String sellerPhoneValidCode,HttpSession session) throws NumberFormatException, ParseException {
		if(!NumberUtil.isNumeric(sellerPhoneValidCode)){
			return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR);
		}
		if(session.getAttribute("sellerPhoneValidCodeExpire")==null){
			return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR);
		}
		String sessionvce = session.getAttribute("sellerPhoneValidCodeExpire").toString();
		if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 10)))){//没过期
			if(Integer.valueOf(session.getAttribute("sellerPhoneValidCode").toString()).equals(Integer.valueOf(sellerPhoneValidCode))){
				return StatusCode.GetValueByKey(StatusCode.SUCCESS);
			
		}
			return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR);
			
		}
		return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_EXPIRED);
	}*/
	/**
	 * 商户手机注册
	 * @param merSeller
	 * @param modelMap
	 * @return
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 * @throws Exception 
	 */
	/*@RequestMapping(value = "/sellerPhoneRegister", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	Seller merSellerRegister(@ModelAttribute Seller seller,@RequestParam("validCode") String sellerPhoneValidCode, HttpSession session) throws Exception {
		
		 * if(result.hasErrors()){
		 * //customer.setContent(result.getFieldError().getDefaultMessage());
		 * return null; }
		 
		if(!NumberUtil.isNumeric(sellerPhoneValidCode)){
			return null;
		}
		if(session.getAttribute("sellerPhoneValidCodeExpire")==null){
			return null;
		}
		
		String sessionvce = session.getAttribute("sellerPhoneValidCodeExpire").toString();
		if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 10)))){//没过期
			if(Integer.valueOf(session.getAttribute("sellerPhoneValidCode").toString()).equals(Integer.valueOf(sellerPhoneValidCode))){
			String shalp = MyDESutil.getMD5(seller.getSellerPassword());
			seller.setSellerPassword(shalp);
		
		boolean status = sellerService.addSeller(seller);
		if(status){
			//成功则清除validcode
			session.removeAttribute("sellerPhoneValidCodeExpire");
			session.removeAttribute("sellerPhoneValidCode");
			seller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
			seller.setSellerToken( MyDESutil.getMD5(seller.getSellerPhone()));//设置token
			session.setAttribute("seller", seller);
			return seller;
		}
		return null;
			}
			seller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR));
			return seller;
		}
		seller.setSellerMsg(StatusCode.GetValueByKey("VERIFICATION_CODE_EXPIRED"));
		
		return seller;
		
	}
	
	*//**
	 * 商户手动登录
	 * 
	 * @param merSeller
	 * @param session
	 * @return
	 * @throws Exception 
	 *//*
	@RequestMapping(value = "/sellerLogin", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	Seller sellerLogin(HttpSession session,@RequestParam("sellerName")String sellerName,@RequestParam("sellerPassword")String sellerPassword) {
		boolean status = sellerService.chkLoginName(sellerName);
		if(status&&sellerPassword!=null){
			String shaup =  MyDESutil.getMD5(sellerPassword);
			Seller seller = sellerService.merSellerLogin(sellerName, shaup);
			if(seller!=null){
				seller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
				seller.setSellerToken( MyDESutil.getMD5(sellerName));//设置token
				session.setAttribute("seller", seller);
				return seller;
			}
		}
		
		return null;
		
	}*/
	/**
	 * 商户自动登录
	 * 
	 * @param merSeller
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	/*@RequestMapping(value = "/sellerAutoLogin", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	Seller sellerAutoLogin(HttpSession session,@RequestParam("sellerId")Integer sellerId,@RequestParam("sellerLoginState")String sellerLoginState,@RequestParam("sellerToken")String sellerToken){
		Seller seller=new Seller();
		//如果会话存在
		if(session.getAttribute("seller")!=null&&((Seller)session.getAttribute("seller")).getSellerId().equals(sellerId)){
			seller=(Seller) session.getAttribute("seller");
			seller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
			return seller;
		}
		//如何会话不存在，新会话
		if(sellerToken!=null){
			//没有设置自动登录
			if(sellerLoginState.equals("0")){
				seller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.SESSION_EXPIRED));
				return seller;
			}
			//设置自动登录
			if(sellerLoginState.equals("1")){
			seller =sellerService.loadSeller(Integer.valueOf(sellerId));
			if( MyDESutil.getMD5(seller.getSellerEmail()).equals(sellerToken)|| MyDESutil.getMD5(seller.getSellerPhone()).equals(sellerToken)){
				seller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
				session.setAttribute("seller", seller);
			}
			}
		}
		return seller;
	}*/
	/**
	 * 商户登出
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/sellerLoginOut", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody void sellerLoginOut(HttpSession session) {
		if(session.getAttribute("seller")!=null){
			session.invalidate();
		}
		
	}
	/**
	 * sellerImg商户店铺图片上传
	 * 
	 * @param seller
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	/*@RequestMapping(value = "/sellerImgUpload", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String sellerImgUpload(@RequestParam("seller_file") MultipartFile file,HttpSession session,@RequestParam("seller_id")Integer id)  {
			Seller s = sellerService.loadSeller(id);
			//删除原图片
			String	oldIMGURL=s.getSellerImg();
			String userIMG = null;
			 try{
				 userIMG = FileUploadUtil.FormDataFileUpload(file, session,"/resources/sellerUpload",id.toString(),oldIMGURL);
				 s.setSellerImg(userIMG);
			}catch (IOException e) {
				e.printStackTrace();
			}
			sellerService.updateSeller(s);
			 return userIMG;
		}
	*/
	/**
	 * 商户修改属性
	 * 
	 * @param seller
	 * @param session
	 * @return
	 * @throws Exception 
	 */   
	/*@RequestMapping(value = "/updateSellerInfo", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String updateSeller(HttpSession session ,@RequestParam("sellerId")Integer sellerId,@RequestParam(value="sellerNiceName" ,required=false) String sellerNiceName,@RequestParam(value="sellerSignature" ,required=false) String sellerSignature)  {
		Seller seller = sellerService.loadSeller(sellerId);
		seller.setSellerNiceName(sellerNiceName);
		seller.setSellerSignature(sellerSignature);
		sellerService.updateSeller(seller);
		 session.setAttribute("seller",seller);
		return StatusCode.GetValueByKey(StatusCode.SUCCESS);
	}
	*/
	
}
