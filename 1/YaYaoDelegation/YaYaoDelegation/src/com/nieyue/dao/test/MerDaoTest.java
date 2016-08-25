package com.nieyue.dao.test;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nieyue.bean.Mer;
import com.nieyue.dao.MerDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-dao.xml")
public class MerDaoTest {
	@Resource
	MerDao merDao;
	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddMer() {
		for (int i = 0; i < 3; i++) {
			Mer mer=new Mer();
			if(Math.random()*10>5){
				mer.setMerStatus(0);
			}
		mer.setMerThumbImg("/resources/sellerUpload/7/黑茶/百两茶/百两茶_"+(i+4)+".jpg");
		mer.setMerTitle("百两茶"+(i+4));
		mer.setMerPerson(2);
		mer.setMerOldPrice(55.00);
		mer.setMerPrice(50.00);
		mer.setMerStock(999);
		mer.setSellerId(23);
		//mer.setMerDiscount(0.00);//默认1.00
		//mer.setMerPostage(1.00);//默认0.00
		//mer.setMerUpdateTime(new Date());//默认当前时间
		//mer.setMerStatus(0);//默认1
		merDao.addMer(mer);
		}
	}

	@Test
	public void testDelMer() {
		boolean b = merDao.delMer(23,1014);
		System.out.println(b);
	}

	@Test
	public void testUpdateMer() {
		Mer mer = merDao.loadMer(1014);
		//Mer mer = new Mer();
		//mer.setMerId(1013);
		System.out.println(mer.getMerStatus());
		mer.setMerStatus(0);
		System.out.println(mer.getMerStatus());
		//mer.setMerUpdateTime(new Date());
		merDao.updateMer(mer);
	}

	@Test
	public void testLoadMer() {
		Mer mer = merDao.loadMer(1014);
		System.out.println(JSONObject.fromObject(mer));
	}

	@Test
	public void testBrowseMer() {
		List<Mer> list = merDao.browseMerBySeller(23,1, "mer_id", "desc");
		for (int i = 0; i < list.size(); i++) {
			Mer mer = list.get(i);
			System.out.println(mer.getMerThumbImg());
		}
	}

	@Test
	public void testBrowsePagingMer() {
		List<Mer> list = merDao.browsePagingMerBySeller(23,1, 3, 5,"mer_id", "asc");
		for (int i = 0; i < list.size(); i++) {
			Mer mer = list.get(i);
			System.out.println(mer.getMerThumbImg());
		}
	}

	@Test
	public void testSearchMer() {
		List<Mer> list = merDao.searchMerBySeller(23,"4");
		for (int i = 0; i < list.size(); i++) {
			Mer mer = list.get(i);
			System.out.println(mer.getMerThumbImg());
		}
	}

	@Test
	public void testCountRecord() {
		int c = merDao.countRecordBySeller(23,1);
		System.out.println(c);
	}

}
