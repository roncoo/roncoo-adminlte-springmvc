<div class="row">
	<div class="col-md-12">
		<table class="table table-striped">
            <tr>
            	<td>账号：</td>
            	<td style="width: 90%">${info.fromUser!}</td>
            </tr>
            <tr>
            	<td>授权码：</td>
            	<td>${info.passwd}</td>
            </tr>
            <tr>
            	<td>服务器:</td>
            	<td>${info.host}</td>
            </tr>
            <tr>
            	<td>创建时间：</td>
            	<td>${info.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
            </tr>
            <tr>
            	<td>更新时间：</td>
            	<td>${info.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
            </tr>
            <tr>
            	<td style="min-height:300px">备注:</td>
            	<td>${info.remark}</td>
        	</tr>
     	</table>
     	<div class="box-footer">
			<div class="pull-right">
				<button type="button" class="btn btn-default btn-sm" id="close" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
			</div>
		</div>
	</div>
</div>