package com.roncoo.adminlte.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.service.DataDictionaryListService;
import com.roncoo.adminlte.service.DataDictionaryService;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典明细逻辑功能
 * 
 * @author LYQ
 */
@Component
public class DataDictionaryListBiz {

	@Autowired
	private DataDictionaryService dictionaryService;

	@Autowired
	private DataDictionaryListService dictionaryListService;

	/**
	 * 分页查询
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @param id
	 * @return
	 */
	public Page<RcDataDictionaryList> listForPage(int pageCurrent, int pageSize, Long id) {
		RcDataDictionary dictionary = dictionaryService.queryById(id);
		RcDataDictionaryList dList = new RcDataDictionaryList();
		dList.setFieldCode(dictionary.getFieldCode());
		return dictionaryListService.listForPage(dList, pageCurrent, pageSize);

	}

	/**
	 * 根据id删除
	 */
	public void deleteById(Long id) {
		dictionaryListService.deleteById(id);
	}

	/**
	 * 添加
	 * 
	 * @param dList
	 * @param id
	 */
	public void save(RcDataDictionaryList dList) {
		dictionaryListService.save(dList);
	}

}
