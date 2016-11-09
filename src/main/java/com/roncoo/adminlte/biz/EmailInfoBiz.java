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

import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.bean.vo.RcEmailInfoVo;
import com.roncoo.adminlte.service.EmailInfoService;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.cache.EmailAccountInfoCache;

/**
 * @author wujing
 */
@Component
public class EmailInfoBiz {

	@Autowired
	private EmailInfoService emailInfoService;
	
	@Autowired
	private EmailAccountInfoCache accountInfoCache;

	/**
	 * 分页查询
	 */
	public Result<Page<RcEmailInfo>> listForPage(int pageCurrent, int pageSize) {
		return emailInfoService.listForPage(pageCurrent, pageSize);
	}

	/**
	 * 发送邮件
	 * 
	 * @param rcEmailInfoVo
	 */
	public Result<RcEmailInfo> sendMail(RcEmailInfoVo rcEmailInfoVo) {
		List<RcEmailAccountInfo> accountList = accountInfoCache.getList();
		Random random = new Random();
		int index = random.nextInt(accountList.size());
		RcEmailInfo rcEmailInfo = new RcEmailInfo();
		BeanUtils.copyProperties(rcEmailInfoVo, rcEmailInfo);
		return emailInfoService.sendMail(accountList.get(index), rcEmailInfo);
	}

	/**
	 * 根据id进行删除
	 * 
	 * @param id
	 */
	public Result<String> deleteById(Long id) {
		return emailInfoService.deleteById(id);
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Result<RcEmailInfo> queryById(Long id) {
		return emailInfoService.queryById(id);
	}
}
