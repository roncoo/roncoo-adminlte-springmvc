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
package com.roncoo.adminlte.service.impl.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryExample;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryExample.Criteria;
import com.roncoo.adminlte.service.impl.dao.DataDictionaryDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcDataDictionaryMapper;
import com.roncoo.adminlte.util.DateUtil;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;

/**
 * 
 * @author LYQ
 */
@Repository
public class DataDictionaryDaoImpl implements DataDictionaryDao {

	@Autowired
	private RcDataDictionaryMapper mapper;

	@Override
	public int insert(RcDataDictionary rcDataDictionary) {
		rcDataDictionary.setStatusId("1");
		rcDataDictionary.setCreateTime(new Date());
		rcDataDictionary.setUpdateTime(new Date());
		return mapper.insertSelective(rcDataDictionary);
	}

	@Override
	public Page<RcDataDictionary> listForPage(int pageCurrent, int pageSize, String premise, String datePremise) {
		RcDataDictionaryExample example = new RcDataDictionaryExample();
		example.setOrderByClause("sort asc");

		int totalCount = mapper.countByExample(example);
		pageSize = SqlUtil.checkPageSize(pageSize);
		pageCurrent = SqlUtil.checkPageCurrent(totalCount, pageSize, pageCurrent);
		int totalPage = SqlUtil.countTotalPage(totalCount, pageSize);

		example.setLimitStart(SqlUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);

		Criteria criteria = example.createCriteria();
		if (StringUtils.hasText(premise)) {
			criteria.andFieldNameLike(SqlUtil.like(premise));
		}
		if (StringUtils.hasText(datePremise)) {
			criteria.andCreateTimeBetween(DateUtil.parseDate(datePremise), DateUtil.addDate(DateUtil.parseDate(datePremise), 1));
		}

		List<RcDataDictionary> list = mapper.selectByExample(example);
		Page<RcDataDictionary> page = new Page<>(totalCount, totalPage, pageCurrent, pageSize, list);
		return page;
	}

	@Override
	public RcDataDictionary selectById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateById(RcDataDictionary dictionary) {
		dictionary.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(dictionary);
	}
}
