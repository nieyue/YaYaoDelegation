package com.nieyue.service;

import java.util.List;

import com.nieyue.bean.Seller;
/**
 * 商户业务接口
 * @author yy
 *
 */
public interface SellerService {
	/**商户邮箱登录 */
	public Seller sellerEmailLogin(String sellerEmail,String sellerPassword);	
	/**商户手机登录 */
	public Seller sellerPhoneLogin(String sellerPhone,String sellerPassword);	
	/** 邮箱检测登录商户是否有效 */	
	public boolean chkEmailLoginName(String sellerEmail) ;	
	/** 手机检测登录商户是否有效 */	
	public boolean chkPhoneLoginName(String sellerPhone) ;	
	/** 邮箱找回商户 */	
	public Seller emailRetrieveAccount(String sellerEmail) ;	
	/** 手机找回商户 */	
	public Seller phoneRetrieveAccount(String sellerPhone) ;	
	/** 新增注册商户 */	
	public boolean addSeller(Seller seller) ;
	/** 修改注册商户信息 */	
	public boolean updateSeller(Seller seller);
	/** 分页查询注册商户  */
	public List<Seller> searchSeller(Integer pageNum,Integer pageSize) ;
	/** 浏览注册商户*/
	public List<Seller> browseSeller();
	/** 删除注册商户 */	
	public boolean delSeller(Integer sellerId);
	/**装载注册商户 */	
	public Seller loadSeller(Integer sellerId);		
}
