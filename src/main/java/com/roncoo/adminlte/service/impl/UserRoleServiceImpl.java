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

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcUserRole;
import com.roncoo.adminlte.service.UserRoleService;
import com.roncoo.adminlte.service.impl.dao.UserRoleDao;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao dao;

	@Override
	public Result<List<RcUserRole>> queryByUserId(long id) {
		Result<List<RcUserRole>> result = new Result<List<RcUserRole>>();
		if (id < 0) {
			result.setErrMsg("此id无效");
			return result;
		}
		List<RcUserRole> resultList = dao.selectByUserId(id);
		if (resultList.size() > 0) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setResultData(resultList);
		}
		return result;
	}

	@Override
	public Result<RcUserRole> queryByUserRole(RcUserRole rcUserRole) {
		Result<RcUserRole> result = new Result<RcUserRole>();
		if (rcUserRole.getUserId() < 0) {
			result.setErrMsg("此用户id无效");
			return result;
		}
		if (rcUserRole.getRolesId() < 0) {
			result.setErrMsg("此角色id无效");
			return result;
		}
		RcUserRole userRole = dao.selectByUserRole(rcUserRole);
		if (userRole != null) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setResultData(userRole);
		}
		return result;
	}

	@Override
	public Result<Integer> insert(RcUserRole rcUserRole) {
		Result<Integer> result = new Result<Integer>();
		if (rcUserRole.getUserId() < 0) {
			result.setErrMsg("此用户id无效");
			return result;
		}
		if (rcUserRole.getRolesId() < 0) {
			result.setErrMsg("此角色id无效");
			return result;
		}
		int resultNum = dao.insert(rcUserRole);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}

	@Override
	public Result<Integer> update(RcUserRole rcUserRole) {
		Result<Integer> result = new Result<Integer>();
		if (rcUserRole.getUserId() < 0) {
			result.setErrMsg("此用户id无效");
			return result;
		}
		if (rcUserRole.getRolesId() < 0) {
			result.setErrMsg("此角色id无效");
			return result;
		}
		int resultNum = dao.update(rcUserRole);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}

	@Override
	public Result<Integer> deleteByUserRole(RcUserRole rcUserRole) {
		Result<Integer> result = new Result<Integer>();
		if (rcUserRole.getUserId() < 0) {
			result.setErrMsg("此用户id无效");
			return result;
		}
		int resultNum = dao.delectByRcUserRole(rcUserRole);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}

	@Override
	public Result<Integer> updateByUserId(long userId, List<Long> roles) {
		Result<Integer> result = new Result<Integer>();
		RcUserRole rcUserRole = new RcUserRole();
		if (userId < 1) {
			result.setErrMsg("用户id不能为空");
			return result;
		}
		dao.deleteByUserId(userId);
		for (Long rolesId : roles) {
			rcUserRole.setUserId(userId);
			rcUserRole.setRolesId(rolesId);
			dao.insert(rcUserRole);
		}
		result.setErrCode(0);
		result.setStatus(true);
		result.setErrMsg("更新成功");
		return result;
	}
}
