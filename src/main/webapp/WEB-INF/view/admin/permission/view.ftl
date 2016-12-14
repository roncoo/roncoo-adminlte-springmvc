<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="security"/>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">用户详情</h3>
					<div class="pull-right">
						<button class="btn btn-sm btn-info" onClick="history.back();">
							<i class="fa fa-reply"></i>返回
						</button>
					</div>
				</div>
				<div class="box-body  no-padding">
					<table class="table table-striped">
		                <tr>
		                	<td>角色：</td>
		                	<td style="width: 90%">${bean.permissionsName!}</td>
		                </tr>
		                <tr>
		                	<td>角色值：</td>
		                	<td>${bean.permissionsValue!}</td>
		                </tr>
		                <tr>
			                <td>用户状态：</td>
			                <td>
			                  	<#if bean.statusId == '0'>不可用</#if>
			                  	<#if bean.statusId == '1'>可用</#if>
			                </td>
		                </tr>
		                <tr>
		                	<td>创建时间：</td>
		                	<td>${bean.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
		                </tr>
		                <tr>
		                	<td>更新时间：</td>
		                	<td>${bean.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
		                </tr>
		              </table>
	             </div>
			</div>
		</div>
	</div>
</div>
<@wrapper/>
<!-- 这里添加额外的css和js -->
<@footer/>