package com.roncoo.adminlte.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.service.UserService;
import com.roncoo.adminlte.service.impl.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public Result<RcUser> login(String userno, String password) {
		Result<RcUser> result = new Result<RcUser>();
		if (!StringUtils.hasText(userno)) {
			result.setErrMsg("账号不能为空");
			return result;
		}
		if (!StringUtils.hasText(password)) {
			result.setErrMsg("密码不能为空");
			return result;
		}
		RcUser user = dao.selectUser(userno, password);
		if (user != null) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setResultData(user);
		}
		return result;
	}

	@Override
	public Result<RcUser> queryByUserNo(String userno) {
		Result<RcUser> result = new Result<RcUser>();
		if (!StringUtils.hasText(userno)) {
			result.setErrMsg("账号不能为空");
			return result;
		}
		RcUser user = dao.selectByUserNo(userno);
		if (user != null) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setResultData(user);
		}
		return result;
	}

	@Override
	public Result<Integer> insert(RcUser rcUser) {
		Result<Integer> result = new Result<Integer>();
		if (!StringUtils.hasText(rcUser.getUserNo())) {
			result.setErrMsg("账号不能为空");
		}
		if (!StringUtils.hasText(rcUser.getPassword())) {
			result.setErrMsg("密码不能为空");
		}
		int resultNum = dao.insert(rcUser);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}

	@Override
	public Result<Integer> update(RcUser rcUser) {
		Result<Integer> result = new Result<Integer>();
		int resultNum = dao.update(rcUser);
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
