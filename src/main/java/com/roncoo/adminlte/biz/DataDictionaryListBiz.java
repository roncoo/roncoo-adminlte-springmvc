package com.roncoo.adminlte.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.service.DataDictionaryListService;
import com.roncoo.adminlte.service.DataDictionaryService;
import com.roncoo.adminlte.util.base.Page;

/**
 * @author LYQ
 */
@Component
public class DataDictionaryListBiz {

	private String ORDER = "sort";

	@Autowired
	private DataDictionaryService dictionaryService;

	@Autowired
	private DataDictionaryListService dictionaryListService;

	public Page<RcDataDictionaryList> listForPage(int pageCurrent, int pageSize, Long id) {
		return null;

	}

}
