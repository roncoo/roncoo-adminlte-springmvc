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

import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.bean.entity.RcRoleExample;
import com.roncoo.adminlte.bean.entity.RcRoleExample.Criteria;
import com.roncoo.adminlte.service.impl.dao.RoleDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcRoleMapper;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private RcRoleMapper mapper;

	@Override
	public RcRole selectById(long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(RcRole rcRole) {
		Date date = new Date();
		rcRole.setCreateTime(date);
		rcRole.setUpdateTime(date);
		return mapper.insertSelective(rcRole);
	}

	@Override
	public int update(RcRole rcRole) {
		rcRole.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(rcRole);
	}

	@Override
	public int deleteById(long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Page<RcRole> listForPage(int pageCurrent, int pageSize, String date, String search) {
		RcRoleExample example = new RcRoleExample();
		example.setOrderByClause("id desc");
		Criteria criteria = example.createCriteria();
		if (StringUtils.hasText(date)) {
			Date time = SqlUtil.formatterDate(date);
			criteria.andCreateTimeBetween(time, SqlUtil.addDay(time, 1));
		}
		if (StringUtils.hasText(search)) {
			criteria.andRoleNameLike(SqlUtil.like(search));
		}
		int totalCount = mapper.countByExample(example);
		pageSize = SqlUtil.checkPageSize(pageSize);
		pageCurrent = SqlUtil.checkPageCurrent(totalCount, pageSize, pageCurrent);
		int totalPage = SqlUtil.countTotalPage(totalCount, pageSize);
		example.setPageSize(pageSize);
		example.setLimitStart(SqlUtil.countOffset(pageCurrent, pageSize));
		List<RcRole> list = mapper.selectByExample(example);
		return new Page<>(totalCount, totalPage, pageCurrent, pageSize, list);
	}

	@Override
	public List<RcRole> list() {
		RcRoleExample example = new RcRoleExample();
		example.setOrderByClause("id desc");
		return mapper.selectByExample(example);
	}

	@Override
	public RcRole selectByRoleName(String roleName) {
		RcRoleExample example = new RcRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleNameEqualTo(roleName);
		List<RcRole> resultData = mapper.selectByExample(example);
		if (resultData.size() < 1) {
			return null;
		}
		return resultData.get(0);
	}

}
