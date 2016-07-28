package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 卖家类
 * 
 * @author yy
 * 
 */
public class Seller implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 店铺id
	 */
	private Integer sellerId;
	/**
	 * 商品
	 */
	private Set<Mer> mer;
	/**
	 * 邮箱
	 */
	private String sellerEmail;
	/**
	 * 手机号
	 */
	private String sellerPhone;
	/**
	 * 登录密码
	 */
	private String sellerPassword;
	/**
	 * 店铺昵称
	 */
	private String sellerNiceName;
	/**
	 * 店铺图片
	 */
	private String sellerImg;
	/**
	 * 店铺宣传信息
	 */
	private String sellerSignature;
	/**
	 * 店铺收藏数
	 */
	private Integer sellerNumber;
	/**
	 * 是否企业认证商户默认为0，未认证
	 */
	private Integer isAuthentication;
	/**
	 * 注册时间
	 */
	private Date registerDate;
	/**
	 * 认证时间
	 */
	private Date authenticationDate;
	/**
	 * appid
	 */
	private String appid;
	/**
	 * secret
	 */
	private String secret;

	public Seller() {
		super();
	}

	public Seller(Integer sellerId, Set<Mer> mer, String sellerEmail,
			String sellerPhone, String sellerPassword, String sellerNiceName,
			String sellerImg, String sellerSignature, Integer sellerNumber,
			Integer isAuthentication, Date registerDate,
			Date authenticationDate,String appid, String secret) {
		super();
		this.sellerId = sellerId;
		this.mer = mer;
		this.sellerEmail = sellerEmail;
		this.sellerPhone = sellerPhone;
		this.sellerPassword = sellerPassword;
		this.sellerNiceName = sellerNiceName;
		this.sellerImg = sellerImg;
		this.sellerSignature = sellerSignature;
		this.sellerNumber = sellerNumber;
		this.isAuthentication = isAuthentication;
		this.registerDate = registerDate;
		this.authenticationDate = authenticationDate;
		this.setAppid(appid);
		this.secret = secret;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Set<Mer> getMer() {
		return mer;
	}

	public void setMer(Set<Mer> mer) {
		this.mer = mer;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getSellerPhone() {
		return sellerPhone;
	}

	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public String getSellerPassword() {
		return sellerPassword;
	}

	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}

	public String getSellerNiceName() {
		return sellerNiceName;
	}

	public void setSellerNiceName(String sellerNiceName) {
		this.sellerNiceName = sellerNiceName;
	}

	public String getSellerImg() {
		return sellerImg;
	}

	public void setSellerImg(String sellerImg) {
		this.sellerImg = sellerImg;
	}

	public String getSellerSignature() {
		return sellerSignature;
	}

	public void setSellerSignature(String sellerSignature) {
		this.sellerSignature = sellerSignature;
	}

	public Integer getSellerNumber() {
		return sellerNumber;
	}

	public void setSellerNumber(Integer sellerNumber) {
		this.sellerNumber = sellerNumber;
	}

	public Integer getIsAuthentication() {
		return isAuthentication;
	}

	public void setIsAuthentication(Integer isAuthentication) {
		this.isAuthentication = isAuthentication;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getAuthenticationDate() {
		return authenticationDate;
	}

	public void setAuthenticationDate(Date authenticationDate) {
		this.authenticationDate = authenticationDate;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

}
