package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 收货地址类
 * @author yy
 *
 */
public class ReceiptAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 收货地址id
	 */
	private Integer receiptAddressId;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 收货地址姓名
	 */
	private String receiptAddressName;
	/**
	 * 收货地址手机号
	 */
	private String receiptAddressPhone;
	/**
	 * 收货地址
	 */
	private String receiptAddressSite;
	/**
	 * 收货地址更新时间
	 */
	private Date  receiptAddressUpdateTime;
	/**
	 * 是否默认收货地址,1是，0不是默认为0
	 */
	private Integer  isDefault;
	
	
	public ReceiptAddress() {
		super();
	}


	public ReceiptAddress(Integer receiptAddressId,Integer userId,String receiptAddressName,
			String receiptAddressPhone, String receiptAddressSite,Date  receiptAddressUpdateTime,Integer isDefault) {
		super();
		this.receiptAddressId = receiptAddressId;
		this.userId = userId;
		this.receiptAddressName = receiptAddressName;
		this.receiptAddressPhone = receiptAddressPhone;
		this.receiptAddressSite = receiptAddressSite;
		this.receiptAddressUpdateTime =receiptAddressUpdateTime;
		this.isDefault=isDefault;
	}


	public Integer getReceiptAddressId() {
		return receiptAddressId;
	}


	public void setReceiptAddressId(Integer receiptAddressId) {
		this.receiptAddressId = receiptAddressId;
	}


	public String getReceiptAddressName() {
		return receiptAddressName;
	}


	public void setReceiptAddressName(String receiptAddressName) {
		this.receiptAddressName = receiptAddressName;
	}


	public String getReceiptAddressPhone() {
		return receiptAddressPhone;
	}


	public void setReceiptAddressPhone(String receiptAddressPhone) {
		this.receiptAddressPhone = receiptAddressPhone;
	}


	public String getReceiptAddressSite() {
		return receiptAddressSite;
	}


	public void setReceiptAddressSite(String receiptAddressSite) {
		this.receiptAddressSite = receiptAddressSite;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Date getReceiptAddressUpdateTime() {
		return receiptAddressUpdateTime;
	}


	public void setReceiptAddressUpdateTime(Date receiptAddressUpdateTime) {
		this.receiptAddressUpdateTime = receiptAddressUpdateTime;
	}


	public Integer getIsDefault() {
		return isDefault;
	}


	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	
	
}
