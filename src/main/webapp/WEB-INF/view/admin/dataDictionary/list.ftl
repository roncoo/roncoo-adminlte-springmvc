<#include "/macro/base.ftl" /> <@header/> <@menu activeId="dictionary"/>

<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">数据字典表</h3>
					<div class="box-tools pull-right">
						<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">添加</button>
					</div>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
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
						<tbody>
							<#list page.list as data>
							<tr>
								<td>${data_index+1}</td>
								<td>${data.fieldName}</td>
								<td>${data.sort}</td>
								<td>${data.remark}</td>
								<td>${data.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
								<td>
									<a href="${ctx}/admin/dataDictionary/view?id=${data.id}">
										<button type="button" class="btn btn-primary btn-xs">查看</button>
									</a>
									<a href="${ctx}/admin/dataDictionaryList/list?id=${data.id}&fieldCode=${data.fieldCode}">
										<button type="button" class="btn btn-primary btn-xs">查看明细</button>
									</a>
									<a href="${ctx}/admin/dataDictionary/edit?id=${data.id}">
											<button type="button" class="btn btn-info btn-xs">修改</button>
									</a>
									<a href="${ctx}/admin/dataDictionary/delete?id=${data.id}&fieldCode=${data.fieldCode}">
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

<#include "add.ftl" /> <@wrapper/>
<!-- 这里添加额外的css和js -->
<@footer/>
