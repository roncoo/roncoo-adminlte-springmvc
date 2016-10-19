<script type="text/javascript" src="bootstrap/bootstrap.js"></script>
<div class="row">
	<div class="col-md-12">
		<div class="box box-primary">
			<div class="box-header with-border">
				<h3 class="box-title">数据字典明细表</h3>
				<div class="box-tools pull-right">


					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">添加</button>
				</div>
			</div>
			<div class="box-body">



				<table class="table table-bordered">
					<thead>
						<tr>
							<th>序号</th>
							<th>关键词</th>
							<th>默认值</th>
							<th>排序</th>
							<th>备注</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

						<#list page.list as dataList>
						<tr>
							<td>${dataList_index+1}</td>
							<td>${dataList.fieldKey}</td>
							<td>${dataList.fieldValue}</td>
							<td>${dataList.sort}</td>
							<td>${dataList.remark}</td>
							<td>${dataList.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
							<td>
								<a href="${ctx}/admin/datadictionary-list/${dataList.id}/delete">
								<button type="button" class="btn-xs btn-primary">
									 删除
								</button>
								</a>
							</td>
						</tr>
						</#list>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>



<!-- 拟态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form action="${ctx}/admin/datadictionary-list/insert" method="post">
			<input type="hidden" name="dictionaryId" value="#{dictionaryId}">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="exampleInputEmail1">关键词</label> <input type="text" class="form-control" name="fieldKey"
							id="fieldKey" placeholder="输入key...">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">默认值</label> <input type="text" class="form-control" name="fieldValue"
							id="fieldValue" placeholder="输入value值...">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">排序</label> <input type="text" class="form-control" name="sort" id="sort"
							placeholder="排序，请输入整数...">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">备注</label> <input type="text" class="form-control" name="remark" id="remark"
							placeholder="输入备注...">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">保存</button>
				</div>
			</div>
		</form>
	</div>
</div>