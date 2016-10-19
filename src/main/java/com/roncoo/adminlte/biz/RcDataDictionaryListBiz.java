package com.roncoo.adminlte.biz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryListExample;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryListExample.Criteria;
import com.roncoo.adminlte.service.RcDataDictionaryListService;
import com.roncoo.adminlte.service.RcDataDictionaryService;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * 作用功能：数据字典明细逻辑业务类 作者： LYQ 时间：2016年10月18日
 */
@Component
public class RcDataDictionaryListBiz {

	private String ORDER = "sort";

	@Autowired
	private RcDataDictionaryService dictionaryService;

	@Autowired
	private RcDataDictionaryListService dictionaryListService;

	public Page<RcDataDictionaryList> queryForPage(Page<RcDataDictionaryList> page, RcDataDictionaryList dictionaryList,
			Long dictionaryId) {
		if (page.getPageSize() == 0) {
			page.setPageSize(page.DEFAULT_PAGE_SIZE);
		}
		if (page.getPageCurrent() == 0) {
			page.setPageCurrent(1);
		}

		RcDataDictionaryListExample example = new RcDataDictionaryListExample();
		example.setLimitStart((page.getPageCurrent() - 1) * page.getPageSize());
		example.setPageSize(page.getPageSize());
		example.setOrderByClause(ORDER);

		RcDataDictionary dictionary = dictionaryService.selectByPrimaryKey(dictionaryId);
		Criteria criteria = example.createCriteria();
		criteria.andFieldCodeEqualTo(dictionary.getFieldCode());

		page = dictionaryListService.queryForPage(page, example);
		return page;

	}

	public List<RcDataDictionaryList> queryByFieldCode(String fieldCode) {
		RcDataDictionaryListExample example = new RcDataDictionaryListExample();
		example.setOrderByClause(ORDER);
		Criteria criteria = example.createCriteria();
		criteria.andFieldCodeEqualTo(fieldCode);
		return dictionaryListService.queryByFieldCode(example);

	}

	public void insert(RcDataDictionaryList dictionaryList, Long dictionaryId) {

		Date date = new Date();
		dictionaryList.setCreateTime(date);
		dictionaryList.setUpdateTime(date);

		RcDataDictionary dictionary = dictionaryService.selectByPrimaryKey(dictionaryId);
		dictionaryList.setFieldCode(dictionary.getFieldCode());

		dictionaryListService.insert(dictionaryList);
	}

	public void deleteById(Long id) {
		dictionaryListService.deleteById(id);
	}
}
