package com.roncoo.adminlte.service.impl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryListExample;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * 作用功能：数据字典操作明细接口类 作者： LYQ 时间：2016年10月17日
 */
public interface DataDictionaryListDao {

	/**
	 * 
	 * 功能：统计
	 * 
	 * @param example
	 * @return int
	 */
	int countByExample(RcDataDictionaryListExample example);

	/**
	 * 
	 * 功能：根据条件删除
	 * 
	 * @param example
	 * @return int
	 */
	int deleteByFieldCode(String FieldCode);

	/**
	 * 
	 * 功能：根据id删除
	 * 
	 * 
	 * @param id
	 * @return int
	 */
	int deleteById(Long id);

	/**
	 * 
	 * 功能：添加
	 * 
	 * @param record
	 * @return int
	 */
	int insert(RcDataDictionaryList dList);

	
	/**
	 * 分页查询
	 * @param dList
	 * @param pageCurrent
	 * @param pageSize
	 * @return
	 */
	Page<RcDataDictionaryList> listForPage(int pageCurrent, int pageSize, String fieldCode);

	/**
	 * 
	 * 功能：根据id查询
	 * 
	 * @param id
	 * @return RcDataDictionaryList
	 */
	RcDataDictionaryList selectById(Long id);

	/**
	 * 
	 * 功能：更新
	 * 
	 * @param record
	 * @param example
	 * @return int
	 */
	int update(@Param("record") RcDataDictionaryList record,
			@Param("example") RcDataDictionaryListExample example);
	
	/**
	 * 根据fieldCode查询
	 * @param fieldCode
	 * @return
	 */
	List<RcDataDictionaryList> listByFieldCode(String fieldCode);

}
