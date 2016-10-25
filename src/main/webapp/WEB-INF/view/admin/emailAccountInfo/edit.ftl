<#include "/macro/base.ftl" /> 
<@header/> 

<@menu activeId="email"/>

<div class="content-wrapper">
	<section class="content">
	<div class="row">
		<div class="col-md-12">
				<div class="box box-primary">
					<form action="${ctx}/admin/emailAccountInfo/update" method="post">
						<input type="hidden" id="id" name="id" value=${info.id}>
						<div class="box-header with-border">
							<h3 class="box-title">账号修改</h3>
						</div>
						<div class="box-body">
							<div class="form-group">
								<label>Host</label> 
								<select name="host" class="form-control select2" style="width: 100%;">
									<#list selectList as select>
										<option <#if info.host == select.fieldValue>selected="selected"</#if> value="${select.fieldValue}">${select.fieldKey}</option>
									</#list>
								</select>
							</div>
							<div class="form-group">
								<label>邮箱账号</label> <input type="text" class="form-control" name="fromUser" id="fromUser" value=${info.fromUser!} placeholder="输入邮箱...">
							</div>
							<div class="form-group">
								<label>授权码</label> <input type="text" class="form-control" name="passwd" id="passwd" value=${info.passwd} placeholder="授权码...">
							</div>
							<div class="form-group">
								<label>备注</label> <input type="text" class="form-control" name="remark" id="remark" value="${info.remark}" placeholder="输入备注...">
							</div>
			             </div>
						<div class="box-footer">
		               		<button type="submit" class="btn btn-primary   pull-right">更新</button>
							<button type="reset" class="btn btn-danger   pull-right">清空</button>
		              	</div>
					</form>
				</div>
		</div>
	</div>
	<section class="content">
</div>
<@wrapper/>
<!-- 这里添加额外的css和js -->
<@footer/>
