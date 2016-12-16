<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="security"/>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<form action="${ctx}/admin/role/update" method="post">
					<input type="hidden" id="id" name="id" value=${bean.id}>
					<div class="box-header with-border">
						<h3 class="box-title">角色修改</h3>
					</div>
					<div class="box-body">
						<div class="form-group">
							<label id="roleNameLabel">角色名</label>
							<input type="text" class="form-control" name="roleName" id="roleName" value=${bean.roleName} placeholder="角色名...">
						</div>
						<div class="form-group">
							<label id="roleValueLabel">角色值</label>
							<input type="text" class="form-control" name="roleValue" id="roleValue" value=${bean.roleValue} placeholder="角色值...">
						</div>
						<div class="form-group">
							<label>权限：</label>
							<label>
								<input type="checkbox" id="allCheckbox" class="flat-red" onClick="onClickCheckbox('allCheckbox','permission')">全选
							</label>
							<br/>
							<#list permissions as permission>
								<#if bean.permissionList??>
									<label>
					                  <input type="checkbox" name="permission" class="flat-red" value="${permission.id}"<#list bean.permissionList as beanPermission> <#if beanPermission.permissionsValue == permission.permissionsValue>checked</#if></#list>> ${permission.permissionsName}
					                </label>
								<#else>
									<label>
					                  <input type="checkbox" name="permission" class="flat-red" value="${permission.id}"> ${permission.permissionName}
					                </label>
								</#if>
							</#list>
						</div>
		             </div>
					<div class="box-footer">
						<div class="pull-right">
							<button class="btn btn-sm btn-info" onClick="history.back();">返回</button>
		               		<button id="submit" type="submit" class="btn btn-primary btn-sm">更新</button>
						</div>
	              	</div>
				</form>
			</div>
		</div>
	</div>
</div>
<@wrapper/>
<@onClickChecked/>
<@footer/>