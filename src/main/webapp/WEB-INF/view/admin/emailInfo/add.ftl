<#include "/macro/base.ftl" />
<@header/> 
<@menu activeId="email"/>
<@validation/>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12">
			<form action="${ctx}/admin/emailInfo/send" method="post">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">编写邮件</h3>
					</div>
					<div class="box-body">
						<div class="form-group">
							<#if infoVo??>  
							    <@spring.bind "infoVo.toUser" />  
							    <@spring.showErrors "" "color:red"/>  
							</#if> 
							<input class="form-control" name="toUser" placeholder="发送至:" value="<#if infoVo??>${infoVo.toUser!}</#if>">
						</div>
						<div class="form-group">
							<#if infoVo??>  
							    <@spring.bind "infoVo.subject" />  
							    <@spring.showErrors "" "color:red"/>  
							</#if>
							<input class="form-control" name="subject" placeholder="主题:" value="<#if infoVo??>${infoVo.subject!}</#if>">
						</div>
						<div class="form-group">
							<#if infoVo??>  
							    <@spring.bind "infoVo.title" />  
							    <@spring.showErrors "" "color:red"/>  
							</#if>
							<input class="form-control" name="title" placeholder="标题:" value="<#if infoVo??>${infoVo.title!}</#if>">
						</div>
						<div class="form-group">
							<#if infoVo??>  
							    <@spring.bind "infoVo.content" />  
							    <@spring.showErrors "" "color:red"/>  
							</#if>
							<textarea name="content" rows="10" cols="10" class="ckeditor" >
								<#if infoVo??>${infoVo.content!}</#if>
                    		</textarea>
						</div>
						<div class="form-group"></div>
					</div>
					<div class="box-footer">
						<div class="pull-right">
							<button type="reset" class="btn btn-default">
								<i class="fa fa-rotate-left"></i> 重置
							</button>
							<button type="submit" class="btn btn-primary">
								<i class="fa fa-envelope-o"></i> 发送
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<@wrapper/>
<@footer/>