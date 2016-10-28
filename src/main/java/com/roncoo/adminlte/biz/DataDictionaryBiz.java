package com.roncoo.adminlte.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.service.DataDictionaryListService;
import com.roncoo.adminlte.service.DataDictionaryService;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典逻辑业务类
 * 
 * @author LYQ
 */
@Component
public class DataDictionaryBiz {

	@Autowired
	private DataDictionaryService dictionaryService;

	@Autowired
	private DataDictionaryListService dictionaryListService;

	/**
	 * 分页查询
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @return
	 */
	public Page<RcDataDictionary> listForPage(int pageCurrent, int pageSize) {
		return dictionaryService.listForPage(pageCurrent, pageSize);
	}

	/**
	 * 添加
	 * 
	 * @param rcDataDictionary
	 */
	public int save(RcDataDictionary rcDataDictionary) {
		return dictionaryService.save(rcDataDictionary);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param fieldCode
	 */
	@Transactional
	public void delete(Long id, String fieldCode) {
		dictionaryListService.deleteByFieldCode(fieldCode);
		dictionaryService.deleteById(id);
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public RcDataDictionary query(Long id) {
		return dictionaryService.queryById(id);
	}

	/**
	 * 更新
	 * 
	 * @param dictionary
	 * @param oldFieldCode
	 */
	@Transactional
	public void update(RcDataDictionary dictionary, String oldFieldCode) {
		dictionaryService.update(dictionary);
		if (oldFieldCode != dictionary.getFieldCode()) {
			dictionaryListService.updateForFieldCode(oldFieldCode, dictionary.getFieldCode());
		}
	}
}
