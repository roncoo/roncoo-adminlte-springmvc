package com.roncoo.adminlte.test.emailInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.biz.EmailInfoBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-core.xml")
public class EmailInfoTest {

	@Autowired
	private EmailInfoBiz biz;

	/**
	 * 发送邮件测试
	 */
	@Test
	public void test() {
		RcEmailInfo rcEmailInfo = new RcEmailInfo();
		rcEmailInfo.setToUser("1291693839@qq.com");
		rcEmailInfo.setSubject("邮件标题1");
		rcEmailInfo.setTitle("dddd");
		rcEmailInfo.setContent("测试邮件1");
		biz.sendMail(rcEmailInfo);
	}
}
