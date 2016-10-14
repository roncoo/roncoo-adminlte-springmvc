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
package com.roncoo.adminlte.service.impl.dao;

import java.util.List;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.bean.entity.RcEmailInfoExample;

/**
 * @author wujing
 */
public interface RcEmailInfoDao {
	
	/**
	 * 
	 * 功能：统计email记录
	 * @param example
	 * @return int
	 */
	int countTotal(RcEmailInfoExample example);
	
	/**
	 * 
	 * 功能：查询邮件
	 * @param example
	 * @return List<RcEmailInfo>
	 */
	List<RcEmailInfo> queryForPage(RcEmailInfoExample example);
	
	/**
	 * 
	 * 功能：添加邮件信息
	 * @param info
	 * @return int
	 */
	int insertSelective(RcEmailInfo info);
}
