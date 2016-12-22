<div class="row">
	<div class="col-md-12">
		<table class="table table-striped">
            <tr>
            	<td>上级关联：</td>
            	<td style="width: 90%">${dictionaryList.fieldCode!}</td>
            </tr>
            <tr>
            	<td>名称：</td>
            	<td>${dictionaryList.fieldKey}</td>
            </tr>
            <tr>
            	<td>默认值:</td>
            	<td>${dictionaryList.fieldValue}</td>
            </tr>
            <tr>
            	<td>排序:</td>
            	<td>${dictionaryList.sort}</td>
            </tr>
            <tr>
            	<td>创建时间：</td>
            	<td>${dictionaryList.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
            </tr>
            <tr>
            	<td>更新时间：</td>
            	<td>${dictionaryList.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
            </tr>
            <tr>
            	<td style="min-height:300px">备注:</td>
            	<td>${dictionaryList.remark}</td>
            </tr>
     	</table>
     	<div class="box-footer">
			<div class="pull-right">
				<button type="button" class="btn btn-default btn-sm" id="close" data-dismiss="modal"><i class="fa fa-close"></i>关闭</button>
			</div>
		</div>
	</div>
</div>