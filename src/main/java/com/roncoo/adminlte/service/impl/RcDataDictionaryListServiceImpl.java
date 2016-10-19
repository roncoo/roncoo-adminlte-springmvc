package com.roncoo.adminlte.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryListExample;
import com.roncoo.adminlte.service.RcDataDictionaryListService;
import com.roncoo.adminlte.service.impl.dao.RcDataDictionaryListDao;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * 作用功能：数据字典明细服务接口实现类
 * 作者： LYQ
 * 时间：2016年10月18日
 */
@Service
public class RcDataDictionaryListServiceImpl implements RcDataDictionaryListService {

	@Autowired
	private RcDataDictionaryListDao dao;

	@Override
	public Page<RcDataDictionaryList> queryForPage(Page<RcDataDictionaryList> page,
			RcDataDictionaryListExample example) {
		int totalCount = dao.countByExample(example);
		int totalPage = 1;
		if (totalCount != 0) {
			totalPage = totalCount / page.getPageSize();

			if (totalCount % page.getPageSize() != 0) {
				totalPage++;
			}
		}
		page.setTotalCount(totalCount);
		page.setTotalPage(totalPage);
		
		List<RcDataDictionaryList> result = dao.selectByExample(example);
		page.setList(result);
		return page;
	}
	
	@Override
	public List<RcDataDictionaryList> queryByFieldCode(RcDataDictionaryListExample example){
		return dao.selectByExample(example);
		
	}

	@Override
	public RcDataDictionaryList queryById(Long id) {
		return dao.selectByPrimaryKey(id);
	}

	@Transactional
	@Override
	public void insert(RcDataDictionaryList dictionaryList) {
		dao.insertSelective(dictionaryList);
	}

	@Override
	public void updateByExampleSelective(RcDataDictionaryList dictionaryList, RcDataDictionaryListExample example) {
		dao.updateByExampleSelective(dictionaryList, example);
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteByPrimaryKey(id);
	}

}
