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

import com.roncoo.adminlte.bean.entity.RcUserRole;
import com.roncoo.adminlte.bean.entity.RcUserRoleExample;
import com.roncoo.adminlte.bean.entity.RcUserRoleExample.Criteria;
import com.roncoo.adminlte.service.impl.dao.UserRoleDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcUserRoleMapper;

/**
 * 用户-角色关系Dao层
 * 
 * @author LYQ
 *
 */
@Repository
public class UserRoleDaoImpl implements UserRoleDao {

	@Autowired
	private RcUserRoleMapper mapper;

	@Override
	public List<RcUserRole> selectByUserId(long id) {
		RcUserRoleExample example = new RcUserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(id);
		return mapper.selectByExample(example);
	}

	@Override
	public int insert(RcUserRole rcUserRole) {
		Date date = new Date();
		rcUserRole.setCreateTime(date);
		rcUserRole.setUpdateTime(date);
		return mapper.insertSelective(rcUserRole);
	}

	@Override
	public int update(RcUserRole rcUserRole) {
		rcUserRole.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(rcUserRole);
	}

	@Override
	public int delectByRcUserRole(RcUserRole rcUserRole) {
		RcUserRoleExample example = new RcUserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(rcUserRole.getUserId());
		if (rcUserRole.getRolesId() != null && rcUserRole.getRolesId() > 0) {
			criteria.andRolesIdEqualTo(rcUserRole.getRolesId());
		}
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteById(long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public RcUserRole selectById(long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public RcUserRole selectByUserRole(RcUserRole rcUserRole) {
		RcUserRoleExample example = new RcUserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(rcUserRole.getUserId());
		criteria.andRolesIdEqualTo(rcUserRole.getRolesId());
		List<RcUserRole> resultList = mapper.selectByExample(example);
		if (resultList.size() > 0) {
			return resultList.get(0);
		}
		return null;
	}

	@Override
	public int deleteByUserId(long userId) {
		RcUserRoleExample example = new RcUserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return mapper.deleteByExample(example);
	}
}
