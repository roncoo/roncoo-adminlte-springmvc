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
import com.roncoo.adminlte.bean.entity.RcPermission;
import com.roncoo.adminlte.service.PermissionService;
import com.roncoo.adminlte.service.impl.dao.PermissionDao;
import com.roncoo.adminlte.util.base.Page;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionDao dao;

	@Override
	public Result<RcPermission> query(long id) {
		Result<RcPermission> result = new Result<RcPermission>();
		if (id < 0) {
			result.setErrMsg("此id无效");
			return result;
		}
		RcPermission rcPermission = dao.selectById(id);
		if (rcPermission != null) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setResultData(rcPermission);
			result.setErrMsg("查询成功");
			return result;
		}
		result.setErrMsg("查询失败");
		return result;
	}

	@Override
	public Result<Integer> save(RcPermission rcPermission) {
		Result<Integer> result = new Result<Integer>();
		if (!StringUtils.hasText(rcPermission.getPermissionsName())) {
			result.setErrMsg("权限名不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcPermission.getPermissionsValue())) {
			result.setErrMsg("权限值不能为空");
			return result;
		}
		int resultNum = dao.insert(rcPermission);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("添加成功");
			return result;
		}
		result.setErrMsg("添加失败");
		return result;
	}

	@Override
	public Result<Integer> update(RcPermission rcPermission) {
		Result<Integer> result = new Result<Integer>();
		if (!StringUtils.hasText(rcPermission.getPermissionsName())) {
			result.setErrMsg("权限名不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcPermission.getPermissionsValue())) {
			result.setErrMsg("权限值不能为空");
			return result;
		}
		int resultNum = dao.update(rcPermission);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("更新成功");
			return result;
		}
		result.setErrMsg("更新失败");
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
			result.setErrMsg("删除成功");
			return result;
		}
		result.setErrMsg("删除失败");
		return result;
	}

	@Override
	public Result<Page<RcPermission>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		Result<Page<RcPermission>> result = new Result<Page<RcPermission>>();
		if (pageCurrent < 1) {
			result.setErrMsg("pageCurrent有误");
			return result;
		}
		if (pageSize < 1) {
			result.setErrMsg("pageSize有误");
			return result;
		}
		Page<RcPermission> resultData = dao.listForPage(pageCurrent, pageSize, date, search);
		result.setResultData(resultData);
		result.setErrCode(0);
		result.setStatus(true);
		result.setErrMsg("查询成功");
		return result;
	}

	@Override
	public Result<List<RcPermission>> listForId(List<Long> idList) {
		Result<List<RcPermission>> result = new Result<List<RcPermission>>();
		if (idList.size() < 1) {
			result.setErrMsg("没有id需要查询");
			return result;
		}
		List<RcPermission> resultData = dao.listForId(idList);
		result.setErrCode(0);
		result.setStatus(true);
		result.setResultData(resultData);
		result.setErrMsg("查询成功");
		return result;
	}

	@Override
	public Result<List<RcPermission>> list() {
		Result<List<RcPermission>> result = new Result<List<RcPermission>>();
		List<RcPermission> resultData = dao.list();
		result.setErrCode(0);
		result.setStatus(true);
		result.setResultData(resultData);
		result.setErrMsg("查询成功");
		return result;
	}
}
