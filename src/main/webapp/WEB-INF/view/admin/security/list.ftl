<#include "/macro/base.ftl" /> 
<@header/> 

<@menu activeId="security"/>

<div class="content-wrapper">
	<section class="content">
		<div class="box box-info">
			<div class="box-header">
				<h3 class="box-title">权限演示</h3>
			</div>
			<div class="box-body">
				<div class="row">
					<form action="${ctx}/admin/security/update">
						<div class="col-xs-1">
						</div>
						<div class="col-xs-4">
							<select name=role class="form-control select2" style="width: 100%;">
								<option value="admin" selected="selected">admin</option>
								<option value="user">user</option>
							</select>
						</div>
						<div class="col-xs-2">
							<button type="submit" class="btn btn-block btn-primary">访问</button>
						</div>
					<form>
					<div class="col-xs-2">
						<a class="btn btn-primary" href="${ctx}/admin/security/view">访问</a>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

<@wrapper/>
<@footer/>
