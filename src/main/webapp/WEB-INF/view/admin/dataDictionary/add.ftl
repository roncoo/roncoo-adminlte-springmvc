<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form action="${ctx}/admin/dataDictionary/save" method="post">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="exampleInput" id="fieldNameLabel">字段名</label> <input type="text" class="form-control" name="fieldName"
							id="fieldName" placeholder="输入字段名...">
					</div>
					<div class="form-group">
						<label for="exampleInput" id="fieldCodeLabel">CODE</label> <input type="text" class="form-control" name="fieldCode"
							id="fieldCode" placeholder="输入code值...">
					</div>
					<div class="form-group">
						<label for="exampleInput" id="sortLabel">排序</label> <input type="text" class="form-control" name="sort" id="sort"
							placeholder="排序，请输入整数...">
					</div>
					<div class="form-group">
						<label for="exampleInput">备注</label> <input type="text" class="form-control" name="remark" id="remark"
							placeholder="输入备注...">
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
$(document).ready(function(){
	 $("#submit").click(function() {
	 	var status = 1;
	 	$("span").remove(".errorSpan");
	 	$("br").remove(".errorBr");
	 	if($("#fieldName").val()==""){
	 		$("#fieldNameLabel").prepend('<span class="errorSpan" style="color:red">*字段名不能为空</span><br class="errorBr"/>');
	 		status=0;
	 	}
	 	if($("#fieldCode").val()==""){
	 		$("#fieldCodeLabel").prepend('<span class="errorSpan" style="color:red">*Code值不能为空</span><br class="errorBr"/>');
	 		status=0;
	 	}
	 	if($("#sort").val()==""){
	 		$("#sortLabel").prepend('<span class="errorSpan" style="color:red">*排序值不能为空</span><br class="errorBr"/>');
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