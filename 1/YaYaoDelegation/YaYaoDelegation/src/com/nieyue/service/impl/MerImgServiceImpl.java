package com.nieyue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nieyue.bean.MerImg;
import com.nieyue.dao.MerImgDao;
import com.nieyue.service.MerImgService;

/**
 * 商品图片业务实现类
 * @author Administrator
 *
 */
@Service
public class MerImgServiceImpl implements MerImgService {
	@Resource
	MerImgDao merImgDao;
	/**
	 * 新增商品图片
	 * @param merImg
	 */
	@Override
	public boolean addMerImg(MerImg merImg) {
		boolean b = merImgDao.addMerImg(merImg);
		return b;
		
	}
	/**
	 * 删除指定的商品图片
	 * @param merImg
	 */
	@Override
	public boolean delMerImg(Integer merImgId) {
		boolean b =merImgDao.delMerImg(merImgId);
		return b ;
	}
	/**
	 * 更新商品图片
	 * @param merImg
	 */
	@Override
	public boolean updateMerImg(MerImg merImg) {
		boolean b =merImgDao.updateMerImg(merImg);
		return b ;
	}
	/**
	 * 装载指定的商品图片
	 * @param merImg
	 */
	@Override
	public MerImg loadMerImg(Integer merImgId) {
		MerImg mi = merImgDao.loadMerImg(merImgId);
		return mi;
	}
	/**
	 * 根据商家浏览商品图片
	 * @param merImg
	 */
	@Override
	public List<MerImg> browseMerImg(Integer merId, String orderName,
			String orderWay) {
		List<MerImg> l = merImgDao.browseMerImg(merId, orderName, orderWay);
		return l;
	}
	/**
	 * 分页浏览商品图片
	 * @param merImg
	 */
	@Override
	public List<MerImg> browsePagingMerImg(Integer merId,int pageNum, int pageSize, String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<MerImg> l = merImgDao.browsePagingMerImg(merId,pageNum-1, pageSize, orderName, orderWay);
		return l;
	}
	/**
	 * 根据图片地址加载图片
	 * @param merImg
	 */
	@Override
	public MerImg loadMerImgByAddress(String merImgAddress) {
		MerImg merImg = merImgDao.loadMerImgByAddress(merImgAddress);
		return merImg;
	}

}
