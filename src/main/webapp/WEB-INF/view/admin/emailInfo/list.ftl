<#include "/macro/base.ftl" />
<@header/>
<@menu activeId="email"/>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">发件箱</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div class="clearfix">
	            		<form action="${ctx}/admin/emailInfo/list" method="post">
							<div class="col-md-4">
								<div class="input-group date ">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control pull-right" id="date" name="date" value="${param['date']!}" placeholder="选择时间...">
								</div>
							</div>
							<div class="col-md-4">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-search"></i></span>
									<input type="text" class="form-control" name="search"  value="${param['search']!}" placeholder="根据收件人搜索...">
								</div>
							</div>
							<div class="col-md-4">
								<button type="submit" class="btn btn-primary btn-sm">查询</button>
							</div>
						</form>
					</div>
					<table class="table table-bordered">
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
						<tbody>
							<#list page.list as bean>
								<tr>
									<td>${bean_index+1}</td>
									<td>${bean.fromUser}</td>
									<td>${bean.toUser}</td>
									<td>${bean.subject}</td>
									<td>${bean.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
									<td>
										<a class="btn btn-xs btn-primary" href="${ctx}/admin/emailInfo/view?id=${bean.id}">查看</a>
										<a  class="btn btn-xs btn-default" onClick="delcfm('${ctx}/admin/emailInfo/delete?id=${bean.id}')">删除</a>
									</td>
								</tr>
							</#list>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
				<@initPage url="${ctx}/admin/emailInfo/list" paginationSize=5/>
			</div>
		</div>
	</div>
</div>
<@wrapper/>
<@deleteHint/>
<@footer/>
