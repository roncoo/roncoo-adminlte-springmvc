package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfoExample;
import com.roncoo.adminlte.util.base.Page;

/**
 * 邮件账号数据交换功能
 * 
 * @author LYQ
 */
public interface EmailAccountInfoDao {

	/**
	 * 统计
	 * 
	 * @param example
	 * @return
	 */
	int count(RcEmailAccountInfoExample example);

	/**
	 * 删除
	 * 
	 * @param example
	 * @return
	 */
	int delete(RcEmailAccountInfoExample example);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(Long id);

	/**
	 * 添加
	 * 
	 * @param info
	 * @return
	 */
	int insert(RcEmailAccountInfo info);

	/**
	 * 分页查询
	 * 
	 * @param example
	 * @return
	 */
	Page<RcEmailAccountInfo> listForPage(int pageCurrent, int pageSize);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	RcEmailAccountInfo queryById(Long id);

	/**
	 * 更新
	 * 
	 * @param info
	 * @return
	 */
	int updateById(RcEmailAccountInfo info);
}
