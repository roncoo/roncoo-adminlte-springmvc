package com.roncoo.adminlte.service.impl.dao;

import java.util.List;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryExample;

public interface RcDataDictionaryDao {

	/**
	 * 
	 * 功能：统计数据字典记录
	 * @param example
	 * @return int
	 */
	int countByExample(RcDataDictionaryExample example);

	/**
	 * 
	 * 功能：根据id删除数据字典记录
	 * @param id
	 * @return int
	 */
	int deleteByPrimaryKey(Long id);
	
	/**
	 * 
	 * 功能：添加数据字典信息
	 * @param record
	 * @return int
	 */
	int insertSelective(RcDataDictionary record);

	/**
	 * 
	 * 功能：按条件查询数据字典记录
	 * @param example
	 * @return List<RcDataDictionary>
	 */
	List<RcDataDictionary> selectByExample(RcDataDictionaryExample example);
}
