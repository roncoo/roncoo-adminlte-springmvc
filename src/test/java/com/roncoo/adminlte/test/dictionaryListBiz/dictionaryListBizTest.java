package com.roncoo.adminlte.test.dictionaryListBiz;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.biz.RcDataDictionaryListBiz;
import com.roncoo.adminlte.util.base.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-core.xml")
public class dictionaryListBizTest {
	
	@Autowired
	private RcDataDictionaryListBiz listBiz;
	
	@Test
	public void testInsert(){
		RcDataDictionaryList dictionaryList = new RcDataDictionaryList();
		Date date = new Date();
		dictionaryList.setFieldKey("163");
		dictionaryList.setFieldValue("smtp.163.com");
		dictionaryList.setSort(1);
		dictionaryList.setRemark("163服务器");
		dictionaryList.setCreateTime(date);
		dictionaryList.setUpdateTime(date);
		
		Long id = (long) 1; 
		listBiz.insert(dictionaryList, id);
		
	}
	
	@Test
	public void testQueryForPage(){
		Page<RcDataDictionaryList> page = new Page<>();
		RcDataDictionaryList dictionaryList = new RcDataDictionaryList();
		listBiz.queryForPage(page, dictionaryList, (long) 1);
	}
	
	@Test
	public void testQueryByFieldCode(){
		String fieldCode = "host_code";
		listBiz.queryByFieldCode(fieldCode);
	}
	
}
