package com.roncoo.adminlte.test.dataDictionary;

import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.service.impl.dao.DataDictionaryDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-core.xml")
public class DataDictionaryTest {
	
	@Autowired
	private DataDictionaryDao dao;
	
	@Test
	public void test(){
		RcDataDictionary dataDictionary = new RcDataDictionary();
		Random random = new Random();
		
		for(int i=0;i<30;i++){
			Date date = new Date();
			dataDictionary.setFieldName("测试字段"+(i+1));
			dataDictionary.setFieldCode("code"+(i+1));
			dataDictionary.setRemark("备注"+(i+1));
			dataDictionary.setSort(random.nextInt(3));
			dataDictionary.setCreateTime(date);
			dataDictionary.setUpdateTime(date);
			
			dao.insert(dataDictionary);
		}
	}
}
