/**
 * Copyright 2015-2016 广州市领课网络科技有限公司
 */
package com.roncoo.adminlte.test;

import org.eclipse.jetty.server.Server;

import com.roncoo.adminlte.test.jetty.JettyFactory;

/**
 * @author wujing
 */
public class RoncooAdminlteSpringmvcTest {
	public static final int PORT = 8080;
	public static final String CONTEXT = "/";

	public static void main(String[] args) {
		// 启动Jetty
		Server server = JettyFactory.createServerInSource(PORT, CONTEXT);
		try {
			server.start();
			// 等待用户输入回车重载应用.
			while (true) {
				char c = (char) System.in.read();
				if (c == '\n') {
					JettyFactory.reloadContext(server);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
