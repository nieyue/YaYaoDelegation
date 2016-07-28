package com.nieyue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nieyue.bean.Mer;
import com.nieyue.dao.MerDao;
import com.nieyue.service.MerService;

/**
 * 商品业务实现类
 * @author Administrator
 *
 */
@Service
public class MerServiceImpl implements MerService {
	@Resource
	MerDao merDao;
	/**
	 * 新增商品
	 * @param mer
	 */
	@Override
	public boolean addMer(Mer mer) {
		boolean b = merDao.addMer(mer);
		return b;
		
	}
	/**
	 * 删除指定的商品
	 * @param mer
	 */
	@Override
	public boolean delMer(Integer merId) {
		boolean b =merDao.delMer(merId);
		return b ;
	}
	/**
	 * 更新商品
	 * @param mer
	 */
	@Override
	public boolean updateMer(Mer mer) {
		boolean b =merDao.updateMer(mer);
		return b ;
	}
	/**
	 * 装载指定的商品
	 * @param mer
	 */
	@Override
	public Mer loadMer(Integer merId) {
		Mer m = merDao.loadMer(merId);
		return m;
	}
	/**
	 * 根据商家浏览商品
	 * @param mer
	 */
	@Override
	public List<Mer> browseMer(Integer merStatus, String orderName,
			String orderWay) {
		List<Mer> l = merDao.browseMer(merStatus, orderName, orderWay);
		return l;
	}
	/**
	 * 分页浏览商品
	 * @param mer
	 */
	@Override
	public List<Mer> browsePagingMer(int pageNum, int pageSize,
			Integer merStatus, String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<Mer> l = merDao.browsePagingMer(pageNum-1, pageSize, merStatus, orderName, orderWay);
		return l;
	}
	/**
	 * 后台检索商品（按商品模糊名称）
	 * @param mer
	 */
	@Override
	public List<Mer> searchMer(String merTitle) {
		List<Mer> l = merDao.searchMer(merTitle);
		return l;
	}
	/**
	 * 统计记录条数
	 * @param mer
	 */
	@Override
	public int countRecord(Integer merStatus) {
		int c = merDao.countRecord(merStatus);
		return c;
	}
	
}
