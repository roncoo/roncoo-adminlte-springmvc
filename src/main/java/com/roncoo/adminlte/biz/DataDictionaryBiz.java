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
import org.springframework.transaction.annotation.Transactional;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.service.DataDictionaryListService;
import com.roncoo.adminlte.service.DataDictionaryService;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典逻辑业务类
 * 
 * @author LYQ
 */
@Component
public class DataDictionaryBiz {

	@Autowired
	private DataDictionaryService dictionaryService;

	@Autowired
	private DataDictionaryListService dictionaryListService;

	/**
	 * 分页查询
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @return
	 */
	public Result<Page<RcDataDictionary>> listForPage(int pageCurrent, int pageSize, String premise, String datePremise) {
		return dictionaryService.listForPage(pageCurrent, pageSize, premise, datePremise);
	}

	/**
	 * 添加
	 * 
	 * @param rcDataDictionary
	 */
	public Result<RcDataDictionary> save(RcDataDictionary rcDataDictionary) {
		return dictionaryService.save(rcDataDictionary);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param fieldCode
	 */
	@Transactional
	public Result<String> delete(Long id, String fieldCode) {
		if (dictionaryListService.deleteByFieldCode(fieldCode).isStatus()) {
			return dictionaryService.delete(id);
		}
		return null;
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Result<RcDataDictionary> query(Long id) {
		return dictionaryService.query(id);
	}

	/**
	 * 更新
	 * 
	 * @param dictionary
	 * @param oldFieldCode
	 */
	@Transactional
	public Result<RcDataDictionary> update(RcDataDictionary dictionary, String oldFieldCode) {
		Result<RcDataDictionary> result = dictionaryService.update(dictionary);
		if (result.isStatus()) {
			if (oldFieldCode != dictionary.getFieldCode()) {
				dictionaryListService.updateByFieldCode(oldFieldCode, dictionary.getFieldCode());
			}
		}
		return result;
	}
}
