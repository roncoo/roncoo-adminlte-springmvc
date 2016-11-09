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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.service.DataDictionaryListService;
import com.roncoo.adminlte.service.impl.dao.DataDictionaryListDao;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典明细服务接口实现类
 * 
 * @author wujing
 */
@Service
public class DataDictionaryListServiceImpl implements DataDictionaryListService {

	@Autowired
	private DataDictionaryListDao dao;

	@Override
	public Result<Page<RcDataDictionaryList>> listForPage(int pageCurrent, int pageSize, String fieldCode, String premise, String datePremise) {
		Result<Page<RcDataDictionaryList>> result = new Result<>();
		if (pageCurrent < 1) {
			result.setErrMsg("参数pageCurrent有误,pageCurrent=" + pageCurrent);
			return result;
		}
		if (pageSize < 1) {
			result.setErrMsg("参数pageSize有误,pageSize=" + pageSize);
			return result;
		}
		if (!StringUtils.hasText(fieldCode)) {
			result.setErrMsg("fieldCode不能为空");
			return result;
		}
		Page<RcDataDictionaryList> resultData = dao.listForPage(pageCurrent, pageSize, fieldCode, premise, datePremise);
		result.setResultData(resultData);
		result.setStatus(true);
		result.setErrCode(0);
		return result;
	}

	@Override
	public Result<RcDataDictionaryList> save(RcDataDictionaryList dList) {
		Result<RcDataDictionaryList> result = new Result<>();
		if (!StringUtils.hasText(dList.getFieldKey())) {
			result.setErrMsg("fieldkey值不能为空");
			return result;
		}
		if (!StringUtils.hasText(dList.getFieldValue())) {
			result.setErrMsg("fieldvalue值不能为空");
			return result;
		}
		if ((dList.getSort()) < 0) {
			result.setErrMsg("sort值不能为空");
			return result;
		}
		if (dao.insert(dList) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
			result.setResultData(dList);
		}
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
			result.setResultData("成功");
		}
		return result;
	}

	@Override
	public Result<String> deleteByFieldCode(String fieldCode) {
		Result<String> result = new Result<>();
		if (!StringUtils.hasText(fieldCode)) {
			result.setErrMsg("fieldCode不能为空");
			return result;
		}
		if (dao.deleteByFieldCode(fieldCode) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
		}
		return result;
	}

	@Override
	public Result<List<RcDataDictionaryList>> listByFieldCode(String fieldCode) {
		Result<List<RcDataDictionaryList>> result = new Result<>();
		if (!StringUtils.hasText(fieldCode)) {
			result.setErrMsg("fieldCode");
		}
		List<RcDataDictionaryList> resultList = dao.listByFieldCode(fieldCode);
		result.setResultData(resultList);
		result.setStatus(true);
		result.setErrCode(0);
		return result;
	}

	@Override
	public Result<RcDataDictionaryList> query(Long id) {
		Result<RcDataDictionaryList> result = new Result<>();
		if (id < 1) {
			result.setErrMsg("此操作的id：" + id + "为无效id");
			return result;
		}
		RcDataDictionaryList dList = dao.selectById(id);
		result.setResultData(dList);
		result.setStatus(true);
		result.setErrCode(0);
		return result;
	}

	@Override
	public Result<RcDataDictionaryList> update(RcDataDictionaryList dList) {
		Result<RcDataDictionaryList> result = new Result<>();
		if (!StringUtils.hasText(dList.getFieldKey())) {
			result.setErrMsg("fieldkey值不能为空");
			return result;
		}
		if (!StringUtils.hasText(dList.getFieldValue())) {
			result.setErrMsg("fieldvalue值不能为空");
			return result;
		}
		if ((dList.getSort()) < 0) {
			result.setErrMsg("sort值不能为空");
			return result;
		}
		if (dao.updateById(dList) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
		}
		return result;
	}

	@Override
	public Result<String> updateByFieldCode(String fieldCodePremise, String fieldCode) {
		Result<String> result = new Result<String>();
		if (!StringUtils.hasText(fieldCodePremise)) {
			result.setErrMsg("fieldCodePremise不能为空");
			return result;
		}
		if (!StringUtils.hasText(fieldCode)) {
			result.setErrMsg("fieldCode不能为空");
			return result;
		}
		if (dao.updateByFieldCode(fieldCodePremise, fieldCode) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
		}
		return result;
	}
}
