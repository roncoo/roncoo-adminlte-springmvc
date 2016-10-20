package com.roncoo.adminlte.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryListExample;
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
	public Page<RcDataDictionaryList> listForPage(RcDataDictionaryList dList, int pageCurrent, int pageSize) {
		return dao.listForPage(dList, pageCurrent, pageSize);
	}

	@Override
	public RcDataDictionaryList queryById(Long id) {
		return null;
	}

	@Override
	public void save(RcDataDictionaryList dList) {
		dao.save(dList);
	}

	@Override
	public void update(RcDataDictionaryList dList, RcDataDictionaryListExample example) {
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void delete(RcDataDictionaryList dList) {
		dao.delete(dList);
	}

	@Override
	public List<RcDataDictionaryList> listForFieldCode(String fieldCode) {
		return dao.listForFieldCode(fieldCode);
	}
}
