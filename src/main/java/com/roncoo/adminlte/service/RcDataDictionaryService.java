package com.roncoo.adminlte.service;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryExample;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * 作用功能：数据字典接口类
 * 作者： LYQ
 * 时间：2016年10月18日
 */
public interface RcDataDictionaryService {
	
	Page<RcDataDictionary> queryForPage(Page< RcDataDictionary> page, RcDataDictionaryExample example);
	
	RcDataDictionary selectByPrimaryKey(Long id);
	
	void insert(RcDataDictionary dictionary);
}
