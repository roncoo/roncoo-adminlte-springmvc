<#include "/macro/base.ftl" />
<@header/>
<@menu activeId="email"/>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">发件箱</h3>
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
	        		<button type="submit" id="submitExample4" class="btn btn-primary">查询</button>
	        	</div>
        	</div>
			<table id="example4" class="table table-bordered" >
		         <thead>
		            <tr>
		                <th>序号</th>
		                <th>发件人</th>
		                <th>收件人</th>
		                <th>主题</th>
		                <th>发送时间</th>
		                <th>操作</th>
		            </tr>
		        </thead>
		    </table>
			</div>
			</div>
		</div>
	</div>
</div>
<@wrapper/>
<@deleteHint/>
<!-- iCheck -->
<link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<!-- Page Script -->
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
        "ajax": {"url":"${ctx}/admin/emailInfo/page","type":"post"},
        "columns": [
            { "data": null },
            { "data": "fromUser" },
            { "data": "toUser" },
            { "data": "subject" },
            { "data": "createTime" },
            { "data": null }
        ],
        "columnDefs": [
						{
						    targets: 0,
						    data: null,
						    render: function (data) {
						    	No=No+1;
						        return No;
						    }
						},
		               {
		            "targets": 5,
		            "data": null,
		            "render": function(data){
						console.log(data);
						return '<a class="btn btn-xs btn-primary" href="${ctx}/admin/emailInfo/view?id='+data.id+'">查看</a> &nbsp;<a class="btn btn-xs btn-default" onClick="delcfm(\'${ctx}/admin/emailInfo/delete?id='+data.id+'\')">删除</a>'
					}
      			} ]
    } ).on('preXhr.dt', function ( e, settings, data ) {
		No=0;
    } );

	$("#submitExample4").on("click",function(){
		reloadTable(example4);
	})

  });
</script>
<@footer/>
