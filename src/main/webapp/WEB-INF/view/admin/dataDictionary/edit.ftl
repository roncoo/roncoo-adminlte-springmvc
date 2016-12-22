<div class="row">
	<div class="col-md-12">
		<form id="dataDictionaryEditForm"  method="post">
			<input type="hidden" id="oldFieldCode" name="oldFieldCode" value=${dictionary.fieldCode}/>
			<input type="hidden" id="id" name="id" value=${dictionary.id}/>
			<div>
				<div class="form-group">
					<label id="fnl">字段名:</label>
					<input type="text" class="form-control" name="fieldName" id="fn" value=${dictionary.fieldName!} placeholder="输入字段名称...">
				</div>
				<div class="form-group">
					<label id="fcl">Code值:</label>
					<input type="text" class="form-control" name="fieldCode" id="fc" value=${dictionary.fieldCode!} placeholder="输入Code值...">
				</div>
				<div class="form-group">
					<label id="stl">排序:</label>
					<input type="text" class="form-control" name="sort" id="st" value=${dictionary.sort} placeholder="排序值...">
				</div>
				<div class="form-group">
					<label>备注:</label>
					<input type="text" class="form-control" name="remark" id="remark" value="${dictionary.remark}" placeholder="输入备注...">
				</div>
             </div>
          	<div class="box-footer">
          		<div class="pull-right">
                	<button type="button" class="btn btn-default btn-sm"  data-dismiss="modal"><i class="fa fa-close"></i>取消</button>
                	<button onclick="dataDictionaryUpdate();" type="button" class="btn btn-primary btn-sm"><i class="fa fa-paste"></i>更新</button>
                </div>
      		</div>
		</form>
	</div>
</div>

<script type="text/javascript">
function dataDictionaryUpdate(){
	var status = 1;
	$("span").remove(".errorClass");
 	$("br").remove(".errorClass");
	if($("#fn").val()==""){
 		$("#fnl").prepend('<span class="errorClass" style="color:red">*字段名不能为空</span><br class="errorClass"/>');
 		status=0;
 	}
 	if($("#fc").val()==""){
 		$("#fcl").prepend('<span class="errorClass" style="color:red">*Code值不能为空</span><br class="errorClass"/>');
 		status=0;
 	}
 	if($("#st").val()==""){
 		$("#stl").prepend('<span class="errorClass" style="color:red">*排序值不能为空</span><br class="errorClass"/>');
 		status=0;
 	}
 	if(status==0){
 		return false;
 	}else{
 		$.ajax({
 			url: '${ctx}/admin/dataDictionary/update',
	        type: 'post',
	        dataType: 'text',
	        data: $("#dataDictionaryEditForm").serialize(),
	        success: function (data) {
	        	$("#lgModal").modal('hide');
	        	alertMsg("更新成功","success");
	        	reloadTable(list_ajax,"#dictionary-time","#dictionary-premise");
	        }
 		});
 	}
}		
</script>