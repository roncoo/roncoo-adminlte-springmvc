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
package com.roncoo.adminlte.service.impl.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfoExample;
import com.roncoo.adminlte.service.impl.dao.EmailAccountInfoDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcEmailAccountInfoMapper;
import com.roncoo.adminlte.util.Base64Util;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;

@Repository
public class EmailAccountInfoDaoImpl implements EmailAccountInfoDao {

	@Autowired
	private RcEmailAccountInfoMapper mapper;

	@Override
	public int delete(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(RcEmailAccountInfo info) {
		String passwd = Base64Util.encrypt(info.getPasswd());
		info.setPasswd(passwd);
		Date date = new Date();
		info.setCreateTime(date);
		info.setUpdateTime(date);
		return mapper.insertSelective(info);
	}

	@Override
	public Page<RcEmailAccountInfo> listForPage(int pageCurrent, int pageSize) {
		RcEmailAccountInfoExample example = new RcEmailAccountInfoExample();
		example.setOrderByClause("id desc");
		int totalCount = mapper.countByExample(example);
		pageSize = SqlUtil.checkPageSize(pageSize);
		pageCurrent = SqlUtil.checkPageCurrent(totalCount, pageSize, pageCurrent);
		int totalPage = SqlUtil.countTotalPage(totalCount, pageSize);
		example.setLimitStart(SqlUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);
		List<RcEmailAccountInfo> list = mapper.selectByExample(example);
		Page<RcEmailAccountInfo> page = new Page<>(totalCount, totalPage, pageCurrent, pageSize, list);
		return page;
	}

	@Override
	public RcEmailAccountInfo select(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(RcEmailAccountInfo info) {
		String passwd = Base64Util.encrypt(info.getPasswd());
		info.setPasswd(passwd);
		info.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(info);
	}
}
