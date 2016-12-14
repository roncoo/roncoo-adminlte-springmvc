<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form action="${ctx}/admin/role/save" method="post">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label id="roleNameLabel">角色</label>
						<input type="text" class="form-control" name="roleName" id="roleName" placeholder="输入角色...">
					</div>
					<div class="form-group">
						<label id="roleValueLabel">角色值</label>
						<input type="text" class="form-control" name="roleValue" id="roleValue" placeholder="输入角色值...">
					</div>
					<div class="form-group">
						<label>角色：</label>
						<#list permissions as permission>
							<label>
			                  <input type="checkbox" name="permission" class="flat-red" value="${permission.id}"> ${permission.permissionsName}
			                </label>
						</#list>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<i class="fa fa-close"></i>关闭
					</button>
					<button type="submit" class="btn btn-primary" id="submit">
						<i class="fa fa-save"></i>保存
					</button>
				</div>
			</div>
		</form>
	</div>
</div>