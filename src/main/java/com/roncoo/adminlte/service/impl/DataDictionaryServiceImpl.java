package com.roncoo.adminlte.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.service.DataDictionaryService;
import com.roncoo.adminlte.service.impl.dao.DataDictionaryDao;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典接口实现类
 * 
 * @author LYQ
 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

	@Autowired
	private DataDictionaryDao dao;

	@Override
	public int save(RcDataDictionary rcDataDictionary) {
		return dao.save(rcDataDictionary);
	}

	@Override
	public Page<RcDataDictionary> listForPage(int pageCurrent, int pageSize) {
		return dao.listForPage(pageCurrent, pageSize);
	}

	@Override
	public RcDataDictionary queryById(Long id) {
		return dao.queryById(id);
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

}
