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

import java.util.List;

import com.roncoo.adminlte.bean.entity.RcUserRole;
import com.roncoo.adminlte.bean.vo.Result;

/**
 * 用户-角色Service
 * 
 * @author LYQ
 *
 */
public interface UserRoleService {

	Result<List<RcUserRole>> queryByUserId(long id);

	Result<RcUserRole> queryByUserRole(RcUserRole rcUserRole);

	Result<Integer> insert(RcUserRole rcUserRole);

	Result<Integer> update(RcUserRole rcUserRole);

	Result<Integer> updateByUserId(long userId, List<Long> roles);
	
	Result<Integer> deleteByUserRole(RcUserRole rcUserRole);
}
