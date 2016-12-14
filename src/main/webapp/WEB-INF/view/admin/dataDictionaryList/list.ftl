<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="dictionary"/>
<div class="content-wrapper">
	<!-- Main content -->
	<div class="row">
		<div class="col-md-12">
			<div class="box" >
				<div class="box-header with-border">
					<h3 class="box-title">数据字典明细表</h3>
					<div class="box-tools pull-right">
						<button class="btn btn-sm btn-info" onClick="history.back();"><i class="fa fa-reply"></i>返回</button>
						<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i>添加</button>
					</div>
				</div>
				<div class="box-body">
					<div class="clearfix">
	            		<form id="search-form" action="${ctx}/admin/dataDictionaryList/list" method="post">
	            			<input type="hidden" name="fieldCode" value="${param['fieldCode']}"/>
	            			<input type="hidden" name="dId" value="${param['dId']}"/>
							<div class="col-md-4">
								<div class="input-group date ">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control pull-right input-sm" id="date" name="date" value="${param['date']!}" placeholder="选择时间...">
								</div>
							</div>
							<div class="col-md-4">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-search"></i></span>
									<input type="text" class="form-control input-sm" id="search" name="search" value="${param['search']!}" placeholder="根据关键词搜索...">
								</div>
							</div>
							<div class="col-md-4">
								<button type="submit" id="reset" class="btn btn-warning btn-sm"><i class="fa fa-rotate-left"></i>重置</button>
								<button type="submit" class="btn btn-primary btn-sm"><i class="fa fa-search"></i>查询</button>
							</div>
						</form>
						<br/><br/>
					</div>
					<table id="example4" class="table table-bordered table-striped" >
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
							<#list page.list as bean>
								<tr>
									<td>${bean_index+1}</td>
									<td>${bean.fieldKey}</td>
									<td>${bean.fieldValue}</td>
									<td>${bean.sort}</td>
									<td>${bean.remark}</td>
									<td>${bean.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
									<td style="width:25%;">
										<a class="btn btn-primary btn-sm" href="${ctx}/admin/dataDictionaryList/view?id=${bean.id}">查看</a>
										<a class="btn btn-twitter btn-sm" href="${ctx}/admin/dataDictionaryList/edit?id=${bean.id}&dId=${param['dId']}">修改</a>
										<a class="btn btn-danger btn-sm" onClick="delcfm('${ctx}/admin/dataDictionaryList/delete?id=${bean.id}&dId=${param['dId']}&fieldCode=${bean.fieldCode}')">删除</a>
									</td>
								</tr>
							</#list>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
				<@initPage url="${ctx}/admin/dataDictionaryList/list" paginationSize=5/>
			</div>
		</div>
	</div>
</div>
<#include "add.ftl" />
<@wrapper/>
<@deleteHint/>
<@footer/>