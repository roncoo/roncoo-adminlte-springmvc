package com.roncoo.adminlte.test.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.biz.RcEmailInfoBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-core.xml")
public class EmailTemplateTest {
	
	@Autowired
	private RcEmailInfoBiz biz;
	
	@Test
	public void testTemplate(){
		RcEmailInfo info = new RcEmailInfo();
		info.setFromUser("18813367223@163.com");
		info.setToUser("1291693839@qq.com");
		info.setSubject("我测试一下测试");
		info.setTitle("我测试一下测试1");
		info.setStatusId("1");
		info.setContent("我看看可不可以用");
		biz.testT(info);
	}
}
