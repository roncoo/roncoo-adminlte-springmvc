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

import com.roncoo.adminlte.bean.entity.RcRolePermissions;
import com.roncoo.adminlte.bean.entity.RcRolePermissionsExample;
import com.roncoo.adminlte.bean.entity.RcRolePermissionsExample.Criteria;
import com.roncoo.adminlte.service.impl.dao.RolePermissionsDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcRolePermissionsMapper;

@Repository
public class RolePermissionsDaoImpl implements RolePermissionsDao {

	@Autowired
	private RcRolePermissionsMapper mapper;

	@Override
	public List<RcRolePermissions> selectByRoleId(long id) {
		RcRolePermissionsExample example = new RcRolePermissionsExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(id);
		return mapper.selectByExample(example);
	}

	@Override
	public int insert(RcRolePermissions rcRolePermissions) {
		Date date = new Date();
		rcRolePermissions.setCreateTime(date);
		rcRolePermissions.setUpdateTime(date);
		return mapper.insertSelective(rcRolePermissions);
	}

	@Override
	public int update(RcRolePermissions rcRolePermissions) {
		rcRolePermissions.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(rcRolePermissions);
	}

	@Override
	public int delectByRolePermissions(RcRolePermissions rcRolePermissions) {
		RcRolePermissionsExample example = new RcRolePermissionsExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(rcRolePermissions.getRoleId());
		criteria.andPermissionIdEqualTo(rcRolePermissions.getPermissionId());
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public RcRolePermissions selectById(long id) {
		return mapper.selectByPrimaryKey(id);
	}
}
