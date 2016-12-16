<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="dictionary"/>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<form action="${ctx}/admin/dataDictionary/update" method="post">
					<input type="hidden" id="oldFieldCode" name="oldFieldCode" value=${dictionary.fieldCode}>
					<input type="hidden" id="id" name="id" value=${dictionary.id}>
					<div class="box-header with-border">
						<h3 class="box-title">数据字典修改</h3>
					</div>
					<div class="box-body">
						<div class="form-group">
							<label id="fieldNameLabel">字段名:</label>
							<input type="text" class="form-control" name="fieldName" id="fieldName" value=${dictionary.fieldName!} placeholder="输入字段名称...">
						</div>
						<div class="form-group">
							<label id="fieldCodeLabel">Code值:</label>
							<input type="text" class="form-control" name="fieldCode" id="fieldCode" value=${dictionary.fieldCode!} placeholder="输入Code值...">
						</div>
						<div class="form-group">
							<label id="sortLabel">排序:</label>
							<input type="text" class="form-control" name="sort" id="sort" value=${dictionary.sort} placeholder="排序值...">
						</div>
						<div class="form-group">
							<label>备注:</label>
							<input type="text" class="form-control" name="remark" id="remark" value="${dictionary.remark}" placeholder="输入备注...">
						</div>
		             </div>
					<div class="box-footer">
						<div class="pull-right">
							<button class="btn btn-sm btn-info" onClick="history.back();">返回</button>
		               		<button id="submit" type="submit" class="btn btn-sm btn-primary">更新</button>
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
});
</script>
<@footer/>