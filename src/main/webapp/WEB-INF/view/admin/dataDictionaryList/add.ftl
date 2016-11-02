<div class="row">
	<div class="col-md-12">
		<div class="box box-primary">
			<form action="${ctx}/admin/dataDictionaryList/save" method="post">
				<input type="hidden" name="dId" value="${id}" />
				<input type="hidden" name="fieldCode" value="${fieldCode}" />
				<div class="box-header with-border">
					<h3 class="box-title">数据字典明细添加</h3>
				</div>
				<div class="box-body">
					<div class="form-group">

						<label for="exampleInput" id="fieldKeyLabel">关键词</label>
						<input type="text" class="form-control" name="fieldKey" id="fieldKey" placeholder="输入key...">
					</div>
					<div class="form-group">
						<label for="exampleInput1" id="fieldValueLabel">默认值</label>
						<input type="text" class="form-control" name="fieldValue" id="fieldValue" placeholder="输入value值...">
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
	                <button id="dataDictionaryList_add" type="submit" class="btn btn-info pull-right">添加</button>
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
		if ($("#fieldKey").val() == "") {
			$("#fieldKeyLabel").prepend('<span class="errorSpan" style="color:red">*Key不能为空</span><br class="errorBr"/>');
			status = 0;
		}
		if ($("#fieldValue").val() == "") {
			$("#fieldValueLabel").prepend('<span class="errorSpan"  style="color:red">*默认值不能为空</span><br class="errorBr"/>');
			status = 0;
		}
		if ($("#sort").val() == "") {
			$("#sortLabel").prepend('<span class="errorSpan"  style="color:red">*排序值不能为空</span><br  class="errorBr"/>');
			status = 0;
		}
		if (status == 0) {
			return false;
		}
		return true;
	});
});
</script>
