package com.nieyue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nieyue.bean.Seller;
import com.nieyue.dao.SellerDao;
import com.nieyue.service.SellerService;

/**
 * 商户业务实现类
 * @author Administrator
 *
 */
@Service
public class SellerServiceImpl implements SellerService {
	@Resource
	SellerDao sellerDao;
	/**商户邮箱登录 */
	@Override
	public Seller sellerEmailLogin(String sellerEmail, String sellerPassword) {
		Seller s = sellerDao.sellerEmailLogin(sellerEmail, sellerPassword);
		return s;
	}
	/**商户手机登录 */
	@Override
	public Seller sellerPhoneLogin(String sellerPhone, String sellerPassword) {
		Seller s = sellerDao.sellerEmailLogin(sellerPhone, sellerPassword);
		return s;
	}
	/** 邮箱检测登录商户是否有效 */	
	@Override
	public boolean chkEmailLoginName(String sellerEmail) {
		boolean b = sellerDao.chkEmailLoginName(sellerEmail);
		return b;
	}
	/** 手机检测登录商户是否有效 */
	@Override
	public boolean chkPhoneLoginName(String sellerPhone) {
		boolean b = sellerDao.chkEmailLoginName(sellerPhone);
		return b;
	}
	/** 邮箱找回商户 */
	@Override
	public Seller emailRetrieveAccount(String sellerEmail) {
		Seller s = sellerDao.emailRetrieveAccount(sellerEmail);
		return s;
	}
	/** 手机找回商户 */	
	@Override
	public Seller phoneRetrieveAccount(String sellerPhone) {
		Seller s = sellerDao.emailRetrieveAccount(sellerPhone);
		return s;
	}
	/** 新增注册商户 */	
	@Override
	public boolean addSeller(Seller seller) {
		boolean b = sellerDao.addSeller(seller);
		return b;
	}
	/** 修改注册商户信息 */
	@Override
	public boolean updateSeller(Seller seller) {
		boolean b = sellerDao.updateSeller(seller);
		return b;
	}
	/** 分页查询注册商户  */
	@Override
	public List<Seller> searchSeller(Integer pageNum, Integer pageSize) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<Seller> l = sellerDao.searchSeller(pageNum-1, pageSize);
		return l;
	}
	/** 浏览注册商户*/
	@Override
	public List<Seller> browseSeller() {
		List<Seller> l = sellerDao.browseSeller();
		return l;
	}
	/** 删除注册商户 */
	@Override
	public boolean delSeller(Integer sellerId) {
		boolean b = sellerDao.delSeller(sellerId);
		return b;
	}
	/**装载注册商户 */
	@Override
	public Seller loadSeller(Integer sellerId) {
		Seller s = sellerDao.loadSeller(sellerId);
		return s;
	}

}
