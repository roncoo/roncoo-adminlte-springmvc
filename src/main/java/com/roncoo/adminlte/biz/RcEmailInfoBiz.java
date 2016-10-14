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
package com.roncoo.adminlte.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.bean.entity.RcEmailInfoExample;
import com.roncoo.adminlte.bean.entity.RcEmailInfoExample.Criteria;
import com.roncoo.adminlte.service.RcEmailInfoService;
import com.roncoo.adminlte.util.base.Page;

/**
 * @author wujing
 */
@Component
public class RcEmailInfoBiz {

	@Autowired
	private RcEmailInfoService rcEmailInfoService;
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private SimpleMailMessage mailMessage;

	/**
	 * 
	 * 功能：分页查询
	 * 
	 * @param page
	 * @param info
	 * @return Page<RcEmailInfo>
	 */
	public Page<RcEmailInfo> queryForPage(Page<RcEmailInfo> page, String fromUser) {
		RcEmailInfoExample premise = new RcEmailInfoExample();
		if (page.getPageSize() == 0) {
			page.setPageSize(page.DEFAULT_PAGE_SIZE);
		}
		premise.setPageSize(page.getPageSize());
		int limitStart = 0;
		if (page.getPageCurrent() > 0) {
			limitStart = (page.getPageCurrent() - 1) * page.getPageSize();
		} else {
			page.setPageCurrent(1);
		}
		premise.setLimitStart(limitStart);
		Criteria criteria = premise.createCriteria();
		criteria.andFromUserEqualTo(fromUser);

		return rcEmailInfoService.queryForPage(page, premise);
	}

	@Transactional
	public void insertSelective(RcEmailInfo info) {
		rcEmailInfoService.insertSelective(info);
		
		mailMessage.setSubject(info.getSubject());
		mailMessage.setText(info.getContent());
		mailMessage.setTo(info.getToUser());
		mailSender.send(mailMessage);
	}


}
