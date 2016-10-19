package com.roncoo.adminlte.util.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;

/**
 * 
 * 作用功能：邮件发送组件
 * 作者： LYQ
 * 时间：2016年10月17日
 */
public class Mail implements Runnable {
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private SimpleMailMessage mailMessage;

	@Override
	public void run() {
		mailSender.send(mailMessage);

	}
	
	public void setMail(RcEmailInfo info){
	
		mailMessage.setSubject(info.getSubject());
		mailMessage.setText(info.getContent());
		mailMessage.setTo(info.getToUser());
		
	}

}
