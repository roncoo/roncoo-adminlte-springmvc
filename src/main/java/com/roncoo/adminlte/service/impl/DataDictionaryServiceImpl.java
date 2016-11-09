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
package com.roncoo.adminlte.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.service.DataDictionaryService;
import com.roncoo.adminlte.service.impl.dao.DataDictionaryDao;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典
 * 
 * @author LYQ
 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

	@Autowired
	private DataDictionaryDao dao;

	@Override
	public Result<RcDataDictionary> save(RcDataDictionary rcDataDictionary) {
		Result<RcDataDictionary> result = new Result<RcDataDictionary>();
		// 校验字段
		if (!StringUtils.hasText(rcDataDictionary.getFieldName())) {
			result.setErrMsg("fieldname不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcDataDictionary.getFieldCode())) {
			result.setErrMsg("fieldcode不能为空");
			return result;
		}
		if (StringUtils.isEmpty(rcDataDictionary.getSort())) {
			result.setErrMsg("sort不能为空");
			return result;
		}
		if(dao.insert(rcDataDictionary)>0){
			result.setStatus(true);
			result.setErrCode(0);
		}
		return result;

	}

	@Override
	public Result<Page<RcDataDictionary>> listForPage(int pageCurrent, int pageSize,String premise,String datePremise) {
		Result<Page<RcDataDictionary>> result = new Result<Page<RcDataDictionary>>();
		if (pageCurrent < 1) {
			result.setErrMsg("参数pageCurrent有误,pageCurrent=" + pageCurrent);
			return result;
		}
		if (pageSize < 1) {
			result.setErrMsg("参数pageSize有误,pageSize=" + pageSize);
			return result;
		}
		Page<RcDataDictionary> resultData = dao.listForPage(pageCurrent, pageSize,premise,datePremise);
		result.setResultData(resultData);
		result.setStatus(true);
		result.setErrCode(0);
		return result;
	}

	@Override
	public Result<RcDataDictionary> query(Long id) {
		Result<RcDataDictionary> result = new Result<RcDataDictionary>();
		if (id < 1) {
			result.setErrMsg("此操作的id：" + id + "为无效id");
			return result;
		}
		RcDataDictionary resultData = dao.selectById(id);
		result.setStatus(true);
		result.setErrCode(0);
		result.setResultData(resultData);
		return result;
	}

	@Override
	public Result<String> delete(Long id) {
		Result<String> result = new Result<String>();
		if (id < 1) {
			result.setErrMsg("此操作的id：" + id + "为无效id");
			return result;
		}
		if (dao.deleteById(id) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
		}
		return result;
	}

	@Override
	public Result<RcDataDictionary> update(RcDataDictionary rcDataDictionary) {
		Result<RcDataDictionary> result = new Result<RcDataDictionary>();
		if (!StringUtils.hasText(rcDataDictionary.getFieldName())) {
			result.setErrMsg("fieldname不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcDataDictionary.getFieldCode())) {
			result.setErrMsg("fieldcode不能为空");
			return result;
		}
		if (StringUtils.isEmpty(rcDataDictionary.getSort())) {
			result.setErrMsg("sort不能为空");
			return result;
		}
		if (dao.updateById(rcDataDictionary) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
		}
		return result;
	}
}
