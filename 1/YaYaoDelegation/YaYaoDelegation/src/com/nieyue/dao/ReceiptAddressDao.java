package com.nieyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.ReceiptAddress;
/**
 * 收货地址接口
 * @author yy
 *
 */
public interface ReceiptAddressDao {
	/** 新增收货地址 */	
	public boolean addReceiptAddress(ReceiptAddress receiptAddress) ;	
	/** 删除收货地址 */	
	public boolean delReceiptAddress(Integer receiptAddressId) ;	
	/** 更新收货地址 */	
	public boolean updateReceiptAddress(ReceiptAddress receiptAddress);
	/** 装载收货地址 */	
	public ReceiptAddress loadReceiptAddress(Integer receiptAddressId);	
	/** 查询默认地址 */	
	public ReceiptAddress loadDefaultReceiptAddress(@Param("userId")Integer userId,@Param("isDefault")Integer isDefault);	
	/** 浏览收货地址 */
	public List<ReceiptAddress> browseReceiptAddress(@Param("orderName")String orderName,@Param("orderWay")String orderWay);
	/** 分页收货地址 */
	public List<ReceiptAddress> browsePagingReceiptAddress(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;
}
