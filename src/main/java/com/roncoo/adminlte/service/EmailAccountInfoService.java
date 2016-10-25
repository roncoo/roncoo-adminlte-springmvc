package com.roncoo.adminlte.service;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.util.base.Page;

/**
 * 邮件账号服务功能
 * 
 * @author LYQ
 */
public interface EmailAccountInfoService {

	/**
	 * 分页查询
	 * 
	 * @param page
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
	 * 添加
	 * 
	 * @param info
	 */
	int save(RcEmailAccountInfo info);

	/**
	 * 更新
	 * 
	 * @param info
	 */
	int updateById(RcEmailAccountInfo info);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	int deleteById(Long id);

	/**
	 * 随机获取一条记录
	 * 
	 * @return
	 */
	RcEmailAccountInfo queryByRand();

	/**
	 * 更新
	 * 
	 * @param info
	 * @return
	 */
	int update(RcEmailAccountInfo info);
}
