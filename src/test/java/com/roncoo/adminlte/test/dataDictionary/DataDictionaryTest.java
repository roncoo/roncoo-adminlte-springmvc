package com.roncoo.adminlte.test.dataDictionary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.service.impl.dao.EmailInfoDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-core.xml")
public class DataDictionaryTest {

	@Autowired
	private EmailInfoDao dao;

	@Test
	public void test() {
		RcEmailInfo info = new RcEmailInfo();
		info.setFromUser("188111111@163.com");
		for (int i = 0; i < 30; i++) {
			info.setToUser("198114511" + i + "@qq.com");
			info.setSubject("邮件主题"+i);
			info.setTitle("邮件标题"+i);
			info.setContent(" 广州市领课网络科技有限公司旗下龙果学院是一家专注于互联网金融系统技术解决方案的IT在线教育平台，提供专业级的互联网金融系统技术解决方案及技术教育服务。随着互联网+时代的到来，在线教育技术也是在不断的成熟，龙果学院利用在线教育优势，为广大龙果学院用户提供了最为方便、快捷的学习交流途径、并提供了大量的高质量免费和收费的在线IT课程。龙果学院具备优秀的系统研发和技术课程制作能力, 学院的讲师在IT领域积累了丰富的经验，均具有多年的大型项目架构实战经验，产品项目均采用当前主流、前沿的技术进行开发。");
			dao.insert(info);
		}
	}
}
