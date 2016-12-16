<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="security"/>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">角色管理</h3>
					<div class="box-tools pull-right">
						<@shiro.hasPermission name="super:insert">
							<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
								<i class="fa fa-plus"></i>添加
							</button>
						</@shiro.hasPermission>
					</div>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div class="clearfix">
	            		<form id="search-form" action="${ctx}/admin/role/list" method="post">
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
									<input type="text" class="form-control input-sm" id="search" name="search" value="${param['search']!}" placeholder="根据角色搜索...">
								</div>
							</div>
							<div class="col-md-4">
								<button type="submit" id="reset" class="btn btn-warning btn-sm">
									<i class="fa fa-rotate-left"></i>重置
								</button>
								<button type="submit" class="btn btn-primary btn-sm">
									<i class="fa fa-search"></i>查询
								</button>
							</div>
						</form>
						<br/><br/>
					</div>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>序号</th>
								<th>角色</th>
								<th>角色值</th>
								<th>状态</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<#list page.list as bean>
								<tr>
									<td>${bean_index+1}</td>
									<td>${bean.roleName}</td>
									<td>${bean.roleValue}</td>
									<td>
										<#if bean.statusId == '0'>不可用</#if>
										<#if bean.statusId == '1'>可用</#if>
									</td>
									<td>${bean.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
									<td>
										<a class="btn btn-sm btn-primary" href="${ctx}/admin/role/view?id=${bean.id}">查看</a>
										
										<#if bean.roleValue != 'superAdmin'>
											<@shiro.hasPermission name="super:update">
												<a class="btn btn-twitter btn-sm" href="${ctx}/admin/role/edit?id=${bean.id}">修改</a>
											</@shiro.hasPermission>
											<@shiro.hasPermission name="super:delete">
												<a class="btn btn-danger btn-sm" onClick="delcfm('${ctx}/admin/role/delete?id=${bean.id}')">删除</a>
											</@shiro.hasPermission>
										</#if>
									</td>
								</tr>
							</#list>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
				<@initPage url="${ctx}/admin/role/list" paginationSize=5/>
			</div>
		</div>
	</div>
</div>
<#include "add.ftl" />
<@wrapper/>
<@deleteHint/>
<@footer/>