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
package com.roncoo.adminlte.biz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcPermission;
import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.bean.entity.RcRolePermissions;
import com.roncoo.adminlte.bean.vo.RcRoleVo;
import com.roncoo.adminlte.service.PermissionService;
import com.roncoo.adminlte.service.RolePermissionsService;
import com.roncoo.adminlte.service.RoleService;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.StringUtils;

@Component
public class RoleBiz {

	@Autowired
	private RoleService service;

	@Autowired
	private RolePermissionsService rolePermissionsService;

	@Autowired
	private PermissionService permissionService;

	public Result<RcRoleVo> query(long id) {
		Result<RcRole> result = service.query(id);
		Result<RcRoleVo> resultRoleVo = new Result<RcRoleVo>();
		if (result.isStatus()) {
			RcRoleVo rcRoleVo = new RcRoleVo(result.getResultData());
			HashSet<String> permissionNameSet = new HashSet<String>();
			HashSet<String> permissionSet = new HashSet<String>();
			Result<List<RcRolePermissions>> resultRolePermissions = rolePermissionsService.queryByRoleId(id);
			if (resultRolePermissions.isStatus()) {
				ArrayList<Long> idList = new ArrayList<Long>();
				for (RcRolePermissions rcRolePermissions : resultRolePermissions.getResultData()) {
					idList.add(rcRolePermissions.getPermissionId());
				}
				Result<List<RcPermission>> resultPermission = permissionService.listForId(idList);
				for (RcPermission rcPermission : resultPermission.getResultData()) {
					permissionNameSet.add(rcPermission.getPermissionsName());
					permissionSet.add(rcPermission.getPermissionsValue());
				}
				rcRoleVo.setPermission(StringUtils.toString(permissionSet));
				rcRoleVo.setPermissionName(StringUtils.toString(permissionNameSet));
				rcRoleVo.setPermissions(permissionSet);
				rcRoleVo.setPermissionNames(permissionNameSet);

				resultRoleVo.setErrCode(0);
				resultRoleVo.setStatus(true);
				resultRoleVo.setResultData(rcRoleVo);
				resultRoleVo.setErrMsg("查询成功");
				return resultRoleVo;
			}
		}
		return resultRoleVo;
	}

	public Result<List<RcPermission>> queryPermissionList() {
		return permissionService.list();
	}

	@Transactional
	public Result<Integer> save(RcRole rcRole, List<Long> permissionList) {
		Result<Integer> result = service.save(rcRole);
		if (result.isStatus()) {
			Result<RcRole> resultRole = service.queryByRoleName(rcRole.getRoleName());
			if (result.isStatus()) {
				return rolePermissionsService.save(resultRole.getResultData().getId(), permissionList);
			}
		}
		return result;
	}

	@Transactional
	public Result<Integer> update(RcRole rcRole, List<Long> permissionList) {
		Result<Integer> result = rolePermissionsService.update(rcRole.getId(), permissionList);
		if (result.isStatus()) {
			return service.update(rcRole);
		}
		return result;
	}

	@Transactional
	public Result<Integer> delete(long id) {
		Result<Integer> result = rolePermissionsService.delete(id);
		if (result.isStatus()) {
			return service.delete(id);
		}
		return result;
	}

	public Result<Page<RcRole>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		return service.listForPage(pageCurrent, pageSize, date, search);
	}
}
