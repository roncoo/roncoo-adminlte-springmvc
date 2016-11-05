<div class="row">
	<div class="col-md-12">
		<div class="box box-primary">
			<form id="dataDictionaryList-add-form" role="form" method="post">
				<input type="hidden" id="dId" name="dId" value=${id}>
				<input type="hidden" id="fieldCode" name="fieldCode" value=${fieldCode!}>
				<div class="box-header with-border">
					<h3 class="box-title">数据字典明细添加</h3>
				</div>
				<div class="box-body">
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
	               	<button type="button" class="btn btn-default"  data-dismiss="modal">取消</button>
	               	<button id="dataDictionaryList_add" type="button" class="btn btn-info pull-right" data-dismiss="modal">添加</button>
         		</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
$(function(){
	$("#dataDictionaryList_add").click(function(){
		var status = 1;
		$("span").remove(".errorSpan");
	 	$("br").remove(".errorBr");
		if($("#fieldKey").val()==""){
	 		$("#fieldKeyLabel").prepend('<span class="errorSpan" style="color:red">*Key不能为空</span><br class="errorBr"/>');
	 		status=0;
	 	}
	 	if($("#fieldValue").val()==""){
	 		$("#fieldValueLabel").prepend('<span class="errorSpan"  style="color:red">*默认值不能为空</span><br class="errorBr"/>');
	 		status=0;
	 	}
	 	if($("#sort").val()==""){
	 		$("#sortLabel").prepend('<span class="errorSpan"  style="color:red">*排序值不能为空</span><br  class="errorBr"/>');
	 		status=0;
	 	}
	 	if(status==0){
	 		return false;
	 	}else{
	 		ajaxPost();
	 	}
	});
	
	function ajaxPost() {
		var options = {
	        url: '${ctx}/admin/dataDictionaryList/save',
	        type: 'post',
	        dataType: 'text',
	        data: $("#dataDictionaryList-add-form").serialize(),
	        success: function (data) {
	        	reloadTable(list_ajax,"#dictionaryList-time","#dictionaryList-premise");
	        }
   		};
    $.ajax(options);
	}
});
</script>
