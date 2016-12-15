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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.vo.RcUserVo;
import com.roncoo.adminlte.biz.UserBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.ParamUtil;
import com.roncoo.adminlte.util.base.StringUtils;

/**
 * 用户Controller
 * 
 * @author LYQ
 *
 */
@Controller
@RequestMapping(value = "/admin/security/", method = RequestMethod.POST)
public class SecurityController extends BaseController {

	@Autowired
	private UserBiz biz;

	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list(@RequestParam(defaultValue = "1") int pageCurrent, @RequestParam(defaultValue = "10") int pageSize, HttpServletRequest request, ModelMap modelMap) {
		// 获取所有参数
		Map<String, Object> params = ParamUtil.getParamsMap(request, null);
		modelMap.put("param", params);
		// 分页查询用户信息
		Result<Page<RcUserVo>> result = biz.listForPage(pageCurrent, pageSize, (String) params.get("date"), (String) params.get("search"));
		if (result.isStatus()) {
			modelMap.put("page", result.getResultData());
		}
		// 获取角色列表
		Result<List<RcRole>> resultRole = biz.queryRoleList();
		if (resultRole.isStatus()) {
			modelMap.put("roles", resultRole.getResultData());
		}
		// 动态拼接查询条件
		String paramUrl = ParamUtil.getParamUrl(request, params, "pageCurrent");
		modelMap.put("paramUrl", paramUrl);
	}
	
	@RequestMapping(value = SAVE)
	public String save(RcUser rcUser, @RequestParam(value = "role", required = false) String role) {
		List<Long> roles = StringUtils.toLongList(role, ",");
		Result<Integer> result = biz.save(rcUser, roles);
		if (result.isStatus()) {
			return redirect("/admin/security/list");
		}
		return null;
	}

	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	public String delete(long id) {
		Result<Integer> result = biz.delete(id);
		if (result.isStatus()) {
			return redirect("/admin/security/list");
		}
		return null;
	}

	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(ModelMap modelMap, long id) {
		Result<RcUserVo> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("bean", result.getResultData());
		}
	}

	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(ModelMap modelMap, long id) {
		Result<RcUserVo> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("bean", result.getResultData());
		}
		Result<List<RcRole>> resultRole = biz.queryRoleList();
		if (resultRole.isStatus()) {
			modelMap.put("roles", resultRole.getResultData());
		}
	}

	@RequestMapping(value = UPDATE)
	public String update(RcUser rcUser, @RequestParam(value = "role", required = false) String role) {
		List<Long> roles = StringUtils.toLongList(role, ",");
		Result<Integer> result = biz.update(rcUser, roles);
		if (result.isStatus()) {
			return redirect("/admin/security/list");
		}
		return null;
	}
}
