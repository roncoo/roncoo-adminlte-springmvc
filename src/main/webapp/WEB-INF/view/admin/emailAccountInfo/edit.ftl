<div class="row">
	<div class="col-md-12">
		<form id="emailAccountInfo-edit-form" method="post">
			<input type="hidden" id="id" name="id" value=${info.id}>
			<div>
				<div class="form-group">
					<label>Host</label> 
					<select name="host" class="form-control select2" style="width: 100%;">
						<#list selectList as select>
							<option <#if info.host == select.fieldValue>selected="selected"</#if> value="${select.fieldValue}">${select.fieldKey}</option>
						</#list>
					</select>
				</div>
				<div class="form-group">
					<label id="fromUserLabel">邮箱账号</label>
					<input type="text" class="form-control" name="fromUser" id="fromUser" value=${info.fromUser!} placeholder="输入邮箱...">
				</div>
				<div class="form-group">
					<label id="passwdLabel">授权码</label>
					<input type="text" class="form-control" name="passwd" id="passwd" value=${info.passwd} placeholder="授权码...">
				</div>
				<div class="form-group">
					<label>备注</label>
					<input type="text" class="form-control" name="remark" id="remark" value="${info.remark}" placeholder="输入备注...">
				</div>
             </div>
          	<div class="box-footer">
                <div class="pull-right">
					<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
                	<button onclick="emilAccountInfoUpdate();" type="button" class="btn btn-primary btn-sm"><i class="fa fa-paste"></i>更新</button>
                </div>
          	</div>
		</form>
	</div>
</div>
	
<script type="text/javascript">
function emilAccountInfoUpdate(){
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ ;
 	var status = 1;
 	$("span").remove(".errorClass");
 	$("br").remove(".errorClass");
 	if($("#fromUser").val()==""){
 		$("#fromUserLabel").prepend('<span class="errorClass" style="color:red">*收件人不能为空</span><br class="errorClass"/>');
 		status=0;
 	}
 	if(!reg.test($("#fromUser").val())&&$("#fromUser").val()!=""){
 		$("#fromUserLabel").prepend('<span class="errorClass" style="color:red">*收件人邮箱格式不正确</span><br class="errorClass"/>');
 		status=0;
 	}
 	if($("#passwd").val()==""){
 		$("#passwdLabel").prepend('<span class="errorClass" style="color:red">*授权码不能为空</span><br class="errorClass"/>');
 		status=0;
 	}
 	if(status == 0){
 		return false;
 	}else{
 		$.ajax({
 			url: '${ctx}/admin/emailAccountInfo/update',
	        type: 'post',
	        dataType: 'text',
	        data: $("#emailAccountInfo-edit-form").serialize(),
	        success: function (data) {
	        	$("#lgModal").modal('hide');
	        	alertMsg("更新成功","success");
	        	reloadTable(list_ajax,"#accountInfo-time","#accountInfo-premise");
	        }
 		});
 	}
}
</script>