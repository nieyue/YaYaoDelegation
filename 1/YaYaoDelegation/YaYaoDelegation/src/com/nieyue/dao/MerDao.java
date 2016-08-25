package com.nieyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.Mer;
/**
 * 商品接口
 * @author yy
 *
 */
public interface MerDao {
	/** 新增商品 */	
	public boolean addMer(Mer mer) ;	
	/** 删除指定的商品 */	
	public boolean delMer(@Param("sellerId") Integer sellerId,@Param("merId") Integer merId) ;	
	/** 更新商品 */	
	public boolean updateMer(Mer mer);
	/** 装载指定的商品 */	
	public Mer loadMer(Integer merId);	
	/** 根据商家浏览商品 */
	public List<Mer> browseMerBySeller(@Param("sellerId") Integer sellerId,@Param("merStatus") Integer merStatus,@Param("orderName")String orderName,@Param("orderWay")String orderWay);
	/** 分页浏览商品 */
	public List<Mer> browsePagingMerBySeller(@Param("sellerId") Integer sellerId,@Param("merStatus")Integer merStatus,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;
	/** 后台检索商品（按商品模糊名称） */
	public List<Mer> searchMerBySeller(@Param("sellerId")Integer sellerId,@Param("merTitle")String merTitle) ;	
	/** 统计记录条数 */
	public int countRecordBySeller(@Param("sellerId")Integer sellerId,@Param("merStatus")Integer merStatus);	
}
