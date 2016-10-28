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

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.service.DataDictionaryListService;
import com.roncoo.adminlte.service.impl.dao.DataDictionaryListDao;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * 作用功能：数据字典明细服务接口实现类 作者： LYQ 时间：2016年10月18日
 */
@Service
public class DataDictionaryListServiceImpl implements DataDictionaryListService {

	@Autowired
	private DataDictionaryListDao dao;

	@Override
	public Page<RcDataDictionaryList> listForPage(int pageCurrent, int pageSize, String fieldCode) {
		return dao.listForPage(pageCurrent, pageSize, fieldCode);
	}

	@Override
	public int save(RcDataDictionaryList dList) {
		return dao.insert(dList);
	}

	@Override
	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	@Override
	public int deleteByFieldCode(String fieldCode) {
		return dao.deleteByFieldCode(fieldCode);
	}

	@Override
	public List<RcDataDictionaryList> listByFieldCode(String fieldCode) {
		return dao.listByFieldCode(fieldCode);
	}

	@Override
	public RcDataDictionaryList queryById(Long id) {
		return dao.selectById(id);
	}

	@Override
	public int update(RcDataDictionaryList dList) {
		return dao.updateById(dList);
	}

	@Override
	public int updateForFieldCode(String fieldCodePremise, String fieldCode) {
		return dao.updateByFieldCode(fieldCodePremise, fieldCode);
	}


}
