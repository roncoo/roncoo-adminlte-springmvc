package com.roncoo.adminlte.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcPermission;
import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.bean.vo.RcRoleVo;
import com.roncoo.adminlte.biz.RoleBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.PageBean;
import com.roncoo.adminlte.util.base.ParamUtil;

@Controller
@RequestMapping(value = "/admin/role/", method = RequestMethod.POST)
public class RoleController extends BaseController {

	@Autowired
	private RoleBiz biz;

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
	public PageBean<RcRole> queryForPage(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize, @RequestParam(value = "date", required = false) String date, @RequestParam(value = "search", required = false) String search) {
		Result<Page<RcRole>> result = biz.listForPage((start / pageSize) + 1, pageSize, date, search);
		if (result.isStatus()) {
			return new PageBean<RcRole>(result.getResultData());
		}
		return new PageBean<RcRole>();
	}

	@RequestMapping(value = ADD, method = RequestMethod.GET)
	public void add(ModelMap modelMap) {
		Result<List<RcPermission>> resultPermission = biz.queryPermissionList();
		if (resultPermission.isStatus()) {
			modelMap.put("permissions", resultPermission.getResultData());
		}
	}

	@RequestMapping(value = SAVE)
	public String save(RcRole rcRole, String permission) {
		List<Long> permissions = ParamUtil.toLongList(permission, ",");
		Result<Integer> result = biz.save(rcRole, permissions);
		if (result.isStatus()) {
			return redirect("/admin/role/list");
		}
		return null;
	}

	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(ModelMap modelMap, long id) {
		Result<RcRoleVo> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("bean", result.getResultData());
		}
	}

	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(ModelMap modelMap, long id) {
		Result<RcRoleVo> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("bean", result.getResultData());
		}

		Result<List<RcPermission>> resultPermission = biz.queryPermissionList();
		if (resultPermission.isStatus()) {
			modelMap.put("permissions", resultPermission.getResultData());
		}
	}

	@ResponseBody
	@RequestMapping(value = UPDATE)
	public String update(RcRole rcRole, String permission) {
		List<Long> permissions = ParamUtil.toLongList(permission, ",");
		Result<Integer> result = biz.update(rcRole, permissions);
		if (result.isStatus()) {
			return redirect("/admin/role/list");
		}
		return null;
	}
}
