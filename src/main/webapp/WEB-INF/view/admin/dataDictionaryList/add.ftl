<div class="row">
	<div class="col-md-12">
		<form id="dataDictionaryListAddForm" role="form" method="post">
			<input type="hidden" id="dId" name="dId" value=${id}>
			<input type="hidden" id="fieldCode" name="fieldCode" value=${fieldCode!}>
			<div>
				<div class="form-group">
					<label for="exampleInput" id="fieldKeyLabel">关键词</label>
					<input type="text" class="form-control" name="fieldKey" id="fieldKey" placeholder="输入key..." >
				</div>
				<div class="form-group">
					<label for="exampleInput1" id="fieldValueLabel">默认值</label>
					<input type="text" class="form-control" name="fieldValue" id="fieldValue" placeholder="输入value值..." >
				</div>
				<div class="form-group">
					<label for="exampleInput" id="sortLabel">排序</label>
					<input type="text" class="form-control" name="sort" id="sort" placeholder="排序，请输入整数..." >
				</div>
				<div class="form-group">
					<label for="exampleInput" >备注</label>
					<input type="text" class="form-control" name="remark" id="remark" placeholder="输入备注..." >
				</div>
             </div>
         	<div class="box-footer">
         		<div class="pull-right">
               		<button type="button" class="btn btn-default btn-sm"  data-dismiss="modal"><i class="fa fa-close"></i>取消</button>
               		<button onclick="dataDictionaryListSave();" type="button" class="btn btn-primary btn-sm"><i class="fa fa-save"></i>添加</button>
               	</div>
     		</div>
		</form>
	</div>
</div>

<script type="text/javascript">
function dataDictionaryListSave(){
	var status = 1;
	$("span").remove(".errorClass");
 	$("br").remove(".errorClass");
	if($("#fieldKey").val()==""){
 		$("#fieldKeyLabel").prepend('<span class="errorClass" style="color:red">*Key不能为空</span><br class="errorClass"/>');
 		status=0;
 	}
 	if($("#fieldValue").val()==""){
 		$("#fieldValueLabel").prepend('<span class="errorClass"  style="color:red">*默认值不能为空</span><br class="errorClass"/>');
 		status=0;
 	}
 	if($("#sort").val()==""){
 		$("#sortLabel").prepend('<span class="errorClass"  style="color:red">*排序值不能为空</span><br  class="errorClass"/>');
 		status=0;
 	}
 	if(status==0){
 		return false;
 	}else{
 		$.ajax({
 			url: '${ctx}/admin/dataDictionaryList/save',
	        type: 'post',
	        dataType: 'text',
	        data: $("#dataDictionaryListAddForm").serialize(),
	        success: function (data) {
	        	$("#lgModal").modal('hide');
	        	alertMsg("添加成功","success");
	        	reloadTable(list_ajax,"#dictionaryList-time","#dictionaryList-premise");
	        }
 		});
 	}
}
</script>