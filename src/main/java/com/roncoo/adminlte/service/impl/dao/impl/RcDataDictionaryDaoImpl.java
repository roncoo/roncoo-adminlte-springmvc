package com.roncoo.adminlte.service.impl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryExample;
import com.roncoo.adminlte.service.impl.dao.RcDataDictionaryDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcDataDictionaryMapper;

/**
 * 
 * 作用功能：数据字典接口实现类
 * 作者： LYQ
 * 时间：2016年10月18日
 */
@Repository
public class RcDataDictionaryDaoImpl implements RcDataDictionaryDao {
	
	@Autowired
	private RcDataDictionaryMapper mapper;

	@Override
	public int countByExample(RcDataDictionaryExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(RcDataDictionary record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<RcDataDictionary> selectByExample(RcDataDictionaryExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public RcDataDictionary selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

}
