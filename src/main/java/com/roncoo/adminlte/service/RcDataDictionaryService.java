package com.roncoo.adminlte.service;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryExample;
import com.roncoo.adminlte.util.base.Page;

public interface RcDataDictionaryService {
	
	Page<RcDataDictionary> queryForPage(Page< RcDataDictionary> page, RcDataDictionaryExample example);
	
	void insert(RcDataDictionary dictionary);
}
