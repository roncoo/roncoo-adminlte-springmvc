package com.roncoo.adminlte.service.impl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryExample;
import com.roncoo.adminlte.service.impl.dao.RcDataDictionaryDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcDataDictionaryMapper;

@Repository
public class RcDataDictionaryDaoImpl implements RcDataDictionaryDao {
	
	@Autowired
	private RcDataDictionaryMapper rcDataDictionaryMapper;

	@Override
	public int countByExample(RcDataDictionaryExample example) {
		return rcDataDictionaryMapper.countByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return rcDataDictionaryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(RcDataDictionary record) {
		return rcDataDictionaryMapper.insertSelective(record);
	}

	@Override
	public List<RcDataDictionary> selectByExample(RcDataDictionaryExample example) {
		return rcDataDictionaryMapper.selectByExample(example);
	}

}
