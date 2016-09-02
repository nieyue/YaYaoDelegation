package com.nieyue.bean;

import java.io.Serializable;

/**
 * 拼团类
 * 
 * @author yy
 * 
 */
public class FightGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 拼团id
	 */
	private Integer fightGroupId;
	/**
	 * 拼团队长id
	 */
	private Integer merGroupId;
	/**
	 * 商品id
	 */
	private Integer merId;
	/**
	 * 开团人数
	 */
	private Integer openPerson;
	/**
	 * 已参团人数
	 */
	private Integer joinPerson;
	
	/**
	 * 团长佣金比例
	 */
	private Integer merGroupDiscount;
	/**
	 * 团长佣金
	 */
	private Double merGroupCommission;
	/**
	 * 是否免单0,不免， 1,免单
	 */
	private Integer isFree;
	/**
	 * 开团时间
	 */
	private Integer openGroupTime;
	/**
	 * 是否成功 0,失败， 1,成功
	 */
	private Integer isSuccess;
	/**
	 * sellerId
	 */
	private Integer sellerId;
	
	
	public FightGroup() {
		super();
	}


	public FightGroup(Integer fightGroupId, Integer merGroupId, Integer merId,
			Integer openPerson, Integer joinPerson, Integer merGroupDiscount,
			Double merGroupCommission, Integer isFree, Integer openGroupTime,
			Integer isSuccess,Integer sellerId) {
		super();
		this.fightGroupId = fightGroupId;
		this.merGroupId = merGroupId;
		this.merId = merId;
		this.openPerson = openPerson;
		this.joinPerson = joinPerson;
		this.merGroupDiscount = merGroupDiscount;
		this.merGroupCommission = merGroupCommission;
		this.isFree = isFree;
		this.openGroupTime = openGroupTime;
		this.isSuccess = isSuccess;
		this.sellerId=sellerId;
	}


	public Integer getFightGroupId() {
		return fightGroupId;
	}


	public void setFightGroupId(Integer fightGroupId) {
		this.fightGroupId = fightGroupId;
	}


	public Integer getMerGroupId() {
		return merGroupId;
	}


	public void setMerGroupId(Integer merGroupId) {
		this.merGroupId = merGroupId;
	}


	public Integer getMerId() {
		return merId;
	}


	public void setMerId(Integer merId) {
		this.merId = merId;
	}


	public Integer getOpenPerson() {
		return openPerson;
	}


	public void setOpenPerson(Integer openPerson) {
		this.openPerson = openPerson;
	}


	public Integer getJoinPerson() {
		return joinPerson;
	}


	public void setJoinPerson(Integer joinPerson) {
		this.joinPerson = joinPerson;
	}


	public Integer getMerGroupDiscount() {
		return merGroupDiscount;
	}


	public void setMerGroupDiscount(Integer merGroupDiscount) {
		this.merGroupDiscount = merGroupDiscount;
	}


	public Double getMerGroupCommission() {
		return merGroupCommission;
	}


	public void setMerGroupCommission(Double merGroupCommission) {
		this.merGroupCommission = merGroupCommission;
	}


	public Integer getIsFree() {
		return isFree;
	}


	public void setIsFree(Integer isFree) {
		this.isFree = isFree;
	}


	public Integer getOpenGroupTime() {
		return openGroupTime;
	}


	public void setOpenGroupTime(Integer openGroupTime) {
		this.openGroupTime = openGroupTime;
	}


	public Integer getIsSuccess() {
		return isSuccess;
	}


	public void setIsSuccess(Integer isSuccess) {
		this.isSuccess = isSuccess;
	}
	public static void main(String[] args) {
		System.out.println(serialVersionUID);
		
	}


	public Integer getSellerId() {
		return sellerId;
	}


	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
}
