龙果开源-后台管理系统


###项目介绍
1. 框架完全是基于Spring IO platform，绝对拥抱Spring，版本的依赖关系再不用担心。
2. 前端基于 **[龙果开源-后台管理UI Roncoo AdminLTE](https://github.com/roncoo/roncoo-adminLTE/)**，高端大气上档次。
3. 实现了邮件发送功能，邮件增删改查功能
4. 代码自动生成工具使用了[龙果开源-Mybatis代码自动生成工具](https://github.com/roncoo/roncoo-mybatis-generator)

###项目愿景
根据实际项目的需求，实现一个适合由单应用扩展到多应用的架构。在项目的最初设定就是一个适合多模块扩展的架构，最初是单应用架构，以包区分模块。当项目需求增大的时候，会先实现多机部署，接下来进行项目拆分，进行集群部署。每个阶段都会整合一个架构，提供对应的解决方案。


###后台截图
![roncoo-adminlte-springmvc](http://www.roncoo.com/images/adminlte.png)

####在线预览：[http://demo.adminlte.roncoo.com/roncoo-adminlte-springmvc](http://demo.adminlte.roncoo.com/roncoo-adminlte-springmvc/)

###目录简介
```
roncoo-adminlte-springmvc/ 龙果开源-后台管理系统
├── src/ 源码
│   ├── main/
│   │   ├── java/
│   │   ├── resources/
│   │   └── webapp/
│   └── test/
│
├── support/ 
│   ├── archetype/ 模板原型（待续）
│   ├── Sql脚本/ 初始化脚本
│   └── document/ 数据结构
│
└── pom.xml maven配置文件

```


###技术框架
* 核心框架：Spring Framework
* 视图框架：Spring MVC
* 模板引擎：Freemark
* 持久层框架：Mybatis
* 数据库连接池：Alibaba Druid

###更新日志
####2016-10-22
1. 添加邮件发送功能
####2016-11-18
1. 添加数据字典功能
2. 添加邮件账号管理功能，并把邮件发送改为随机账号发送
####2016-12-22
1. 集成spring session和shiro权限管理
2. 修改删除回调刷新方法
3. 调整项目代码


###本地运行
```
1.创建数据库，导入数据
2.把
<input type="hidden" name="username" value="admin"/>
<input type="hidden" name="password" value="admin"/>删除，然后
把username1和password1中的“1”去掉；
<form action="${ctx}/login" class="login__form" method="post">
	   <!--默认账号密码user、admin、super-->
	   <input type="hidden" name="username" value="admin"/>
	   <input type="hidden" name="password" value="admin"/>
	   <div class="login__row">
	   <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
	       <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
	   </svg>
	   <!--账号-->
	  <input type="text" name="username1" class="login__input name" placeholder="Username"/>
	  </div>
	  <div class="login__row">
	   <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
	       <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
	   </svg>
	   <!--密码-->
	<input type="password1" name="password1" class="login__input pass" placeholder="Password"/>
	</div>
	   <button type="submit" class="login__submit">登 录</button>
	  <p class="login__signup">还没有账号? &nbsp;<a href="#" target="_blank">立刻注册</a></p>
</form>
```


###帮助文档
1. 教程视频 [免费视频看这里](http://www.roncoo.com/course/view/d33d4b6f515e4ea9abec6454ef13c774)


###下步计划
1. 继续优化，持续更新，增加各种demo实例
2. 集成权限模块，shiro或者spring security，待定
3. 集成Spring Session，解决单节点问题
4. 创建maven原型，实现快捷搭建项目架构


###技术交流
技术交流群：546588570
