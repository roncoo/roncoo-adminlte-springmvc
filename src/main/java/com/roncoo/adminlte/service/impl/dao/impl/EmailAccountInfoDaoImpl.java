package com.roncoo.adminlte.service.impl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfoExample;
import com.roncoo.adminlte.service.impl.dao.EmailAccountInfoDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcEmailAccountInfoMapper;

/**
 * 
 * 作用功能：发件账号的数据库接口实现类
 * 作者： LYQ
 * 时间：2016年10月18日
 */
@Repository
public class EmailAccountInfoDaoImpl implements EmailAccountInfoDao {
	
	@Autowired
	private RcEmailAccountInfoMapper mapper;

	@Override
	public int countByExample(RcEmailAccountInfoExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RcEmailAccountInfoExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public int insertSelective(RcEmailAccountInfo record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<RcEmailAccountInfo> selectByExample(RcEmailAccountInfoExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public RcEmailAccountInfo selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(RcEmailAccountInfo record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

}
