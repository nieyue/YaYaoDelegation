package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 商品图片类
 * @author yy
 *
 */
public class MerImg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品图片id
	 */
	private Integer merImgId;
	/**
	 * 商品图片地址
	 */
	private String merImgAddress;
	/**
	 * 商品图片更新时间
	 */
	private Date merImgUpdateTime;
	/**
	 * 排序
	 */
	private Integer order;
	/**
	 * 商品id
	 */
	private Integer merId;
	/**
	 * 商户id
	 */
	private Integer sellerId;
	
	
	public MerImg() {
		super();
	}


	public MerImg(Integer merImgId, String merImgAddress,Date merImgUpdateTime,
			Integer order,Integer merId,Integer sellerId) {
		super();
		this.merImgId = merImgId;
		this.merImgAddress = merImgAddress;
		this.merImgUpdateTime = merImgUpdateTime;
		this.order = order;
		this.merId = merId;
		this.sellerId=sellerId;
	}


	public Integer getMerImgId() {
		return merImgId;
	}


	public void setMerImgId(Integer merImgId) {
		this.merImgId = merImgId;
	}


	public String getMerImgAddress() {
		return merImgAddress;
	}


	public void setMerImgAddress(String merImgAddress) {
		this.merImgAddress = merImgAddress;
	}


	public Date getMerImgUpdateTime() {
		return merImgUpdateTime;
	}


	public void setMerImgUpdateTime(Date merImgUpdateTime) {
		this.merImgUpdateTime = merImgUpdateTime;
	}


	public Integer getMerId() {
		return merId;
	}


	public void setMerId(Integer merId) {
		this.merId = merId;
	}


	public Integer getSellerId() {
		return sellerId;
	}


	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}


	public Integer getOrder() {
		return order;
	}


	public void setOrder(Integer order) {
		this.order = order;
	}

	
}
