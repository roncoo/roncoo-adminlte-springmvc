
<div class="row">
	<div class="col-md-12">
		<div class="box box-primary">
			<div class="box-header with-border">
				<h3 class="box-title">发件箱</h3>
				<div class="box-tools pull-right">
					<div class="has-feedback">
						<input type="text" class="form-control input-sm" placeholder="搜索邮件......">
						<span class="glyphicon glyphicon-search form-control-feedback"></span>
					</div>
				</div>
			</div>
			<div class="box-body">
				<table id="example2" class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>编号</th>
							<th>收件人</th>
							<th>主题</th>
							<th>状态</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
<!-- 						<#list page.list as info> -->
<!-- 						<tr> -->
<!-- 							<td class="mailbox-name"> -->
<!-- 								<a href="read-mail.html">${info_index+1}</a> -->
<!-- 							</td> -->
<!-- 							<td class="mailbox-user">${info.toUser}</td> -->
<!-- 							<td class="mailbox-subject">${info.subject}</td> -->
<!-- 							<td class="mailbox-attachment"><#if info.statusId =="0">警告</#if> <#if info.statusId =="1">可用</#if></td> -->
<!-- 							<td class="mailbox-date">${info.createTime?string('yyyy-MM-dd HH:mm:ss')}</td> -->
<!-- 							<td width="120px"> -->
<!-- 								<a class="btn btn-primary btn-xs" href="${ctx}/admin/emailInfo/view?id=${info.id}">查看</a> -->
<!-- 								<a class="btn btn-danger btn-xs" data-body="确认要删除吗？" target="ajaxTodo" -->
<!-- 									href="${ctx}/admin/emailInfo/delete?id=${info.id}">删除</a> -->
<!-- 							</td> -->
<!-- 						</tr> -->
<!-- 						</#list> -->
					</tbody>
					<tfoot>

					</tfoot>
				</table>
			</div>
			<div class="box-footer no-padding"></div>
		</div>
	</div>
</div>
<!-- iCheck -->
<link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<!-- Page Script -->

<script>
	$(document).ready(function() {
		 $('#tableParam').datepicker({
		      autoclose: true
		    });
		
		$('#example2').dataTable({
			"processing" : true,
			"searching" : false,
			"serverSide" : true,//启用服务器端分页
			"language": {
	            "url": "plugins/datatables/language.json"
	        },
	        "ajax": "${ctx}/admin/emailInfo/queryList",
	          "columns": [
	                      { "list": "id"},
	                      { "list": "toUser" },
	                      { "list": "" },
	                      { "list": null },
	                      { "list": null },
	                      { "list": null }
	                  ]
		});
	});
</script>
