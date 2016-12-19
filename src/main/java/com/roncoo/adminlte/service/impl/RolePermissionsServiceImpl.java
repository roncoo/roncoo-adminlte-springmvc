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
import com.roncoo.adminlte.bean.entity.RcRolePermissions;
import com.roncoo.adminlte.service.RolePermissionsService;
import com.roncoo.adminlte.service.impl.dao.RolePermissionsDao;

@Service
public class RolePermissionsServiceImpl implements RolePermissionsService {

	@Autowired
	private RolePermissionsDao dao;

	@Override
	public Result<RcRolePermissions> query(long id) {
		Result<RcRolePermissions> result = new Result<RcRolePermissions>();
		if (id < 0) {
			result.setErrMsg("此id无效");
			return result;
		}
		RcRolePermissions rcRolePermissions = dao.selectById(id);
		if (rcRolePermissions != null) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setResultData(rcRolePermissions);
		}
		return result;
	}

	@Override
	public Result<List<RcRolePermissions>> queryByRoleId(long id) {
		Result<List<RcRolePermissions>> result = new Result<List<RcRolePermissions>>();
		if (id < 0) {
			result.setErrMsg("此id无效");
			return result;
		}
		List<RcRolePermissions> resultList = dao.selectByRoleId(id);
		if (resultList.size() > 0) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setResultData(resultList);
		}
		return result;
	}

	@Override
	public Result<Integer> save(long roleId, List<Long> permissionList) {
		Result<Integer> result = new Result<Integer>();
		if (roleId < 1) {
			result.setErrMsg("此角色id无效");
			return result;
		}
		if (permissionList.size() == 0) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("没有需要插入的数据");
			return result;
		}
		RcRolePermissions rcRolePermissions = new RcRolePermissions();
		int i = 0;
		for (Long permissionId : permissionList) {
			rcRolePermissions.setPermissionId(permissionId);
			rcRolePermissions.setRoleId(roleId);
			i = i + dao.insert(rcRolePermissions);
		}
		if (i == permissionList.size()) {
			result.setErrMsg("操作成功");
			result.setErrCode(0);
			result.setStatus(true);
			return result;
		}
		result.setErrMsg("操作失败");
		return result;
	}

	@Override
	public Result<Integer> delete(long roleId) {
		Result<Integer> result = new Result<Integer>();
		if (roleId < 0) {
			result.setErrMsg("此id无效");
			return result;
		}
		int resultNum = dao.deleteByRoleId(roleId);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}

	@Override
	public Result<Integer> deleteByRolePermissions(RcRolePermissions rcRolePermissions) {
		Result<Integer> result = new Result<Integer>();
		if (rcRolePermissions.getRoleId() < 0) {
			result.setErrMsg("此角色id无效");
			return result;
		}
		if (rcRolePermissions.getPermissionId() < 0) {
			result.setErrMsg("此权限id无效");
			return result;
		}
		int resultNum = dao.delectByRolePermissions(rcRolePermissions);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}

	@Override
	public Result<Integer> update(long roleId, List<Long> permissionList) {
		Result<Integer> result = new Result<Integer>();
		if (roleId < 1) {
			result.setErrMsg("此角色id无效");
			return result;
		}
		if (dao.countByRoleId(roleId) != dao.deleteByRoleId(roleId)) {
			result.setErrMsg("操作失败");
			return result;
		}
		return save(roleId, permissionList);
	}

	@Override
	public Result<List<RcRolePermissions>> listForRoleId(List<Long> idList) {
		Result<List<RcRolePermissions>> result = new Result<List<RcRolePermissions>>();
		if (idList.size() < 1) {
			result.setErrMsg("没有id需要查询");
			return result;
		}
		List<RcRolePermissions> resultData = dao.listForRoleId(idList);
		result.setErrCode(0);
		result.setStatus(true);
		result.setResultData(resultData);
		result.setErrMsg("查询成功");
		return result;
	}
}
