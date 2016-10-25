package com.roncoo.adminlte.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.service.DataDictionaryListService;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典明细逻辑功能
 * 
 * @author LYQ
 */
@Component
public class DataDictionaryListBiz {

	@Autowired
	private DataDictionaryListService dictionaryListService;

	/**
	 * 分页查询
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @param id
	 * @return
	 */
	public Page<RcDataDictionaryList> listForPage(int pageCurrent, int pageSize, String fieldCode) {
		return dictionaryListService.listForPage(pageCurrent, pageSize, fieldCode);
	}

	/**
	 * 根据id删除
	 */
	public void deleteById(Long id) {
		dictionaryListService.deleteById(id);
	}

	/**
	 * 添加
	 * 
	 * @param dList
	 * @param id
	 */
	public void save(RcDataDictionaryList dList) {
		dictionaryListService.save(dList);
	}

	/**
	 * 根据id获取
	 * 
	 * @param id
	 * @return
	 */
	public RcDataDictionaryList queryById(Long id) {
		return dictionaryListService.queryById(id);
	}

	/**
	 * 更新
	 * 
	 * @param dList
	 */
	public void update(RcDataDictionaryList dList) {
		dictionaryListService.update(dList);
	}

}
