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
	private Integer userId;
	/**
	 * 开团次数
	 */
	private Integer openNum;
	/**
	 * 参团人数
	 */
	private Integer joinNum;
	/**
	 * 已经成团次数
	 */
	private Integer successNum;
	/**
	 * 已经拼团失败次数
	 */
	private Integer faileNum;
	/**
	 * 业绩
	 */
	private Double performance;
	/**
	 * 获得佣金
	 */
	private Double commission;
	/**
	 * 免单次数
	 */
	private Integer freeNum;
	
	
	public FightGroup() {
		super();
	}


	public FightGroup(Integer fightGroupId, Integer userId, Integer openNum,
			Integer joinNum, Integer successNum, Integer faileNum,
			Double performance, Double commission, Integer freeNum) {
		super();
		this.fightGroupId = fightGroupId;
		this.userId = userId;
		this.openNum = openNum;
		this.joinNum = joinNum;
		this.successNum = successNum;
		this.faileNum = faileNum;
		this.performance = performance;
		this.commission = commission;
		this.freeNum = freeNum;
	}


	public Integer getFightGroupId() {
		return fightGroupId;
	}


	public void setFightGroupId(Integer fightGroupId) {
		this.fightGroupId = fightGroupId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getOpenNum() {
		return openNum;
	}


	public void setOpenNum(Integer openNum) {
		this.openNum = openNum;
	}


	public Integer getJoinNum() {
		return joinNum;
	}


	public void setJoinNum(Integer joinNum) {
		this.joinNum = joinNum;
	}


	public Integer getSuccessNum() {
		return successNum;
	}


	public void setSuccessNum(Integer successNum) {
		this.successNum = successNum;
	}


	public Integer getFaileNum() {
		return faileNum;
	}


	public void setFaileNum(Integer faileNum) {
		this.faileNum = faileNum;
	}


	public Double getPerformance() {
		return performance;
	}


	public void setPerformance(Double performance) {
		this.performance = performance;
	}


	public Double getCommission() {
		return commission;
	}


	public void setCommission(Double commission) {
		this.commission = commission;
	}


	public Integer getFreeNum() {
		return freeNum;
	}


	public void setFreeNum(Integer freeNum) {
		this.freeNum = freeNum;
	}
	
	
}
