package com.nieyue.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nieyue.bean.Mer;
import com.nieyue.bean.ReceiptAddress;
import com.nieyue.dao.ReceiptAddressDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-dao.xml")
public class ReceiptAddressDaoTest {
	@Resource
	ReceiptAddressDao receiptAddressDao;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddReceiptAddress() {
		ReceiptAddress ra=new ReceiptAddress();
		receiptAddressDao.addReceiptAddress(ra);
	}

	@Test
	public void testDelReceiptAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateReceiptAddress() {
		ReceiptAddress ra = receiptAddressDao.loadReceiptAddress(1000);
		ra.setIsDefault(1);
		ra.setReceiptAddressName("聂跃");
		ra.setReceiptAddressPhone("15111336587");
		ra.setUserId(1000);
		receiptAddressDao.updateReceiptAddress(ra);
	}

	@Test
	public void testLoadReceiptAddress() {
		ReceiptAddress sr = receiptAddressDao.loadDefaultReceiptAddress(1000, 0);
		System.out.println(sr.getReceiptAddressId());
	}

	@Test
	public void testLoadDefaultReceiptAddress() {
		ReceiptAddress ra = receiptAddressDao.loadReceiptAddress(1000);
		System.out.println(ra);
	}

	@Test
	public void testBrowseReceiptAddress() {
		List<ReceiptAddress> l = receiptAddressDao.browseReceiptAddress("receipt_address_update_time", "desc");
		System.out.println(l.size());
	}

	@Test
	public void testBrowsePagingReceiptAddress() {
		List<ReceiptAddress> l = receiptAddressDao.browsePagingReceiptAddress(0, 1, "receipt_address_update_time", "desc");
		System.err.println(l.get(0).getReceiptAddressId());
	}

}
