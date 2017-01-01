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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.service.UserService;
import com.roncoo.adminlte.service.impl.dao.UserDao;
import com.roncoo.adminlte.util.base.Page;

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
	public Result<Integer> save(RcUser rcUser) {
		Result<Integer> result = new Result<Integer>();
		if (!StringUtils.hasText(rcUser.getUserNo())) {
			result.setErrMsg("账号不能为空");
		}
		if (!StringUtils.hasText(rcUser.getPassword())) {
			result.setErrMsg("密码不能为空");
		}
		RcUser user = dao.selectByUserNo(rcUser.getUserNo());
		if (user == null) {
			int resultNum = dao.insert(rcUser);
			if (resultNum > 0) {
				result.setErrCode(0);
				result.setStatus(true);
				result.setErrMsg("添加成功");
				return result;
			}
		}
		result.setErrMsg("添加失败");
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

	@Override
	public Result<Page<RcUser>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		Result<Page<RcUser>> result = new Result<Page<RcUser>>();
		if (pageCurrent < 1) {
			result.setErrMsg("pageCurrent有误");
			return result;
		}
		if (pageSize < 1) {
			result.setErrMsg("pageSize有误");
			return result;
		}
		Page<RcUser> resultData = dao.listForPage(pageCurrent, pageSize, date, search);
		result.setResultData(resultData);
		result.setErrCode(0);
		result.setStatus(true);
		result.setErrMsg("查询成功");
		return result;
	}

	@Override
	public Result<RcUser> query(long id) {
		Result<RcUser> result = new Result<RcUser>();
		if (id < 1) {
			result.setErrMsg("用户id不存在");
			return result;
		}
		RcUser resultData = dao.select(id);
		if (resultData != null) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("查询成功");
			result.setResultData(resultData);
			return result;
		}
		result.setErrMsg("查询失败");
		return result;
	}
}
