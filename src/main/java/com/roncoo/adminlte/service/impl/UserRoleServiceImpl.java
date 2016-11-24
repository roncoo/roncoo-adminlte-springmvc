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
	public Result<RcUserRole> query(long id) {
		Result<RcUserRole> result = new Result<RcUserRole>();
		if (id < 0) {
			result.setErrMsg("此id无效");
			return result;
		}
		RcUserRole rcUserRole = dao.selectById(id);
		if (rcUserRole != null) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setResultData(rcUserRole);
		}
		return result;
	}

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
	public Result<Integer> deleteByUserRole(RcUserRole rcUserRole) {
		Result<Integer> result = new Result<Integer>();
		if (rcUserRole.getUserId() < 0) {
			result.setErrMsg("此用户id无效");
			return result;
		}
		if (rcUserRole.getRolesId() < 0) {
			result.setErrMsg("此角色id无效");
			return result;
		}
		int resultNum = dao.delectByRcUserRole(rcUserRole);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}
}
