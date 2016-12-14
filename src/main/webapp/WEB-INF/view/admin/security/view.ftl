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
						<button class="btn btn-sm btn-info" onClick="history.back();"><i class="fa fa-reply"></i>返回</button>
					</div>
				</div>
				<div class="box-body  no-padding">
					<table class="table table-striped">
		                <tr>
		                  <td>账号：</td>
		                  <td style="width: 90%">${bean.userNo!}</td>
		                </tr>
		                <tr>
		                  <td>昵称：</td>
		                  <td>${bean.nickName!}</td>
		                </tr>
		                <tr>
		                  <td>性别:</td>
		                  <td>
		                  	<#if bean.sex == 0>女</#if>
		                  	<#if bean.sex == 1>男</#if>
		                  </td>
		                </tr>
		                <tr>
		                  <td>拥有角色：</td>
		                  <td>${bean.roleName}</td>
		                </tr>
		                <tr>
		                  <td>拥有权限：</td>
		                  <td>${bean.permissionName}</td>
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