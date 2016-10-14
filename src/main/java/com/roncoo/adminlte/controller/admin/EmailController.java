package com.roncoo.adminlte.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.biz.RcEmailInfoBiz;
import com.roncoo.adminlte.util.base.Page;

/**
 * 
 * 作用功能：email功能
 * 作者： LYQ
 * 时间：2016年10月13日
 */
@Controller
@RequestMapping(value="/admin/email")
public class EmailController {
	
	@Autowired
	private RcEmailInfoBiz rcEmailInfoBiz;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(HttpSession session,Page<RcEmailInfo> page,ModelMap modelMap){
		
		String fromUser = "88888888888888";
		
		page = rcEmailInfoBiz.queryForPage(page, fromUser);
		modelMap.put("page", page);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public void add(){
		
	}
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(RcEmailInfo info){
		String fromUser = "88888888888888";
		info.setFromUser(fromUser);
		return "redirect:/admin/email/list ";
	}
}
