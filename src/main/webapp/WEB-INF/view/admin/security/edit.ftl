<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="email"/>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<form action="${ctx}/admin/security/update" method="post">
					<input type="hidden" id="id" name="id" value=${bean.id}>
					<div class="box-header with-border">
						<h3 class="box-title">账号修改</h3>
					</div>
					<div class="box-body">
						<div class="form-group">
							<label id="userNoLabel">账号</label>
							<input type="text" class="form-control" name="userNo" id="userNo" value=${bean.userNo!} disabled placeholder="输入账号...">
						</div>
						<div class="form-group">
							<label id="nickNameLabel">昵称</label>
							<input type="text" class="form-control" name="nickName" id="nickName" value=${bean.nickName!} placeholder="输入昵称...">
						</div>
						<div class="form-group">
							<label>性别</label> 
							<select name="sex" class="form-control select2" style="width: 100%;">
								<option <#if bean.sex == 0>selected="selected"</#if> value="0">女</option>
								<option <#if bean.sex == 1>selected="selected"</#if> value="1">男</option>
							</select>
						</div>
						<div class="form-group">
							<label>角色：</label>
							<#list roles as role>
								<#if bean.roles??>
									<label>
					                  <input type="checkbox" name="role" class="flat-red" value="${role.id}"<#list bean.roles as beanRole> <#if beanRole == role.roleValue>checked</#if></#list>> ${role.roleName}
					                </label>
								<#else>
									<label>
					                  <input type="checkbox" name="role" class="flat-red" value="${role.id}"> ${role.roleName}
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
<@footer/>
