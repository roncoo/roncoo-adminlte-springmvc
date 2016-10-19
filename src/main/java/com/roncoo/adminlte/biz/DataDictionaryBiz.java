package com.roncoo.adminlte.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.service.DataDictionaryService;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典逻辑业务类
 * 
 * @author LYQ
 */
@Component
public class DataDictionaryBiz {

	@Autowired
	private DataDictionaryService dataDictionaryService;

	/**
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @return
	 */
	public Page<RcDataDictionary> listForPage(int pageCurrent, int pageSize) {

		return null;
	}

	/**
	 * 
	 * @param rcDataDictionary
	 */
	public int save(RcDataDictionary rcDataDictionary) {
		return dataDictionaryService.save(rcDataDictionary);
	}
}
