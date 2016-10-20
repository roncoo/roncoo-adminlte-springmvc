package com.roncoo.adminlte.service.impl.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfoExample;
import com.roncoo.adminlte.service.impl.dao.EmailAccountInfoDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcEmailAccountInfoMapper;
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
	public void delete(RcEmailAccountInfoExample example) {
		mapper.deleteByExample(example);
	}

	@Override
	public void deleteById(Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void save(RcEmailAccountInfo info) {
		Date date = new Date();
		info.setCreateTime(date);
		info.setUpdateTime(date);
		mapper.insertSelective(info);
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
	public void update(RcEmailAccountInfo info) {
		mapper.updateByPrimaryKeySelective(info);
	}
}
