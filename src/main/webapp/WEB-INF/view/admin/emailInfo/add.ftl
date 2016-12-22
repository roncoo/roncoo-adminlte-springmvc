<div class="row">
	<div class="col-md-12">
		<form id="emailInfoSendForm" method="post">
			<div>
				<div id="toUserDiv" class="form-group">
					<input class="form-control" id="toUser" name="toUser" placeholder="发送至:" >
				</div>
				<div id="subjectDiv" class="form-group">
					<input class="form-control" id="subject" name="subject" placeholder="主题:" >
				</div>
				<div id="titleDiv" class="form-group">
					<input class="form-control"  id="title" name="title" placeholder="标题:" >
				</div>
				<div id="contentDiv" class="form-group">
					<textarea id="textarea" name="content" class="form-control" style="height: 200px" placeholder="正文....."></textarea>
				</div>
				<div class="form-group"></div>
			</div>
			<div class="box-footer">
				<div class="pull-right">
                	<button type="button" class="btn btn-default btn-sm"  data-dismiss="modal"><i class="fa fa-close"></i>取消</button>
                	<button onclick="emailInfoSend();" type="button" class="btn btn-primary btn-sm"><i class="fa fa-save"></i>发送</button>
                </div>
       		</div>
		</form>
	</div>
</div>

<script type="text/javascript">
	function emailInfoSend(){
		var status = 1;
		$("span").remove(".errorClass");
		$("br").remove(".errorClass");
		if ($("#toUser").val() == "") {
			$("#toUserDiv").prepend('<span class="errorClass" style="color:red">*收件人不能为空</span><br class="errorClass"/>');
			status = 0;
		}
		if ($("#subject").val() == "") {
			$("#subjectDiv").prepend('<span class="errorClass" style="color:red">*主题不能为空</span><br class="errorClass"/>');
			status = 0;
		}
		if ($("#title").val() == "") {
			$("#titleDiv").prepend('<span class="errorClass" style="color:red">*标题不能为空</span><br class="errorClass"/>');
			status = 0;
		}
		if ($("#textarea").val() == "") {
			$("#contentDiv").prepend('<span class="errorClass" style="color:red">*正文不能为空</span><br class="errorClass"/>');
			status = 0;
		}
		if (status == 0) {
			return false;
		}else{
			$.ajax({
				url: '${ctx}/admin/emailInfo/send',
		        type: 'post',
		        dataType: 'text',
		        data: $("#emailInfoSendForm").serialize(),
		        success: function (data) {
		        	$("#lgModal").modal('hide');
		        	alertMsg("添加成功","success");
		        	reloadTable(list_ajax,"#emailInfoTime","#emailInfoPremise");
		        }
			});
		}
	}
	
	$(function(){
		$("#textarea").wysihtml5();
	});
</script>