<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="security"/>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<form action="${ctx}/admin/permission/update" method="post">
					<input type="hidden" id="id" name="id" value=${bean.id}>
					<div class="box-header with-border">
						<h3 class="box-title">账号修改</h3>
					</div>
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInput" id="permissionNameLabel">权限名</label>
							<input type="text" class="form-control" name="permissionsName" id="permissionsName" value=${bean.permissionsName!} placeholder="输入权限名...">
						</div>
						<div class="form-group">
							<label for="exampleInput" id="permissionValueLabel">权限值</label>
							<input type="text" class="form-control" name="permissionsValue" id="permissionsValue" value=${bean.permissionsValue!} placeholder="输入权限值...">
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