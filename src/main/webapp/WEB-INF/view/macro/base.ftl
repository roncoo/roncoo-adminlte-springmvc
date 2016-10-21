<#macro menu activeId>
<!-- Left side column. contains the logo and sidebar -->
	<aside class="main-sidebar">
		<!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar">
			<!-- sidebar menu: : style can be found in sidebar.less -->
			<ul class="sidebar-menu">
				<li class="header">主导航</li>
				
				<li class="<#if activeId=='email'>active</#if>">
					<a href="javascript:void(0);">
						<i class="fa fa-envelope"></i> 
						<span>邮箱</span> 
						<span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i></span>
					</a>
					<ul class="treeview-menu">
						<li>
							<a href="${ctx}/admin/emailInfo/list">
								<i class="fa fa-inbox"></i> 
								<span>收件箱</span> 
								<span class="pull-right-container"><small class="label pull-right bg-yellow">12</small></span>
							</a>
						</li>
						<li>
							<a href="${ctx}/admin/emailInfo/add">
								<i class="fa fa-envelope-o"></i> 发送
							</a>
						</li>
						<li>
							<a href="${ctx}/admin/emailAccountInfo/list">
								<i class="fa fa-circle-o"></i> 账号信息
							</a>
						</li>
					</ul>
				</li>
				
				<li class="<#if activeId=='dictionary'>active</#if>">
					<a href="${ctx}/admin/dataDictionary/list">
						<i class="fa fa-folder"></i> <span>数据字典管理</span> </i>
					</a>
				</li>
				
			</ul>
		</section>
		<!-- /.sidebar -->
	</aside>
</#macro>

<#macro header>
<!DOCTYPE html>
<html>
<head>
	<base href="${ctx}/static/roncoo-adminlte/">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>龙果管理后台</title>
	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<!-- Bootstrap 3.3.6 -->
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="dist/css/font-awesome.min.css">
	<!-- Ionicons -->
	<link rel="stylesheet" href="dist/css/ionicons.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
	<!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
	<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
	<!-- 以上为公共css -->

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body class="sidebar-mini skin-blue fixed">
<div class="wrapper">
	<header class="main-header">
		<!-- Logo -->
		<a href="http://www.roncoo.com" target="_blank" class="logo">
			<!-- mini logo for sidebar mini 50x50 pixels -->
			<span class="logo-mini"><b>R</b>A</span>
			<!-- logo for regular state and mobile devices -->
			<span class="logo-lg"><b>Roncoo</b> AdminLTE</span>
		</a>
		
		<!-- Header Navbar: style can be found in header.less -->
		<nav class="navbar navbar-static-top">
			<!-- Sidebar toggle button-->
			<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
				<span class="sr-only">切换导航</span>
			</a>
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<!-- Messages: style can be found in dropdown.less-->
					<li class="dropdown messages-menu">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="fa fa-envelope-o"></i> <span class="label label-success">4</span>
						</a>
						<ul class="dropdown-menu">
							<li class="header">你有4个消息</li>
							<li>
								<!-- inner menu: contains the actual data -->
								<ul class="menu">
									<li>
										<!-- start message -->
										<a href="#">
											<div class="pull-left">
												<img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
											</div>
											<h4>
												运营团队 <small><i class="fa fa-clock-o"></i> 5 分钟</small>
											</h4>
											<p>为什么要使用龙果模板?</p>
										</a>
									</li>
									<!-- end message -->
									<li>
										<a href="#">
											<div class="pull-left">
												<img src="dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
											</div>
											<h4>
												设计团队 <small><i class="fa fa-clock-o"></i> 2 小时</small>
											</h4>
											<p>为什么要使用龙果模板?</p>
										</a>
									</li>
									<li>
										<a href="#">
											<div class="pull-left">
												<img src="dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
											</div>
											<h4>
												开发者 <small><i class="fa fa-clock-o"></i> 今天</small>
											</h4>
											<p>为什么要使用龙果模板?</p>
										</a>
									</li>
									<li>
										<a href="#">
											<div class="pull-left">
												<img src="dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
											</div>
											<h4>
												销售部 <small><i class="fa fa-clock-o"></i> 昨天</small>
											</h4>
											<p>为什么要使用龙果模板?</p>
										</a>
									</li>
									<li>
										<a href="#">
											<div class="pull-left">
												<img src="dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
											</div>
											<h4>
												测试员 <small><i class="fa fa-clock-o"></i> 2 天前</small>
											</h4>
											<p>为什么要使用龙果模板?</p>
										</a>
									</li>
								</ul>
							</li>
							<li class="footer">
								<a href="#">查看所有消息</a>
							</li>
						</ul>
					</li>
					<!-- Notifications: style can be found in dropdown.less -->
					<li class="dropdown notifications-menu">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="fa fa-bell-o"></i> <span class="label label-warning">10</span>
						</a>
						<ul class="dropdown-menu">
							<li class="header">你有10个通知</li>
							<li>
								<!-- inner menu: contains the actual data -->
								<ul class="menu">
									<li>
										<a href="#">
											<i class="fa fa-users text-aqua"></i> 今天有 5 人加入
										</a>
									</li>
									<li>
										<a href="#">
											<i class="fa fa-warning text-yellow"></i> 很长的描述，可能在这里不适合展示
										</a>
									</li>
									<li>
										<a href="#">
											<i class="fa fa-users text-red"></i> 5 新用户
										</a>
									</li>
									<li>
										<a href="#">
											<i class="fa fa-shopping-cart text-green"></i> 25 销售额
										</a>
									</li>
									<li>
										<a href="#">
											<i class="fa fa-user text-red"></i> 你更改了你的用户名
										</a>
									</li>
								</ul>
							</li>
							<li class="footer">
								<a href="#">显示全部</a>
							</li>
						</ul>
					</li>
					<!-- Tasks: style can be found in dropdown.less -->
					<li class="dropdown tasks-menu">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="fa fa-flag-o"></i> <span class="label label-danger">9</span>
						</a>
						<ul class="dropdown-menu">
							<li class="header">你有9个任务</li>
							<li>
								<!-- inner menu: contains the actual data -->
								<ul class="menu">
									<li>
										<!-- Task item -->
										<a href="#">
											<h3>
												设计一些按钮 <small class="pull-right">20%</small>
											</h3>
											<div class="progress xs">
												<div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
													<span class="sr-only">20% 完成</span>
												</div>
											</div>
										</a>
									</li>
									<!-- end task item -->
									<li>
										<!-- Task item -->
										<a href="#">
											<h3>
												创造一个好的主题 <small class="pull-right">40%</small>
											</h3>
											<div class="progress xs">
												<div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
													<span class="sr-only">40% 完成</span>
												</div>
											</div>
										</a>
									</li>
									<!-- end task item -->
									<li>
										<!-- Task item -->
										<a href="#">
											<h3>
												使用龙果模板 <small class="pull-right">60%</small>
											</h3>
											<div class="progress xs">
												<div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
													<span class="sr-only">60% 完成</span>
												</div>
											</div>
										</a>
									</li>
									<!-- end task item -->
									<li>
										<!-- Task item -->
										<a href="#">
											<h3>
												活动规则设定 <small class="pull-right">80%</small>
											</h3>
											<div class="progress xs">
												<div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
													<span class="sr-only">80% 完成</span>
												</div>
											</div>
										</a>
									</li>
									<!-- end task item -->
								</ul>
							</li>
							<li class="footer">
								<a href="#">查看所有任务</a>
							</li>
						</ul>
					</li>
					<!-- User Account: style can be found in dropdown.less -->
					<li class="dropdown user user-menu">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image"> <span class="hidden-xs">龙果开源</span>
						</a>
						<ul class="dropdown-menu">
							<!-- User image -->
							<li class="user-header">
								<img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

								<p>
									龙果开源 - 超级管理员 <small>2016-09 加入</small>
								</p>
							</li>
							<!-- Menu Body -->
							<li class="user-body">
								<div class="row">
									<div class="col-xs-4 text-center">
										<a href="#">下属</a>
									</div>
									<div class="col-xs-4 text-center">
										<a href="#">销售额</a>
									</div>
									<div class="col-xs-4 text-center">
										<a href="#">朋友</a>
									</div>
								</div>
								<!-- /.row -->
							</li>
							<!-- Menu Footer-->
							<li class="user-footer">
								<div class="pull-left">
									<a href="#" class="btn btn-default btn-flat">简介</a>
								</div>
								<div class="pull-right">
									<a href="#" class="btn btn-default btn-flat">退出</a>
								</div>
							</li>
						</ul>
					</li>
					<!-- Control Sidebar Toggle Button -->
					<li>
						<a href="#" data-toggle="control-sidebar">
							<i class="fa fa-gears"></i>
						</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
</#macro>

<#macro footer>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 2.3.6
			</div>
			<strong>Copyright &copy; 2016 <a href="http://www.roncoo.com">龙果学院</a>.</strong> All rights reserved.
		</footer>
		
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
		
	</div>
</body>
</html>
</#macro>
