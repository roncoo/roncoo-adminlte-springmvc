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



					<table class="table table-bordered">
						<thead>
							<tr>
								<th>序号</th>
								<th>账号</th>
								<th>host</th>
								<th>备注</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<#list page.list as info>
							<tr>
								<td>${info_index+1}</td>
								<td>${info.fromUser}</td>
								<td>${info.host}</td>
								<td>${info.remark}</td>
								<td>${info.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
								<td>
									<a href="${ctx}/admin/emailAccountInfo/delete?id=${info.id}">
										<button type="button" class="btn btn-danger btn-xs">删除</button>
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

	<!-- /.content -->
</div>

<@footer/>


<script type="text/javascript" src="bootstrap/bootstrap.js"></script>

<!-- 拟态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<form action="${ctx}/admin/emailAccountInfo/save" method="post">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加账号信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Host</label> 
						<select name="host" class="form-control select2" style="width: 100%;">
						<#list selectList as select>
							<option value="${select.fieldKey}">${select.fieldValue}</option>
						</#list>
						</select>
					</div>
					<div class="form-group">
						<label>邮箱账号</label> <input type="text" class="form-control" name="fromUser" id="fromUser" placeholder="输入邮箱...">
					</div>
					<div class="form-group">
						<label>授权码</label> <input type="text" class="form-control" name="passwd" id="passwd" placeholder="授权码...">
					</div>
					<div class="form-group">
						<label>备注</label> <input type="text" class="form-control" name="remark" id="remark" placeholder="输入备注...">
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