package com.roncoo.adminlte.service.impl;

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
}
