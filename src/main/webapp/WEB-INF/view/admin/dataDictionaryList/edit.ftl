<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="dictionary"/>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<form action="${ctx}/admin/dataDictionaryList/update" method="post">
					<input type="hidden" id="dId" name="dId" value=${dId}>
					<input type="hidden" id="id" name="id" value=${dictionaryList.id!}>
					<input type="hidden" id="fieldCode" name="fieldCode" value=${dictionaryList.fieldCode!}>
					<div class="box-header with-border">
						<h3 class="box-title">数据字典明细修改</h3>
					</div>
					<div class="box-body">
						<div class="form-group">
							<label id="fieldKeyLabel">名称:</label>
							<input type="text" class="form-control" name="fieldKey" id="fieldKey" value=${dictionaryList.fieldKey!} placeholder="输入显示名称...">
						</div>
						<div class="form-group">
							<label id="fieldValueLabel">默认值:</label>
							<input type="text" class="form-control" name="fieldValue" id="fieldValue" value=${dictionaryList.fieldValue!} placeholder="输入默认值...">
						</div>
						<div class="form-group">
							<label id="sortLabel">排序:</label>
							<input type="text" class="form-control" name="sort" id="sort" value=${dictionaryList.sort} placeholder="排序值...">
						</div>
						<div class="form-group">
							<label>备注:</label>
							<input type="text" class="form-control" name="remark" id="remark" value="${dictionaryList.remark}" placeholder="输入备注...">
						</div>
		             </div>
					<div class="box-footer">
						<div class="pull-right">
							<button class="btn btn-sm btn-info" onClick="history.back();">返回</button>
		               		<button  id="submit"  type="submit" class="btn btn-primary btn-sm">更新</button>
						</div>
	              	</div>
				</form>
			</div>
		</div>
	</div>
</div>
<@wrapper/>
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
});
</script>
<@footer/>