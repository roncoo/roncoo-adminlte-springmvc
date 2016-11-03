<div class="row">
  <div class="col-xs-12">
    <div class="box">
      <div class="box-header">
        <h3 class="box-title">数据字典明细列表</h3>
        <div class="box-tools pull-right">
		<a class="btn btn-sm btn-primary" target="modal" modal="lg" href="${ctx}/admin/dataDictionaryList/add?id=${id}&fieldCode=${fieldCode}">添加</a>
	</div>
      </div>
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
	<table id="dataDictionaryList_tab" class="table table-bordered table-striped" >
        <thead>
           <tr>
				<th>序号</th>
				<th>关键词</th>
				<th>默认值</th>
				<th>排序</th>
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
<script type="text/javascript">
  $(function () {
    //Date picker
    $('#tableParam').datepicker({
      autoclose: true
    });
    
	//初始化表格
	 var No=0;
     var dataDictionaryList_tab = $('#dataDictionaryList_tab').DataTable( {
        "dom": 'itflp',
        "processing": true,
		"searching": false,
        "serverSide": true,   //启用服务器端分页
		 "bInfo": false,  
        "language": {
            "url": "plugins/datatables/language.json"
        },
        "ajax": {"url": "${ctx}/admin/dataDictionaryList/page?fieldCode=${fieldCode}", "type":"post"},
        "columns": [
            { "data": null },
            { "data": "fieldKey" },
            { "data": "fieldValue" },
            { "data": "sort" },
            { "data": "remark" },
            { "data": null },
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
					    targets: 5,
					    data: "createTime",
					    render: function (data) {
					        return new Date(parseInt(data.createTime) * 1000).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
					    }
					},
                        {
            "targets": -1,
            "data": null,
            "render": function(data){
				return '<a class="btn btn-xs btn-primary" target="modal" modal="lg" href="${ctx}/admin/dataDictionaryList/view?id='+data.id+'">查看</a>&nbsp;<a class="btn btn-xs btn-info" target="modal" modal="lg" href="${ctx}/admin/dataDictionaryList/edit?id='+data.id+'&dId=${id}">修改</a>&nbsp;<a class="btn btn-xs btn-default btn-del" data-body="确认要删除吗？" target="ajaxTodo" href="${ctx}/admin/dataDictionaryList/delete?id='+ data.id + '&dId=${id}&fieldCode=${fieldCode}">删除</a>'
			}
        } ]
    } ).on('preXhr.dt', function ( e, settings, data ) {
		No=0;
    } );
	
	//点击删除确认时，删除后刷新
     $(".btn-del").click(function(){
 		reloadTable(dataDictionaryList_tab);
 	});
	

	
 });
</script>