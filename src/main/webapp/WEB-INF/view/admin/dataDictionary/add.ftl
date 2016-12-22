<div class="row">
	<div class="col-md-12">
		<form id="dataDictionaryAddForm" method="post">
			<div>
				<div class="form-group">
					<label for="exampleInput" id="fieldNameLabel">字段名</label>
					<input type="text" class="form-control" name="fieldName" id="fieldName" placeholder="输入字段名...">
				</div>
				<div class="form-group">
					<label for="exampleInput" id="fieldCodeLabel">CODE</label>
					<input type="text" class="form-control" name="fieldCode" id="fieldCode" placeholder="输入code值...">
				</div>
				<div class="form-group">
					<label for="exampleInput" id="sortLabel">排序</label>
					<input type="text" class="form-control" name="sort" id="sort" placeholder="排序，请输入整数...">
				</div>
				<div class="form-group">
					<label for="exampleInput">备注</label>
					<input type="text" class="form-control" name="remark" id="remark" placeholder="输入备注...">
				</div>
			</div>
			<div class="box-footer">
				<div class="pull-right">
                	<button type="button" class="btn btn-default btn-sm"  data-dismiss="modal"><i class="fa fa-close"></i>取消</button>
                	<button onclick="dataDictionarySave();" type="button" class="btn btn-primary btn-sm"><i class="fa fa-save"></i>保存</button>
                </div>
          </div>
		</form>
	</div>
</div>
<script type="text/javascript">
function dataDictionarySave(){
	$("span").remove(".errorClass");
	$("br").remove(".errorClass");
	var status = 1;
	if($("#fieldName").val() == ""){
		$("#fieldNameLabel").prepend('<span class="errorClass" style="color:red">*字段名不能为空</span><br class="errorClass"/>');
		status = 0;
	}
	if($("#fieldCode").val() == ""){
		$("#fieldCodeLabel").prepend('<span class="errorClass" style="color:red">*Code值不能为空</span><br class="errorClass"/>');
		status = 0;
	}
	if ($("#sort").val() == "") {
		$("#sortLabel").prepend('<span class="errorClass" style="color:red">*排序值不能为空</span><br class="errorClass"/>');
		status = 0;
	}
	if (status == 0) {
		return false;
	}else{
		$.ajax({
			cache: false,
			url: "${ctx}/admin/dataDictionary/save",
	        type: "post",
	        dataType: "text",
	        data: $("#dataDictionaryAddForm").serialize(),
	        success: function (data) {
	        	$("#lgModal").modal('hide');
	        	alertMsg("添加成功","success");
	        	reloadTable(list_ajax,"#dictionary-time","#dictionary-premise");
	        }
		});
	}
}
</script>