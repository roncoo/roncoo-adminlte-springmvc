package com.roncoo.adminlte.test.userTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-core.xml")
public class UserTest {
	
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
	
	
	
//	@Test
	public void addUser(){
//		RcUser user = new RcUser();
//		user.setUserNo("admin");
//		user.setPassword("admin");
//		user.setNickName("超级管理员");
//		user.setSex(1);
		
		RcUser user = new RcUser();
		user.setUserNo("user");
		user.setPassword("user");
		user.setNickName("普通用户");
		user.setSex(1);
		
		userService.insert(user);
	}
	
//	@Test
	public void addRole(){
		RcRole role = new RcRole();
		role.setRoleName("超级管理员");
		role.setRoleValue("admin");
		
		RcRole role1 = new RcRole();
		role1.setRoleName("普通用户");
		role1.setRoleValue("user");
		
		roleService.insert(role);
		roleService.insert(role1);
	}
	
//	@Test
	public void addPermission(){
		RcPermission permission = new RcPermission();
		permission.setPermissionsName("用户删除");
		permission.setPermissionsValue("user:delete");
		
		permissionService.insert(permission);
	}
	
//	@Test
	public void addUserRole(){
		RcUserRole rcUserRole = new RcUserRole();
		rcUserRole.setUserId((long) 2);
		rcUserRole.setRolesId((long) 2);
		
		userRoleService.insert(rcUserRole);
		
	}
	
	@Test
	public void addRolePermission(){
		RcRolePermissions rcRolePermissions = new RcRolePermissions();
		rcRolePermissions.setRoleId((long) 2);
		rcRolePermissions.setPermissionId((long) 8);
		
		rolePermissionsService.insert(rcRolePermissions);
	}
}
