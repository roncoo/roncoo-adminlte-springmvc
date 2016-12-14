package com.roncoo.adminlte.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcUserRole;
import com.roncoo.adminlte.service.UserRoleService;

@Component
public class UserRoleBiz {

	@Autowired
	private UserRoleService service;

	Result<List<RcUserRole>> queryRoles(long userId) {
		return service.queryByUserId(userId);
	}
}
