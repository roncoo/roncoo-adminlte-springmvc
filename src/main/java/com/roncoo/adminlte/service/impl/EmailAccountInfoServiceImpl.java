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
	public Page<RcEmailAccountInfo> listForPage(int pageCurrent, int pageSize) {
		return dao.listForPage(pageCurrent, pageSize);
	}

	@Override
	public RcEmailAccountInfo queryById(Long id) {
		RcEmailAccountInfo info = dao.selectById(id);
		String passwd = Base64Util.decode(info.getPasswd());
		info.setPasswd(passwd);
		return info;
	}

	@Override
	public int save(RcEmailAccountInfo info) {
		return dao.insert(info);
	}

	@Override
	public int updateById(RcEmailAccountInfo info) {
		return dao.updateById(info);
	}

	@Override
	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	@Override
	public RcEmailAccountInfo queryByRand() {
		return dao.queryByRand();
	}

	@Override
	public int update(RcEmailAccountInfo info) {
		return dao.updateById(info);
	}

}
