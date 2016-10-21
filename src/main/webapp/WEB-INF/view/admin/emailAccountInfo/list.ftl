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
</div>

<#include "add.ftl" />

<@wrapper/>
<!-- 这里添加额外的css和js -->
<@footer/>
