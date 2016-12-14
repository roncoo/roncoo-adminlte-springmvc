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
import org.springframework.util.StringUtils;

import com.roncoo.adminlte.bean.entity.RcPermission;
import com.roncoo.adminlte.bean.entity.RcPermissionExample;
import com.roncoo.adminlte.bean.entity.RcPermissionExample.Criteria;
import com.roncoo.adminlte.service.impl.dao.PermissionDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcPermissionMapper;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;

@Repository
public class PermissionDaoImpl implements PermissionDao {

	@Autowired
	private RcPermissionMapper mapper;

	@Override
	public RcPermission selectById(long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(RcPermission rcPermission) {
		Date date = new Date();
		rcPermission.setCreateTime(date);
		rcPermission.setUpdateTime(date);
		return mapper.insertSelective(rcPermission);
	}

	@Override
	public int update(RcPermission rcPermission) {
		rcPermission.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(rcPermission);
	}

	@Override
	public int deleteById(long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Page<RcPermission> listForPage(int pageCurrent, int pageSize, String date, String search) {
		RcPermissionExample example = new RcPermissionExample();
		example.setOrderByClause("id desc");
		Criteria criteria = example.createCriteria();
		if (StringUtils.hasText(date)) {
			Date time = SqlUtil.formatterDate(date);
			criteria.andCreateTimeBetween(time, SqlUtil.addDay(time, 1));
		}
		if (StringUtils.hasText(search)) {
			criteria.andPermissionsNameLike(SqlUtil.like(search));
		}
		int totalCount = mapper.countByExample(example);
		pageSize = SqlUtil.checkPageSize(pageSize);
		pageCurrent = SqlUtil.checkPageCurrent(totalCount, pageSize, pageCurrent);
		int totalPage = SqlUtil.countTotalPage(totalCount, pageSize);
		example.setPageSize(pageSize);
		example.setLimitStart(SqlUtil.countOffset(pageCurrent, pageSize));
		List<RcPermission> list = mapper.selectByExample(example);
		return new Page<>(totalCount, totalPage, pageCurrent, pageSize, list);
	}

	@Override
	public List<RcPermission> listForId(List<Long> idList) {
		RcPermissionExample example = new RcPermissionExample();
		example.setOrderByClause("id desc");
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(idList);
		return mapper.selectByExample(example);
	}

	@Override
	public List<RcPermission> list() {
		RcPermissionExample example = new RcPermissionExample();
		example.setOrderByClause("id desc");
		return mapper.selectByExample(example);
	}
}
