<!-- 拟态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form action="${ctx}/admin/security/save" method="post">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label id="userNoLabel">账号</label> <input type="text" class="form-control" name="userNo" id="userNo" placeholder="输入账号...">
					</div>
					<div class="form-group">
						<label id="passwordLabel">密码</label> <input type="password" class="form-control" name="password" id="password" placeholder="输入密码...">
					</div>
					<div class="form-group">
						<label id="nickNameLabel">昵称</label> <input type="text" class="form-control" name="nickName" id="nickName" placeholder="输入昵称...">
					</div>
					<div class="form-group">
						<label>性别</label> 
						<select name="sex" class="form-control select2" style="width: 100%;">
							<option value="1">男</option>
							<option value="0">女</option>
						</select>
					</div>
					<div class="form-group">
						<label>角色：</label>
						<#list roles as role>
							<label>
			                  <input type="checkbox" name="role" class="flat-red" value="${role.id}"> ${role.roleName}
			                </label>
						</#list>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
					<button type="submit" class="btn btn-primary" id="submit"><i class="fa fa-save"></i>保存</button>
				</div>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">

</script>