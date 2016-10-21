<!-- 拟态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form action="${ctx}/admin/emailAccountInfo/save" method="post">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加账号信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Host</label> 
						<select name="host" class="form-control select2" style="width: 100%;">
						<#list selectList as select>
							<option value="${select.fieldKey}">${select.fieldValue}</option>
						</#list>
						</select>
					</div>
					<div class="form-group">
						<label>邮箱账号</label> <input type="text" class="form-control" name="fromUser" id="fromUser" placeholder="输入邮箱...">
					</div>
					<div class="form-group">
						<label>授权码</label> <input type="text" class="form-control" name="passwd" id="passwd" placeholder="授权码...">
					</div>
					<div class="form-group">
						<label>备注</label> <input type="text" class="form-control" name="remark" id="remark" placeholder="输入备注...">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">保存</button>
				</div>
			</div>
		</form>
	</div>
</div>