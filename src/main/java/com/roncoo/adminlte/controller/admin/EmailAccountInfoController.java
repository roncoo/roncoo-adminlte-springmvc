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
import org.springframework.web.bind.annotation.ResponseBody;

import com.roncoo.adminlte.bean.entity.RcDataDictionaryList;
import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.biz.EmailAccountInfoBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.PageBean;

/**
 * 邮件账号controller
 * 
 * @author LYQ
 */
@Controller
@RequestMapping(value = "/admin/emailAccountInfo/", method = RequestMethod.POST)
public class EmailAccountInfoController extends BaseController {

	private static final String FIELDCODE = "host_code";

	@Autowired
	private EmailAccountInfoBiz biz;

	/**
	 * 列表
	 */
	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list() {
	}

	/**
	 * 分页查询
	 * 
	 * @param start
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = PAGE)
	public PageBean<RcEmailAccountInfo> queryForPage(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize,@RequestParam(value="date",required=false)String  date,@RequestParam(value="search",required=false)String search) {
		int pageCurrent = (start / pageSize) + 1;
		Result<Page<RcEmailAccountInfo>> result = biz.listForPage(pageCurrent, pageSize,search,date);
		return new PageBean<>(result.getResultData());
	}

	/**
	 * 添加
	 * 
	 * @param modelMap
	 */
	@RequestMapping(value = ADD, method = RequestMethod.GET)
	public void add(ModelMap modelMap) {
		Result<List<RcDataDictionaryList>> result = biz.listByFieldCode(FIELDCODE);
		if (result.isStatus()) {
			modelMap.put("selectList", result.getResultData());
		}
	}

	/**
	 * 保存
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = SAVE)
	public String save(RcEmailAccountInfo info) {
		Result<RcEmailAccountInfo> result = biz.save(info);
		if (result.isStatus()) {
			return "/admin/emailAccountInfo/list";
		}
		return null;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	public String delete(@RequestParam Long id) {
		Result<RcEmailAccountInfo> result = biz.delete(id);
		if (result.isStatus()) {
			return redirect("/admin/emailAccountInfo/list");
		}
		return "admin/emailAccountInfo/list";
	}

	/**
	 * 查看
	 * 
	 * @param id
	 * @param modelMap
	 */
	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(@RequestParam Long id, ModelMap modelMap) {
		Result<RcEmailAccountInfo> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("info", result.getResultData());
		}
	}

	/**
	 * 编辑
	 * 
	 * @param id
	 * @param modelMap
	 */
	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(@RequestParam Long id, ModelMap modelMap) {
		Result<List<RcDataDictionaryList>> dictionaryListResult = biz.listByFieldCode(FIELDCODE);
		Result<RcEmailAccountInfo> emailAccountResult = biz.query(id);
		if (dictionaryListResult.isStatus()) {
			modelMap.put("selectList", dictionaryListResult.getResultData());
		}
		if (emailAccountResult.isStatus()) {
			modelMap.put("info", emailAccountResult.getResultData());
		}
	}

	/**
	 * 更新
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = UPDATE)
	public String update(@ModelAttribute RcEmailAccountInfo info) {
		Result<RcEmailAccountInfo> result = biz.update(info);
		if (result.isStatus()) {
			return redirect("/admin/emailAccountInfo/list");
		}
		return "admin/emailAccountInfo/list";
	}
}
