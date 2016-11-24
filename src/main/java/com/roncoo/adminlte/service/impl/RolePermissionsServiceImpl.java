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
	public Result<Integer> insert(RcRolePermissions rcRolePermissions) {
		Result<Integer> result = new Result<Integer>();
		if (rcRolePermissions.getRoleId() < 0) {
			result.setErrMsg("此角色id无效");
			return result;
		}
		if (rcRolePermissions.getPermissionId() < 0) {
			result.setErrMsg("此权限id无效");
			return result;
		}
		int resultNum = dao.insert(rcRolePermissions);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}

	@Override
	public Result<Integer> update(RcRolePermissions rcRolePermissions) {
		Result<Integer> result = new Result<Integer>();
		if (rcRolePermissions.getRoleId() < 0) {
			result.setErrMsg("此角色id无效");
			return result;
		}
		if (rcRolePermissions.getPermissionId() < 0) {
			result.setErrMsg("此权限id无效");
			return result;
		}
		int resultNum = dao.update(rcRolePermissions);
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
}
