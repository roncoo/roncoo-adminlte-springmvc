<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="security"/>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">角色详情</h3>
					<div class="pull-right">
						<button class="btn btn-sm btn-info" onClick="history.back();">
							<i class="fa fa-reply"></i>返回
						</button>
					</div>
				</div>
				<div class="box-body  no-padding">
					<table class="table table-striped">
		                <tr>
		                	<td>角色：</td>
		                	<td style="width: 90%">${bean.roleName}</td>
		                </tr>
		                <tr>
		                	<td>角色值：</td>
		                	<td>${bean.roleValue}</td>
		                </tr>
		                <tr>
		                	<td>拥有权限：</td>
		                	<td>
		                		<#list bean.permissionList as permission>
		                			${permission_index+1}.${permission.permissionsName}
		                		</#list>
		                	</td>
		                </tr>
		                <tr>
		                	<td>创建时间：</td>
		                	<td>${bean.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
		                </tr>
		                <tr>
		                	<td>更新时间：</td>
		                	<td>${bean.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
		                </tr>
		         	</table>
	             </div>
			</div>
		</div>
	</div>
</div>
<@wrapper/>
<@footer/>