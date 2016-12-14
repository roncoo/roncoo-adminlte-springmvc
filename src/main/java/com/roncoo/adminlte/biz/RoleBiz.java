package com.roncoo.adminlte.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.service.RoleService;
import com.roncoo.adminlte.util.base.Page;

@Component
public class RoleBiz {

	@Autowired
	private RoleService service;

	Result<RcRole> query(long id) {
		return service.query(id);
	}

	Result<Integer> save(RcRole rcRole) {
		return service.save(rcRole);
	}

	Result<Integer> update(RcRole rcRole) {
		return service.update(rcRole);
	}

	Result<Integer> delete(long id) {
		return service.delete(id);
	}

	Result<Page<RcRole>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		return service.listForPage(pageCurrent, pageSize, date, search);
	}

	Result<List<RcRole>> getRolesList() {
		return service.list();
	}
}
