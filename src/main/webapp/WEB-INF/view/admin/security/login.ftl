<#include "/macro/base.ftl" /> 
<@header/> 
<@menu activeId="security"/>
<div class="content-wrapper">
	<section class="content">
		<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">权限演示</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal" action="${ctx}/admin/security/login" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">账号</label>

                  <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" placeholder="账号">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">密码</label>

                  <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="密码">
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                      <label>
                        <input type="checkbox"> 记住我
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="reset" class="btn btn-default">取消</button>
                <button type="submit" class="btn btn-info pull-right">登录</button>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
	</section>
</div>

<@wrapper/>
<!-- 这里添加额外的css和js -->
<@footer/>
