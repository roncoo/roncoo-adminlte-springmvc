<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="dictionary"/>

<div class="content-wrapper">
	<section class="content">
	<div class="row">
		<div class="col-md-12">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">数字字典明细详情</h3>
						<div class="pull-right">
							<button class="btn btn-sm btn-info" onClick="history.back();">返回</button>
						</div>
					</div>
					<div class="box-body  no-padding">
						<table class="table table-striped">
			                <tr>
			                  <td>上级关联：</td>
			                  <td style="width: 90%">${dictionaryList.fieldCode!}</td>
			                </tr>
			                <tr>
			                  <td>名称：</td>
			                  <td>${dictionaryList.fieldKey}</td>
			                </tr>
			                <tr>
			                  <td>默认值:</td>
			                  <td>${dictionaryList.fieldValue}</td>
			                </tr>
			                <tr>
			                  <td>排序:</td>
			                  <td>${dictionaryList.sort}</td>
			                </tr>
			                <tr>
			                  <td>创建时间：</td>
			                  <td>${dictionaryList.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
			                </tr>
			                <tr>
			                  <td>更新时间：</td>
			                  <td>${dictionaryList.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
			                </tr>
			                <tr>
			                  <td style="min-height:300px">备注:</td>
			                  <td>${dictionaryList.remark}</td>
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
