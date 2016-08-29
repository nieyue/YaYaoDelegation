package com.nieyue.controller;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.bean.Mer;
import com.nieyue.bean.MerImg;
import com.nieyue.dto.StateResult;
import com.nieyue.service.MerImgService;
import com.nieyue.service.MerService;
import com.nieyue.util.DateUtil;

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
	@Resource
	private MerImgService merImgService;
	/**
	 * 分页浏览商家的获取所有商品
	 * @param merStatus 上架1 下架0
	 * @param orderName 商品排序数据库字段
	 * @param orderWay 商品排序方法 asc升序 desc降序
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<Mer> browsePagingMerBySeller(
			@RequestParam(value="sellerId") Integer sellerId,
			@RequestParam(value="merStatus",defaultValue="1",required=false) Integer merStatus,
			@RequestParam(value="pageNum",defaultValue="0",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="orderName",required=false,defaultValue="mer_id") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="asc") String orderWay,HttpSession session)  {
			List<Mer> list = new ArrayList<Mer>();
			if(pageNum==0 || pageSize==0){//查询所有
				list= merService.browseMerBySeller(sellerId,merStatus, orderName,orderWay);
				return list;
			}
			list= merService.browsePagingMerBySeller(sellerId,merStatus,pageNum, pageSize, orderName, orderWay);
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
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addMer(@ModelAttribute Mer mer, @RequestParam("merImgList") String merImgList,  HttpSession session) throws IllegalAccessException, InvocationTargetException, ParseException  {
		boolean am = merService.addMer(mer);
		if(am){
			JSONArray json=JSONArray.fromObject(merImgList);
			for (int i = 0; i < json.size(); i++) {
				MerImg merImg = new MerImg();
				JSONObject jo = JSONObject.fromObject(json.get(i));
				Integer merImgId = (Integer) jo.get("mer_img_id");
				String merImgAddress = (String) jo.get("mer_img_address");
				String merImgUpdateTime = (String) jo.get("mer_img_update_time");
				Integer orderNum = (Integer) jo.get("order_num");
				Integer sellerId = (Integer) jo.get("seller_id");
				merImg.setMerImgId(merImgId);
				merImg.setMerImgAddress(merImgAddress);
				merImg.setMerImgUpdateTime(DateUtil.parseDate(merImgUpdateTime));
				merImg.setOrderNum(orderNum);
				merImg.setMerId(mer.getMerId());
				merImg.setSellerId(sellerId);
				merImgService.updateMerImg(merImg);
			}
		}
		return StateResult.getSR(am);
	}
	/**
	 * 商品删除
	 * @return
	 */
	@RequestMapping(value = "/{merId}/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delMer(@RequestParam(value="sellerId") Integer sellerId,@PathVariable("merId") Integer merId,HttpSession session)  {
		boolean dm = merService.delMer(sellerId,merId);
		return StateResult.getSR(dm);
	}
	/**
	 * 浏览商品数量
	 * @return
	 */
	@RequestMapping(value = "/count", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody int countRecord(@RequestParam(value="sellerId") Integer sellerId,@RequestParam(value="merStatus",required=false) Integer merStatus,HttpSession session)  {
		int count = merService.countRecordBySeller(sellerId,merStatus);
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
