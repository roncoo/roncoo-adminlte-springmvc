<div class="row">
	<div class="col-md-12">
		<form id="emailInfo-send-form" method="post">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">编写邮件</h3>
				</div>
				<div class="box-body">
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
	                	<button type="button" class="btn btn-default"  data-dismiss="modal">取消</button>
	                	<button id="emailInfo_send" type="button" class="btn btn-info pull-right" data-dismiss="modal">发送</button>
           		</div>
			</div>
		</form>
	</div>
</div>
<script>
	$(function() {
		$("#textarea").wysihtml5();
		
		$("#emailInfo_send").click(function(){
			var status = 1;
			$("span").remove(".errorSpan");
			$("br").remove(".errorBr");
			if ($("#toUser").val() == "") {
				$("#toUserDiv").prepend('<span class="errorSpan" style="color:red">*收件人不能为空</span><br class="errorBr"/>');
				status = 0;
			}
			if ($("#subject").val() == "") {
				$("#subjectDiv").prepend('<span class="errorSpan" style="color:red">*主题不能为空</span><br class="errorBr"/>');
				status = 0;
			}
			if ($("#title").val() == "") {
				$("#titleDiv").prepend('<span class="errorSpan" style="color:red">*标题不能为空</span><br class="errorBr"/>');
				status = 0;
			}
			if ($("#textarea").val() == "") {
				$("#contentDiv").prepend('<span class="errorSpan" style="color:red">*正文不能为空</span><br class="errorBr"/>');
				status = 0;
			}
			if (status == 0) {
				return false;
			}
			ajaxPost();
		});

		function ajaxPost() {
			var options = {
		        url: '${ctx}/admin/emailInfo/send',
		        type: 'post',
		        dataType: 'text',
		        data: $("#emailInfo-send-form").serialize(),
		        success: function (data) {
		        	console.log(data)
		        	reloadTable(list_ajax,"#emailInfo-time","#emailInfo-premise");
		        }
	   		};
	    $.ajax(options);
		}
	});
</script>