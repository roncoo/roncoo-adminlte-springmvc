package com.roncoo.adminlte.service.impl.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.service.impl.dao.DataDictionaryDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcDataDictionaryMapper;

/**
 * 
 * @author LYQ
 */
@Repository
public class DataDictionaryDaoImpl implements DataDictionaryDao {

	@Autowired
	private RcDataDictionaryMapper mapper;

	@Override
	public int insert(RcDataDictionary rcDataDictionary) {
		rcDataDictionary.setStatusId("1");
		rcDataDictionary.setCreateTime(new Date());
		rcDataDictionary.setUpdateTime(new Date());
		return mapper.insertSelective(rcDataDictionary);
	}

}
