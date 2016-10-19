package com.roncoo.adminlte.service;

import java.util.List;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryListExample;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * 作用功能：数据字典明细服务接口类
 * 作者： LYQ
 * 时间：2016年10月18日
 */
public interface DataDictionaryListService {
	
	/**
	 * 
	 * 功能：分页查询
	 * @param page
	 * @param example
	 * @return Page<RcDataDictionaryList>
	 */
	Page<RcDataDictionaryList> queryForPage(Page<RcDataDictionaryList> page,RcDataDictionaryListExample example);
	
	/**
	 * 
	 * 功能：根据fieldCode查询
	 * @param example
	 * @return List<RcDataDictionaryList>
	 */
	List<RcDataDictionaryList> queryByFieldCode(RcDataDictionaryListExample example);
	
	/**
	 * 
	 * 功能：根据Id查询
	 * @param Id
	 * @return RcDataDictionaryList
	 */
	RcDataDictionaryList queryById(Long id);
	
	/**
	 * 
	 * 功能：添加记录
	 * @param dictionaryList
	 * @return void
	 */
	void insert(RcDataDictionaryList dictionaryList);
	
	/**
	 * 
	 * 功能：根据条件更新
	 * @param dictionaryList
	 * @param example
	 * @return void
	 */
	void updateByExampleSelective(RcDataDictionaryList dictionaryList,RcDataDictionaryListExample example);
	
	/**
	 * 
	 * 功能：根据id删除
	 * @param id void
	 */
	void deleteById(Long id);
}
