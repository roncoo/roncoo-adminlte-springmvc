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
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.service.EmailAccountInfoService;
import com.roncoo.adminlte.service.EmailInfoService;
import com.roncoo.adminlte.util.base.Page;

/**
 * @author wujing
 */
@Component
public class EmailInfoBiz {

	@Autowired
	private EmailInfoService emailInfoService;

	@Autowired
	private EmailAccountInfoService emailAccountInfoService;

	/**
	 * 分页查询
	 */
	public Page<RcEmailInfo> listForPage(int pageCurrent, int pageSize) {
		return emailInfoService.listForPage(pageCurrent, pageSize);
	}

	/**
	 * 发送邮件
	 * 
	 * @param rcEmailInfo
	 */
	public void sendMail(RcEmailInfo rcEmailInfo) {
		RcEmailAccountInfo info = emailAccountInfoService.queryByRand();
		emailInfoService.sendMail(info, rcEmailInfo);
	}

	/**
	 * 根据id进行删除
	 * 
	 * @param id
	 */
	public void deleteById(Long id) {
		emailInfoService.deleteById(id);
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public RcEmailInfo queryById(Long id) {
		return emailInfoService.queryById(id);
	}
}
