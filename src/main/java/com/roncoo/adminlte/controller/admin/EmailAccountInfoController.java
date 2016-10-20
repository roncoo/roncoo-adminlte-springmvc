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

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.biz.DataDictionaryListBiz;
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

	@Autowired
	private DataDictionaryListBiz dBiz;

	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list(@RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent,
			@RequestParam(value = "pageSize", defaultValue = "20") int pageSize, ModelMap modelMap) {
		List<RcDataDictionaryList> select = dBiz.listForFieldCode(FIELDCODE);
		Page<RcEmailAccountInfo> page = biz.listForPage(pageCurrent, pageSize);

		modelMap.put("selectList", select);
		modelMap.put("page", page);
	}

	@RequestMapping(value = SAVE)
	public String insert(@ModelAttribute RcEmailAccountInfo info) {
		biz.save(info);
		return "redirect:/admin/emailAccountInfo/list";
	}

	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	public String delete(@RequestParam Long id) {
		biz.deleteById(id);
		return "redirect:/admin/emailAccountInfo/list";
	}
}
