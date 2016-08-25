package com.nieyue.service.impl.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.nieyue.bean.MerImg;
import com.nieyue.service.MerImgService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring-dao.xml","classpath:config/spring-service.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback=false)
public class MerImgServiceImplTest {
	@Resource
	MerImgService merImgService;
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
			merImgService.addMerImg(mi);
		}
	}

	@Test
	public void testDelMerImg() {
		merImgService.delMerImg(23,1029);
	}

	@Test
	public void testUpdateMerImg() {
		MerImg merImg = merImgService.loadMerImg(1028);
		merImg.setMerImgAddress("sdfdsf1");
		merImgService.updateMerImg(merImg);
	}

	@Test
	public void testLoadMerImg() {
		MerImg merImg = merImgService.loadMerImg(1028);
		System.out.println(merImg.getMerImgAddress());
	}

	@Test
	public void testBrowseMerImgBySeller() {
		List<MerImg> l = merImgService.browseMerImgBySeller(23,1001, "mer_img_update_time", "desc");
		System.out.println(l);
	}

	@Test
	public void testBrowsePagingMerImgBySeller() {
		List<MerImg> l = merImgService.browsePagingMerImgBySeller(23,1003, 0, -1, "mer_img_update_time", "desc");
		System.out.println(l);
	}

	@Test
	public void testLoadMerImgByAddress() {
		MerImg merImg = merImgService.loadMerImgByAddress("sdfdsf1");
		System.out.println(merImg.getMerImgId());
	}

}
