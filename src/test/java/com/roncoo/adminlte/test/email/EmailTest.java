package com.roncoo.adminlte.test.email;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.biz.RcEmailInfoBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-core.xml")
public class EmailTest {
	
	@Autowired
	private RcEmailInfoBiz biz;
	
	@Test
	public void testSend(){
		RcEmailInfo info = new RcEmailInfo();
		info.setFromUser("8888");
		info.setToUser("624654406@qq.com");
		info.setSubject("测试");
		info.setTitle("测试");
		info.setStatusId("1");
		info.setCreateTime(new Date());
		info.setUpdateTime(new Date());
		info.setContent("cece");
		
		biz.insertSelective(info);
	}
}
