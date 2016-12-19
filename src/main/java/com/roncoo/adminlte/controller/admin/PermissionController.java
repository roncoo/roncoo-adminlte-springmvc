package com.roncoo.adminlte.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcPermission;
import com.roncoo.adminlte.biz.PermissionBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.PageBean;

@Controller
@RequestMapping(value = "/admin/permission/", method = RequestMethod.POST)
public class PermissionController extends BaseController {

	@Autowired
	private PermissionBiz biz;

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
	public PageBean<RcPermission> queryForPage(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize, @RequestParam(value = "date", required = false) String date, @RequestParam(value = "search", required = false) String search) {
		Result<Page<RcPermission>> result = biz.listForPage((start / pageSize) + 1, pageSize, date, search);
		if (result.isStatus()) {
			return new PageBean<RcPermission>(result.getResultData());
		}
		return new PageBean<RcPermission>();
	}

	@RequestMapping(value = ADD, method = RequestMethod.GET)
	public void add() {

	}
	
	/**
	 * 保存
	 * 
	 * @param rcPermission
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = SAVE)
	public String save(RcPermission rcPermission) {
		Result<Integer> result = biz.save(rcPermission);
		if (result.isStatus()) {
			return redirect("/admin/permission/list");
		}
		return null;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	public String delete(long id) {
		Result<Integer> result = biz.delete(id);
		if (result.isStatus()) {
			return redirect("/admin/permission/list");
		}
		return null;
	}
	
	/**
	 * 明细查询
	 * 
	 * @param modelMap
	 * @param id
	 */
	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(ModelMap modelMap, long id) {
		Result<RcPermission> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("bean", result.getResultData());
		}
	}

	/**
	 * 编辑权限
	 * 
	 * @param modelMap
	 * @param id
	 */
	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(ModelMap modelMap, long id) {
		Result<RcPermission> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("bean", result.getResultData());
		}
	}

	/**
	 * 更新权限
	 * 
	 * @param rcPermission
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = UPDATE)
	public String update(RcPermission rcPermission) {
		Result<Integer> result = biz.update(rcPermission);
		if (result.isStatus()) {
			return redirect("/admin/permission/list");
		}
		return null;
	}
}
