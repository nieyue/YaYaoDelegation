package com.nieyue.service;

import java.util.List;

import com.nieyue.bean.MerImg;
/**
 * 商品图片业务接口
 * @author yy
 *
 */
public interface MerImgService {
	/** 新增商品图片 */	
	public boolean addMerImg(MerImg merImg) ;	
	/** 删除指定的商品 图片*/	
	public boolean delMerImg(Integer sellerId,Integer merImgId) ;	
	/** 更新商品 图片*/	
	public boolean updateMerImg(MerImg merImg);
	/** 装载指定的商品图片 */	
	public MerImg loadMerImg(Integer merId) ;	
	/** 图片地址查询商品图片 */	
	public MerImg loadMerImgByAddress(String merImgAddress) ;	
	/** 浏览商品图片 */
	public List<MerImg> browseMerImgBySeller(Integer sellerId,Integer merId,String orderName,String orderWay) ;	
	/** 分页浏览商品图片 */
	public List<MerImg> browsePagingMerImgBySeller(Integer sellerId,Integer merId,int pageNum,int pageSize,String orderName,String orderWay) ;

}
