package com.roncoo.adminlte.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryExample;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryExample.Criteria;
import com.roncoo.adminlte.service.RcDataDictionaryService;
import com.roncoo.adminlte.service.impl.dao.RcDataDictionaryDao;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * 作用功能：数据字典接口实现类
 * 作者： LYQ
 * 时间：2016年10月18日
 */
@Service
public class RcDataDictionaryServiceImpl implements RcDataDictionaryService {

	@Autowired
	private RcDataDictionaryDao dao;

	@Transactional
	@Override
	public Page<RcDataDictionary> queryForPage(Page<RcDataDictionary> page, RcDataDictionaryExample example) {
		int totalCount = dao.countByExample(example);
		int totalPage = 1;
		if (totalCount != 0) {
			totalPage = totalCount / page.getPageSize();

			if (totalCount % page.getPageSize() != 0) {
				totalPage++;
			}
		}
		page.setTotalCount(totalCount);
		page.setTotalPage(totalPage);

		List<RcDataDictionary> result = dao.selectByExample(example);
		page.setList(result);
		return page;
	}

	public RcDataDictionary selectByPrimaryKey(Long id) {
		return dao.selectByPrimaryKey(id);
	}

	@Transactional
	@Override
	public void insert(RcDataDictionary dictionary) {
		RcDataDictionaryExample example = new RcDataDictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andFieldCodeEqualTo(dictionary.getFieldCode());
		List<RcDataDictionary> result = dao.selectByExample(example);
		if (result.isEmpty()) {
			dao.insertSelective(dictionary);
		}
	}

}
