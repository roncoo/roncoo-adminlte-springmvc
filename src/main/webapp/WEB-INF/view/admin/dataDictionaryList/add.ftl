<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form action="${ctx}/admin/dataDictionaryList/save" method="post">
			<input type="hidden" name="dId" value="${param['dId']}"/>
			<input type="hidden" name="fieldCode"  value="${param['fieldCode']}"/>
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加信息</h4>
				</div>
				<div class="modal-body">
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
				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="close" data-dismiss="modal">
						<i class="fa fa-close"></i>关闭
					</button>
					<button id="submit"  type="submit" class="btn btn-primary">
						<i class="fa fa-save"></i>保存
					</button>
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
	 	}
		return true;
	});
	
	$("#close").on("click",function(){
		$("span").remove(".errorSpan");
 		$("br").remove(".errorBr");
	});
});
</script>