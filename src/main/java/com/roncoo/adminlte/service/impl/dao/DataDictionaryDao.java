package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典数据交换功能
 * 
 * @author LYQ
 */
public interface DataDictionaryDao {

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
	 * 根据id删除
	 * @param id
	 */
	void deleteById(Long id);
}
