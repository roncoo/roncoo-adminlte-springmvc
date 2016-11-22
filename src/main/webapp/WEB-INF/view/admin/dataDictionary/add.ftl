<div class="row">
	<div class="col-md-12">
		<div class="box box-primary">
			<form id="dataDictionary-add-form" method="post">
				<div class="box-header with-border">
					<h3 class="box-title">数据字典添加</h3>
				</div>
				<div class="box-body">
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
	                <button type="button" class="btn btn-default"  data-dismiss="modal">取消</button>
	                <button id="dataDictionary_add" type="button"  data-dismiss="modal" class="btn btn-info pull-right">添加</button>
              </div>
			</form>
		</div>
	</div>
</div>


<script type="text/javascript">
$(function(){
	$("#dataDictionary_add").click(function(){
		var status = 1;
		$("span").remove(".errorSpan");
		$("br").remove(".errorBr");
		if ($("#fieldName").val() == "") {
			$("#fieldNameLabel").prepend('<span class="errorSpan" style="color:red">*字段名不能为空</span><br class="errorBr"/>');
			status = 0;
		}
		if ($("#fieldCode").val() == "") {
			$("#fieldCodeLabel").prepend('<span class="errorSpan" style="color:red">*Code值不能为空</span><br class="errorBr"/>');
			status = 0;
		}
		if ($("#sort").val() == "") {
			$("#sortLabel").prepend('<span class="errorSpan" style="color:red">*排序值不能为空</span><br class="errorBr"/>');
			status = 0;
		}
		if (status == 0) {
			return false;
		}
		ajaxPost();
	});

	function ajaxPost() {
		var options = {
	        url: '${ctx}/admin/dataDictionary/save',
	        type: 'post',
	        dataType: 'text',
	        data: $("#dataDictionary-add-form").serialize(),
	        success: function (data) {
	        	alertMsg("添加成功","success");
	        	reloadTable(list_ajax,"#dictionary-time","#dictionary-premise");
	        }
   		};
    $.ajax(options);
	}
});
</script>