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

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.biz.LoginBiz;
import com.roncoo.adminlte.util.Constants;
import com.roncoo.adminlte.util.base.BaseController;

/**
 * 登录功能，集成了龙果学院的oauth登录
 * 
 * @author wujing
 */
@Controller
@RequestMapping
@EnableSpringHttpSession
public class LoginController extends BaseController {

	@Autowired
	private LoginBiz biz;

	/**
	 * 进入登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(HttpSession session) {
		Object token = session.getAttribute(Constants.Token.RONCOO);
		if (token == null) {
			return "login";
		}
		return redirect("/admin/index");
	}

	/**
	 * 登录，跳转到龙果学院授权页面
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void postLogin(HttpSession session) {

	}
	
	@RequestMapping(value = "/certification", method = RequestMethod.GET)
	public String certification(){
		Result<String> result = biz.login();
		if (result.isStatus()) {
			logger.info(result.getResultData());
			
			// 本地发布修改这里，随便增加一个session值即可，请删除下面的：return redirect(result.getResultData());
			//session.setAttribute(Constants.Token.RONCOO, "www.roncoo.com");
			return redirect(result.getResultData());
		}
		return redirect("/login");
	}

	/**
	 * 授权登录
	 */
	@RequestMapping(value = "/oauth", method = RequestMethod.GET)
	public String oauth(@RequestParam(value = "code", defaultValue = "") String code, RedirectAttributes redirectAttributes, HttpSession session) {
		Result<String> result = biz.oauth(code);
		if (result.isStatus()) {
			// 成功之后，传入session
			session.setAttribute(Constants.Token.RONCOO, result.getResultData());
		}
		
		// 重定向到登录页面，由它来判断session进行登录
		return redirect("/login");
	}

	/**
	 * 退出登陆操作
	 */
	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public String exit(RedirectAttributes redirectAttributes, HttpSession session) {
		session.removeAttribute(Constants.Token.RONCOO);
		SecurityUtils.getSubject().logout();
		redirectAttributes.addFlashAttribute("msg", "您已经安全退出");
		return redirect("/login");
	}

}
