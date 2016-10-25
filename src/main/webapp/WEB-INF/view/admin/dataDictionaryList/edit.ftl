<#include "/macro/base.ftl" /> 
<@header/> 

<@menu activeId="dictionary"/>

<div class="content-wrapper">
	<section class="content">
	<div class="row">
		<div class="col-md-12">
				<div class="box box-primary">
					<form action="${ctx}/admin/dataDictionaryList/update" method="post">
						<input type="hidden" id="dId" name="dId" value=${id}>
						<input type="hidden" id="id" name="id" value=${dictionaryList.id!}>
						<input type="hidden" id="fieldCode" name="fieldCode" value=${dictionaryList.fieldCode!}>
						<div class="box-header with-border">
							<h3 class="box-title">数据字典明细修改</h3>
						</div>
						<div class="box-body">
							<div class="form-group">
								<label>名称:</label> <input type="text" class="form-control" name="fieldKey" id="fieldKey" value=${dictionaryList.fieldKey!} placeholder="输入显示名称...">
							</div>
							<div class="form-group">
								<label>默认值:</label> <input type="text" class="form-control" name="fieldValue" id="fieldValue" value=${dictionaryList.fieldValue!} placeholder="输入默认值...">
							</div>
							<div class="form-group">
								<label>排序:</label> <input type="text" class="form-control" name="sort" id="sort" value=${dictionaryList.sort} placeholder="排序值...">
							</div>
							<div class="form-group">
								<label>备注:</label> <input type="text" class="form-control" name="remark" id="remark" value="${dictionaryList.remark}" placeholder="输入备注...">
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
