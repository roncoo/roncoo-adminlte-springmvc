<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form action="${ctx}/admin/emailAccountInfo/save" method="post">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加账号信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Host</label> 
						<select name="host" class="form-control select2" style="width: 100%;">
						<#list option as option>
							<option value="${option.fieldKey}">${option.fieldValue}</option>
						</#list>
						</select>
					</div>
					<div class="form-group">
						<label id="fromUserLabel">邮箱账号</label> <input type="text" class="form-control" name="fromUser" id="fromUser" placeholder="输入邮箱...">
					</div>
					<div class="form-group">
						<label id="passwdLabel">授权码</label> <input type="text" class="form-control" name="passwd" id="passwd" placeholder="授权码...">
					</div>
					<div class="form-group">
						<label>备注</label> <input type="text" class="form-control" name="remark" id="remark" placeholder="输入备注...">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="close" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
					<button type="submit" class="btn btn-primary"  id="submit"><i class="fa fa-save"></i>保存</button>
				</div>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	 $("#submit").click(function() {
		 var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ ;
	 	var status = 1;
	 	$("span").remove(".errorSpan");
	 	$("br").remove(".errorBr");
	 	if($("#fromUser").val()==""){
	 		$("#fromUserLabel").prepend('<span class="errorSpan" style="color:red">*收件人不能为空</span><br class="errorBr"/>');
	 		status=0;
	 	}
	 	if(!reg.test($("#fromUser").val())&&$("#fromUser").val()!=""){
	 		$("#fromUserLabel").prepend('<span class="errorSpan" style="color:red">*收件人邮箱格式不正确</span><br class="errorBr"/>');
	 		status=0;
	 	}
	 	if($("#passwd").val()==""){
	 		$("#passwdLabel").prepend('<span class="errorSpan" style="color:red">*授权码不能为空</span><br class="errorBr"/>');
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