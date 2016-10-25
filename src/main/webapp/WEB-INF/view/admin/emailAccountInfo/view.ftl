<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="email"/>

<div class="content-wrapper">
	<section class="content">
	<div class="row">
		<div class="col-md-12">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">账号详情</h3>
					</div>
					<div class="box-body  no-padding">
						<table class="table table-striped">
			                <tr>
			                  <td>账号：</td>
			                  <td style="width: 90%">${info.fromUser!}</td>
			                </tr>
			                <tr>
			                  <td>授权码：</td>
			                  <td>${info.passwd}</td>
			                </tr>
			                <tr>
			                  <td>服务器:</td>
			                  <td>${info.host}</td>
			                </tr>
			                <tr>
			                  <td>创建时间：</td>
			                  <td>${info.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
			                </tr>
			                <tr>
			                  <td>更新时间：</td>
			                  <td>${info.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
			                </tr>
			                <tr>
			                  <td style="min-height:300px">备注:</td>
			                  <td>${info.remark}</td>
			              </table>
		             </div>
				</div>
		</div>
	</div>
	<section class="content">
</div>
<@wrapper/>
<!-- 这里添加额外的css和js -->
<@footer/>
