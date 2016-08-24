package com.nieyue.dao.test;

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
		for (int j = 0; j < 10; j++) {
			MerImg mi=new MerImg();
			mi.setMerId(1003);
			if(Math.random()*10>5){
				mi.setMerId(1004);
			}
			mi.setMerImgAddress("/resources/sellerUpload/7/黑茶/百两茶/百两茶_"+j+".jpg");
			merImgDao.addMerImg(mi);
		}
	}

	@Test
	public void testDelMerImg() {
		merImgDao.delMerImg(1019);
	}

	@Test
	public void testUpdateMerImg() {
		MerImg merImg = merImgDao.loadMerImg(1018);
		merImg.setMerImgAddress("sdfdsf");
		merImgDao.updateMerImg(merImg);
	}

	@Test
	public void testLoadMerImg() {
		MerImg merImg = merImgDao.loadMerImg(1018);
		System.out.println(merImg.getMerImgAddress());
	}

	@Test
	public void testLoadMerImgByAddress() {
		MerImg merImg = merImgDao.loadMerImgByAddress("sdfdsf");
		System.out.println(merImg.getMerImgId());
	}

	@Test
	public void testBrowseMerImg() {
		List<MerImg> l = merImgDao.browseMerImg(1001, "mer_img_update_time", "desc");
		System.out.println(l);
	}

	@Test
	public void testBrowsePagingMerImg() {
		List<MerImg> l = merImgDao.browsePagingMerImg(1003, 2, 10, "mer_img_update_time", "desc");
		System.out.println(l);
	}

}
