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

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.biz.DataDictionaryBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.ParamUtil;

/**
 * 数据字典Controller
 * 
 * @author LYQ
 */
@Controller
@RequestMapping(value = "/admin/dataDictionary/", method = RequestMethod.POST)
public class DataDictionaryController extends BaseController {

	@Autowired
	private DataDictionaryBiz biz;

	/**
	 * 分页查看
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @param modelMap
	 */
	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list(@RequestParam(defaultValue = "1") int pageCurrent, @RequestParam(defaultValue = "10") int pageSize, ModelMap modelMap, HttpServletRequest request) {
		Map<String, Object> params = ParamUtil.getParamsMap(request, null);
		modelMap.put("param", params);

		Result<Page<RcDataDictionary>> result = biz.listForPage(pageCurrent, pageSize, (String) params.get("date"), (String) params.get("search"));
		if (result.isStatus()) {
			modelMap.put("page", result.getResultData());
		}

		String paramUrl = ParamUtil.getParamUrl(request, params, "pageCurrent");
		modelMap.put("paramUrl", paramUrl);
	}

	/**
	 * 保存
	 * 
	 * @param rcDataDictionary
	 * @return
	 */
	@RequestMapping(value = SAVE)
	public String save(@ModelAttribute RcDataDictionary rcDataDictionary) {
		Result<RcDataDictionary> result = biz.save(rcDataDictionary);
		if (result.isStatus()) {
			return redirect("/admin/dataDictionary/list");
		}
		return "/admin/dataDictionary/list";
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
		Result<String> result = biz.delete(id, fieldCode);
		if (result.isStatus()) {
			return redirect("/admin/dataDictionary/list");
		}
		return null;
	}

	/**
	 * 查看
	 * 
	 * @param id
	 * @param modelMap
	 */
	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(Long id, ModelMap modelMap) {
		Result<RcDataDictionary> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("dictionary", result.getResultData());
		}
	}

	/**
	 * 修改
	 * 
	 * @param id
	 * @param modelMap
	 */
	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(Long id, ModelMap modelMap) {
		Result<RcDataDictionary> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("dictionary", result.getResultData());
		}
	}

	/**
	 * 更新
	 * 
	 * @param rcDataDictionary
	 * @param oldFieldCode
	 * @return
	 */
	@RequestMapping(value = UPDATE)
	public String update(@ModelAttribute RcDataDictionary rcDataDictionary, @RequestParam(value = "oldFieldCode") String oldFieldCode) {
		Result<RcDataDictionary> result = biz.update(rcDataDictionary, oldFieldCode);
		if (result.isStatus()) {
			return redirect("/admin/dataDictionary/list");
		}
		return "/admin/dataDictionary/list";

	}
}
