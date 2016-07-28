package com.nieyue.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.bean.Mer;
import com.nieyue.dto.StateResult;
import com.nieyue.service.MerService;

/**
 * 商品控制类
 * @author yy
 *
 */
@Controller("merController")
@RequestMapping("/mer")
public class MerController {
	@Resource
	private MerService merService;
	/**
	 * 分页浏览商家的获取所有商品
	 * @param merStatus 上架1 下架0
	 * @param orderName 商品排序数据库字段
	 * @param orderWay 商品排序方法 asc升序 desc降序
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<Mer> browsePagingMer(
			@RequestParam(value="pageNum",defaultValue="0",required=false)int pageNum,@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="merStatus",defaultValue="0",required=false) Integer merStatus,
			@RequestParam(value="orderName",required=false,defaultValue="mer_id") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="asc") String orderWay,HttpSession session)  {
			List<Mer> list = new ArrayList<Mer>();
			if(pageNum==0 ||pageSize==0){//查询所有
				list= merService.browseMer(merStatus, orderName,orderWay);
				return list;
			}
			list= merService.browsePagingMer(pageNum, pageSize, merStatus, orderName, orderWay);
			return list;
	}
	/**
	 * 商品修改
	 * @return
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateMer(@ModelAttribute Mer mer,HttpSession session)  {
		boolean um = merService.updateMer(mer);
		return StateResult.getSR(um);
	}
	/**
	 * 商品增加
	 * @return
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addMer(@ModelAttribute Mer mer, HttpSession session)  {
		boolean am = merService.addMer(mer);
		return StateResult.getSR(am);
	}
	/**
	 * 商品删除
	 * @return
	 */
	@RequestMapping(value = "/{merId}/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delMer(@PathVariable("merId") Integer merId,HttpSession session)  {
		boolean dm = merService.delMer(merId);
		return StateResult.getSR(dm);
	}
	/**
	 * 浏览商品数量
	 * @return
	 */
	@RequestMapping(value = "/count", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody int countRecord(@RequestParam(value="merStatus",required=false) Integer merStatus,HttpSession session)  {
		int count = merService.countRecord(merStatus);
		return count;
	}
	/**
	 * 单个商品加载
	 * @return
	 */
	@RequestMapping(value = "/{merId}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Mer loadMer(@PathVariable("merId") Integer merId,HttpSession session)  {
		Mer mer=new Mer();
		 mer = merService.loadMer(merId);
		return mer;
	}
	
}
