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
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.util.Oauth2UrlUtil;
import com.roncoo.adminlte.util.PostJsonUtil;
import com.roncoo.adminlte.util.base.BaseController;

/**
 * 登录功能
 * 
 * @author wujing
 */
@Controller
@RequestMapping
public class LoginController extends BaseController {

	private static final String CLIENTID = Oauth2UrlUtil.readUrl("clientId").trim();
	private static final String CLIENTSECRET = Oauth2UrlUtil.readUrl("clientSecret").trim();
	private static final String RESPONSETYPE = Oauth2UrlUtil.readUrl("responseType").trim();
	private static final String GRANTTYPE = Oauth2UrlUtil.readUrl("grantType").trim();
	private static final String REDIRECTURI = Oauth2UrlUtil.readUrl("redirectUri").trim();
	private static final String BASEURL = Oauth2UrlUtil.readUrl("baseUrl").trim();
	private static final String OAUTH2URL = Oauth2UrlUtil.readUrl("oauth2Url").trim();
	private static final String GETACCESSTOKENURL = Oauth2UrlUtil.readUrl("getAccessTokenUrl").trim();
	
	private static final String STATUS_CODE = "errCode";
	private static final String RONCOONO="roncooNo";
	private static final String RESULTDATA = "resultData";

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
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void postLogin(HttpServletResponse response) throws IOException {
		String url = BASEURL + OAUTH2URL.replace("{CLIENTID}", CLIENTID).replace("{RESPONSETYPE}", RESPONSETYPE)
				.replace("{REDIRECTURI}", URLEncoder.encode(REDIRECTURI, "utf-8"));
		response.sendRedirect(url);
	}

	/**
	 * 进入授权登录
	 */
	@RequestMapping(value = "/oauth", method = RequestMethod.GET)
	public String oauth(@RequestParam(value = "code", defaultValue = "") String code,
			RedirectAttributes redirectAttributes, HttpSession session) {
		if (StringUtils.isEmpty(code)) {
			redirectAttributes.addFlashAttribute("msg", "用户名不能为空");
			return "error";
		}

		JSONObject param = new JSONObject();
		param.put("clientId", CLIENTID);
		param.put("clientSecret", CLIENTSECRET);
		param.put("code", code);
		param.put("grantType", GRANTTYPE);
		String url = BASEURL + GETACCESSTOKENURL;
		JSONObject resultJson = PostJsonUtil.doPost(url, param);
		String status = resultJson.getString(STATUS_CODE);
		if(status.equals("0")){
			JSONObject jsonObj = resultJson.getJSONObject(RESULTDATA);
			String roncooNo = jsonObj.getString(RONCOONO);
			session.setAttribute("roncooNo", roncooNo);
			return "redirect:/admin/index";
		}
		return "redirect:/login";
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
