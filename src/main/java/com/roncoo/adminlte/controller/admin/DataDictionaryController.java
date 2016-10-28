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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.biz.DataDictionaryBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;

/**
 * 数据字典
 * 
 * @author LYQ
 */
@Controller
@RequestMapping(value = "/admin/dataDictionary", method = RequestMethod.POST)
public class DataDictionaryController extends BaseController {

	@Autowired
	private DataDictionaryBiz biz;

	/**
	 * 查看数据字典列表
	 */
	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list(@RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent, @RequestParam(value = "pageSize", defaultValue = "20") int pageSize, ModelMap modelMap) {
		Page<RcDataDictionary> page = biz.listForPage(pageCurrent, pageSize);
		modelMap.put("page", page);
	}

	/**
	 * 
	 * 往数据字典中插入记录
	 * 
	 * @param dictionary
	 * @return String
	 */
	@RequestMapping(value = SAVE)
	public String save(@ModelAttribute RcDataDictionary rcDataDictionary) {
		biz.save(rcDataDictionary);
		return redirect("/admin/dataDictionary/list");
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param fieldCode
	 * @return
	 */
	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", defaultValue = "0") Long id, @RequestParam(value = "fieldCode", defaultValue = "") String fieldCode) {
		biz.delete(id, fieldCode);
		return redirect("/admin/dataDictionary/list");
	}

	/**
	 * 查看详细信息
	 * 
	 * @param id
	 * @param modelMap
	 */
	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(Long id, ModelMap modelMap) {
		RcDataDictionary dictionary = biz.query(id);
		modelMap.put("dictionary", dictionary);
	}

	/**
	 * 修改
	 * 
	 * @param id
	 * @param modelMap
	 */
	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(Long id, ModelMap modelMap) {
		RcDataDictionary dictionary = biz.query(id);
		modelMap.put("dictionary", dictionary);
	}

	@RequestMapping(value = UPDATE)
	public String update(@ModelAttribute RcDataDictionary dictionary, @RequestParam(value = "oldFieldCode") String oldFieldCode) {
		biz.update(dictionary, oldFieldCode);
		return redirect("/admin/dataDictionary/list");

	}
}
