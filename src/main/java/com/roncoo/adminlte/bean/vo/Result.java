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
package com.roncoo.adminlte.bean.vo;

import java.io.Serializable;

/**
 * 通用实体类
 * 
 * @author wujing
 * @param <T>
 */
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 状态
	 */
	private boolean status = false;

	/**
	 * 错误码
	 */
	private int errCode = 99;

	/**
	 * 错误信息
	 */
	private String errMsg = "";

	/**
	 * 返回结果实体
	 */
	private T resultData;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}

	@Override
	public String toString() {
		return "Result [status=" + status + ", errCode=" + errCode + ", errMsg=" + errMsg + ", resultData=" + resultData + "]";
	}

}
