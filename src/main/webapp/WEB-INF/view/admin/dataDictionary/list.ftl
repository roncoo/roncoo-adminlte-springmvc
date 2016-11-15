<#include "/macro/base.ftl" />
<@header/>
<@menu activeId="dictionary"/>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">数据字典表</h3>
					<div class="box-tools pull-right">
						<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">添加</button>
					</div>
				</div>
				<div class="box-body">
					<div class="clearfix">
	            		<form action="${ctx}/admin/emailAccountInfo/list">
							<div class="col-md-4">
								<div class="input-group date ">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control pull-right" id="date" name="date" value="${date!}" placeholder="选择时间...">
								</div>
							</div>
							<div class="col-md-4">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-search"></i></span>
									<input type="text" class="form-control" name="search" value="${search!}" placeholder="根据账号搜索...">
								</div>
							</div>
							<div class="col-md-4">
								<button type="submit" class="btn btn-primary btn-sm">查询</button>
							</div>
						</form>
					</div>
					<table id="example4" class="table table-bordered" >
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
							<#list page.list as bean>
								<td>${bean_index+1}</td>
								<td>${bean.fieldName}</td>
								<td>${bean.sort}</td>
								<td>${bean.remark}</td>
								<td>${bean.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
								<td>
									<a class="btn btn-primary btn-xs" href="${ctx}/admin/dataDictionary/view?id=${bean.id}">查看</a>
									<a class="btn btn-primary btn-xs" href="${ctx}/admin/dataDictionaryList/list?id=${bean.id}&fieldCode=${bean.fieldCode}">查看明细</a>
									<a class="btn btn-info btn-xs" href="${ctx}/admin/dataDictionary/edit?id=${bean.id}">修改</a>
									<a class="btn btn-danger btn-xs" onClick="delcfm('${ctx}/admin/dataDictionary/delete?id=${bean.id}&fieldCode=${bean.fieldCode}')">删除</a>
								</td>
							</#list>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
				<@initPage url="${ctx}/admin/dataDictionary/list?" paginationSize=5/>
			</div>
		</div>
	</div>
</div>
<#include "add.ftl" />
<@wrapper/>
<@deleteHint/>
<@footer/>
