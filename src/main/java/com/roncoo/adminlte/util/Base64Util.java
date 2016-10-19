package com.roncoo.adminlte.util;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * 作用功能：base64工具
 * 作者： LYQ
 * 时间：2016年10月18日
 */
public class Base64Util {
	
	/**
	 * 
	 * 功能：加密
	 * @param key
	 * @return String
	 */
	public static String encrypt(String key){
		byte[] ec = Base64.encodeBase64(key.getBytes(), true);
		String ec_result = new String(ec).replaceAll("\r|\n", "");
		return ec_result;
	}
	
	/**
	 * 
	 * 功能：解密
	 * @param key
	 * @return String
	 */
	public static String decode(String key){
		byte[] dc = Base64.decodeBase64(key.getBytes()); 
		String dc_result = new String(dc).replaceAll("\r|\n", "");
		return dc_result;
	}
}
