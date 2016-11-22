package com.roncoo.adminlte.controller.admin;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roncoo.adminlte.util.base.BaseController;

@Controller
@RequestMapping(value = "/admin/security/")
public class SecurityController extends BaseController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void getLogin() {

	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String postLogin(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName,@RequestParam(FormAuthenticationFilter.DEFAULT_PASSWORD_PARAM)String passWord, Model model) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM,userName);
		model.addAttribute(FormAuthenticationFilter.DEFAULT_PASSWORD_PARAM,passWord);
		return redirect("list");
	}

	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list() {

	}

	@RequestMapping(value = "exit", method = RequestMethod.GET)
	public String exit() {
		
		return redirect("login");
	}
}
