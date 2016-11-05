<!DOCTYPE html>
<html>
<head>
<#include "/macro/base.ftl" /> 
<base href="${ctx}/static/roncoo-adminlte/">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>龙果开源-后台管理系统</title>
<@style/>
</head>

<body class="sidebar-mini ajax-template skin-blue fixed">
	<div class="wrapper">
		<@header/>
		<@menu/>
		<div class="content-wrapper">
			<section class="content-header-navtabs">
				<div class="tabs-page">
					<ul class="tabs-list clearfix" id="navTabs">
						<li class="active">
							<span>我的主页</span>
						</li>
					</ul>
					<a href="javascript:void(0);" class="prev fa fa-step-backward"></a>
					<a href="javascript:void(0);" class="next fa fa-step-forward"></a>
				</div>
			</section>
			<section class="content" id="content">
				<div class="tabs-panel">
					<h1>欢迎使用roncoo-开源管理后台</h1>
				</div>
			</section>
		</div>
		<@footer/>
		<@setting/>
	</div>
	<@jsFile/>
</body>
</html>

