package com.roncoo.adminlte.service.impl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryListExample;

/**
 * 
 * 作用功能：数据字典操作明细接口类 作者： LYQ 时间：2016年10月17日
 */
public interface RcDataDictionaryListDao {

	/**
	 * 
	 * 功能：统计
	 * @param example
	 * @return int
	 */
	int countByExample(RcDataDictionaryListExample example);

	/**
	 * 
	 * 功能：根据条件删除
	 * @param example
	 * @return int
	 */
	int deleteByExample(RcDataDictionaryListExample example);

	/**
	 * 
	 * 功能：根据id删除
	 * @param id
	 * @return int
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 
	 * 功能：添加
	 * @param record
	 * @return int
	 */
	int insertSelective(RcDataDictionaryList record);

	/**
	 * 
	 * 功能：根据条件查询
	 * @param example
	 * @return List<RcDataDictionaryList>
	 */
	List<RcDataDictionaryList> selectByExample(RcDataDictionaryListExample example);

	/**
	 * 
	 * 功能：根据id查询
	 * @param id
	 * @return RcDataDictionaryList
	 */
	RcDataDictionaryList selectByPrimaryKey(Long id);

	/**
	 * 
	 * 功能：更新
	 * @param record
	 * @param example
	 * @return int
	 */
	int updateByExampleSelective(@Param("record") RcDataDictionaryList record,
			@Param("example") RcDataDictionaryListExample example);

}
