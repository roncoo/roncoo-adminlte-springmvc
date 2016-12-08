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

import com.roncoo.adminlte.bean.entity.RcUserRole;

/**
 * 用户-角色Dao
 * @author LYQ
 *
 */
public interface UserRoleDao {
	
	RcUserRole selectById(long id);
 
	List<RcUserRole> selectByUserId(long id);
	
	RcUserRole selectByUserRole(RcUserRole rcUserRole);
	
	int insert(RcUserRole rcUserRole);

	int update(RcUserRole rcUserRole);

	int delectByRcUserRole(RcUserRole rcUserRole);
	
	int deleteById(long id);
}
