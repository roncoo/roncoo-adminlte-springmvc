package com.roncoo.adminlte.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.biz.RcDataDictionaryBiz;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * 作用功能：数据字典操作类
 * 作者： LYQ
 * 时间：2016年10月17日
 */
@Controller
@RequestMapping(value="/admin/datadictionary")
public class DataDictionaryController {
	
	@Autowired
	private RcDataDictionaryBiz biz;
	
	/**
	 * 
	 * 功能：查看数据字典列表
	 * @param page
	 * @param rcDataDictionary
	 * @param map void
	 */
	@RequestMapping(value="/list")
	public void list(Page<RcDataDictionary> page,RcDataDictionary rcDataDictionary,ModelMap map){
		page = biz.queryForPage(page, rcDataDictionary);
		map.put("page", page);
	}
	
	/**
	 * 
	 * 功能：往数据字典中插入记录
	 * @param dictionary
	 * @return String
	 */
	@RequestMapping(value="/insert")
	public String insert(RcDataDictionary dictionary){
		biz.insert(dictionary);
		return "redirect:/admin/datadictionary/list";
		
	}
}
