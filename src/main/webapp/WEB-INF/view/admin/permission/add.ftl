<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form action="${ctx}/admin/permission/save" method="post">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加权限</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="exampleInput" id="permissionNameLabel">权限名</label>
						<input type="text" class="form-control" name="permissionsName" id="permissionsName" placeholder="输入权限名...">
					</div>
					<div class="form-group">
						<label for="exampleInput" id="permissionValueLabel">权限值</label>
						<input type="text" class="form-control" name="permissionsValue" id="permissionsValue" placeholder="输入权限值...">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="close" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
					<button type="submit" class="btn btn-primary" id="submit"><i class="fa fa-save"></i>保存</button>
				</div>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		$("#submit").on("click",function(){
			var status = 1;
			$("span").remove(".errorSpan");
	 		$("br").remove(".errorBr");
	 		
			if($("#permissionsName").val()==""){
				$("#permissionNameLabel").prepend('<span class="errorSpan" style="color:red">*权限名不能为空</span><br class="errorBr"/>');
	 			status=0;
			}
			if($("#permissionsValue").val()==""){
				$("#permissionValueLabel").prepend('<span class="errorSpan" style="color:red">*权限值不能为空</span><br class="errorBr"/>');
	 			status=0;
			}
			if(status==0){
		 		return false;
		 	}
			return true;
		});
		
		$("#close").on("click",function(){
			$("span").remove(".errorSpan");
	 		$("br").remove(".errorBr");
		});
	});
</script>