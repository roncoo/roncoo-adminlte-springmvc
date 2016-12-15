package com.roncoo.adminlte.bean.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.bean.entity.RcUser;

/**
 * 用户实体拓展类
 * 
 * @author LYQ
 *
 */
public class RcUserVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1439710637271708310L;

	private Long id;

	private String statusId;

	private Date createTime;

	private Date updateTime;

	private String userNo;

	private String password;

	private String nickName;

	private Integer sex;

	private String permission;
	
	private List<RcRole> roleList;
	
	public RcUserVo(RcUser rcUser){
		this.id = rcUser.getId();
		this.statusId = rcUser.getStatusId();
		this.createTime = rcUser.getCreateTime();
		this.updateTime = rcUser.getUpdateTime();
		this.userNo = rcUser.getUserNo();
		this.password = rcUser.getPassword();
		this.nickName = rcUser.getNickName();
		this.sex = rcUser.getSex();
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

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public List<RcRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RcRole> roleList) {
		this.roleList = roleList;
	}
}