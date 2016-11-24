package com.roncoo.adminlte.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.service.RoleService;
import com.roncoo.adminlte.service.impl.dao.RoleDao;

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
	public Result<Integer> insert(RcRole rcRole) {
		Result<Integer> result = new Result<Integer>();
		if (!StringUtils.hasText(rcRole.getRoleName())) {
			result.setErrMsg("角色名不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcRole.getRoleValue())) {
			result.setErrMsg("角色值不能为空");
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
}
