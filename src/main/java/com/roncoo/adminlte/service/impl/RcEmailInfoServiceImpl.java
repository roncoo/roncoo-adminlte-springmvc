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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.bean.entity.RcEmailInfoExample;
import com.roncoo.adminlte.service.RcEmailInfoService;
import com.roncoo.adminlte.service.impl.dao.RcEmailInfoDao;
import com.roncoo.adminlte.util.base.Page;

/**
 * @author wujing
 */
@Service
public class RcEmailInfoServiceImpl implements RcEmailInfoService {

	@Autowired
	private RcEmailInfoDao dao;

	/**
	 * 分页查询
	 */
	@Override
	public Page<RcEmailInfo> queryForPage(Page<RcEmailInfo> page, RcEmailInfoExample premise) {
		int totalCount = dao.countTotal(premise);
		List<RcEmailInfo> resultList = dao.queryForPage(premise);
		
		page.setTotalCount(totalCount);
		int totalPage = 1;
		if (totalCount != 0) {
			totalPage = totalCount / premise.getPageSize();
			
			if (totalCount % premise.getPageSize() != 0) {
				totalPage++;
			}
		}
		
		page.setTotalPage(totalPage);
		page.setList(resultList);
		
		return page;
	}

	/**
	 * 保存邮件信息
	 */
	@Override
	public void insertSelective(RcEmailInfo info) {
		dao.insertSelective(info);
	}

}
