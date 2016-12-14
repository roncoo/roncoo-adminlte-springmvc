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
import com.roncoo.adminlte.bean.entity.RcPermission;
import com.roncoo.adminlte.biz.PermissionBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.ParamUtil;

@Controller
@RequestMapping(value = "/admin/permission/", method = RequestMethod.POST)
public class PermissionController extends BaseController {

	@Autowired
	private PermissionBiz biz;

	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list(@RequestParam(defaultValue = "1") int pageCurrent, @RequestParam(defaultValue = "10") int pageSize, HttpServletRequest request, ModelMap modelMap) {
		// 获取所有参数
		Map<String, Object> params = ParamUtil.getParamsMap(request, null);
		modelMap.put("param", params);
		// 分页查询用户信息
		Result<Page<RcPermission>> result = biz.listForPage(pageCurrent, pageSize, (String) params.get("date"), (String) params.get("search"));
		if (result.isStatus()) {
			modelMap.put("page", result.getResultData());
		}
		// 动态拼接查询条件
		String paramUrl = ParamUtil.getParamUrl(request, params, "pageCurrent");
		modelMap.put("paramUrl", paramUrl);
	}

	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(ModelMap modelMap, long id) {
		Result<RcPermission> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("bean", result.getResultData());
		}
	}

	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	public String delete(long id) {
		Result<Integer> result = biz.delete(id);
		if(result.isStatus()){
			return redirect("/admin/permission/list");
		}
		return null;
	}

	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(ModelMap modelMap, long id) {
		Result<RcPermission> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("bean", result.getResultData());
		}
	}

	@RequestMapping(value = SAVE)
	public String save(RcPermission rcPermission) {
		Result<Integer> result = biz.save(rcPermission);
		if (result.isStatus()) {
			return redirect("/admin/permission/list");
		}
		return null;
	}

	@RequestMapping(value = UPDATE)
	public String update(RcPermission rcPermission) {
		Result<Integer> result = biz.update(rcPermission);
		if(result.isStatus()){
			return redirect("/admin/permission/list");
		}
		return null;
	}
}
