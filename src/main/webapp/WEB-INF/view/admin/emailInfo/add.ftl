 <#include "/macro/base.ftl" /> <@header/> <@menu/>

<div class="content-wrapper">
	<!-- Main content -->

	<div class="row">

		<div class="col-md-12">
			<form action="${ctx}/admin/email/insert" method="post">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">编写邮件</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<div class="form-group">
							<input class="form-control" name="toUser" placeholder="发送至:">
						</div>
						<div class="form-group">
							<input class="form-control" name="subject" placeholder="主题:">
						</div>
						<div class="form-group">
							<input class="form-control" name="title" placeholder="标题:">
						</div>
						<div class="form-group">
							<textarea id="compose-textarea" name="content" placeholder="正文....." class="form-control" style="height: 300px">
                    	</textarea>
						</div>
						<div class="form-group"></div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<div class="pull-right">
							<button type="reset" class="btn btn-default">
								<i class="fa fa-pencil"></i> 重置
							</button>
							<button type="submit" class="btn btn-primary">
								<i class="fa fa-envelope-o"></i> 发送
							</button>
						</div>
					</div>
					<!-- /.box-footer -->
				</div>
				<!-- /. box -->
			</form>
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
	<!-- /.content -->
</div>

<@footer/>




<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Page Script -->
<script>
	$(function() {
		$("#compose-textarea").wysihtml5();
	});
</script>
