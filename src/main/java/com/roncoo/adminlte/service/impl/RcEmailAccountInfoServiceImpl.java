package com.roncoo.adminlte.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfoExample;
import com.roncoo.adminlte.service.RcEmailAccountInfoService;
import com.roncoo.adminlte.service.impl.dao.RcEmailAccountInfoDao;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * 作用功能：发件账号的服务接口实现类
 * 作者： LYQ
 * 时间：2016年10月18日
 */
@Service
public class RcEmailAccountInfoServiceImpl implements RcEmailAccountInfoService {

	@Autowired
	private RcEmailAccountInfoDao dao;
	
	@Override
	public Page<RcEmailAccountInfo> queryForpage(Page<RcEmailAccountInfo> page, RcEmailAccountInfoExample example) {
		int totalCount = dao.countByExample(example);
		int pageCount = 1;
		if(totalCount != 0){
			pageCount = totalCount/page.getPageSize();
			if(totalCount%page.getPageSize()!=0){
				pageCount++;
			}
		}
		page.setTotalCount(totalCount);
		page.setTotalPage(pageCount);
		
		List<RcEmailAccountInfo> result = dao.selectByExample(example);
		page.setList(result);
		
		return page;
	}

	@Override
	public RcEmailAccountInfo queryById(Long id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public void insert(RcEmailAccountInfo info) {
		dao.insertSelective(info);
	}

	@Override
	public void update(RcEmailAccountInfo info) {
		dao.updateByPrimaryKeySelective(info);
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteByPrimaryKey(id);
	}


}
