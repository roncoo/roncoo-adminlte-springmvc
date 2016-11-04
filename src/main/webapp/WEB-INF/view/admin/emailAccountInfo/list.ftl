<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">邮箱账号管理</h3>
				<div class="box-tools pull-right">
					<a id="account_add" class="btn btn-sm btn-primary" target="modal" modal="lg" href="${ctx}/admin/emailAccountInfo/add">添加</a>
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
							<input type="text" class="form-control pull-right" id="tableParam" placeholder="选择时间...">
						</div>
					</div>
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-search"></i></span>
							<input type="text" class="form-control" id="search" placeholder="根据账号搜索...">
						</div>
					</div>
					<div class="col-md-4">
						<button type="submit" id="emailAccountInfo-seek" class="btn btn-primary">搜索</button>
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
	
	var No=0;
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
		    {"data" : null}, 
			{"data" : "fromUser"},
			{"data" : "host"},
			{"data" : "remark"},
			{"data" : null},
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
						    targets: 4,
						    data: null,
						    render: function (data) {
						    	 var now = new Date(parseInt(data.createTime) * 1);
								   now =  now.toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
								   if(now.indexOf("下午") > 0) {
									    
									    var temp1 = now.substring(0,now.indexOf("下午"));   //2014/7/6
									    var temp2 = now.substring(now.indexOf("下午")+2,now.length);  // 5:17:43
									    var temp3 = temp2.substring(0,1);    //  5
									    var temp4 = parseInt(temp3); // 5
									    temp4 = 12 + temp4;  // 17
									   }
								   if(now.indexOf("上午") > 0) {
									    
									   var temp1 = now.substring(0,now.indexOf("上午"));   //2014/7/6
									    var temp2 = now.substring(now.indexOf("上午")+2,now.length);  // 5:17:43
									    var temp3 = temp2.substring(0,1);    //  5
									    var index = 1;
									    var temp4 = parseInt(temp3); // 5
									    
									   }
									    var temp5 = temp4 + temp2.substring(1,temp2.length); // 17:17:43
									    now = temp1 + temp5; // 2014/7/6 17:17:43
									    now = now.replace("/","-"); //  2014-7/6 17:17:43
									    now = now.replace("/","-"); //  2014-7-6 17:17:43
								return  now;
						    }
						},
		                {
			"targets" : -1,
			"data" : null,
			"render" : function(data) {
				return '<a class="btn btn-xs btn-primary" target="modal" modal="lg" href="${ctx}/admin/emailAccountInfo/view?id='
						+ data.id
						+ '">查看</a> &nbsp;<a class="btn btn-xs btn-info account_edit" target="modal" modal="lg" href="${ctx}/admin/emailAccountInfo/edit?id='
						+ data.id
						+ '">修改</a> &nbsp;<a class="btn btn-xs btn-default btn-del" data-body="确认要删除吗？" target="ajaxTodo" href="${ctx}/admin/emailAccountInfo/delete?id='
						+ data.id + '">删除</a>'
			}
		} ]
	}).on('preXhr.dt', function ( e, settings, data ) {
		No=0;
    } );
	
	//点击删除确认时，删除后刷新
    $(".btn-del").on('click',function(){
		reloadTable(emailAccountInfo_tab);
	});
	
	//动态生成的元素需要这样做点击事件
    $(document).on("click", ".account_edit", function() {  
    	list_ajax = emailAccountInfo_tab;
    }); 
	
	$("#account_add").on('click',function(){
		list_ajax = emailAccountInfo_tab;
	});
	$("#emailAccountInfo-seek").on("click",function(){
		reloadTable(emailAccountInfo_tab);
	});
});
</script>