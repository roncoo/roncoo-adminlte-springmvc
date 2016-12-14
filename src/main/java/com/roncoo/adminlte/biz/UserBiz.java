package com.roncoo.adminlte.biz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.roncoo.adminlte.bean.Result;
import com.roncoo.adminlte.bean.entity.RcPermission;
import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.bean.entity.RcRolePermissions;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.RcUserRole;
import com.roncoo.adminlte.bean.vo.RcUserVo;
import com.roncoo.adminlte.service.PermissionService;
import com.roncoo.adminlte.service.RolePermissionsService;
import com.roncoo.adminlte.service.RoleService;
import com.roncoo.adminlte.service.UserRoleService;
import com.roncoo.adminlte.service.UserService;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.StringUtils;

/**
 * 用户逻辑业务
 * 
 * @author LYQ
 *
 */
@Component
public class UserBiz {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RolePermissionsService rolePermissionsService;

	@Autowired
	private PermissionService permissionService;

	/**
	 * 用户登录
	 * 
	 * @param userno
	 * @param password
	 * @return
	 */
	public Result<RcUser> login(String userno, String password) {
		return userService.login(userno, password);
	}

	/**
	 * 根据账号查询用户信息
	 * 
	 * @param userno
	 * @return
	 */
	public Result<RcUser> queryByUserNo(String userno) {
		return userService.queryByUserNo(userno);
	}

	// public Result<List<RcUserRole>> getUserRole(long id) {
	// return userRoleService.queryByUserId(id);
	// }
	//
	// public Result<RcRole> getRole(long id) {
	// return roleService.query(id);
	// }
	//
	// public Result<List<RcRolePermissions>> getRolePermissions(long id) {
	// return rolePermissionsService.queryByRoleId(id);
	// }
	//
	// public Result<RcPermission> getPermission(long id) {
	// return permissionService.query(id);
	// }

	@Transactional
	public Result<Integer> delete(long userId) {
		RcUserRole rcUserRole = new RcUserRole();
		rcUserRole.setUserId(userId);
		Result<Integer> result = userRoleService.deleteByUserRole(rcUserRole);
		if (result.isStatus()) {
			return userService.delete(userId);
		}
		return result;
	}

	@Transactional
	public Result<Integer> save(RcUser rcUser, List<Long> roles) {
		Result<Integer> result = userService.save(rcUser);
		if (result.isStatus()) {
			Result<RcUser> resultUser = userService.queryByUserNo(rcUser.getUserNo());
			if (resultUser.isStatus()) {
				return userRoleService.updateByUserId(resultUser.getResultData().getId(), roles);
			}
		}
		return result;
	}

	@Transactional
	public Result<Integer> update(RcUser rcUser, List<Long> roles) {
		Result<Integer> result = userService.update(rcUser);
		if (result.isStatus()) {
			return userRoleService.updateByUserId(rcUser.getId(), roles);
		}
		return result;
	}

	/**
	 * 分页查询用户信息
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @param date
	 * @param search
	 * @return
	 */
	public Result<Page<RcUserVo>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		Result<Page<RcUserVo>> resultVo = new Result<Page<RcUserVo>>();
		Result<Page<RcUser>> result = userService.listForPage(pageCurrent, pageSize, date, search);
		if (result.isStatus()) {
			RcUserVo userVo;
			ArrayList<RcUserVo> resultData = new ArrayList<RcUserVo>();
			List<RcUser> userList = result.getResultData().getList();
			// 循环获取用户的角色和权限
			for (RcUser rcUser : userList) {
				userVo = getRoleAndPermission(rcUser);
				if (userVo != null) {
					resultData.add(userVo);
				}
			}
			// 返回的实体类
			Page<RcUserVo> page = new Page<RcUserVo>(result.getResultData().getTotalCount(), result.getResultData().getTotalPage(), result.getResultData().getPageCurrent(), result.getResultData().getPageSize(), resultData);
			resultVo.setErrCode(0);
			resultVo.setStatus(true);
			resultVo.setErrMsg("查询成功");
			resultVo.setResultData(page);
			return resultVo;
		}
		return resultVo;
	}

	/**
	 * 根据id查询用户的信息
	 * 
	 * @param id
	 * @return
	 */
	public Result<RcUserVo> query(long id) {
		Result<RcUserVo> resultVo = new Result<RcUserVo>();
		Result<RcUser> result = userService.query(id);
		if (result.isStatus()) {
			RcUserVo rcUserVo = getRoleAndPermission(result.getResultData());
			if (rcUserVo != null) {
				resultVo.setErrCode(0);
				resultVo.setStatus(true);
				resultVo.setErrMsg("查询成功");
				resultVo.setResultData(rcUserVo);
				return resultVo;
			}
			resultVo.setErrMsg("查询失败");
		}
		return resultVo;

	}

	/**
	 * 获取角色列表
	 * 
	 * @return
	 */
	public Result<List<RcRole>> getRolesList() {
		return roleService.list();
	}

	/**
	 * 根据用户查询用户的角色和权限
	 * 
	 * @param rcUser
	 * @return
	 */
	public RcUserVo getRoleAndPermission(RcUser rcUser) {
		// 创建角色和权限的集合
		HashSet<String> roleSet = new HashSet<String>();
		HashSet<String> roleNameSet = new HashSet<String>();
		HashSet<String> permissionSet = new HashSet<String>();
		HashSet<String> permissionNameSet = new HashSet<String>();
		RcUserVo userVo = new RcUserVo(rcUser);
		// 获取用户的角色
		Result<List<RcUserRole>> resultUR = userRoleService.queryByUserId(rcUser.getId());
		if (resultUR.isStatus()) {
			// 获取角色的信息
			List<RcUserRole> urList = resultUR.getResultData();
			for (RcUserRole rcUserRole : urList) {
				Result<RcRole> resultR = roleService.query(rcUserRole.getRolesId());
				if (resultR.isStatus()) {
					roleSet.add(resultR.getResultData().getRoleValue());
					roleNameSet.add(resultR.getResultData().getRoleName());
					// 获取角色的权限
					Result<List<RcRolePermissions>> resultRP = rolePermissionsService.queryByRoleId(rcUserRole.getRolesId());
					if (resultRP.isStatus()) {
						// 获取权限的信息
						List<RcRolePermissions> rpList = resultRP.getResultData();
						for (RcRolePermissions rcRolePermissions : rpList) {
							Result<RcPermission> resultP = permissionService.query(rcRolePermissions.getPermissionId());
							if (resultP.isStatus()) {
								permissionSet.add(resultP.getResultData().getPermissionsValue());
								permissionNameSet.add(resultP.getResultData().getPermissionsName());
							}
						}
					}
				}
			}
			userVo.setRole(StringUtils.toString(roleSet));
			userVo.setPermission(StringUtils.toString(permissionSet));
			userVo.setRoleName(StringUtils.toString(roleNameSet));
			userVo.setPermissionName(StringUtils.toString(permissionNameSet));
			userVo.setRoles(roleSet);
			userVo.setPermissions(permissionSet);
			userVo.setRoleNames(roleNameSet);
			userVo.setPermissionNames(permissionNameSet);
			return userVo;
		}
		return userVo;
	}
}
