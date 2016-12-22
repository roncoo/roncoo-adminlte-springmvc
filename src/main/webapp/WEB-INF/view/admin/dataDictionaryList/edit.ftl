<div class="row">
	<div class="col-md-12">
		<form id="dataDictionaryList-edit-form" role="form" method="post">
			<input type="hidden" id="dId" name="dId" value=${id}>
			<input type="hidden" id="id" name="id" value=${dictionaryList.id!}>
			<input type="hidden" id="fieldCode" name="fieldCode" value=${dictionaryList.fieldCode!}>
			
			<div class="box-body">
				<div class="form-group">
					<label id="fkl">名称:</label> <input type="text" class="form-control" name="fieldKey" id="fk" value=${dictionaryList.fieldKey!} placeholder="输入显示名称...">
				</div>
				<div class="form-group">
					<label id="fvl">默认值:</label> <input type="text" class="form-control" name="fieldValue" id="fv" value=${dictionaryList.fieldValue!} placeholder="输入默认值...">
				</div>
				<div class="form-group">
					<label id="stl">排序:</label> <input type="text" class="form-control" name="sort" id="st" value=${dictionaryList.sort} placeholder="排序值...">
				</div>
				<div class="form-group">
					<label>备注:</label> <input type="text" class="form-control" name="remark" id="remark" value="${dictionaryList.remark}" placeholder="输入备注...">
				</div>
	         </div>
	      	<div class="box-footer">
	      		<div class="pull-right">
	        		<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
	        		<button onclick="dataDictionaryListUpdate();" type="button" class="btn btn-primary btn-sm"><i class="fa fa-paste"></i>更新</button>
				</div>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">
function dataDictionaryListUpdate(){
	var status = 1;
	$("span").remove(".errorClass");
 	$("br").remove(".errorClass");
	if($("#fk").val()==""){
 		$("#fkl").prepend('<span class="errorClass" style="color:red">*Key不能为空</span><br class="errorClass"/>');
 		status=0;
 	}
 	if($("#fv").val()==""){
 		$("#fvl").prepend('<span class="errorClass"  style="color:red">*默认值不能为空</span><br class="errorClass"/>');
 		status=0;
 	}
 	if($("#st").val()==""){
 		$("#stl").prepend('<span class="errorClass"  style="color:red">*排序值不能为空</span><br  class="errorClass"/>');
 		status=0;
 	}
 	if(status==0){
 		return false;
 	}else{
 		$.ajax({
 			url: '${ctx}/admin/dataDictionaryList/update',
	        type: 'post',
	        dataType: 'text',
	        data: $("#dataDictionaryList-edit-form").serialize(),
	        success: function (data) {
	        	$("#lgModal").modal('hide');
	        	alertMsg("更新成功","success");
	        	reloadTable(list_ajax,"#dictionaryList-time","#dictionaryList-premise");
	        }
 		});
 	}
}

</script>