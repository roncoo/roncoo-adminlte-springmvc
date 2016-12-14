package com.roncoo.adminlte.util.base;

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
}
