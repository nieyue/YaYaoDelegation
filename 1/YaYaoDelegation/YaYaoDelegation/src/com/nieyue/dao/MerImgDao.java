package com.nieyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.MerImg;
/**
 * 商品图片接口
 * @author yy
 *
 */
public interface MerImgDao {
	/** 新增商品图片 */	
	public boolean addMerImg(MerImg merImg) ;	
	/** 删除指定的商品 图片*/	
	public boolean delMerImg(@Param("sellerId")Integer sellerId,@Param("merImgId")Integer merImgId) ;	
	/** 更新商品 图片*/	
	public boolean updateMerImg(MerImg merImg);
	/** 装载指定的商品图片 */	
	public MerImg loadMerImg(Integer merId) ;	
	/** 图片地址查询商品图片 */	
	public MerImg loadMerImgByAddress(String merImgAddress) ;	
	/** 浏览商品图片 */
	public List<MerImg> browseMerImgBySeller(@Param("sellerId")Integer sellerId,@Param("merId")Integer merId,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;	
	/** 分页浏览商品图片 */
	public List<MerImg> browsePagingMerImgBySeller(@Param("sellerId")Integer sellerId,@Param("merId")Integer merId,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;
	
}
