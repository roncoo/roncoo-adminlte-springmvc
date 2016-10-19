package com.roncoo.adminlte.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.service.EmailAccountInfoService;
import com.roncoo.adminlte.util.base.Page;

@Component
public class EmailAccountInfoBiz {

	@Autowired
	private EmailAccountInfoService emailAccountInfoService;

	public Page<RcEmailAccountInfo> listForPage(int pageCurrent, int pageSize) {
		return null;
	}

	public void save(RcEmailAccountInfo rcEmailAccountInfo) {

	}
}
