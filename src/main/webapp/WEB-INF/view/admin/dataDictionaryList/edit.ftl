<div class="row">
	<div class="col-md-12">
			<div class="box box-primary">
			<input type="text" class="form-control" id="search">
				<form id="dataDictionaryList-edit-form" role="form" method="post">
					<input type="hidden" id="dId" name="dId" value=${id}>
					<input type="hidden" id="id" name="id" value=${dictionaryList.id!}>
					<input type="hidden" id="fieldCode" name="fieldCode" value=${dictionaryList.fieldCode!}>
					<div class="box-header with-border">
						<h3 class="box-title">数据字典明细修改</h3>
					</div>
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
	                	<button type="button" class="btn btn-default"  data-dismiss="modal">取消</button>
	                	<button id="dataDictionaryList_submit" type="button" class="btn btn-info pull-right" data-dismiss="modal">更新</button>
           			</div>
				</form>
			</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$("#dataDictionaryList_submit").click(function(){
		var status = 1;
		$("span").remove(".errorSpan");
	 	$("br").remove(".errorBr");
		if($("#fk").val()==""){
	 		$("#fkl").prepend('<span class="errorSpan" style="color:red">*Key不能为空</span><br class="errorBr"/>');
	 		status=0;
	 	}
	 	if($("#fv").val()==""){
	 		$("#fvl").prepend('<span class="errorSpan"  style="color:red">*默认值不能为空</span><br class="errorBr"/>');
	 		status=0;
	 	}
	 	if($("#st").val()==""){
	 		$("#stl").prepend('<span class="errorSpan"  style="color:red">*排序值不能为空</span><br  class="errorBr"/>');
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
	        url: '${ctx}/admin/dataDictionaryList/update',
	        type: 'post',
	        dataType: 'text',
	        data: $("#dataDictionaryList-edit-form").serialize(),
	        success: function (data) {
	        	reloadTable(dataDictionaryList_tab);
	        }
   		};
    $.ajax(options);
	}
});
</script>
