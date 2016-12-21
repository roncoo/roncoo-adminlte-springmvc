<div class="row">
	<div class="col-md-12">
		<div class="box box-primary">
			<div class="box-header with-border">
				<h3 class="box-title">数字字典详情</h3>
			</div>
			<div class="box-body  no-padding">
				<table class="table table-striped">
	                <tr>
	                	<td>字段名：</td>
	                	<td style="width: 90%">${dictionary.fieldName!}</td>
	                </tr>
	                <tr>
	                	<td>字段Code：</td>
	                	<td>${dictionary.fieldCode}</td>
	                </tr>
	                <tr>
	                	<td>排序:</td>
	                	<td>${dictionary.sort}</td>
	                </tr>
	                <tr>
	                	<td>创建时间：</td>
	                	<td>${dictionary.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
	                </tr>
	                <tr>
	                	<td>更新时间：</td>
	                	<td>${dictionary.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
	                </tr>
	                <tr>
	                	<td style="min-height:300px">备注:</td>
	                	<td>${dictionary.remark}</td>
	                </tr>
	         	</table>
             </div>
		</div>
	</div>
</div>