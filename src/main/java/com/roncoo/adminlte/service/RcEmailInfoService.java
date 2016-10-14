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
package com.roncoo.adminlte.service;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.bean.entity.RcEmailInfoExample;
import com.roncoo.adminlte.util.base.Page;

/**
 * @author wujing
 */
public interface RcEmailInfoService {
	
	/**
	 * 
	 * 功能：分页查询
	 * @param page
	 * @param premise
	 * @return Page<RcEmailInfo>
	 */
	Page<RcEmailInfo> queryForPage(Page<RcEmailInfo> page,RcEmailInfoExample premise);
	
	/**
	 * 
	 * 功能：保存邮件信息
	 * @param info void
	 */
	void insertSelective(RcEmailInfo info);
}
