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
package com.roncoo.adminlte.controller;

import javax.servlet.http.HttpSession;

import org.eclipse.jetty.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roncoo.adminlte.util.base.BaseController;

/**
 * 登录功能
 * 
 * @author wujing
 */
@Controller
@RequestMapping
public class LoginController extends BaseController {

	/**
	 * 进入登陆页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(HttpSession session) {
		Object token = session.getAttribute("roncooNo");
		if (token == null) {
			return "login";
		}
		return "redirect:/admin/index";
	}
	
	/**
	 * 进行授权登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin() {
		// 获取参数，进行授权跳转
		return "redirect:/admin/index";
	}

	/**
	 * 进入授权登录
	 */
	@RequestMapping(value = "/oauth", method = RequestMethod.GET)
	public String oauth(@RequestParam(value = "code", defaultValue = "") String code, RedirectAttributes redirectAttributes, HttpSession session) {
		if (StringUtil.isBlank(code)) {
			redirectAttributes.addFlashAttribute("msg", "用户名不能为空");
			return "error";
		}

		// 验证用户，获取到用户的龙果账号
		String roncooNo = "88888888888888";
		session.setAttribute("roncooNo", roncooNo);
		return "redirect:/admin/index";
	}

	/**
	 * 退出登陆操作
	 */
	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public String exit(RedirectAttributes redirectAttributes, HttpSession session) {
		session.removeAttribute("roncooNo");
		redirectAttributes.addFlashAttribute("msg", "您已经安全退出");
		return "redirect:/login";
	}

}
