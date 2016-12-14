package com.roncoo.adminlte.controller.admin;

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
import com.roncoo.adminlte.biz.RoleBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.ParamUtil;

@Controller
@RequestMapping(value = "/admin/role/", method = RequestMethod.POST)
public class RoleController extends BaseController {

	@Autowired
	private RoleBiz biz;

	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list(@RequestParam(defaultValue = "1") int pageCurrent, @RequestParam(defaultValue = "10") int pageSize, HttpServletRequest request, ModelMap modelMap) {
		// 获取所有参数
		Map<String, Object> params = ParamUtil.getParamsMap(request, null);
		modelMap.put("param", params);
		// 分页查询用户信息
		Result<Page<RcRole>> result = biz.listForPage(pageCurrent, pageSize, (String) params.get("date"), (String) params.get("search"));
		if (result.isStatus()) {
			modelMap.put("page", result.getResultData());
		}
		// 动态拼接查询条件
		String paramUrl = ParamUtil.getParamUrl(request, params, "pageCurrent");
		modelMap.put("paramUrl", paramUrl);
	}

	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(long id) {

	}

	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	public void delete(long id) {

	}

	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(long id) {

	}

	@RequestMapping(value = SAVE)
	public void save(RcRole rcRole) {

	}

	@RequestMapping(value = UPDATE)
	public void update(RcRole rcRole) {

	}
}
