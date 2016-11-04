/*
 * Copyright 2015-2016 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.roncoo.adminlte.service.impl.dao;

import java.util.List;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * @author wujing
 */
public interface DataDictionaryListDao {


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
	int delete(Long id);

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
	Page<RcDataDictionaryList> listForPage(int pageCurrent, int pageSize, String fieldCode,String premise,String datePremise);

	/**
	 * 
	 * 功能：根据id查询
	 * 
	 * @param id
	 * @return RcDataDictionaryList
	 */
	RcDataDictionaryList select(Long id);

	/**
	 * 
	 * 功能：更新
	 * 
	 * @param record
	 * @param example
	 * @return int
	 */
	int update(RcDataDictionaryList dList);
	
	/**
	 * 根据fieldCode查询
	 * @param fieldCode
	 * @return
	 */
	List<RcDataDictionaryList> listByFieldCode(String fieldCode);
	
	/**
	 * 根据fieldCode更新
	 * 
	 * @param fieldCodePremise
	 * @param fieldCode
	 * @return
	 */
	int updateByFieldCode(String fieldCodePremise,String fieldCode);
}
