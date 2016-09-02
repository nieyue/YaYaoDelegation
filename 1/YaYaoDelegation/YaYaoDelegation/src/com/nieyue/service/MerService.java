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
	public boolean delMer(Integer sellerId,Integer merId) ;	
	/** 更新商品 */	
	public boolean updateMer(Mer mer);
	/** 装载指定的商品 */	
	public Mer loadMer(Integer merId);	
	/** 根据商品图片标识装载指定的商品 */	
	public Mer loadMerByMerImgIdentify(String merImgIdentify);	
	/** 根据商家浏览商品 */
	public List<Mer> browseMerBySeller(Integer sellerId, Integer merStatus,String orderName,String orderWay);
	/** 分页浏览商品 */
	public List<Mer> browsePagingMerBySeller(Integer sellerId,Integer merStatus,int pageNum,int pageSize,String orderName,String orderWay) ;
	/** 后台检索商品（按商品模糊名称） */
	public List<Mer> searchMerBySeller(Integer sellerId,String merTitle) ;	
	/** 统计记录条数 */
	public int countRecordBySeller(Integer sellerId,Integer merStatus);	
}
