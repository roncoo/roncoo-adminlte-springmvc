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

import com.roncoo.adminlte.bean.entity.RcRolePermissions;

/**
 * 角色-权限Dao
 * @author LYQ
 *
 */
public interface RolePermissionsDao {
	
	RcRolePermissions selectById(long id);

	List<RcRolePermissions> selectByRoleId(long id);

	int insert(RcRolePermissions rcRolePermissions);

	int update(RcRolePermissions rcRolePermissions);

	int delectByRolePermissions(RcRolePermissions rcRolePermissions);
	
	int deleteById(Long id);
	
	List<RcRolePermissions> list(List<Long> premise);

}
