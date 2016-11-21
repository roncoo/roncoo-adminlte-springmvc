package com.roncoo.adminlte.controller.admin;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roncoo.adminlte.util.base.BaseController;

@Controller
@RequestMapping(value = "/admin/security/")
public class SecurityController extends BaseController {

	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list() {

	}
	
	@RequestMapping(value=UPDATE, method = RequestMethod.GET)
	public String update(String role,ModelMap modelMap){
		System.out.println(role);
		modelMap.put("role", role);
		modelMap.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, role);
		return redirect("/admin/security/list");
	}
	
	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(){
		
	}
}
