package com.roncoo.adminlte.service.impl.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryExample;
import com.roncoo.adminlte.service.impl.dao.DataDictionaryDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcDataDictionaryMapper;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;

/**
 * 
 * @author LYQ
 */
@Repository
public class DataDictionaryDaoImpl implements DataDictionaryDao {

	@Autowired
	private RcDataDictionaryMapper mapper;

	@Transactional
	@Override
	public int save(RcDataDictionary rcDataDictionary) {
		rcDataDictionary.setStatusId("1");
		rcDataDictionary.setCreateTime(new Date());
		rcDataDictionary.setUpdateTime(new Date());
		return mapper.insertSelective(rcDataDictionary);
	}

	@Override
	public Page<RcDataDictionary> listForPage(int pageCurrent, int pageSize) {
		RcDataDictionaryExample example = new RcDataDictionaryExample();
		example.setOrderByClause("sort desc");
		int totalCount = mapper.countByExample(example);
		pageSize = SqlUtil.checkPageSize(pageSize);
		pageCurrent = SqlUtil.checkPageCurrent(totalCount, pageSize, pageCurrent);
		int totalPage = SqlUtil.countTotalPage(totalCount, pageSize);
		example.setLimitStart(SqlUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);
		List<RcDataDictionary> list = mapper.selectByExample(example);
		Page<RcDataDictionary> page = new Page<>(totalCount, totalPage, pageCurrent, pageSize, list);
		return page;
	}

	@Override
	public RcDataDictionary queryById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteById(Long id) {
		mapper.deleteByPrimaryKey(id);
	}

}
