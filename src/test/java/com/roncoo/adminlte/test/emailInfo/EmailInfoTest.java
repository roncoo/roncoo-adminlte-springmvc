package com.roncoo.adminlte.test.emailInfo;

import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.service.impl.dao.EmailInfoDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-core.xml")
public class EmailInfoTest {

	@Autowired
	private EmailInfoDao dao;

	/**
	 * 发送邮件测试
	 */
	@Test
	public void test() {
		int num = 8;
		Date date;
		Random random = new Random();

		for (int i = 0; i < 30; i++) {
			RcEmailInfo info = new RcEmailInfo();
			date = new Date();
			info.setCreateTime(date);
			info.setUpdateTime(date);
			info.setFromUser("18813367223@163.com");
			StringBuffer sb = new StringBuffer();
			for(int j=0;j<10;j++){
				sb.append((random.nextInt(num)+1));
			}
			info.setToUser(sb.toString()+"@qq.com");
			info.setContent("龙果学院测试邮件");
			info.setSubject("邮件"+i);
			info.setTitle("标题"+i);
			
			dao.insert(info);
		}
	}
}
