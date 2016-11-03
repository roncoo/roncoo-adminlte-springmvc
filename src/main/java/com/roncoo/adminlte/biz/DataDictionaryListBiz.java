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
package com.roncoo.adminlte.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.service.DataDictionaryListService;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典明细逻辑功能
 * 
 * @author LYQ
 */
@Component
public class DataDictionaryListBiz {

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
	public Result<Page<RcDataDictionaryList>> listForPage(int pageCurrent, int pageSize, String fieldCode) {
		return dictionaryListService.listForPage(pageCurrent, pageSize, fieldCode);
	}

	/**
	 * 根据id删除
	 */
	public Result<RcDataDictionaryList> delete(Long id) {
		return dictionaryListService.delete(id);
	}

	/**
	 * 添加
	 * 
	 * @param dList
	 * @param id
	 */
	public Result<RcDataDictionaryList> save(RcDataDictionaryList dList) {
		return dictionaryListService.save(dList);
	}

	/**
	 * 根据id获取
	 * 
	 * @param id
	 * @return
	 */
	public Result<RcDataDictionaryList> query(Long id) {
		return dictionaryListService.query(id);
	}

	/**
	 * 更新
	 * 
	 * @param dList
	 */
	public Result<RcDataDictionaryList> update(RcDataDictionaryList dList) {
		return dictionaryListService.update(dList);
	}

}
