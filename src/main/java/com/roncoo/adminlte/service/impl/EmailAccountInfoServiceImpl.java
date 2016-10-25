package com.roncoo.adminlte.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.service.EmailAccountInfoService;
import com.roncoo.adminlte.service.impl.dao.EmailAccountInfoDao;
import com.roncoo.adminlte.util.Base64Util;
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
		RcEmailAccountInfo info = dao.queryById(id);
		String passwd = Base64Util.decode(info.getPasswd());
		info.setPasswd(passwd);
		return info;
	}

	@Override
	public int save(RcEmailAccountInfo info) {
		return dao.insert(info);
	}

	@Override
	public int updateById(RcEmailAccountInfo info) {
		return dao.update(info);
	}

	@Override
	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	@Override
	public RcEmailAccountInfo queryByRand() {
		return dao.queryByRand();
	}

	@Override
	public int update(RcEmailAccountInfo info) {
		return dao.update(info);
	}

}
