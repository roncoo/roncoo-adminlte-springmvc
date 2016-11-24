package com.roncoo.adminlte.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roncoo.adminlte.util.base.BaseController;

@Controller
@RequestMapping(value = "/admin/security/")
public class SecurityController extends BaseController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void getLogin() {

	}
	
	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list() {

	}
}
