package com.roncoo.adminlte.util.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 字符工具类
 * 
 * @author LYQ
 *
 */
public final class StringUtils {

	@SuppressWarnings("rawtypes")
	public final static String toString(Set set) {
		StringBuffer sbf = new StringBuffer();
		for (Object object : set) {
			sbf.append(object).append("、");
		}
		sbf.deleteCharAt(sbf.length() - 1);
		return sbf.toString();
	}

	/**
	 * string 转换成Long数组
	 * 
	 * @param str
	 * @param splitStr
	 * @return
	 */
	public final static List<Long> toLongList(String str, String splitStr) {
		if (str != null) {
			ArrayList<Long> longList = new ArrayList<Long>();
			String[] strList = str.split(splitStr);
			for (String string : strList) {
				longList.add(Long.parseLong(string));
			}
			return longList;
		}
		return null;
	}
}
