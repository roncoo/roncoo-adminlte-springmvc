package com.roncoo.adminlte.test.email;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.biz.RcEmailInfoBiz;
import com.roncoo.adminlte.util.base.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-core.xml")
public class EmailTest {
	
	@Autowired
	private RcEmailInfoBiz biz;
	
	@Test
	public void testSend(){
		RcEmailInfo info = new RcEmailInfo();
		info.setFromUser("8888");
		info.setToUser("1291693839@qq.com");
		info.setSubject("镇荣！我测试一下测试");
		info.setTitle("镇荣！我测试一下测试1");
		info.setStatusId("1");
		info.setCreateTime(new Date());
		info.setUpdateTime(new Date());
		info.setContent("镇荣，我看看可不可以用");
		
		biz.insertSelective(info);
	}
	
	@Test
	public void testQueryByPage(){
		Page<RcEmailInfo> page = new Page<>();
		biz.queryForPage(page, "8888");
	}
}
