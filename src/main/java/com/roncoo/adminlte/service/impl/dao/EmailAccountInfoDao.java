package com.roncoo.adminlte.service.impl.dao;

import java.util.List;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfoExample;


/**
 * 
 * 作用功能：发件账号的数据库接口类
 * 作者： LYQ
 * 时间：2016年10月18日
 */
public interface EmailAccountInfoDao {
	
	int countByExample(RcEmailAccountInfoExample example);

    int deleteByExample(RcEmailAccountInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(RcEmailAccountInfo record);

    List<RcEmailAccountInfo> selectByExample(RcEmailAccountInfoExample example);

    RcEmailAccountInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RcEmailAccountInfo record);
}
