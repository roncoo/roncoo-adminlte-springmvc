package com.roncoo.adminlte.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcPermission;
import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.bean.entity.RcRolePermissions;
import com.roncoo.adminlte.service.PermissionService;
import com.roncoo.adminlte.service.RolePermissionsService;
import com.roncoo.adminlte.util.base.Page;

@Component
public class PermissionBiz {

	@Autowired
	private PermissionService service;

	@Autowired
	private RolePermissionsService rolePermissionsService;

	Result<RcPermission> query(long id) {
		return service.query(id);
	}

	Result<Integer> insert(RcPermission rcPermission) {
		return service.insert(rcPermission);
	}

	Result<Integer> update(RcPermission rcPermission) {
		return service.update(rcPermission);
	}

	Result<Integer> delete(long id) {
		return service.delete(id);
	}

	Result<Page<RcPermission>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		return service.listForPage(pageCurrent, pageSize, date, search);
	}

	Result<List<RcPermission>> list(List<RcRole> roleList) {
		ArrayList<Long> rolePremise = new ArrayList<Long>();
		for (RcRole rcRole : roleList) {
			rolePremise.add(rcRole.getId());
		}
		Result<List<RcRolePermissions>> resultRolePermissions = rolePermissionsService.list(rolePremise);
		if (!resultRolePermissions.isStatus() || resultRolePermissions.getResultData().size() < 1) {
			return new Result<List<RcPermission>>();
		}
		ArrayList<Long> premise = new ArrayList<Long>();
		for (RcRolePermissions rcRolePermissions : resultRolePermissions.getResultData()) {
			premise.add(rcRolePermissions.getPermissionId());
		}
		Result<List<RcPermission>> result = service.list(premise);
		return result;

	}
}
