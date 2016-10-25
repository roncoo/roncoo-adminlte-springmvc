package com.roncoo.adminlte.service.impl.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfoExample;
import com.roncoo.adminlte.service.impl.dao.EmailAccountInfoDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcEmailAccountInfoMapper;
import com.roncoo.adminlte.util.Base64Util;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;

@Repository
public class EmailAccountInfoDaoImpl implements EmailAccountInfoDao {

	@Autowired
	private RcEmailAccountInfoMapper mapper;

	@Override
	public int count(RcEmailAccountInfoExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int delete(RcEmailAccountInfoExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(RcEmailAccountInfo info) {
		String passwd = Base64Util.encrypt(info.getPasswd());
		info.setPasswd(passwd);
		Date date = new Date();
		info.setCreateTime(date);
		info.setUpdateTime(date);
		return mapper.insertSelective(info);
	}

	@Override
	public Page<RcEmailAccountInfo> listForPage(int pageCurrent, int pageSize) {
		RcEmailAccountInfoExample example = new RcEmailAccountInfoExample();
		example.setOrderByClause("id desc");
		int totalCount = mapper.countByExample(example);
		pageSize = SqlUtil.checkPageSize(pageSize);
		pageCurrent = SqlUtil.checkPageCurrent(totalCount, pageSize, pageCurrent);
		int totalPage = SqlUtil.countTotalPage(totalCount, pageSize);
		List<RcEmailAccountInfo> list = mapper.selectByExample(example);
		Page<RcEmailAccountInfo> page = new Page<>(totalCount, totalPage, pageCurrent, pageSize, list);
		return page;
	}

	@Override
	public RcEmailAccountInfo queryById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(RcEmailAccountInfo info) {
		String passwd = Base64Util.encrypt(info.getPasswd());
		info.setPasswd(passwd);
		info.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(info);
	}

	@Override
	public RcEmailAccountInfo queryByRand() {
		RcEmailAccountInfo info = mapper.selectByRand();
		String passwd = Base64Util.decode(info.getPasswd());
		info.setPasswd(passwd);
		return info;
	}
}
