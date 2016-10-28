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

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.service.DataDictionaryService;
import com.roncoo.adminlte.service.impl.dao.DataDictionaryDao;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典接口实现类
 * 
 * @author LYQ
 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

	@Autowired
	private DataDictionaryDao dao;

	@Override
	public int save(RcDataDictionary rcDataDictionary) {
		return dao.insert(rcDataDictionary);
	}

	@Override
	public Page<RcDataDictionary> listForPage(int pageCurrent, int pageSize) {
		return dao.listForPage(pageCurrent, pageSize);
	}

	@Override
	public RcDataDictionary queryById(Long id) {
		return dao.selectById(id);
	}

	@Override
	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	@Override
	public int update(RcDataDictionary dictionary) {
		return dao.updateById(dictionary);
	}

}
