<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">邮箱账号管理</h3>
				<div class="box-tools pull-right">
					<a onclick="emailAccountInfoToListAjax();" class="btn btn-sm btn-primary" target="modal" modal="lg" href="${ctx}/admin/emailAccountInfo/add">添加</a>
				</div>
			</div>
			<div class="box-body">
				<div class="clearfix">
					<div class="col-md-4">
						<div class="input-group date ">
							<div class="input-group-addon">
								<i class="fa fa-calendar"></i>
							</div>
							<input type="text" class="form-control pull-right" id="accountInfoTime" placeholder="选择时间...">
						</div>
					</div>
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-search"></i></span>
							<input type="text" class="form-control" id="accountInfoPremise" placeholder="根据账号搜索...">
						</div>
					</div>
					<div class="col-md-4">
						<button type="button" onclick="emailAccountInfoReload();" class="btn btn-primary">搜索</button>
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
		</div>
	</div>
</div>
<script type="text/javascript">
var emailAccountInfo_tab;
$(function() {
	//初始化时间选择器
	$('#accountInfoTime').datepicker({
		language: 'zh-CN',
		format: 'yyyy-mm-dd',
		autoclose: true,
		todayHighlight: true
	});
	//初始化表格
	
	var No=0;
	emailAccountInfo_tab = $('#emailAccountInfo_tab').DataTable({
		"dom":"itflp",
		"processing":true,
		"searching":false,
		"serverSide":true, //启用服务器端分页
		"bInfo":false,
		"language":{"url":"plugins/datatables/language.json"},
		"ajax":{"url":"${ctx}/admin/emailAccountInfo/page","type":"post"},
		"columns":[ 
		    {"data":null}, 
			{"data":"fromUser"},
			{"data":"host"},
			{"data":"remark"},
			{"data":"createTime"},
			{"data":null} 
			],
		"columnDefs":[
			{
			    targets: 0,
			    data: null,
			    render: function (data) {
			    	No=No+1;
			        return No;
			    }
			},
            {
				"targets":-1,
				"data":null,
				"render":function(data) {
					var btn = '<a class="btn btn-xs btn-primary" target="modal" modal="lg" href="${ctx}/admin/emailAccountInfo/view?id='+data.id+'">查看</a> &nbsp;'
					+'<a class="btn btn-xs btn-info" onclick="emailAccountInfoToListAjax();" target="modal" modal="lg" href="${ctx}/admin/emailAccountInfo/edit?id='+ data.id+'">修改</a> &nbsp;'
					+'<a class="btn btn-xs btn-default" callback="emailAccountInfoReload();" data-body="确认要删除吗？" target="ajaxTodo" href="${ctx}/admin/emailAccountInfo/delete?id='+data.id +'">删除</a>';
					return btn;
			}
		} ]
	}).on('preXhr.dt',function(e,settings,data ) {
		No=0;
    } );
});

function emailAccountInfoToListAjax(){
	list_ajax = emailAccountInfo_tab;
}
function emailAccountInfoReload(){
	reloadTable(emailAccountInfo_tab,"#accountInfoTime","#accountInfoPremise");
}
</script>