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
					<table class="table table-bordered">
						<tbody>
								<#list page.list as info>
								<tr>
									<td>
										<input type="checkbox">
									</td>
									<td class="mailbox-star">
										<a href="#">
											<i class="fa fa-star text-yellow"></i>
										</a>
									</td>
									<td class="mailbox-name">
										<a href="read-mail.html">${info_index+1}</a>
									</td>
									<td class="mailbox-user">${info.toUser}</td>
									<td class="mailbox-subject">${info.subject}</td>
									<td class="mailbox-attachment"><#if info.statusId =="0">警告</#if> <#if info.statusId =="1">可用</#if></td>
									<td class="mailbox-date">${info.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
									<td width="120px">
										<a class="btn btn-primary btn-xs" href="${ctx}/admin/emailInfo/view?id=${info.id}">查看</a>
										<a class="btn btn-danger btn-xs" onClick="delcfm('${ctx}/admin/emailInfo/delete?id=${info.id}')">删除</a>
									</td>
								</tr>
								</#list>
							</tbody>
					</table>
				</div>
				<!-- /.box-body -->
				<div class="box-footer clearfix">
					<ul class="pagination pagination-sm no-margin pull-right">
						<li><a href="#">«</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">»</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<@wrapper/> <@deleteHint/>
<!-- iCheck -->
<link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<!-- Page Script -->
<script>

</script>
<@footer/>
