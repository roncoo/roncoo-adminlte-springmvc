<div class="row">
	<div class="col-md-12">
			<div class="box box-primary">
				<form id="dataDictionary-edit-form"  method="post">
					<input type="hidden" id="oldFieldCode" name="oldFieldCode" value=${dictionary.fieldCode}>
					<input type="hidden" id="id" name="id" value=${dictionary.id}>
					<div class="box-header with-border">
						<h3 class="box-title">数据字典修改</h3>
					</div>
					<div class="box-body">
						<div class="form-group">
							<label id="fnl">字段名:</label> <input type="text" class="form-control" name="fieldName" id="fn" value=${dictionary.fieldName!} placeholder="输入字段名称...">
						</div>
						<div class="form-group">
							<label id="fcl">Code值:</label> <input type="text" class="form-control" name="fieldCode" id="fc" value=${dictionary.fieldCode!} placeholder="输入Code值...">
						</div>
						<div class="form-group">
							<label id="stl">排序:</label> <input type="text" class="form-control" name="sort" id="st" value=${dictionary.sort} placeholder="排序值...">
						</div>
						<div class="form-group">
							<label>备注:</label> <input type="text" class="form-control" name="remark" id="remark" value="${dictionary.remark}" placeholder="输入备注...">
						</div>
		             </div>
	              	<div class="box-footer">
		                <button type="button" class="btn btn-default"  data-dismiss="modal">取消</button>
		                <button id="dataDictionary_submit" type="submit" class="btn btn-info pull-right">更新</button>
              		</div>
				</form>
			</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$("#dataDictionary_submit").click(function(){
		var status = 1;
		$("span").remove(".errorSpan");
	 	$("br").remove(".errorBr");
		if($("#fn").val()==""){
	 		$("#fnl").prepend('<span class="errorSpan" style="color:red">*字段名不能为空</span><br class="errorBr"/>');
	 		status=0;
	 	}
	 	if($("#fc").val()==""){
	 		$("#fcl").prepend('<span class="errorSpan" style="color:red">*Code值不能为空</span><br class="errorBr"/>');
	 		status=0;
	 	}
	 	if($("#st").val()==""){
	 		$("#stl").prepend('<span class="errorSpan" style="color:red">*排序值不能为空</span><br class="errorBr"/>');
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
	        url: '${ctx}/admin/dataDictionary/update',
	        type: 'post',
	        dataType: 'text',
	        data: $("#dataDictionary-edit-form").serialize(),
	        success: function (data) {
	        	reloadTable(dataDictionary_tab);
	        }
   		};
    $.ajax(options);
	}
});
</script>
