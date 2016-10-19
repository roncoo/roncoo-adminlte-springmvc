package com.roncoo.adminlte.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.biz.RcDataDictionaryListBiz;
import com.roncoo.adminlte.util.base.Page;

@Controller
@RequestMapping(value = "/admin/datadictionary-list")
public class DatadictionaryListController {

	@Autowired
	private RcDataDictionaryListBiz biz;

	@RequestMapping(value = "/{id}/list")
	public String list(@PathVariable Long id, Page<RcDataDictionaryList> page, RcDataDictionaryList dictionaryList,
			ModelMap map) {
		page = biz.queryForPage(page, dictionaryList, id);
		map.put("dictionaryId", id);
		map.put("page", page);
		return "/admin/datadictionary-list/list";

	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(RcDataDictionaryList dictionaryList, Long dictionaryId) {
		biz.insert(dictionaryList, dictionaryId);
		String url = "redirect:/admin/datadictionary-list/" + dictionaryId + "/list";
		return url;
	}
	
	@RequestMapping(value = "/{id}/delete")
	public String delete(@PathVariable Long id){
		biz.deleteById(id);
		String url = "redirect:/admin/datadictionary-list/" + id + "/list";
		return url;
	}
}
