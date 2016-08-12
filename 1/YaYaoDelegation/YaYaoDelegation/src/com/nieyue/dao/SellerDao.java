package com.nieyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.Seller;
/**
 * 商户管理接口
 * @author yy
 *
 */
public interface SellerDao {
	/**商户邮箱登录 */
	public Seller sellerEmailLogin(@Param("sellerEmail")String sellerEmail,@Param("sellerPassword")String sellerPassword);	
	/**商户手机登录 */
	public Seller sellerPhoneLogin(@Param("sellerPhone")String sellerPhone,@Param("sellerPassword")String sellerPassword);	
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
	public List<Seller> searchSeller(@Param("pageNum") Integer pageNum,@Param("pageSize")Integer pageSize) ;
	/** 浏览注册商户*/
	public List<Seller> browseSeller();
	/** 删除注册商户 */	
	public boolean delSeller(Integer sellerId);
	/**装载注册商户 */	
	public Seller loadSeller(Integer sellerId);		
}
