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
import org.springframework.util.StringUtils;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.service.RoleService;
import com.roncoo.adminlte.service.impl.dao.RoleDao;
import com.roncoo.adminlte.util.base.Page;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao dao;

	@Override
	public Result<RcRole> query(long id) {
		Result<RcRole> result = new Result<RcRole>();
		if (id < 0) {
			result.setErrMsg("此id无效");
			return result;
		}
		RcRole role = dao.selectById(id);
		if (role != null) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setResultData(role);
		}
		return result;
	}

	@Override
	public Result<Integer> save(RcRole rcRole) {
		Result<Integer> result = new Result<Integer>();
		if (!StringUtils.hasText(rcRole.getRoleName())) {
			result.setErrMsg("角色名不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcRole.getRoleValue())) {
			result.setErrMsg("角色值不能为空");
			return result;
		}
		if (dao.selectByRoleName(rcRole.getRoleName()) != null) {
			result.setErrMsg("角色已经存在");
			return result;
		}
		int resultNum = dao.insert(rcRole);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}

	@Override
	public Result<Integer> update(RcRole rcRole) {
		Result<Integer> result = new Result<Integer>();
		if (!StringUtils.hasText(rcRole.getRoleName())) {
			result.setErrMsg("角色名不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcRole.getRoleValue())) {
			result.setErrMsg("角色值不能为空");
			return result;
		}
		int resultNum = dao.update(rcRole);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}

	@Override
	public Result<Integer> delete(long id) {
		Result<Integer> result = new Result<Integer>();
		if (id < 0) {
			result.setErrMsg("此id无效");
			return result;
		}
		int resultNum = dao.deleteById(id);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}

	@Override
	public Result<Page<RcRole>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		Result<Page<RcRole>> result = new Result<Page<RcRole>>();
		if (pageCurrent < 1) {
			result.setErrMsg("pageCurrent有误");
			return result;
		}
		if (pageSize < 1) {
			result.setErrMsg("pageSize有误");
			return result;
		}
		Page<RcRole> resultData = dao.listForPage(pageCurrent, pageSize, date, search);
		result.setResultData(resultData);
		result.setErrCode(0);
		result.setStatus(true);
		result.setErrMsg("查询成功");
		return result;
	}

	@Override
	public Result<List<RcRole>> list() {
		Result<List<RcRole>> result = new Result<List<RcRole>>();
		List<RcRole> resultData = dao.list();
		if (resultData.size() > 0) {
			result.setResultData(resultData);
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("查询成功");
			return result;
		}
		result.setErrMsg("查询失败");
		return result;
	}

	@Override
	public Result<RcRole> queryByRoleName(String roleName) {
		Result<RcRole> result = new Result<RcRole>();
		if (!StringUtils.hasText(roleName)) {
			result.setErrMsg("角色名不能为空");
			return result;
		}
		RcRole resultData = dao.selectByRoleName(roleName);
		if (resultData != null) {
			result.setResultData(resultData);
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("查询成功");
			return result;
		}
		result.setErrMsg("查询失败");
		return result;
	}

	@Override
	public Result<List<RcRole>> listForId(List<Long> idList) {
		Result<List<RcRole>> result = new Result<List<RcRole>>();
		if (idList.size() < 1) {
			result.setErrMsg("没有id需要查询");
			return result;
		}
		List<RcRole> resultData = dao.listForId(idList);
		result.setErrCode(0);
		result.setStatus(true);
		result.setResultData(resultData);
		result.setErrMsg("查询成功");
		return result;
	}
}
