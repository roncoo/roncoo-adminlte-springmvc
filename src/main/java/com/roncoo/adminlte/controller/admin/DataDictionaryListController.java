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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.biz.DataDictionaryListBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.PageBean;

/**
 * 数据字典明细Controller
 * 
 * @author LYQ
 */
@Controller
@RequestMapping(value = "/admin/dataDictionaryList", method = RequestMethod.POST)
public class DataDictionaryListController extends BaseController {

	@Autowired
	private DataDictionaryListBiz biz;

	/**
	 * 查询列表
	 * 
	 * @param id
	 * @param fieldCode
	 * @param modelMap
	 */
	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list(@RequestParam(value = "id", defaultValue = "-1") Long id, @RequestParam(value = "fieldCode") String fieldCode, ModelMap modelMap) {
		modelMap.put("id", id);
		modelMap.put("fieldCode", fieldCode);
	}

	/**
	 * 分页查询
	 * 
	 * @param start
	 * @param pageSize
	 * @param fieldCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = PAGE)
	public PageBean<RcDataDictionaryList> queryForList(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize, @RequestParam(value = "fieldCode") String fieldCode,@RequestParam(value="date",required=false)String  date,@RequestParam(value="search",required=false)String search) {
		int pageCurrent = (start / pageSize) + 1;
		Result<Page<RcDataDictionaryList>> result = biz.listForPage(pageCurrent, pageSize, fieldCode,search,date);
		return new PageBean<RcDataDictionaryList>(result.getResultData());
	}

	/**
	 * 添加
	 * 
	 * @param id
	 * @param fieldCode
	 * @param modelMap
	 */
	@RequestMapping(value = ADD, method = RequestMethod.GET)
	public void add(@RequestParam(value = "id", defaultValue = "-1") Long id, @RequestParam(value = "fieldCode") String fieldCode, ModelMap modelMap) {
		modelMap.put("id", id);
		modelMap.put("fieldCode", fieldCode);
	}

	/**
	 * 保存
	 * 
	 * @param dList
	 * @param bindingResult
	 * @param dId
	 * @return
	 */
	@RequestMapping(value = SAVE)
	public String save(@ModelAttribute("dListVo") RcDataDictionaryList dList, BindingResult bindingResult, @RequestParam(name = "dId") Long dId) {
		if (!bindingResult.hasErrors()) {
			biz.save(dList);
		}
		return redirect("/admin/dataDictionaryList/list?id={0}&fieldCode={1}", dId, dList.getFieldCode());
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param dId
	 * @param fieldCode
	 * @return
	 */
	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id") Long id, @RequestParam(value = "dId") Long dId, @RequestParam(value = "fieldCode") String fieldCode) {
		biz.delete(id);
		return redirect("/admin/dataDictionaryList/list?id={0}&fieldCode={1}", dId, fieldCode);
	}

	/**
	 * 查看
	 * 
	 * @param id
	 * @param modelMap
	 */
	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(@RequestParam(value = "id", required = false) Long id, ModelMap modelMap) {
		Result<RcDataDictionaryList> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("dictionaryList", result.getResultData());
		}
	}

	/**
	 * 编辑
	 * 
	 * @param id
	 * @param dId
	 * @param modelMap
	 */
	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(@RequestParam(value = "id", defaultValue = "-1") Long id, @RequestParam(value = "dId") Long dId, ModelMap modelMap) {
		Result<RcDataDictionaryList> result = biz.query(id);
		modelMap.put("id", dId);
		if (result.isStatus()) {
			modelMap.put("dictionaryList", result.getResultData());
		}
	}

	/**
	 * 更新
	 * 
	 * @param dList
	 * @param dId
	 * @return
	 */
	@RequestMapping(value = UPDATE)
	public String update(@ModelAttribute RcDataDictionaryList dList, @RequestParam(value = "dId") Long dId) {
		biz.update(dList);
		return redirect("/admin/dataDictionaryList/list?id={0}&fieldCode={1}", dId, dList.getFieldCode());
	}
}
