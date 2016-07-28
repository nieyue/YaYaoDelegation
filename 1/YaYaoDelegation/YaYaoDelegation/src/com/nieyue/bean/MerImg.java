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
	 * 商品id
	 */
	private Integer merId;
	
	
	public MerImg() {
		super();
	}


	public MerImg(Integer merImgId, String merImgAddress,
			Date merImgUpdateTime, Integer merId) {
		super();
		this.merImgId = merImgId;
		this.merImgAddress = merImgAddress;
		this.merImgUpdateTime = merImgUpdateTime;
		this.merId = merId;
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


	@Override
	public String toString() {
		return "MerImg [merImgId=" + merImgId + ", merImgAddress="
				+ merImgAddress + ", merImgUpdateTime=" + merImgUpdateTime
				+ ", merId=" + merId + "]";
	}

	
}
