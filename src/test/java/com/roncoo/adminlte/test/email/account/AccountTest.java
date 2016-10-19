package com.roncoo.adminlte.test.email.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.biz.RcEmailAccountInfoBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-core.xml")
public class AccountTest {

	@Autowired
	private RcEmailAccountInfoBiz biz;
	
	@Test
	public void testInsert(){
		RcEmailAccountInfo info = new RcEmailAccountInfo();
		info.setHost("smtp.163.com");
		info.setFromUser("18813367223@163.com");
		info.setPasswd("LYQ188133");
		info.setRemark("测试数据");
		
		biz.insert(info);
	}
}
