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

@Service
public class RcDataDictionaryServiceImpl implements RcDataDictionaryService {

	@Autowired
	private RcDataDictionaryDao rcDataDictionaryDao;

	@Transactional
	@Override
	public Page<RcDataDictionary> queryForPage(Page<RcDataDictionary> page, RcDataDictionaryExample example) {
		int countTotal = rcDataDictionaryDao.countByExample(example);
		int totalPage = 1;
		if (countTotal != 0) {
			totalPage = countTotal / page.getPageSize();

			if (countTotal % page.getPageSize() != 0) {
				totalPage++;
			}
		}
		page.setTotalCount(countTotal);
		page.setTotalPage(totalPage);

		List<RcDataDictionary> result = rcDataDictionaryDao.selectByExample(example);
		page.setList(result);
		return page;
	}

	@Transactional
	@Override
	public void insert(RcDataDictionary dictionary) {
		RcDataDictionaryExample example = new RcDataDictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andFieldCodeEqualTo(dictionary.getFieldCode());
		List<RcDataDictionary> result = rcDataDictionaryDao.selectByExample(example);
		if (result.isEmpty()) {
			rcDataDictionaryDao.insertSelective(dictionary);
		}
	}

}
