<div class="row">
	<div class="col-xs-12">
	   <div class="box">
	     <div class="box-header">
	       <h3 class="box-title">数据字典明细功能</h3>
	       <div class="box-tools pull-right">
				<a id="dictionary_add" class="btn btn-sm btn-primary"  target="modal" modal="lg" href="${ctx}/admin/dataDictionary/add">添加</a>
			</div>
	     </div>
	     <div class="box-body">
	     	<div class="clearfix">
		      	<div class="col-md-4">
		        <div class="input-group date ">
		                <div class="input-group-addon">
		                  <i class="fa fa-calendar"></i>
		                </div>
		                <input type="text" class="form-control pull-right" id="dictionary-time" placeholder="选择时间...">
		              </div>
		      	</div>
		      	<div class="col-md-4">
		      		<div class="input-group">
		               <span class="input-group-addon"><i class="fa fa-search"></i></span>
		               <input type="text" class="form-control" id="dictionary-premise" placeholder="根据字段名搜索...">
		           </div>
		      	</div>
		      	<div class="col-md-4">
		      		<button type="button" id="dictionary-seek" class="btn btn-primary">搜索</button>
		      	</div>
	     	</div>
			<table id="dictionary_tab" class="table table-bordered table-striped" >
		       <thead>
		           <tr>
					<th>序号</th>
					<th>字段名</th>
					<th>排序</th>
					<th>备注</th>
					<th>创建时间</th>
					<th>操作</th>
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
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">×</span></button>
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
</div>
  
<script>
  $(function () {
    //Date picker
    $('#dictionary-time').datepicker({
      	language: 'zh-CN',
		format: 'yyyy-mm-dd',
		autoclose: true,
		todayHighlight: true
    });
	//初始化表格

	 var No=0;
     var dictionary_tab = $('#dictionary_tab').DataTable( {
        "dom": 'itflp',
        "processing": true,
		"searching": false,
        "serverSide": true,   //启用服务器端分页
		"bInfo": false,  
        "language": {
            "url": "plugins/datatables/language.json"
        },
        "ajax": {"url":"${ctx}/admin/dataDictionary/page","type":"post"},
        "columns": [
            { "data": null},
            { "data": "fieldName" },
            { "data": "sort" },
            { "data": "remark" },
            { "data": "createTime"},
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
				return '<a class="btn btn-xs btn-primary" target="modal" modal="lg" href="${ctx}/admin/dataDictionary/view?id='+data.id+'">查看</a> &nbsp;<a class="btn btn-xs btn-info dictionary-edit" target="modal" modal="lg"  href="${ctx}/admin/dataDictionary/edit?id='+data.id+'">修改</a>&nbsp;<a class="btn btn-xs btn-primary" target="navTab" href="${ctx}/admin/dataDictionaryList/list?id='+data.id+'&fieldCode='+data.fieldCode+'">明细</a>&nbsp;<a class="btn btn-xs btn-default" data-body="确认要删除吗？" target="ajaxTodo" href="${ctx}/admin/dataDictionary/delete?id='+ data.id + '&fieldCode='+data.fieldCode+'">删除</a>'
			}
        } ]
    } ).on('preXhr.dt', function ( e, settings, data ) {
		No=0;
    } );

	//动态生成的元素需要这样做点击事件
    $(document).on("click", "#dictionary_add", function() {
    	list_ajax = dictionary_tab;
    });
	
	//动态生成的元素需要这样做点击事件
    $(document).on("click", ".dictionary-edit", function() {
    	list_ajax = dictionary_tab;
    });
    
	
	 
	 $("#dictionary-seek").on("click",function(){
		 reloadTable(dictionary_tab,"#dictionary-time","#dictionary-premise");
	});
	
	$(document).on("click", ".btn-del", function() { 
	    reloadTable(dictionary_tab,"#dictionary-time","#dictionary-premise");
	 });
  });
</script>