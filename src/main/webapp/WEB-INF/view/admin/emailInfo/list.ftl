<#include "/macro/base.ftl" /> <@header/> <@menu activeId="email"/>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">收件箱</h3>
					<div class="box-tools pull-right">
						<div class="has-feedback">
							<input type="text" class="form-control input-sm" placeholder="搜索邮件......">
							<span class="glyphicon glyphicon-search form-control-feedback"></span>
						</div>
					</div>
				</div>
				<div class="box-body no-padding">
					<div class="mailbox-controls">
						<div class="mailbox-controls">
						<!-- Check all button -->
						<button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i></button>
						<div class="btn-group">
							<button type="button" class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
							<button type="button" class="btn btn-default btn-sm"><i class="fa fa-reply"></i></button>
							<button type="button" class="btn btn-default btn-sm"><i class="fa fa-share"></i></button>
						</div>
						<button type="button" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
						<div class="pull-right">
							#{(page.pageCurrent-1)*page.pageSize+1}-#{page.pageCurrent*page.pageSize}/#{page.totalCount}
							<div class="btn-group">
								<#if (page.pageCurrent > 1)>
								<a href="${ctx}/admin/emailInfo/list?pageCurrent=${page.pageCurrent-1}&pageSize=${page.pageSize}">
									<button type="button" class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
								</a>
								</#if> <#if (page.pageCurrent <=1)>
								<a>
									<button type="button" class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
								</a>
								</#if> <#if (page.pageCurrent
								<page.totalPage)> <a href="${ctx}/admin/emailInfo/list?pageCurrent=${page.pageCurrent+1}&pageSize=${page.pageSize}">
									<button type="button" class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
								</a> </#if> <#if (page.pageCurrent >=page.totalPage)> <a>
									<button type="button" class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
								</a> </#if> 
							</div>
						</div>
					</div>
					</div>
					<div class="table-responsive mailbox-messages" style="min-height: 350px;">
						<table class="table table-hover table-striped">
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
				</div>
				<div class="box-footer no-padding">
					<div class="mailbox-controls">
						<!-- Check all button -->
						<button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i></button>
						<div class="btn-group">
							<button type="button" class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
							<button type="button" class="btn btn-default btn-sm"><i class="fa fa-reply"></i></button>
							<button type="button" class="btn btn-default btn-sm"><i class="fa fa-share"></i></button>
						</div>
						<button type="button" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
						<div class="pull-right">
							#{(page.pageCurrent-1)*page.pageSize+1}-#{page.pageCurrent*page.pageSize}/#{page.totalCount}
							<div class="btn-group">
								<#if (page.pageCurrent > 1)>
									<a  href="${ctx}/admin/emailInfo/list?pageCurrent=${page.pageCurrent-1}&pageSize=${page.pageSize}">
										<button type="button" ><i class="fa fa-chevron-left"></i></button>
									</a>
								</#if>
								<#if (page.pageCurrent <=1)>
									<a>
										<button type="button" class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
									</a>
								</#if>
								<#if (page.pageCurrent < page.totalPage) > 
									<a href="${ctx}/admin/emailInfo/list?pageCurrent=${page.pageCurrent+1}&pageSize=${page.pageSize}">
										<button type="button" class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
									</a> 
								</#if> 
								<#if (page.pageCurrent >=page.totalPage)>
									 <a>
										<button type="button" class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
									</a> 
								</#if> 
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<@wrapper/>
<@deleteHint/>
<!-- iCheck -->
<link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<!-- Page Script -->
<script>
	$(function() {
		//Enable iCheck plugin for checkboxes
		//iCheck for checkbox and radio inputs
		$('.mailbox-messages input[type="checkbox"]').iCheck({
			checkboxClass : 'icheckbox_flat-blue',
			radioClass : 'iradio_flat-blue'
		});

		//Enable check and uncheck all functionality
		$(".checkbox-toggle").click(
				function() {
					var clicks = $(this).data('clicks');
					if (clicks) {
						//Uncheck all checkboxes
						$(".mailbox-messages input[type='checkbox']").iCheck(
								"uncheck");
						$(".fa", this).removeClass("fa-check-square-o")
								.addClass('fa-square-o');
					} else {
						//Check all checkboxes
						$(".mailbox-messages input[type='checkbox']").iCheck(
								"check");
						$(".fa", this).removeClass("fa-square-o").addClass(
								'fa-check-square-o');
					}
					$(this).data("clicks", !clicks);
				});

		//Handle starring for glyphicon and font awesome
		$(".mailbox-star").click(function(e) {
			e.preventDefault();
			//detect type
			var $this = $(this).find("a > i");
			var glyph = $this.hasClass("glyphicon");
			var fa = $this.hasClass("fa");

			//Switch states
			if (glyph) {
				$this.toggleClass("glyphicon-star");
				$this.toggleClass("glyphicon-star-empty");
			}

			if (fa) {
				$this.toggleClass("fa-star");
				$this.toggleClass("fa-star-o");
			}
		});
	});
</script>
<@footer/>
