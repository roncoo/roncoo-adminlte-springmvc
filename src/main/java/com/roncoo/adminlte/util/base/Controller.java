package com.roncoo.adminlte.util.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controller {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static final String TEXT_UTF8 = "text/html;charset=UTF-8";
	public static final String JSON_UTF8 = "application/json;charset=UTF-8";
	public static final String XML_UTF8 = "application/xml;charset=UTF-8";

	public static final String ADD = "add";
	public static final String SAVE = "save";
	public static final String EDIT = "edit";
	public static final String VIEW = "view";
	public static final String GET = "get";
	public static final String LIST = "list";
	public static final String LISTALL = "listAll";
	public static final String INSERT = "insert";
	public static final String DELETE = "delete";
	public static final String UPDATE = "update";
	public static final String SELETE = "selete";
	public static final String BATCHUPDATE = "batchUpdate";
	public static final String UPDATESTATUS = "updateStatus";
	public static final String BATCHENABLE = "batchEnable";
	public static final String BATCHDISABLE = "batchDisable";

}
