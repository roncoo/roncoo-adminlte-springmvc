<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="email"/>

<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<form action="${ctx}/admin/email/insert" method="post">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">邮件详情</h3>
					</div>
					<div class="box-body">
		                <div class="form-group">
		                  <label for="inputEmail3" class="col-sm-2 control-label">发件人:</label>
		                  <div class="col-sm-10">
		                    <p>${info.fromUser}</p>
		                  </div>
		                </div>
		                <div class="form-group">
		                  <label for="inputPassword3" class="col-sm-2 control-label">收件人:</label>
		
		                  <div class="col-sm-10">
		                    <p>${info.toUser}</p>
		                  </div>
		                </div>
		                <div class="form-group">
		                  <label for="inputPassword3" class="col-sm-2 control-label">主题:</label>
		
		                  <div class="col-sm-10">
		                    <p>${info.subject}</p>
		                  </div>
		                </div>
		                 <div class="form-group">
		                  <label for="inputPassword3" class="col-sm-2 control-label">标题:</label>
		
		                  <div class="col-sm-10">
		                    <p>${info.title}</p>
		                  </div>
		                </div>
		                 <div class="form-group" style="margin-left:12px; ">
		                  <label class="control-label">正文:</label>
							<br/><br/>
		                    <p >${info.content}</p>
		                </div>
		              </div>
				</div>
			</form>
		</div>
	</div>
</div>
<@wrapper/>
<!-- 这里添加额外的css和js -->
<@footer/>
