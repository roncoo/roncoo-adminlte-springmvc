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
			<section class="content" id="content">
				<div class="tabs-panel">
					<h1>权限管理</h1>
				</div>
			</section>
		</div>
		<@footer/>
		<@setting/>
	</div>
	<@jsFile/>
</body>
</html>