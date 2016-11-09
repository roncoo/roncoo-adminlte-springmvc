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
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.service.EmailAccountInfoService;
import com.roncoo.adminlte.service.impl.dao.EmailAccountInfoDao;
import com.roncoo.adminlte.util.Base64Util;
import com.roncoo.adminlte.util.base.Page;

@Service
public class EmailAccountInfoServiceImpl implements EmailAccountInfoService {

	@Autowired
	private EmailAccountInfoDao dao;

	@Override
	public Result<Page<RcEmailAccountInfo>> listForPage(int pageCurrent, int pageSize, String premise, String datePremise) {
		Result<Page<RcEmailAccountInfo>> result = new Result<>();
		if (pageCurrent < 1) {
			result.setErrMsg("参数pageCurrent有误,pageCurrent=" + pageCurrent);
			return result;
		}
		if (pageSize < 1) {
			result.setErrMsg("参数pageSize有误,pageSize=" + pageSize);
			return result;
		}
		Page<RcEmailAccountInfo> resultData = dao.listForPage(pageCurrent, pageSize, premise, datePremise);
		result.setResultData(resultData);
		result.setStatus(true);
		result.setErrCode(0);
		return result;
	}

	@Override
	public Result<RcEmailAccountInfo> query(Long id) {
		Result<RcEmailAccountInfo> result = new Result<>();
		if (id < 1) {
			result.setErrMsg("此操作的id：" + id + "为无效id");
			return result;
		}

		RcEmailAccountInfo resultData = dao.selectById(id);
		// 解密
		String passwd = Base64Util.decode(resultData.getPasswd());
		resultData.setPasswd(passwd);

		result.setResultData(resultData);
		result.setStatus(true);
		result.setErrCode(0);
		return result;
	}

	@Override
	public Result<RcEmailAccountInfo> save(RcEmailAccountInfo info) {
		Result<RcEmailAccountInfo> result = new Result<>();
		if (!StringUtils.hasText(info.getFromUser())) {
			result.setErrMsg("用户名不能为空");
			return result;
		}
		if (!StringUtils.hasText(info.getHost())) {
			result.setErrMsg("host不能为空");
			return result;
		}
		if (!StringUtils.hasText(info.getPasswd())) {
			result.setErrMsg("授权码不能为空");
			return result;
		}
		if (dao.insert(info) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
		}
		return result;
	}

	@Override
	public Result<RcEmailAccountInfo> delete(Long id) {
		Result<RcEmailAccountInfo> result = new Result<>();
		if (id < 1) {
			result.setErrMsg("此操作的id：" + id + "为无效id");
			return result;
		}
		if (dao.deleteById(id) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
		}
		return result;
	}

	@Override
	public Result<RcEmailAccountInfo> update(RcEmailAccountInfo info) {
		Result<RcEmailAccountInfo> result = new Result<RcEmailAccountInfo>();
		if (!StringUtils.hasText(info.getFromUser())) {
			result.setErrMsg("用户名不能为空");
			return result;
		}
		if (!StringUtils.hasText(info.getHost())) {
			result.setErrMsg("host不能为空");
			return result;
		}
		if (!StringUtils.hasText(info.getPasswd())) {
			result.setErrMsg("授权码不能为空");
			return result;
		}
		if (dao.updateById(info) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
			result.setResultData(info);
		}
		return result;
	}

	@Override
	public Result<List<RcEmailAccountInfo>> list() {
		Result<List<RcEmailAccountInfo>> result = new Result<List<RcEmailAccountInfo>>();
		List<RcEmailAccountInfo> list = dao.list();
		result.setStatus(true);
		result.setErrCode(0);
		result.setResultData(list);
		return result;
	}

}
