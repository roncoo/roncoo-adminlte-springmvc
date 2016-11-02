<div class="row">
	<div class="col-md-12">
		<div class="box box-primary">
			<form action="${ctx}/admin/emailAccountInfo/save" method="post">
				<div class="box-header with-border">
					<h3 class="box-title">添加账号</h3>
				</div>
				<div class="box-body">
					<div class="form-group">
						<label>Host</label>
						<select name="host" class="form-control select2" style="width: 100%;">
							<#list selectList as select>
							<option value="${select.fieldKey}">${select.fieldValue}</option>
							</#list>
						</select>
					</div>
					<div class="form-group">
						<label id="fromUserLabel">邮箱账号</label>
						<input type="text" class="form-control" name="fromUser" id="fromUser" placeholder="输入邮箱...">
					</div>
					<div class="form-group">
						<label id="passwdLabel">授权码</label>
						<input type="text" class="form-control" name="passwd" id="passwd" placeholder="授权码...">
					</div>
					<div class="form-group">
						<label>备注</label>
						<input type="text" class="form-control" name="remark" id="remark" placeholder="输入备注...">
					</div>
				</div>
				<div class="box-footer">
	                <button type="button" class="btn btn-default"  data-dismiss="modal">取消</button>
	                <button id="emilAccountInfo_submit" type="submit" class="btn btn-info pull-right">添加</button>
              	</div>
			</form>
		</div>
	</div>
</div>


<script type="text/javascript">
$(function(){
	$("#emilAccountInfo_submit").click(function(){
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		var status = 1;
		$("span").remove(".errorSpan");
		$("br").remove(".errorBr");
		if ($("#fromUser").val() == "") {
			$("#fromUserLabel").prepend('<span class="errorSpan" style="color:red">*收件人不能为空</span><br class="errorBr"/>');
			status = 0;
		}
		if (!reg.test($("#fromUser").val())&& $("#fromUser").val() != "") {
			$("#fromUserLabel").prepend('<span class="errorSpan" style="color:red">*收件人邮箱格式不正确</span><br class="errorBr"/>');
			status = 0;
		}
		if ($("#passwd").val() == "") {
			$("#passwdLabel").prepend('<span class="errorSpan" style="color:red">*授权码不能为空</span><br class="errorBr"/>');
			status = 0;
		}
		if (status == 0) {
			return false;
		}
		return true;
	});
});
</script>