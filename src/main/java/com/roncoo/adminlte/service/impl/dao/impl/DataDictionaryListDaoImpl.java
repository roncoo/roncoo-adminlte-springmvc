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

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryListExample;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryListExample.Criteria;
import com.roncoo.adminlte.service.impl.dao.DataDictionaryListDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcDataDictionaryListMapper;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;

/**
 * 
 * @author wujing
 */
@Repository
public class DataDictionaryListDaoImpl implements DataDictionaryListDao {

	@Autowired
	private RcDataDictionaryListMapper mapper;

	@Override
	public int deleteByFieldCode(String fieldCode) {
		RcDataDictionaryListExample example = new RcDataDictionaryListExample();
		Criteria criteria = example.createCriteria();
		criteria.andFieldCodeEqualTo(fieldCode);
		return mapper.deleteByExample(example);
	}

	@Override
	public int delete(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(RcDataDictionaryList dList) {
		Date date = new Date();
		dList.setCreateTime(date);
		dList.setUpdateTime(date);
		return mapper.insertSelective(dList);
	}

	@Override
	public Page<RcDataDictionaryList> listForPage(int pageCurrent, int pageSize, String fieldCode,String premise,String datePremise) {
		System.out.println("dao >>>>search:"+premise+"date:"+datePremise);
		RcDataDictionaryListExample example = new RcDataDictionaryListExample();
		example.setOrderByClause("sort desc");
		int totalCount = mapper.countByExample(example);
		pageSize = SqlUtil.checkPageSize(pageSize);
		pageCurrent = SqlUtil.checkPageCurrent(totalCount, pageSize, pageCurrent);
		int totalPage = SqlUtil.countTotalPage(totalCount, pageSize);
		example.setLimitStart(SqlUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);
		Criteria criteria = example.createCriteria();
		criteria.andFieldCodeEqualTo(fieldCode);
		if(StringUtils.hasText(premise)){
			criteria.andFieldKeyLike(SqlUtil.like(premise));
		}
		if(StringUtils.hasText(datePremise)){
			Date date = SqlUtil.formatTime(datePremise);
			criteria.andCreateTimeBetween(date, SqlUtil.addDay(date, 1));
		}
		List<RcDataDictionaryList> list = mapper.selectByExample(example);
		Page<RcDataDictionaryList> page = new Page<>(totalCount, totalPage, pageCurrent, pageSize, list);
		return page;
	}

	@Override
	public RcDataDictionaryList select(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(RcDataDictionaryList dList) {
		dList.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(dList);
	}

	@Override
	public List<RcDataDictionaryList> listByFieldCode(String fieldCode) {
		RcDataDictionaryListExample example = new RcDataDictionaryListExample();
		example.setOrderByClause("sort desc");
		Criteria criteria = example.createCriteria();
		criteria.andFieldCodeEqualTo(fieldCode);
		return mapper.selectByExample(example);
	}

	@Override
	public int updateByFieldCode(String fieldCodePremise, String fieldCode) {
		RcDataDictionaryList dList = new RcDataDictionaryList();
		dList.setFieldCode(fieldCode);
		RcDataDictionaryListExample example = new RcDataDictionaryListExample();
		Criteria criteria = example.createCriteria();
		criteria.andFieldCodeEqualTo(fieldCodePremise);
		return mapper.updateByExampleSelective(dList, example);
	}
}
