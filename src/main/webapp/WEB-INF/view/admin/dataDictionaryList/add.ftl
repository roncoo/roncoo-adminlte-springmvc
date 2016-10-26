<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form action="${ctx}/admin/dataDictionaryList/save" method="post">
			<input type="hidden" name="dId" value="${id}"/>
			<input type="hidden" name="fieldCode"  value="${fieldCode}"/>
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="exampleInputEmail1">关键词</label> <input type="text" class="form-control" name="fieldKey" id="fieldKey"
							placeholder="输入key..." >
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">默认值</label> <input type="text" class="form-control" name="fieldValue"
							id="fieldValue" placeholder="输入value值..." >
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">排序</label> <input type="text" class="form-control" name="sort" id="sort"
							placeholder="排序，请输入整数..." >
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">备注</label> <input type="text" class="form-control" name="remark" id="remark"
							placeholder="输入备注..." >
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
