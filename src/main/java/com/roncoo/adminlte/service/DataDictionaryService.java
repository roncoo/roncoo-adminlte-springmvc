package com.roncoo.adminlte.service;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典业务功能
 * 
 * @author LYQ
 */
public interface DataDictionaryService {

	/**
	 * 添加
	 * 
	 * @param rcDataDictionary
	 * @return
	 */
	int save(RcDataDictionary rcDataDictionary);

	/**
	 * 分页查询
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @return
	 */
	Page<RcDataDictionary> listForPage(int pageCurrent, int pageSize);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	RcDataDictionary queryById(Long id);
	
	/**
	 * 根据id进行删除
	 * @param id
	 */
	int deleteById(Long id);
}
