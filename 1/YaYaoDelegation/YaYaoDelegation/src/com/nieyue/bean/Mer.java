package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 商品类
 * @author yy
 *
 */
public class Mer implements Serializable {
	
	private static final long serialVersionUID = 8198930199550185349L;
	/**
	 * 商品id
	 */
	private Integer merId;
	/**
	 * 商品缩略图
	 */
	private String merThumbImg;
	/**
	 * 商品名称
	 */
	private String merTitle;
	/**
	 * 商品拼团人数
	 */
	private Integer merPerson;
	/**
	 * 原始价格
	 */
	private Double merOldPrice;
	/**
	 * 拼团价格
	 */
	private Double merPrice;
	/**
	 * 库存
	 */
	private Integer merStock;
	/**
	 * 商品编码
	 */
	private String merCode;
	/**
	 * 折扣
	 */
	private Double merDiscount;
	/**
	 * 包邮(0包邮)
	 */
	private Double merPostage;
	/**
	 * 更新时间
	 */
	private Date merUpdateTime;
	/**
	 * 商品转态(0下架,1上架)
	 */
	private Integer merStatus;
	/**
	 * 商品类型id
	 */
	private Integer merCateId;
	/**
	 * 商户id
	 */
	private Integer sellerId;
	
	
	public Mer() {
		super();
	}


	public Mer(Integer merId, String merThumbImg, String merTitle,
			Integer merPerson, Double merOldPrice, Double merPrice,
			Integer merStock,String merCode, Double merDiscount,
			Double merPostage,Date merUpdateTime, Integer merStatus,
			Integer merCateId,Integer sellerId) {
		super();
		this.merId = merId;
		this.merThumbImg = merThumbImg;
		this.merTitle = merTitle;
		this.merPerson = merPerson;
		this.merOldPrice = merOldPrice;
		this.merPrice = merPrice;
		this.merStock = merStock;
		this.merCode=merCode;
		this.merDiscount = merDiscount;
		this.merPostage = merPostage;
		this.merUpdateTime = merUpdateTime;
		this.merStatus = merStatus;
		this.merCateId=merCateId;
		this.sellerId=sellerId;
	}


	public Integer getMerId() {
		return merId;
	}


	public void setMerId(Integer merId) {
		this.merId = merId;
	}


	public String getMerThumbImg() {
		return merThumbImg;
	}


	public void setMerThumbImg(String merThumbImg) {
		this.merThumbImg = merThumbImg;
	}


	public String getMerTitle() {
		return merTitle;
	}


	public void setMerTitle(String merTitle) {
		this.merTitle = merTitle;
	}


	public Integer getMerPerson() {
		return merPerson;
	}


	public void setMerPerson(Integer merPerson) {
		this.merPerson = merPerson;
	}


	public Double getMerOldPrice() {
		return merOldPrice;
	}


	public void setMerOldPrice(Double merOldPrice) {
		this.merOldPrice = merOldPrice;
	}


	public Double getMerPrice() {
		return merPrice;
	}


	public void setMerPrice(Double merPrice) {
		this.merPrice = merPrice;
	}


	public Integer getMerStock() {
		return merStock;
	}


	public void setMerStock(Integer merStock) {
		this.merStock = merStock;
	}


	public Double getMerDiscount() {
		return merDiscount;
	}


	public void setMerDiscount(Double merDiscount) {
		this.merDiscount = merDiscount;
	}


	public Double getMerPostage() {
		return merPostage;
	}


	public void setMerPostage(Double merPostage) {
		this.merPostage = merPostage;
	}

	public Integer getMerStatus() {
		return merStatus;
	}


	public void setMerStatus(Integer merStatus) {
		this.merStatus = merStatus;
	}

	public Date getMerUpdateTime() {
		return merUpdateTime;
	}
	
	
	public void setMerUpdateTime(Date merUpdateTime) {
		this.merUpdateTime = merUpdateTime;
	}


	public Integer getSellerId() {
		return sellerId;
	}


	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getMerCateId() {
		return merCateId;
	}


	public void setMerCateId(Integer merCateId) {
		this.merCateId = merCateId;
	}


	public String getMerCode() {
		return merCode;
	}


	public void setMerCode(String merCode) {
		this.merCode = merCode;
	}


}
