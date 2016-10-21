package com.roncoo.adminlte.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.service.DataDictionaryListService;
import com.roncoo.adminlte.service.impl.dao.DataDictionaryListDao;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * 作用功能：数据字典明细服务接口实现类 作者： LYQ 时间：2016年10月18日
 */
@Service
public class DataDictionaryListServiceImpl implements DataDictionaryListService {

	@Autowired
	private DataDictionaryListDao dao;

	@Override
	public Page<RcDataDictionaryList> listForPage(int pageCurrent, int pageSize, String fieldCode) {
		return dao.listForPage(pageCurrent, pageSize, fieldCode);
	}

	@Override
	public int save(RcDataDictionaryList dList) {
		return dao.insert(dList);
	}

	@Override
	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	@Override
	public int deleteByFieldCode(String fieldCode) {
		return dao.deleteByFieldCode(fieldCode);
	}

	@Override
	public List<RcDataDictionaryList> listByFieldCode(String fieldCode) {
		return dao.listByFieldCode(fieldCode);
	}


}
