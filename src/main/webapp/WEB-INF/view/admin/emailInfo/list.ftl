<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">邮件列表</h3>
				<div class="box-tools pull-right">
						<a onclick="emailSend();" class="btn btn-sm btn-primary" target="modal" modal="lg" href="${ctx}/admin/emailInfo/add">发送</a>
				</div>
			</div>
	        <div class="box-body">
	        	<div class="clearfix">
		        	<div class="col-md-4">
				        <div class="input-group date ">
							<div class="input-group-addon">
		                    	<i class="fa fa-calendar"></i>
		                  	</div>
		                  	<input type="text" class="form-control pull-right" id="emailInfoTime" placeholder="选择时间...">
		                </div>
		        	</div>
		        	<div class="col-md-4">
		        		<div class="input-group">
			                <span class="input-group-addon"><i class="fa fa-search"></i></span>
			                <input type="text" class="form-control" id="emailInfoPremise" placeholder="根据收件人搜索...">
			            </div>
		        	</div>
		        	<div class="col-md-4">
		        		<button type="button" onclick="emailInfoReload();" class="btn btn-primary">搜索</button>
		        	</div>
	        	</div>
	        	<!-- 表格 -->
				<table id="emailInfo_tab" class="table table-bordered table-striped" >
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
<script type="text/javascript">
var emailInfo_tab;
$(function () {
    //初始化时间选择器
    $('#emailInfoTime').datepicker({
      	language: 'zh-CN',
		format: 'yyyy-mm-dd',
		autoclose: true,
		todayHighlight: true
    });
	//初始化表格
	var No=0;
    emailInfo_tab = $('#emailInfo_tab').DataTable( {
        "dom":'itflp',
        "processing":true,
		"searching":false,
        "serverSide":true,   //启用服务器端分页
		"bInfo":false,  
        "language":{"url":"plugins/datatables/language.json"},
        "ajax":{"url":"${ctx}/admin/emailInfo/page","type":"post"},
        "columns": [
            { "data":null },
            { "data":"fromUser" },
            { "data":"toUser" },
            { "data":"subject" },
            { "data":"createTime" },
            { "data":null }
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
				var btn = '<a class="btn btn-xs btn-primary" target="modal" modal="lg" href="${ctx}/admin/emailInfo/view?id='+data.id+'">查看</a> &nbsp;'
				+'<a class="btn btn-xs btn-default" data-body="确认要删除吗？" callback="emailInfoReload();" target="ajaxTodo" href="${ctx}/admin/emailInfo/delete?id='+ data.id + '">删除</a>';
				return btn;
			}
      	} ]
    } ).on('preXhr.dt',function(e,settings,data) {
		No=0;
    } );
});

function emailInfoReload(){
	reloadTable(emailInfo_tab,"#emailInfoTime","#emailInfoPremise");
}

function emailSend(){
	list_ajax = emailInfo_tab;
}
</script>