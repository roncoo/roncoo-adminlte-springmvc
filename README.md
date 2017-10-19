# 龙果开源-后台管理系统

### 项目介绍
1. 框架完全是基于Spring IO platform，绝对拥抱Spring，版本的依赖关系再不用担心。
2. 前端基于 **[龙果开源-后台管理UI Roncoo AdminLTE](https://github.com/roncoo/roncoo-adminLTE/)**，高端大气上档次。
3. 代码自动生成工具使用了 **[龙果开源-Mybatis代码自动生成工具](https://github.com/roncoo/roncoo-mybatis-generator)**
4. 实现了邮件发送功能，邮件增删改查功能
5. 集成Spring Session和Shiro

### 分支说明
* master 是基于tags来实现
* synchronous 是基于页面跳转来实现


### 项目愿景
根据实际项目的需求，实现一个适合由单应用扩展到多应用的架构。在项目的最初设定就是一个适合多模块扩展的架构，最初是单应用架构，以包区分模块。当项目需求增大的时候，会先实现多机部署，接下来进行项目拆分，进行集群部署。每个阶段都会整合一个架构，提供对应的解决方案。


### 后台截图
![roncoo-adminlte-springmvc](http://www.roncoo.com/images/adminlte.png)

#### 在线预览：**[http://demo.adminlte.roncoo.com/roncoo-adminlte-springmvc](http://demo.adminlte.roncoo.com/roncoo-adminlte-springmvc/)**

### 目录简介
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

### 技术框架
* 核心框架：Spring Framework
* 视图框架：Spring MVC
* 模板引擎：Freemark
* 持久层框架：Mybatis
* 数据库连接池：Alibaba Druid

### 更新日志

2016-12-22
1. 集成spring session和shiro权限管理
2. 修改删除回调刷新方法
3. 调整项目代码

2016-11-18
1. 添加数据字典功能
2. 添加邮件账号管理功能，并把邮件发送改为随机账号发送

2016-10-22
1. 添加邮件发送功能

### 帮助文档
1. 教程视频 [免费视频看这里-【龙果学院】](http://www.roncoo.com/course/view/d33d4b6f515e4ea9abec6454ef13c774)

### 下步计划
1. 继续优化，持续更新，增加各种demo实例
2. 创建maven原型，实现快捷搭建项目架构
3. 进行项目的拆分，实现多模块开发

### 技术交流
1群: 546588570 (满)
2群: 469508330


