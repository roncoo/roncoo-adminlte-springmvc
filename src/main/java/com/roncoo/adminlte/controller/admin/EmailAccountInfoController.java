/*
 * Copyright 2015-2016 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.roncoo.adminlte.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.biz.EmailAccountInfoBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;

/**
 * 邮件账号controller
 * 
 * @author LYQ
 */
@Controller
@RequestMapping(value = "/admin/emailAccountInfo", method = RequestMethod.POST)
public class EmailAccountInfoController extends BaseController {

	private static final String FIELDCODE = "host_code";

	@Autowired
	private EmailAccountInfoBiz biz;

	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list( ModelMap modelMap,@RequestParam(defaultValue = "1") int pageCurrent, @RequestParam(defaultValue = "10") int pageSize) {
		Result<List<RcDataDictionaryList>> result = biz.listByFieldCode(FIELDCODE);
		if(result.isStatus()){
			modelMap.put("selectList", result.getResultData());
		}
		
		Result<Page<RcEmailAccountInfo>> resultPage = biz.listForPage(pageCurrent, pageSize);
		if(result.isStatus()){
			modelMap.put("page", resultPage.getResultData());
		}
	}

	@RequestMapping(value = SAVE)
	public String insert(@ModelAttribute RcEmailAccountInfo rcEmailAccountInfo) {
		biz.save(rcEmailAccountInfo);
		return redirect("/admin/emailAccountInfo/list");
	}

	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	public String delete(@RequestParam Long id) {
		Result<String> result = biz.deleteById(id);
		if(result.isStatus()){
			return redirect("/admin/emailAccountInfo/list");
		}
		return null;
	}

	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(@RequestParam Long id, ModelMap modelMap) {
		Result<RcEmailAccountInfo> result = biz.queryById(id);
		if(result.isStatus()){
			modelMap.put("info", result.getResultData());
		}
	}

	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(@RequestParam Long id, ModelMap modelMap) {
		Result<List<RcDataDictionaryList>> rcDataDictionaryListResult = biz.listByFieldCode(FIELDCODE);
		Result<RcEmailAccountInfo> result = biz.queryById(id);
		if(rcDataDictionaryListResult.isStatus()){
			modelMap.put("selectList", rcDataDictionaryListResult.getResultData());
		}
		if (result.isStatus()) {
			modelMap.put("info", result.getResultData());
		}
	}

	@RequestMapping(value = UPDATE)
	public String update(@ModelAttribute RcEmailAccountInfo rcEmailAccountInfo) {
		Result<RcEmailAccountInfo> result = biz.update(rcEmailAccountInfo);
		if(result.isStatus()){
			return redirect("/admin/emailAccountInfo/list");
		}
		return "/admin/emailAccountInfo/list";
	}
}
