<#include "/macro/base.ftl" />
<!DOCTYPE html>
<html>
<head>
	<@head />
</head>
<body class="sidebar-mini skin-blue fixed">
	<div class="wrapper">
		<@header/>
		
		<@aside/>

		<div class="content-wrapper">
			<!-- Main content -->
			<section class="content">
				<h1>欢迎使用admin LTE</h1>
				<div>文档</div>
			</section>
			<!-- /.content -->
		</div>
		
		<@footer/>
	</div>
	
	<div id="loading" class="loading-panel">
		<div class="box">
			<i class="fa fa-refresh fa-spin"></i> <span class="tip"> 正在加载 · · · </span>
		</div>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.2.3 -->
	<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="plugins/fastclick/fastclick.js"></script>
	<!-- Slimscroll -->
	<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- AdminLTE App -->
	<script src="dist/js/app.min.js"></script>
</body>
</html>
