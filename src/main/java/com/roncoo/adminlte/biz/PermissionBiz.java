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
package com.roncoo.adminlte.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcPermission;
import com.roncoo.adminlte.service.PermissionService;
import com.roncoo.adminlte.util.base.Page;

@Component
public class PermissionBiz {

	@Autowired
	private PermissionService service;

	public Result<RcPermission> query(long id) {
		return service.query(id);
	}

	public Result<Integer> save(RcPermission rcPermission) {
		return service.save(rcPermission);
	}

	public Result<Integer> update(RcPermission rcPermission) {
		return service.update(rcPermission);
	}

	public Result<Integer> delete(long id) {
		return service.delete(id);
	}

	public Result<Page<RcPermission>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		return service.listForPage(pageCurrent, pageSize, date, search);
	}
}
