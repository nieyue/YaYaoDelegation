package com.nieyue.service;

import java.util.List;

import com.nieyue.bean.Mer;
/**
 * 商品业务接口
 * @author yy
 *
 */
public interface MerService {
	/** 新增商品 */	
	public boolean addMer(Mer mer) ;	
	/** 删除指定的商品 */	
	public boolean delMer(Integer merId) ;	
	/** 更新商品 */	
	public boolean updateMer(Mer mer);
	/** 装载指定的商品 */	
	public Mer loadMer(Integer merId);	
	/** 根据商家浏览商品 */
	public List<Mer> browseMer( Integer merStatus,String orderName,String orderWay);
	/** 分页浏览商品 */
	public List<Mer> browsePagingMer(int pageNum,int pageSize,Integer merStatus,String orderName,String orderWay) ;
	/** 后台检索商品（按商品模糊名称） */
	public List<Mer> searchMer(String merTitle) ;	
	/** 统计记录条数 */
	public int countRecord(Integer merStatus);	
}
