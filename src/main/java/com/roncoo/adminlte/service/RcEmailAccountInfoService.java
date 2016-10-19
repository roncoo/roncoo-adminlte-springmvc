package com.roncoo.adminlte.service;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfoExample;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * 作用功能：发件账号的服务接口类
 * 作者： LYQ
 * 时间：2016年10月18日
 */
public interface RcEmailAccountInfoService {
	
	Page<RcEmailAccountInfo> queryForpage(Page<RcEmailAccountInfo> page,RcEmailAccountInfoExample example);
	
	RcEmailAccountInfo queryById(Long id);
	
	void insert(RcEmailAccountInfo info);
	
	void update(RcEmailAccountInfo info);
	
	void deleteById(Long id);
}
