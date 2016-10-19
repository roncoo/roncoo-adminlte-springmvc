package com.roncoo.adminlte.service.impl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryListExample;
import com.roncoo.adminlte.service.impl.dao.DataDictionaryListDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcDataDictionaryListMapper;

/**
 * 
 * 作用功能：数据字典明细接口实现类
 * 作者： LYQ
 * 时间：2016年10月18日
 */
@Repository
public class DataDictionaryListDaoImpl implements DataDictionaryListDao {

	@Autowired
	private RcDataDictionaryListMapper mapper;
	
	@Override
	public int countByExample(RcDataDictionaryListExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RcDataDictionaryListExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(RcDataDictionaryList record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<RcDataDictionaryList> selectByExample(RcDataDictionaryListExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public RcDataDictionaryList selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(RcDataDictionaryList record, RcDataDictionaryListExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

}
