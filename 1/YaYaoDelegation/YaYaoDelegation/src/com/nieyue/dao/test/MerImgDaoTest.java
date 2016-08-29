package com.nieyue.dao.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nieyue.bean.MerImg;
import com.nieyue.dao.MerDao;
import com.nieyue.dao.MerImgDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-dao.xml")
public class MerImgDaoTest {
	@Resource
	MerDao merDao;
	@Resource
	MerImgDao merImgDao;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddMerImg() {
		for (int j = 0; j < 2; j++) {
			MerImg mi=new MerImg();
			mi.setMerId(1003);
			if(Math.random()*10>5){
				mi.setMerId(1004);
			}
			//mi.setMerImgAddress("/resources/sellerUpload/7/黑茶/百两茶/百两茶_"+j+".jpg");
			mi.setMerImgAddress("jpg");
			mi.setSellerId(23);
			merImgDao.addMerImg(mi);
		}
	}

	@Test
	public void testDelMerImg() {
		merImgDao.delMerImg(23,1019);
	}

	@Test
	public void testUpdateMerImg() {
		MerImg merImg = merImgDao.loadMerImg(1091);
		merImg.setMerImgAddress("sdfdsf11");
		merImg.setSellerId(23);
		boolean l = merImgDao.updateMerImg(merImg);
		
		System.out.println(l);
	}

	@Test
	public void testLoadMerImg() {
		MerImg merImg = merImgDao.loadMerImg(1002);
		System.out.println(merImg.getMerImgAddress());
	}

	@Test
	public void testLoadMerImgByAddress() {
		MerImg merImg = merImgDao.loadMerImgByAddress("sdfdsf");
		System.out.println(merImg.getMerImgId());
	}

	@Test
	public void testBrowseMerImgBySeller() {
		List<MerImg> l = merImgDao.browseMerImgBySeller(23,1001, "mer_img_update_time", "desc");
		System.out.println(l);
	}

	@Test
	public void testBrowsePagingMerImgBySeller() {
		List<MerImg> l = merImgDao.browsePagingMerImgBySeller(23,1003, 2, 10, "mer_img_update_time", "desc");
		System.out.println(l);
	}

}
