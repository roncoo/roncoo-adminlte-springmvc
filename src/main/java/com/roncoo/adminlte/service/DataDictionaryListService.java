package com.roncoo.adminlte.service;

import java.util.List;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
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
	Page<RcDataDictionaryList> listForPage(int pageCurrent, int pageSize, String fieldCode);


	/**
	 * 添加记录
	 * 
	 * @param dList
	 */
	int save(RcDataDictionaryList dList);


	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	int deleteById(Long id);

	/**
	 * 删除
	 * 
	 * @param dList
	 */
	int deleteByFieldCode(String fieldCode);
	
	/**
	 * 根据fieldCode查询
	 * @param fieldCode
	 * @return
	 */
	List<RcDataDictionaryList> listByFieldCode(String fieldCode);
}
