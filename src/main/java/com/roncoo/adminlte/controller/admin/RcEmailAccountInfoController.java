package com.roncoo.adminlte.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.biz.RcDataDictionaryListBiz;
import com.roncoo.adminlte.biz.RcEmailAccountInfoBiz;
import com.roncoo.adminlte.util.base.Page;

@Controller
@RequestMapping(value = "/admin/email/account")
public class RcEmailAccountInfoController {

	@Autowired
	private RcEmailAccountInfoBiz accountInfoBiz;

	@Autowired
	private RcDataDictionaryListBiz dictionaryListBiz;

	@RequestMapping(value = "/list")
	public void list(Page<RcEmailAccountInfo> page, RcEmailAccountInfo info, ModelMap map) {
		String fieldCode = "host_code";
		
		List<RcDataDictionaryList> resultSelect = dictionaryListBiz.queryByFieldCode(fieldCode);
		map.put("selectList", resultSelect);
		
		page = accountInfoBiz.queryForPage(page, info);
		map.put("page", page);
	}
	
	@RequestMapping(value="/insert")
	public String insert(RcEmailAccountInfo info){
		accountInfoBiz.insert(info);
		return "redirect:/admin/email/account/list";
	}
}
