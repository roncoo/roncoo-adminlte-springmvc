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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.biz.DataDictionaryListBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典明细Controller
 * @author LYQ
 */
@Controller
@RequestMapping(value = "/admin/dataDictionaryList", method = RequestMethod.POST)
public class DataDictionaryListController extends BaseController {

	@Autowired
	private DataDictionaryListBiz biz;

	
	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list(@RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent,
			@RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
			@RequestParam(value = "id", defaultValue = "1") Long id,
			@RequestParam(value="fc") String fieldCode,
			ModelMap modelMap) {
		Page<RcDataDictionaryList> page = biz.listForPage(pageCurrent, pageSize, id);
		modelMap.put("id", id);
		modelMap.put("fieldCode", fieldCode);
		modelMap.put("page", page);

	}

	@RequestMapping(value = SAVE)
	public String save(RcDataDictionaryList dList, @RequestParam(name = "dId") Long dId) {
		biz.save(dList);
		return redirect("/admin/dataDictionaryList/list?id={0}&fc={1}", dId,dList.getFieldCode());
	}

	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	public String delete(@RequestParam(value="id") Long id,  @RequestParam(value="dId") Long dId,@RequestParam(value="fc") String fieldCode) {
		biz.deleteById(id);	
		return redirect("/admin/dataDictionaryList/list?id={0}&fc={1}", dId,fieldCode);
		
	}
}
