package com.roncoo.adminlte.biz;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfoExample;
import com.roncoo.adminlte.service.RcEmailAccountInfoService;
import com.roncoo.adminlte.util.Base64Util;
import com.roncoo.adminlte.util.base.Page;

@Component
public class RcEmailAccountInfoBiz {

	private String ORDER = "create_time";

	@Autowired
	private RcEmailAccountInfoService service;

	public Page<RcEmailAccountInfo> queryForPage(Page<RcEmailAccountInfo> page, RcEmailAccountInfo info) {

		if (page.getPageSize() == 0) {
			page.setPageSize(page.DEFAULT_PAGE_SIZE);
		}
		if (page.getPageCurrent() == 0) {
			page.setPageCurrent(1);
		}
		RcEmailAccountInfoExample example = new RcEmailAccountInfoExample();
		int limitStart = (page.getPageCurrent() - 1) * page.getPageSize();
		example.setLimitStart(limitStart);
		example.setPageSize(page.getPageSize());
		example.setOrderByClause(ORDER);

		page = service.queryForpage(page, example);

		return page;
	}

	public void insert(RcEmailAccountInfo info) {
		Date date = new Date();
		info.setCreateTime(date);
		info.setUpdateTime(date);

		String pass = Base64Util.encrypt(info.getPasswd());
		info.setPasswd(pass);

		service.insert(info);
	}
}
