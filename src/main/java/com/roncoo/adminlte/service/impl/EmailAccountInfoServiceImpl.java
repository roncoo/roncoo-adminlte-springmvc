package com.roncoo.adminlte.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.service.EmailAccountInfoService;
import com.roncoo.adminlte.service.impl.dao.EmailAccountInfoDao;
import com.roncoo.adminlte.util.base.Page;

@Service
public class EmailAccountInfoServiceImpl implements EmailAccountInfoService {

	@Autowired
	private EmailAccountInfoDao dao;

	@Override
	public Page<RcEmailAccountInfo> listForPage(int pageCurrent, int pageSize) {
		return dao.listForPage(pageCurrent, pageSize);
	}

	@Override
	public RcEmailAccountInfo queryById(Long id) {
		return dao.queryById(id);
	}

	@Override
	public void save(RcEmailAccountInfo info) {
		dao.save(info);
	}

	@Override
	public void update(RcEmailAccountInfo info) {
		dao.update(info);
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

}
