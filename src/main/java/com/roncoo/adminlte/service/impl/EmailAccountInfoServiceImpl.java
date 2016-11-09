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
	public Result<Page<RcEmailAccountInfo>> listForPage(int pageCurrent, int pageSize) {
		Result<Page<RcEmailAccountInfo>> result = new Result<>();
		if(pageCurrent<1){
			result.setErrMsg("pageCurrent有误");
			return result;
		}
		if(pageSize<1){
			result.setErrMsg("pageSize有误");
			return result;
		}
		result.setResultData(dao.listForPage(pageCurrent, pageSize));
		result.setErrCode(0);
		result.setStatus(true);
		return result;
	}

	@Override
	public Result<RcEmailAccountInfo> queryById(Long id) {
		Result<RcEmailAccountInfo> result = new Result<>();
		if(id<1){
			result.setErrMsg("此id无效");
			return result;
		}
		RcEmailAccountInfo info = dao.selectById(id);
		String passwd = Base64Util.decode(info.getPasswd());
		info.setPasswd(passwd);
		result.setResultData(info);
		result.setErrCode(0);
		result.setStatus(true);
		return result;
	}

	@Override
	public Result<RcEmailAccountInfo> save(RcEmailAccountInfo info) {
		Result<RcEmailAccountInfo> result = new Result<>();
		if(!StringUtils.hasText(info.getFromUser())){
			result.setErrMsg("账号不能为空");
			return result;
		}
		if(!StringUtils.hasText(info.getHost())){
			result.setErrMsg("Host不能为空");
			return result;
		}
		if(!StringUtils.hasText(info.getPasswd())){
			result.setErrMsg("授权码不能为空");
			return result;
		}
		if(dao.insert(info)>0){
			result.setStatus(true);
			result.setErrCode(0);
		}
		return result;
	}

	@Override
	public Result<RcEmailAccountInfo> updateById(RcEmailAccountInfo info) {
		Result<RcEmailAccountInfo> result = new Result<>();
		if(!StringUtils.hasText(info.getFromUser())){
			result.setErrMsg("账号不能为空");
			return result;
		}
		if(!StringUtils.hasText(info.getHost())){
			result.setErrMsg("Host不能为空");
			return result;
		}
		if(!StringUtils.hasText(info.getPasswd())){
			result.setErrMsg("授权码不能为空");
			return result;
		}
		if(dao.updateById(info)>0){
			result.setStatus(true);
			result.setErrCode(0);
		}
		return result;
	}

	@Override
	public Result<RcEmailAccountInfo> deleteById(Long id) {
		Result<RcEmailAccountInfo> result = new Result<>();
		if(id<1){
			result.setErrMsg("此id无效");
			return result;
		}
		if(dao.deleteById(id)>0){
			result.setStatus(true);
			result.setErrCode(0);
		}
		return result;
	}

	@Override
	public Result<RcEmailAccountInfo> queryByRand() {
		Result<RcEmailAccountInfo> result = new Result<>();
		result.setResultData(dao.queryByRand());
		result.setStatus(true);
		result.setErrCode(0);
		return result;
	}

	@Override
	public Result<RcEmailAccountInfo> update(RcEmailAccountInfo info) {
		Result<RcEmailAccountInfo> result = new Result<>();
		if(!StringUtils.hasText(info.getFromUser())){
			result.setErrMsg("账号不能为空");
			return result;
		}
		if(!StringUtils.hasText(info.getHost())){
			result.setErrMsg("Host不能为空");
			return result;
		}
		if(!StringUtils.hasText(info.getPasswd())){
			result.setErrMsg("授权码不能为空");
			return result;
		}
		if(dao.updateById(info)>0){
			result.setStatus(true);
			result.setErrCode(0);
		}
		return result;
	}

}
