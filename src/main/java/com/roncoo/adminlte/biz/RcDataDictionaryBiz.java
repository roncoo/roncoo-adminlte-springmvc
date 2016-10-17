package com.roncoo.adminlte.biz;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryExample;
import com.roncoo.adminlte.service.RcDataDictionaryService;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * 作用功能：数据字典逻辑业务类
 * 作者： LYQ
 * 时间：2016年10月17日
 */
@Component
public class RcDataDictionaryBiz {
	
	private String SORT = "sort";
	
	@Autowired
	private RcDataDictionaryService dataDictionaryService;

	/**
	 * 
	 * 功能：分页查询
	 * 
	 * @param dictionary
	 * @return Page<RcDataDictionary>
	 */
	public Page<RcDataDictionary> queryForPage(Page<RcDataDictionary> page, RcDataDictionary dictionary) {
		if (page.getPageSize() == 0) {
			page.setPageSize(page.DEFAULT_PAGE_SIZE);
		}
		if (page.getPageCurrent() == 0) {
			page.setPageCurrent(1);
		}
		RcDataDictionaryExample example = new RcDataDictionaryExample();
		example.setLimitStart((page.getPageCurrent()-1)*page.getPageSize());
		example.setPageSize(page.getPageSize());
		example.setOrderByClause(SORT);
		
		page = dataDictionaryService.queryForPage(page, example);
		
		return page;
	}

	/**
	 * 
	 * 功能：添加RcDataDictionary
	 * 
	 * @return void
	 */
	public void insert(RcDataDictionary dictionary) {
		
		Date date = new Date();
		dictionary.setCreateTime(date);
		dictionary.setUpdateTime(date);
		
		dataDictionaryService.insert(dictionary);
	}
}
