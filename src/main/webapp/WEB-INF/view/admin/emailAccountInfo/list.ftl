<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="email"/>

<div class="content-wrapper">
	<!-- Main content -->
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">账号列表</h3>
					<div class="box-tools pull-right">


						<!-- Button trigger modal -->
						<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">添加</button>
					</div>
				</div>
				<div class="box-body">
					<table id="example4" class="table table-bordered">
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
</div>

<#include "add.ftl" />

<@wrapper/>
<@deleteHint/>
<script>
  $(function () {
	//初始化表格
	var No=0;
     var example4 = $('#example4').DataTable( {
        "dom": 'itflp',
        "processing": true,
		"searching": false,
        "serverSide": true,   //启用服务器端分页
		"bInfo": false,
		"language": {
            "url": "plugins/datatables/language.json"
        }, 
        "ajax" : {
			"url" : "${ctx}/admin/emailAccountInfo/page",
			"type" : "post"
		},
		"columns" : [ 
		    {"data" : null}, 
			{"data" : "fromUser"},
			{"data" : "host"},
			{"data" : "remark"},
			{"data" : "createTime"},
			{"data" : null} 
			],
		"columnDefs" : [
						{
						    targets: 0,
						    data: null,
						    render: function (data) {
						    	No=No+1;
						        return No;
						    }
						},
		                {
			"targets" : -1,
			"data" : null,
			"render" : function(data) {
				return '<a class="btn btn-xs btn-primary" href="${ctx}/admin/emailAccountInfo/view?id='
						+ data.id
						+ '">查看</a> &nbsp;<a class="btn btn-xs btn-info account_edit" target="modal" modal="lg" href="${ctx}/admin/emailAccountInfo/edit?id='
						+ data.id
						+ '">修改</a> &nbsp;<a class="btn btn-xs btn-default btn-del" href="${ctx}/admin/emailAccountInfo/delete?id='
						+ data.id + '">删除</a>'
			}
		} ]
    } ).on('preXhr.dt', function ( e, settings, data ) {
		No=0;
    } );

$("#submitExample4").on("click",function(){
	reloadTable(example4);
})

//当你需要多条件查询，你可以调用此方法，动态修改参数传给服务器
function reloadTable(oTable) {
    var date = $("#tableParam").val();
    var search = $("#search").val();
    var param = {
        "date": date,
        "search": search
    };
    oTable.settings()[0].ajax.data = param;
    oTable.ajax.reload();
}
  });
</script>
<@footer/>
