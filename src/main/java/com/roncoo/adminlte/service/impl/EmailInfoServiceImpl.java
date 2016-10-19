/*
 * Copyright 2015-2016 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.roncoo.adminlte.service.impl;

import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.service.EmailInfoService;
import com.roncoo.adminlte.service.impl.dao.EmailInfoDao;
import com.roncoo.adminlte.util.base.Page;

import freemarker.template.Template;

/**
 * @author wujing
 */
@Service
public class EmailInfoServiceImpl implements EmailInfoService {

	// private static final String TEMPLATE = "mail/roncoo.ftl";

	@Autowired
	private EmailInfoDao dao;

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Override
	public Page<RcEmailInfo> listForPage(int pageCurrent, int pageSize) {
		return dao.listForPage(pageCurrent, pageSize);
	}

	@Override
	public void sendMail(RcEmailInfo rcEmailInfo) {
		// 发送邮件
		send("", "", null, ""); 
		
		// 保存记录
		dao.insert(rcEmailInfo);
	}

	/**
	 * 
	 * @param to
	 * @param subject
	 * @param map
	 * @param templatePath
	 */
	private void send(String to, String subject, Map<String, String> map, String templatePath) {
		try {
			// 从FreeMarker模板生成邮件内容
			Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templatePath);
			String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
			this.threadPoolTaskExecutor.execute(new SendMailThread(to, subject, text));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 内部线程类，利用线程池异步发邮件。
	private class SendMailThread implements Runnable {
		private String to;
		private String subject;
		private String content;

		private SendMailThread(String to, String subject, String content) {
			super();
			this.to = to;
			this.subject = subject;
			this.content = content;
		}

		@Override
		public void run() {
			send(to, subject, content);
		}

		private static final String NAME = "龙果学院";

		public void send(String to, String subject, String text) {
			try {
				MimeMessage message = javaMailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
				InternetAddress from = new InternetAddress();
				from.setAddress("");
				from.setPersonal(NAME, "UTF-8");
				helper.setFrom(from);
				helper.setTo(to);
				helper.setSubject(subject);
				helper.setText(text, true);
				javaMailSender.send(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
