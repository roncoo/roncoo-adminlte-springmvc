package com.roncoo.adminlte.service;

import java.util.List;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryListExample;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典明细服务功能
 * 
 * @author LYQ
 */
public interface DataDictionaryListService {

	/**
	 * 分页查询
	 * 
	 * @param fieldCode
	 * @param pageCurrent
	 * @param pageSize
	 * @return
	 */
	Page<RcDataDictionaryList> listForPage(RcDataDictionaryList dList, int pageCurrent, int pageSize);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	RcDataDictionaryList queryById(Long id);

	/**
	 * 添加记录
	 * 
	 * @param dList
	 */
	void save(RcDataDictionaryList dList);

	/**
	 * 更新
	 * 
	 * @param dList
	 * @param example
	 */
	void update(RcDataDictionaryList dList, RcDataDictionaryListExample example);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	void deleteById(Long id);

	/**
	 * 删除
	 * 
	 * @param dList
	 */
	void delete(RcDataDictionaryList dList);
	
	/**
	 * 根据fieldCode查询
	 * @param fieldCode
	 * @return
	 */
	List<RcDataDictionaryList> listForFieldCode(String fieldCode);
}
