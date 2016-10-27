package com.roncoo.adminlte.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * post请求工具
 * 
 * @author LYQ
 */
public class PostJsonUtil {
	
	private static final String APPLICATION_JSON = "application/json";
	private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
	private static final String CHARSET_UTF_8 = "UTF-8";

	/**
	 * post请求
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	public static JSONObject doPost(String url, JSONObject param) {
		try {
			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
			StringEntity entity = new StringEntity(param.toString(), CHARSET_UTF_8);
			entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, CONTENT_TYPE_TEXT_JSON));
			httpPost.setEntity(entity);
			
			HttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpPost);
			
			String result = EntityUtils.toString(httpResponse.getEntity(), CHARSET_UTF_8);
			JSONObject resultJson = JSONObject.parseObject(result);
			return resultJson;
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
