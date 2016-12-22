<div class="row">
	<div class="col-md-12">
		<table class="table table-striped">
            <tr>
            	<td>发件人：</td>
            	<td style="width: 90%">${info.fromUser!}</td>
            </tr>
            <tr>
            	<td>收件人：</td>
            	<td>${info.toUser}</td>
            </tr>
            <tr>
            	<td>主题:</td>
            	<td>${info.subject}</td>
            </tr>
            <tr>
            	<td>标题：</td>
            	<td>${info.title}</td>
            </tr>
            <tr>
            	<td style="min-height:300px">正文</td>
            	<td>${info.content}</td>
        	</tr>
     	</table>
     	<div class="box-footer">
			<div class="pull-right">
				<button type="button" class="btn btn-default btn-sm" id="close" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
			</div>
		</div>
	</div>
</div>