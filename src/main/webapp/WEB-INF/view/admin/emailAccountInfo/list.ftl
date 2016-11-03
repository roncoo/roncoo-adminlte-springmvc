<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">邮箱账号管理</h3>
				<div class="box-tools pull-right">
					<a class="btn btn-sm btn-primary" target="modal" modal="lg" href="${ctx}/admin/emailAccountInfo/add">添加</a>
				</div>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<div class="clearfix">
					<div class="col-md-4">
						<div class="input-group date ">
							<div class="input-group-addon">
								<i class="fa fa-calendar"></i>
							</div>
							<input type="text" class="form-control pull-right" id="tableParam">
						</div>
					</div>
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-search"></i></span>
							<input type="text" class="form-control" id="search">
						</div>
					</div>
					<div class="col-md-4">
						<button type="submit" id="submitExample4" class="btn btn-primary">Submit</button>
						<a class="btn btn-default" target="navTab" href="/include/index.html?cid=123">更多</a>
					</div>
				</div>
				<table id="emailAccountInfo_tab" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>序号</th>
							<th>账号</th>
							<th>host</th>
							<th>备注</th>
							<th>创建时间</th>
							<th style="width: 20%">操作</th>
						</tr>
					</thead>
				</table>
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->
	</div>
<!-- /.col -->
</div>
<!-- /.row -->
<div class="modal fade" id="deleteUser">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
				<h4 class="modal-title">提示</h4>
			</div>
			<div class="modal-body">
				<p>确认删除？</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">确认</button>
			</div>
		</div>
	</div>
	<!-- /.modal-content -->
</div>
<script>
$(function() {
	//Date picker
	$('#tableParam').datepicker({
		autoclose : true
	});
	//初始化表格

	var emailAccountInfo_tab = $('#emailAccountInfo_tab').DataTable({
		"dom" : 'itflp',
		"processing" : true,
		"searching" : false,
		"serverSide" : true, //启用服务器端分页
		"bInfo" : false,
		"language" : {
			"url" : "plugins/datatables/language.json"
		},
		"ajax" : {
			"url" : "${ctx}/admin/emailAccountInfo/page",
			"type" : "post"
		},
		"columns" : [ 
		    {"data" : "id"}, 
			{"data" : "fromUser"},
			{"data" : "host"},
			{"data" : "remark"},
			{"data" : "createTime"},
			{"data" : null} 
			],
		"columnDefs" : [ {
			"targets" : -1,
			"data" : null,
			"render" : function(data) {
				return '<a class="btn btn-xs btn-primary" target="modal" modal="lg" href="${ctx}/admin/emailAccountInfo/view?id='
						+ data.id
						+ '">查看</a> &nbsp;<a class="btn btn-xs btn-info" target="modal" modal="lg" href="${ctx}/admin/emailAccountInfo/edit?id='
						+ data.id
						+ '">修改</a> &nbsp;<a class="btn btn-xs btn-default btn-del" data-body="确认要删除吗？" target="ajaxTodo" href="${ctx}/admin/emailAccountInfo/delete?id='
						+ data.id + '">删除</a>'
			}
		} ]
	});
});
</script>