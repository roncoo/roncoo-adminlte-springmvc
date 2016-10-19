package com.roncoo.adminlte.util.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;

import freemarker.template.Template;
import freemarker.template.TemplateException;


public class MailTemplate implements Runnable {
	
	private static final String ENCODING = "utf-8"; 

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	private MimeMessage msg;

	@Override
	public void run() {
		mailSender.send(msg);
	}

	public void setMail(RcEmailInfo info) {
		try {
			msg = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, ENCODING);
			helper.setFrom(info.getFromUser());
			helper.setTo(info.getToUser());
			helper.setSubject(MimeUtility.encodeText("estore注册成功提示邮件", ENCODING, "B"));
			helper.setText(setContent(info), true); // true表示text的内容为html

		} catch (Exception e) {
			throw new RuntimeException("error happens", e);
		}
	}

	private String setContent(RcEmailInfo info) {
		String htmlText = null;
		try {
System.out.println(freeMarkerConfigurer);
			Template template = freeMarkerConfigurer.getConfiguration().getTemplate("/WEB-INF/view/template/template.ftl");
			Map<String, String> map = new HashMap<String, String>();
			map.put("content", info.getContent());

			// 解析模板并替换动态数据，最终content将替换模板文件中的${content}标签。
			htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return htmlText;
	}

}
