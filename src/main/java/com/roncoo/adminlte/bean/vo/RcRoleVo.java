package com.roncoo.adminlte.bean.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.roncoo.adminlte.bean.entity.RcPermission;
import com.roncoo.adminlte.bean.entity.RcRole;

public class RcRoleVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5657330758447750715L;

	private Long id;

	private String statusId;

	private Date createTime;

	private Date updateTime;

	private String roleName;

	private String roleValue;
	
	private List<RcPermission> permissionList;

	public RcRoleVo(RcRole rcRole) {
		this.id = rcRole.getId();
		this.statusId = rcRole.getStatusId();
		this.createTime = rcRole.getCreateTime();
		this.updateTime = rcRole.getUpdateTime();
		this.roleName = rcRole.getRoleName();
		this.roleValue = rcRole.getRoleValue();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleValue() {
		return roleValue;
	}

	public void setRoleValue(String roleValue) {
		this.roleValue = roleValue;
	}

	public List<RcPermission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<RcPermission> permissionList) {
		this.permissionList = permissionList;
	}
}