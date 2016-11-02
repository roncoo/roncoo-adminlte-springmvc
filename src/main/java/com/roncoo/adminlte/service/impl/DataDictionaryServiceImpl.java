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
			
		}
		if (!StringUtils.hasText(rcDataDictionary.getFieldCode())) {
			
		}
		if (StringUtils.isEmpty(rcDataDictionary.getSort())) {
			
		}
		return result;


	}

	@Override
	public Page<RcDataDictionary> listForPage(int pageCurrent, int pageSize) {
		return dao.listForPage(pageCurrent, pageSize);
	}

	@Override
	
	public Result<RcDataDictionary> queryById(Long id) {
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
	public int deleteById(Long id) {
		Long temp = (long) -1;
		Result<RcDataDictionary> result = new Result<RcDataDictionary>();
		if(id.equals(temp)){
			if(dao.deleteById(id)>0){
				result.setStatus(true);
				result.setErrCode(0);
			}else{
				result.setErrMsg("删除操作失败");
			}
		}else{
			result.setErrMsg("此操作的id："+id+"为无效id");
		}
		return 0;
	}

	@Override
	public Result<RcDataDictionary> update(RcDataDictionary rcDataDictionary) {
		Result<RcDataDictionary> result = new Result<RcDataDictionary>();
		// 校验字段
		String errMsg = "";
		// 校验字段
		if (!StringUtils.hasText(rcDataDictionary.getFieldName())) {
			errMsg += "fieldname为空;";
		}
		if (!StringUtils.hasText(rcDataDictionary.getFieldCode())) {
			errMsg += "fieldcode为空;";
		}
		if (StringUtils.isEmpty(rcDataDictionary.getSort())) {
			errMsg += "sort为空;";
		}
		if (StringUtils.hasText(errMsg)) {
			result.setErrMsg(errMsg);
		} else {
			if (dao.updateById(rcDataDictionary) > 0) {
				result.setStatus(true);
				result.setErrCode(0);
			} else {
				result.setErrMsg("数据字典更新失败");
			}
		}
		return result;
	}

}
