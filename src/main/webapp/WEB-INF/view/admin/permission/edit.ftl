<div class="row">
	<div class="col-md-12">
		<div class="box box-primary">
			<form id="permissionEditForm">
				<input type="hidden" id="id" name="id" value=${bean.id}>
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
						<button type="button" class="btn btn-default btn-sm" id="close" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
	               		<button id="permissionSubmit" type="button" class="btn btn-info pull-right btn-sm" data-dismiss="modal"><i class="fa fa-paste"></i>更新</button>
					</div>
              	</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$("#permissionSubmit").click(function(){
		$("span").remove(".errorClass");
		$("br").remove(".errorClass");
		var status = 1;
		if($("#permissionsName").val()==""){
			$("#permissionNameLabel").prepend('<span class="errorClass" style="color:red">*权限名不能为空</span><br class="errorClass"/>');
			status = 0;
		}
		if($("#permissionsValue").val()==""){
			$("#permissionValueLabel").prepend('<span class="errorClass" style="color:red">*权限名不能为空</span><br class="errorClass"/>');
			status = 0;
		}
		if(status == 0){
			return false;
		}else{
			ajaxPost();
		}
	});
	
	function ajaxPost() {
		var options = {
	        url: '${ctx}/admin/permission/update',
	        type: 'post',
	        dataType: 'text',
	        data: $("#permissionEditForm").serialize(),
	        success: function (data) {
	        	alertMsg("添加成功","success");
	        	reloadTable(list_ajax,"#permissionTime","#permissionPremise");
	        }
   		};
    $.ajax(options);
	}
});
</script>