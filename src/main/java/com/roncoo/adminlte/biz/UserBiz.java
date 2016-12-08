package com.roncoo.adminlte.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcPermission;
import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.bean.entity.RcRolePermissions;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.RcUserRole;
import com.roncoo.adminlte.service.PermissionService;
import com.roncoo.adminlte.service.RolePermissionsService;
import com.roncoo.adminlte.service.RoleService;
import com.roncoo.adminlte.service.UserRoleService;
import com.roncoo.adminlte.service.UserService;

@Component
public class UserBiz {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RolePermissionsService rolePermissionsService;
	
	@Autowired
	private PermissionService permissionService;

	public Result<RcUser> login(String userno, String password) {
		return userService.login(userno, password);
	}
	
	public Result<RcUser> getUser(String userno){
		return userService.queryByUserNo(userno);
	}
	
	public Result<List<RcUserRole>> getUserRole(long id){
		return userRoleService.queryByUserId(id);
	}
	
	public Result<RcRole> getRole(long id){
		return roleService.query(id);
	}
	
	public Result<List<RcRolePermissions>> getRolePermissions(long id){
		return rolePermissionsService.queryByRoleId(id);
	}
	
	public Result<RcPermission> getPermission(long id){
		return permissionService.query(id);
	}
}
