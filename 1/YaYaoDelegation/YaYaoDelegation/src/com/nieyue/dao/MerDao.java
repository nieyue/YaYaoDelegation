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
	public boolean delMer(Integer merId) ;	
	/** 更新商品 */	
	public boolean updateMer(Mer mer);
	/** 装载指定的商品 */	
	public Mer loadMer(Integer merId);	
	/** 根据商家浏览商品 */
	public List<Mer> browseMer(@Param("merStatus") Integer merStatus,@Param("orderName")String orderName,@Param("orderWay")String orderWay);
	/** 分页浏览商品 */
	public List<Mer> browsePagingMer(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize,@Param("merStatus")Integer merStatus,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;
	/** 后台检索商品（按商品模糊名称） */
	public List<Mer> searchMer(String merTitle) ;	
	/** 统计记录条数 */
	public int countRecord(Integer merStatus);	
}
